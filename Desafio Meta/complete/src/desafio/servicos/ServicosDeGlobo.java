package desafio.servicos;

import desafio.dto.EntradaQuestaoDoisDto;
import desafio.dto.EntradaQuestaoQuatroDto;
import desafio.dto.EntradaQuestaoTresDto;
import desafio.dto.EntradaQuestaoUmDto;
import desafio.dto.RespostaQuestaoDoisDto;
import desafio.dto.RespostaQuestaoQuatroDto;
import desafio.dto.RespostaQuestaoTresDto;
import desafio.dto.RespostaQuestaoUmDto;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Stack;

@Service
public class ServicosDeGlobo {


    public RespostaQuestaoUmDto questaoUm(EntradaQuestaoUmDto q) {
        Long aux;
        List<Long> listaEntrada = q.getConjuntoEntrada();
        RespostaQuestaoUmDto res = new RespostaQuestaoUmDto();
        Long entrada;

        for (int i = 0; i < listaEntrada.size(); i++) {
            entrada = listaEntrada.get(i);
            aux = q.getAlvo() -entrada;
            res.setIndiceUm((long)i);
            for (int j = 0; j < listaEntrada.size(); j++) {
                if (aux .equals(listaEntrada.get(j))){
                    res.setIndiceDois((long) j);
                    return res;
                }
            }
        }
        return null;
    }

    public RespostaQuestaoDoisDto questaoDois(EntradaQuestaoDoisDto q) {
        Stack<Character> stack = new Stack<>();
        for(char c : q.getEntrada().toCharArray())
        {
            if(c == '(')
                stack.push(')');
            else if(c == '{')
                stack.push('}');
            else if(c == '[')
                stack.push(']');

            else{
                if( stack.isEmpty() || c != stack.peek()){
                    return new RespostaQuestaoDoisDto("NAO");
                }
                else{
                    stack.pop();
                }
            }
        }
        if(stack.isEmpty())
            return new RespostaQuestaoDoisDto("SIM");
        else
            return new RespostaQuestaoDoisDto("NAO");
    }

    public RespostaQuestaoTresDto questaoTres(EntradaQuestaoTresDto q) {
        List<Long> entrada = q.getAcoes();
        Long auxMenor = Long.MAX_VALUE, auxMaior= 0L;
        int indiceMenor=0;

        for (int i = 0; i < entrada.size(); i++) {
            if(entrada.get(i) < auxMenor){
                auxMenor = entrada.get(i);
                indiceMenor = i;
            }
        }

        for (int i = indiceMenor; i < entrada.size(); i++) {
            if(entrada.get(i) > auxMaior){
                auxMaior = entrada.get(i);
            }
        }
        if(auxMenor > auxMaior) {
            return new RespostaQuestaoTresDto(0L);
        }
        else {
            return new RespostaQuestaoTresDto(auxMaior -auxMenor);
        }
    }

    public RespostaQuestaoQuatroDto questaoQuatro(EntradaQuestaoQuatroDto q) {
        List<Long> entrada = q.getMapa();
        int[] array = entrada.stream().mapToInt(Long::intValue).toArray();
        return new RespostaQuestaoQuatroDto(encontrarAgua(array, entrada.size()));
    }

    private long encontrarAgua(int arr[], int n) {
        // initialize output
        int result = 0;

        // maximum element on left and right
        int left_max = 0, right_max = 0;

        // indices to traverse the array
        int lo = 0, hi = n - 1;

        while (lo <= hi) {
            if (arr[lo] < arr[hi]) {
                if (arr[lo] > left_max)

                    // update max in left
                    left_max = arr[lo];
                else

                    // water on curr element =
                    // max - curr
                    result += left_max - arr[lo];
                lo++;
            } else {
                if (arr[hi] > right_max)

                    // update right maximum
                    right_max = arr[hi];
                else
                    result += right_max - arr[hi];
                hi--;
            }
        }
        return result;
    }
}
