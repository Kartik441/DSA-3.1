// Also known as interleaving substring problem
public class CheckValidShuffle {
	
	static boolean validShuffle(String a,String b, String c)  // This will not work for duplicates input like
	{                                                         //("AAB","AAC","AACAAB")
		int i=0;
		int j=0;
		int k=0;
		int la=a.length();
		int lb=b.length();
		int lc=c.length();
		if(lc!=(la+lb))
			return false;
		boolean isValid = true; 
		
		for(k=0;k<lc;k++)
		{
			if(i<la && a.charAt(i)==c.charAt(k))
			{
				i++;
			}
			else if(j<lb && b.charAt(j)==c.charAt(k))
			{
				j++;
			}
			else
			{
				isValid = false;
				break;
			}
		}
		
		
		//if(k == lc && i==la && j==lb)      // means loop continued for entire array 
		if(isValid)
			return true;
		else
			return false;
	}

	public static void main(String[] args) {
		System.out.println(validShuffle("AB","CD","ACBD"));
	}

}
//Duplicates case can be solved using recursion but it takes o(2^n) in worst case
//Recusrsion solution involved lot of overlapping subproblems
//Hence DP provides best solution