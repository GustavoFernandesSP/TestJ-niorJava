package com.example.TesteItauGustavoFernadnes.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("estatistica")
public class Estatistica {

    private Transacao transacao;

    public Estatistica(Transacao transacao) {
        this.transacao = transacao;
    }




}
