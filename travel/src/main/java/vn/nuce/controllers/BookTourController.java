package vn.nuce.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import vn.nuce.dto.BookTourDto;
import vn.nuce.dto.TourDto;
import vn.nuce.dto.UserDto;
import vn.nuce.service.BookTourService;
import vn.nuce.service.TourService;
import vn.nuce.service.UserService;
import vn.nuce.service.impl.BookTourServiceImpl;
import vn.nuce.service.impl.TourServiceImpl;
import vn.nuce.service.impl.UserServiceImpl;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.io.File;
import java.io.FileInputStream;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.List;
import java.util.Properties;

@RequestMapping("/home")
@Controller
public class BookTourController {

    @Autowired
    TourService tourService;

    @Autowired
    BookTourService bookTourService;

    @Autowired
    UserService userService;

    static int a,A,p,d;

    @GetMapping("/book/{id}")
    public String showPageBookTour(@PathVariable Long id, HttpSession httpSession, ModelMap modelMap) {
        setUser(httpSession, modelMap);
        List<TourDto> tourDtos = tourService.findAllTours();
        TourDto tourDto = tourService.findOneTour(id);

        Calendar c1 = Calendar.getInstance();
        Calendar c2 = Calendar.getInstance();

        c1.setTime(tourDto.getTour_Departureday());
        c2.setTime(tourDto.getTour_Enddate());

        long day = (c2.getTime().getTime() - c1.getTime().getTime()) / (24 * 3600 * 1000);
        tourDto.setTour_Day(day);
        if (!modelMap.containsAttribute("bookTourDto")) {
            modelMap.addAttribute("bookTourDto", new BookTourDto());
        }
        modelMap.addAttribute("tour", tourDto);
        BookTourDto bookTourDto = new BookTourDto();
        UserDto userDto = (UserDto) httpSession.getAttribute("user");
        if (userDto != null) {
            bookTourDto.setName(userDto.getUser_Fullname());
            bookTourDto.setPhone(userDto.getUser_Phone());
            bookTourDto.setEmail(userDto.getUser_Email());
        }
        modelMap.addAttribute("bookTourDto", bookTourDto);
        return "book";
    }

