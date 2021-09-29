package re.fazan.transfer;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;

public class Main {
	
	public static ArrayList<ArgsTransfer> list = new ArrayList<ArgsTransfer>();
	
	public static void main(String[] args) {
		if (args.length == 1 && args[0].equals("-h")) {
	        printHelp();
	        System.exit(0);
	    }
		if (args.length < 2) {
			printErr();
			System.exit(84);
		}	
		if (args.length % 2 != 0) {
			printErr();
			System.exit(84);
		}
		transfer(args);
	}

	public static void printHelp() {
	    System.out.println("USAGE");
	    System.out.println("    ./107transfer [num den]*");
	    System.out.println();
	    System.out.println("DESCRIPTION");
	    System.out.println("    num\tpolynomial numerator defined by its coefficients");
	    System.out.println("    den\tpolynomial denominator defined by its coefficients");
	}
	
	public static void printErr() {
		System.out.println("Wrong arguments.");
		System.out.println("Try './107transfer -h' to have more information.");
	}
	
	public static void transfer(String[] args) {   
		ArrayList<Double> rlist = new ArrayList<Double>();
		
		for (int i = 0; i < args.length;) {
			list.add(new ArgsTransfer(args[i++], args[i++]));
		}
		
		for (double i = 0.000; i < 1.001; i += 0.001) {
			rlist.clear();
			for (ArgsTransfer at : list) {
				double tmpNum = 0;
				double tmpDen = 0;
				for (int k = 0; k < at.getNumArgs().size(); k++) {
					tmpNum += at.getNumArgs().get(k) * Math.pow(i, k);
				}
				for (int j = 0; j < at.getDenArgs().size(); j++) {
					tmpDen += at.getDenArgs().get(j) * Math.pow(i, j);
				}
				if (tmpDen != 0) {
					rlist.add(tmpNum / tmpDen);
				} else {
					System.err.println("Error: Divided by zero");
					System.exit(84);
				}
			}
			Double rslt = 1.0;
			for (Double value : rlist) {
				rslt *= value;
			}
			System.out.printf("%.3f -> %.5f\n", i, rslt);
		}
	}
	
}