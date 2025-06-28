package ClassePrincipal;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Testes para GeradorAnagrama")
class GeradorAnagramaTest {

    private GeradorAnagrama gerador;

    @BeforeEach
    void setUp() {
        gerador = new GeradorAnagrama();
    }

    @Test
    @DisplayName("Deve gerar todos os anagramas para 'abc'")
    void deveGerarAnagramasParaTresLetras() {
        List<String> resultado = gerador.gerarAnagramas("abc");

        assertAll(
                () -> assertEquals(6, resultado.size(), "Deve conter 6 anagramas"),
                () -> assertTrue(resultado.contains("abc")),
                () -> assertTrue(resultado.contains("acb")),
                () -> assertTrue(resultado.contains("bac")),
                () -> assertTrue(resultado.contains("bca")),
                () -> assertTrue(resultado.contains("cab")),
                () -> assertTrue(resultado.contains("cba"))
        );
    }

    @Test
    @DisplayName("Deve retornar a própria letra quando só há uma")
    void deveGerarUmAnagramaParaUmaLetra() {
        List<String> resultado = gerador.gerarAnagramas("x");
        assertEquals(List.of("x"), resultado);
    }

    @Test
    @DisplayName("Deve lançar exceção para entrada vazia")
    void deveLancarExcecaoParaEntradaVazia() {
        IllegalArgumentException ex = assertThrows(IllegalArgumentException.class, () -> {
            gerador.gerarAnagramas("");
        });
        assertEquals("A entrada não pode ser nula ou vazia.", ex.getMessage());
    }

    @Test
    @DisplayName("Deve lançar exceção para entrada nula")
    void deveLancarExcecaoParaEntradaNula() {
        IllegalArgumentException ex = assertThrows(IllegalArgumentException.class, () -> {
            gerador.gerarAnagramas(null);
        });
        assertEquals("A entrada não pode ser nula ou vazia.", ex.getMessage());
    }

    @ParameterizedTest
    @ValueSource(strings = {"123", "a1b", "abc!", "A*B", "a b"})
    @DisplayName("Deve lançar exceção para entrada com caracteres inválidos")
    void deveLancarExcecaoParaCaracteresInvalidos(String entrada) {
        IllegalArgumentException ex = assertThrows(IllegalArgumentException.class, () -> {
            gerador.gerarAnagramas(entrada);
        });
        assertEquals("A entrada deve conter apenas letras (a-z ou A-Z).", ex.getMessage());
    }
}
