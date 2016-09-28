package tables;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DataTableStacked { //Full Table Stacked
	
	private static List<ClosingPairs> arrClosingPairs = new ArrayList<ClosingPairs>();
	
	private DataTableStacked() {
		
	}
	
	public static List<ClosingPairs> shareInstance() {
		if (arrClosingPairs.size() == 0) {
			arrClosingPairs = SourcesTable.getFullTable();
		}
		return arrClosingPairs;
	}
	
	public static void main(String a[]) {
		for (ClosingPairs abc : SourcesTable.getFullTable()) {
			System.out.println(abc.getClosingPair());
			System.out.println();
			for (DetailPairs abd : abc.getArrayDetailPairs()) {
				System.out.println(abd.getX()+""+abd.getY()+" = "+abd.getResult());
			}
		}
	}

}


class ClosingPairs { // One Table In Stacked
	
	private String closingPairs;
	private List<DetailPairs> arrDetailPairs = new ArrayList<DetailPairs>();

	public ClosingPairs(String closingPairs, List<DetailPairs> arrDetailPairs) {
		this.closingPairs = closingPairs;
		this.arrDetailPairs = arrDetailPairs;
	}
	
	public String getClosingPair() {
		return this.closingPairs;
	}
	
	public List<DetailPairs> getArrayDetailPairs() {
		return this.arrDetailPairs;
	}
	
}

class DetailPairs { // One Detail Pair
	
	private Float results;
	private Character X;
	private Character Y;
	
	public DetailPairs(Float results, Character X, Character Y) {
		this.results = results;
		this.X = X;
		this.Y = Y;
	}
	
	public Character getX() {
		return this.X;
	}
	
	public Character getY() {
		return this.Y;
	}
	
	public Float getResult() {
		return this.results;
	}
	
}

class SourcesTable {
	
	private static List<String> staticClosingPairs = new ArrayList<String>();
	private static char[] arrEnclu = {'A', 'C', 'G', 'U'};
	
	public static List<String> getStaticClosingPairs() {
		
		if (staticClosingPairs.size() == 0) {
			for (char firstChar: arrEnclu) {
				for (char secondChar: arrEnclu) {
					char[] closingPair = {firstChar, secondChar};
					String newClosingPair = new String(closingPair);
					staticClosingPairs.add(newClosingPair);
				}
			}
		}
		
		return staticClosingPairs;
	}
	
	public static List<ClosingPairs> getFullTable() {
		List<String> closingPairs = SourcesTable.getStaticClosingPairs();
		List<ClosingPairs> fullTable = new ArrayList<ClosingPairs>();
		try {
			FileReader fr = new FileReader("../NNTM/src/sources/stack.dat");
			BufferedReader input = new BufferedReader(fr);
			String line = input.readLine();
			String closingPair = "";
			int count = 0;
			int pair = 0;
			List<DetailPairs> arrDetailPairs = new ArrayList<DetailPairs>();
			while (line != null) {
				System.out.println(line);
				if (line.length() == 2) {
					closingPair = line;
					pair = 0;
					count = 0;
					arrDetailPairs = new ArrayList<DetailPairs>();
				} else {
					count++;
					String[] parts = line.split(" ");
//					for (String aaa: parts) {
//						System.out.println("fuck  "+aaa);
//					}
					for (int j=0; j<4; j++) {
						Float result;
						if (parts[j].equals(".")) {
							result = (float) 0;
						} else {
							result = Float.parseFloat(parts[j]);
						}
						String closePair = closingPairs.get(pair);
						DetailPairs detailPair = new DetailPairs(result, closePair.charAt(0), closePair.charAt(1));
						arrDetailPairs.add(detailPair);
					
						pair++;
					}
					
					if (count == 4 && arrDetailPairs.size() == 16) {
						ClosingPairs oneTable = new ClosingPairs(closingPair, arrDetailPairs);
						fullTable.add(oneTable);
					}
					
				}
				
				
				line = input.readLine();
			}
			input.close();
			fr.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return fullTable;
		
	}
	
}

