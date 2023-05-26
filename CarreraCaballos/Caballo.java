/*Sobre carga de metodos: Es cuando se tienen metodos llamados igual
pero tienen diferentes parametros*/
public class Caballo {
    private String  nombre, figura, cadena="";
    private int atras, pasos=0, n;
    public Caballo(String nombre, String figura){
        this.nombre = nombre;
        this.figura = figura;
    }
    public String avanzar(){
        pasos = pasos+(int)(Math.random()*25+1);
        cadena="";
        for(n=0;n<pasos;n++){
            cadena = cadena + " ";
        }
        cadena = cadena + figura;
        return cadena;
    }
    public String avanzar(int pasos){
        this.pasos = pasos;
        for(n=0;n<pasos;n++){
            cadena = cadena + " ";
        }
        cadena = cadena + figura;
        return cadena;
    }
    public String retroceder(){
        atras = (int)(Math.random()*this.pasos+1);
        this.pasos = this.pasos - atras;
        cadena = "";
        for(n=0;n<this.pasos;n++){
            cadena = cadena + " ";
        }
        cadena = cadena + figura;
        return cadena;
    }
    public int getAvance(){
        if(this.pasos<0){
            return 0;
        }else{
            return this.pasos;
        }
    }
    public String getNombre(){
        return this.nombre;
    }
    public int getAtras(){
        return this.atras;
    }
    public String retroceder(int pasos){
        this.pasos = this.pasos - pasos;
        cadena = "";
        for(n=0;n<this.pasos;n++){
            cadena = cadena + " ";
        }
        cadena = cadena + figura;
        return cadena;
    }
}
