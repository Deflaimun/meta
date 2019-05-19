package desafio.vo;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.io.Serializable;
import java.util.Date;

@Embeddable
public class AuditoriaVo implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * Data de Inativacao
     */
    @Temporal(TemporalType.DATE)
    @Column(name = "DT_INAT", insertable = false)
    private Date dtInat;

    /**
     * Data de Inclusao
     */
    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(pattern = "dd/MM/yyyy HH:mm:ss")
    @Column(name = "DT_INCL", nullable = false, updatable = false)
    private Date dtIncl;

    /**
     * Data de Alteracao
     */
    @Temporal(TemporalType.DATE)
    @Column(name = "DT_ALTER", length = 7)
    private Date dtAlter;

    /**
     * Codigo do Usuario
     */
    @Column(name = "CD_USUARIO", nullable = false, length = 30)
    private String cdUsuario;

    /**
     * Construtor padrao
     */
    public AuditoriaVo() {
        super();
    }

    /**
     * Construtor a partir de usuario
     *
     * @param usuario usuario
     */
    public AuditoriaVo(String usuario) {
        super();
        this.dtIncl = new Date();
        this.cdUsuario = usuario;
    }

    public Date getDtInat() {
        return dtInat;
    }

    public void setDtInat(Date dtInat) {
        this.dtInat = dtInat;
    }

    public Date getDtIncl() {
        return dtIncl;
    }

    public void setDtIncl(Date dtIncl) {
        this.dtIncl = dtIncl;
    }

    public Date getDtAlter() {
        return dtAlter;
    }

    public void setDtAlter(Date dtAlter) {
        this.dtAlter = dtAlter;
    }

    public String getCdUsuario() {
        return cdUsuario;
    }

    public void setCdUsuario(String cdUsuario) {
        this.cdUsuario = cdUsuario;
    }

    /**
     * Preenche data de alteracao e usuario
     *
     * @param usuario usuario
     */
    public void alterar(String usuario) {
        this.dtAlter = new Date();
        this.cdUsuario = usuario;
    }
}
