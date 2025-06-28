package Validacoes;

public class ValidadorSomenteLetras {

    public void validar(String entrada) {
        if (!entrada.matches("[a-zA-Z]+")) {
            throw new IllegalArgumentException("A entrada deve conter apenas letras (a-z ou A-Z).");
        }
    }
}
