package desafio.dto;

import java.util.List;

public class EntradaQuestaoTresDto {

    private List<Long> acoes;

    public List<Long> getAcoes() {
        return acoes;
    }

    public void setAcoes(List<Long> acoes) {
        this.acoes = acoes;
    }

    public EntradaQuestaoTresDto() {
    }

    public EntradaQuestaoTresDto(List<Long> acoes) {
        this.acoes = acoes;
    }
}
