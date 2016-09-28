package model;

public class InternalLoop {
	
	private static InternalLoop instance = null;
	
	private InternalLoop() { }
	
	public static InternalLoop shareInstance() {
		if (instance == null) {
			instance = new InternalLoop();
		}
		return instance;
	}
	
	public boolean isInternalLoop(String structure) {
		int i = 0;
		int j = structure.length()-1;
		boolean checkI = false;
		int i1 = 0, j1 = 0;
		for (int w=1; w<structure.length()-1; w++) {
			if (structure.charAt(w) == '(' && w > i+1) {
				if (checkI == false) {
					checkI = true;
					i1 = w;
					if (structure.charAt(w+1) == ')') {
						j1 = w+1;
					}else {
						return false;
					}
				}else {
					return false;
				}
			}
		}
		
		if (i1 == 0 && j1 == 0) return false;
		
		for (int w=i+1; w<i1; w++) {
			if (structure.charAt(w) != '.') {
				return false;
			}
		}
		for (int w=j1+1; w<j; w++) {
			if (structure.charAt(w) != '.') {
				return false;
			}
		}
		return true;
	}

}
