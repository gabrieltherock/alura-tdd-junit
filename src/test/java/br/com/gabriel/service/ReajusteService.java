package br.com.gabriel.service;

import br.com.gabriel.modelo.Funcionario;

import java.math.BigDecimal;

public class ReajusteService {

    public void concederReajuste(Funcionario funcionario, Desempenho desempenho) {
        BigDecimal reajuste = null;

        if (desempenho == Desempenho.A_DESEJAR)
            reajuste = funcionario.getSalario().multiply(new BigDecimal("0.03"));

        funcionario.reajustarSalario(reajuste);
    }
}
