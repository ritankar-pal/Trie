package in.dsa.cn.problems;

class Node1{

	public Node1[] links;
	
	public Node1() {
		this.links = new Node1[2];
	}
	
	public boolean containsKey(int bit) {
		return (links[bit] != null);
	}
	
	public Node1 get(int bit) {
		return links[bit];
	}
	
	public void put(int bit, Node1 node) {
		links[bit] = node;
	}

}


class Trie1{
	
	public static Node1 root;

	public Trie1() {
		this.root = new Node1();
	}
	
	
	public static void insert(int num) {
		
		Node1 node = root;
		
		for(int i = 31; i >= 0; i--) {
			int bit = (num >> i) & 1;
			if(!node.containsKey(bit)) {
				node.put(bit, new Node1());
			}
			node = node.get(bit);
		}
	}
	
	public static int getMax(int num) {
		
		Node1 node = root; 
		
		int maxNum = 0;
		
		for(int i = 31; i >= 0; i--) {
			
			int bit = (num >> i) & 1;
			
			if(node.containsKey(1-bit)) {
				maxNum = maxNum | (1 << i);
				node = node.get(1-bit);
			}
			else node = node.get(bit);
		}
		
		return maxNum;
		
	}
	
}


public class MaxXorOftwoNumbers {

}
