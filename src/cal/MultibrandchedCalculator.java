package cal;

import java.util.ArrayList;
import java.util.List;

import tables.Constants;

public class MultibrandchedCalculator {

	private static MultibrandchedCalculator obj = null;
	private MultibrandchedCalculator() {}
	public static MultibrandchedCalculator shareInstance() {
		if (obj == null) {
			obj = new MultibrandchedCalculator();
		}
		return obj;
	}
	
	public float computeDeltaG(String structure, String enclus) {
		
		List<Integer> arrayI = this.getI(structure);
		List<Integer> arrayJ = this.getJ(structure);
		float deltaG = 0;
		int temp = 0;
		
		deltaG = deltaG + Constants.Multia;
		deltaG = deltaG + Constants.Multib * (arrayI.size());
		for (int i=1; i<arrayI.size()-1; i++) {
			temp = temp + arrayI.get(i+1) - arrayI.get(i) - 1;
		}
		deltaG = deltaG + Constants.Multic * (arrayI.get(1) - arrayI.get(0) - 1 + temp + arrayJ.get(0) - arrayJ.get(arrayJ.size()-1) - 1);
		deltaG = deltaG + Constants.nonGCterminal(enclus.charAt(0), enclus.charAt(enclus.length()-1));
		float temp1 = 0;
		for (int i=1; i<arrayI.size(); i++) {
			temp1 = temp1 + Constants.nonGCterminal(enclus.charAt(arrayI.get(i)), enclus.charAt(arrayJ.get(i)));
		}
		deltaG = deltaG + temp1;
		deltaG = deltaG + Constants.deltaGDangle(enclus, arrayJ.get(0), arrayI.get(0), arrayI.get(1), arrayJ.get(1));
		temp1 = 0;
		for (int i=1; i<arrayI.size()-1; i++) {
			temp1 = temp1 + Constants.deltaGDangle(enclus, arrayI.get(i), arrayJ.get(i), arrayI.get(i+1), arrayJ.get(i+1));
		}
		deltaG = deltaG + temp1;
		deltaG = deltaG + Constants.deltaGDangle(enclus, arrayI.get(arrayI.size()-1), arrayJ.get(arrayJ.size()-1), arrayJ.get(0), arrayI.get(0));
		
		return deltaG;
	}
	
	private List<Integer> getI(String structure) {
		List<Integer> arr = new ArrayList<Integer>();
		arr.add(0);
		for (int i=1; i<structure.length(); i++) {
			if (structure.charAt(i) == '(') {
				arr.add(i);
			}
		}
		if (arr.size() < 3) return new ArrayList<Integer>();
		else return arr;
	}
	
	private List<Integer> getJ(String structure) {
		List<Integer> arr = new ArrayList<Integer>();
		arr.add(structure.length()-1);
		for (int i=1; i<structure.length()-1; i++) {
			if (structure.charAt(i) == ')') {
				arr.add(i);
			}
		}
		if (arr.size() < 3) return new ArrayList<Integer>();
		else return arr;
	}
	
}
