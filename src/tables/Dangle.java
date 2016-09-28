package tables;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class Dangle {
	
	private String str = null;
	private float[] data = new float[5];
	private static List<Character> listEnclu = new ArrayList<Character>();
	private static boolean check = false;
	private static List<Dangle> listTable = new ArrayList<Dangle>();
	
	private Dangle() {
		listEnclu = new ArrayList<Character>();
		listEnclu.add('`');
		listEnclu.add('A');
		listEnclu.add('C');
		listEnclu.add('G');
		listEnclu.add('U');
	}
	
	public static List<Dangle> getListTable() {
		
		if (check == false) {
			
			List<String> listStr = new ArrayList<String>();
			listStr.add("UAX"); listStr.add("GCX");
			listStr.add("CGX"); listStr.add("UGX");
			listStr.add("AUX"); listStr.add("GUX");
			listStr.add("XUA"); listStr.add("XGC");
			listStr.add("XCG"); listStr.add("XUG");
			listStr.add("XAU"); listStr.add("XGU");
			
			try {
				
				FileReader fr = new FileReader("../NNTM/src/sources/dangle.dat");
				BufferedReader input = new BufferedReader(fr);
				String line = input.readLine();
				int count = 0;
				int countListString = 0;
				while (line != null) {
					Dangle table = new Dangle();
					table.str = listStr.get(countListString);
					String[] parts = line.split(" ");
					count = 0;
					for (int i=0; i<listEnclu.size(); i++) {
						if (i==0) table.data[i] = 0;
						else {
							table.data[i] = Float.parseFloat(parts[count]);
							count++;
						}
					}
					listTable.add(table);
					countListString++;
					line = input.readLine();
				}
				input.close();
				fr.close();
				
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
	
	public float[] getData() {
		return this.data;
	}
	
}
