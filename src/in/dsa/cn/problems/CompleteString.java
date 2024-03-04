package in.dsa.cn.problems;


class Node{

	public Node[] links;
	public boolean flag;
	public int countPrefix = 0;

	public Node() {
		this.links = new Node[26];
		this.flag = false;
		this.countPrefix = 0;
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
	
	public void increasePrefix() {
		countPrefix++;
	}
	
	public int getPrefix() {
		return countPrefix;
	}

}


class Trie {

	public static Node root;

	public Trie() {
		this.root = new Node();
	}

	public static void insert(String word) {	

		Node node = root;
		for(int i = 0; i < word.length(); i++) {
			if(!node.containsKey(word.charAt(i))) {
				node.put(word.charAt(i), new Node());
			}
			node = node.get(word.charAt(i));
		}
		node.setEnd();
	}


	public static boolean checkIfPrefixExist(String word) {

		Node node = root;
		boolean flag = true;

		for(int i = 0; i < word.length(); i++) {
			if(!node.containsKey(word.charAt(i))) {
				return false;
			}			
			node = node.get(word.charAt(i));
			if(!node.isEnd()) return false;
		}

		return flag;
	}

}


public class CompleteString {

	public static String completeString(int n, String[] a) {

		Trie trie = new Trie(); //creating an object of the Trie:

		for (String word : a) {
			trie.insert(word);
		}

		String longest = "";

		for(String word : a) {
			if(trie.checkIfPrefixExist(word)) {	
				if(word.length() > longest.length()) {
					longest = word;
				}
				else if(word.length() == longest.length() && word.compareTo(longest) < 0) {
					longest = word;
				}
			}
		}
		
		if(longest == "") return "None";
		else return longest;
	}	


}





