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
        ss = principal.h.retUs(usuario);
        padre n = new padre();
        hijo n1 = new hijo();
        n.carpeta = "/";
        n1.carpeta = "/";
        ss.p = n;
        ss.h = n1;
        ss.last_h = n1;
        ss.last_p = n;
        carpeta raiz_n = new carpeta();
        raiz_n.cap1 = "/";
        raiz_n.cap2 = "/";
        raiz_n.ruta = "/";
        n.derecha = raiz_n;
        n1.abajo = raiz_n;
    }

    public void unsetUs() {
        this.en_vista = null;
        this.th = null;
        this.tp = null;
    }

    public void n_carpeta(padre px, String us, String c_nombre) {
        padre np = new padre();//n padre
        hijo nh = new hijo();//n hijo
        carpeta cls = new carpeta();//n hijo
        cls.ruta=px.carpeta+"/"+c_nombre;
        cls.cap1=px.carpeta;
        cls.cap2=c_nombre;
        ss = principal.h.retUs(us);//agarramos el usuario
        np.carpeta = c_nombre;//seteo padre
        nh.carpeta = c_nombre;//seteo hijo
        ss.last_h.siguinete = nh;//ultimo a nuevo
        ss.last_p.siguinete = np;//ultimo a nuevo
        nh.ante=ss.last_h;
        np.ante=ss.last_p;
        ss.last_h = nh;//seteo ult
        ss.last_p = np;//seteo ult2
        nh.abajo=cls;//hijo abajo
        cls.sig=np;//puntero diagonal
        cls.arriba=nh;
        carpeta cn = px.derecha;//obtenemos el papi
        if(px.derecha==null){//si era nulo
            px.derecha=cls;
            //System.out.println(px.derecha.ruta);
        }else{
            while (true) {
                if(cn.siguiente==null){
                    cn.siguiente=cls;
                    break;
                }else{
                    cn=cn.siguiente;
                }
            }
        }
        
    }
    public void altCarpeta(padre clt,String atual, String nuevo){
        carpeta alt=clt.derecha;
        while(true){
            if(alt.cap2.equals(atual)){
              break;  
            }else{
                alt=alt.siguiente;
            }
        }
        
        alt.cap2=nuevo;
        alt.ruta=alt.cap1+"/"+alt.cap2;
        alt.arriba.carpeta=nuevo;
        padre sx=alt.sig;
        carpeta nhj=sx.derecha;
        while(true){
            if(nhj==null){
                break;
            }else{
                nhj.cap1=nuevo;
                nhj.ruta=nhj.cap1+"/"+nhj.cap2;
                nhj=nhj.siguiente;
            }
        }
    }
    
    public void elCarpeta(padre pri, String nombre){
        //primero el deslink del padre
        carpeta tpm;
        if(pri.derecha.cap2.equals(nombre)){
            carpeta ls = pri.derecha;
            hijo nj=ls.arriba;
            nj.ante.siguinete=nj.siguinete;
            if(nj.siguinete!=null){
                nj.siguinete.ante=nj.ante;
            }
            nj.ante=null;
            nj.siguinete=null;
            //llamamos al recursivo
            elimRecur(ls.sig);
            pri.derecha=pri.derecha.siguiente;
            
        }else{
            tpm=pri.derecha;
            while(true){
                if(tpm.siguiente.cap2.equals(nombre)){//vamos uno adelante
                    //procedemos con el delete
                    elimRecur(tpm.siguiente.sig);
                    hijo nj=tpm.siguiente.arriba;
                    tpm.siguiente=tpm.siguiente.siguiente;
                    //ahora la cabecera
                    
                    nj.ante.siguinete=nj.siguinete;
                    if(nj.siguinete!=null){
                        nj.siguinete.ante=nj.ante;
                    }
                    nj.ante=null;
                    nj.siguinete=null;
                    //elimRecur(tpm.siguiente.sig);
                    break;
                }else{
                    tpm=tpm.siguiente;
                }
            }
        }
    }
    
    public void elimRecur(padre cua){
        //primero de la tabla padre
        cua.ante.siguinete=cua.siguinete;
        if(cua.siguinete!=null){
           cua.siguinete.ante=cua.ante; 
        }
        cua.ante=null;
        cua.siguinete=null;
        if(cua.derecha!=null){//si tiene hijos
            carpeta t=cua.derecha;
            //removemos los hijos
            while(true){
                if(t.siguiente==null){
                    break;
                }else{
                    hijo nj=t.siguiente.arriba;
                    nj.ante.siguinete=nj.siguinete;
                    if(nj.siguinete!=null){
                        nj.siguinete.ante=nj.ante;
                    }
                    nj.ante=null;
                    nj.siguinete=null;
                    elimRecur(t.sig);
                    t=t.siguiente;
                }
            }
            
            
            
            
            
        }
        
        
    }
    

}
