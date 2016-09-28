package model;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
	
	private static Scanner scanner;
	private static String structure;
	private static String enclu;
	private static List<Character> struc = new ArrayList<Character>();
	private static List<Character> strucEnclu = new ArrayList<Character>();
	private static List<Boolean> checkStruc = new ArrayList<Boolean>();
	private static String subStructure;
	private static String subEnclu;

	public static void main(String[] args) {
		
		scanner = new Scanner(System.in);
		System.out.print("Nhap String: ");
		structure = scanner.nextLine();
		System.out.print("Nhap Enclu: ");
		enclu = scanner.nextLine();
		for (int j=0; j<structure.length(); j++) {
			struc.add(structure.charAt(j));
			strucEnclu.add(enclu.charAt(j));
			checkStruc.add(false);
		}
		
		int i = 0;
		
		while (i < struc.size()) {
			if (struc.get(i) == ')') {
				 for (int j=i-1; j>=0; j--) {
					 if (struc.get(j) == '(' && checkStruc.get(j) == false) {
						 subStructure = "";
						 subEnclu = "";
						 for (int k=j; k<=i; k++) {
							 subStructure += struc.get(k);
							 subEnclu += strucEnclu.get(k);
						 }
						 int tmp = j+1;
						 int tmp1 = i;
						 for (int k=j+1; k<tmp1; k++) {
							 struc.remove(tmp);
							 strucEnclu.remove(tmp);
							 checkStruc.remove(tmp);
							 i--;
						 }
						 checkStruc.set(j, true);
						 System.out.println(subStructure+"---"+subEnclu);
						 
						 break;
					 }
				 }
				 
				 if (subStructure.length() != 0) {
					 
					 if (BulgeLoop.shareInstance().isBulgeLoop(subStructure)) {
						 System.out.println("Bulge Loop");
					 }else if (InternalLoop.shareInstance().isInternalLoop(subStructure)) {
						 System.out.println("Internal Loop");
					 }else if (MultiBranchedLoop.shareInstance().isMultiBrandedLoop(subStructure)) {
						 System.out.println("MultiBranched Loop");
					 }else if (HairpinLoop.shareInstance().isHairpinLoop(subStructure)) {
						 System.out.println("Hairpin Loop");
					 }else if (StackedLoop.shareInstance().isStackedLoop(subStructure)) {
						 System.out.println("Stacked Loop");
					 }
					 
				 }
				 
			}
			i++;
		}
		
	}
	
}
