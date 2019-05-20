package desafio.dto;

import java.util.List;

public class EntradaQuestaoQuatroDto {

    private List<Long> mapa;

    public List<Long> getMapa() {
        return mapa;
    }

    public void setMapa(List<Long> mapa) {
        this.mapa = mapa;
    }

    public EntradaQuestaoQuatroDto() {
    }

    public EntradaQuestaoQuatroDto(List<Long> mapa) {
        this.mapa = mapa;
    }
}
