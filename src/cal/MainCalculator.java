package cal;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import model.BulgeLoop;
import model.HairpinLoop;
import model.InternalLoop;
import model.MultiBranchedLoop;
import model.StackedLoop;

public class MainCalculator {
	
	private static Scanner scanner;
	private static String structure;
	private static String enclu;
	private static List<Character> struc = new ArrayList<Character>();
	private static List<Character> strucEnclu = new ArrayList<Character>();
	private static List<Boolean> checkStruc = new ArrayList<Boolean>();
	private static String subStructure;
	private static String subEnclu;
	private static String bonusForHairpin;
	private static float results = 0;

	public static void main(String[] args) {
		
		scanner = new Scanner(System.in);
		System.out.print("Nhap String: ");
		structure = scanner.nextLine();
		System.out.print("Nhap Enclu: ");
		enclu = scanner.nextLine();
		structure = ".....(((((.........(((((.(((((..((((.(((..(((.................))).)))..)))).))))).(((.......))).....))))).(((((((....(((....)))(((((((....))))))).((((((....)))))).((....)).))))))).....)))))....((....))....................";
		enclu = "ACAUGGGGAUAAGGGCAGGCGGUGAAUGCCUUGGCUCUCGGAGGCGAAGAAGGACGUGAUAAGCUGCGAUAAGCCCGGCGUAGGCGCAAAUAGCCGUUAAUACCGGGGUUUCCGAAUGGGGCAACCCGCCGGGAGUAAUUCCGGCAUCUCUUGAAAGAGGGAGGCGAACGUGGGGAACUGAAACAUCUCAGUACCUGCAGGAAAAAAAAAAAAAAAAAAAA";
		enclu = enclu.toUpperCase();
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
						 if (j > 1) bonusForHairpin = ""+strucEnclu.get(j-2)+strucEnclu.get(j-1);
						 else bonusForHairpin = "";
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
						 float temp = InternalLoopCalculator.shareInstance().computeDeltaG(subStructure, subEnclu);
						 System.out.println("Bulge Loop ----> "+temp);
						 results += temp;
					 }else if (InternalLoop.shareInstance().isInternalLoop(subStructure)) {
						 float temp = InternalLoopCalculator.shareInstance().computeDeltaG(subStructure, subEnclu);
						 System.out.println("Internal Loop ----> "+temp);
						 results += temp;
					 }else if (MultiBranchedLoop.shareInstance().isMultiBrandedLoop(subStructure)) {
						 float temp = MultibrandchedCalculator.shareInstance().computeDeltaG(subStructure, subEnclu);
						 System.out.println("MultiBranched Loop ----> "+temp);
						 results += temp;
					 }else if (HairpinLoop.shareInstance().isHairpinLoop(subStructure)) {
						 float temp = HairpinLoopCalculator.shareInstance().computeDeltaG(subStructure, subEnclu, bonusForHairpin);
						 System.out.println("Bonus: "+bonusForHairpin);
						 System.out.println("Hairpin Loop ----> "+temp);
						 results += temp;
					 }else if (StackedLoop.shareInstance().isStackedLoop(subStructure)) {
						 float temp = StackLoopCalculator.shareInstance().computeDeltaG(subStructure, subEnclu);
						 System.out.println("Stacked Loop ----> "+temp);
						 results += temp;
					 }
					 
				 }
				 
			}
			i++;
		}
		
		System.out.println("Result = "+results);
		
	}
	
}
