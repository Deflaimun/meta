package desafio.dominio;

import desafio.util.Constantes;
import desafio.vo.AuditoriaVo;

import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

public class EntidadeGenericaOuvinte {

    @PrePersist
    public void userPrePersist(final EntidadeGenerica entidade) {
        entidade.setAuditoriaVo(new AuditoriaVo(this.getUsuarioCorrente()));
    }

    @PreUpdate
    public void userPreUpdate(final EntidadeGenerica entidade) {
        entidade.alterar(this.getUsuarioCorrente());
    }

    /**
     * Poe o usuario corrente que esta executando a query
     *
     * @return usuario corrente
     */
    private String getUsuarioCorrente() {
        return Constantes.USUARIO_SISTEMA;
    }
}
