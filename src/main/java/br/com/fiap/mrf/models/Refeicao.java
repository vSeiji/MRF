package br.com.fiap.mrf.models;

import java.time.LocalDate;
import java.time.LocalTime;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Refeicao {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private LocalDate dia;

    @NotNull
    private LocalTime horario;

    @NotNull
    private String tipo;

    @NotNull @Size (min = 5, max = 200, message = "deve ser uma refeicao significativa")
    private String refeicao;

    @NotNull @Size (min = 5, max = 200, message = "deve ser uma bebida significativa")
    private String bebida;

    @NotNull
    private Integer calorias;
    
    @ManyToOne
    private Users user;


}
