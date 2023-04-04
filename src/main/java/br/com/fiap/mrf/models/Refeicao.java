package br.com.fiap.mrf.models;


import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import jakarta.annotation.Generated;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Size;

@Entity
public class Refeicao {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private LocalDate dia;

    @NotNull
    private LocalTime horario;

    @NotNull
    private String tipoRefeicao;

    @NotNull @Size (min = 5, max = 200, message = "deve ser uma refeicao significativa")
    private String refeicao;

    @NotNull @Size (min = 5, max = 200, message = "deve ser uma bebida significativa")
    private String bebida;

    @NotNull
    private Integer calorias;
    
    protected Refeicao(){}

    public Refeicao (Long id, LocalDate dia, LocalTime horario, String tipoRefeicao, String refeicao, String bebida, Integer calorias) {
        this.id = id;
        this.dia = dia;
        this.horario = horario;
        this.tipoRefeicao = tipoRefeicao;
        this.refeicao = refeicao;
        this.bebida = bebida;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getDia() {
        return dia;
    }
    public void setDia(LocalDate dia) {
        this.dia = dia;
    }
    public LocalTime getHorario() {
        return horario;
    }
    public void setHorario(LocalTime horario) {
        this.horario = horario;
    }
    public String getTipoRefeicao() {
        return tipoRefeicao;
    }
    public void setTipoRefeicao(String tipoRefeicao) {
        this.tipoRefeicao = tipoRefeicao;
    }
    public String getRefeicao() {
        return refeicao;
    }
    public void setRefeicao(String refeicao) {
        this.refeicao = refeicao;
    }
    public String getBebida() {
        return bebida;
    }
    public void setBebida(String bebida) {
        this.bebida = bebida;
    }
    public Integer getCalorias() {
        return calorias;
    }
    public void setCalorias(Integer calorias) {
        this.calorias = calorias;
    }

    @Override
    public String toString() {
        return "Refeicao [id=" + id + ", dia=" + dia + ", horario=" + horario + ", tipoRefeicao=" + tipoRefeicao
                + ", refeicao=" + refeicao + ", bebida=" + bebida + ", calorias=" + calorias + "]";
    }

    public void add(Refeicao refeicao2) {
    }

    
}
