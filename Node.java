package proyecto;
public class Node {
   private int key;                                  // llave
   public double dData;                            	 // dato
    public Node(int key, double dData) {
      this.key = key;
      this.dData = dData;
   }
   public Node() {
   }
public int getKey() {
      return key;
   }
   public void setKey(int key) {
      this.key=key;
   }
   public void displayNode() {                      
      System.out.print('{');
      System.out.print(key);
      System.out.print(", ");
      System.out.print(dData);
      System.out.print("} ");
   }
}

