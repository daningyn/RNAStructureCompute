package tables;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Int11 {

	private String str = null;
	private float[][] data = new float[5][5];
	private static List<Character> listEnclu = new ArrayList<Character>();
	private static boolean check = false;
	private static List<Int11> listTable = new ArrayList<Int11>();
	
	private Int11() {
		listEnclu = new ArrayList<Character>();
		listEnclu.add('`');
		listEnclu.add('A');
		listEnclu.add('C');
		listEnclu.add('G');
		listEnclu.add('U');
	}
	
	public static List<Int11> getListTable() {
		if (check == false) {
			List<String> listStr = new ArrayList<String>();
			listStr.add("AAUU");listStr.add("ACGU");listStr.add("AGCU");listStr.add("AUAU");listStr.add("AGUU");listStr.add("AUGU");
			listStr.add("CAUG");listStr.add("CCGG");listStr.add("CGCG");listStr.add("CUAG");listStr.add("CGUG");listStr.add("CUGG");
			listStr.add("GAUC");listStr.add("GCGC");listStr.add("GGCC");listStr.add("GUAC");listStr.add("GGUC");listStr.add("GUGC");
			listStr.add("UAUA");listStr.add("UCGA");listStr.add("UGCA");listStr.add("UUAA");listStr.add("UGUA");listStr.add("UUGA");
			listStr.add("GAUU");listStr.add("GCGU");listStr.add("GGCU");listStr.add("GUAU");listStr.add("GGUU");listStr.add("GUGU");
			listStr.add("UAUG");listStr.add("UCGG");listStr.add("UGCG");listStr.add("UUAG");listStr.add("UGUG");listStr.add("UUGG");
			try {
				FileReader fr = new FileReader("../NNTM/src/sources/int11.dat");
				BufferedReader input = new BufferedReader(fr);
				String line = input.readLine();
				int count = 0;
				int countListString = 0;
				while (line != null) {
					Int11 table = new Int11();
					table.str = listStr.get(countListString);
					String[] parts = line.split(" ");
					count = 0;
					for (int i=0; i<listEnclu.size(); i++) {
						for (int j=0; j<listEnclu.size(); j++) {
							if (i==0 || j==0) table.data[i][j] = 0;
							else {
								table.data[i][j] = Float.parseFloat(parts[count]);
								count++;
							}
						}
					}
					listTable.add(table);
					countListString++;
					line = input.readLine();
				}
				fr.close();
				input.close();
			
			} catch (IOException e) {
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