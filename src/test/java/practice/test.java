package practice;

import java.util.ArrayList;
import java.util.stream.Stream;

import org.testng.annotations.Test;

public class test {
	@Test
	public void regular() {
		ArrayList<String> name= new ArrayList<String>();
		name.add("anita");
		name.add("nandu");
		name.add("anil");
		name.add("arjun");
		name.add("lucky");
		name.add("aryan");
		name.add("arpita");
		int count=0;
		for(int i=0; i<name.size();i++) {
			String actual=name.get(i);
			if(actual.startsWith("a")) {
				count++;
			}
			
		}
		System.out.println(count);
		
		
	}
	@Test
	public void streamFilter() {
		ArrayList<String> name= new ArrayList<String>();
		name.add("anita");
		name.add("nandu");
		name.add("anil");
		name.add("arjun");
		name.add("lucky");
		name.add("aryan");
		name.add("arpita");
		
		//->lambda expression
		Long c= name.stream().filter(s->s.startsWith("a")).count();
		
		System.out.println(c);
		
		 long d =Stream.of("anu","ajsnd","urhfn","djuf","ajfhv").filter(s-> 
		{
		
		s.startsWith("a");
		return true;
		}).count();
		 System.out.println(d);
	}

}
