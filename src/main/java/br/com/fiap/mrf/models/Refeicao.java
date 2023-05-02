package br.com.fiap.mrf.models;

import java.time.LocalDate;
import java.time.LocalTime;

import org.springframework.data.domain.Pageable;
import org.springframework.hateoas.EntityModel;

import br.com.fiap.mrf.controllers.AlimentacoesController;
import br.com.fiap.mrf.controllers.UsersController;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
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

    public EntityModel<Refeicao> toEntityModel() {
        return EntityModel.of(
            this, 
            linkTo(methodOn(AlimentacoesController.class).show(id)).withSelfRel(),
            linkTo(methodOn(AlimentacoesController.class).destroy(id)).withRel("delete"),
            linkTo(methodOn(AlimentacoesController.class).index(null, Pageable.unpaged())).withRel("all"),
            linkTo(methodOn(UsersController.class).show(this.getUser().getId())).withRel("user")
        );
    }
}
