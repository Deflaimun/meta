package desafio.visao;


import desafio.dto.EntradaQuestaoDoisDto;
import desafio.dto.EntradaQuestaoQuatroDto;
import desafio.dto.EntradaQuestaoTresDto;
import desafio.dto.EntradaQuestaoUmDto;
import desafio.dto.RespostaQuestaoDoisDto;
import desafio.dto.RespostaQuestaoQuatroDto;
import desafio.dto.RespostaQuestaoTresDto;
import desafio.dto.RespostaQuestaoUmDto;
import desafio.servicos.ServicosDeGlobo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/globo")
public class GloboController {


    @Autowired
    private ServicosDeGlobo servicosDeGlobo;

    @GetMapping("/1")
    private RespostaQuestaoUmDto questaoUm (@RequestBody EntradaQuestaoUmDto q){
        return this.servicosDeGlobo.questaoUm(q);
    }

    @PostMapping("/2")
    private RespostaQuestaoDoisDto questaoDois (@RequestBody EntradaQuestaoDoisDto q){
        return this.servicosDeGlobo.questaoDois(q);
    }

    @PostMapping("/3")
    private RespostaQuestaoTresDto questaoTres (@RequestBody EntradaQuestaoTresDto q){
        return this.servicosDeGlobo.questaoTres(q);
    }

    @PostMapping("/4")
    private RespostaQuestaoQuatroDto questaoQuatro (@RequestBody EntradaQuestaoQuatroDto q){
        return this.servicosDeGlobo.questaoQuatro(q);
    }

}
