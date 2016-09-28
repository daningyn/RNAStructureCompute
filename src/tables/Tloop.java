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
		if (str.equals("CUACGG")) return (float) 2.8;
		else if (str.equals("CUCCGG")) return (float) 2.7;
		else if (str.equals("CUUCGG")) return (float) 3.7;
		else if (str.equals("CUUUGG")) return (float) 3.7;
		else if (str.equals("CCAAGG")) return (float) 3.3;
		else if (str.equals("CCCAGG")) return (float) 3.4;
		else if (str.equals("CCGAGG")) return (float) 3.5;
		else if (str.equals("CCUAGG")) return (float) 3.7;
		else if (str.equals("CCACGG")) return (float) 3.7;
		else if (str.equals("CCGCGG")) return (float) 3.6;
		else if (str.equals("CCUCGG")) return (float) 2.5;
		else if (str.equals("CUAAGG")) return (float) 3.6;
		else if (str.equals("CUCAGG")) return (float) 3.7;
		else if (str.equals("CUUAGG")) return (float) 3.5;
		else if (str.equals("CUGCGG")) return (float) 2.8;
		else if (str.equals("CAACGG")) return (float) 5.5;
		
		return 0;
	}
	
}
