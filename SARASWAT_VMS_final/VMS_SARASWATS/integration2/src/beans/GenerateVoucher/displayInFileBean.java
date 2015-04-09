package beans.GenerateVoucher;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;



public class displayInFileBean {
		
		public ArrayList<String> show(String[] filenames) {
			ArrayList<String> list = new ArrayList<String>();
				String data = "";
				String a = "";
				String decoration = "_________________________________________________________";
				decoration += "_________________________________";
				
				for (int i = 0; i < filenames.length; i++) {
					
					list.add(data);
					list.add(decoration);
					list.add(data);
				try {
					FileReader fileReader = new FileReader(filenames[i]);
					
					BufferedReader br = new BufferedReader(fileReader);
					try {
					
					while((a= br.readLine())!=null){ 
						 list.add(a);
					}
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				}
				return list;
			}
		
}
