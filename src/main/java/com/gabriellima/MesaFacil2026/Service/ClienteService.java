package com.gabriellima.MesaFacil2026.Service;

import com.gabriellima.MesaFacil2026.Model.ClienteModel;
import com.gabriellima.MesaFacil2026.Repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    //Retornar todos os clientes
    public List<ClienteModel> listarTodos(){
        return clienteRepository.findAll();

    }

    //Criar novo Cliente
    public ClienteModel criarCliene(ClienteModel clienteModel){

        return clienteRepository.save(clienteModel);

    }

    //BuscarPorId
    public Optional<ClienteModel> findById(Long id){
        return clienteRepository.findById(id);
    }

    //Deletar
    public void deletarPorId(Long id){

        if(clienteRepository.existsById(id)){
            clienteRepository.deleteById(id);
        }else{
            throw new RuntimeException("Cliente nao encontrado");
        }
    }

    public ClienteModel atualizarCliente(ClienteModel model, Long id){

        Optional<ClienteModel>  clienteExiste = clienteRepository.findById(id);
        if(clienteExiste.isPresent()) {

            ClienteModel clienteAtual = clienteExiste.get();
            clienteAtual.setNome(model.getNome());
            clienteAtual.setEmail(model.getEmail());
            clienteAtual.setNumero(model.getNumero());
            return clienteRepository.save(clienteAtual);

        }else{
            throw  new RuntimeException("Cliente nao encontrado");
        }




    }



}
