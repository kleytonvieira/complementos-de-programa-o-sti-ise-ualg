
public class Car extends LandVehicle {
  
  private int numberOfDoor;
  
  /**
   * @param brand
   * @param model
   * @param price
   * @param landVelocity
   * @param numberOfWheels
   * @param numberOfDoor
   */
  public Car(String brand, String model, float price, float landVelocity, int numberOfWheels, int numberOfDoor) {
    super(brand, model, price, landVelocity, numberOfWheels);
    this.numberOfDoor = numberOfDoor;
  }
  
  /**
   * @return the numberOfDoor
   */
  public int getNumberOfDoor() {
    return numberOfDoor;
  }
  
  /**
   * @param numberOfDoor the numberOfDoor to set
   */
  public void setNumberOfDoor(int numberOfDoor) {
    this.numberOfDoor = numberOfDoor;
  }
  
  @Override
  void vehicleInfo() {
    System.out.println("Car: " + this.getBrand() + " " + this.getModel() + " with " + this.getNumberOfDoor()
        + " doors at the price of " + this.getPrice());
        
  }
  
}
