import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

public class mainProgram {
  
  public static void main(String[] args) {

    ArrayList<Car> al = new ArrayList();
    
    al.add(new Car("Audi", "A4", 25000.0f, 200, 4, 4));
    al.add(new Car("Fiat", "500", 15000.0f, 160, 2, 4));
    al.add(new Car("Opel", "Astra", 20000.0f, 180, 4, 4));
    al.add(new Car("Volvo", "v40", 22500.0f, 190, 4, 5));
    
    Iterator<Car> it = al.iterator();
    while(it.hasNext()){
        Vehicle  v = (Vehicle)it.next();
        v.vehicleInfo();
    }
    
    System.out.println("=============");
    Collections.sort(al); //possible since Car implements Comparable 
    it = al.iterator();
    while(it.hasNext()){
        Vehicle  v = (Vehicle)it.next();
        v.vehicleInfo();
    }
  }
}
