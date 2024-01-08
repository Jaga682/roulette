package Tasks;

import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;
import java.util.Map.Entry;

public class Andarbaharlogics {

	public static void main(String[] args) throws InterruptedException  {
		System.out.println("Andar bahar");
		int sum=0;
		char choice;
		String betNumber;
		double totalamount=0;
		double Acard=0;
		double bah=0;
		double colour=0;
		double coloursame=0;
		double black=0;
		double blacksame=0;
		double s2=0;
		double s1=0;
		double big=0;
		double perfect=0;
		double club=0;
		double spad=0;
		double heart=0;
		double diamond=0;
		
		
		List<String>total=Arrays.asList("A","2","3","4","5","6","7","8","9","10","j","q","Atk");
		System.out.println("your betting cards are"+total);
		//	List<String>smallbet=Arrays.asList("A","2","3","4","5","6");
		Map<String, List<Integer>>andhar=new 	HashMap<>();
		Scanner scan=new Scanner(System.in);

		do {

			betNumber=scan.next();
			int amount=scan.nextInt();
			List<Integer>list=new ArrayList<>();
			if(andhar.containsKey(betNumber)==false) {
				andhar.put(betNumber, list);
			}
			andhar.get(betNumber).add(amount);
			System.out.println("DO you want more bet Y for yes N for No");

			choice=scan.next().charAt(0);
		}while((choice=='Y'||choice=='y'));
		System.out.println(andhar);

		Map<String, Integer>totalcard=new HashMap<>();
		for(Entry<String, List<Integer>>entry:andhar.entrySet()) {
			sum=0;
			for(int i=0;i<entry.getValue().size();i++) {
				System.out.println(entry.getValue().get(i));
				sum +=entry.getValue().get(i);

			}

			System.out.println(entry.getKey() + "         " + sum);
			totalcard.put(entry.getKey(),sum);

			System.out.println(entry.getKey() + "" + sum);	
			System.out.println("sum values"+sum);
		}
		System.out.println("2nd map"+totalcard);


		//		List<String> Housecard=Arrays.asList("D-A","D-2","D-3","D-4","D-5","D-6","D-7","D-8","D-9","D-10","D-j","D-q","D-k","C-A","C-2","C-3","C-4","C-5","C-6","C-7","C-8","C-9","C-10","C-j","C-q","C-k",
		//				"S-A","S-2","S-3","S-4","S-5","S-6","S-7","S-8","S-9","S-10","S-j","S-q","S-k","H-A","H-2","H-3","H-4","H-5","H-6","H-7","H-8","H-9","H-10","H-j","H-q","H-k");
		List<String> Housecard=new ArrayList<String>(Arrays.asList("D-A","D-2","D-3","D-4","D-5","D-6","D-7","D-8","D-9","D-10","D-j","D-q","D-k","C-A","C-2","C-3","C-4","C-5","C-6","C-7","C-8","C-9","C-10","C-j","C-q","C-k",
				"S-A","S-2","S-3","S-4","S-5","S-6","S-7","S-8","S-9","S-10","S-j","S-q","S-k","H-A","H-2","H-3","H-4","H-5","H-6","H-7","H-8","H-9","H-10","H-j","H-q","H-k"));

		Random rand=new Random();
		String randomcard=Housecard.get(rand.nextInt(Housecard.size()));
		System.out.println("House card for these game"+randomcard);
		String[] split=randomcard.split("-");
		Housecard.remove(randomcard);
		System.out.println("card symbol :   "+split[0]);
		System.out.println("card number :    "+split[1]);


		//        
		//
		//        System.out.println("1st"+seperate[0]);
		//        System.out.println("2nd"+seperate[1]);
		for(int i=0;i<51;i++)
		{

			String rands=Housecard.get(rand.nextInt(Housecard.size()));
			String[] seperate=rands.split("-");
			if(i%2==0) {
				Thread.sleep(1000);
				System.out.println(" andhaar card"+rands);
				Housecard.remove(rands);
				if(totalcard.containsKey("andhar")&&(split[1].matches(seperate[1]))) {
					Acard=totalcard.get("andhar")*1.95;
					System.out.println("winning amount for andhaar"+Acard);
				}
				if(split[1].matches(seperate[1])) {
					System.out.println("sucessforAndhar");
					break;
				}

			}
			else {
				Thread.sleep(1000);
				System.out.println(" bahar card"+rands);

				Housecard.remove(rands);
				if(totalcard.containsKey("bahar")&&(split[1].matches(seperate[1]))) {
					 bah=totalcard.get("bahar")*1.95;
					System.out.println("winning amount for andhaar"+bah);
				}
				if(split[1].matches(seperate[1])) {
					System.out.println("sucess for bahar");
					break;
				}
			}
		}
//		if(totalcard.containsKey(split[0])) {
//			System.out.println(totalcard.get(split[0]));
//			  bet=totalcard.get(split[0])*3.75;
//			System.out.println("symbol winning amount       :"+bet);
//		}
		if(totalcard.containsKey("Diamond")&&(split[0].matches("D"))) {
			 diamond=totalcard.get("Diamond")*3.75;
			System.out.println("win for diamond"+diamond);
		}else if(totalcard.containsKey("Heart")&&(split[0].matches("H"))) {
		 heart=totalcard.get("Heart")*3.75;
			System.out.println("Win for Heart"+heart);
		}else if(totalcard.containsKey("Spad")&&(split[0].matches("S"))) {
			 spad=totalcard.get("Spad")*3.75;
			System.out.println("win for spad"+spad);
		}else if(totalcard.containsKey("Club")&&(split[0]).matches("c")) {
			club=totalcard.get("Club")*3.75;
			System.out.println("win for club"+club);
		}

		if(totalcard.containsKey("Red")&&(split[0].matches("D"))) {
			 colour=totalcard.get("Red")*1.95;
			System.out.println("This is for Red winnig   :"+colour);
		}else if(totalcard.containsKey("Red")&&(split[0].matches("H"))) {
			 coloursame=totalcard.get("Red")*1.95;
			System.out.println("This is for Red winning      :"+coloursame);
		}

		if(totalcard.containsKey("Black")&&(split[0].matches("C"))) {
			 black=totalcard.get("Black")*1.95;
			System.out.println("This is for Black winning      :"+black);
		}else if(totalcard.containsKey("Black")&&(split[0].matches("S"))) {
			 blacksame=totalcard.get("Black")*1.95;
			System.out.println("This is for Black Winning       :"+blacksame);
		}

		if(totalcard.containsKey(split[1])) {
			System.out.println("sucess"+totalcard.get((split[1 ])));
		  s1=totalcard.get(split[1])*12;
			System.out.println("win for series number playee   :"+s1);
		} 
		if((total.subList(0, 6).indexOf(split[1])>-1)&&totalcard.containsKey("Ato6")){
			 s2=totalcard.get("Ato6")*2;
			System.out.println(" win for small bet            :"+s2);
		}
		if((total.subList(7,13).indexOf(split[1])>-1)&&totalcard.containsKey("8tok")) {
			 big=totalcard.get("8tok")*2;
			System.out.println("win for big bet amount      :"+big);
		}

		if((total.subList(6, 7).indexOf(split[1])>-1)&&totalcard.containsKey("perfect")) {
			 perfect=totalcard.get("perfect")*12;
			System.out.println("win for perfect bet"+perfect);
		}
           totalamount=heart+perfect+s1+s2+black+blacksame+colour+coloursame+bah+Acard+club+spad+diamond+big;
           System.out.println("total winning amount"+totalamount);
}
}