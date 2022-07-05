package com.crud.mycrud.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.crud.mycrud.models.Usuario;
import com.crud.mycrud.repositories.UsuarioRepository;

@RestController
public class MyCrudController {
	
	@Autowired
	private UsuarioRepository rep;
	
	@GetMapping("/")
	public String getPrincipal() {
		return "Hello World!";
	}
	
	@GetMapping("/usuarios")
	public List<Usuario> getUsers() {
		return rep.findAll();
	}
	
	@GetMapping("/usuarios/{id}")
	public Usuario getUser(@PathVariable long id) {
		return rep.findById(id);
	}
	
	@PostMapping("/usuarios")
	public Usuario postUser(@RequestBody Usuario u) {
		return rep.save(u);
	}
	
	@DeleteMapping("/usuarios/{id}")
	public String deleteUser(@PathVariable long id) {
		rep.deleteById(id);
		return "Usuário Deletado";
	}
	
	@PutMapping("/usuarios/{id}")
	public Usuario updateUser(@PathVariable long id, @RequestBody Usuario u) {
		Usuario user = rep.findById(id);
		if(user == null) {
			return rep.save(u);
		}
		user.setIdade(u.getIdade());
		user.setName(u.getName());		
		return user;
	}
}
