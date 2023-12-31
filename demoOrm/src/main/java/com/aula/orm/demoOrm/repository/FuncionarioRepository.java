package com.aula.orm.demoOrm.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.aula.orm.demoOrm.model.Funcionario;

@Repository
public interface FuncionarioRepository extends JpaRepository <Funcionario, Long> {

}