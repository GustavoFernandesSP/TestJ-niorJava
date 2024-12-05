package com.example.TesteItauGustavoFernadnes.controller;

import com.example.TesteItauGustavoFernadnes.dto.EstatisticaDto;
import com.example.TesteItauGustavoFernadnes.entity.EstatisticaEntity;
import com.example.TesteItauGustavoFernadnes.entity.TransacaoEntity;
import com.example.TesteItauGustavoFernadnes.service.EstatisticaService;
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


    private Transacao transacao;
    private EstatisticaService estatisticaService;


    @GetMapping
    public ResponseEntity<EstatisticaDto> getEstatistica() {

        if (transacao == null || transacao.getTransacoes().isEmpty()) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }

        EstatisticaDto estatisticas = estatisticaService.calcularEstatisticas(transacao.getTransacoes());
        return ResponseEntity.ok(estatisticas);
    }



}
