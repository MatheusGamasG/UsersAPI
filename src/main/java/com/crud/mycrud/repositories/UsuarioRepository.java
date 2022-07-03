package com.crud.mycrud.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.crud.mycrud.models.Usuario;

@Repository
public interface UsuarioRepository extends CrudRepository<Usuario, Long>{

}
