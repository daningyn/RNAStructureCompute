package cal;

import tables.Constants;

public class InternalLoopCalculator {

	private static InternalLoopCalculator obj = null;
	private InternalLoopCalculator() {}
	public static InternalLoopCalculator shareInstance() {
		if (obj == null) {
			obj = new InternalLoopCalculator();
		}
		return obj;
	}
	
	public float computeDeltaG(String structure, String enclus) {
		enclus = enclus.toUpperCase();
		float deltaG1=0, deltaG2=0, deltaG3=0, deltaG4=0, deltaG=0;
		int l1 = getLength(structure)[0];
		int l2 = getLength(structure)[1];
		int l = l1+l2;
		int i = getI(structure)[0], i1 = getI(structure)[1];
		int j = getJ(structure)[1], j1 = getJ(structure)[0];
		
		if (l1 == 0 || l2 == 0) {
			deltaG = Constants.deltaGLengthB(l);
			if (l1+l2 == 1) {
				deltaG = deltaG + Constants.deltaGStack(enclus.charAt(i), enclus.charAt(j), enclus.charAt(i1), enclus.charAt(j1));
				System.out.println("DeltaG: "+deltaG);
			} else {
				deltaG = deltaG + Constants.nonGCterminal(enclus.charAt(i), enclus.charAt(j)) + Constants.nonGCterminal(enclus.charAt(i1), enclus.charAt(j1));
				System.out.println("DeltaG: "+deltaG);
			}
		} else if (l1 == 1 && l2 == 1) {
			deltaG = Constants.deltaGInternal2(enclus);
			System.out.println("DeltaG: "+deltaG);
		} else if (l1 == 1 && l2 == 2) {
			deltaG = Constants.deltaGInternal3(enclus.charAt(0), enclus.charAt(enclus.length()-1), enclus.charAt(2), enclus.charAt(3), enclus.charAt(1), enclus.charAt(enclus.length()-2), enclus.charAt(4));
			System.out.println("DeltaG: "+deltaG);
		} else if (l1 == 2 && l2 == 1) {
			deltaG = Constants.deltaGInternal3(enclus.charAt(j1), enclus.charAt(i1), enclus.charAt(j), enclus.charAt(i), enclus.charAt(j1+1), enclus.charAt(i1-1), enclus.charAt(i+1));
			System.out.println("DeltaG: "+deltaG);
		} else if (l1 == 2 && l2 == 2) {
			deltaG = Constants.deltaGInternal4(enclus.charAt(i), enclus.charAt(j), enclus.charAt(i1), enclus.charAt(j1), enclus.charAt(i+1), enclus.charAt(j-1), enclus.charAt(i1-1), enclus.charAt(j1+1));
			System.out.println("DeltaG: "+deltaG);
		} else {
			deltaG1 = Constants.deltaGLengthI(l);
			System.out.println("DeltaG: "+deltaG);
			if ((l1 == 1 || l2 == 1) && Constants.GailRule == 1) {
				deltaG2 = Constants.deltaGInternalN(enclus.charAt(i), enclus.charAt(j), 'A', 'A');
				System.out.println("DeltaG2: "+deltaG2);
				deltaG3 = Constants.deltaGInternalN(enclus.charAt(i1), enclus.charAt(j1), 'A', 'A');
				System.out.println("DeltaG3: "+deltaG3);
			} else {
				deltaG2 = Constants.deltaGInternalN(enclus.charAt(i), enclus.charAt(j), enclus.charAt(i+1), enclus.charAt(j-1));
				System.out.println("DeltaG2: "+deltaG2);
				deltaG3 = Constants.deltaGInternalN(enclus.charAt(j1), enclus.charAt(i1), enclus.charAt(j1+1), enclus.charAt(i1-1));
				System.out.println("DeltaG3: "+deltaG3);
			}
			deltaG4 = Constants.deltaGAsymmetry(l1, l2);
			System.out.println("DeltaG4: "+deltaG4);
			deltaG = deltaG1 + deltaG2 + deltaG3 + deltaG4;
			System.out.println("DeltaGTong: "+deltaG);
		}
		
		return deltaG;
	}
	
	private int[] getLength(String structure) {
		int l1=0, l2=0;
		int j=2;
		for (int i=1; i<structure.length(); i++) {
			if (structure.charAt(i) == '(') {
				j=i+1;
				break;
			} else {
				l1++;
			}
		}
		for (int i=j+1; i<structure.length()-1; i++) {
			l2++;
		}
		int[] l = {l1, l2};
		return l;
	}
	
	private int[] getI(String structure) {
		int[] temp = new int[2];
		temp[0] = -1; temp[1] = -1;
		for (int i=0; i<structure.length(); i++) {
			if (structure.charAt(i) == '(') {
				if (temp[0] != -1) temp[1]=i;
				else temp[0] = i;
			}
		}
		return temp;
	}
	
	private int[] getJ(String structure) {
		int[] temp = new int[2];
		temp[0] = -1; temp[1] = -1;
		for (int i=0; i<structure.length(); i++) {
			if (structure.charAt(i) == ')') {
				if (temp[0] != -1) temp[1]=i;
				else temp[0] = i;
			}
		}
		return temp;
	}
	
}
