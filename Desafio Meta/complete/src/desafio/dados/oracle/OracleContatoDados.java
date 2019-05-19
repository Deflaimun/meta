package desafio.dados.oracle;

import desafio.dados.IContatoDados;
import desafio.dominio.Contato;
import org.springframework.stereotype.Repository;

import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class OracleContatoDados extends OracleRepositorioGenericoDados<Contato,Long> implements IContatoDados {

    public OracleContatoDados() {
        super(Contato.class);
    }



    @Override
    public List<Contato> obterTodosPaginado(Integer page, Integer size) {
        StringBuilder consulta = new StringBuilder()
                .append("SELECT contato from Contato contato ")
                .append("WHERE ROWID < :pagina ");


        final TypedQuery<Contato> query = this.getGerenciadorDeEntidade().createQuery(consulta.toString(), Contato.class);

        query.setParameter("pagina", page*size);
        return query.getResultList();
    }
}
