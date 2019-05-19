package desafio.dados;

import desafio.dominio.Contato;

import java.util.List;

public interface IContatoDados extends IRepositorioGenericoDados<Contato, Long>{

    List<Contato> obterTodosPaginado(Integer page, Integer size);
}
