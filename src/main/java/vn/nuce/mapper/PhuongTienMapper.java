//package vn.nuce.mapper;
//
//import vn.nuce.dto.PhuongTienDto;
//import vn.nuce.entity.PhuongTienEntity;
//
//public class PhuongTienMapper {
//
//    public static PhuongTienDto toPhuongTienDto(PhuongTienEntity phuongTienEntity) {
//        PhuongTienDto phuongTienDto = new PhuongTienDto();
//
//        phuongTienDto.setMaPhuongTien(phuongTienEntity.getMaPhuongTien());
//        phuongTienDto.setTenPhuongTien(phuongTienEntity.getTenPhuongTien());
//        phuongTienDto.setLoaiPhuongTien(phuongTienEntity.getLoaiPhuongTien());
//        phuongTienDto.setSoChoNgoi(phuongTienEntity.getSoChoNgoi());
//        phuongTienDto.setKhoangGiaDau(phuongTienEntity.getKhoangGiaDau());
//        phuongTienDto.setKhoangGiaCuoi(phuongTienEntity.getKhoangGiaCuoi());
//        phuongTienDto.setLienLacSDT(phuongTienEntity.getLienLacSDT());
//        phuongTienDto.setThoiGianDiChuyen(phuongTienEntity.getThoiGianDiChuyen());
//        phuongTienDto.setTrangThai(phuongTienEntity.getTrangThai());
//
//        return phuongTienDto;
//    }
//
//    public static PhuongTienEntity toPhuongTienEntity(PhuongTienDto phuongTienDto) {
//        PhuongTienEntity phuongTienEntity = new PhuongTienEntity();
//
//        phuongTienEntity.setMaPhuongTien(phuongTienDto.getMaPhuongTien());
//        phuongTienEntity.setTenPhuongTien(phuongTienDto.getTenPhuongTien());
//        phuongTienEntity.setLoaiPhuongTien(phuongTienDto.getLoaiPhuongTien());
//        phuongTienEntity.setSoChoNgoi(phuongTienDto.getSoChoNgoi());
//        phuongTienEntity.setKhoangGiaDau(phuongTienDto.getKhoangGiaDau());
//        phuongTienEntity.setKhoangGiaCuoi(phuongTienDto.getKhoangGiaCuoi());
//        phuongTienEntity.setLienLacSDT(phuongTienDto.getLienLacSDT());
//        phuongTienEntity.setThoiGianDiChuyen(phuongTienDto.getThoiGianDiChuyen());
//        phuongTienEntity.setTrangThai(phuongTienDto.getTrangThai());
//
//        return phuongTienEntity;
//    }
//
//}
