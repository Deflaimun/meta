package desafio.dados;

import desafio.dominio.Contato;

import java.util.List;

public interface IContatoDados extends IRepositorioGenericoDados<Contato, Long>{

    List obterTodosPaginado(Integer page, Integer size);
}
