package vn.nuce.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "provincial")
public class ProvincialEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long provincial_Id;
    @Column(name = "provincial_Name")
    private String provincial_Name;

    public Long getProvincial_Id() {
        return provincial_Id;
    }

    public void setProvincial_Id(Long provincial_Id) {
        this.provincial_Id = provincial_Id;
    }

    public String getProvincial_Name() {
        return provincial_Name;
    }

    public void setProvincial_Name(String provincial_Name) {
        this.provincial_Name = provincial_Name;
    }
}
