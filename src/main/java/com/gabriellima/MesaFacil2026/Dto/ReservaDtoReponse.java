package com.gabriellima.MesaFacil2026.Dto;

import com.gabriellima.MesaFacil2026.Enums.ReservaStatus;
import com.gabriellima.MesaFacil2026.Enums.ReservaTipoDeEvento;
import com.gabriellima.MesaFacil2026.Enums.ReservaTipoDePagamento;
import com.gabriellima.MesaFacil2026.Model.ReservaModel;

import java.time.LocalDateTime;

public record ReservaDtoReponse (

        Long id,
        int quantidade,
        ReservaTipoDeEvento tipoDeEvento,
        ReservaStatus reservaStatus,
        ReservaTipoDePagamento statusTipoDePagamaneto,
        LocalDateTime hararioInicio,
        Long clienteId


){



}
