package com.practica.cajanegra;

import com.cajanegra.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

public class UtilidadesTest {

    private SingleLinkedListImpl<Character> lista;

    @BeforeEach
    public void inicio(){
        lista = new SingleLinkedListImpl<>('A', 'B', 'C', 'D', 'E');
    }

     /* ####################################################################
     *  ###                        TEST isEmpty                          ###
     *  #################################################################### */

     private static Stream<Arguments> isEmpty_listaVaciaParams(){
         List<Arguments> args = new LinkedList<>();
         args.add(Arguments.of(new SingleLinkedListImpl<>('X', 'A', 'B', 'C', 'D', 'E')));
         args.add(Arguments.of(new SingleLinkedListImpl<>('A', 'B', 'X')));
         args.add(Arguments.of(new SingleLinkedListImpl<>('A', 'B')));
         args.add(Arguments.of(new SingleLinkedListImpl<>('A')));
         args.add(Arguments.of(new SingleLinkedListImpl<>()));

         return args.stream();
     }
    @ParameterizedTest
    @MethodSource("isEmpty_listaVaciaParams")
    public void isEmpty_listaVaciaTest(SingleLinkedListImpl<Character> lista){
         assertTrue(lista.isEmpty());
    }

}
