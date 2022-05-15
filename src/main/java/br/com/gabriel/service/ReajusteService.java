package br.com.gabriel.service;

import br.com.gabriel.modelo.Desempenho;
import br.com.gabriel.modelo.Funcionario;

import java.math.BigDecimal;

public class ReajusteService {

    public void concederReajuste(Funcionario funcionario, Desempenho desempenho) {
        BigDecimal reajuste = funcionario.getSalario().multiply(desempenho.percentualReajuste());
        funcionario.reajustarSalario(reajuste);
    }
}
