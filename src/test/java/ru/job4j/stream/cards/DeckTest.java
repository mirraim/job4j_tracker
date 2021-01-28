package ru.job4j.stream.cards;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class DeckTest {

    @Test
    public void generate() {
        Deck deck = new Deck();
        List<String> expected = Arrays.asList(
                "Diamonds V_6",
                "Diamonds V_7",
                "Diamonds V_8",
                "Hearts V_6",
                "Hearts V_7",
                "Hearts V_8",
                "Spades V_6",
                "Spades V_7",
                "Spades V_8",
                "Clubs V_6",
                "Clubs V_7",
                "Clubs V_8"
        );
        assertThat(deck.generate(), is(expected));
    }
}