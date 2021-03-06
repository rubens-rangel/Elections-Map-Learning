package Application;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedHashMap;
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

        Map<String, Integer> votacao = new LinkedHashMap<>();


        try (BufferedReader br = new BufferedReader(new FileReader(path))) {

            String line = br.readLine();

            while (line != null) {
                object = line.split(";");
                String nome = object[0];
                int votos = Integer.parseInt(object[1]);

                if (votacao.containsKey(nome)) {
                    int novovoto = votacao.get(nome);
                    votacao.put(nome, votos + novovoto);
                } else {
                    votacao.put(nome, votos);
                }
                line = br.readLine();
            }
            for (String key : votacao.keySet()) {
                System.out.println(key + " " + votacao.get(key));
            }
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