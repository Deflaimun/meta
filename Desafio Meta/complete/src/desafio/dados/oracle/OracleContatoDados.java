package desafio.dados.oracle;

import desafio.dados.IContatoDados;
import desafio.dominio.Contato;
import org.springframework.stereotype.Repository;

import javax.persistence.Query;
import java.util.List;

@Repository
public class OracleContatoDados extends OracleRepositorioGenericoDados<Contato,Long> implements IContatoDados {

    public OracleContatoDados() {
        super(Contato.class);
    }



    @Override
    public List<Contato> obterTodosPaginado(Integer page, Integer size) {
        StringBuilder consulta = new StringBuilder()
                .append("SELECT * FROM Contato  ")
                .append("ORDER BY NO_SEQ_ID_CONT ")
                .append("OFFSET :page ROWS FETCH NEXT :size ROWS ONLY");

        final Query query = this.getGerenciadorDeEntidade().createNativeQuery(consulta.toString(), Contato.class);

        query.setParameter("page", page*size);
        query.setParameter("size", size);
        return query.getResultList();
    }
}
