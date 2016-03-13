import java.util.Date;

public class Car extends LandVehicle implements CirculationTax, Insurance {
  
  private int   numberOfDoor;
  private float carAnualTax;
  private Date  insuranceDate;
  private float insurance;
                
  public Car(String brand, String model, float price, float landVelocity, int numberOfWheels, int numberOfDoor) {
    super(brand, model, price, landVelocity, numberOfWheels);
    this.numberOfDoor = numberOfDoor;
  }
  
  public int getNumberOfDoor() {
    return numberOfDoor;
  }
  
  public void setNumberOfDoor(int numberOfDoor) {
    this.numberOfDoor = numberOfDoor;
  }
  
  @Override
  void vehicleInfo() {
    System.out.println("Car: " + this.getBrand() + " " + this.getModel() + " with " + this.getNumberOfDoor()
        + " doors at the price of " + this.getPrice());
        
  }
  
  @Override
  public float getAnualTax() {
    return this.carAnualTax;
  }
  
  @Override
  public void setAnualTax(float tax) {
    this.carAnualTax = tax;
  }
  
  @Override
  public void setDate(Date date) {
    this.insuranceDate = date;
  }
  
  @Override
  public Date getDate() {
    return this.insuranceDate;
  }
  
  @Override
  public void setInsurenaceValue(float value) {
    this.insurance = value;
    
  }
  
  @Override
  public float getInsuranceValue() {
    return this.insurance;
  }
  
}
