package com.practica.cajanegra;

import com.cajanegra.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.LinkedList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

public class BusquedaTest {

    private SingleLinkedListImpl<Character> lista;
    private SingleLinkedListImpl<Character> listaRepetidos;

    @BeforeEach
    public void inicio(){
        lista = new SingleLinkedListImpl<>('A', 'B', 'C', 'D', 'E');
        listaRepetidos = new SingleLinkedListImpl<>('A', 'B', 'A', 'C', 'C', 'B', 'A');
    }


     /* ####################################################################
     *  ###                        TEST getAtPos                         ###
     *  #################################################################### */

    @ParameterizedTest
    @CsvSource({
            "-1",
            "0",
            "1",
            "3",
            "5",
            "6",
            "7"
    })
    public void getAtPos_posValidaTest(int pos){
        assertThrows(IllegalArgumentException.class, () -> lista.getAtPos(pos));
    }

    @ParameterizedTest
    @CsvSource({
            "1, 'A'",
            "3, 'C'",
            "5, 'E'"
    })
    public void getAtPos_elemAtPosCorrectoTest(int pos, char elemEsperado){
        assertEquals(elemEsperado, lista.getAtPos(pos));
    }

     /* ####################################################################
     *  ###                        TEST indexOf                          ###
     *  #################################################################### */
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
     public void indexOf_elementoValidoTest(char element) {
         assertThrows(IllegalArgumentException.class, () -> lista.indexOf(element));
     }

     @ParameterizedTest
     @CsvSource({
             "'A', 1",
             "'B', 2",
             "'C', 3",
             "'D', 4",
             "'E', 5"
     })
    public void indexOf_indiceCorrectoTest(char elem, int posEsperada){
         assertEquals(posEsperada, lista.indexOf(elem));
     }

    @ParameterizedTest
    @CsvSource({
            "'A', 1",
            "'B', 2",
            "'C', 4"
    })
    public void indexOf_indiceCorrectoRepetidosTest(char elem, int posEsperada){
        assertEquals(posEsperada, listaRepetidos.indexOf(elem));
    }

    @ParameterizedTest
    @CsvSource({
            "'F'",
            "'Z'"
    })
    public void indexOf_noIndiceTest(char elem){
         assertThrows(NoSuchElementException.class, () -> lista.indexOf(elem));
    }

     /* ####################################################################
     *  ###                        TEST isSubList                        ###
     *  #################################################################### */
     private static Stream<Arguments> isSubList_encontrarSublistaParams(){
         List<Arguments> args = new LinkedList<>();
         args.add(Arguments.of(1, new SingleLinkedListImpl<>('A', 'B', 'C', 'D', 'E')));
         args.add(Arguments.of(2, new SingleLinkedListImpl<>('B', 'C', 'D')));
         args.add(Arguments.of(-1, new SingleLinkedListImpl<>('B', 'A', 'D')));
         args.add(Arguments.of(4, new SingleLinkedListImpl<>('D', 'E')));
         args.add(Arguments.of(-1, new SingleLinkedListImpl<>('D', 'E', 'F')));
         args.add(Arguments.of(-1, new SingleLinkedListImpl<>('A', 'C')));
         args.add(Arguments.of(-1, new SingleLinkedListImpl<>('D', 'C')));
         args.add(Arguments.of(1, new SingleLinkedListImpl<>('A')));
         args.add(Arguments.of(5, new SingleLinkedListImpl<>('E')));
         args.add(Arguments.of(0, new SingleLinkedListImpl<>()));
         args.add(Arguments.of(0, null));

         return args.stream();
     }
    @ParameterizedTest
    @MethodSource("isSubList_encontrarSublistaParams")
    public void isSubList_encontrarSublistaTest(int posicionEsperada, SingleLinkedListImpl<Character> part){
        assertEquals(posicionEsperada, lista.isSubList(part));
    }

    private static Stream<Arguments> isSubList_encontrarSublistaElemRepetidosParams(){
        List<Arguments> args = new LinkedList<>();
        args.add(Arguments.of(1, new SingleLinkedListImpl<>('A', 'B', 'A', 'C', 'C', 'B', 'A')));
        args.add(Arguments.of(2, new SingleLinkedListImpl<>('B', 'A', 'C')));
        args.add(Arguments.of(-1, new SingleLinkedListImpl<>('A', 'A', 'C')));
        args.add(Arguments.of(4, new SingleLinkedListImpl<>('C', 'C')));
        args.add(Arguments.of(2, new SingleLinkedListImpl<>('B', 'A')));
        args.add(Arguments.of(1, new SingleLinkedListImpl<>('A', 'B')));
        args.add(Arguments.of(1, new SingleLinkedListImpl<>('A')));
        args.add(Arguments.of(2, new SingleLinkedListImpl<>('B')));
        args.add(Arguments.of(0, new SingleLinkedListImpl<>()));
        args.add(Arguments.of(0, null));

        return args.stream();
    }
    @ParameterizedTest
    @MethodSource("isSubList_encontrarSublistaElemRepetidosParams")
    public void isSubList_encontrarSublistaElemRepetidosTest(int posicionEsperada, SingleLinkedListImpl<Character> part){
        assertEquals(posicionEsperada, listaRepetidos.isSubList(part));
    }

}
