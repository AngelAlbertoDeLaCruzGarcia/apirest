package com.backend.apirest.repo;

import com.backend.apirest.entity.Cliente;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ClienteRepo extends CrudRepository<Cliente, Integer> {

    boolean existsByCorreoE(String email);
    boolean existsByNombreUsuario(String user);
}
