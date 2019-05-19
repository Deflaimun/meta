package desafio.servicos;

import desafio.dados.IContatoDados;
import desafio.dominio.Contato;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class ServicosDeContato {

    @Autowired
    private IContatoDados repositorioDeContato;

    public Contato obterContato(Long id) {

        return this.repositorioDeContato.obterPorId(id);
    }

    public Contato alterarContato(Contato contato) {
        Contato old =  this.repositorioDeContato.obterPorId(contato.getId());
        contato.setAuditoriaVo(old.getAuditoriaVo());
        this.repositorioDeContato.alterar(contato);
        return contato;
    }

    public Contato deletarContato(Long id) {
        Contato contato = this.repositorioDeContato.obterPorId(id);

        this.repositorioDeContato.excluir(contato);
        return contato;
    }

    public List<Contato> obterTodosPaginado(Integer page, Integer size) {
        return this.repositorioDeContato.obterTodosPaginado(page,size);

    }

    public Contato adicionarContato(Contato contato) {
        try {
            this.repositorioDeContato.salvar(contato);
            return contato;
        }
        catch (Exception e ){
            return null;
        }
    }
}
