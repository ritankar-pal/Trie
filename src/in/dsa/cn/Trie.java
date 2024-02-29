package in.dsa.cn;


class TrieNode{
	char data;
	boolean isTerminal;
	TrieNode[] children;
	
	public TrieNode(char data){
		this.data = data;
		this.isTerminal = false;
		this.children = new TrieNode[26];
	}
	
	
}

public class Trie {

	private TrieNode root;
	
	public Trie() {
		this.root = new TrieNode('\0');
	}
	
}
