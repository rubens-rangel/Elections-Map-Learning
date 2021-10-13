package Application;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {

        String path = "C:\\Users\\ruben\\OneDrive\\Área de Trabalho\\java_files\\in.csv";
        File file = new File(path);
        Scanner sc = null;
        int i = 0;
        String[] object = null;

        Map<String, Double> votacao = new HashMap<>();


        try (BufferedReader br = new BufferedReader(new FileReader(path))) {

            String line = br.readLine();

            while (line != null) {
                object = line.split(";");
                votacao.put(object[0] , Double.parseDouble(object[1]));
                line = br.readLine();
            }


           // for (String voto : votacao.keySet()) {
                System.out.println("Alex Blue " + votacao.get("Alex Blue"));  // falta somar os votos//
                System.out.println("Bob Brown " + votacao.get("Bob Brown"));  // falta somar os votos//
                System.out.println("Maria Green " + votacao.get("Maria Green"));  // falta somar os votos//
           // }


        } catch (IOException e) {
            System.out.println("File not found or can't be read");

        } catch (NoSuchElementException b) {

            System.out.println("!!!!ERROR!!!!");

        } finally {

            if (sc != null) {
                sc.close();
            }
        }
    }
}