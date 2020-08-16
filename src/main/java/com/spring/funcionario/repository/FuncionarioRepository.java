package com.spring.funcionario.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.funcionario.model.Funcionario;

public interface FuncionarioRepository extends JpaRepository<Funcionario, Long>{
	
	//como só a classes filhas vão utiliza-la vamos colocar o método como abstrato
	abstract List<Funcionario> findByCidadeAndSalarioGreaterThan(String cidade, Float salario);

}
