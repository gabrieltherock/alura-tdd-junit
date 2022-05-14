package br.com.gabriel.test;

import br.com.gabriel.modelo.Funcionario;
import br.com.gabriel.service.BonusService;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.math.BigDecimal;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BonusServiceTest {

    @ParameterizedTest
    @CsvSource({
            "25000, 0.00",
            "2500, 250.00",
            "10000, 1000.00"
    })
    void testaTodosOsCenariosDeBonus(String salario, String bonusEsperado) {
        BonusService service = new BonusService();
        BigDecimal bonus = service.calcularBonus(new Funcionario("Gabriel", LocalDate.now(), new BigDecimal(salario)));

        assertEquals(new BigDecimal(bonusEsperado), bonus);
    }
}
