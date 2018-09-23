package main;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Circuit {
	
	public double B;
	public double R;
	public double C;
	public double T0;
	public double Tn;
	
	public Circuit() {
		
		File name = new File("params.txt");
				
		try {
					
			Scanner sc = new Scanner(name);
			
			B = sc.nextDouble();
			R = sc.nextDouble();
			C = sc.nextDouble();
			T0 = sc.nextDouble();
			Tn = sc.nextDouble();	
				
			sc.close();
					
		} catch (FileNotFoundException e) {
					
			System.out.println("File Not Found");
		}
	}
	
	double equation(double t) {
		
		return B*(1 - Math.pow(Math.E,-t/(R*C)));
	}
	
	public void calculation() {
		
		double i=0.0,tmp=0.0,ans=0.0;
		
		tmp = (Tn - T0)/100.0;
		
		try {
			
			FileWriter out = new FileWriter("rc.txt");
			
			for(i=T0;i<=Tn;i+=tmp) {
				
				ans = equation(i);
				out.write(i + " " + ans + "\n\n");			
			}
			out.close();
			
		} catch (IOException e) {
			
			e.printStackTrace();
		}	
	}
}
