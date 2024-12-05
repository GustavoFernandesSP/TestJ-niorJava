package com.example.TesteItauGustavoFernadnes.controller;

import com.example.TesteItauGustavoFernadnes.entity.EstatisticaEntity;
import com.example.TesteItauGustavoFernadnes.entity.TransacaoEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpClientErrorException;
import org.w3c.dom.DOMImplementation;

import java.time.OffsetTime;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/estatistica")
public class Estatistica {


    private Integer count;
    private double sum;
    private double avg;
    private double min;
    private double max;
    private Transacao transacao;


    @GetMapping
    public ResponseEntity<Estatistica> getEstatistica() {

        if (transacao == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }

        if (transacao.getTransacoes().isEmpty()) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }

        int horarioExecutado = OffsetTime.now().getSecond() - 60;

        List<TransacaoEntity> transacoesDentroDoTempoDeUmMinuto = new ArrayList<>();

        for (int i = 0; i < transacao.getTransacoes().size(); i++) {
            if (transacao.getTransacoes().get(i).getDataHora().getSecond() > horarioExecutado) {
                transacoesDentroDoTempoDeUmMinuto.add(transacao.getTransacoes().get(i));
            }
        }

        Integer count = transacoesDentroDoTempoDeUmMinuto.size();
        double sum = 0.0;
        double min = Double.MAX_VALUE;
        double max = Double.MIN_VALUE;

        for (TransacaoEntity transacao : transacoesDentroDoTempoDeUmMinuto) {
            sum += transacao.getValor();
            min = Math.min(min, transacao.getValor());
            max = Math.max(max, transacao.getValor());
        }

        double avg = count > 0 ? sum / count : 0.0;

        Estatistica estatistica = new Estatistica(count, sum, avg, min, max);

        return ResponseEntity.ok(estatistica);
    }



}
