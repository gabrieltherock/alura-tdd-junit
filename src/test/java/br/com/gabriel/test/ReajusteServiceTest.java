package br.com.gabriel.test;

import br.com.gabriel.modelo.Desempenho;
import br.com.gabriel.modelo.Funcionario;
import br.com.gabriel.service.ReajusteService;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class ReajusteServiceTest {

    @ParameterizedTest
    @MethodSource("desempenhoESalarioEsperadoSource")
    void reajustesCorretosParaTodosOsDesempenhos(Desempenho desempenho, String salarioEsperado) {
        ReajusteService service = new ReajusteService();
        Funcionario funcionario = new Funcionario("Gabriel", LocalDate.now(), new BigDecimal("1000"));

        service.concederReajuste(funcionario, desempenho);

        assertEquals(new BigDecimal(salarioEsperado), funcionario.getSalario());
    }

    static Stream<Arguments> desempenhoESalarioEsperadoSource() {
        return Stream.of(
                arguments(Desempenho.A_DESEJAR, "1030.00"),
                arguments(Desempenho.BOM, "1150.00"),
                arguments(Desempenho.OTIMO, "1200.00")
        );
    }
}
