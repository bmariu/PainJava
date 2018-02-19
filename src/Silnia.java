import java.math.BigInteger;

public class Silnia {
	
	
		public static BigInteger silnia (int n)
		{
			BigInteger s= BigInteger.valueOf(1);     // inscianilizacja liczb biginteger przez funkcje vauleof
		
				for(int i = 1; i<=n; i++)
				{
					s = s.multiply(BigInteger.valueOf(i));   // nozeenie liczb big nie ma przeciozenia operatpra *
				}
			
			return s;
		}

	public static void main(String[] args) {
		
		int n = 40;
		int k = 6;
		BigInteger pr = silnia(n).divide(silnia(k).multiply(silnia(n-k)));
		
		System.out.println(pr);

	}

}
