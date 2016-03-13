
public class MotorBoat extends WaterVehicle {
  private float engineHorsePower;
  
  /**
   * @param brand
   * @param model
   * @param price
   * @param waterVelocity
   * @param engineHorsePower
   */
  public MotorBoat(String brand, String model, float price, float waterVelocity, float engineHorsePower) {
    super(brand, model, price, waterVelocity);
    this.engineHorsePower = engineHorsePower;
  }
  
  /**
   * @return the engineHorsePower
   */
  public float getEngineHorsePower() {
    return engineHorsePower;
  }
  
  /**
   * @param engineHorsePower the engineHorsePower to set
   */
  public void setEngineHorsePower(float engineHorsePower) {
    this.engineHorsePower = engineHorsePower;
  }
  
  @Override
  void vehicleInfo() {
    System.out.println("Motor boat: " + this.getBrand() + " " + this.getModel() + " with a " + this.engineHorsePower
        + " horse power engine");
  }
  
}
