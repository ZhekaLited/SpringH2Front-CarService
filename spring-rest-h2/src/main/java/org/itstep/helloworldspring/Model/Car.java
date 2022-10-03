package org.itstep.helloworldspring.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@Entity
@ToString
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Car {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    @Column(name = "car_Name", nullable = false)
    private String carName;
    @Column(name = "car_Color", nullable = false)
    private String carColor;
    @Column(name = "car_Model", nullable = false)
    private String carModel;

        @Override
        public String toString() {
            return "Car{" + "id=" + id + ", carName=" + carName + ", carColor=" + carColor + "carModel" + carModel + '}';
        }
    }






