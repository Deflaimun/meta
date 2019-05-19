package desafio.dominio;


import desafio.dto.ContatoDto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "CONTATO")
public class Contato  extends EntidadeGenerica{

    @Id
    @Column(name = "NO_SEQ_ID_CONT", nullable = false)
    private Long id;

    @Column(name = "NOME")
    private String nome;

    @Column(name = "CANAL")
    private Long canal;

    @Column (name = "VALOR")
    private String valor;

    @Column (name = "OBS")
    private String obs;

    public Long getId() {
        return id;
    }


    public Long getCanal() {
        return canal;
    }

    public void setCanal(Long canal) {
        this.canal = canal;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Contato() {
    }

    public Contato(ContatoDto contatoDto) {
        this.id = contatoDto.getId();
        this.nome = contatoDto.getNome();
        this.canal = contatoDto.getCanal();
        this.obs = contatoDto.getObs();
        this.valor = contatoDto.getValor();
    }
}
