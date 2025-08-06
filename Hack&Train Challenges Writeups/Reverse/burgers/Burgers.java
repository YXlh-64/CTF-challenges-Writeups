import java.util.*;

public class Burgers {
	
	public static boolean bun(String s) {
		return (s.substring(0, 6).equals("SecAI{") && s.charAt(s.length()-1) == '}');
	}
	
	public static boolean cheese(String s) {
		return (s.charAt(10) == '_' && (int)s.charAt(17) == 48 && s.charAt(19) == '9' && s.charAt(26)+s.charAt(19) == 152 && s.charAt(29) == 'u' && s.charAt(34)-5 == 46 && s.charAt(39) == '3' 
			&& (int)s.charAt(43) == 52 && s.charAt(47) == 'h' && s.charAt(50) == '_' && (int)s.charAt(54) == (int)s.charAt(55) && s.charAt(55) + s.charAt(60)== 100 && s.charAt(64) == '5' && s.charAt(68) == '3'
			&& s.charAt(41) == 'f' && s.charAt(48) == '4' && s.charAt(62) == '8' && s.charAt(66) == '4' && (int) s.charAt(60) == 51
			);
	}
	
	public static boolean meat(String s) {
		boolean good = true;
		int m;
		char[] meat = {'4', '7', '?' ,  '3', '_' ,  '0',  '0',  'y', '4', '0'};
		int[] dif =   { 1 ,  7 ,  13 ,  19 ,  25 ,  42 ,  46 ,  14 ,  63 ,  58 };
		for (int i = 0; i < meat.length; i++) {
			m = 70;
			m -= dif[i];
			if (s.charAt(m) != meat[i]) {
				good = false;
				break;
			}
		}
		return good;
	}
	
	public static boolean pizzaSauce(String s) {
		boolean[] isDigit = {false, true, false, false, true, false, false, false, false, true, false, true, false, false, false, false, true, false, false, false, true, false, true, false, false, false};
		for (int i = 15; i < 40; i++) {
			if (Character.isDigit(s.charAt(i - 7)) != isDigit[i - 15]) {
				
				System.out.println("i is " + i);
				//System.out.println("i - 7 is " + (String)(i - 7));
				System.out.println("Character.isDigit(s.charAt(i - 7)) " + Character.isDigit(s.charAt(i - 7)));
				System.out.println("isDigit[i] " + isDigit[i]);
				return false;
			}
		}
		char[] sauce = {'v', 'g', '3', '_', '_', 'd', 'y', '1', '0', 'u', 'u', '0', '_', 'w', 't', '_', 'h', 'u', '0', '0', 'u', 'y', '9', '_', 'h', 't'};
		int a = 8; int b = 33; int i = 0; boolean good = true;
		while (a < b) {

			if (s.charAt(a) != sauce[i] || s.charAt(b) != sauce[i+1]) {

				System.out.println("a is " + a);
				System.out.println("b is " + b);
				System.out.println("i is " + i);

				good = false;
				break;
			}
			
			a++; b--; i += 2;
		}
		return good;
	}
	
	public static boolean veggies(String s) {
		int[] veg1 = {6, 35, 36, 37, 38, 40, 42, 44, 46, 49, 52, 53, 56, 58, 59, 61, 65, 67 };
		int[] veg = new int[18];
		for (int i = 0; i < veg1.length; i++) {
			veg[i] = (int) s.charAt(veg1[i]);
		}

		
		return (veg[0] + veg[1] == 220 && veg[1] * veg[2] == 11020 && 
		veg[2]-veg[3]-veg[4] == -125 && veg[3] + veg[4] == 220 && 
		veg[5] == veg[13] && veg[13] == 95 && 
		veg[6] == veg[14] && veg[14] == 49 && 
		veg[8] == veg[9] && veg[8] == 116 && 
		veg[7] == 57 && veg[10] == 52 && veg[11] == 115 && veg[12] == 121 &&
		veg[15] == 54 &&
		veg[16] == 51 &&
		veg[17] == 53 &&
		1 == 1);
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println("Can burgers be pizzas? Try making a burger...");
		System.out.print("Enter flag: ");
		String input = in.next();
		in.close();
		
		boolean gotFlag = true;
		
		if (input.length() > 71) {
			System.out.println("This burger iz too big :(");
		} else if (input.length() < 71) {
			System.out.println("This burger iz too small :(");
		} else {
			if (!bun(input)) {
				System.out.println("Wrong bun >:0");
				gotFlag = false;
			}
			
			if (gotFlag) {
				if (!cheese(input)) {
					System.out.println("Hmph. Not good chez :/");
					gotFlag = false;
				}
			}
			
			if (gotFlag) {
				if (!meat(input)) {
					System.out.println("Bah, needs better meat :S");
					gotFlag = false;
				}
			}
			
			if (gotFlag) {
				if (!pizzaSauce(input)) {
					System.out.println("Tsk tsk. You call that pizza sauce? >:|");
					gotFlag = false;
				}
			}
			
			if (gotFlag) {
				if (!veggies(input)) {
					System.out.println("Rotten veggies, ew XP");
					gotFlag = false;
				}
			}
			
			if (gotFlag) {
				System.out.println("Yesyes good burger :D");
			}
		}
	}
}
