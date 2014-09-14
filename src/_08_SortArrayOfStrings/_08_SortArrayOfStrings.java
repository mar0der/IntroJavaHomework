package _08_SortArrayOfStrings;

import java.util.Scanner;
import java.util.Arrays;

public class _08_SortArrayOfStrings {

	public static void main(String[] args) {
			Scanner input = new Scanner(System.in);
		    int n =input.nextInt();
		    String[] sortWords = new String[n];
		    for(int i=0; i<n;i++)
		    {
		    	sortWords[i] = input.next();
		    }
		    Arrays.sort(sortWords);
		    for(int i=0;i<n;i++)
		    {
		    	System.out.println(sortWords[i]);
		    }
		}

	}
