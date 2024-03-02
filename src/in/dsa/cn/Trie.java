package in.dsa.cn;


class TrieNode{
	char data;
	boolean isTerminal;
	TrieNode[] children;
	int childCount;
	
	public TrieNode(char data){
		this.data = data;
		this.isTerminal = false;
		this.children = new TrieNode[26];
		this.childCount = 0;
	}
	
	
}

public class Trie {

	private TrieNode root;
	
	public Trie() {
		this.root = new TrieNode('\0');
	}
	
	private void addHelper(String word, TrieNode root) {
		
		if(word.length() == 0) {
			root.isTerminal = true;
			return;
		}
		
		int childIndex = word.charAt(0) - 'a';
		
		TrieNode child = root.children[childIndex];
		if(child == null) {
			child = new TrieNode(word.charAt(0));
			root.children[childIndex] = child;
			root.childCount++;
		}
		
		addHelper(word.substring(1), child);
		
	}
	
	public void add(String word) {
		addHelper(word, root);
	}
	
	private boolean searchHelper(TrieNode root, String word) {
		
		//base condition:
		if(word.length() == 0) return root.isTerminal;
		
		int childIndex = word.charAt(0) - 'a';
		TrieNode child = root.children[childIndex];
		
		if(child == null) return false;
		
		return searchHelper(child, word.substring(1));
		
	}
	
	
	public boolean search(String word) {
		return searchHelper(root, word);
	}
	

	private void removeWordHelper(TrieNode root, String word) {
		
		//base case:
		if(word.length() == 0) {
			root.isTerminal = false;
			return;
		}
	
		int childIndex = word.charAt(0) - 'a';
		
		TrieNode child = root.children[childIndex];
		if(child == null) return;  //the word doesn't exist hence nothing to remove:
		
		removeWordHelper(child, word);
		
		//making that child == null: 
		if(!child.isTerminal && child.childCount == 0) {
			root.children[childIndex] = null;
			root.childCount--;
		}
		
		
	}
	
	public void removeWord(String word) {
		removeWordHelper(root, word);
	}

	
}




