import java.util.ArrayList;
import java.util.Scanner;

public class Menu {
    private ArrayList <String> opciones = new ArrayList<String>();
    Scanner entrada = new Scanner(System.in);
    private int numeroOpciones, i, unidades, decenas, centenas, tipoViñeta,a,suma=0,index=0;
    private String romano="", n, elemento="", titulo, opcion, seleccion, verde = "\u001B[32m", amarillo = "\u001B[33m", cyan = "\u001B[36m", blanco = "\u001B[37m", rojo = "\u001B[31m";
    private char s;
    private boolean numeracion = false;
    public Menu(int tipoViñeta, int numeroOpciones, int opt){
        this.tipoViñeta = tipoViñeta;
        this.numeroOpciones = numeroOpciones;
        numeracion = false;
        for(a=1;a<=this.numeroOpciones;a++){
            switch(this.tipoViñeta){
                case 1:
                    n = toRomano(a);
                    break;
                case 2:
                    n = toRomano(a).toLowerCase();
                    break;
                case 3:
                    n = String.valueOf(toMayus(a));
                    break;
                case 4:
                    n = String.valueOf(toMinus(a));
                    break;
                case 5:
                    numeracion = true;
                    break;              
            }
            opcion = entrada.nextLine();
            if(numeracion == true){
                elemento = amarillo+a+blanco+".- "+opcion;                
            }else{
                elemento = amarillo+n+blanco+".- "+opcion;                
            }            
            opciones.add(elemento);
        }
    }
    public Menu(int tipoViñeta, int numeroOpciones){
        this.tipoViñeta = tipoViñeta;
        this.numeroOpciones = numeroOpciones;
        numeracion = false;
        for(a=1;a<=this.numeroOpciones;a++){
            switch(this.tipoViñeta){
                case 1:
                    n = toRomano(a);
                    break;
                case 2:
                    n = toRomano(a).toLowerCase();
                    break;
                case 3:
                    n = String.valueOf(toMayus(a));
                    break;
                case 4:
                    n = String.valueOf(toMinus(a));
                    break;
                case 5:
                    numeracion = true;
                    break;              
            }
            if(numeracion == true){
                elemento = amarillo+a+blanco+".-Opcion "+a;                
            }else{
                elemento = amarillo+n+blanco+".- Opcion "+a;                
            }            
            opciones.add(elemento);
        }
    }
    public String toRomano(int a){
        centenas = this.a / 100 % 10;
        decenas = this.a / 10 % 10;
        unidades = this.a % 10;
        romano = "";
        if(centenas == 9){
            romano += "CM";
        }else{
            if(centenas >= 5){
                romano += "D";
                for(i=6;i<=centenas;i++){
                    romano += "C";
                }
            }else{
                if(centenas == 4){
                    romano += "CD";
                }else{
                    for(i=1;i<=centenas;i++){
                        romano += "C";
                    }
                }
            }
        }
        if(decenas == 9){
            romano += "XC";
        }else{
            if(decenas >= 5){
                romano += "L";
                for(i=6;i<=decenas;i++){
                    romano += "X";
                }
            }else{
                if(decenas == 4){
                    romano += "XL";
                }else{
                    for(i=1;i<=decenas;i++){
                        romano += "X";
                    }
                }
            }
        }
        if(unidades == 9){
            romano += "IX";
        }else{
            if(unidades >= 5){
                romano += "V";
                for(i=6;i<=unidades;i++){
                    romano += "I";
                }
            }else{
                if(unidades == 4){
                    romano += "IV";
                }else{
                    for(i=1;i<=unidades;i++){
                        romano += "I";
                    }
                }
            }
        }
        return romano;
    }
    public char toMinus(int numeroOpciones){
        if(numeroOpciones<=26){
            for(s='a';s<'a'+numeroOpciones-1;s++){
            }
        }else{
            s='a';
        }   
        return s;
    }
    public char toMayus(int numeroOpciones){
        if(numeroOpciones<=26){
            for(s='A';s<'A'+numeroOpciones-1;s++){
            }
        }else{
            s = 'A';
        }       
        return s;
    }
    public void setTitulo(String titulo){
        this.titulo = titulo;
    }
    public String getTitulo(){
        return titulo;
    }
    public int getA(){
        return a;
    }
    public boolean getNumeracion(){
        return numeracion;
    }
    public int getViñeta(){
        return tipoViñeta;
    }
    public void agregarOpcion(){
        this.a = getA();
        if(suma>0){
            this.a++;
        }
        this.numeracion = getNumeracion();
        switch(this.tipoViñeta){
            case 1:
                n = toRomano(a);
                break;
            case 2:
                n = toRomano(a).toLowerCase();
                break;
            case 3:
                n = String.valueOf(toMayus(a));
                break;
            case 4:
                n = String.valueOf(toMinus(a));
                break;
            case 5:
                numeracion = true;
                break;              
        }
        if(numeracion == true){
            elemento = amarillo+a+blanco+".-Opcion "+a;                
        }else{
            elemento = amarillo+n+blanco+".- Opcion "+a;                
        }            
        opciones.add(elemento);
        suma++;
    }   
    public void agregarOpcion(int opt){
        this.a = getA();
        if(suma>0){
            this.a++;
        }
        this.numeracion = getNumeracion();
            switch(this.tipoViñeta){
                case 1:
                    n = toRomano(a);
                    break;
                case 2:
                    n = toRomano(a).toLowerCase();
                    break;
                case 3:
                    n = String.valueOf(toMayus(a));
                    break;
                case 4:
                    n = String.valueOf(toMinus(a));
                    break;
                case 5:
                    numeracion = true;
                    break;              
            }
            opcion = entrada.nextLine();
            if(numeracion == true){
                elemento = amarillo+a+blanco+".- "+opcion;                
            }else{
                elemento = amarillo+n+blanco+".- "+opcion;                
            }            
            opciones.add(elemento);
            suma++;
    }
    public void imprimir(){
        System.out.println(cyan+"--------- "+getTitulo()+" --------- "+blanco);
        opciones.stream().forEach((p)->{
            System.out.println(p);
        });
        if(getSeleccionar()==null){
            System.out.println(rojo+"No se ha seleccionado ninguna opción"+blanco);
        }else{
            System.out.println("Seleccion actual: "+cyan+getSeleccionar()+blanco);
        }
    }
    public void Setseleccionar(int index){
        this.index = index;
        if(index<opciones.size() && index>=0){
            seleccion = opciones.get(index);
        }
    }
    public String getSeleccionar(){
        return seleccion;
    }
}