
public class Main {
  
  public static void main(String[] args) {
    // TODO Auto-generated method stub
    Person owner = new Person("João", "1997/08/15");
    Engine engine = new Engine("Diesel", 120, 4);
    
    Car car = new Car("Audi", "A4", owner, engine);
    
    System.out.println("The car belongs to " + car.getOwner().getName() + ". It is a " + car.getBrand() + " "
        + car.getModel() + " with a " + car.getEngine().getHorsepower() + " horsepower engine.");
  }
  
}
