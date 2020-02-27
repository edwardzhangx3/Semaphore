import java.util.*;
class levelOrder {
	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(6);
		root.left.right.left = new TreeNode(10);
		root.left.right.right = new TreeNode(13);
		root.left.right.left.left = new TreeNode(14);
		root.right.left = new TreeNode(8);
		System.out.println("level order of tree: " + levelOrder(root));
		System.out.println("level order of tree in dfs: " + levelOrderDFS(root));
		
	}
	public static List<List<Integer>> levelOrderDFS(TreeNode root) {
		List<List<Integer>> res = new ArrayList<>();
		levelOrderHelper(root, 0, res);
		return res;
	}
	public static void levelOrderHelper(TreeNode root, int level, List<List<Integer>> ans){
		if (root == null) return;
		if (ans.size() == level){
			ans.add(new ArrayList<>());
		}
		ans.get(level).add(root.val);
		levelOrderHelper(root.left, level + 1, ans);
		levelOrderHelper(root.right, level + 1, ans);

	}
	public static List<List<Integer>> levelOrder(TreeNode root) {
		List<List<Integer>> res = new ArrayList<>();
		if (root == null) return res;
		Queue<TreeNode> q = new LinkedList<>();
		q.offer(root);
		while(!q.isEmpty()){
			int levelSize = q.size();
			List<Integer> level = new ArrayList<>();
			for (int i = 0; i < levelSize;i++){
				TreeNode node = q.poll();
				if (node.left != null) q.add(node.left);
				if (node.right != null) q.add(node.right);
				level.add(node.val);
			}
			res.add(level);
		}
		return res;
	}
}

class TreeNode{
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode(int val){
		this.val = val;
	}
	
}