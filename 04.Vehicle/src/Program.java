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
    Person p1 = new Person();
    p1.setForename("Margarida");
    p1.setSurname("Herdeiro");
    p1.setAddress("Rua das flores, lote 1, Faro");
    p1.setCC("238921739");
    p1.setPhoneNumber("289800100");
    car.carOwner = p1;
    car.carColor = "White";
    car.carModel = "500";
    car.carConsumption = 6.1;
    
    cars[0] = new Car();
    cars[0].carBrand = "Audi";
    Person p2 = new Person();
    p2.setForename("Maria");
    p2.setSurname("Herdeiro");
    p2.setAddress("Rua das flores, lote 1, Faro");
    p2.setCC("2398908888");
    p2.setPhoneNumber("289800100");
    cars[0].carOwner = p2;
    cars[0].carColor = "White";
    cars[0].carModel = "A6";
    cars[0].carConsumption = 6.1;
    
    System.out.println(car.carOwner.getForename() + " owns a " + car.carBrand + " " + car.carModel);
    System.out.println(cars[0].carOwner.getForename() + " owns a " + cars[0].carBrand + " " + cars[0].carModel);
    
    car.printOwner();
    cars[0].printOwner();
    
    car.setOwner(p2);
    car.printOwner();
    System.out.println(car.carOwner.getForename() + " owns a " + cars[0].carBrand + " " + cars[0].carModel);
    
  }
}
