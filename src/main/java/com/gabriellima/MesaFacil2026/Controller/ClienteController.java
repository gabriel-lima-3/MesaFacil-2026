package com.gabriellima.MesaFacil2026.Controller;
import com.gabriellima.MesaFacil2026.Model.ClienteModel;

import com.gabriellima.MesaFacil2026.Service.ClienteService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/cliente")
public class ClienteController {

    @Autowired
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

    //Deletar cliente pelo Id
    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id){

       clienteService.deletarPorId(id);
       return ResponseEntity.noContent().build();

    }

    //Atulizar dados do CLiente

    @PutMapping("/atualizar/{id}")
    public ResponseEntity<ClienteModel> AtualizarCliente(@RequestBody ClienteModel clienteModel,  @PathVariable Long id ){

        ClienteModel clienteAtualizado = clienteService.atualizarCliente(clienteModel, id );

        return ResponseEntity.ok(clienteAtualizado);

    }









}
