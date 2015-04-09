import java.util.Random;
public class a {
	public static String encrypt(String no) {
		
		String temp = "";
		String odd = "";
		String even = "";
		String result = "";
		int value = 0;
		for (int i = 0; i < no.length(); i++) {
			if(i%2==0)
				even += no.charAt(i);
			else
				odd += no.charAt(i);
		}
		for (int i = 0; i < no.length(); i++) {
			
				if(odd.length()>=(i+1))
					result += odd.charAt(i);
				if(even.length()>=(i+1))
					result += even.charAt(i);
		}
		if((no.length()%2) == 0)
			value = no.length()/2;
		else 
			value = ((no.length()+1)/2);
		char[] array = new char[no.length()];
	
		for (int start = 0 , end = (no.length()-1); start < value; start++ , end--) {
			
			array[start] = result.charAt(end);
			array[end] = result.charAt(start);
			
		}
		result = array.toString();
	
		return new String(array);
	}
	public static String decrypt(String no) {
		int value = 0;
		String odd = "";
		String even = "";
		String result = no;
		
		if((no.length()%2) == 0)
			value = no.length()/2;
		else  
			value = ((no.length()+1)/2);
		char[] array = new char[no.length()];
		
		for (int start = 0 , end = (no.length()-1); start < value; start++ , end--) {
			
			array[start] = result.charAt(end);
			array[end] = result.charAt(start);
			
		}
		result = new String(array);
		
		
		for (int i = 0; i < no.length(); i++) {
			if(i%2==0)
				even += result.charAt(i);
			else
				odd += result.charAt(i);
		}
		result = new String();
		for (int i = 0; i < no.length(); i++) {
			
				if(odd.length()>=(i+1))
					result += odd.charAt(i);
				if(even.length()>=(i+1))
					result += even.charAt(i);
		}
	
		return result;
	}
	public static String getdate(String st) {
		
		String year = "";
		String date = "";
		String mon = "";
		year = st.substring(0 ,4);
		mon = st.substring(5,7 );
		date = st.substring(8,10);
		
		return (date+"-"+mon+"-"+year);
			
	}
	public static int getNo(String st) {
		
		int i = Integer.valueOf(st,16).intValue();
		return i;
		//Double i = Double.valueOf(st).doubleValue();
		//return i;
		
	}
	public static void main(String args[]) {
	
		Random random =  new Random(1000000);
		Integer randomNo = random.nextInt();
		Integer randomNo1 = random.nextInt();
		System.out.println(randomNo+" "+randomNo1+ " "+encrypt(randomNo.toHexString(randomNo)+encrypt(randomNo1.toHexString(randomNo))));
		//System.out.println(encrypt("pratikchaudhari"));
		String abc = decrypt("429ccf8db6594330");
		System.out.println(abc);
	//	System.out.println("encrypt:"+encrypt(abc));
		System.out.println(abc.substring(0,4));
		System.out.print(getNo(abc.substring(0,4))+" ");
		System.out.print(getNo(abc.substring(4,8))+" ");
		System.out.print(getNo(abc.substring(8,12))+" ");
		System.out.print(getNo(abc.substring(12,16)));
		//System.out.println(getdate("2011-02-09"));
		//System.out.println(encrypt(randomNo.toHexString(4000236303)+encrypt(randomNo1.toHexString(2296612355))));
		System.out.println();
		System.out.println(encrypt(((Integer.toHexString(getNo(abc.substring(0,4)))))
				+(Integer.toHexString(getNo(abc.substring(4,8))))+
				(Integer.toHexString(getNo(abc.substring(8,12))))+
				(Integer.toHexString(getNo(abc.substring(12,16))))));	
		
		
	}
}