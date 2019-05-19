package desafio.dto;

public class ContatoDto {

    private String nome;
    private String valor;
    private String obs;
    private Long canal;
    private Long id;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    public String getObs() {
        return obs;
    }

    public void setObs(String obs) {
        this.obs = obs;
    }

    public Long getCanal() {
        return canal;
    }

    public void setCanal(Long canal) {
        this.canal = canal;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ContatoDto() {
    }

    public ContatoDto(String nome, String valor, String obs, Long canal, Long id) {
        this.nome = nome;
        this.valor = valor;
        this.obs = obs;
        this.canal = canal;
        this.id = id;
    }
}
