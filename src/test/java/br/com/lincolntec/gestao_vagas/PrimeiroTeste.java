package br.com.lincolntec.gestao_vagas;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class PrimeiroTeste {

    private static int RESULT_SUM = 5;

    @Test
    public void deve_ser_possivel_calcular_dois_numeros() {
        var result = calculate( 2, 3);
        assertEquals(result, RESULT_SUM);

    }

    public static int calculate(int num1, int num2) {
        return num1 + num2;
    }
    
}
