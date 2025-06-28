package Validacoes;

public class ValidadorNaoVazio {

    public void validar(String entrada) {
        if (entrada == null || entrada.isEmpty()) {
            throw new IllegalArgumentException("A entrada não pode ser nula ou vazia.");
        }
    }
}

