package tables;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class Tstacki {

	private String str = null;
	private float[][] data = new float[5][5];
	private static List<Character> listEnclu = new ArrayList<Character>();
	private static boolean check = false;
	private static List<Tstacki> listTable = new ArrayList<Tstacki>();
	
	private Tstacki() {
		listEnclu = new ArrayList<Character>();
		listEnclu.add('`');
		listEnclu.add('A');
		listEnclu.add('C');
		listEnclu.add('G');
		listEnclu.add('U');
	}
	
	public static List<Tstacki> getListTable() {
		
		if (check == false) {
			
			List<String> listStr = new ArrayList<String>();
			listStr.add("AU"); listStr.add("CG");
			listStr.add("GC"); listStr.add("GU");
			listStr.add("UA"); listStr.add("UG");
			
			try {
				
				FileReader fr = new FileReader("../NNTM/src/sources/tstacki.dat");
				BufferedReader input = new BufferedReader(fr);
				String line = input.readLine();
				int count = 0;
				int countListString = 0;
				while (line != null) {
					Tstacki table = new Tstacki();
					table.str = listStr.get(countListString);
					String[] parts = line.split(" ");
					count = 0;
					for (int i=0; i<listEnclu.size(); i++) {
						for (int j=0; j<listEnclu.size(); j++) {
							if (i==0 || j==0) table.data[i][j] = 0;
							else {
								if (parts[count].equals(".") == true) {
									table.data[i][j] = 0;
								} else {
									table.data[i][j] = Float.parseFloat(parts[count]);
								}
								count++;
							}
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
	
	public float[][] getData() {
		return this.data;
	}
	
}
