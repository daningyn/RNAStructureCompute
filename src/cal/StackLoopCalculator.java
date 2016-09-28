package cal;

import tables.Constants;

public class StackLoopCalculator {

	private static StackLoopCalculator obj = null;
	private StackLoopCalculator() {}
	
	public static StackLoopCalculator shareInstance() {
		if (obj == null) {
			obj = new StackLoopCalculator();
		}
		return obj;
	}
	
	public float computeDeltaG(String structure, String enclus) {
		
		return Constants.deltaGStack(enclus.charAt(0), enclus.charAt(3), enclus.charAt(1), enclus.charAt(2));
		
	}
	
}
