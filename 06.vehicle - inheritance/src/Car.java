
// TODO: Auto-generated Javadoc
/**
 * The Class Car.
 */
public class Car extends LandVehicle {
	
	/** The engine. */
	private Engine engine; 
	
	/** The number of doors. */
	private int numberOfDoors;
	
	/**
	 * Instantiates a new car.
	 *
	 * @param owner the owner
	 * @param brand the brand
	 * @param model the model
	 * @param numberOfPassengers the number of passengers
	 * @param landVelocity the land velocity
	 * @param wheels the wheels
	 * @param numberOfWheels the number of wheels
	 * @param engine the engine
	 * @param numberOfDoors the number of doors
	 */
	public Car(Person owner, String brand, String model, int numberOfPassengers, float landVelocity, Wheel wheels,
			int numberOfWheels, Engine engine, int numberOfDoors) {
		super(owner, brand, model, numberOfPassengers, landVelocity, wheels, numberOfWheels);
		this.engine = engine;
		this.numberOfDoors = numberOfDoors;
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
	 * Gets the number of doors.
	 *
	 * @return the number of doors
	 */
	public int getNumberOfDoors() {
		return numberOfDoors;
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
	 * Sets the number of doors.
	 *
	 * @param numberOfDoors the new number of doors
	 */
	public void setNumberOfDoors(int numberOfDoors) {
		this.numberOfDoors = numberOfDoors;
	}	
}