import java.util.Scanner;


public class ScannerTest {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("enter two number separated by space");
		int a = sc.nextInt();
		int b = sc.nextInt();
		System.out.println(a+b);

	}

}
