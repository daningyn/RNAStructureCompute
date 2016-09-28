package tables;

import java.util.ArrayList;
import java.util.List;

public class DataTableLoop {

	private static DataTableLoop data = null;
	private DataTableLoop() {}
	
	public static DataTableLoop shareInstance() {
		if (data == null) {
			data = new DataTableLoop();
		}
		return data;
	}
	
	public List<Float> getDataHairpinLoop() {
		return HairpinLoop.listHairpinLoop();
	}
	
	public List<Float> getDataBulgeLoop() {
		return Bulge.listBulgeLoop();
	}
	
	public List<Float> getDataInternalLoop() {
		return Internal.listInternalLoop();
	}
	
}


class HairpinLoop {
	
	private static List<Float> hairpinLoop = new ArrayList<Float>();
	
	public static List<Float> listHairpinLoop() {
		if (hairpinLoop.size() == 0) {
			hairpinLoop.add((float) 0);
			hairpinLoop.add((float) 0);
			hairpinLoop.add((float) 0);
			hairpinLoop.add((float) 5.4);
			hairpinLoop.add((float) 5.6);
			hairpinLoop.add((float) 5.7);
			hairpinLoop.add((float) 5.4);
			hairpinLoop.add((float) 6.0);
			hairpinLoop.add((float) 5.5);
			hairpinLoop.add((float) 6.4);
			hairpinLoop.add((float) 6.5);
			hairpinLoop.add((float) 6.6);
			hairpinLoop.add((float) 6.7);
			hairpinLoop.add((float) 6.8);
			hairpinLoop.add((float) 6.9);
			hairpinLoop.add((float) 6.9);
			hairpinLoop.add((float) 7.0);
			hairpinLoop.add((float) 7.1);
			hairpinLoop.add((float) 7.1);
			hairpinLoop.add((float) 7.2);
			hairpinLoop.add((float) 7.2);
			hairpinLoop.add((float) 7.3);
			hairpinLoop.add((float) 7.3);
			hairpinLoop.add((float) 7.4);
			hairpinLoop.add((float) 7.4);
			hairpinLoop.add((float) 7.5);
			hairpinLoop.add((float) 7.5);
			hairpinLoop.add((float) 7.5);
			hairpinLoop.add((float) 7.6);
			hairpinLoop.add((float) 7.6);
			hairpinLoop.add((float) 7.7);
		}
		return hairpinLoop;
	}
	
}

class Internal {
	
	private static List<Float> internalLoop = new ArrayList<Float>();
	
	public static List<Float> listInternalLoop() {
		
		if (internalLoop.size() == 0) {
			internalLoop.add((float) 0);
			internalLoop.add((float) 0);
			internalLoop.add((float) 0);
			internalLoop.add((float) 0);
			internalLoop.add((float) 1.1);
			internalLoop.add((float) 2.0);
			internalLoop.add((float) 2.0);
			internalLoop.add((float) 2.1);
			internalLoop.add((float) 2.3);
			internalLoop.add((float) 2.4);
			internalLoop.add((float) 2.5);
			internalLoop.add((float) 2.6);
			internalLoop.add((float) 2.7);
			internalLoop.add((float) 2.8);
			internalLoop.add((float) 2.9);
			internalLoop.add((float) 2.9);
			internalLoop.add((float) 3.0);
			internalLoop.add((float) 3.1);
			internalLoop.add((float) 3.1);
			internalLoop.add((float) 3.2);
			internalLoop.add((float) 3.3);
			internalLoop.add((float) 3.3);
			internalLoop.add((float) 3.4);
			internalLoop.add((float) 3.4);
			internalLoop.add((float) 3.5);
			internalLoop.add((float) 3.5);
			internalLoop.add((float) 3.5);
			internalLoop.add((float) 3.6);
			internalLoop.add((float) 3.6);
			internalLoop.add((float) 3.7);
			internalLoop.add((float) 3.7);
		}
		return internalLoop;
		
	}
	
}

class Bulge {
	
	private static List<Float> bulgeLoop = new ArrayList<Float>();
	
	public static List<Float> listBulgeLoop() {
		
		if (bulgeLoop.size() == 0) {
			bulgeLoop.add((float) 0);
			bulgeLoop.add((float) 3.8);
			bulgeLoop.add((float) 2.8);
			bulgeLoop.add((float) 3.2);
			bulgeLoop.add((float) 3.6);
			bulgeLoop.add((float) 4.0);
			bulgeLoop.add((float) 4.4);
			bulgeLoop.add((float) 4.6);
			bulgeLoop.add((float) 4.7);
			bulgeLoop.add((float) 4.8);
			bulgeLoop.add((float) 4.9);
			bulgeLoop.add((float) 5.0);
			bulgeLoop.add((float) 5.1);
			bulgeLoop.add((float) 5.2);
			bulgeLoop.add((float) 5.3);
			bulgeLoop.add((float) 5.4);
			bulgeLoop.add((float) 5.4);
			bulgeLoop.add((float) 5.5);
			bulgeLoop.add((float) 5.5);
			bulgeLoop.add((float) 5.6);
			bulgeLoop.add((float) 5.7);
			bulgeLoop.add((float) 5.7);
			bulgeLoop.add((float) 5.8);
			bulgeLoop.add((float) 5.8);
			bulgeLoop.add((float) 5.8);
			bulgeLoop.add((float) 5.9);
			bulgeLoop.add((float) 5.9);
			bulgeLoop.add((float) 6.0);
			bulgeLoop.add((float) 6.0);
			bulgeLoop.add((float) 6.0);
			bulgeLoop.add((float) 6.1);
		}
		return bulgeLoop;
		
	}
	
}






