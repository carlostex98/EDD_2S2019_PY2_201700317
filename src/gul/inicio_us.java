package gul;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.sql.Timestamp;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;


public class inicio_us extends javax.swing.JFrame {
    usuarios actual_us;
    padre pad;
    carpeta cad;
    archivo rai;
    
    carpeta idx_c;
    archivo idx_a;
    padre idp;
    
    String rep_t;
    int e;
     //inicializacion de avl
    public void mostrarUs(String rr){//mostramos usuario
        nomb.setText(rr);
    }
    public String tmxx(){//devuelve fecha
        Date date= new Date();
        long time = date.getTime();
        Timestamp ts = new Timestamp(time);
        String g = ts.toString();
        return g;
    }
    int comp(String str1, String str2){ 
  
        int l1 = str1.length(); 
        int l2 = str2.length(); 
        int lmin = Math.min(l1, l2); 
  
        for (int i = 0; i < lmin; i++) { 
            int str1_ch = (int)str1.charAt(i); 
            int str2_ch = (int)str2.charAt(i); 
  
            if (str1_ch != str2_ch) { 
                return str1_ch - str2_ch; 
            } 
        } 
  
        // Edge case for strings like 
        // String 1="Geeks" and String 2="Geeksforgeeks" 
        if (l1 != l2) { 
            return l1 - l2; 
        } 
  
        // If none of the above conditions is true, 
        // it implies both the strings are equal 
        else { 
            return 0; 
        } 
    } 
    public inicio_us() {//on load
        initComponents();
        e=0;
        //tenemos que cargar la casa
        actual_us=principal.h.retSel();//usuario seleccionado
        pad =actual_us.p;
        cad=pad.derecha;
        rai=cad.raiz;
        tablis.setShowGrid(false);
        this.mostrarUs(actual_us.nombre);
        this.mostraCarpetas(pad);
        this.archi(rai);
        
        //vars para la casita
        idp=pad;
        idx_c=cad;
        idx_a=cad.raiz;
        
        
        //botoncitos
        jButton2.setEnabled(false);
        jButton3.setEnabled(false);
        jButton6.setEnabled(false);
        jButton7.setEnabled(false);
        jButton13.setEnabled(false);
    }
    public void archi(archivo envv){
        
        if(envv!=null){
            this.archi(envv.izq);
            Object[] cc={"Archivo",envv.archivo, envv.contenido};
            DefaultTableModel model = (DefaultTableModel) tablis.getModel();
            
            model.addRow(cc);
            this.archi(envv.def);
        }
        
        
    }
    
    public void cln(){
        DefaultTableModel model = (DefaultTableModel) tablis.getModel();
        model.setRowCount(0);
    }
    void mostraCarpetas(padre ctx){
        carpeta clx=ctx.derecha;
        
        while(true){
            if(clx==null){
                break;
            }else{
                Object[] cc={"Carpeta",clx.cap2, "contenido"};
                DefaultTableModel model = (DefaultTableModel) tablis.getModel();
                model.addRow(cc);
                clx=clx.siguiente;
            }
            
            
            
        }
        
        
                       
    }
    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();
        jButton10 = new javax.swing.JButton();
        jButton11 = new javax.swing.JButton();
        jButton12 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tablis = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        nomb = new javax.swing.JLabel();
        jButton13 = new javax.swing.JButton();
        jSeparator2 = new javax.swing.JSeparator();
        tog = new javax.swing.JToggleButton();
        jButton4 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jButton1.setText("Nueva carpeta");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Modificar nombre");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("Eliminar carpeta");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton5.setText("Nuevo Archivo");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton6.setText("Modificar archivo");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jButton7.setText("Eliminar archivo");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        jButton8.setText("Subir archivo");

