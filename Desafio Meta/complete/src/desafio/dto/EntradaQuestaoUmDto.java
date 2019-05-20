package desafio.dto;

import java.util.List;

public class EntradaQuestaoUmDto {

    private List<Long> conjuntoEntrada;
    private Long alvo;


    public List<Long> getConjuntoEntrada() {
        return conjuntoEntrada;
    }

    public void setConjuntoEntrada(List<Long> conjuntoEntrada) {
        this.conjuntoEntrada = conjuntoEntrada;
    }

    public Long getAlvo() {
        return alvo;
    }

    public void setAlvo(Long alvo) {
        this.alvo = alvo;
    }

    public EntradaQuestaoUmDto() {
    }

    public EntradaQuestaoUmDto(List<Long> conjuntoEntrada, Long alvo) {
        this.conjuntoEntrada = conjuntoEntrada;
        this.alvo = alvo;
    }
}
