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

class TrieDS {
	
	public static Node root;

	public TrieDS() {
		this.root = new Node();
	}

	public static void insert(String word) {	

		Node node = root;
		
		for(int i = 0; i < word.length(); i++) {
			if(!node.containsKey(word.charAt(i))) {
				node.put(word.charAt(i), new Node());
			}
			node = node.get(word.charAt(i));
			node.increasePrefix();  //increasing the prefix
		}
		node.setEnd();
	}
	
	public static int commonPrefx(String word, int size) {
		
		Node node = root;
		
		int res = 0;
		
		for(int i = 0; i < word.length(); i++) {
			if(node.containsKey(word.charAt(i))) {
				node = node.get(word.charAt(i)); 
				if(node.getPrefix() == size) {
					res++;
				}
				else break;
			}
		}
		
		return res;
	}
}


public class LongestCommonPrefix {
	
	public static String longestCommonPrefix(String[] arr, int n) {
		
		TrieDS trie = new TrieDS();
		
		String res = "";
		
		for (String word : arr) {
			trie.insert(word);
		}
		
		int length = trie.commonPrefx(arr[0], n);
		
		if(length == 0) return res;
		
		res = res + arr[0].substring(0, length);
			
		return res;
	}
}
