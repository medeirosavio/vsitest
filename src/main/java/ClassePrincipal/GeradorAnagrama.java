package ClassePrincipal;

import java.util.ArrayList;
import java.util.List;

public class GeradorAnagrama {

    public List<String> gerarAnagramas(String entrada) {
        if (entrada == null || entrada.isEmpty()) {
            throw new IllegalArgumentException("A entrada não pode ser nula ou vazia.");
        }

        if (!entrada.matches("[a-zA-Z]+")) {
            throw new IllegalArgumentException("A entrada deve conter apenas letras (a-z ou A-Z).");
        }

        List<String> resultado = new ArrayList<>();
        gerarPermutacoes("", entrada, resultado);
        return resultado;
    }

    private void gerarPermutacoes(String prefixo, String restante, List<String> resultado) {
        if (restante.isEmpty()) {
            resultado.add(prefixo);
        } else {
            for (int i = 0; i < restante.length(); i++) {
                String novoPrefixo = prefixo + restante.charAt(i);
                String novoRestante = restante.substring(0, i) + restante.substring(i + 1);
                gerarPermutacoes(novoPrefixo, novoRestante, resultado);
            }
        }
    }
}

