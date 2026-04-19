package com.gabriellima.MesaFacil2026.Service;

import com.gabriellima.MesaFacil2026.Model.ReservaModel;
import com.gabriellima.MesaFacil2026.Repository.ReservaRepository;
import org.hibernate.annotations.AnyDiscriminatorImplicitValues;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReservaService {

    @Autowired
    private ReservaRepository reservaRepository;


    //Listar todas as Reservas

    public List<ReservaModel> listarTodos(){

        return reservaRepository.findAll();
    }

    //Buscar Por id
    public Optional<ReservaModel> listarPorId(Long id){

        return reservaRepository.findById(id);
    }

    //Criar nova Reserva
    public ReservaModel criarReserva (ReservaModel reservaModel){
        return reservaRepository.save(reservaModel);

    }



}
