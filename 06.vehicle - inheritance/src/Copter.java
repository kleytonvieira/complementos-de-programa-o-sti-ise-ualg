
// TODO: Auto-generated Javadoc
/**
 * The Class Multicopter.
 */
public class Copter extends AirVehicle {
	
	/** The number of rotors. */
	private int numberOfRotors;

	/**
	 * Instantiates a new multicopter.
	 *
	 * @param owner the owner
	 * @param brand the brand
	 * @param model the model
	 * @param numberOfPassengers the number of passengers
	 * @param airVelocity the air velocity
	 * @param numberOfRotors the number of rotors
	 */
	public Copter(Person owner, String brand, String model, int numberOfPassengers, float airVelocity,
			int numberOfRotors) {
		super(owner, brand, model, numberOfPassengers, airVelocity);
		this.numberOfRotors = numberOfRotors;
	}

	/**
	 * Gets the number of rotors.
	 *
	 * @return the number of rotors
	 */
	public int getNumberOfRotors() {
		return numberOfRotors;
	}

	/**
	 * Sets the number of rotors.
	 *
	 * @param numberOfRotors the new number of rotors
	 */
	public void setNumberOfRotors(int numberOfRotors) {
		this.numberOfRotors = numberOfRotors;
	}
	

}
