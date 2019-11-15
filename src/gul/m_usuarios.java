package gul;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.bind.DatatypeConverter;

public class m_usuarios {

    usuarios primero;
    usuarios ultimo;
    usuarios sel_log;
    int tam_a;
    int llenados;

    public m_usuarios() {
        primero = null;
        ultimo = null;
        tam_a = 0;
        llenados = 0;
    }

    public void nuevo_index(int idx) {
        //tenemos que crear el numero de identificacion de nuestr usserr
        usuarios nuevo = new usuarios();
        nuevo.pos = idx;
        nuevo.state=false;
        this.tam_a++;
        if (this.primero == null) {
            this.primero = nuevo;
            this.ultimo = nuevo;
        } else {
            this.ultimo.siguiente=nuevo;
            this.ultimo=nuevo;
        }

    }
    public void editar_in(String nombre, String pass){
        int intent=0;
        usuarios candidato = new usuarios();
        //para la insercion primero calculamos el modulo
        int j=this.identificador(nombre);
        int mod = j%this.tam_a;
        //se ha calculado el modulo
        //ahora se verifica el factor de llenado de la tabla hash
        if(this.tam_x()){
            //si es mayor a 75 se realiza el redimensionado de la tabla
        }else{
            //aca normal
            //cargamos el nodo a modificar
            
            while(true){
                candidato=this.get_at(mod+(int) Math.pow(intent, 2));
                if(candidato.state==false){
                    //sin ocupar
                    candidato.id=j;
                    candidato.nombre=nombre;
                    candidato.state=true;
                    try {
                        candidato.contra=this.hasheo(pass);
                    } catch (NoSuchAlgorithmException ex) {
                        Logger.getLogger(m_usuarios.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    break;
                }else{
                    intent++;
                }
            }
            
        }
        
    }

    public boolean tam_x() {
        //calculamos el factor de llenado
        boolean d = false;
        float num = 0;
        num = this.llenados / this.tam_a;
        if (num > 0.75) {
            d = true;
        }
        return d;
    }
    
    public usuarios get_at(int pos){
        usuarios actual = new usuarios();
        actual=this.primero;
        while(true){
            if(actual.pos==pos){
                break;
            }else{
                actual=actual.siguiente;
            }
           
        }
        return actual;
    }

    public int nxt_primo(int tmx) {
        int itx = 0;
        while (true) {
            if (tmx % 2 != 0 || tmx % 3 != 0 || tmx % 5 != 0 || tmx % 7 != 0) {
                break;
            } else {
                tmx++;
            }
        }
        return itx;
    }

    public String hasheo(String password) throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance("SHA-256");
        byte[] digest = md.digest(password.getBytes(StandardCharsets.UTF_8));
        String sha256 = DatatypeConverter.printHexBinary(digest).toLowerCase();
        //System.out.println(sha256);
        return sha256; //retornamos el pinche hash
    }

    public int identificador(String nombrexx) {
        int id = 0;
        int len = nombrexx.length();
        int a, b, c;
        a = (int) (Math.random() * len + 10);
        b = (int) (Math.random() * len + 10);
        c = (int) (Math.random() * len + 10);
        id = (a + b + c + (int) (Math.random() * len + 100)) / len;
        return id;
    }
    
    public padre ret_padre(String nombre){
        usuarios actual = new usuarios();
        padre pp=new padre();
        actual=this.primero;
        while(true){
            if(nombre==actual.nombre){
                pp=actual.p;
                break;
            }else{
                actual=actual.siguiente;
            }
        }
        return pp;
    }
    public hijo ret_hijo(String nombre){
        usuarios actual = new usuarios();
        hijo hh=new hijo();
        actual=this.primero;
        while(true){
            if(nombre==actual.nombre){
                hh=actual.h;
                break;
            }else{
                actual=actual.siguiente;
            }
        }
        return hh;
    }
    
    
    
    public void info(){
        usuarios actual = new usuarios();
        actual=this.primero;
        while(true){
            
            if(actual==null){
                break;
            }else{
                System.out.println(actual.pos);
                System.out.println(actual.id);
                System.out.println(actual.nombre);
                System.out.println(actual.contra);
                System.out.println("----------------------");
                actual=actual.siguiente;
            }
        }
    }
    
    public boolean existe_x(String us, String ps) throws NoSuchAlgorithmException{
        boolean s=false;
        usuarios acc=this.primero;
        while(true){
            //System.out.println(acc.nombre+", "+acc.contra+"..."+this.hasheo(ps));
            if(acc.state!=false){
                if(acc.nombre.equals(us)&&acc.contra.equals(this.hasheo(ps))){
                    s=true;
                    this.sel_log=acc;
                    break;
                }
            }
            acc=acc.siguiente;
            if(acc==null){
                break;
            }
            
        }
        return s;
    }
    public usuarios retSel(){
        return this.sel_log;
    }
    
}
