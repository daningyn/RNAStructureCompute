package cal;

import java.util.ArrayList;
import java.util.List;

import tables.Constants;

public class MultiDomainCalculator {
	
	private static MultiDomainCalculator obj = null;
	private MultiDomainCalculator() {}
	public static MultiDomainCalculator shareInstance() {
		if (obj == null) {
			obj = new MultiDomainCalculator();
		}
		return obj;
	}
	
	public float computeDeltaG(String structure, String enclus) {
		
		List<Integer> arrayI = this.getI(structure);
		List<Integer> arrayJ = this.getJ(structure);
		float deltaG = 0;
		
		if (arrayI.size() == 0 || arrayJ.size() == 0) {
			return 0;
		} else {
		
			for (int i=0; i<arrayI.size(); i++) {
				deltaG = deltaG + Constants.nonGCterminal(enclus.charAt(arrayI.get(i)), enclus.charAt(arrayJ.get(i)));
			}
			
			deltaG = deltaG + Constants.deltaGDangle5p(enclus.charAt(arrayI.get(0)), enclus.charAt(arrayJ.get(0)), enclus.charAt(arrayI.get(0)-1));
			deltaG = deltaG + Constants.deltaGDangle3p(enclus.charAt(arrayI.get(arrayI.size()-1)), enclus.charAt(arrayJ.get(arrayJ.size()-1)), enclus.charAt(arrayJ.get(arrayJ.size()-1)+1));
			
			for (int i=0; i<arrayI.size()-1; i++) {
				deltaG = deltaG + Constants.deltaGDangle(enclus, arrayI.get(i), arrayJ.get(i), arrayI.get(i+1), arrayJ.get(i+1), "Normal");
			}
			
			return deltaG;
		}
	}
	
	private List<Integer> getI(String structure) {
		List<Integer> arr = new ArrayList<Integer>();
		for (int i=1; i<structure.length(); i++) {
			if (structure.charAt(i) == '(') {
				arr.add(i);
			}
		}
		if (arr.size() < 1) return new ArrayList<Integer>();
		else return arr;
	}
	
	private List<Integer> getJ(String structure) {
		List<Integer> arr = new ArrayList<Integer>();
		for (int i=2; i<structure.length()-1; i++) {
			if (structure.charAt(i) == ')') {
				arr.add(i);
			}
		}
		if (arr.size() < 1) return new ArrayList<Integer>();
		else return arr;
	}
	
	
}
