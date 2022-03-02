package LongAdd;

public class LongInt {

	private static int[] add(int[] a,int[] b) {
		if(a.length < b.length) {
			return null;
		}
		int jinwei = 0;
		for(int i = 0; i < a.length; i++) {
			int tmp = a[a.length-i-1] + b[b.length-i-1] + jinwei;
			if(tmp >= 10) {
				jinwei = 1;
			}else {
				jinwei = 0;
			}
			tmp %= 10; 
			a[a.length-i-1] = tmp;
		}
		return a;
	}
	
	public static String LongAdd(String a,String b) {
		if(a == null || b == null) {
			throw new NullPointerException();
		}
		boolean a_sign = true, b_sign = true;
		if(a.charAt(0) == '-') {
			a_sign = false;
			a = a.substring(1);
		}
		if(b.charAt(0) == '-') {
			b_sign = false;
			b = b.substring(1);
		}
		int maxlen = a.length() > b.length() ? a.length()+2: b.length()+2;
		int [] m = new int [maxlen];
		int [] n = new int [maxlen]; 
		m[0] = a_sign ? 0 : 9;
		n[0] = b_sign ? 0 : 9;
		for(int i = 0; i < a.length(); i++) {
			m[maxlen - a.length() + i] = Integer.parseInt("" + a.charAt(i));
		}
		for(int i = 0; i < b.length(); i++) {
			n[maxlen - b.length() + i] = Integer.parseInt("" + b.charAt(i));
		}
		int[] result = add(buma(m),buma(n));
		return intToString(buma(result));
	}
	
	/*int []array = null;
	LongInt(String a){
		if(a == null){
			throw new NullPointerException();
		}
		boolean sign = true;
		if(a.charAt(0) == '-'){
				sign = false;
				a = a.substring(1);
		}
		int len = a.length()+2;
		array = new int [len];
		array[0] = sign ? 0 : 9;
		for(int i = 0; i < array.length - 2; i++) {
			array[len - a.length() + i] = Integer.parseInt("" + a.charAt(i));
			}
		}
	
	LongInt LongAdd(LongInt sum) {
		int maxlen = array.length > sum.array.length ? array.length : sum.array.length;
		int [] m = new int [maxlen];
		int [] n = new int [maxlen];
		m[0] = array[0];
		n[0] = sum.array[0];
		for(int i = 0; i < array.length -2; i++) {
			m[maxlen - array.length + 2 + i] = array[i]; 
		}
		for(int i1 = 0; i1 < sum.array.length - 2; i1++) {
			n[maxlen - sum.array.length + 2 + i1] = sum.array[i1];
		}
		int [] result = add(buma(m),buma(n));
		return intToLongInt(buma(result));
		}
		*/
	
	public static int[] buma(int[] a) {
		if(a[0] == 9) {
			for(int i = 1; i < a.length; i++) {
				a[i] = 9 - a[i];
			}
			int[] tmp = new int[a.length];
			tmp[a.length-1] = 1;
			return add(a,tmp);
		}else {
		return a;
		}
	}
	
	static String intToString(int[] a) {
		StringBuffer s= new StringBuffer();
		if(a[0] == 9) {
			s.append('-');
		}else {
			s.append("");
		}
		int buma_zero = 0;
		for(int i = 1; i < a.length; i++) {
			if(a[i] == 0) {
				buma_zero++;
			}else {
				break;
			}
		}
		for(int j = buma_zero + 1; j < a.length; j++) {
			s.append(a[j]);
		}
		if(s.length() == 0) {
			return null;
		}
		return s.toString();
	}
}