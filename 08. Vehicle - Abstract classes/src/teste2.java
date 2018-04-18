import java.util.ArrayList;

public class teste2 {

	public static void main(String[] args) {
		  Person p = new Person("", "");
		  Car c = new Car(p, "Fiat", "500", 4, 2000f, 5, 4 );

		  Car clone = c.clone(); 

	}

}
