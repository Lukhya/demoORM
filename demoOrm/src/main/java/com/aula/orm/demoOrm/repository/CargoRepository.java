package com.aula.orm.demoOrm.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.aula.orm.demoOrm.model.Cargo;



@Repository
public interface CargoRepository extends JpaRepository <Cargo, Long>{

}
