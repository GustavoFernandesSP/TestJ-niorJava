package com.example.TesteItauGustavoFernadnes.controller;


import com.example.TesteItauGustavoFernadnes.entity.transacaoEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/transacao")
public class transacao {

    List<transacaoEntity> transacoes = new ArrayList<>();


    @PostMapping
    public ResponseEntity<Void> cadastrarTransacao(@RequestBody transacaoEntity transacao) {

        if (transacao.getDataHora().isAfter(OffsetDateTime.now())) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }

        /////Faltando///

        transacoes.add(transacao);

        return ResponseEntity.ok().build();

    }





}

