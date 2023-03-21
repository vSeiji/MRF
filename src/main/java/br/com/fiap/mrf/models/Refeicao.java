package br.com.fiap.mrf.models;

import java.sql.Date;

public class Refeicao {
    
    private String id;
    private String dia;
    private String horario;
    private String tipoRefeicao;
    private String refeicao;
    private String bebida;
    private Integer calorias;
    
    public Refeicao (String id, String dia, String horario, String tipoRefeicao, String refeicao, String bebida, Integer calorias) {
        this.id = id;
        this.dia = dia;
        this.horario = horario;
        this.tipoRefeicao = tipoRefeicao;
        this.refeicao = refeicao;
        this.bebida = bebida;
    }

    public String getDia() {
        return dia;
    }
    public void setDia(String dia) {
        this.dia = dia;
    }
    public String getHorario() {
        return horario;
    }
    public void setHorario(String horario) {
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

    
}
