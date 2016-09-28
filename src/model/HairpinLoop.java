package model;

public class HairpinLoop {

	private static HairpinLoop instance = null;
	
	private HairpinLoop() { }
	
	public static HairpinLoop shareInstance() {
		if (instance == null) {
			instance = new HairpinLoop();
		}
		return instance;
	}
	
	public boolean isHairpinLoop(String structure) {
		
		if (structure.length() > 4) {
			String subStructure = structure.substring(1, structure.length()-1);
			if (subStructure.length() <= 2) return false;
			for (int i=0; i<subStructure.length(); i++) {
				if (subStructure.charAt(i) != '.') {
					return false;
				}
			}
			return true;
		}
		
		return false;
		
		
	}
	
}
