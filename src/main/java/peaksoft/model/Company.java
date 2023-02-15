package peaksoft.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Table(name = "companies")
@Getter
@Setter
@NoArgsConstructor
public class Company {
    @Id
    @SequenceGenerator(name = "company_gen",sequenceName = "company_seq",allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "company_gen")
    private Long id;
    private String name;
    private String address;
    private String country;
    private String img;

    public Company(String name,String address, String country, String img) {
        this.address = address;
        this.country = country;
        this.img = img;
    }

    @Override
    public String toString() {
        return  "Company:" +
                "\nname = " + name +
                "\nid = " + id +
                "\naddress = " + address +
                "\ncountry = " + country +
                "\nimg = " + img  +
                ";";
    }
}
