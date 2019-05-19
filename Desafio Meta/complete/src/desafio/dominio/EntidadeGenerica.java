package desafio.dominio;


import com.fasterxml.jackson.annotation.JsonIgnore;
import desafio.vo.AuditoriaVo;

import javax.persistence.Embedded;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.io.Serializable;
import java.util.Date;

@MappedSuperclass
@EntityListeners(EntidadeGenericaOuvinte.class)
public abstract class EntidadeGenerica implements Serializable {

    private static final long serialVersionUID = 1990519232869260591L;

    @Embedded
    @JsonIgnore
    protected AuditoriaVo auditoriaVo;

    public EntidadeGenerica() {
        super();
    }

    public EntidadeGenerica(String usuario) {
        this.auditoriaVo = new AuditoriaVo(usuario);
    }

    public AuditoriaVo getAuditoriaVo() {
        return auditoriaVo;
    }

    public void setAuditoriaVo(AuditoriaVo auditoriaVo) {
        this.auditoriaVo = auditoriaVo;
    }

    public void alterar(String usuario) {
        this.auditoriaVo.setDtAlter(new Date());
        this.auditoriaVo.alterar(usuario);
    }

}
