/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pooaula1;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Scanner;
import java.util.logging.Level;
import static java.util.logging.Level.SEVERE;
import java.util.logging.Logger;

/**
 *
 * @author aluno
 */
public class Principal {
   public static void main (String[] args){
       Pessoa p = new Pessoa();
       
       Scanner teclado = new Scanner(System.in);
       
       do{
           System.out.println("Informe o nome: ");
           p.nome = teclado.next();
           if(p.nome.equalsIgnoreCase("sair")){
               break;
           }
           boolean erro = true;
           do{
               System.out.println("Informe a data de nascimento: ");
               String dataText = teclado.next();
               
               SimpleDateFormat formatoData = new SimpleDateFormat("dd/MM/yyyy");
               formatoData.setLenient(false);
               
               try{
                   p.datNascimento = formatoData.parse(dataText);
                   Calendar dataNasc = Calendar.getInstance();
                   dataNasc.setTime(p.datNascimento);
                   Calendar hoje = Calendar.getInstance();
                   hoje.getTime();
                   if(hoje.after(dataNasc)){
                       erro = false;
                   }
               }catch (ParseException ex){
                   System.out.println("Data invalida: " + dataText);
                   Logger.getLogger(Principal.class.getName()).log(Level,SEVERE, null, ex);
               }
           }while(erro);
           
           System.out.println(p.imprimir());
           
       }while(true);
   }
    
}
