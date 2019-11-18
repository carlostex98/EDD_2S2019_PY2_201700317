package gul;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import javax.xml.bind.DatatypeConverter;

public class principal {

    public static m_usuarios h = new m_usuarios();
    public static m_carpeta cc = new m_carpeta();
    public static m_archivo arbol = new m_archivo();
    public static temps txt = new temps();
    public static m_archivo rara = new m_archivo();

    public static void main(String[] args) throws NoSuchAlgorithmException {
        //aca tendremos todas la inicializaciones de las estructuras
        //primero llamamos a nuestro jframe de logueo
        //teniendo ya ingresado nuestru usuario ademin
        new logueo().setVisible(true);

        for (int i = 0; i < 17; i++) {
            h.nuevo_index(i);
        }
        h.editar_in("admin", "admin");
        h.editar_in("juan", "juan");
        cc.i_carpeta("juan");
        //cc.nueva_carpeta("/s");
        //h.info();
        
    }
}
