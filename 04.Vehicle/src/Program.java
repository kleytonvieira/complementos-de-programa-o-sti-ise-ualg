// TODO: Auto-generated Javadoc
/**
 * The Class Program.
 */
public class Program {
  
  /**
   * The main method.
   *
   * @param args
   *          the arguments
   */
  public static void main(String[] args) {
    new Car(); // Unuseful!
    Car car = new Car(); // 1 car!
    Car[] cars = new Car[10]; // 10 cars! But this is only creating pointers
    // (references) to Car and not 10 objects.
    System.out.println("by now, we've a lot of 'Cars'!");
    
    car.carBrand = "Fiat";
    car.carOwner = "Margarida";
    car.carColor = "White";
    car.carModel = "500";
    car.carConsumption = 6.1;
    
    cars[0] = new Car();
    cars[0].carBrand = "Audi";
    cars[0].carOwner = "Maria";
    cars[0].carColor = "White";
    cars[0].carModel = "A6";
    cars[0].carConsumption = 6.1;
    
    System.out.println(car.carOwner + " owns a " + car.carBrand + " " + car.carModel);
    System.out.println(cars[0].carOwner + " owns a " + cars[0].carBrand + " " + cars[0].carModel);
    
    car.printOwner();
    cars[0].printOwner();
    
    car.setOwner("Pedro");
    car.printOwner();
    System.out.println(car.carOwner + " owns a " + cars[0].carBrand + " " + cars[0].carModel);
    
  }
}
