/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package caneta;

/**
 *
 * @author marco-silva
 */
public class Caneta {

    private String modelo;
    private String cor;
    private double ponta;
    private int carga;
    private boolean tampada;
    
    /**
     *
     * @param modelo
     * @param cor
     * @param ponta
     * @param carga
     */
    public Caneta(String modelo, String cor, double ponta, int carga){
        this.modelo = modelo;
        this.cor = cor;
        this.ponta = ponta;
        this.carga = carga;
        this.tampada = true; //Caneta é criada inicialmente tampada
    }
    
    public void escrever(){
        if(this.tampada){
          System.out.println("Erro! Não é possivel escrever com a caneta tampada");
        }else if(this.carga <= 0){
           System.out.println("Erro! Caneta sem carga");
        }else{
            System.out.println("Escrevendo com a caneta" + this.cor + " e ponta " + this.ponta);
            this.carga--;
        }
    }
    
    public void rabiscar(){
        if(this.tampada){
            System.out.println("Erro! Não é possivel rabiscar com a caneta tampada");
        }else if(this.carga <= 0){
            System.out.println("Erro! caneta sem carga");
        }else{
            System.out.println("Rabiscando com a caneta" + this.cor + " e ponta " + this.ponta);
            this.carga--;
        }
    }    
    
    public void pintar(){
        if(this.tampada){
            System.out.println("Erro! Não é possível pintar com a caneta tampada");
        }else if(this.carga <= 0){
            System.out.println("Erro! Caneta sem carga");
        }else{
            System.out.println("Pintando com a caneta" +this.cor+ " e ponta " +this.ponta);
            this.carga--;
        }
        
    }    
    
    public void tampar(){
        this.tampada = true;
    }
    
    public void destampar(){
        this.tampada = false;
    }
    
    public String getModelo(){
        return this.modelo;
    }
    
    public String getCor(){
        return this.cor;
    }
    
    public double getPonta(){
        return this.ponta;
    }
    
    public int getCarga(){
        return this.carga;
    }
    
    public boolean isTampada(){
        return this.tampada;
    }

    public static void main(String[] args) {
        Caneta minhaCaneta = new Caneta("Bic", " Azul", 0.5, 100);
        minhaCaneta.destampar();
        minhaCaneta.escrever();
        minhaCaneta.rabiscar();
        minhaCaneta.pintar();
        minhaCaneta.tampar();
        minhaCaneta.escrever();
    }
    
}
