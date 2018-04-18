
public class MotorBoat 
	extends Vehicle 
	implements CirculationTax {
	
	public MotorBoat(Person owner, 
				String brand, 
				String model, 
				int numberOfPassengers){
		super(owner, brand, model, numberOfPassengers);
	}
	
	@Override
	public void setTax(float tax) {
		// TODO Auto-generated method stub

	}

	@Override
	public float getTax() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	String vehicleInfo() {
		// TODO Auto-generated method stub
		return null;
	}

}
