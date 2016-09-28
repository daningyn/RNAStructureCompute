package tables;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class Int21 {

	private String str = null;
	private float[][] data = new float[5][5];
	private static List<Character> listEnclu = new ArrayList<Character>();
	private static boolean check = false;
	private static List<Int21> listTable = new ArrayList<Int21>();
	
	private Int21() {
		listEnclu = new ArrayList<Character>();
		listEnclu.add('`');
		listEnclu.add('A');
		listEnclu.add('C');
		listEnclu.add('G');
		listEnclu.add('U');
	}
	
	public static List<Int21> getListTable() {
		
		if (check == false) {
			
			List<String> listStr = new ArrayList<String>();
			listStr.add("AXAUAYU");listStr.add("AXCGAYU");listStr.add("AXGCAYU");listStr.add("AXUAAYU");listStr.add("AXGUAYU");listStr.add("AXUGAYU");
			listStr.add("AXAUCYU");listStr.add("AXCGCYU");listStr.add("AXGCCYU");listStr.add("AXUACYU");listStr.add("AXGUCYU");listStr.add("AXUGCYU");
			listStr.add("AXAUGYU");listStr.add("AXCGGYU");listStr.add("AXGCGYU");listStr.add("AXUAGYU");listStr.add("AXGUGYU");listStr.add("AXUGGYU");
			listStr.add("AXAUUYU");listStr.add("AXCGUYU");listStr.add("AXGCUYU");listStr.add("AXUAUYU");listStr.add("AXGUUYU");listStr.add("AXUGUYU");
			
			listStr.add("CXAUAYG");listStr.add("CXCGAYG");listStr.add("CXGCAYG");listStr.add("CXUAAYG");listStr.add("CXGUAYG");listStr.add("CXUGAYG");
			listStr.add("CXAUCYG");listStr.add("CXCGCYG");listStr.add("CXGCCYG");listStr.add("CXUACYG");listStr.add("CXGUCYG");listStr.add("CXUGCYG");
			listStr.add("CXAUGYG");listStr.add("CXCGGYG");listStr.add("CXGCGYG");listStr.add("CXUAGYG");listStr.add("CXGUGYG");listStr.add("CXUGGYG");
			listStr.add("CXAUUYG");listStr.add("CXCGUYG");listStr.add("CXGCUYG");listStr.add("CXUAUYG");listStr.add("CXGUUYG");listStr.add("CXUGUYG");
			
			listStr.add("GXAUAYC");listStr.add("GXCGAYC");listStr.add("GXGCAYC");listStr.add("GXUAAYC");listStr.add("GXGUAYC");listStr.add("GXUGAYC");
			listStr.add("GXAUCYC");listStr.add("GXCGCYC");listStr.add("GXGCCYC");listStr.add("GXUACYC");listStr.add("GXGUCYC");listStr.add("GXUGCYC");
			listStr.add("GXAUGYC");listStr.add("GXCGGYC");listStr.add("GXGCGYC");listStr.add("GXUAGYC");listStr.add("GXGUGYC");listStr.add("GXUGGYC");
			listStr.add("GXAUUYC");listStr.add("GXCGUYC");listStr.add("GXGCUYC");listStr.add("GXUAUYC");listStr.add("GXGUUYC");listStr.add("GXUGUYC");
			
			listStr.add("UXAUAYA");listStr.add("UXCGAYA");listStr.add("UXGCAYA");listStr.add("UXUAAYA");listStr.add("UXGUAYA");listStr.add("UXUGAYA");
			listStr.add("UXAUCYA");listStr.add("UXCGCYA");listStr.add("UXGCCYA");listStr.add("UXUACYA");listStr.add("UXGUCYA");listStr.add("UXUGCYA");
			listStr.add("UXAUGYA");listStr.add("UXCGGYA");listStr.add("UXGCGYA");listStr.add("UXUAGYA");listStr.add("UXGUGYA");listStr.add("UXUGGYA");
			listStr.add("UXAUUYA");listStr.add("UXCGUYA");listStr.add("UXGCUYA");listStr.add("UXUAUYA");listStr.add("UXGUUYA");listStr.add("UXUGUYA");
			
			listStr.add("GXAUAYU");listStr.add("GXCGAYU");listStr.add("GXGCAYU");listStr.add("GXUAAYU");listStr.add("GXGUAYU");listStr.add("GXUGAYU");
			listStr.add("GXAUCYU");listStr.add("GXCGCYU");listStr.add("GXGCCYU");listStr.add("GXUACYU");listStr.add("GXGUCYU");listStr.add("GXUGCYU");
			listStr.add("GXAUGYU");listStr.add("GXCGGYU");listStr.add("GXGCGYU");listStr.add("GXUAGYU");listStr.add("GXGUGYU");listStr.add("GXUGGYU");
			listStr.add("GXAUUYU");listStr.add("GXCGUYU");listStr.add("GXGCUYU");listStr.add("GXUAUYU");listStr.add("GXGUUYU");listStr.add("GXUGUYU");
			
			listStr.add("UXAUAYG");listStr.add("UXCGAYG");listStr.add("UXGCAYG");listStr.add("UXUAAYG");listStr.add("UXGUAYG");listStr.add("UXUGAYG");
			listStr.add("UXAUCYG");listStr.add("UXCGCYG");listStr.add("UXGCCYG");listStr.add("UXUACYG");listStr.add("UXGUCYG");listStr.add("UXUGCYG");
			listStr.add("UXAUGYG");listStr.add("UXCGGYG");listStr.add("UXGCGYG");listStr.add("UXUAGYG");listStr.add("UXGUGYG");listStr.add("UXUGGYG");
			listStr.add("UXAUUYG");listStr.add("UXCGUYG");listStr.add("UXGCUYG");listStr.add("UXUAUYG");listStr.add("UXGUUYG");listStr.add("UXUGUYG");
			
			try {
				
				FileReader fr = new FileReader("../NNTM/src/sources/int21.dat");
				BufferedReader input = new BufferedReader(fr);
				String line = input.readLine();
				
				int count = 0;
				int countListString = 0;
				while (line != null) {
					
					Int21 table = new Int21();
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
				
			}catch (Exception e) {
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
	
	public static void main(String[] args) {
		
		for (int i=0; i<Int22.getListTable().size(); i++) {
			System.out.println(i);
			System.out.println(Int22.getListTable().get(i).getStr());
			for (int j=1; j<17; j++) {
				System.out.println(Int22.getListTable().get(j).getData()[j][1]+" "+Int22.getListTable().get(i).getData()[j][2]+" "+Int22.getListTable().get(i).getData()[j][3]+" "+Int22.getListTable().get(i).getData()[j][4]+" "+Int22.getListTable().get(i).getData()[j][5]+" "+Int22.getListTable().get(i).getData()[j][6]+" "+Int22.getListTable().get(i).getData()[j][7]+" "+Int22.getListTable().get(i).getData()[j][8]+" "+Int22.getListTable().get(i).getData()[j][9]+" "+Int22.getListTable().get(i).getData()[j][10]+" "+Int22.getListTable().get(i).getData()[j][11]+" "+Int22.getListTable().get(i).getData()[j][12]+" "+Int22.getListTable().get(i).getData()[j][13]+" "+Int22.getListTable().get(i).getData()[j][14]+" "+Int22.getListTable().get(i).getData()[j][15]+" "+Int22.getListTable().get(i).getData()[j][16]);
			}
		}
		
	}
	
}
