package tables;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class Int22 {

	private String str = null;
	private float[][] data = new float[17][17];
	private static List<String> listEnclu = new ArrayList<String>();
	private static boolean check = false;
	private static List<Int22> listTable = new ArrayList<Int22>();
	
	private Int22() {
		listEnclu = new ArrayList<String>();
		listEnclu.add("``");
		listEnclu.add("AA");
		listEnclu.add("AC");
		listEnclu.add("AG");
		listEnclu.add("AU");
		listEnclu.add("CA");
		listEnclu.add("CC");
		listEnclu.add("CG");
		listEnclu.add("CU");
		listEnclu.add("GA");
		listEnclu.add("GC");
		listEnclu.add("GG");
		listEnclu.add("GU");
		listEnclu.add("UA");
		listEnclu.add("UC");
		listEnclu.add("UG");
		listEnclu.add("UU");
	}
	
	public static List<Int22> getListTable() {
		if (check == false) {
			
			List<String> listStr = new ArrayList<String>();
			
			try {
				
				FileReader fr = new FileReader("../NNTM/src/sources/STRINGint22.dat");
				BufferedReader input = new BufferedReader(fr);
				String line = input.readLine();
				while (line != null) {
					listStr.add(line);
					line = input.readLine();
				}
				fr.close();
				input.close();
				
				fr = new FileReader("../NNTM/src/sources/int22.dat");
				input = new BufferedReader(fr);
				line = input.readLine();
				
				int countListString = 0;
				int count = 0;
				while (line != null) {
					
					Int22 table = new Int22();
					table.str = listStr.get(countListString);
					String[] parts = line.split(" ");
					
					for (int i=0; i<listEnclu.size(); i++) {
						for (int j=0; j<listEnclu.size(); j++) {
							if (i == 0 || j == 0) table.data[i][j] = 0;
							else {
								table.data[i][j] = Float.parseFloat(parts[count]);
								count++;
							}
						}
						if (i != 0) {
							line = input.readLine();
							count = 0;
						}
					}
					listTable.add(table);
					countListString++;
					
				}
				fr.close();
				input.close();
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			check = true;
		}
		return listTable;
	}
	
	public String getStr() {
		return this.str;
	}
	
	public float[][] getData() {
		return this.data;
	}
	
}
