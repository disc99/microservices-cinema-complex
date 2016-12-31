package io.disc99.cinemacomplex.maintenance;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="CINEMA_PALACES")
@Data
@NoArgsConstructor
public class CinemaPalace {

    @Id
    @GeneratedValue
    Long id;
    String name;
    String address;

    CinemaPalace(String name, String address) {
        this.name = name;
        this.address = address;
    }
}
