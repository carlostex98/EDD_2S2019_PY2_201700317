package gul;

public class m_carpeta {
    //si sobrecarga
    carpeta en_vista;
    padre tp;
    hijo th;
    public m_carpeta(){
        en_vista = null;
        tp = null;
        th = null;
    }

    public void i_carpeta(String usuario) {
        tp = principal.h.ret_padre(usuario);
        th = principal.h.ret_hijo(usuario);
        padre n = new padre();
        hijo n2 = new hijo();
        n.carpeta="/";
        n2.carpeta="/";
        tp.siguinete=n;
        th.siguinete=n2;        
    }
    
}
