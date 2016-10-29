package tables;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Constants {

	public static float LenPar = (float) 1.079;
	public static float AsymMax = (float) 3.0;
	public static float AsymPar[] = {(float)0.5, (float)0.5, (float)0.5, (float)0.5};
	public static float Multia = (float) 3.4;
	public static float Multib = (float) 0.4;
	public static float Multic = (float) 0.0;
	public static float bonusGGG = (float) -2.2;
	public static float CHairpin1 = (float) 0.3;
	public static float CHairpin2 = (float) 1.6;
	public static float CHairpin3 = (float) 1.4;
	public static float Intermol = (float) 4.1;
	public static float GailRule = (float) 1;
	private static Character[] temp = {'`', 'A', 'C', 'G', 'U'};
	public static List<Character> listEnclus = new ArrayList<Character>(Arrays.asList(temp));
	private static String[] temp1 = {"``", "AA", "AC", "AG", "AU", "CA", "CC", "CG", "CU", "GA", "GC", "GG", "GU", "UA", "UC", "UG", "UU"};
	public static List<String> listEnclusString = new ArrayList<String>(Arrays.asList(temp1));
	
	public static float nonGCterminal(Character A, Character B) {
		if ((A=='C'&&B=='G')||(A=='G'&&B=='C')) {
			return (float) 0;
		}
		return (float) 0.5;
	}
	
	public static float deltaGLengthH(int l) {
		if (l <= 30) return DataTableLoop.shareInstance().getDataHairpinLoop().get(l);
		else {
			return (float) (DataTableLoop.shareInstance().getDataHairpinLoop().get(30) + Constants.LenPar*Math.log((double)(l/30)));
		}
	}
	
	public static float deltaGLengthB(int l) {
		if (l <= 30) return DataTableLoop.shareInstance().getDataBulgeLoop().get(l);
		else {
			return (float) (DataTableLoop.shareInstance().getDataBulgeLoop().get(30) + Constants.LenPar*Math.log((double)(l/30)));
		}
	}
	
	public static float deltaGLengthI(int l) {
		if (l <= 30) return DataTableLoop.shareInstance().getDataInternalLoop().get(l);
		else {
			return (float) (DataTableLoop.shareInstance().getDataInternalLoop().get(30) + Constants.LenPar*Math.log((double)(l/30)));
		}
	}
	
	public static float deltaGHairpinN(String enclus) {
		String temp = ""+enclus.charAt(0)+enclus.charAt(enclus.length()-1);
		for (int i=0; i<Tstackh.getListTable().size(); i++) {
			if (Tstackh.getListTable().get(i).getStr().equals(temp) == true) {
				return Tstackh.getListTable().get(i).getData()[listEnclus.indexOf(enclus.charAt(1))][listEnclus.indexOf(enclus.charAt(enclus.length()-2))];
			}
		}
		return 0;
	}
	
	public static float deltaGHairpin4(String enclus) {
		return Tloop.shareInstance().getData(enclus.charAt(0), enclus.charAt(1), enclus.charAt(2), enclus.charAt(3), enclus.charAt(4), enclus.charAt(5));
	}
	
	public static float deltaGInternal2(String enclus) {
		String temp = enclus.charAt(0)+""+enclus.charAt(2)+""+enclus.charAt(3)+""+enclus.charAt(5);
		for (int i=0; i<Int11.getListTable().size(); i++) {
			if (Int11.getListTable().get(i).getStr().equals(temp) == true) {
				return Int11.getListTable().get(i).getData()[listEnclus.indexOf(enclus.charAt(1))][listEnclus.indexOf(enclus.charAt(4))]; 
			}
		}
		return 0;
	}
	
	public static float deltaGInternal3(Character si, Character sj, Character si1, Character sj1, Character sip1, Character sjs1, Character sj1p1) {
		String temp = ""+si+'X'+si1+sj1+sj1p1+'Y'+sj;
		for (int i=0; i<Int21.getListTable().size(); i++) {
			if (Int21.getListTable().get(i).getStr().equals(temp) == true) {
				return Int21.getListTable().get(i).getData()[listEnclus.indexOf(sip1)][listEnclus.indexOf(sjs1)];
			}
		}
		return 0;    
	}
	
	public static float deltaGInternal4(Character si, Character sj, Character si1, Character sj1, Character sip1, Character sjs1, Character si1s1, Character sj1p1) {
		String temp = ""+si+"XX"+si1+sj1+"YY"+sj;
		String X = ""+sip1+sjs1;
		String Y = ""+si1s1+sj1p1;
		for (int i=0; i<Int22.getListTable().size(); i++) {
			if (Int22.getListTable().get(i).getStr().equals(temp) == true) {
				return Int22.getListTable().get(i).getData()[listEnclusString.indexOf(X)][listEnclusString.indexOf(Y)];
			}
		}
		return 0;
	}
	
	public static float deltaGStack(Character si, Character sj, Character si1, Character sj1) {
		String temp = ""+si+sj;
		for (int i=0; i<Stack.getListStack().size(); i++) {
			if (Stack.getListStack().get(i).getStr().equals(temp) == true) {
				return Stack.getListStack().get(i).getData()[listEnclus.indexOf(si1)][listEnclus.indexOf(sj1)];
			}
		}
		return 0;
	}
	
	public static float deltaGInternalN(Character si, Character sj, Character sip1, Character sjs1) {
		String temp = ""+si+sj;
		for (int i=0; i<Tstacki.getListTable().size(); i++) {
			if (Tstacki.getListTable().get(i).getStr().equals(temp) == true) {
				return Tstacki.getListTable().get(i).getData()[listEnclus.indexOf(sip1)][listEnclus.indexOf(sjs1)];
			}
		}
		return 0;
	}
	
	public static float deltaGAsymmetry(int l1, int l2) {
		float temp = (float) (Math.abs(l1 - l2) * 0.5);
		return Math.min(temp, AsymMax);
	}
	
	public static float deltaGDangle5p(Character i, Character j, Character is1) {
		String temp = ""+'X'+i+j;
		float s = 0;
		
		for (int w=0; w<Dangle.getListTable().size(); w++) {
			if (Dangle.getListTable().get(w).getStr().equals(temp)) {
				s += Dangle.getListTable().get(w).getData()[listEnclus.indexOf(is1)];
				break;
			}
		}
		return s;
		
	}
	
	public static float deltaGDangle3p(Character i, Character j, Character jp1) {
		String temp = ""+i+j+'X';
		float s = 0;
		
		for (int w=0; w<Dangle.getListTable().size(); w++) {
			if (Dangle.getListTable().get(w).getStr().equals(temp)) {
				s += Dangle.getListTable().get(w).getData()[listEnclus.indexOf(jp1)];
				break;
			}
		}
		
		return s;
	}
	
	public static float deltaGDangle(String enclus, int i, int j, int i1, int j1, String type) {
		String temp1 = ""+enclus.charAt(i)+enclus.charAt(j)+'X';
		String temp2 = ""+'X'+enclus.charAt(i1)+enclus.charAt(j1);
		float s = 0;
		
		if (type.equals("First")) {
			if (j+1 < i1-1) {
				for (int w=0; w<Dangle.getListTable().size(); w++) {
					if (Dangle.getListTable().get(w).getStr().equals(temp1)) {
						s += Dangle.getListTable().get(w).getData()[listEnclus.indexOf(enclus.charAt(j+1))];
					} else if (Dangle.getListTable().get(w).getStr().equals(temp2)) {
						s += Dangle.getListTable().get(w).getData()[listEnclus.indexOf(enclus.charAt(i1-1))];
					}
				}
				return s;
			} else if (j+1 == i1-1) {
				float s1=0, s2=0;
				for (int w=0; w<Dangle.getListTable().size(); w++) {
					if (Dangle.getListTable().get(w).getStr().equals(temp1)) {
						s1 = Dangle.getListTable().get(w).getData()[listEnclus.indexOf(enclus.charAt(j+1))];
					} else if (Dangle.getListTable().get(w).getStr().equals(temp2)) {
						s2 = Dangle.getListTable().get(w).getData()[listEnclus.indexOf(enclus.charAt(i1-1))];
					}
				}
				return Math.min(s1, s2);
			} else {
				return 0;
			}
		} else if (type.equals("Normal")) {
			if (i+2 < i1-1) {
				for (int w=0; w<Dangle.getListTable().size(); w++) {
					if (Dangle.getListTable().get(w).getStr().equals(temp1)) {
						s += Dangle.getListTable().get(w).getData()[listEnclus.indexOf(enclus.charAt(j+1))];
					} else if (Dangle.getListTable().get(w).getStr().equals(temp2)) {
						s += Dangle.getListTable().get(w).getData()[listEnclus.indexOf(enclus.charAt(i1-1))];
					}
				}
				return s;
			} else if (i+2 == i1-1) {
				float s1 = 0, s2 = 0;
				for (int w=0; w<Dangle.getListTable().size(); w++) {
					if (Dangle.getListTable().get(w).getStr().equals(temp1)) {
						s1 = Dangle.getListTable().get(w).getData()[listEnclus.indexOf(enclus.charAt(j+1))];
					} else if (Dangle.getListTable().get(w).getStr().equals(temp2)) {
						s2 = Dangle.getListTable().get(w).getData()[listEnclus.indexOf(enclus.charAt(i1-1))];
					}
				}
				return Math.min(s1, s2);
			} else {
				return 0;
			}
		} else {
			return -9999;
		}
		
		
	}
	
}
