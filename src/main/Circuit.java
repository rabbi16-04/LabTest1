package main;

import java.io.BufferedWriter;
import java.io.File;
import java.io.Exception;
import java.util.Scanner;

public class Circuit {
	public static void main(String[] args) throws Exception
	{
		File file = new File("C:\\LabTest1\\Java\\eclipse\\LabTest 1\\src\\params.txt"); 
		Scanner scan = new Scanner(file); 
			  
		if (scan.hasNextDouble()) {
			
			double Start = scan.nextInt();
			double End = scan.nextInt();
			
			double B = scan.nextDouble();
			double R = scan.nextDouble();
			double C = scan.nextDouble();
			
			double e = 2.7183;
			double rc = 1/(R*C);
			
			double T = (End-Start)/100;
			for(double i = Start; i<=End; i=i+T) {
				double ep = 1 / (Math.pow(e, (rc*i)));
				double v = B*(1-ep);
				
				File fileName = new  File("C:\\LabTest1\\Java\\eclipse\\LabTest 1\\src\\rc.txt");
			    BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true));
			    writer.append("\n"+i+"  "+v);
			    
			    writer.close();
				
			}
		}	      
	}
}
