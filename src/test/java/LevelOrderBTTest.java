import org.example.karthick.LevelOrderBT;
import org.example.karthick.TreeNode;

public class LevelOrderBTTest {
    public static void main(String[] args) {

        TreeNode node15 = new TreeNode(15);
        TreeNode node7 = new TreeNode(7);
        TreeNode node20 = new TreeNode(20, node15, node7);
        TreeNode node9 = new TreeNode(9);
        TreeNode root = new TreeNode(3, node9, node20);

        LevelOrderBT levelOrderBT = new LevelOrderBT();
        System.out.println(levelOrderBT.levelOrder(root));

        levelOrderBT.printInOrder(root);

//        TreeNode root = new
    }
}
