
// TODO: Auto-generated Javadoc
/**
 * The Class Car.
 */
public class Car {
  
  /** The brand. */
  private String brand;
                 
  /** The engine. */
  private Engine engine;
                 
  /** The model. */
  private String model;
                 
  /** The owner. */
  private Person owner;
                 
  /**
   * Instantiates a new car.
   *
   * @param brand the brand
   * @param model the model
   * @param owner the owner
   * @param engine the engine
   */
  public Car(String brand, String model, Person owner, Engine engine) {
    super();
    this.brand = brand;
    this.model = model;
    this.owner = owner;
    this.engine = engine;
  }
  
  /**
   * Instantiates a new car.
   *
   * @param brand
   * @param engine
   * @param model
   */
  public Car(String brand, String model, Engine engine) {
    super();
    this.brand = brand;
    this.engine = engine;
    this.model = model;
  }

  /**
   * Gets the brand.
   *
   * @return the brand
   */
  public String getBrand() {
    return brand;
  }
  
  /**
   * Gets the engine.
   *
   * @return the engine
   */
  public Engine getEngine() {
    return engine;
  }
  
  /**
   * Gets the model.
   *
   * @return the model
   */
  public String getModel() {
    return model;
  }
  
  /**
   * Gets the owner.
   *
   * @return the owner
   */
  public Person getOwner() {
    return owner;
  }
  
  /**
   * Sets the brand - values accepted are Fiat or Audi (to be improved...).
   *
   * @param brand the new brand
   * @return true, if successful
   */
  public boolean setBrand(String brand) {
    if (brand == "Fiat" || brand == "Audi"){
      this.brand = brand;
      return true;
    }    
    return false;
  }
  
  /**
   * Sets the engine.
   *
   * @param engine the new engine
   */
  public void setEngine(Engine engine) {
    this.engine = engine;
  }
  
  /**
   * Sets the model.
   *
   * @param model the new model
   */
  public void setModel(String model) {
    this.model = model;
  }
  
  /**
   * Sets the owner.
   *
   * @param owner the new owner
   */
  public void setOwner(Person owner) {
    this.owner = owner;
  }
  
}
