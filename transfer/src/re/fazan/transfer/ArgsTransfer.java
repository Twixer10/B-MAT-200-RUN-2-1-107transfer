package re.fazan.transfer;

import java.util.ArrayList;

public class ArgsTransfer {

	private String den;
	private String num;
	private ArrayList<Integer> denArgs;
	private ArrayList<Integer> numArgs;
	
	public ArgsTransfer(String num, String den) {
		super();
		this.den = den;
		this.num = num;
		denArgs = new ArrayList<Integer>();
		numArgs = new ArrayList<Integer>();
		
		for (String s : den.split("\\*")) {
			try {
				denArgs.add(Integer.parseInt(s));
			} catch (Exception e2) {
				System.out.println("NAN");
				System.exit(84);
			}
		}
		
		for (String s : num.split("\\*")) {
			try {
				numArgs.add(Integer.parseInt(s));
			} catch (Exception e2) {
				System.out.println("NAN");
				System.exit(84);
			}
		}
	}
	
	public ArrayList<Integer> getDenArgs() {
		return denArgs;
	}
	public ArrayList<Integer> getNumArgs() {
		return numArgs;
	}
	public String getDen() {
		return den;
	}
	public String getNum() {
		return num;
	}
	
	
}
