import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

public class TesteComparacao {

	public static void main(String[] args) {
	  Person p = new Person("", "");
	  ArrayList<Car> al = new ArrayList<Car>();
	  
	  al.add(new Car(p, "Fiat", "500", 4, 2000f, 5, 4 ));
	  al.add(new Car(p, "Volvo", "V40", 4, 1200f, 5, 4 ));
	  al.add(new Car(p, "Audi", "A4", 4, 3200f, 5, 4 ));
	  al.add(new Car(p, "Ferrari", "F40", 2, 123300f, 5, 4 ));
	  
	  
	  Iterator<Car> it = al.iterator();
	  while(it.hasNext()) {
		  Car c = (Car) it.next();
		  System.out.println(c.vehicleInfo());
	  }
	  
	  System.out.println("--------------------");
	  Collections.sort(al);
	  
	  it = al.iterator();
	  while(it.hasNext()) {
		  Car c = (Car) it.next();
		  System.out.println(c.vehicleInfo());
	  }
	  
	}
}
