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
import java.util.NoSuchElementException;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

public class BorradoTest {

    private SingleLinkedListImpl<Character> lista;
    private SingleLinkedListImpl<Character> listaRepetidos;

    @BeforeEach
    public void inicio(){
        lista = new SingleLinkedListImpl<>('A', 'B', 'C', 'D', 'E');
        listaRepetidos = new SingleLinkedListImpl<>('A', 'B', 'A', 'C', 'C', 'B', 'A');
    }

     /* ####################################################################
     *  ###                        TEST removeLast                       ###
     *  #################################################################### */

    private static Stream<Arguments> removeLast_listaVaciaParams(){
        List<Arguments> args = new LinkedList<>();
        args.add(Arguments.of(new SingleLinkedListImpl<>('A', 'B', 'C', 'D', 'E')));
        args.add(Arguments.of(new SingleLinkedListImpl<>('A', 'B', 'X')));
        args.add(Arguments.of(new SingleLinkedListImpl<>('A', 'B')));
        args.add(Arguments.of(new SingleLinkedListImpl<>('A')));
        args.add(Arguments.of(new SingleLinkedListImpl<>()));

        return args.stream();
    }
    @ParameterizedTest
    @MethodSource("removeLast_listaVaciaParams")
    public void removeLast_listaVaciaTest(SingleLinkedListImpl<Character> lista){
        assertThrows(EmptyCollectionException.class, () -> lista.removeLast());
    }

    private static Stream<Arguments> removeLast_tamanoCorrectoParams(){
        List<Arguments> args = new LinkedList<>();
        args.add(Arguments.of(new SingleLinkedListImpl<>('A', 'B', 'C', 'D', 'E'), new SingleLinkedListImpl<>('A', 'B', 'C', 'D')));
        args.add(Arguments.of(new SingleLinkedListImpl<>('A', 'B', 'X'), new SingleLinkedListImpl<>('A', 'B')));
        args.add(Arguments.of(new SingleLinkedListImpl<>('A', 'B'), new SingleLinkedListImpl<>('A')));
        args.add(Arguments.of(new SingleLinkedListImpl<>('A'), new SingleLinkedListImpl<>()));

        return args.stream();
    }
    @ParameterizedTest
    @MethodSource("removeLast_tamanoCorrectoParams")
    public void removeLast_tamanoCorrectoTest(SingleLinkedListImpl<Character> lista, SingleLinkedListImpl<Character> esperada) throws EmptyCollectionException {
        lista.removeLast();
        assertIterableEquals(esperada, lista);
    }

    private static Stream<Arguments> removeLast_caracterEliminadoCorrectoParams(){
        List<Arguments> args = new LinkedList<>();
        args.add(Arguments.of(new SingleLinkedListImpl<>('A', 'B', 'C', 'D', 'E'),'E'));
        args.add(Arguments.of(new SingleLinkedListImpl<>('A', 'B', 'X'), 'X'));
        args.add(Arguments.of(new SingleLinkedListImpl<>('A', 'B'), 'B'));
        args.add(Arguments.of(new SingleLinkedListImpl<>('A'), 'A'));

        return args.stream();
    }
    @ParameterizedTest
    @MethodSource("removeLast_caracterEliminadoCorrectoParams")
    public void removeLast_caracterEliminadoCorrectoTest(SingleLinkedListImpl<Character> lista, char esperado) throws EmptyCollectionException {
        assertEquals(esperado, lista.removeLast());
    }

     /* ####################################################################
     *  ###                        TEST removeLast(params)               ###
     *  #################################################################### */
     private static Stream<Arguments> removeLast2_listaVaciaParams(){
         List<Arguments> args = new LinkedList<>();
         args.add(Arguments.of(new SingleLinkedListImpl<>('A', 'B', 'C', 'D', 'E')));
         args.add(Arguments.of(new SingleLinkedListImpl<>('A', 'B', 'X')));
         args.add(Arguments.of(new SingleLinkedListImpl<>('A', 'B')));
         args.add(Arguments.of(new SingleLinkedListImpl<>('A')));
         args.add(Arguments.of(new SingleLinkedListImpl<>()));

         return args.stream();
     }
    @ParameterizedTest
    @MethodSource("removeLast2_listaVaciaParams")
    public void removeLast2_listaVaciaTest(SingleLinkedListImpl<Character> lista){
        assertThrows(EmptyCollectionException.class, () -> lista.removeLast('A'));
    }

    @ParameterizedTest
    @MethodSource("removeLast2_listaVaciaParams")
    public void removeLast2_paramIncorrectoTest(SingleLinkedListImpl<Character> lista){
        assertThrows(NoSuchElementException.class, () -> lista.removeLast('M'));
    }
    private static Stream<Arguments> removeLast2_tamanoCorrectoParams(){
        List<Arguments> args = new LinkedList<>();
        args.add(Arguments.of(new SingleLinkedListImpl<>('A', 'B', 'C', 'D', 'E'), new SingleLinkedListImpl<>('A', 'B', 'D', 'E'), 'C'));
        args.add(Arguments.of(new SingleLinkedListImpl<>('A', 'B', 'C', 'D', 'E'), new SingleLinkedListImpl<>('B', 'C', 'D', 'E'), 'A'));
        args.add(Arguments.of(new SingleLinkedListImpl<>('A', 'B', 'C', 'D', 'E'), new SingleLinkedListImpl<>('A', 'B', 'C', 'D'), 'E'));
        args.add(Arguments.of(new SingleLinkedListImpl<>('A', 'B', 'X'), new SingleLinkedListImpl<>('B', 'X'), 'A'));
        args.add(Arguments.of(new SingleLinkedListImpl<>('A', 'B'), new SingleLinkedListImpl<>('A'), 'B'));
        args.add(Arguments.of(new SingleLinkedListImpl<>('A'), new SingleLinkedListImpl<>(), 'A'));

        return args.stream();
    }
    @ParameterizedTest
    @MethodSource("removeLast2_tamanoCorrectoParams")
    public void removeLast2_tamanoCorrectoTest(SingleLinkedListImpl<Character> lista, SingleLinkedListImpl<Character> esperada, char elem) throws EmptyCollectionException {
        lista.removeLast(elem);
        assertIterableEquals(esperada, lista);
    }

    private static Stream<Arguments> removeLast2_caracterEliminadoCorrectoParams(){
        List<Arguments> args = new LinkedList<>();
        args.add(Arguments.of(new SingleLinkedListImpl<>('A', 'B', 'C', 'D', 'E'),'C'));
        args.add(Arguments.of(new SingleLinkedListImpl<>('A', 'B', 'X'), 'X'));
        args.add(Arguments.of(new SingleLinkedListImpl<>('A', 'B'), 'B'));
        args.add(Arguments.of(new SingleLinkedListImpl<>('A', 'B'), 'A'));

        return args.stream();
    }
    @ParameterizedTest
    @MethodSource("removeLast2_caracterEliminadoCorrectoParams")
    public void removeLast2_caracterEliminadoCorrectoTest(SingleLinkedListImpl<Character> lista, char esperado) throws EmptyCollectionException {
        assertEquals(esperado, lista.removeLast(esperado));
    }

}
