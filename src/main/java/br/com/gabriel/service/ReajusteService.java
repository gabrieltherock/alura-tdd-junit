package br.com.gabriel.service;

import br.com.gabriel.modelo.Desempenho;
import br.com.gabriel.modelo.Funcionario;

import java.math.BigDecimal;

public class ReajusteService {

    public void concederReajuste(Funcionario funcionario, Desempenho desempenho) {
        BigDecimal reajuste;

        switch (desempenho) {
            case A_DESEJAR:
                reajuste = funcionario.getSalario().multiply(new BigDecimal("0.03"));
                break;
            case BOM:
                reajuste = funcionario.getSalario().multiply(new BigDecimal("0.15"));
                break;
            case OTIMO:
                reajuste = funcionario.getSalario().multiply(new BigDecimal("0.20"));
                break;
            default:
                return;
        }

        funcionario.reajustarSalario(reajuste);
    }
}
