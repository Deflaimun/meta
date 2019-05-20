package desafio.dto;

public class RespostaQuestaoUmDto {

    private Long indiceUm;
    private Long indiceDois;

    public Long getIndiceUm() {
        return indiceUm;
    }

    public void setIndiceUm(Long indiceUm) {
        this.indiceUm = indiceUm;
    }

    public Long getIndiceDois() {
        return indiceDois;
    }

    public void setIndiceDois(Long indiceDois) {
        this.indiceDois = indiceDois;
    }

    public RespostaQuestaoUmDto() {
    }

    public RespostaQuestaoUmDto(Long indiceUm, Long indiceDois) {
        this.indiceUm = indiceUm;
        this.indiceDois = indiceDois;
    }
}
