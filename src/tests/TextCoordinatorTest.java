package tests;

import keyboard_teacher.TextCoordinator;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

class TextCoordinatorTest {

    @Test
    void howManyCharacters() {
        assertEquals(7, TextCoordinator.howManyCharacters("Allegro"));
        assertEquals(23, TextCoordinator.howManyCharacters("summer e-xperience 2019"));

    }
    @Test
    void indexOfMistake() {
        assertEquals(0, TextCoordinator.indexOfMistake("ALLEGRO", ""));
        assertEquals(3, TextCoordinator.indexOfMistake("ALLEGRO", "ALLLEGRO"));
        assertEquals(5, TextCoordinator.indexOfMistake("ALLEGRO", "ALLEG"));
        assertEquals(7, TextCoordinator.indexOfMistake("ALLEGRO", "ALLEGROS"));
        assertEquals(0, TextCoordinator.indexOfMistake("ALLEGRO", "R"));
        //assertEquals(TextCoordinator.indexOfMistake());
    }
}