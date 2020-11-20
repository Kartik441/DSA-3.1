
public class MinReversalsToBalanceBrackets {
	
	//can be solved recursively O(2^n)
	
	// The idea is to first remove all balanced part of expression
	static int min(String s)
	{
		int n = s.length();
		int open = 0;       // current open that are unbalanced
		int close = 0;      // current close that are unbalanced
		
		if(s.length() % 2 !=0)
			return -1;
		
		for(int i=0;i<n;i++)
		{
			if(s.charAt(i) == '{')
			{
				open++;
			}
			else
			{
				if(open == 0)
					close++;
				else
					open--;
			}
		}
		
		// after this loop open and close will contain unbalanced brackets
		int ans = (close/2) + (open/2);
		
		// for case: }{
		
		if(close % 2 != 0)     // if close is not even
			ans += 2;
		
		return ans;
		
		
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "}{{}}{{{";
		String s1 = "}{}}";
		System.out.println(min(s1));

	}

}
