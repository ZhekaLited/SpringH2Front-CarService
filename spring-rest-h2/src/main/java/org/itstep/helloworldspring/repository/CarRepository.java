package org.itstep.helloworldspring.repository;

import org.itstep.helloworldspring.Model.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarRepository extends CrudRepository <Car, Long> {

}
