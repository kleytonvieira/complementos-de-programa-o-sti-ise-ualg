
public class mainProgram {
  
  public static void main(String[] args) {
    // TODO Auto-generated method stub
    Car c = new Car("Audi", "A4", 25000.0f, 200, 4, 4);
    Bicycle b = new Bicycle("B'TWIN", "ROCKRIDER 300", 129, 40, 2, false, false);
    RowBoat rb = new RowBoat("Coleman", "Adventure", 300, 5, 2);
    MotorBoat mb = new MotorBoat("Wonwave", "T32", 4000, 25, 15);
    c.vehicleInfo();
    b.vehicleInfo();
    rb.vehicleInfo();
    mb.vehicleInfo();
    
    
    
  }
}
