package maccess;
import java.util.Scanner;

import test.IComparable;
public class DemoAnonymous1 {
	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		System.out.println("Enter the value-1:");
		int v1=s.nextInt();
		System.out.println("Enter the value-2");
		int v2=s.nextInt();
		System.out.println("==Choice==");
		System.out.println("1.Greater Value \n2.Smaller Value");
		switch(s.nextInt()) {
		case 1:
		//Anonymous InnerClass As Implementation extension
			IComparable ob1=new IComparable() 
			{
				@Override
				public int compare(int x,int y) {
					if(x>y) return x;
					else return y;
				}
			};
			int r1=ob1.compare(v1, v2);
			System.out.println("Greater Vlaue:"+r1);
			break;
		case 2:
			//Anonymous InnerClass As Implementation extension
			IComparable ob2=new IComparable() 
			{
				@Override
				public int compare(int x,int y) {
					if(x<y) return x;
					else return y;
				}
			};
			int r2=ob2.compare(v1, v2);
			System.out.println("Greater Vlaue:"+r2);
			break;
		}
	}
}