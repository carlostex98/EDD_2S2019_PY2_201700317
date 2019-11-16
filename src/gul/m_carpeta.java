package gul;

public class m_carpeta {

    //si sobrecarga
    carpeta en_vista;
    padre tp;
    hijo th;
    usuarios ss;

    public m_carpeta() {
        /*en_vista = null;
        tp = null;
        th = null;
        ss = null;*/
    }

    public void i_carpeta(String usuario) {
        ss=principal.h.retUs(usuario);
        padre n= new padre();
        hijo n1 = new hijo();
        n.carpeta="/";
        n1.carpeta="/";
        ss.p=n;
        ss.h=n1;
        carpeta raiz_n = new carpeta();
        raiz_n.cap1="/";
        raiz_n.cap2="/";
        raiz_n.ruta="/";
        n.derecha=raiz_n;
        n1.abajo = raiz_n;
    }

    public void unsetUs() {
        this.en_vista = null;
        this.th = null;
        this.tp = null;
    }

}
