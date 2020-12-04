package vn.nuce.entity;


import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name = "district")
public class DistrictEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long district_Id;

//    @ManyToOne
//    @JoinColumn(name = "provincial_Id", nullable = false)
//    private ProvincialEntity provincial;

    @Column(name = "district_Name")
    private String district_Name;

}
