package com.gabriellima.MesaFacil2026.Mapper;

import com.gabriellima.MesaFacil2026.Dto.ClienteDtoReponse;
import com.gabriellima.MesaFacil2026.Dto.ReservaDtoReponse;
import com.gabriellima.MesaFacil2026.Dto.ReservaDtoRequest;
import com.gabriellima.MesaFacil2026.Model.ReservaModel;

public class ReservaMapper {

    public static ReservaDtoReponse toResponse(ReservaModel reserva){

        return new ReservaDtoReponse(reserva.getId(),
                reserva.getQuantidade(),
                reserva.getTipoEvento(),
                reserva.getReservaStatus(),
                reserva.getStatusTipoDePagamanento(),
                reserva.getHorarioInicio(),
                reserva.getCliente().getId());

    }


    public static ReservaModel toEntity( ReservaDtoRequest dto){

        return new ReservaModel(null, dto.quantidade(), dto.tipoDeEvento(), null, dto.tipoDePagamento(), dto.horarioInicio(),null);



    }





}
