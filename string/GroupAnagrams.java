import java.util.ArrayList;
import java.util.HashMap;

public class GroupAnagrams {
	
	// Other approaches on gfg

	// efficient approach using trie Advanced Data Structure
	static ArrayList<ArrayList<String>> solve(ArrayList<String> list)
	{
//		HashMap<HashMap<Character, Integer>, ArrayList<String>> map = new HashMap<HashMap<Character, Integer>,
//				ArrayList<String>>();
		HashMap<HashMap<Character, Integer>, ArrayList<String>> map = new HashMap<>();
		
		for(String str : list)
		{
			HashMap<Character, Integer> tempMap = new HashMap<>();
			// counting frequency of characters present in a string
			for(int i = 0;i < str.length() ; i++)
			{
				if(tempMap.containsKey(str.charAt(i)))
				{
					int x = tempMap.get(str.charAt(i));
					tempMap.put(str.charAt(i), ++x);
				}
				
				else
				{
					tempMap.put(str.charAt(i), 1);
				}
			}
			
			if(map.containsKey(tempMap))
				map.get(tempMap).add(str);
			else
			{
				ArrayList<String> tempList = new ArrayList<String>();
				tempList.add(str);
				map.put(tempMap, tempList);
			}
		}
		ArrayList<ArrayList<String>> res = new ArrayList<>();
		for(HashMap<Character, Integer> temp : map.keySet())
			res.add(map.get(temp));
		return res;
	}

	public static void main(String[] args) {
		ArrayList<String> list = new ArrayList<>();
		list.add("cat");
		list.add("dog");
		list.add("ogd");
		list.add("god");
		list.add("atc");
		
		System.out.println(solve(list));

	}

}
