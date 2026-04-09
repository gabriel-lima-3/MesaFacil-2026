package com.gabriellima.MesaFacil2026.Controller;
import com.gabriellima.MesaFacil2026.Model.ClienteModel;
import com.gabriellima.MesaFacil2026.Repository.ClienteRepository;
import com.gabriellima.MesaFacil2026.Service.ClienteService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.lang.ref.Cleaner;
import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/cliente")
public class ClienteController {

    private ClienteService clienteService;

    //Listar todos
    @GetMapping("/listar")
    public ResponseEntity <List<ClienteModel>> listaxrTodos(){

        List<ClienteModel> lista = clienteService.listarTodos();
        return ResponseEntity.ok(lista);

    }

    //Listar por id
    @GetMapping("/listar/{id}")
    public ResponseEntity<ClienteModel> listarPorId(@PathVariable Long id){

        Optional<ClienteModel> clienteId = clienteService.findById(id);

        if(clienteId.isPresent()){

            return ResponseEntity.ok(clienteId.get());

        }else{
            return ResponseEntity.notFound().build();
        }

    }

    //Criar novo Cliente
    @PostMapping("/criar")
    public ResponseEntity<ClienteModel> criarUsuario(@RequestBody ClienteModel clienteModel){
        ClienteModel clienteSave = clienteService.criarCliene(clienteModel);

        return new ResponseEntity<>(clienteSave, HttpStatus.CREATED);

    }

    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<ClienteModel> deletar(@PathVariable Long id){

      return clienteService.deletarPorId(id);

    }





}
