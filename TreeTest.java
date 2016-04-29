package proyecto;
import java.io.IOException;
import java.util.Scanner;
public class TreeTest {
public static void main(String[] args) throws IOException {
    int value;
    Tree theTree = new Tree(50);   
    theTree.insert(50, 1.5);
    theTree.insert(25, 1.2);
    theTree.insert(75, 1.7);
    theTree.insert(37, 1.5);
    theTree.insert(62, 1.2);
    theTree.insert(84, 1.7);
    theTree.insert(31, 1.5);
    theTree.insert(43, 1.2);
    theTree.insert(55, 1.7);
    theTree.insert(92, 1.5);
//dtheTree.insert(97, 1.5);d

    while(true) {
      System.out.print("Teclee la primera letra de: desplegar, Máximo, mínimo, ");
      System.out.print("insertar, encontrar, borrar, o salir: ");
      int choice = getChar();
      switch(choice) {
        case 'd':
          theTree.displayTree();
          break;
        case 'i':
          System.out.print("Teclee la llave del nodo a insertar: ");
          value = getInt();
          theTree.insert(value, value + 0.9);
          break;
        case 'e':
          System.out.print("Teclee la llave del nodo a encontrar: ");
          value = getInt();
          Node found = theTree.find(value);
          if(found != null) {
            System.out.print("Se encontró el nodo ");
            found.displayNode();
            System.out.print("\n");
          } else {
            System.out.print("No se encontró el nodo con llave ");
            System.out.println(value);
          }      
          break;
        case 'b':
          System.out.print("Teclee la llave del nodo a borrar: ");
          value = getInt();
          boolean didDelete = theTree.delete(value);
          if(didDelete) {
            System.out.println("Se borró el nodo con llave " + value);
          } else {
            System.out.println("No se pudo borrar, no existe nodo con llave " + value);      
            
          }
	  break;
	case 'M':
          System.out.println("El máximo es " + theTree.maximum().getKey());
          break;   
        case 'm':
          System.out.println("El mínimo es " + theTree.minimum().getKey());
          break; 
	case 's':
          System.exit(0);
          break;
                  
        default:
          System.out.print("Opción inválida\n");
      }
    }
  }
  public static String getString() throws IOException {
    Scanner sc = new Scanner(System.in);
    String s = sc.next();
    return s;
  }
  public static char getChar() throws IOException {
    String s = getString();
    return s.charAt(0);
  }
  public static int getInt() throws IOException {
    Scanner sc = new Scanner(System.in);
    return sc.nextInt();
  } 
}

