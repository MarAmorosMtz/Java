/*
Realizar un soo para simular la carrera de tres caballos
todos inician al inicio de pantalla y de forma aleatoria deben avanzar y se
debe imprimir su avance hasta que el primer caballo llegue a la derecha de la pantalla
caballo 1 tendrá la figura C1
caballo 2 tendrá la figura C2
caballo 3 tendrá la figura C3
imprimir ganador
esperar 2 segundos entre impresiones
*/
import java.lang.Thread;
public class Clase19 {
    public static void main(String[] args) {
        Caballo caballo1 = new Caballo("Caballo1", "C1");
        Caballo caballo2 = new Caballo("Caballo2", "C2");
        Caballo caballo3 = new Caballo("Caballo3", "C3");
        String salida, ganador="\u001B[33m ", rojo = "\u001B[31m", azul = "\u001B[34m", verde = "\u001B[32m", blanco = "\u001B[37m", amarillo = "\u001B[33m";
        boolean fin = false;
        int i, meta=140;
        System.out.println("\033[H\033[2J");
        salida = caballo1.avanzar(0);
        System.out.println(azul+salida);
        salida = caballo2.avanzar(0);
        System.out.println(verde+salida);
        salida = caballo3.avanzar(0);
        System.out.println(rojo+salida+blanco);
        System.out.println("El primero en llegar a "+amarillo+"140"+blanco+" gana");
        System.out.print("La carrera comienza en ");
        for(i=3;i>=1;i--){
            System.out.print(i+" ");
            try{
                Thread.sleep(1000);
            }catch(Exception e){
                System.out.println(e);
            }            
        }
        System.out.println("\033[H\033[2J");
        do{
            salida = caballo1.avanzar();
            System.out.println(azul+salida);
            salida = caballo2.avanzar();
            System.out.println(verde+salida);
            salida = caballo3.avanzar();
            System.out.println(rojo+salida);
            System.out.println(blanco+"Caballo1  ha avanzado: "+azul+caballo1.getAvance()+blanco+", Caballo2 ha avanzado: "+verde+caballo2.getAvance()+blanco+", Caballo3 ha avanzado: "+rojo+caballo3.getAvance());
            try{
                Thread.sleep(2000);
            }catch(Exception e){
                System.out.println(e);
            }
            
            i++;
            if(caballo1.getAvance()>=140 && caballo2.getAvance()<140 && caballo3.getAvance()<140){
                ganador += "Caballo1";
                fin = true;
            }else{
                if(caballo2.getAvance()>=140 && caballo3.getAvance()<140 && caballo1.getAvance()<140){
                    ganador += "Caballo2";
                    fin = true;
                }else{
                    if(caballo3.getAvance()>=140 && caballo2.getAvance()<140 && caballo3.getAvance()<140){
                        ganador += "Caballo3";
                        fin = true;
                    }else{
                        if(caballo1.getAvance()>=140 && caballo2.getAvance()>=140 && caballo3.getAvance()>=140){
                            ganador += "Empate";
                            fin = true;
                        }else{
                            if(caballo1.getAvance()>=140 && caballo2.getAvance()>=140 && caballo3.getAvance()<140){
                                ganador += "Empate de Caballo1 y Caballo2";
                                fin = true;
                            }else{
                                if(caballo1.getAvance()>=140 && caballo3.getAvance()>=140 && caballo2.getAvance()<140){
                                    ganador += "Empate de Caballo1 y Caballo3";
                                    fin = true;
                                }else{
                                    if(caballo2.getAvance()>=140 && caballo3.getAvance()>=140 && caballo1.getAvance()<140){
                                        ganador += "Empate de Caballo2 y Caballo3";
                                        fin = true;
                                    }else{
                                        System.out.println("\033[H\033[2J");
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }while(fin==false);
        System.out.println(blanco+"El ganador es "+ganador+blanco);
    }
}
