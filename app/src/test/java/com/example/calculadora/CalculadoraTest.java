package com.example.calculadora;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class CalculadoraTest {

    private Calculadora sut;

    @Before
    public void setUp() {
        sut = new Calculadora();
    }

    @Test
    public void operaTest(){
        sut.setOper1(2.0);
        sut.setOper2(3.0);
        sut.setOperacion(Calculadora.OPERACION.RESTA);

        assertEquals(-2.0, sut.opera(), 0.001);
    }
}
