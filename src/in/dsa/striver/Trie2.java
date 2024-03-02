package in.dsa.striver;

public class Trie2 {

	private Node root;

	public Trie2() {
		this.root = new Node();
	}

	public void insert(String word) {
		
		Node node = root;
		
		for(int i = 0; i < word.length(); i++) {
			
			if(!node.containsKey(word.charAt(i))) {
				node.put(word.charAt(i), new Node());
			}
			node = node.get(word.charAt(i));
			node.increasePrefix();
		}
		node.increaseEnd();
	}
	
	
	public int countWordsEqualTo(String word) {
		
		Node node = root;
		
		for(int i = 0; i < word.length(); i++) {
			if(!node.containsKey(word.charAt(i))) return 0;
			node = node.get(word.charAt(i));
		}
		return node.getEnd();
	}
	
	
	public int countWordsStartWith(String prefix) {
		
		Node node = root;
		for(int i = 0; i < prefix.length(); i++) {
			if(!node.containsKey(prefix.charAt(i))) return 0;
			node = node.get(prefix.charAt(i));
		}
		return node.getPrefix();
	}
	
	
	public void erase(String word) {
		
		Node node = root;
		for(int i = 0; i < word.length(); i++) {
			if(!node.containsKey(word.charAt(i))) return;
			
			node = node.get(word.charAt(i));
			node.decreasePrefix();
		}
		node.deleteEnd();
		
	}
	

	private class Node{

		Node[] links;
		int endsWith;
		int countPrefix;

		public Node() {
			this.links = new Node[26];
			this.endsWith = 0; 
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

		public void increasePrefix() {
			countPrefix++;
		}

		public void increaseEnd() {
			endsWith++;
		}

		public void decreasePrefix() {
			countPrefix--;
		}

		public void deleteEnd() {
			endsWith--;
		}
		
		public int getEnd() {
			return endsWith;
		}
		
		public int getPrefix() {
			return countPrefix;
		}

	}
}
