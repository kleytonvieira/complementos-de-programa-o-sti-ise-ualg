import javax.swing.plaf.synth.SynthSeparatorUI;

public class WithLogicalErrors {
	public static void separador() {
		System.out.println("\n-----------------------------");
	}

	public static void a() {
		separador();
		for (int i = 150; i <= 300; i++)
			System.out.print(i + " ");
	}

	public static void b() {
		separador();
		int s = 0;
		for (int i = 1; i <= 1000; i++)
			s += i;
		System.out.println(s);
	}

	public static void c() {
		separador();
		int i = 0;
		for (i = 3; i <= 100; i += 3)
			System.out.print(i + " ");
	}

	public static void d() {
		separador();
		long fact = 1;
		for (int i = 1; i <= 30; i++) {
			fact *= i;
			System.out.println(i + "! = " + fact);
		}
	}

	public static void g() {
		separador();
		System.out.print("0 1");
		int a = 0, b = 1;
		while(b <= 100) {
			int c = a + b;
			System.out.print(" " + c);
			a = b;
			b = c;
		}
	}

	public static void h() {
		separador();
		int x = 13;
		System.out.print(x + " ");
		while(x != 1) {
			if(x % 2 == 0) {
				x /= 2;
			}else {
				x = 3 * x + 1;
			}
			System.out.print(x + " ");
		}
	}

	public static void i() {
		separador();
		for(int l = 1; l <= 5; l++){
			for(int c = 1; c <= l; c++) {
				System.out.print((l * c) + "\t");
			}
			System.out.println();
		}

	}

	public static void main(String[] args) {
		a();
		b();
		c();
		d();
		g();
		h();
		i();
	}
}
