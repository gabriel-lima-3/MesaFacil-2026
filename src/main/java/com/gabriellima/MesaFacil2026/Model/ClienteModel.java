package com.gabriellima.MesaFacil2026.Model;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table(name ="Cliente")
@Entity

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ClienteModel {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;
    private String nome;
    private String email;
    private String numero;

}
