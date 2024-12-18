package com.example.TesteItauGustavoFernadnes.entity;

import java.time.OffsetDateTime;

public class TransacaoEntity {

    private Double valor;
    private OffsetDateTime dataHora;

    public TransacaoEntity(Double valor, OffsetDateTime dataHora) {
        this.valor = valor;
        this.dataHora = dataHora;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public OffsetDateTime getDataHora() {
        return dataHora;
    }

    public void setDataHora(OffsetDateTime dataHora) {
        this.dataHora = dataHora;
    }

}
