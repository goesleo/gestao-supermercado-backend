package com.example.supermercado.supermarket_api.model;


import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;

@Entity
@Table(name = "produtos")
@Data
public class Produto {
   @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long    id;
    private String  nome;
    private Integer quantidade;
    private String descricao;
    private LocalDateTime dataCadastro;
        @PrePersist
        public void preencherDataCadastro() {
        this.dataCadastro = LocalDateTime.now();
 }

}
