package gul;
public class m_archivo {
   archivo raiz;
   int height(archivo N){
       if(N == null){
           return 0;
       }
       return N.hei;
   }
   int max(int a, int b){
       return (a>b)? a:b;
   }
   
   archivo rightRotate(archivo y){
       archivo x = y.izq;
       archivo T2 = x.def;
       
       x.def=y;
       y.izq=T2;
       
       y.hei=max(height(y.izq),height(y.def))+1;
       x.hei=max(height(x.izq),height(x.def))+1;
       
       return x;
   }
   
   archivo leftRotate(archivo x){
       archivo y = x.def;
       archivo T2 = y.izq;
       
       y.izq = x;
       x.def = T2;
       
       x.hei = max(height(x.izq),height(x.def))+1;
       y.hei = max(height(y.izq),height(y.def))+1;
       
       return y;
   }
   
   int getBalance(archivo N){
       if(N==null){
           return 0;
       }
       return height(N.izq) - height(N.def);
   }
   
   archivo insertar(archivo node, String nombre, String contenido, String tmtm){
       if(node==null){
           return (new archivo(nombre,contenido, tmtm));
       }
       
       if (comp(nombre,node.archivo)<0){
           node.izq = insertar(node.izq, nombre, contenido, tmtm);
       }else if(comp(nombre,node.archivo)>0){
           node.def = insertar(node.def, nombre, contenido, tmtm);
       }else{
           return node;
       }
       
       node.hei = 1 + max(height(node.izq),height(node.def));
       int balance = getBalance(node);
       
       if(balance > 1 && (comp(nombre, node.izq.archivo)<0)){
           return rightRotate(node);
       }
       if(balance < -1 && (comp(nombre, node.izq.archivo)>0)){
           return leftRotate(node);
       }
       if(balance > 1 && (comp(nombre, node.izq.archivo)>0)){
           node.izq = leftRotate(node.izq);
           return rightRotate(node);
       }
       if(balance < -1 && (comp(nombre, node.izq.archivo)<0)){
           node.def = rightRotate(node.def);
           return leftRotate(node);
       }
       return node;
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
    
    void inRd(archivo node){
        inRd(node.izq);
        System.out.println(node.archivo);
        inRd(node.def);
    }
    
    public void setRaiz(archivo Node){
        this.raiz = Node;
    }
    
    public archivo retAVL(){
        return this.raiz;
    }
    
    //----para eliminar
    archivo minValueNode(archivo node){
        archivo current = node;
        while(current.izq != null){
            current= current.izq;
        }
        return current;
    }
    
    archivo deleteNode(archivo root, String nombre){
        if(root==null){
            return root;
        }
        if(this.comp(nombre, root.archivo)<0){
            root.izq=this.deleteNode(root.izq, nombre);
        }else if(this.comp(nombre, root.archivo)>0){
            root.def = this.deleteNode(root.def, nombre);
        }else{
            if ((root.izq == null) || (root.def == null))  
            {  
                archivo temp = null;  
                if (temp == root.izq){  
                    temp = root.def;
                }
                else{
                    temp = root.izq;  
                }
                
                if (temp == null)  
                {  
                    temp = root;  
                    root = null;  
                }  
                else{   
                    root = temp;
                }
            }
            else{  

                archivo temp = minValueNode(root.def);  
                root.archivo.equals(temp.archivo);
                root.def = deleteNode(root.def, temp.archivo);  
            } 
        }
        if (root==null){
            return root;
        }
        root.hei=this.max(height(root.izq), height(root.def)) + 1;    
        int balance = getBalance(root);
        
        if (balance > 1 && getBalance(root.izq) >= 0){  
            return rightRotate(root);
        }
        if (balance > 1 && getBalance(root.izq) < 0){  
            root.izq = leftRotate(root.izq);  
            return rightRotate(root);  
        }
        if (balance < -1 && getBalance(root.def) <= 0){  
            return leftRotate(root);  
        }
        if (balance < -1 && getBalance(root.def) > 0){  
            root.def = rightRotate(root.def);  
            return leftRotate(root);  
        }  
        return root;
    }
    
    
   
}
