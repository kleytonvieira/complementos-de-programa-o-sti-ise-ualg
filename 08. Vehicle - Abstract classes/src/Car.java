
public class Car 
	extends LandVehicle 
	implements CirculationTax,
//				Insurance,
				Comparable,
				Cloneable
				{
	
  private double filledFuel;
  private double kms;
  private int    numberOfDoors;
  private float tax;

  @Override
  public Car clone() {
	  return new Car(getOwner(), getBrand(), getModel(),
			  getNumberOfPassengers(), getLandVelocity(),
			  getNumberOfWheels(), getNumberOfDoors());
  }
  
  @Override
	public int compareTo(Object o) {
	  Car c = (Car)o;
	  if (getLandVelocity() < c.getLandVelocity())
		  return -1;
	  if (getLandVelocity() > c.getLandVelocity())
		  return 1;		
		return 0;
	}
  
  @Override
  public void setTax(float tax) {
	  this.tax = tax;
  }
  
  @Override
  public float getTax() {
	  return this.tax;
  }
 
  public Car(Person owner, String brand, String model, int numberOfPassengers, float landVelocity, int numberOfWheels,
      int numberOfDoors) {
    super(owner, brand, model, numberOfPassengers, landVelocity, numberOfWheels);
    
    this.numberOfDoors = numberOfDoors;
  }
  
  public double consumption() {
    return this.filledFuel / this.kms * 100;
  }
  
  /**
   * Estimated consumption when doing kms kilometers.
   *
   * @param kms the kms
   * @return the double
   */
  public double consumption(double kms) {
    return this.filledFuel / this.kms * kms;
  }
  
  /**
   * Expected consumption when doing kms kilometers applied a given load factor.
   *
   * @param kms the kms
   * @param loadFactor the load factor
   * @return the double
   */
  public double consumption(double kms, double loadFactor) {
    return this.filledFuel / this.kms * kms * loadFactor;
  }
  
  /**
   * Gets the car consumption.
   *
   * @return the car consumption
   */
  public double getFilledFuel() {
    return filledFuel;
  }
  
  /**
   * Gets the car kms.
   *
   * @return the car kms
   */
  public double getKms() {
    return kms;
  }
  
  /**
   * Gets the number of doors.
   *
   * @return the number of doors
   */
  public int getNumberOfDoors() {
    return numberOfDoors;
  }
  
  /**
   * Sets the car consumption.
   *
   * @param carConsumption the new car consumption
   */
  public void setFilledFuel(double carConsumption) {
    this.filledFuel = carConsumption;
  }
  
  /**
   * Sets the car kms.
   *
   * @param carKms the new car kms
   */
  public void setKms(double carKms) {
    this.kms = carKms;
  }
  
  /**
   * Sets the number of doors.
   *
   * @param numberOfDoors the new number of doors
   */
  public void setNumberOfDoors(int numberOfDoors) {
    this.numberOfDoors = numberOfDoors;
  }
  
  /* (non-Javadoc)
   * @see LandVehicle#vehicleInfo()
   */
  public String vehicleInfo() {
    return this.getLandVelocity() + " -- This vehicle is a " + this.getBrand() + " " + this.getModel() + " has " + this.getNumberOfWheels()
        + " wheels and is owned by " + this.getOwner().getName();
  }
  
}
