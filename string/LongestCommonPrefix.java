
public class LongestCommonPrefix {
	
	static int LCP(String[] str)
	{
		if(str.length == 0)
			return 0;
		
		int index = 0;
		
		while(index < str[0].length())
		{
			char ch =str[0].charAt(index);
			for(int i = 1;i<str.length;i++)
			{
				if(index >= str[i].length() || ch != str[i].charAt(index))
				{
					return index;
				}
				
			}
			index++;
			
		}
		return index;
	}
	    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str[] = {
				"flower", "flow", "flight"
		};
		
		String str1[] = {
				"dog", "racecar", "car"
		};
		
		String str2[] = {
				"apple", "app", "appe"
		};
		
		System.out.println(LCP(str2));

	}

}
