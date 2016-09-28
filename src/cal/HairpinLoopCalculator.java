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
			if (l == 3) {
				deltaG2 = Constants.nonGCterminal(enclus.charAt(0), enclus.charAt(enclus.length()-1));
				deltaG3 = 0;
			} else {
				deltaG2 = Constants.deltaGHairpinN(enclus);
				if (l == 4) {
					deltaG3 = Constants.deltaGHairpin4(enclus);
				}
			}
			
			if (bonus == "GG" && enclus.charAt(0) == 'G' && enclus.charAt(enclus.length()-1) == 'C') {
				deltaG4 = Constants.bonusGGG;
			} else if (checkEncluC(enclus) == true) {
				if (l == 3) {
					deltaG4 = Constants.CHairpin3;
				} else {
					deltaG4 = Constants.CHairpin2 + Constants.CHairpin1*l;
				}
			}
			deltaG = deltaG1 + deltaG2 + deltaG3 + deltaG4;
			
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
