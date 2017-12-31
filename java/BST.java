public class BST {
    BSTNode root;

    public BST() {
        this.root = null;
    }

    public BST(int val) {
        this.root = new BSTNode(val);
    }

    public void add(int value) {

        if (this.root == null) {
            this.root = new BSTNode(value);
            return;
        }

        BSTNode currNode = this.root;
        BSTNode parentNode = currNode;
        while (currNode != null) {
            parentNode = currNode;
            if (value < currNode.value) {
                currNode = currNode.left;
            } else {
                currNode = currNode.right;
            }
        }
        if (value < parentNode.value) {
            parentNode.left = new BSTNode(value);
        } else {
            parentNode.right = new BSTNode(value);
        }
    } 

    public void remove(int value) {
        // edge case - if removing root of the tree
        if (value == this.root.value) {
            BSTNode leftMostNode = this.findLeftMostNode(this.root.right);
            leftMostNode.left = this.root.left;
            this.root = this.root.right;
            return;
        }

        BSTNode n = this.root;
        BSTNode parentNode = n;

        while (n != null) {
            if (value == n.value) {

                BSTNode leftNode = n.left;
                if (n.right != null) {
                    BSTNode leftMostNode = this.findLeftMostNode(n.right);
                    leftMostNode.left = leftNode;
                }
                if (value < parentNode.value) {
                    parentNode.left = n.right;
                } else {
                    parentNode.right = n.right;
                }
                return;
            }
            parentNode = n; 
            if (value < n.value) {
                n = n.left;
            } else {
                n = n.right;
            }
        }
        
    }

    private static BSTNode findLeftMostNode(BSTNode n) {
        BSTNode currNode = n;
        while (currNode.left != null) {
            currNode = currNode.left;
        }
        return currNode;
    }

    public Boolean contains(int value) {
        BSTNode result = this.findNode(value);
        if (result == null) {
            return false;
        } else {
            return true;
        }
    }

    public BSTNode findNode(int value) {
        BSTNode currNode = this.root;
        while (currNode != null) {
            if (value == currNode.value) {
                return currNode;
            } else if (value < currNode.value) {
                currNode = currNode.left;
            } else {
                currNode = currNode.right;
            }
        }
        return null;
    }

    public void printBST() {
        System.out.println("in printBST() method");
        this.printBST(this.root);
    }

    private void printBST(BSTNode n) {
        if (n != null) {
            printBST(n.left);
            System.out.println(n.value);
            printBST(n.right);
        }
    }

    public static void main(String[] args) {
        BST testBST = new BST(10);
        testBST.add(5);
        testBST.add(8);
        testBST.add(9);
        testBST.add(7);
        testBST.add(25);
        testBST.add(13);
        testBST.add(1);
        testBST.add(6);
        testBST.add(2);
        testBST.add(3);
        testBST.add(20);

        testBST.printBST();
    }
}