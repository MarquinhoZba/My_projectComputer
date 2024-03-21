/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package testand;



import testand.Pessoa;
import java.util.logging.Logger;
import java.util.logging.Level;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Scanner;


/**
 * 
 * @author marquinhoz
 */
public class Principal {
    
    public static void main(String[] args){
        Pessoa p = new Pessoa();
        Scanner teclado = new Scanner(System.in);
        loop: do{
                    System.out.println("\nInforme o nome: ");
                    p.nome = teclado.next();
                    if(p.nome.equalsIgnoreCase("Sair")){
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
                    dataNasc.setTime( p.datNascimento);
                    Calendar hoje = Calendar.getInstance();
                    hoje.getTime();
                    if(hoje.after(dataNasc)){
                        erro = false;
                    }
                } catch (ParseException ex){
                    System.out.println("Data inválida: " + dataText);
                    Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
                }
            }while(erro);
            //Imprimir os dados solicitados
            System.out.println(p.imprimir());
        }while(true);
        
    }
}
