package com.example.demo.rest.controller;


import com.example.demo.domain.entity.Cliente;
import com.example.demo.domain.repository.Clientes;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.http.HttpStatus.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

import static org.springframework.http.HttpStatus.*;

@RestController
@RequestMapping("/api/clientes")
public class ClienteController {

    //instância do repositório de clientes injetada automaticamente pelo Spring
    private Clientes clientes;

    public ClienteController(Clientes clientes) {
        this.clientes = clientes;
    }

    //método http get
    @GetMapping("{id}")
    //retorna o cliente pelo id especificado na url
    public Cliente getClienteById(@PathVariable Integer id) {
        //retorna uma instância Optional porque pode ou não existir um cliente com o id passado
        return clientes
                .findById(id)
                .orElseThrow(() -> new ResponseStatusException(NOT_FOUND, "Cliente não encontrado"));
    }

    //usado quando queremos colocar informações que não existem no servidor, necessário definir a rota
    @PostMapping
    //necessário o @ResponseBody senão o Spring não entende que esse é o corpo de resposta
    //@RequestBody é a entrada e o @ResponseBody é o que vamos retornar no Post
    @ResponseStatus(CREATED)
    //Retorna o código de status apropriado de quando criamos alguma coisa no servidor
    public Cliente save(@RequestBody Cliente cliente) {
        return clientes.save(cliente);
    }

    @DeleteMapping( "{id}")
    @ResponseStatus(NO_CONTENT)
    public void delete(@PathVariable Integer id) {
        clientes.findById(id)
                .map( cliente -> {
                    clientes.delete(cliente);
                    return cliente;
                })
                .orElseThrow(() -> new ResponseStatusException(NOT_FOUND, "Cliente não encontrado"));
    }


    @PutMapping("{id}")
    @ResponseStatus(CREATED)
    public void update(@PathVariable Integer id, @RequestBody Cliente cliente) {

        clientes
                .findById(id)
                .map( clienteExistente -> {
                    cliente.setId(clienteExistente.getId());
                    clientes.save(cliente);
                    return clienteExistente;
                }).orElseThrow(() -> new ResponseStatusException(NOT_FOUND, "Cliente não encontrado"));
    }

    //pesquisa os clientes por um parâmetro específico
    @GetMapping
    public List<Cliente> find( Cliente filtro ) {
        ExampleMatcher matcher = ExampleMatcher
                .matching()
                .withIgnoreCase()
                .withStringMatcher(ExampleMatcher.StringMatcher.CONTAINING);

        Example example = Example.of(filtro, matcher);
        return clientes.findAll(example);

    }
}
