public class Trie {
	public static final int CHAR_MAX = 256;

	public static class TrieNode {
		public boolean isLeaf;
		public TrieNode[] children;

		public TrieNode() {
			children = new TrieNode[CHAR_MAX];
			isLeaf = false;
		}
	}

	public static TrieNode insert(TrieNode root, String str) {
		if ("".equals(str)) {
			root.isLeaf = true;
			return root;
		}

		return insert(root, str, 0);
	}

	private static TrieNode insert(TrieNode root, String str, int charNdx) 	{
		if (charNdx < 0 || charNdx >= str.length())
			throw new IllegalArgumentException();

		int currChar = str.charAt(charNdx);
		
		if (currChar >= CHAR_MAX) {
			throw new IllegalArgumentException();
		}

		if (root.children[currChar] == null) {
			root.children[currChar] = new TrieNode();
		}

		TrieNode child = root.children[currChar];

		if (charNdx == str.length() - 1)
			child.isLeaf = true;
		else
			insert(child, str, charNdx + 1);

		return root;
	}

	public static boolean exists(TrieNode root, String str) {
		return "".equals(str) ? root.isLeaf : exists(root, str, 0);
	}

	private static boolean exists(TrieNode root, String str, int charNdx) {
		if (charNdx >= str.length() || charNdx < 0)
			throw new IllegalArgumentException();
		
		int currChar = (int) str.charAt(charNdx);
		if (currChar >= CHAR_MAX)
			throw new IllegalArgumentException();

		TrieNode child = root.children[currChar];
		if (child == null) {
			return false;
		} else if (charNdx == str.length() - 1) {
			return child.isLeaf;
		}
		else {
			return exists(child, str, charNdx + 1);
		}
	}

	public static void main(String[] args) {
		TrieNode root = new TrieNode();
		Exception exc = null;

		try { exists(root, null); } catch (NullPointerException e) {
			exc = e;
		}
		assert exc != null;
		exc = null;

		try { exists(null, "app"); } catch (NullPointerException e) {
			exc = e;
		}
		assert exc != null;

		assert !exists(root, "app");
		assert !exists(root, "");
		assert exists(insert(root, ""), "");

		assert exists(insert(root, "app"), "app");
		assert !exists(root, "a");
		assert !exists(root, "apple");
		assert exists(insert(root, "apple"), "apple");
		assert exists(root, "app");
	}
}