        jButton9.setText("Reporte matriz");
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });

        jButton10.setText("Reporte arbol");
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });

        jButton11.setText("Ir a raiz");
        jButton11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton11ActionPerformed(evt);
            }
        });

        jButton12.setText("Cerrar sesion");
        jButton12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton12ActionPerformed(evt);
            }
        });

        tablis.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Tipo", "Nombre", "Contenido"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tablis.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablisMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tablis);

        jLabel1.setText("Hola: ");

        nomb.setText(".");

        jButton13.setText("Compartir");

        tog.setText("Modo edicion");
        tog.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                togActionPerformed(evt);
            }
        });

        jButton4.setText("Reporte grafo");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButton4)
                        .addGap(29, 29, 29)
                        .addComponent(jButton11)
                        .addGap(18, 18, 18)
                        .addComponent(jButton10)
                        .addGap(31, 31, 31)
                        .addComponent(jButton9)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jSeparator1)
                            .addComponent(jButton6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jSeparator2)
                            .addComponent(tog, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 667, Short.MAX_VALUE)
                        .addGap(25, 25, 25))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(nomb, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton12)
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(nomb)
                    .addComponent(jButton12))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton9)
                            .addComponent(jButton10)
                            .addComponent(jButton11)
                            .addComponent(jButton4))
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addComponent(tog)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 11, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton13)
                        .addGap(0, 35, Short.MAX_VALUE))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton11ActionPerformed
        
        this.cln();
        this.mostraCarpetas(idp);
        this.archi(idx_a);
        pad=idp;
        cad=idx_c;
        rai=idx_a;
        
    }//GEN-LAST:event_jButton11ActionPerformed

    private void jButton12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton12ActionPerformed
        new logueo().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton12ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        //new n_archivo().setVisible(true);
        String name = JOptionPane.showInputDialog("Nombre del archivo");
        String cont = JOptionPane.showInputDialog("Contenido del archivo");
        rai=principal.rara.insertar(rai, name, cont, this.tmxx(), actual_us.nombre);
        this.cln();
        this.mostraCarpetas(pad);
        this.archi(rai);
        
        cad.raiz=rai;
        /*rara.raiz = rara.insertar(rara.raiz, name, cont, this.tmxx());
        this.cln();
        this.archi(rara.raiz); 
        carpet.raiz=rara.raiz;*/
        
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        String name = JOptionPane.showInputDialog("Nombre de la carpeta");
        principal.cc.n_carpeta(pad, actual_us.nombre, name);
        this.cln();
        this.mostraCarpetas(pad);
        this.archi(rai); 
    }//GEN-LAST:event_jButton1ActionPerformed

    private void tablisMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablisMouseClicked
        if(e==0){
            DefaultTableModel model = (DefaultTableModel) tablis.getModel();
            int s=tablis.getSelectedRow();
            String e=tablis.getValueAt(s, 1).toString();
            String sl=tablis.getValueAt(s, 0).toString();
            if(sl.equals("Archivo")){
                archivo busca=rai;
                while(true){
                    if(busca.archivo.equals(e)){
                        String superf="Nombre archivo: "+busca.archivo
                            +"\nContenido: "+busca.contenido
                            +"\nFecha: "+busca.tmtp;
                        JOptionPane.showMessageDialog(this, superf);
                        break;
                    }else{
                        if(this.comp(busca.archivo, e)<0){
                            busca=busca.izq;
                        }else{
                            busca=busca.def;
                        }
                    }
                }
            }else{
                //la carpeta
                carpeta busq = pad.derecha;
                while(true){
                    if(busq.cap2.equals(e)){
                        pad = busq.sig;
                        cad = busq;
                        rai = busq.raiz;
                        this.cln();
                        this.mostraCarpetas(pad);
                        this.archi(rai); 
                    
                        break;
                    }else{
                        busq = busq.siguiente;
                    }
                }
            }
        }else{
            //modo modificacion
        }
        
        
        
        
    }//GEN-LAST:event_tablisMouseClicked

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        //launch de reporte
    }//GEN-LAST:event_jButton9ActionPerformed

    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed
        try {
            //primero el archivo bin
            PrintWriter writer = new PrintWriter("./avl.dot", "UTF-8");
            rep_t="";
            writer.println("digraph sls{");
            writer.println("node [shape=box]");
            nodosAvl(rai);
            writer.println(rep_t);
            rep_t="";
            relAvl(rai);
            writer.println(rep_t);
            writer.println("}");
            writer.close();
            
            

            Runtime rt = Runtime.getRuntime();
            Process pr = rt.exec("dot -Tjpg avl.dot -o avl.jpg");
            
            new verAvl().setVisible(true);
            
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(inicio_us.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(inicio_us.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(inicio_us.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
    }//GEN-LAST:event_jButton10ActionPerformed

    private void togActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_togActionPerformed
        if(e==0){
            e=1;
            jButton2.setEnabled(true);
            jButton3.setEnabled(true);
            jButton6.setEnabled(true);
            jButton7.setEnabled(true);
            jButton13.setEnabled(true);
            
        }else{
            e=0;
            jButton2.setEnabled(false);
            jButton3.setEnabled(false);
            jButton6.setEnabled(false);
            jButton7.setEnabled(false);
            jButton13.setEnabled(false);
        }
    }//GEN-LAST:event_togActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        //el proceso es el siguiente
        //obtenemos el nombre
        DefaultTableModel model = (DefaultTableModel) tablis.getModel();
        int s=tablis.getSelectedRow();
        String e=tablis.getValueAt(s, 1).toString();
        String sl=tablis.getValueAt(s, 0).toString();
        JOptionPane.showMessageDialog(this, "Vamos a eliminar el archivo seleccionado!");
        rai=principal.rara.deleteNode(rai, e);
        
        this.cln();
        this.mostraCarpetas(pad);
        this.archi(rai);
        
        
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        DefaultTableModel model = (DefaultTableModel) tablis.getModel();
        int s=tablis.getSelectedRow();
        String e=tablis.getValueAt(s, 1).toString();
        String sl=tablis.getValueAt(s, 0).toString();
        String h=tablis.getValueAt(s, 2).toString();
        String input = JOptionPane.showInputDialog(null,"El nuevo nombre(si lo desea)", e);
        String input2 = JOptionPane.showInputDialog(null,"El nuevo contenido(si lo desea)", h);
        if(e.equals(input)){//si el usuario es iagual
            rai=principal.rara.insertar(rai, input, input2, this.tmxx(), actual_us.nombre);
            this.cln();
            this.mostraCarpetas(pad);
            this.archi(rai);
        }else{
            //primero elimina y luego re-inserta
            rai=principal.rara.deleteNode(rai, e);
            rai=principal.rara.insertar(rai, input, input2, this.tmxx(), actual_us.nombre);
            this.cln();
            this.mostraCarpetas(pad);
            this.archi(rai);
        }
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        //obtenemos el nombre
        int s=tablis.getSelectedRow();
        String e=tablis.getValueAt(s, 1).toString();
        String sl=tablis.getValueAt(s, 0).toString();
        String h=tablis.getValueAt(s, 2).toString();
        if(sl.equals("Carpeta")){
            //modificamos
            String ex = JOptionPane.showInputDialog(null,"El nuevo nombre(si lo desea)", e);
            principal.cc.altCarpeta(pad, e, ex);
            this.cln();
            this.mostraCarpetas(pad);
            this.archi(rai);
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        int s=tablis.getSelectedRow();
        String e=tablis.getValueAt(s, 1).toString();
        String sl=tablis.getValueAt(s, 0).toString();
        String h=tablis.getValueAt(s, 2).toString();
        if(sl.equals("Carpeta")){
            //modificamos
            JOptionPane.showMessageDialog(this, "Vamos a eliminar la carpeta seleccionada");
            principal.cc.elCarpeta(pad, e);
            this.cln();
            this.mostraCarpetas(pad);
            this.archi(rai);
        }
        
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        
    }//GEN-LAST:event_jButton4ActionPerformed
    
    public void grafo(padre j){
        rep_t+="sdl00[label=\" \\ \"]; \n";
        
    }
    
    
    public void nodosAvl(archivo r){
        if(r!=null){
            nodosAvl(r.izq);
            //data
            String[] s = r.archivo.split("\\.");
            //System.out.println(s.length);
            String lbl=r.archivo+"\\n"+r.contenido+"\\n"+Integer.toString(r.bal)+"\\n"+Integer.toString(r.hei)+"\\n"+r.tmtp+"\\n"+r.prop;
            rep_t+=s[0]+s[1]+"[label=\""+lbl+"\" ]; \n";
            nodosAvl(r.def);
        }
    }
    public void relAvl(archivo r){
        if(r!=null){
            relAvl(r.izq);
            //data
            String[] s = r.archivo.split("\\.");
            if(r.def!=null){
                String[] s1=r.def.archivo.split("\\.");
                rep_t+=s[0]+s[1]+"->"+s1[0]+s1[1]+"; \n";
            }
            if(r.izq!=null){
                String[] s1=r.izq.archivo.split("\\.");
                rep_t+=s[0]+s[1]+"->"+s1[0]+s1[1]+"; \n";
            }
            relAvl(r.def);
        }
    }
    
    
    
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(inicio_us.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(inicio_us.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(inicio_us.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(inicio_us.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        //aca llamamos la carpeta root y sus hijos
        //para cada carpeta
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new inicio_us().setVisible(true);
            }
        });
    }
    
    public void llena_casa(){
        
    }
    
    public void matriz(){
        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton12;
    private javax.swing.JButton jButton13;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JLabel nomb;
    public static javax.swing.JTable tablis;
    private javax.swing.JToggleButton tog;
    // End of variables declaration//GEN-END:variables
}
