package model;

public class BulgeLoop {
	
	private static BulgeLoop instance = null;
	
	private BulgeLoop() { }
	
	public static BulgeLoop shareInstance() {
		if (instance == null) {
			instance = new BulgeLoop();
		}
		return instance;
	}
	
	
	public boolean isBulgeLoop(String structure) {
		
		boolean isLeft = true;
		int i = 0;
		int j = structure.length()-1;
		boolean checkFreeBase = false;
		
		if (structure.charAt(i+1) == '(') {
			if (structure.charAt(i+2) == ')') {
				isLeft = false;
			}else {
				return false;
			}
		} else {
			if (structure.charAt(j-1) == ')') {
				if (structure.charAt(j-2) == '(') {
					isLeft = true;
				} else {
					return false;
				}
			} else {
				return false;
			}
		}
		
		if (isLeft == true) {
			for (int w=i+1; w<j-2; w++) {
				if (structure.charAt(w) != '.') {
					return false;
				}else {
					checkFreeBase = true;
				}
			}
		} else {
			for (int w=j-1; w>i+2; w--) {
				if (structure.charAt(w) != '.') {
					return false;
				} else {
					checkFreeBase = true;
				}
			}
		}
		
		if (checkFreeBase == true) {
			return true;
		} else {
			return false;
		}
		
	}

}
