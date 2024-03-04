package in.dsa.cn.problems;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LongestCommonPrefix prefix = new LongestCommonPrefix();
		
		String[] res = new String[] {"ni", "nil", "nile"};
		
		String output = prefix.longestCommonPrefix(res, 3);
		System.out.println(output);

	}

}
