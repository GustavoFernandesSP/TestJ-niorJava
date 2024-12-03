package com.example.TesteItauGustavoFernadnes.dto;

public class EstatisticaDTO {

    public class EstatisticaDTO {
        private Integer count;
        private double sum;
        private double avg;
        private double min;
        private double max;

        public EstatisticaDTO(Integer count, double sum, double avg, double min, double max) {
            this.count = count;
            this.sum = sum;
            this.avg = avg;
            this.min = min;
            this.max = max;
        }

}
