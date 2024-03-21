/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pooaula1;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import static java.time.Clock.system;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Scanner;


/**
 *
 * @author marco-silva
 */
public class Principal {

    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        List<Pessoa> pessoas = new ArrayList<>();
        int pessoasMenor18 = 0;
        int pessoasMaiorouIgual18 = 0;

        do {
            Pessoa p = new Pessoa();
            System.out.println("\nInforme o nome (ou 'Sair' para encerrar): ");
            String nome = teclado.next();
            if (nome.equalsIgnoreCase("Sair")) {
                break;
            }
            p.nome = nome;

            boolean erro = true;
            do {
                System.out.println("Informe a data de nascimento (dd/MM/yyyy): ");
                String dataText = teclado.next();
                try {
                    p.datNascimento = new SimpleDateFormat("dd/MM/yyyy").parse(dataText);
                    Calendar dataNasc = Calendar.getInstance();
                    dataNasc.setTime(p.datNascimento);
                    Calendar hoje = Calendar.getInstance();
                    if (hoje.after(dataNasc)) {
                        erro = false;
                    }
                } catch (ParseException ex) {
                    System.out.println("Data inválida: " + dataText);
                }
            } while (erro);

            pessoas.add(p);
        } while (true);
        
        //Calcular a idade de cada pessoas
        for(Pessoa p: pessoas){
            int idade = calcularIdade(p.datNascimento);
            if(idade < 18){
                pessoasMenor18++;
            }
            else{
                pessoasMaiorouIgual18++;
            }
        }
        //MOSTRAR A PERCENTUAL DAS IDADES
        double percentualMenor18 = (double) pessoasMenor18 / pessoas.size() * 100;
        double percentualMaiorouIgual18 = (double) pessoasMaiorouIgual18 / pessoas.size() * 100;
        
        
        // Mostrar a média das idades
        int somaIdades = 0;
        for (Pessoa p : pessoas) {
            somaIdades += calcularIdade(p.datNascimento);
        }
        double mediaIdades = (double) somaIdades / pessoas.size();
        

        // Mostrar a menor idade
        int menorIdade = Integer.MAX_VALUE;
        for (Pessoa p : pessoas) {
            int idade = calcularIdade(p.datNascimento);
            if (idade < menorIdade) {
                menorIdade = idade;
            }
        }

        // Mostrar quem tem a maior idade e qual é sua idade
        int maiorIdade = Integer.MIN_VALUE;
        Pessoa maisVelho = null;
        for (Pessoa p : pessoas) {
            int idade = calcularIdade(p.datNascimento);
            if (idade > maiorIdade) {
                maiorIdade = idade;
                maisVelho = p;
            }
        }
        
        System.out.println("\nQuantidade de pessoas cadastradas: " + pessoas.size());
        System.out.println("Média das idades: " + mediaIdades);
        System.out.println("Menor idade: " + menorIdade);
        System.out.println("Pessoa mais velha: " + maisVelho.nome + ", idade: " + maiorIdade);
        System.out.println("A percentual de pessoas menores de 18: " + pessoasMenor18 + "%");
        System.out.println("A percentual de pessoas maiores ou igual de 18: " + pessoasMaiorouIgual18 + "%");
    }

    private static int calcularIdade(Date dataNascimento) {
        Calendar nascimento = Calendar.getInstance();
        nascimento.setTime(dataNascimento);
        Calendar hoje = Calendar.getInstance();

        int idade = hoje.get(Calendar.YEAR) - nascimento.get(Calendar.YEAR);
        if (hoje.get(Calendar.MONTH) < nascimento.get(Calendar.MONTH) ||
                (hoje.get(Calendar.MONTH) == nascimento.get(Calendar.MONTH) &&
                        hoje.get(Calendar.DAY_OF_MONTH) < nascimento.get(Calendar.DAY_OF_MONTH))) {
            idade--;
        }
        return idade;
    }

    static class Pessoa {
        String nome;
        Date datNascimento;
    }
}
