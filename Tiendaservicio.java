/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tiendaservicio;
import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 *
 * @author Eddy
 */
public class Tiendaservicio {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        BufferedReader leer = new BufferedReader(new InputStreamReader(System.in));
        
        int numcompras=0,montocompra=0,codcompra=0,puntosacum=0,decision=0,puntosplata=0,compraspuntos=0,puntoscompra=0;
        boolean estado=true;
        
        do{
            System.out.println("Ingrese el número de compras a realizar: ");
            try{
                numcompras = Integer.parseInt(leer.readLine());
                estado=true;
                if(numcompras<0){
                    System.out.println("El número ingresado no es válido");
                    System.out.println("Ingrese nuevamente");
                }
            }catch(Exception e){
                estado = false;
                System.out.println("Los datos ingresados no son válidos");
                System.out.println("Intente nuevamente");
            }
        }while(numcompras<0||estado==false);
        
        for (int i = 0; i < numcompras; i++) {
            
            System.out.println("");
            System.out.println("Compra n°: "+(i+1));
            System.out.println("");
            do{
                System.out.println("Ingrese el monto de la compra");
                try{
                    montocompra = Integer.parseInt(leer.readLine());
                    estado=true;
                    if(montocompra<0){
                        System.out.println("El monto ingresado no es válido");
                        System.out.println("Ingrese nuevamente");
                    }
                }catch(Exception e){
                    estado = false;
                    System.out.println("Los datos ingresados no son válidos");
                    System.out.println("Ingrese nuevamente");
                }
            }while(montocompra<0||estado==false);
            
            do{
                System.out.println("Ingrese el código de la compra");
                try{
                    codcompra=Integer.parseInt(leer.readLine());
                    estado=true;
                    if(codcompra<100||codcompra>=300){
                        System.out.println("El código Ingresado no es válido");
                        System.out.println("Ingréselo nuevamente");
                    }
                }catch(Exception e){
                    estado=false;
                    System.out.println("Los datos ingresados no son válidos");
                    System.out.println("Ingrese nuevamente");
                }
            }while(codcompra<100||codcompra>=300||estado==false);
            
            puntosplata=puntosacum*10;
            
            System.out.println("Usted tiene: "+(puntosacum)+" puntos actualmente, equivalentes a "+(puntosplata)+" pesos.");
            
            if(puntosplata>=montocompra){
                do{
                    System.out.println("¿Cómo desea pagar?");
                    System.out.println("1 - Con puntos");
                    System.out.println("2 - Con efectivo");
                    try{
                        decision=Integer.parseInt(leer.readLine());
                        estado=true;
                        if(decision>2||decision<1){
                            System.out.println("El número ingresado no es válido");
                            System.out.println("Ingrese nuevamente");
                        }
                    }catch(Exception e){
                        estado=false;
                        System.out.println("Los datos ingresados no son válidos");
                        System.out.println("Ingrese nuevamente");
                    }
                }while(decision>2||decision<1||estado==false);
                
                if(decision==1){
                    puntosplata=puntosplata-montocompra;
                    puntosacum=puntosplata/10;
                    compraspuntos++;
                    System.out.println("En esta compra usted no ha acumulado puntos");
                    System.out.println("Y su saldo actual es: "+puntosacum+" puntos");
                }else{
                    if(codcompra>=100&&codcompra<200){
                        if(montocompra<10000){
                            puntoscompra = (montocompra/100);
                            puntosacum = puntosacum + puntoscompra;
                        }else{
                            puntoscompra = montocompra/50;
                            puntosacum = puntosacum + puntoscompra;
                        }
                    }else{
                        if(montocompra<10000){
                            puntoscompra = montocompra/50;
                            puntosacum = puntosacum + puntoscompra;
                        }else{
                            puntoscompra = montocompra/30;
                            puntosacum = puntosacum + puntoscompra;
                        }
                    }
                    System.out.println("");
                    System.out.println("Con el monto de esta compra usted a acumulado: "+puntoscompra+" puntos");
                    System.out.println("");
                    System.out.println("En total tiene: "+puntosacum + " puntos");
                }
                
                
                
            }else{
                System.out.println("Sus puntos son insuficientes para cancelar este pago");
                System.out.println("");
                System.out.println("Debe pagar con efectivo ");
                
                if(codcompra>=100&&codcompra<200){
                        if(montocompra<10000){
                            puntoscompra = (montocompra/100);
                            puntosacum = puntosacum + puntoscompra;
                        }else{
                            puntoscompra = montocompra/50;
                            puntosacum = puntosacum + puntoscompra;
                        }
                    }else{
                        if(montocompra<10000){
                            puntoscompra = montocompra/50;
                            puntosacum = puntosacum + puntoscompra;
                        }else{
                            puntoscompra = montocompra/30;
                            puntosacum = puntosacum + puntoscompra;
                        }
                    }
                System.out.println("");
                System.out.println("Con el monto de esta compra usted a acumulado: "+puntoscompra+" puntos");
                System.out.println("");
                System.out.println("En total tiene: "+puntosacum+" puntos");
            }
        }
        System.out.println("");
        System.out.println("Ha finalizado el número de compras ");
        System.out.println("");
        System.out.println("Usted ha realizado: "+compraspuntos+" compras con puntos.");
        System.out.println("");
        System.out.println("Y su saldo final es : "+puntosacum+" puntos.");
    
    }
}