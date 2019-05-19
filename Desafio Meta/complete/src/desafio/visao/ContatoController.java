package desafio.visao;

import desafio.dominio.Contato;
import desafio.dto.ContatoDto;
import desafio.servicos.ServicosDeContato;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/contato")
public class ContatoController {

    @Autowired
    private ServicosDeContato servicosDeContato;
    
    @GetMapping("/idContato")
    public Contato obterContato(@RequestParam Long id) {
        return servicosDeContato.obterContato(id);
    }

    @PutMapping("/idContato")
    public Contato alterarContato(@RequestBody ContatoDto contato) {
        Contato cont = new Contato(contato);
        return servicosDeContato.alterarContato(cont);
    }

    @DeleteMapping("/idContato")
    public Contato deletarContato(@RequestParam (value = "idContato")Long id) {
        return servicosDeContato.deletarContato(id);
    }

    @GetMapping
    public List<Contato> obterTodosPaginado(@RequestParam(required = false, value = "page")  Integer page, @RequestParam(required = false,value = "size") Integer size){
        return servicosDeContato.obterTodosPaginado(page != null ? page : 0 ,size != null ? size : 10);
    }

    @PostMapping
    public Contato insereContato(@RequestBody ContatoDto contato){
        Contato cont = new Contato(contato);
        return servicosDeContato.adicionarContato(cont);
    }
}
