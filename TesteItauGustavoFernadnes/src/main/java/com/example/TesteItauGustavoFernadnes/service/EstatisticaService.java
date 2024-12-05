package com.example.TesteItauGustavoFernadnes.service;

import com.example.TesteItauGustavoFernadnes.dto.EstatisticaDto;
import com.example.TesteItauGustavoFernadnes.entity.TransacaoEntity;
import org.springframework.stereotype.Service;

import java.time.OffsetTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class EstatisticaService {

    public EstatisticaDto calcularEstatisticas(List<TransacaoEntity> transacoes) {
        int horarioExecutado = OffsetTime.now().getSecond() - 60;

        List<TransacaoEntity> transacoesDentroDoTempoDeUmMinuto = new ArrayList<>();
        for (TransacaoEntity transacao : transacoes) {
            if (transacao.getDataHora().getSecond() > horarioExecutado) {
                transacoesDentroDoTempoDeUmMinuto.add(transacao);
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

        return new EstatisticaDto(count, sum, avg, min, max);
    }
}

