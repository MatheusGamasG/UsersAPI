package com.crud.mycrud.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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
		List<Usuario> users = new ArrayList<>();
		for(Usuario object : rep.findAll()) {
			users.add(object);
		}
		return users;
	}
	
	@PostMapping("/usuarios")
	public Usuario postUser(@RequestBody Usuario u) {
		rep.save(u);
		return u;
	}
	
	@DeleteMapping("/usuarios/{id}")
	public String deleteUser(@PathVariable long id) {
		rep.deleteById(id);
		return "Usuário Deletado";
	}
	
	@PutMapping("/usuarios/{id}")
	public Usuario updateUser(@PathVariable long id, @RequestBody Usuario u) {
		return rep.findById(id).map((user) -> {
			user.setName(u.getName());
			user.setIdade(u.getIdade());
			return rep.save(user);
		}).orElseGet(() -> {
			u.setId(id);
			return rep.save(u);
		});
	}
}
