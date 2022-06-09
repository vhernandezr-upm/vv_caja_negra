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
    public void addAtPos_insercionCorrectaTest(char element, int p, SingleLinkedListImpl<Character> esperada){ // Comprobar si se añade elemento correctamente.
        lista.addAtPos(element, p);
        assertIterableEquals(esperada, lista);
    }


    /* ####################################################################
     * ###                        TEST addFirst                         ###
     * #################################################################### */

    @ParameterizedTest
    @CsvSource({
            "'@'",
            "'A'",
            "'B'",
            "'M'",
            "'Y'",
            "'Z'",
            "'['",
    })
    public void addFirst_elementoValidoTest(char element){
        assertThrows(IllegalArgumentException.class, () -> lista.addFirst(element));
    }

    private static Stream<Arguments> addFirst_insercionCorrectaParams(){
        List<Arguments> args = new LinkedList<>();
        args.add(Arguments.of('X', new SingleLinkedListImpl<>('A', 'B', 'C'), new SingleLinkedListImpl<>('X', 'A', 'B', 'C')));
        args.add(Arguments.of('X', new SingleLinkedListImpl<>('A'), new SingleLinkedListImpl<>('X', 'A')));
        args.add(Arguments.of('X', new SingleLinkedListImpl<>(), new SingleLinkedListImpl<>('X')));

        return args.stream();
    }
    @ParameterizedTest
    @MethodSource("addFirst_insercionCorrectaParams")
    public void addFirst_insercionCorrectaTest(char element, SingleLinkedListImpl<Character> list, SingleLinkedListImpl<Character> esperada){
        list.addFirst(element);
        assertIterableEquals(esperada, list);
    }

    /* ####################################################################
     * ###                        TEST addLast                          ###
     * #################################################################### */
    @ParameterizedTest
    @CsvSource({
            "'@'",
            "'A'",
            "'B'",
            "'M'",
            "'Y'",
            "'Z'",
            "'['",
    })
    public void addLast_elementoValidoTest(char element){
        assertThrows(IllegalArgumentException.class, () -> lista.addLast(element));
    }

    private static Stream<Arguments> addLast_insercionCorrectaParams(){
        List<Arguments> args = new LinkedList<>();
        args.add(Arguments.of('X', new SingleLinkedListImpl<>('A', 'B', 'C'), new SingleLinkedListImpl<>('A', 'B', 'C', 'X')));
        args.add(Arguments.of('X', new SingleLinkedListImpl<>('A'), new SingleLinkedListImpl<>('A', 'X')));
        args.add(Arguments.of('X', new SingleLinkedListImpl<>(), new SingleLinkedListImpl<>('X')));

        return args.stream();
    }
    @ParameterizedTest
    @MethodSource("addLast_insercionCorrectaParams")
    public void addLast_insercionCorrectaTest(char element, SingleLinkedListImpl<Character> list, SingleLinkedListImpl<Character> esperada){
        list.addLast(element);
        assertIterableEquals(esperada, list);
    }


    /* ####################################################################
     * ###                        TEST addNTimes                        ###
     * #################################################################### */

    @ParameterizedTest
    @CsvSource({
            "'@', 1",
            "'A', 1",
            "'B', 1",
            "'M', 1",
            "'Y', 1",
            "'Z', 1",
            "'[', 1"
    })
    public void addNTimes_elementoValidoTest(char element, int n){
        assertThrows(IllegalArgumentException.class, () -> lista.addNTimes(element, n));
    }

    @ParameterizedTest
    @CsvSource({
            "'M', -2",
            "'M', -1",
            "'M', 0",
            "'M', 1",
            "'M', 4",
            "'M', 10"
    })
    public void addNTimes_NValidoTest(char element, int n){
        assertThrows(IllegalArgumentException.class, () -> lista.addNTimes(element, n));
    }

    private static Stream<Arguments> addNTimes_insercionCorrectaParams(){
        List<Arguments> args = new LinkedList<>();
        args.add(Arguments.of('X', 0, new SingleLinkedListImpl<>('A', 'B', 'C', 'D', 'E')));
        args.add(Arguments.of('X', 1, new SingleLinkedListImpl<>('A', 'B', 'C', 'D', 'E', 'X')));
        args.add(Arguments.of('X', 2, new SingleLinkedListImpl<>('A', 'B', 'C', 'D', 'E', 'X', 'X')));
        args.add(Arguments.of('X', 5, new SingleLinkedListImpl<>('A', 'B', 'C', 'D', 'E', 'X', 'X', 'X', 'X', 'X')));

        return args.stream();
    }
    @ParameterizedTest
    @MethodSource("addNTimes_insercionCorrectaParams")
    public void addNTimes_insercionCorrectaTest(char element, int n, SingleLinkedListImpl<Character> esperada){
        lista.addNTimes(element, n);
        assertIterableEquals(esperada, lista);
    }

}
