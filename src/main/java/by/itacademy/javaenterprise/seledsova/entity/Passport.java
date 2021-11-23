package by.itacademy.javaenterprise.seledsova.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Passports")
public class Passport implements Serializable {

    @Id
    @SequenceGenerator(name = "Passport_passport_id_seq", sequenceName = "Passport_passport_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "Passport_passport_id_seq")
    @Column(name = "passport_id")
    private Long passportId;

    private Integer number;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id")
    private Person person;

    public Passport(Long passportId, Integer number) {
        this.passportId = passportId;
        this.number = number;
    }
}


