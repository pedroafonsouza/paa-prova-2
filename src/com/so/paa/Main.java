package com.so.paa;


import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Random;

import static com.sun.activation.registries.LogSupport.log;


public class Main {

    public static ArrayList<Integer> list = new ArrayList<>();
    public static int arr[];

    public static Long startTime;
    public static Long endTime;
    public static int listCount = 0;
    public static int vectorSize = 0;
    public static MethodEnum selectedMethod;
    public static TypeVectorEnum typeVectorEnum;


    public static void main(String[] args) {


        printInfo();
        readLine();
        switchAlgorithm();
        writeOutput();


    }


    private static void randomVectorOutput() {

        try {
            PrintWriter writer = new PrintWriter("vector.txt", "UTF-8");
            for (int i = 0; i < 1000000; i++) {

                Random random = new Random();
                writer.println(random.nextInt(2000000));
            }
            writer.close();

        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    private static void writeOutput() {

        try {

            PrintWriter writer = new PrintWriter("Resposta.txt", "UTF-8");
            writer.println("Tipo de Ordenação: " + typeVectorEnum);
            writer.println("Tamanho do vetor:  " + vectorSize);
            writer.println("Método:            " + selectedMethod);
            writer.println("Comparações:       " + Details.comp);
            writer.println("Movimentos         " + Details.mov);
            writer.println("Tempo:             " + Details.time);
            writer.close();

        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    public static void switchAlgorithm() {


        switch (selectedMethod) {
            case INSERT:
                SortMethod.insertionSort(arr);
                break;
            case MERGE:
                SortMethod.mergeSort(arr);
                break;
            case SELECT:
                SortMethod.selectionSort(arr);
                break;
        }

    }

    public static void printInfo() {
//        System.out.println("Trabalho 1 - Sistemas Operacionais");
//        System.out.println("Projeto: Algoritmos de Escalonamento de CPU");
//        System.out.println("Professor: Gabriel Novy");
//        System.out.println("Autor: Pedro Afonso Ramos de Souza");
//        System.out.println("IFMG - SABARÁ");
//        System.out.println("Curso: Sistemas de Informação");
    }


    public static void readLine() {

        int i = 0;

        try {
            for (String line : Files.readAllLines(Paths.get("Entrada.txt"))) {

                if (line.isEmpty()) {
                    i++;
                    continue;
                }

                if (i == 0) {
                    selectedMethod = MethodEnum.valueOf(line.toUpperCase());
                } else if (i == 1) {
                    vectorSize = Integer.parseInt(line);
                } else if (i == 2) {
                    typeVectorEnum = TypeVectorEnum.valueOf(line.toUpperCase());
                } else {
                    list.add(Integer.valueOf(line));
                }


                i++;
            }
            arr = list.stream().mapToInt(element -> element).toArray();

        } catch (IOException e) {
            e.printStackTrace();

            PrintWriter writer = null;
            try {
                writer = new PrintWriter("Resposta.txt", "UTF-8");
            } catch (FileNotFoundException ex) {
                ex.printStackTrace();
            } catch (UnsupportedEncodingException ex) {
                ex.printStackTrace();
            }
            writer.println("Falha na leitura do arquivo, verifique a formatação, salve e execute o programa novamente");

            writer.close();
        }

    }


}
