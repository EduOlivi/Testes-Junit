import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.*;

public class ValidadorUsuarioTest {

    private ValidadorUsuario validador;

    @BeforeEach
    void setup() {
        // Inicializa o objeto antes de cada teste
        validador = new ValidadorUsuario();
    }

    // --- TESTES: VALIDAÇÃO DO NOME DE USUÁRIO ---

    @Test
    @DisplayName("Deve retornar verdadeiro para nomes com tamanho entre 3 e 20 caracteres")
    void testNomeUsuarioValido() {
        assertTrue(validador.validarNomeUsuario("Eduardo"), "Nome dentro da faixa deveria ser válido");
        assertTrue(validador.validarNomeUsuario("Jo"), "Nome com 3 caracteres deveria ser válido");
        assertTrue(validador.validarNomeUsuario("NomeComVinteChars123"), "Nome com 20 caracteres deveria ser válido");
    }

    @Test
    @DisplayName("Deve retornar falso para nomes muito curtos")
    void testNomeUsuarioMuitoCurto() {
        assertFalse(validador.validarNomeUsuario("Ed"), "Nome com menos de 3 caracteres deve ser inválido");
    }

    @Test
    @DisplayName("Deve retornar falso para nomes muito longos")
    void testNomeUsuarioMuitoLongo() {
        assertFalse(validador.validarNomeUsuario("EsteNomeDeUsuarioEhMuitoLongo"), "Nome com mais de 20 caracteres deve ser inválido");
    }

    @Test
    @DisplayName("Deve retornar falso para nome nulo")
    void testNomeUsuarioNulo() {
        assertFalse(validador.validarNomeUsuario(null), "Nome nulo deve ser inválido");
    }

    // --- TESTES: VALIDAÇÃO DO EMAIL ---

    @Test
    @DisplayName("Deve retornar verdadeiro para emails em formato válido")
    void testEmailValido() {
        assertTrue(validador.validarEmail("contato@exemplo.com"), "Email formatado corretamente deve ser válido");
        assertTrue(validador.validarEmail("eduardo.dev@univ.br"), "Email com pontos deve ser válido");
    }

    @Test
    @DisplayName("Deve retornar falso para email sem o caractere @")
    void testEmailSemArroba() {
        assertFalse(validador.validarEmail("usuarioexemplo.com"), "Email sem @ deve ser inválido");
    }

    @Test
    @DisplayName("Deve retornar falso para email sem domínio")
    void testEmailSemDominio() {
        assertFalse(validador.validarEmail("usuario@"), "Email sem domínio após o @ deve ser inválido");
        assertFalse(validador.validarEmail("usuario@com"), "Email sem extensão de domínio válida deve ser inválido");
    }

    @Test
    @DisplayName("Deve retornar falso para email nulo")
    void testEmailNulo() {
        assertFalse(validador.validarEmail(null), "Email nulo deve ser inválido");
    }

    // --- TESTES: VALIDAÇÃO DA SENHA ---

    @Test
    @DisplayName("Deve retornar verdadeiro para senha com letras, números e tamanho mínimo")
    void testSenhaValida() {
        assertTrue(validador.validarSenha("Senha123"), "Senha com letras e números deve ser válida");
    }

    @Test
    @DisplayName("Deve retornar falso para senha com menos de 8 caracteres")
    void testSenhaMuitoCurta() {
        assertFalse(validador.validarSenha("Ab123"), "Senha com menos de 8 caracteres deve ser inválida");
    }

    @Test
    @DisplayName("Deve retornar falso para senha que não contém números")
    void testSenhaSemNumeros() {
        assertFalse(validador.validarSenha("SenhaApenasLetras"), "Senha sem números deve ser inválida");
    }

    @Test
    @DisplayName("Deve retornar falso para senha que não contém letras")
    void testSenhaSemLetras() {
        assertFalse(validador.validarSenha("123456789"), "Senha apenas com números deve ser inválida");
    }

    @Test
    @DisplayName("Deve retornar falso para senha nula")
    void testSenhaNula() {
        assertFalse(validador.validarSenha(null), "Senha nula deve ser inválida");
    }
}