package fishesThread;
import java.util.*;
import java.util.concurrent.ThreadLocalRandom;
import java.lang.Thread;

class multiThread extends Thread{
	
	ArrayList<String> fishesList;
	
	public multiThread(ArrayList<String> fishes) {
		this.fishesList=fishes;
	}
	
	public void run() {
	
		synchronized(fishesList) {
			int randomIndex1=ThreadLocalRandom.current().nextInt(fishesList.size())% fishesList.size();
		    int randomIndex2=ThreadLocalRandom.current().nextInt(fishesList.size())% fishesList.size();
		    if(randomIndex2==randomIndex1)
		    	  randomIndex2=ThreadLocalRandom.current().nextInt(fishesList.size())% fishesList.size();
		    
		    String str1=fishesList.get(randomIndex1), 
		    		str2=fishesList.get(randomIndex2);
		    
		    if(str1.equals(str2))
		    {
		    	if(str1=="MF") {
		    		fishesList.remove(randomIndex1);
		    		fishesList.remove(randomIndex2);
		    	}
		    	
		    	else if(str1=="FF")
		    	{
		    		int randomOfTwoInts = new Random().nextBoolean() ? randomIndex1 : randomIndex2;
		    		fishesList.remove(randomOfTwoInts);
		    	}
		    }
		    
		    if((str1=="MF" && str2=="FF") || (str1=="FF" && str2=="MF"))
		    {
		    	String randomOfTwoStr1=new Random().nextBoolean() ? "MF" : "FF";
		    	String randomOfTwoStr2=new Random().nextBoolean() ? "MF" : "FF";
		 	    fishesList.add(randomOfTwoStr1);
		 	    fishesList.add(randomOfTwoStr2);
		    }
		    
			System.out.println(fishesList);
		}
		}
	
	    
}
public class fishesThread {

	public static void main(String[] args)
	{
		ArrayList<String> fishes = new ArrayList<>(Arrays.asList("MF","MF","FF","MF","FF","FF","MF","FF","FF","FF","MF","MF","MF","FF","FF","MF","FF","MF","MF","FF"));
        
		for(int i=0;i<5;i++) {
		
		multiThread t1=new multiThread(fishes);
		t1.start();
		}
		
	}
	
}




