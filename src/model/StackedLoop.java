package model;

public class StackedLoop {
	
	private static StackedLoop instance = null;
	
	private StackedLoop() { }
	
	public static StackedLoop shareInstance() {
		if (instance == null) {
			instance = new StackedLoop();
		}
		return instance;
	}
	
	public boolean isStackedLoop(String structure) {
		
		if (structure.length() == 4) {
			
			if (structure.charAt(0) == '(' && structure.charAt(1) == '(' && structure.charAt(2) == ')' && structure.charAt(3) == ')') {
				return true;
			}
			
		}
		
		return false;
		
	}
	
}
