package stack;

public class MaxAreaRectBinaryMatrix {
	
	// variation of maximum area histogram
	
	static int MaxArea(int a[][])
	{
		int n = a.length;                  // rows
		int m = a[0].length;              // columns
		
		int max = LargestRectangularAreaInHistogram.mah(a[0]);
		int temp[] = a[0];
		for(int i = 1;i<n; i++)
		{
			for(int j =0 ;j<m;j++)
			{
				if(a[i][j] == 0)
					temp[j] = 0;
				else
					temp[j]+=1;
			}
			max = Math.max(max, LargestRectangularAreaInHistogram.mah(temp));

		}
		return max;
	}

	public static void main(String[] args) {
		int a[][] = {
				{0, 1, 1, 0},
				{1, 1, 1, 1},
				{1, 1, 1, 1},
				{1, 1, 0, 0},
		};
		int a1[][] = {
				{0, 1, 1},
				{1, 1, 1},
				{0, 1, 1},
		};
		
		
		System.out.println(MaxArea(a1));

	}

}
