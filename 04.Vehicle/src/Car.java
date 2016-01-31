// TODO: Auto-generated Javadoc
/**
 * The Class Car.
 *
 * @author pcardoso
 */
public class Car {
  
  /** The car color. */
  String carColor;
  
  /** The car brand. */
  String carBrand;
  
  /** The car model. */
  String carModel;
  
  /** The car owner. */
  String carOwner;
  
  /** The Liters per hundred km. */
  double carConsumption;
  
  /** The car kms. */
  double carKms;
  
  /**
   * Prints the owner.
   */
  void printOwner() {
    System.out.println(carOwner);
  }
  
  /**
   * Gets the owner.
   *
   * @return the owner
   */
  String getOwner() {
    return carOwner;
  }
  
  /**
   * Sets the owner.
   *
   * @param carOwnerIn the new owner
   */
  void setOwner(String carOwnerIn) {
    carOwner = carOwnerIn;
  }
  
  /**
   * Adds kmsIn to the carKms.
   *
   * @param kmsIn the kms in
   */
  void addKms(double kmsIn) {
    carKms += kmsIn;
  }
  
}
