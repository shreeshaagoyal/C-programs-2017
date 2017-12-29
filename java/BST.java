public class BST {
    BSTNode root;

    public BST() {
        this.root = null;
    }

    public void add(int value) {
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
        // find node that has the given value

        // store its left node in leftNode

        // if its right node exists, go to its right node. store valiue in rightNode

        // go to rightNode's left most node

        // left most node -> left node -> leftNode

        // n's parent node -> n.right

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
                BSTNode leftMostNode = this.findLeftMostNode(n.right);
                leftMostNode.left = leftNode;
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

    private BSTNode findLeftMostNode(BSTNode n) {
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

    }
}