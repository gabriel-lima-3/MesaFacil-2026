package com.gabriellima.MesaFacil2026.Dto;

import com.gabriellima.MesaFacil2026.Enums.ReservaStatus;
import com.gabriellima.MesaFacil2026.Enums.ReservaTipoDeEvento;
import com.gabriellima.MesaFacil2026.Enums.ReservaTipoDePagamento;
import com.gabriellima.MesaFacil2026.Model.ClienteModel;
import org.springframework.cglib.core.Local;

import java.time.LocalDateTime;

public record ReservaDtoRequest(

        int quantidade,
        ReservaTipoDeEvento tipoDeEvento,
        ReservaTipoDePagamento tipoDePagamento,
        LocalDateTime horarioInicio,
        Long clienteId

) {
}
