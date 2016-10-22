public class ProfessionFinder {
	public static boolean isEngineer(int profTree, int level, int position) {
		int engMask = 0x80000000;

		int lNdx = ((int) Math.pow(2, level - 1)) - 1 + (position - 1);
		engMask = engMask >>> lNdx;

		return (profTree & engMask) != 0;
	}

	public static boolean isDoctor(int profTree, int level, int position) {
		return !isEngineer(profTree, level, position);
	}

	public static void main(String[] args) {
		int tree = 0xD32C0000; //1 10 1001 10010110 (0)

		assert isEngineer(tree, 1, 1);
		assert isEngineer(tree, 2, 1);
		assert isDoctor(tree, 2, 2);
		assert isEngineer(tree, 3, 1);
		assert isDoctor(tree, 3, 2);
		assert isDoctor(tree, 3, 3);
		assert isEngineer(tree, 3, 4);
	}
}
