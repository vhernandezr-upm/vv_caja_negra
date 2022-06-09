package com.practica.cajanegra;

import com.cajanegra.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

public class InsercionTest {


    private SingleLinkedListImpl<Character> lista;

    @BeforeEach
    public void inicio(){
        lista = new SingleLinkedListImpl<>('A', 'B', 'C', 'D', 'E');
    }

    /* ####################################################################
    *  ###                        TEST addAtPos                         ###
    *  #################################################################### */

    @ParameterizedTest
    @CsvSource({
            "'@', 0",
            "'A', 0",
            "'B', 0",
            "'M', 0",
            "'Y', 0",
            "'Z', 0",
            "'[', 0",

            "@,	1",
            "[,	1",
            "@,	2",
            "[,	2",
            "@,	3",
            "[,	3",
            "@,	5",
            "[,	5",
            "@,	6",
            "[,	6"
    })
    public void addAtPos_elementoValidoTest(char element, int p) { // Comprobar elementos dentro y fuera del dominio
        assertThrows(IllegalArgumentException.class, () -> lista.addAtPos(element, p));
    }

    @ParameterizedTest
    @CsvSource({
            "'M', 0",
            "'M', 1",
            "'M', 2",
            "'M', 3",
            "'M', 4",
            "'M', 5",
            "'M', 6"
    })
    public void addAtPos_posicionValidaTest(char element, int p){ // Comprobar posición dentro y fuera del rango válido.
        assertThrows(IllegalArgumentException.class, () -> lista.addAtPos(element, p));
    }

    private static Stream<Arguments> addAtPos_insercionCorrectaParams(){
        List<Arguments> args = new LinkedList<>();
        args.add(Arguments.of('X', 1, new SingleLinkedListImpl<>('X', 'A', 'B', 'C', 'D', 'E')));
        args.add(Arguments.of('X', 3, new SingleLinkedListImpl<>('A', 'B', 'X', 'C', 'D', 'E')));
        args.add(Arguments.of('X', 5, new SingleLinkedListImpl<>('A', 'B', 'C', 'D', 'X', 'E')));
        args.add(Arguments.of('X', 6, new SingleLinkedListImpl<>('A', 'B', 'C', 'D', 'E', 'X')));
        args.add(Arguments.of('X', 10, new SingleLinkedListImpl<>('A', 'B', 'C', 'D', 'E', 'X')));

        return args.stream();
    }
    @ParameterizedTest
    @MethodSource("addAtPos_insercionCorrectaParams")
    public void addAtPos_insercionCorrectaTest(char element, int p, SingleLinkedListImpl<Character>esperada){ // Comprobar si se añade elemento correctamente.
        lista.addAtPos(element, p);
        assertIterableEquals(esperada, lista);
    }

}
