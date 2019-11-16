package gul;
public class temps {
    usuarios en_mira;
    
    String nombre_x;
    String contenido_x;
    public temps(){
        this.en_mira = null;
        this.nombre_x ="";
        this.contenido_x = "";
    }
    
    public void setArchivo(String arh, String cont){
        this.nombre_x=arh;
        this.contenido_x = cont;
    }
}
