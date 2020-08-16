package com.spring.funcionario.service;

import java.util.List;

import com.spring.funcionario.model.Funcionario;

public interface FuncionarioService {
	
	List<Funcionario> findAll();
	Funcionario findById(long id);
	Funcionario save(Funcionario funcionario);
	void deleteById(long id);
	
	List<Funcionario> findByCidadeAndSalarioGreaterThan(String cidade, Float salario);

}
