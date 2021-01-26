package ru.job4j.stream;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class FlatMatrixTest {

    @Test
    public void listFromArray() {
        FlatMatrix flatMatrix = new FlatMatrix();
        Integer[][] matrix = new Integer[][]{
                {1, 2},
                {3, 4},
                {5, 6}
        };
        List<Integer> expected = Arrays.asList(1, 2, 3, 4, 5, 6);
        assertThat(flatMatrix.listFromArray(matrix), is(expected));
    }
}