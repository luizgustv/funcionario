package com.spring.funcionario.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.spring.funcionario.model.Funcionario;
import com.spring.funcionario.service.FuncionarioService;

@RestController
public class FuncionarioController {
	
	@Autowired
	FuncionarioService funcionarioService;
	
	@GetMapping("/")
	public ResponseEntity<List<Funcionario>> getAllFuncionarios(){
		List<Funcionario> funcionarios = funcionarioService.findAll();
		return new ResponseEntity<List<Funcionario>>(funcionarios, HttpStatus.OK);
	}
	
	
	@GetMapping("/{id}")
	public ResponseEntity<Funcionario> getFuncionario(@PathVariable(value="id") long id){
		Funcionario funcionario = funcionarioService.findById(id);
		return new ResponseEntity<Funcionario>(funcionario, HttpStatus.OK);
	}
	
	
	@PostMapping("/new")
	public Funcionario saveFuncionario(@RequestBody Funcionario funcionario) {
		return funcionarioService.save(funcionario);	
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Funcionario> updateFuncionario(@PathVariable(value="id") long id,  @RequestBody Funcionario funcionario){
		Funcionario upfuncionario = funcionarioService.findById(id);
		upfuncionario.setCargo(funcionario.getCargo());
		upfuncionario.setCidade(funcionario.getCidade());
		upfuncionario.setNome(funcionario.getNome());
		upfuncionario.setSalario(funcionario.getSalario());
		
		return ResponseEntity.ok(funcionarioService.save(upfuncionario));
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteFuncionario(@PathVariable(value = "id") long id){
		funcionarioService.deleteById(id);
		return new ResponseEntity<String>("Funcionário deletado!",HttpStatus.OK);
	}
	
	@GetMapping("/{cidade}/{salario}")
	//para realizar pesquisas mais complexas
	public ResponseEntity<List<Funcionario>> getFuncionarioByCidAndSal(@PathVariable(value = "cidade") String cidade, @PathVariable(value = "salario") Float salario){
		List<Funcionario> funcionarios = funcionarioService.findByCidadeAndSalarioGreaterThan(cidade, salario);
		return new ResponseEntity<List<Funcionario>>(funcionarios, HttpStatus.OK);
	}
	

}
