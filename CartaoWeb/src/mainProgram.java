
public class mainProgram {

	public static void main(String[] args) {
		WebCard wcs[] = new WebCard[4];
		
		wcs[0] = new ChristmasCard("Pedro");
		wcs[1] = new BirthdayCard("Margarida");
		wcs[2] = new ChristmasCard("Cláudia");
		wcs[3] = new BirthdayCard("João");
		
		for( WebCard wc : wcs){
			wc.showMessage();
		}
	}
}
