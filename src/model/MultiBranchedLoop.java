package model;

import java.util.ArrayList;
import java.util.List;

public class MultiBranchedLoop {
	
	List<Integer> closingPairs = new ArrayList<Integer>();
	
	private static MultiBranchedLoop instance = null;
	
	private MultiBranchedLoop() { }
	
	public static MultiBranchedLoop shareInstance() {
		if (instance == null) {
			instance = new MultiBranchedLoop();
		} else {
			instance.closingPairs = new ArrayList<Integer>();
		}
		return instance;
	}
	
	public boolean isMultiBrandedLoop(String structure) {
		
		int i = 0;
		int j = structure.length()-1;
		
		for (int w=i+1; w<j; w++) {
			if (structure.charAt(w) == '(') {
				if (structure.charAt(w+1) != ')') return false;
				this.closingPairs.add(w);
			}
		}
		
		if (this.closingPairs.size() < 2) return false;
		
		for (int w=i+1; w<j; w++) {
			if (structure.charAt(w) == '(') {
//				if (structure.charAt(w-1) != '.') return false;
				if (structure.charAt(w+1) != ')') return false;
			} else {
				
			}
		}
		
		return true;
		
	}

}
