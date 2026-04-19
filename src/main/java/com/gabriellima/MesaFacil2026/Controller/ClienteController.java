package com.gabriellima.MesaFacil2026.Controller;
import com.gabriellima.MesaFacil2026.Dto.ClienteDtoReponse;
import com.gabriellima.MesaFacil2026.Dto.ClienteDtoRequest;
import com.gabriellima.MesaFacil2026.Mapper.ClienteMapper;
import com.gabriellima.MesaFacil2026.Model.ClienteModel;
import com.gabriellima.MesaFacil2026.Repository.ReservaRepository;
import com.gabriellima.MesaFacil2026.Service.ClienteService;
import org.hibernate.usertype.UserVersionType;
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
    private  ClienteService clienteService;


    //Listar todos
    @GetMapping("/listar")
    public ResponseEntity <List<ClienteDtoReponse>> listarTodos(){

        List<ClienteDtoReponse> lista = clienteService.listarTodos().stream().map(ClienteMapper::toResponse).toList();
        return ResponseEntity.ok(lista);

    }

    //Listar por id

    @GetMapping("/listar/{id}")
    public ResponseEntity<ClienteDtoReponse> listarPorId(@PathVariable Long id){

        Optional<ClienteModel> clienteId = clienteService.findById(id);

        if(clienteId.isPresent()){
            ClienteDtoReponse dto  = ClienteMapper.toResponse(clienteId.get());
            return ResponseEntity.ok(dto);

        }else{
            return ResponseEntity.notFound().build();
        }

    }

    //Criar novo Cliente
    @PostMapping("/criar")
    public ResponseEntity<ClienteDtoReponse> criarUsuario(@RequestBody ClienteDtoRequest request){

            ClienteModel clienteSave = ClienteMapper.toEntity(request);
            ClienteModel save = clienteService.criarCliente(clienteSave);
            return new ResponseEntity<>(ClienteMapper.toResponse(save), HttpStatus.CREATED);
    }

    //Deletar cliente pelo Id
    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id){

       clienteService.deletarPorId(id);
       return ResponseEntity.noContent().build();

    }

    //Atulizar dados do CLiente

    @PutMapping("/atualizar/{id}")
    public ResponseEntity<ClienteDtoReponse> atualizarCliente(@RequestBody ClienteDtoRequest request,  @PathVariable Long id ){


        ClienteModel clienteAtulizado = ClienteMapper.toEntity(request);
        ClienteModel atulizado = clienteService.atualizarCliente(clienteAtulizado, id);

        return ResponseEntity.ok(ClienteMapper.toResponse(atulizado));

    }



}
