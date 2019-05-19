package desafio.dados;

import javax.persistence.EntityManager;

public interface IRepositorioGenericoDados <T, TipoId> {

    void salvar(T var1);

    void excluir(T var1);

    void alterar(T var1);

    EntityManager getGerenciadorDeEntidade();

    T obterPorId(TipoId id);

}
