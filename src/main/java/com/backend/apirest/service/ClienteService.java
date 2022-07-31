package com.backend.apirest.service;

import com.backend.apirest.entity.Cliente;
import com.backend.apirest.repo.ClienteRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ClienteService {
    @Autowired
    ClienteRepo clienteRepo;

    public List<Cliente> list(){
        return (List) clienteRepo.findAll();
    }

    public Optional<Cliente> getOne(int id) {
        return clienteRepo.findById(id);
    }

    public void save(Cliente cliente) {
        clienteRepo.save(cliente);
    }

    public boolean existsByEmail(String email) {
        return clienteRepo.existsByCorreoE(email);
    }

    public boolean exitsByUser(String userName) {
        return clienteRepo.existsByNombreUsuario(userName);
    }

    public boolean existsByid(int id) {
        return clienteRepo.existsById(id);
    }
}
