/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pooaula1;

import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author aluno
 */
public class Pessoa {
    String nome;
    Date datNascimento;
    
    int calcularIdade(){
       Calendar dataNasc =  Calendar.getInstance();
       dataNasc.setTime(datNascimento);
       
       Calendar hoje = Calendar.getInstance();
       hoje.getTime();
       
       int idade = hoje.get(Calendar.YEAR) - dataNasc.get(Calendar.YEAR);
       
       dataNasc.add(Calendar.YEAR, idade);
       
       if(hoje.before(dataNasc)){
           idade --;
         
       }
       
       return idade;
    }
    String imprimir(){
        return "Nome: " + nome + "\nIdade: " + calcularIdade();
    }
    
}
