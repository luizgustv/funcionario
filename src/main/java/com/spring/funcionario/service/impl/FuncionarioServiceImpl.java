package com.spring.funcionario.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.funcionario.model.Funcionario;
import com.spring.funcionario.repository.FuncionarioRepository;
import com.spring.funcionario.service.FuncionarioService;

@Service
public class FuncionarioServiceImpl implements FuncionarioService{
	
	@Autowired
	FuncionarioRepository funcionarioRepository;

	@Override
	public List<Funcionario> findAll() {
		return funcionarioRepository.findAll();
	}

	@Override
	public Funcionario findById(long id) {
		return funcionarioRepository.findById(id).get();
	}

	@Override
	public Funcionario save(Funcionario funcionario) {
		return funcionarioRepository.save(funcionario);
	}

	@Override
	public void deleteById(long id) {
		funcionarioRepository.deleteById(id);
	}

	@Override
	public List<Funcionario> findByCidadeAndSalarioGreaterThan(String cidade, Float salario) {
		return funcionarioRepository.findByCidadeAndSalarioGreaterThan(cidade, salario);
	}
}
