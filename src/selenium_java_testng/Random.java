package selenium_java_testng;


public class Random {
//	public static void main(String[] args) {
//		Random rand = new Random(); 
//		System.out.println(rand.nextFloat());
//		System.out.println(rand.nextDouble());
//		System.out.println(rand.nextInt());
//		System.out.println(rand.nextInt(999999));
//		System.out.println(rand.nextInt(99999));
//		System.out.println("automation" + rand.nextInt(9999) + "@gmail.com");
//		System.out.println(rand.nextInt(999));
//		System.out.println(rand.nextLong());
//	}
	
	public static void main(String[] args) {
		System.out.println("nguyenloc" + getRandomNumber() + "@gmail.com");
	}
	
	
	public static int getRandomNumber() {
		java.util.Random rand = new java.util.Random();
		return rand.nextInt(99999);
	}
	
}
