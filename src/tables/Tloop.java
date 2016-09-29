package tables;

public class Tloop {

	private static Tloop tloop = null;
	private Tloop() {}
	
	public static Tloop shareInstance() {
		if (tloop == null) {
			tloop = new Tloop();
		}
		return tloop;
	}
	
	public float getData(Character A, Character B, Character C, Character D, Character E, Character F) {
		char[] a = {(char) A, (char) B, (char) C, (char) D, (char) E, (char) F};
		String str = new String(a);
		if (str.equals("GGGGAC")) return (float) -3.0;
		else if (str.equals("GGUGAC")) return (float) -3.0;
		else if (str.equals("CGAAAG")) return (float) -3.0;
		else if (str.equals("GGAGAC")) return (float) -3.0;
		else if (str.equals("CGCAAG")) return (float) -3.0;
		else if (str.equals("GGAAAC")) return (float) -3.0;
		else if (str.equals("CGGAAG")) return (float) -3.0;
		else if (str.equals("CUUCGG")) return (float) -3.0;
		else if (str.equals("CGUGAG")) return (float) -3.0;
		else if (str.equals("CGAAGG")) return (float) -2.5;
		else if (str.equals("CUACGG")) return (float) -2.5;
		else if (str.equals("GGCAAC")) return (float) -2.5;
		else if (str.equals("CGCGAG")) return (float) -2.5;
		else if (str.equals("UGAGAG")) return (float) -2.5;
		else if (str.equals("CGAGAG")) return (float) -2.0;
		else if (str.equals("AGAAAU")) return (float) -2.0;
		else if (str.equals("CGUAAG")) return (float) -2.0;
		else if (str.equals("CUAACG")) return (float) -2.0;
		else if (str.equals("UGAAAG")) return (float) -2.0;
		else if (str.equals("GGAAGC")) return (float) -1.5;
		else if (str.equals("GGGAAC")) return (float) -1.5;
		else if (str.equals("UGAAAA")) return (float) -1.5;
		else if (str.equals("AGCAAU")) return (float) -1.5;
		else if (str.equals("AGUAAU")) return (float) -1.5;
		else if (str.equals("CGGGAG")) return (float) -1.5;
		else if (str.equals("AGUGAU")) return (float) -1.5;
		else if (str.equals("GGCGAC")) return (float) -1.5;
		else if (str.equals("GGGAGC")) return (float) -1.5;
		else if (str.equals("GUGAAC")) return (float) -1.5;
		else if (str.equals("UGGAAA")) return (float) -1.5;
		
		return 0;
	}
	
}
