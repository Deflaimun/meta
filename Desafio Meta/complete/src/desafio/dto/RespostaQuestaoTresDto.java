package desafio.dto;

public class RespostaQuestaoTresDto {

    private Long lucro;

    public Long getLucro() {
        return lucro;
    }

    public void setLucro(Long lucro) {
        this.lucro = lucro;
    }

    public RespostaQuestaoTresDto() {
    }

    public RespostaQuestaoTresDto(Long lucro) {
        this.lucro = lucro;
    }
}
