package desafio.dados.oracle;

import desafio.dados.IRepositorioGenericoDados;
import desafio.dominio.EntidadeGenerica;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public abstract class OracleRepositorioGenericoDados <T,TipoId> implements IRepositorioGenericoDados<T,TipoId> {

    @PersistenceContext
    private EntityManager gerenciadorDeEntidade;
    private Class<T> classeDaEntidade;

    public OracleRepositorioGenericoDados(Class<T> classe) {
        this.classeDaEntidade = classe;
    }

    public void salvar(T entidade) {
        this.gerenciadorDeEntidade.persist(entidade);
    }

    public void excluir(T entidade) {
        this.gerenciadorDeEntidade.remove(entidade);
    }

    public void alterar(T entidade) {
        this.gerenciadorDeEntidade.merge(entidade);
    }

    public EntityManager getGerenciadorDeEntidade() {
        return this.gerenciadorDeEntidade;
    }

    public T obterPorId(TipoId id) {
        return this.gerenciadorDeEntidade.find(this.classeDaEntidade, id);
    }


}
