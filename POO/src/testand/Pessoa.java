/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package testand;

import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author marquinhoz
 */
public class Pessoa {
    String nome;
    Date datNascimento;
    
    int calcularIdade(){
    
    Calendar dataNasc = Calendar.getInstance();
    dataNasc.setTime(datNascimento);
    
    Calendar hoje = Calendar.getInstance();
    hoje.getTime();
    
    int idade = hoje.get(Calendar.YEAR) - dataNasc.get(Calendar.YEAR);
    
    dataNasc.add(Calendar.YEAR, idade);
    
    if(hoje.before(dataNasc)){
        idade--;
    }
    
    return idade;
   }
    
   String imprimir(){
       return "Nome: " + nome + "\nIdade: " + calcularIdade();
   } 
}
