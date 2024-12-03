package com.example.TesteItauGustavoFernadnes.controller;


import com.example.TesteItauGustavoFernadnes.entity.TransacaoEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/transacao")
public class Transacao {

    List<TransacaoEntity> transacoes = new ArrayList<>();

    public List<TransacaoEntity> getTransacoes() {
        return transacoes;
    }

    @PostMapping
    public ResponseEntity<Void> cadastrarTransacao(@RequestBody TransacaoEntity transacao) {

        if (transacao.getDataHora() == null || transacao.getValor() == null) {
         return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }

        if (transacao.getDataHora().isAfter(OffsetDateTime.now())) {
            return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).build();
        }

        if (transacao.getValor() > 0 || transacao.getValor() == 0) {
            return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).build();
        }

        transacoes.add(transacao);

        return ResponseEntity.ok().build();
    }


    @DeleteMapping
    public ResponseEntity<Void> ExcluirTransacao() {

        transacoes.clear();

        return ResponseEntity.ok().build();

    }





}