    @PostMapping("/book/{id}")
    public String bookTour(@PathVariable("id") Long id, @ModelAttribute("bookTourDto") @Valid BookTourDto bookTourDto, BindingResult bindingResult,
                           @RequestParam(name = "numAdult") String numAdult,
                           @RequestParam(name = "numChild") String numChild,
                           @RequestParam(name = "price") String price,
                           HttpSession httpSession, ModelMap modelMap) throws AddressException, MessagingException {
        TourDto tourDto = tourService.findOneTour(id);
        if (bindingResult.hasErrors()) {
            setUser(httpSession, modelMap);
            List<TourDto> tourDtos = tourService.findAllTours();

            if (!modelMap.containsAttribute("bookTourDto")) {
                modelMap.addAttribute("bookTourDto", new BookTourDto());
            }
            modelMap.addAttribute("tour", tourDto);
            return "book";
        } else {
            setUser(httpSession, modelMap);
            bookTourDto.setTourId(id);
            bookTourDto.setStatus(0);
            bookTourDto.setPayStatus(0);
            LocalDate now = LocalDate.now();
            Timestamp timestamp = Timestamp.valueOf(now.atStartOfDay());
            bookTourDto.setCreateDate(timestamp);
            bookTourDto.setDateConfirm(timestamp);
            bookTourDto.setNumAdult(Integer.parseInt(numAdult));
            bookTourDto.setNumChild(Integer.parseInt(numChild));
            bookTourDto.setPrice(Double.parseDouble(price));
            bookTourDto.setTourName(tourDto.getTour_Name());
            UserDto userDto = (UserDto) httpSession.getAttribute("user");
            if (userDto != null) {
                Long userID = userDto.getUser_Id();
                bookTourDto.setUserId(userID);
            } else {
                List<UserDto> userDtos = userService.findAllUsers();
                Long uId = Long.valueOf(-1);
                for (UserDto userDto1 : userDtos) {
                    if (bookTourDto.getEmail().equals(userDto1.getUser_Email()) || bookTourDto.getPhone().equals(userDto1.getUser_Phone())) {
                        uId = userDto1.getUser_Id();
                    }
                }
                if (uId == -1) {
                    UserDto userDto1 = new UserDto();
                    userDto1.setUser_Name(bookTourDto.getPhone());
                    String s;
                    do {
                        s = new String(new java.util.Random().ints(15, 33, 127)
                                .toArray(),
                                0, 15);
                        a = A = d = p = 0;
                        s.chars()
                                .map(c ->
                                        c > 96 & c < 123 ? a = 1
                                                : c > 64 & c < 90 ? A = 1
                                                : c > 47 & c < 58 ? d = 1
                                                : (p = 1))
                                .min();
                    } while (a + A + d + p < 4);
                    userDto1.setUser_Password(s);
                    userDto1.setUser_Role((long) 0);
                    userDto1.setUser_Fullname(bookTourDto.getName());
                    userDto1.setUser_Phone(bookTourDto.getPhone());
                    userDto1.setUser_Email(bookTourDto.getEmail());
                    userDto1.setUser_Createdate(Timestamp.valueOf(now.atStartOfDay()));
                    userDto1.setUser_Lastupdate(Timestamp.valueOf(LocalDateTime.now()));
                    userDto1.setUser_Gender(null);
                    userDto1.setUser_Status((long) 1);
                    File file = new File("E:/duantotnghiep/travel/src/main/webapp/resources/home/images/avatar.png");
                    byte[] picByte = new byte[(int) file.length()];
                    try {
                        FileInputStream fileInputStream = new FileInputStream(file);
                        fileInputStream.read(picByte);
                        fileInputStream.close();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    userDto1.setImage(picByte);
                    bookTourDto.setUserId(userDto1.getUser_Id());
                    userService.saveUser(userDto1);
                }
                else {
                    bookTourDto.setUserId(uId);
                }
            }
            List<BookTourDto> bookTourDtos = userService.findBookTourWaitByUserId(bookTourDto.getUserId());
            if (bookTourDtos.isEmpty()) {
                try {
                    bookTourService.save(bookTourDto);
                    sendMail(bookTourDto, tourDto);
                } catch (Exception e) {
                    e.printStackTrace();
                }

                return "success";
            }
            else {
                return "denied";
            }
        }
    }

    private void setUser(HttpSession session, ModelMap modelMap) {
        if (session.getAttribute("user") != null) {
            UserDto dto = (UserDto) session.getAttribute("user");
            modelMap.addAttribute("dto", dto);
        }
    }

    private void sendMail(BookTourDto bookTourDto, TourDto tourDto) {
        try {
            Properties mailServerProperties;
            Session getMailSession;
            MimeMessage mailMessage;

            mailServerProperties = System.getProperties();
            mailServerProperties.put("mail.smtp.port", "587");
            mailServerProperties.put("mail.smtp.auth", "true");
            mailServerProperties.put("mail.smtp.starttls.enable", "true");

            getMailSession = Session.getDefaultInstance(mailServerProperties, null);
            mailMessage = new MimeMessage(getMailSession);

            mailMessage.addRecipient(Message.RecipientType.TO, new InternetAddress(bookTourDto.getEmail()));

            mailMessage.setSubject("Xác nhận đặt tour", "UTF-8");
            String emailBody = "<!DOCTYPE html>\n" +
                    "<html lang=\"en\" xmlns=\"http://www.w3.org/1999/xhtml\" xmlns:v=\"urn:schemas-microsoft-com:vml\"\n" +
                    "\txmlns:o=\"urn:schemas-microsoft-com:office:office\">\n" +
                    "\n" +
                    "<head>\n" +
                    "\t<meta charset=\"utf-8\"> <!-- utf-8 works for most cases -->\n" +
                    "\t<meta name=\"viewport\" content=\"width=device-width\"> <!-- Forcing initial-scale shouldn't be necessary -->\n" +
                    "\t<meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\"> <!-- Use the latest (edge) version of IE rendering engine -->\n" +
                    "\t<meta name=\"x-apple-disable-message-reformatting\"> <!-- Disable auto-scale in iOS 10 Mail entirely -->\n" +
                    "\t<title></title> <!-- The title tag shows in email notifications, like Android 4.4. -->\n" +
                    "\n" +
                    "\t<link href=\"https://fonts.googleapis.com/css?family=Work+Sans:200,300,400,500,600,700\" rel=\"stylesheet\">\n" +
                    "\n" +
                    "\t<!-- CSS Reset : BEGIN -->\n" +
                    "\t<style>\n" +
                    "\t\t/* What it does: Remove spaces around the email design added by some email clients. */\n" +
                    "\t\t/* Beware: It can remove the padding / margin and add a background color to the compose a reply window. */\n" +
                    "\t\thtml,\n" +
                    "\t\tbody {\n" +
                    "\t\t\tmargin: 0 auto !important;\n" +
                    "\t\t\tpadding: 0 !important;\n" +
                    "\t\t\theight: 100% !important;\n" +
                    "\t\t\twidth: 100% !important;\n" +
                    "\t\t\tbackground: #f1f1f1;\n" +
                    "\t\t}\n" +
                    "\n" +
                    "\t\t/* What it does: Stops email clients resizing small text. */\n" +
                    "\t\t* {\n" +
                    "\t\t\t-ms-text-size-adjust: 100%;\n" +
                    "\t\t\t-webkit-text-size-adjust: 100%;\n" +
                    "\t\t}\n" +
                    "\n" +
                    "\t\t/* What it does: Centers email on Android 4.4 */\n" +
                    "\t\tdiv[style*=\"margin: 16px 0\"] {\n" +
                    "\t\t\tmargin: 0 !important;\n" +
                    "\t\t}\n" +
                    "\n" +
                    "\t\t/* What it does: Stops Outlook from adding extra spacing to tables. */\n" +
                    "\t\ttable,\n" +
                    "\t\ttd {\n" +
                    "\t\t\tmso-table-lspace: 0pt !important;\n" +
                    "\t\t\tmso-table-rspace: 0pt !important;\n" +
                    "\t\t}\n" +
                    "\n" +
                    "\t\t/* What it does: Fixes webkit padding issue. */\n" +
                    "\t\ttable {\n" +
                    "\t\t\tborder-spacing: 0 !important;\n" +
                    "\t\t\tborder-collapse: collapse !important;\n" +
                    "\t\t\ttable-layout: fixed !important;\n" +
                    "\t\t\tmargin: 0 auto !important;\n" +
                    "\t\t}\n" +
                    "\n" +
                    "\t\t/* What it does: Uses a better rendering method when resizing images in IE. */\n" +
                    "\t\timg {\n" +
                    "\t\t\t-ms-interpolation-mode: bicubic;\n" +
                    "\t\t}\n" +
                    "\n" +
                    "\t\t/* What it does: Prevents Windows 10 Mail from underlining links despite inline CSS. Styles for underlined links should be inline. */\n" +
                    "\t\ta {\n" +
                    "\t\t\ttext-decoration: none;\n" +
                    "\t\t}\n" +
                    "\n" +
                    "\t\t/* What it does: A work-around for email clients meddling in triggered links. */\n" +
                    "\t\t*[x-apple-data-detectors],\n" +
                    "\t\t/* iOS */\n" +
                    "\t\t.unstyle-auto-detected-links *,\n" +
                    "\t\t.aBn {\n" +
                    "\t\t\tborder-bottom: 0 !important;\n" +
                    "\t\t\tcursor: default !important;\n" +
                    "\t\t\tcolor: inherit !important;\n" +
                    "\t\t\ttext-decoration: none !important;\n" +
                    "\t\t\tfont-size: inherit !important;\n" +
                    "\t\t\tfont-family: inherit !important;\n" +
                    "\t\t\tfont-weight: inherit !important;\n" +
                    "\t\t\tline-height: inherit !important;\n" +
                    "\t\t}\n" +
                    "\n" +
                    "\t\t/* What it does: Prevents Gmail from displaying a download button on large, non-linked images. */\n" +
                    "\t\t.a6S {\n" +
                    "\t\t\tdisplay: none !important;\n" +
                    "\t\t\topacity: 0.01 !important;\n" +
                    "\t\t}\n" +
                    "\n" +
                    "\t\t/* What it does: Prevents Gmail from changing the text color in conversation threads. */\n" +
                    "\t\t.im {\n" +
                    "\t\t\tcolor: inherit !important;\n" +
                    "\t\t}\n" +
                    "\n" +
                    "\t\t/* If the above doesn't work, add a .g-img class to any image in question. */\n" +
                    "\t\timg.g-img+div {\n" +
                    "\t\t\tdisplay: none !important;\n" +
                    "\t\t}\n" +
                    "\n" +
                    "\t\t/* What it does: Removes right gutter in Gmail iOS app: https://github.com/TedGoas/Cerberus/issues/89  */\n" +
                    "\t\t/* Create one of these media queries for each additional viewport size you'd like to fix */\n" +
                    "\n" +
                    "\t\t/* iPhone 4, 4S, 5, 5S, 5C, and 5SE */\n" +
                    "\t\t@media only screen and (min-device-width: 320px) and (max-device-width: 374px) {\n" +
                    "\t\t\tu~div .email-container {\n" +
                    "\t\t\t\tmin-width: 320px !important;\n" +
                    "\t\t\t}\n" +
                    "\t\t}\n" +
                    "\n" +
                    "\t\t/* iPhone 6, 6S, 7, 8, and X */\n" +
                    "\t\t@media only screen and (min-device-width: 375px) and (max-device-width: 413px) {\n" +
                    "\t\t\tu~div .email-container {\n" +
                    "\t\t\t\tmin-width: 375px !important;\n" +
                    "\t\t\t}\n" +
                    "\t\t}\n" +
                    "\n" +
                    "\t\t/* iPhone 6+, 7+, and 8+ */\n" +
                    "\t\t@media only screen and (min-device-width: 414px) {\n" +
                    "\t\t\tu~div .email-container {\n" +
                    "\t\t\t\tmin-width: 414px !important;\n" +
                    "\t\t\t}\n" +
                    "\t\t}\n" +
                    "\t</style>\n" +
                    "\n" +
                    "\t<!-- CSS Reset : END -->\n" +
                    "\n" +
                    "\t<!-- Progressive Enhancements : BEGIN -->\n" +
                    "\t<style>\n" +
                    "\t\t.primary {\n" +
                    "\t\t\tbackground: #17bebb;\n" +
                    "\t\t}\n" +
                    "\n" +
                    "\t\t.bg_white {\n" +
                    "\t\t\tbackground: #ffffff;\n" +
                    "\t\t}\n" +
                    "\n" +
                    "\t\t.bg_ora {\n" +
                    "\t\t\tbackground: #FFCC66;\n" +
                    "\t\t}\n" +
                    "\n" +
                    "\t\t.bg_light {\n" +
                    "\t\t\tbackground: #f7fafa;\n" +
                    "\t\t}\n" +
                    "\n" +
                    "\t\t.bg_black {\n" +
                    "\t\t\tbackground: #000000;\n" +
                    "\t\t}\n" +
                    "\n" +
                    "\t\t.bg_dark {\n" +
                    "\t\t\tbackground: rgba(0, 0, 0, .8);\n" +
                    "\t\t}\n" +
                    "\n" +
                    "\t\t.email-section {\n" +
                    "\t\t\tpadding: 2.5em;\n" +
                    "\t\t}\n" +
                    "\n" +
                    "\t\t/*BUTTON*/\n" +
                    "\t\t.btn {\n" +
                    "\t\t\tpadding: 10px 15px;\n" +
                    "\t\t\tdisplay: inline-block;\n" +
                    "\t\t}\n" +
                    "\n" +
                    "\t\t.btn.btn-primary {\n" +
                    "\t\t\tborder-radius: 5px;\n" +
                    "\t\t\tbackground: #fa9e1b;\n" +
                    "\t\t\tcolor: #ffffff;\n" +
                    "\t\t}\n" +
                    "\n" +
                    "\t\t.btn.btn-white {\n" +
                    "\t\t\tborder-radius: 5px;\n" +
                    "\t\t\tbackground: #ffffff;\n" +
                    "\t\t\tcolor: #000000;\n" +
                    "\t\t}\n" +
                    "\n" +
                    "\t\t.btn.btn-white-outline {\n" +
                    "\t\t\tborder-radius: 5px;\n" +
                    "\t\t\tbackground: transparent;\n" +
                    "\t\t\tborder: 1px solid #fff;\n" +
                    "\t\t\tcolor: #fff;\n" +
                    "\t\t}\n" +
                    "\n" +
                    "\t\t.btn.btn-black-outline {\n" +
                    "\t\t\tborder-radius: 0px;\n" +
                    "\t\t\tbackground: transparent;\n" +
                    "\t\t\tborder: 2px solid #000;\n" +
                    "\t\t\tcolor: #000;\n" +
                    "\t\t\tfont-weight: 700;\n" +
                    "\t\t}\n" +
                    "\n" +
                    "\t\t.btn-custom {\n" +
                    "\t\t\tcolor: rgba(0, 0, 0, .3);\n" +
                    "\t\t\ttext-decoration: underline;\n" +
                    "\t\t}\n" +
                    "\n" +
                    "\t\th1,\n" +
                    "\t\th2,\n" +
                    "\t\th3,\n" +
                    "\t\th4,\n" +
                    "\t\th5,\n" +
                    "\t\th6 {\n" +
                    "\t\t\tfont-family: 'Work Sans', sans-serif;\n" +
                    "\t\t\tcolor: #000000;\n" +
                    "\t\t\tmargin-top: 0;\n" +
                    "\t\t\tfont-weight: 400;\n" +
                    "\t\t}\n" +
                    "\n" +
                    "\t\tbody {\n" +
                    "\t\t\tfont-family: 'Work Sans', sans-serif;\n" +
                    "\t\t\tfont-weight: 400;\n" +
                    "\t\t\tfont-size: 15px;\n" +
                    "\t\t\tline-height: 1.8;\n" +
                    "\t\t\tcolor: rgba(0, 0, 0, .4);\n" +
                    "\t\t}\n" +
                    "\n" +
                    "\t\ta {\n" +
                    "\t\t\tcolor: #8d4fff;\n" +
                    "\t\t}\n" +
                    "\n" +
                    "\t\ttable {}\n" +
                    "\n" +
                    "\t\t/*LOGO*/\n" +
                    "\n" +
                    "\t\t.logo h1 {\n" +
                    "\t\t\tmargin: 0;\n" +
                    "\t\t}\n" +
                    "\n" +
                    "\t\t.logo h1 a {\n" +
                    "\t\t\tcolor: #8d4fff;\n" +
                    "\t\t\tfont-size: 24px;\n" +
                    "\t\t\tfont-weight: 700;\n" +
                    "\t\t\tfont-family: 'Work Sans', sans-serif;\n" +
                    "\t\t}\n" +
                    "\n" +
                    "\t\t/*HERO*/\n" +
                    "\t\t.hero {\n" +
                    "\t\t\tposition: relative;\n" +
                    "\t\t\tz-index: 0;\n" +
                    "\t\t}\n" +
                    "\n" +
                    "\t\t.hero .text {\n" +
                    "\t\t\tcolor: rgba(0, 0, 0, .3);\n" +
                    "\t\t}\n" +
                    "\n" +
                    "\t\t.hero .text h2 {\n" +
                    "\t\t\tcolor: #000;\n" +
                    "\t\t\tfont-size: 34px;\n" +
                    "\t\t\tmargin-bottom: 15px;\n" +
                    "\t\t\tfont-weight: 300;\n" +
                    "\t\t\tline-height: 1.2;\n" +
                    "\t\t}\n" +
                    "\n" +
                    "\t\t.hero .text h3 {\n" +
                    "\t\t\tfont-size: 24px;\n" +
                    "\t\t\tfont-weight: 200;\n" +
                    "\t\t}\n" +
                    "\n" +
                    "\t\t.hero .text h2 span {\n" +
                    "\t\t\tfont-weight: 600;\n" +
                    "\t\t\tcolor: #000;\n" +
                    "\t\t}\n" +
                    "\n" +
                    "\n" +
                    "\t\t/*PRODUCT*/\n" +
                    "\t\t.product-entry {\n" +
                    "\t\t\tdisplay: block;\n" +
                    "\t\t\tposition: relative;\n" +
                    "\t\t\tfloat: left;\n" +
                    "\t\t\tpadding-top: 20px;\n" +
                    "\t\t}\n" +
                    "\n" +
                    "\t\t.product-entry .text {\n" +
                    "\t\t\twidth: calc(100% - 125px);\n" +
                    "\t\t\tpadding-left: 20px;\n" +
                    "\t\t}\n" +
                    "\n" +
                    "\t\t.product-entry .text h3 {\n" +
                    "\t\t\tmargin-bottom: 0;\n" +
                    "\t\t\tpadding-bottom: 0;\n" +
                    "\t\t}\n" +
                    "\n" +
                    "\t\t.product-entry .text p {\n" +
                    "\t\t\tmargin-top: 0;\n" +
                    "\t\t}\n" +
                    "\n" +
                    "\t\t.product-entry img,\n" +
                    "\t\t.product-entry .text {\n" +
                    "\t\t\tfloat: left;\n" +
                    "\t\t}\n" +
                    "\n" +
                    "\t\tul.social {\n" +
                    "\t\t\tpadding: 0;\n" +
                    "\t\t}\n" +
                    "\n" +
                    "\t\tul.social li {\n" +
                    "\t\t\tdisplay: inline-block;\n" +
                    "\t\t\tmargin-right: 10px;\n" +
                    "\t\t}\n" +
                    "\n" +
                    "\t\t/*FOOTER*/\n" +
                    "\n" +
                    "\t\t.footer {\n" +
                    "\t\t\tborder-top: 1px solid rgba(0, 0, 0, .05);\n" +
                    "\t\t\tcolor: rgba(0, 0, 0, .5);\n" +
                    "\t\t}\n" +
                    "\n" +
                    "\t\t.footer .heading {\n" +
                    "\t\t\tcolor: #000;\n" +
                    "\t\t\tfont-size: 20px;\n" +
                    "\t\t}\n" +
                    "\n" +
                    "\t\t.footer ul {\n" +
                    "\t\t\tmargin: 0;\n" +
                    "\t\t\tpadding: 0;\n" +
                    "\t\t}\n" +
                    "\n" +
                    "\t\t.footer ul li {\n" +
                    "\t\t\tlist-style: none;\n" +
                    "\t\t\tmargin-bottom: 10px;\n" +
                    "\t\t}\n" +
                    "\n" +
                    "\t\t.footer ul li a {\n" +
                    "\t\t\tcolor: rgba(0, 0, 0, 1);\n" +
                    "\t\t}\n" +
                    "\n" +
                    "\n" +
                    "\t\t@media screen and (max-width: 500px) {}\n" +
                    "\t</style>\n" +
                    "\n" +
                    "\n" +
                    "</head>\n" +
                    "\n" +
                    "<body width=\"100%\" style=\"margin: 0; padding: 0 !important; mso-line-height-rule: exactly; background-color: #f1f1f1;\">\n" +
                    "\t<center style=\"width: 100%; background-color: #f1f1f1;\">\n" +
                    "\t\t<div\n" +
                    "\t\t\tstyle=\"display: none; font-size: 1px;max-height: 0px; max-width: 0px; opacity: 0; overflow: hidden; mso-hide: all; font-family: sans-serif;\">\n" +
                    "\t\t\t&zwnj;&nbsp;&zwnj;&nbsp;&zwnj;&nbsp;&zwnj;&nbsp;&zwnj;&nbsp;&zwnj;&nbsp;&zwnj;&nbsp;&zwnj;&nbsp;&zwnj;&nbsp;&zwnj;&nbsp;&zwnj;&nbsp;&zwnj;&nbsp;&zwnj;&nbsp;&zwnj;&nbsp;&zwnj;&nbsp;&zwnj;&nbsp;&zwnj;&nbsp;&zwnj;&nbsp;\n" +
                    "\t\t</div>\n" +
                    "\t\t<div style=\"max-width: 600px; margin: 0 auto;\" class=\"email-container\">\n" +
                    "\t\t\t<table align=\"center\" role=\"presentation\" cellspacing=\"0\" cellpadding=\"0\" border=\"0\" width=\"100%\"\n" +
                    "\t\t\t\tstyle=\"margin: auto;\">\n" +
                    "\t\t\t\t<tr>\n" +
                    "\t\t\t\t\t<td valign=\"top\" class=\"bg_ora\" style=\"padding: 1em 2.5em 0 2.5em;\">\n" +
                    "\t\t\t\t\t\t<table role=\"presentation\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\">\n" +
                    "\t\t\t\t\t\t\t<tr>\n" +
                    "\t\t\t\t\t\t\t\t<td class=\"logo\">\n" +
                    "\t\t\t\t\t\t\t\t\t<h1>\n" +
                    "\t\t\t\t\t\t\t\t\t\t<a href=\"#\" style=\"color: white;\">\n" +
                    "\t\t\t\t\t\t\t\t\t\t\t<img src=\"https://scontent.xx.fbcdn.net/v/t1.15752-9/cp0/51562127_2068243553258139_4328069734231703552_n.png?_nc_cat=111&ccb=2&_nc_sid=ae9488&_nc_ohc=lyHiF0yyP0UAX9rRge8&_nc_ad=z-m&_nc_cid=0&_nc_ht=scontent.xx&oh=9d52e8e2bd1e55cd279d191c5a14fd26&oe=5FBE7069\"\n" +
                    "\t\t\t\t\t\t\t\t\t\t\t\talt=\"\">TRAVELIX\n" +
                    "\t\t\t\t\t\t\t\t\t\t</a>\n" +
                    "\t\t\t\t\t\t\t\t\t</h1>\n" +
                    "\t\t\t\t\t\t\t\t</td>\n" +
                    "\t\t\t\t\t\t\t</tr>\n" +
                    "\t\t\t\t\t\t</table>\n" +
                    "\t\t\t\t\t</td>\n" +
                    "\t\t\t\t</tr>\n" +
                    "\t\t\t\t<tr>\n" +
                    "\t\t\t\t\t<td valign=\"middle\" class=\"hero bg_white\" style=\"padding: 2em 0 2em 0;\">\n" +
                    "\t\t\t\t\t\t<table role=\"presentation\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\">\n" +
                    "\t\t\t\t\t\t\t<tr>\n" +
                    "\t\t\t\t\t\t\t\t<td style=\"padding: 0 2.5em; text-align: left;\">\n" +
                    "\t\t\t\t\t\t\t\t\t<div class=\"text\">\n" +
                    "\t\t\t\t\t\t\t\t\t\t<h2>Cảm ơn quý khách đã đặt tour của công ty Travelix</h2>\n" +
                    "\t\t\t\t\t\t\t\t\t\t<h4>Chúng tôi rất vui thông báo tour #00" + bookTourDto.getRegistration_Id() + " của quý khách đã được tiếp nhận và\n" +
                    "\t\t\t\t\t\t\t\t\t\t\tđang trong quá trình xử lý. Chúng tôi sẽ liên lạc sớm nhất với quý khách.\n" +
                    "\t\t\t\t\t\t\t\t\t\t</h4>\n" +
                    "\t\t\t\t\t\t\t\t\t</div>\n" +
                    "\t\t\t\t\t\t\t\t</td>\n" +
                    "\t\t\t\t\t\t\t</tr>\n" +
                    "\t\t\t\t\t\t</table>\n" +
                    "\t\t\t\t\t</td>\n" +
                    "\t\t\t\t</tr>\n" +
                    "\t\t\t\t<tr>\n" +
                    "\t\t\t\t\t<table class=\"bg_white\" role=\"presentation\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\">\n" +
                    "\t\t\t\t\t\t<tr style=\"border-bottom: 1px solid rgba(0,0,0,.05);\">\n" +
                    "\t\t\t\t\t\t\t<th width=\"80%\"\n" +
                    "\t\t\t\t\t\t\t\tstyle=\"text-align:left; padding: 0 2.5em; color: #000; padding-bottom: 20px\">Tour</th>\n" +
                    "\t\t\t\t\t\t\t<th width=\"20%\"\n" +
                    "\t\t\t\t\t\t\t\tstyle=\"text-align:right; padding: 0 2.5em; color: #000; padding-bottom: 20px\">Giá</th>\n" +
                    "\t\t\t\t\t\t</tr>\n" +
                    "\t\t\t\t\t\t<tr style=\"border-bottom: 1px solid rgba(0,0,0,.05);\">\n" +
                    "\t\t\t\t\t\t\t<td valign=\"middle\" width=\"80%\" style=\"text-align:left; padding: 0 2.5em;\">\n" +
                    "\t\t\t\t\t\t\t\t<div class=\"product-entry\">\n" +
                    "\t\t\t\t\t\t\t\t\t<img src=\"https://vyctravel.com/libs/upload/ckfinder/images/H_A/VN/10diem3.jpg\" alt=\"\"\n" +
                    "\t\t\t\t\t\t\t\t\t\tstyle=\"width: 100px; max-width: 600px; height: auto; margin-bottom: 20px; display: block;\">\n" +
                    "\t\t\t\t\t\t\t\t\t<div class=\"text\">\n" +
                    "\t\t\t\t\t\t\t\t\t\t<h3>" + tourDto.getTour_Name() + "</h3>\n" +
                    "\t\t\t\t\t\t\t\t\t</div>\n" +
                    "\t\t\t\t\t\t\t\t</div>\n" +
                    "\t\t\t\t\t\t\t</td>\n" +
                    "\t\t\t\t\t\t\t<td valign=\"middle\" width=\"20%\" style=\"text-align:left;\">\n" +
                    "\t\t\t\t\t\t\t\t<span class=\"price\" style=\"color: #000; font-size: 18px;\">" + bookTourDto.getPrice() + "vnđ</span>\n" +
                    "\t\t\t\t\t\t\t</td>\n" +
                    "\t\t\t\t\t\t</tr>\n" +
                    "\t\t\t\t\t\t<tr>\n" +
                    "\t\t\t\t\t\t\t<td valign=\"middle\" style=\"text-align:left; padding: 1em 2.5em;\">\n" +
                    "\t\t\t\t\t\t\t\t<p><a href=\"http://localhost:8080/\" class=\"btn btn-primary\">Tiếp tục lựa chọn tour</a></p>\n" +
                    "\t\t\t\t\t\t\t</td>\n" +
                    "\t\t\t\t\t\t</tr>\n" +
                    "\t\t\t\t\t</table>\n" +
                    "\t\t\t\t</tr>\n" +
                    "\t\t\t</table>\n" +
                    "\t\t\t<table align=\"center\" role=\"presentation\" cellspacing=\"0\" cellpadding=\"0\" border=\"0\" width=\"100%\"\n" +
                    "\t\t\t\tstyle=\"margin: auto;\">\n" +
                    "\t\t\t\t<tr>\n" +
                    "\t\t\t\t\t<td valign=\"middle\" class=\"bg_light footer email-section\">\n" +
                    "\t\t\t\t\t\t<table>\n" +
                    "\t\t\t\t\t\t\t<tr>\n" +
                    "\t\t\t\t\t\t\t\t<td valign=\"top\" width=\"33.333%\" style=\"padding-top: 20px;\">\n" +
                    "\t\t\t\t\t\t\t\t\t<table role=\"presentation\" cellspacing=\"0\" cellpadding=\"0\" border=\"0\" width=\"100%\">\n" +
                    "\t\t\t\t\t\t\t\t\t\t<tr>\n" +
                    "\t\t\t\t\t\t\t\t\t\t\t<td style=\"text-align: left; padding-left: 5px; padding-right: 5px;\">\n" +
                    "\t\t\t\t\t\t\t\t\t\t\t\t<h3 class=\"heading\">Contact Info</h3>\n" +
                    "\t\t\t\t\t\t\t\t\t\t\t\t<ul>\n" +
                    "\t\t\t\t\t\t\t\t\t\t\t\t\t<li><span class=\"text\">Tòa nhà FPT Polytechnic, Phố Trịnh Văn Bô,\n" +
                    "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tNam Từ Liêm, Hà Nội</span></li>\n" +
                    "\t\t\t\t\t\t\t\t\t\t\t\t\t<li><span class=\"text\">Điện thoại: (024) 7300 1955</span></a></li>\n" +
                    "\t\t\t\t\t\t\t\t\t\t\t\t\t<li><span class=\"text\">Email: travelixpoly@gmail.com</span></a></li>\n" +
                    "\t\t\t\t\t\t\t\t\t\t\t\t</ul>\n" +
                    "\t\t\t\t\t\t\t\t\t\t\t</td>\n" +
                    "\t\t\t\t\t\t\t\t\t\t</tr>\n" +
                    "\t\t\t\t\t\t\t\t\t</table>\n" +
                    "\t\t\t\t\t\t\t\t</td>\n" +
                    "\t\t\t\t\t\t\t</tr>\n" +
                    "\t\t\t\t\t\t</table>\n" +
                    "\t\t\t\t\t</td>\n" +
                    "\t\t\t\t</tr><!-- end: tr -->\n" +
                    "\t\t\t</table>\n" +
                    "\n" +
                    "\t\t</div>\n" +
                    "\t</center>\n" +
                    "</body>\n" +
                    "\n" +
                    "</html>";
            mailMessage.setContent(emailBody, "text/html; charset=UTF-8");

            // Step3: Send mail
            Transport transport = getMailSession.getTransport("smtp");

            // Thay your_gmail thành gmail của bạn, thay your_password
            // thành mật khẩu gmail của bạn
            transport.connect("smtp.gmail.com", "travelixpoly@gmail.com", "hieu0710chv");
            transport.sendMessage(mailMessage, mailMessage.getAllRecipients());
            transport.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
