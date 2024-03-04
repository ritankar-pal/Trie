package in.dsa.cn.problems;


/*class Node{

	public Node[] links;
	public boolean flag;

	public Node() {
		this.links = new Node[26];
		this.flag = false;
	}

	public boolean containsKey(char ch) {
		return (links[ch - 'a'] != null);
	}

	public Node get(char ch) {
		return links[ch - 'a'];
	}

	public void put(char ch, Node node) {
		links[ch - 'a'] = node;
	}

	public void setEnd() {
		flag = true;
	}

	public boolean isEnd() {
		return flag;
	}

}*/


public class NumberOfDistinctSubstring {
	
	public static int countSubStrings(String word) {
		
		Node root = new Node();
		int count = 0;
		
		for(int i = 0; i < word.length(); i++) {
			
			Node node = root;
			
			for(int j = i; j < word.length(); j++) {
				if(!node.containsKey(word.charAt(i))) {
					node.put(word.charAt(i), new Node());
					count++;
				}
				node = node.get(word.charAt(i));
			}
		}
		return count + 1;   //"": empty string also included
	}
}











