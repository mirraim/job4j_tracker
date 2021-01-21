package ru.job4j.lambda;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class FuncCalcTest {
    @Test
    public void whenLinearFunctionThenLinearResults() {
        FuncCalc function = new FuncCalc();
        List<Double> result = function.diapason(5, 8, x -> 2 * x + 1);
        List<Double> expected = Arrays.asList(11D, 13D, 15D);
        assertThat(result, is(expected));
    }

    @Test
    public void whenQuatroFunctionThenQuatroResults() {
        FuncCalc function = new FuncCalc();
        List<Double> result = function.diapason(4, 7, x -> x * x - 2 * x + 1);
        List<Double> expected = Arrays.asList(9D, 16D, 25D);
        assertThat(result, is(expected));
    }

    @Test
    public void whenDegreeFunctionThenDegreeResults() {
        FuncCalc function = new FuncCalc();
        List<Double> result = function.diapason(5, 8, x -> Math.pow(x, x - 5));
        List<Double> expected = Arrays.asList(1D, 6D, 49D);
        assertThat(result, is(expected));
    }
}