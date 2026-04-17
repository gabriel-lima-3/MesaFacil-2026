package com.gabriellima.MesaFacil2026.Model;

import com.gabriellima.MesaFacil2026.Enums.ReservaStatus;
import com.gabriellima.MesaFacil2026.Enums.ReservaTipoDeEvento;
import com.gabriellima.MesaFacil2026.Enums.ReservaTipoDePagamento;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Table(name = "Reserva")
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ReservaModel {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;
    private int quantidade;
    private ReservaTipoDeEvento tipoReserva;
    private ReservaStatus reservaStatus;
    private ReservaTipoDePagamento statusTipoDePagamanento;
    private LocalDateTime horarioInicio;

    @ManyToOne
    @JoinColumn(name = "client_id")
    private ClienteModel cliente;



}
