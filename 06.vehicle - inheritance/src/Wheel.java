
// TODO: Auto-generated Javadoc
/**
 * The Class Wheel.
 * see e.g.,  http://www.trailersauce.co.nz/equipment/tyres-rims/
 */
public class Wheel {
	
	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public int getRimDiameter() {
		return rimDiameter;
	}

	public void setRimDiameter(int rimDiameter) {
		this.rimDiameter = rimDiameter;
	}

	public String getConstruction() {
		return construction;
	}

	public void setConstruction(String construction) {
		this.construction = construction;
	}

	public int getLoadIndex() {
		return loadIndex;
	}

	public void setLoadIndex(int loadIndex) {
		this.loadIndex = loadIndex;
	}

	public String getSpeedRating() {
		return speedRating;
	}

	public void setSpeedRating(String speedRating) {
		this.speedRating = speedRating;
	}

	/** The width. */
	private int width;
	
	/** The height. */
	private int height;
	
	/** The rim diameter. */
	private int rimDiameter;
	
	/** The construction. */
	private String construction; //e.g., R -radial, B -Bias 
	
	/** The load index. */
	private int loadIndex;
	
	/** The speed rating. */
	private String speedRating; //e.g., V	
	
}
