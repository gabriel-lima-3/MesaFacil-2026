package com.gabriellima.MesaFacil2026.Mapper;

import com.gabriellima.MesaFacil2026.Dto.ClienteDtoReponse;
import com.gabriellima.MesaFacil2026.Dto.ClienteDtoRequest;
import com.gabriellima.MesaFacil2026.Model.ClienteModel;

public class ClienteMapper {


    //Para puxar dados do CLiente
    public static ClienteDtoReponse toResponse (ClienteModel cliente){
        return new ClienteDtoReponse(cliente.getId(),
                cliente.getNome(),
                cliente.getEmail(),
                cliente.getNumero());
    }


    //Para criar dados do cliente
    public static ClienteModel toEntity(ClienteDtoRequest dto){

        return new ClienteModel(null, dto.nome(), dto.email(), dto.numero());

    }
}
