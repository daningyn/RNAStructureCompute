package cal;

import tables.Constants;

public class HairpinLoopCalculator {

	private static HairpinLoopCalculator obj = null;
	private HairpinLoopCalculator() {}
	
	public static HairpinLoopCalculator shareInstance() {
		if (obj == null) {
			obj = new HairpinLoopCalculator();
		}
		return obj;
	}
	
	public float computeDeltaG(String structure, String enclus, String bonus) {
		
		enclus = enclus.toUpperCase();
		float deltaG1 = 0, deltaG2 = 0, deltaG3 = 0, deltaG4 = 0, deltaG = 0;
		int l = structure.length() - 2;
		
		if (l < 3) return -999999;
		else  {
			
			deltaG1 = Constants.deltaGLengthH(l);
			System.out.println("DeltaG1: "+deltaG1);
			if (l == 3) {
				deltaG2 = Constants.nonGCterminal(enclus.charAt(0), enclus.charAt(enclus.length()-1));
				System.out.println("DeltaG2: "+deltaG2);
				deltaG3 = 0;
				System.out.println("DeltaG3: "+deltaG3);
			} else {
				deltaG2 = Constants.deltaGHairpinN(enclus);
				System.out.println("DeltaG2: "+deltaG2);
				if (l == 4) {
					deltaG3 = Constants.deltaGHairpin4(enclus);
					System.out.println("DeltaG3: "+deltaG3);
				}
			}
			
			if (bonus == "GG" && enclus.charAt(0) == 'G' && enclus.charAt(enclus.length()-1) == 'C') {
				deltaG4 = Constants.bonusGGG;
				System.out.println("DeltaG4: "+deltaG4);
			} else if (checkEncluC(enclus) == true) {
				if (l == 3) {
					deltaG4 = Constants.CHairpin3;
					System.out.println("DeltaG4: "+deltaG4);
				} else {
					deltaG4 = Constants.CHairpin2 + Constants.CHairpin1*l;
					System.out.println("DeltaG4: "+deltaG4);
				}
			}
			deltaG = deltaG1 + deltaG2 + deltaG3 + deltaG4;
			System.out.println("DeltaG: "+deltaG);
			
		}
		
		
		return (float) deltaG;
		
	}
	
	private boolean checkEncluC(String enclus) {
		for (int i=1; i<enclus.length()-1; i++) {
			if (enclus.charAt(i) != 'C') return false;
		}
		return true;
	}
	
}
