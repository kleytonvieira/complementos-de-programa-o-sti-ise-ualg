import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

public class mainProgram {
  
  public static void main(String[] args) {
    // TODO Auto-generated method stub
    Car c1 = new Car("Audi", "A4", 25000.0f, 200, 4, 4);
    Car c2 = new Car("Fiat", "500", 15000.0f, 160, 2, 4);
    Car c3 = new Car("Opel", "Astra", 20000.0f, 180, 4, 4);
    Car c4 = new Car("Volvo", "v40", 22500.0f, 190, 4, 5);

    ArrayList<Car> al = new ArrayList();
    
    al.add(c1);
    al.add(c2);
    al.add(c3);
    al.add(c4);
    
    Iterator<Car> it = al.iterator();
    while(it.hasNext()){
        Vehicle  v = (Vehicle)it.next();
        v.vehicleInfo();
    }
    

    System.out.println("=============");
    Collections.sort(al);
    it = al.iterator();
    while(it.hasNext()){
        Vehicle  v = (Vehicle)it.next();
        v.vehicleInfo();
    }
    
    
  }
}
