package StreamAPI1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class DoubleTheNumber {

	public static void main(String[] args) {
	List<Integer> numbers= Arrays.asList(1,2,3,4,5,6,7,8);
	//DOUBLE THE NUMBER
	//numbers.stream().map(n->n*2).forEach(System.out::println);
	
	//PRINT THE NUMBER GREATER THAN 2
	//numbers.stream().filter(n->n>2).forEach(System.out::println);
	
	//Print Sorted element
	//List<Integer>sortedNumber= numbers.stream().sorted((o1, o2) ->o1.compareTo(o2)).collect(Collectors.toList());
	//System.out.println(sortedNumber);
	
	//How to find min max()
	/*int min=numbers.stream().min((o1, o2) -> o1.compareTo(o2)).get();
	System.out.println(min);
	int max=numbers.stream().max((o1, o2) -> o1.compareTo(o2)).get();
	System.out.println(max);*/
	
	//How to count The number of elements
	long count= numbers.stream().count();
	System.out.println(count);
	}

}
