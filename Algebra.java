// Implements algebraic operations and the square root function without using 
// the Java operations a + b, a - b, a * b, a / b, a % b, and without calling 
// Math.sqrt. All the functions in this class operate on int values and
// return int values.

public class Algebra {
	public static void main(String args[]) {
	    // Tests some of the operations
	    System.out.println(plus(2,3));   // 2 + 3
	    System.out.println(minus(7,2));  // 7 - 2
   		System.out.println(minus(2,7));  // 2 - 7
 		System.out.println(times(3,4));  // 3 * 4
   		System.out.println(plus(2,times(4,2)));  // 2 + 4 * 2
   		System.out.println(pow(5,3));      // 5^3
   		System.out.println(pow(3,5));      // 3^5
   		System.out.println(div(12,3));   // 12 / 3    
   		System.out.println(div(5,5));    // 5 / 5  
   		System.out.println(div(25,7));   // 25 / 7
   		System.out.println(mod(25,7));   // 25 % 7
   		System.out.println(mod(120,6));  // 120 % 6    
   		System.out.println(sqrt(36));
		System.out.println(sqrt(263169));
   		System.out.println(sqrt(76123));
	}  

	// Returns x1 + x2
	public static int plus(int x1, int x2) {
		int sum = x1;
		if(x2>=0){
			for (int i=0; i<x2; i++){
			sum++;
		}
	}
		if(x2<0){
			x2 = 0-x2;
			for (int i=0; i<x2; i++){
			sum--;
		}
			
		}
		return sum;
	}

	// Returns x1 - x2
	public static int minus(int x1, int x2) {
		int b = x1;
		if(x2>=0){
			for (int i=0; i<x2; i++){
			b--;
		}
	}
		if(x2<0){
			x2 = 0-x2;
			for (int i=0; i<x2; i++){
			b++;
		}
	}
		return b;
	}

	// Returns x1 * x2
	public static int times(int x1, int x2) {
		if (x1==0 || x2==0){
			return 0;
		}
		boolean negativeX =false;
		if ((x1<0 && x2>0) || (x1>0 && x2<0))
			negativeX = true;
		int t=0;
		if (x1<0)
			x1= minus(0, x1);
		if (x2<0){
			x2 = minus(0, x2);	
		}	
		for (int i=0; i<x2; i++){
			t = plus(t, x1);
		}
		if (negativeX)
		return minus(0, t);
		
		return t;
	}

	// Returns x^n (for n >= 0)
	public static int pow(int x, int n) {
		int p = 1;
		for (int i=0; i<n; i++)
		{
			p = times(p,x);
		}
		return p;
	}

	// Returns the integer part of x1 / x2 
	public static int div(int x1, int x2) {
		int d = 0;
		if(x1==0 || x2==0)
		{
			return 0;
		}
		boolean negativeX =false;
		if ((x1<0 && x2>0) || (x1>0 && x2<0))
			negativeX = true;
		if (x1<0)
			x1= minus(0, x1);
		if (x2<0){
			x2 = minus(0, x2);	
		}	
		while (x1>=x2){
			x1 = minus(x1,x2);	
			d++;
		}
		if (negativeX)
		return minus(0, d);
		return d;
	}

	// Returns x1 % x2
	public static int mod(int x1, int x2) {
		int m = div(x1,x2);
		m = minus(x1,times(m, x2));
		return m;
	}	

	// Returns the integer part of sqrt(x) 
	public static int sqrt(int x) {
		if (x<0){
			return 0; 
		}
		if (x==0 || x==1){
			return x;
		}
		int low = 1;
		int high = x;
		int s = 0;
		while (low<=high){
			int mid = plus(low, div(minus(high,low),2));
			if (times(mid, mid) <= x){
				s = mid;
				low = plus(mid, 1);
			}
			else{
				high = minus(mid, 1);
			}
		}
		return s;
	}	  	  
}