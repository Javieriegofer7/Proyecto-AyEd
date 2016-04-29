package proyecto;
import java.util.*;
import java.lang.*;

public class Tree {
  List<Integer> visitados = new ArrayList<Integer>();
  Stack sta = new Stack();
  private Node[] treeArray;
  private int maxSize;
  private int currentSize;
  private int i = 0;		 // i es el índice del arreglo en todos los métodos
  public Tree(int maxSize) {
    this.maxSize = maxSize;
    currentSize = 0;
    treeArray = new Node[maxSize];
  } 
    public Node find(int key) {  
        i = 0;
        while(treeArray[i] != null){
            if(key > treeArray[i].getKey()){
                i = 2*i +2;
            }
            else if (key < treeArray[i].getKey()){
                i = 2*i + 1;
            }
            else{
                return treeArray[i];
            }
        }
	return null;		// para que no de errores antes de implementar
   }
    public void insert(int key, double dData) {
       i = 0;
       Node nodoInsert = new Node(key, dData);
       while(treeArray[i]!= null){
           if(key >= treeArray[i].getKey()){
               i = 2*i+2;
           }
           else{
               i = 2*i+1;
           }
       }
       treeArray[i] = nodoInsert;
       currentSize++;
    }
  public Node minimum() {
        i = 0;
        Node minimo = null;
        while(treeArray[i] != null){
            minimo = treeArray[i];
            i = 2*i+1;
        }
	return minimo;		// para que no de errores antes de implementar
   }
   public Node maximum() {
        i = 0;
        Node maximo = null;
        while(i < maxSize && treeArray[i] != null){
            maximo = treeArray[i];
            i = 2*i+2;
        }
	return maximo;	// para que no de errores antes de implementar
   } 
  public boolean delete(int key) {
    i = 0;
    while(i < maxSize && treeArray[i] != null){
        if(key > treeArray[i].getKey()){
            i = 2*i +2;
        }
        else if (key < treeArray[i].getKey()){
            i = 2*i + 1;
        }
        else{ //En el caso en el que sí lo encuentre
            if((2*i+1)>maxSize){ //forzosamente es un nodo hoja, ya que es imposible que haya más elementos (ya no hay espacio para ellos)
                //System.out.println("Esta entrando a m");
                treeArray[i] = null;
                currentSize--;
                return true;
            }
            else if ((2*i+1)== maxSize){ // El arreglo tiene espacio solamente para el hijo izquierdo.
                if(treeArray[2*i+1] == null){ //Este hijo izquierdo es nulo
                    //System.out.println("Esta entrando a k");
                    treeArray[i] = null;
                    currentSize--;
                    return true;
                }
                else{
                    //Aquí se llamara el metodo para borrar nodos que no son hoja
                }
                
            }
            else{   //El arreglo tiene espacio para ambos hijos
                if(treeArray[2*i+1] == null && treeArray[2*i+2] == null){ //Cuando ambos nodos son nulos
                    //System.out.println("Esta entrando a j");
                    treeArray[i] = null;
                    currentSize--;
                    return true;
                }
                else{ //Cuando tiene algún nodo que no es nulo
                    if(treeArray[2*i+1] == null && treeArray[2*i+2] != null){
                        System.out.println("Esta entrando a esta parte");
                        eliminarInOrder(2*i+2,i, i);
                        return true;
                    
                    }
                    else if (treeArray[2*i+1] != null && treeArray[2*i+2] == null){
                        System.out.println("Esta entrando a esta parte");
                        eliminarInOrder(2*i+1,i, i);
                        return true;
                    }
                    else if(treeArray[2*i+1]!= null && treeArray[2*i+2] != null){
                        System.out.println("Esta entrando bien");
                        eliminarSucesor(i);
                        
                        
                    }            
            }
        }
    }
  }
     return false; //no se pudo encontrar
  }
  public void displayTree(){
    System.out.print("treeArray: ");
    for(int j = 0; j < maxSize; j++) {
      if(treeArray[j] != null) {
        System.out.print(treeArray[j].getKey() + " ");
      } else {
        System.out.print(" - ");
      }
    }
    System.out.println();
   }
  
    public void eliminar(int padreMovido,int padreSinMover, int valEliminar){
        System.out.println("El padre movido es:" + padreMovido + " y el valor del arbol es: " + treeArray[padreMovido].getKey());
        System.out.println("El padre sin mover es:" + padreSinMover + " y el valor del arbol es: " + treeArray[padreSinMover].getKey());
        System.out.println("El valor a eliminar  es: " + valEliminar);
        System.out.println("El valor de la lista es: " + visitados.toString());
        while(padreMovido>=valEliminar){
            if((2*padreSinMover +1)< maxSize  && treeArray[(2*padreSinMover +1)]!=null){
                if (!visitados.contains(padreSinMover)){
                    System.out.println("Esta entrando a 1");
                    treeArray[(2*padreMovido +1)]=treeArray[(2*padreSinMover +1)];
                    visitados.add(padreSinMover);
                    eliminar((2*padreMovido+1),(2*padreSinMover+1),valEliminar);
                }                
            }
            else if((2*padreSinMover +2)< maxSize  && treeArray[(2*padreSinMover +2)]!=null){
                System.out.println("Esta entrando a 2");                
                treeArray[(2*padreMovido +2)]=treeArray[(2*padreSinMover +2)];
                visitados.add(padreSinMover);
                eliminar((2*padreMovido+2),(2*padreSinMover+2),valEliminar);
            }
            else{
                if(padreMovido %2 != 0){
                    System.out.println("Esta entrando a 3");
                    eliminar((padreMovido-1)/2,(padreSinMover-1)/2,valEliminar);
                }
                else{
                    eliminar((padreMovido-2)/2,(padreSinMover-2)/2,valEliminar);
                }

            }
        }
    }


public void eliminarInOrder(int padreSinMover, int padreMovido, int valEliminar){ 
    try{
        /*
    System.out.print("El padre sin mover es: " + padreSinMover + " y el valor del arbol es: ");
    treeArray[padreSinMover].displayNode();
    System.out.println(" ");
    System.out.print("El padre movido es: " + padreMovido + " y el valor del arbol es: " );
    treeArray[padreMovido].displayNode();
    System.out.println(" ");
    System.out.print("El valor a eliminar es: " + valEliminar +" y el valor del arbol es: ");
    treeArray[valEliminar].displayNode();
    System.out.println(" ");
*/
    if(treeArray[padreSinMover]!=  null) {
        treeArray[padreMovido]=treeArray[padreSinMover];
        treeArray[padreSinMover] = null;
        eliminarInOrder(2*padreSinMover+1, 2*padreMovido+1, valEliminar); 
        //treeArray[padreMovido]=treeArray[padreSinMover];
        eliminarInOrder(2*padreSinMover+2, 2*padreMovido+2, valEliminar);
    }
    }
    catch(NullPointerException e){
        System.out.println(e);
    }
}  



public void eliminarSucesor(int valEliminar){
    int k = valEliminar;
    k = 2*k+2;
    int valReemplazo = 0;
    while(k<= maxSize && treeArray[k]!= null){
        System.out.println("El valor de la constante es: " + valEliminar);
        System.out.println("El valor del sucesor está siendo: " + k);
        valReemplazo = k;
        k = 2*k+1;
    }
    treeArray[valEliminar] = treeArray[valReemplazo];
    
}
    
    
    
    



}