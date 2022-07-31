package com.backend.apirest.controller;

import com.backend.apirest.dto.Cliente2Dto;
import com.backend.apirest.dto.ClienteDto;
import com.backend.apirest.entity.Cliente;
import com.backend.apirest.exception.Response;
import com.backend.apirest.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.Nullable;
import org.springframework.validation.Errors;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import javax.validation.constraints.Null;
import javax.validation.constraints.Positive;
import java.util.List;

@RestController
@CrossOrigin(origins = "")
@RequestMapping("/NutriNET")
public class ClienteController {

    @Autowired
    ClienteService clienteService;

    @PostMapping("/Cliente")
    public ResponseEntity<?> create(@Valid @RequestBody ClienteDto clienteDto, Errors errores) {
        try{
            String msgError = "";
            if(errores.hasErrors()) {
                for (ObjectError error : errores.getAllErrors()) {
                    msgError += error.getDefaultMessage() + ", " ;
                }
                return new ResponseEntity(new Response(msgError, -1), HttpStatus.BAD_REQUEST);
            }
            if(clienteService.existsByEmail(clienteDto.getCorreoE())){
                return new ResponseEntity(new Response("Correo ya existe", -1), HttpStatus.BAD_REQUEST);
            }else if(clienteService.exitsByUser(clienteDto.getNombreUsuario())){
                return new ResponseEntity(new Response("Nombre de usuario ya existe", -1), HttpStatus.BAD_REQUEST);
            }
            Cliente cliente = new Cliente();
            cliente.setNombreUsuario(clienteDto.getNombreUsuario());
            cliente.setContrasena(clienteDto.getContrasena());
            cliente.setNombre(clienteDto.getNombre());
            cliente.setApellidos(clienteDto.getApellidos());
            cliente.setCorreoE(clienteDto.getCorreoE());
            cliente.setFechaCreacion(clienteDto.getFechaCreacion());
            clienteService.save(cliente);
            return new ResponseEntity(new Response("Datos guardados", 0), HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity(e, HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/Cliente/{id}")
    public ResponseEntity<?> actualizar(@Valid @RequestBody Cliente2Dto clienteDto, @PathVariable int id, Errors errores) {
        try{
            String msgError = "";
            if(errores.hasErrors()) {
                for (ObjectError error : errores.getAllErrors()) {
                    msgError += error.getDefaultMessage() + ", " ;
                }
                return new ResponseEntity(new Response(msgError, -1), HttpStatus.BAD_REQUEST);
            }
            Cliente cliente = clienteService.getOne(id).get();
            cliente.setEdad(clienteDto.getEdad());
            cliente.setEstatura(clienteDto.getEstatura());
            cliente.setPeso(clienteDto.getPeso());
            cliente.setGeb(clienteDto.getGeb());
            cliente.setFechaActualizacion(clienteDto.getFechaActualizacion());
            clienteService.save(cliente);
            return new ResponseEntity(new Response("Datos actualizados", 0), HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity(e, HttpStatus.BAD_REQUEST);
        }
    }
    @SuppressWarnings({ "unchecked", "rawtypes" })
    @GetMapping("/Cliente")
    public ResponseEntity<Cliente> getByid(@Nullable @Positive @RequestParam("id") String id) {
        try {
            if(id != null) {
                if(id.matches("^\\d+$")) {
                    if (!clienteService.existsByid(Integer.parseInt(id))) {
                        return new ResponseEntity(new Response("No existe el usuario", -1), HttpStatus.NOT_FOUND);
                    } else {
                        Cliente cliente = clienteService.getOne(Integer.parseInt(id)).get();
                        return new ResponseEntity<Cliente>(cliente, HttpStatus.OK);
                    }
                }else {
                    return new ResponseEntity(new Response("id debe ser entero", -1), HttpStatus.BAD_REQUEST);
                }

            }else {
                List<Cliente> cliente = clienteService.list();
                return new ResponseEntity(cliente, HttpStatus.OK);
            }


        }catch (Exception e){
            return new ResponseEntity(e, HttpStatus.BAD_REQUEST);
        }

    }
}
