package Trees;

public class BinaryTree {

    Node root;
    // Preorder = Root → Left → Right
    void preorder(Node p) {
        if (p != null) {
            System.out.print(p.data + " ");
            preorder(p.left);
            preorder(p.right);
        }
    }

    // Inorder = Left → Root → Right
    // sıralı (sorted) veri verir!)
    void inorder(Node p) {
        if (p != null) {
            inorder(p.left);
            System.out.print(p.data + " ");
            inorder(p.right);
        }
    }

    // Postorder = Left → Right → Root
    void postorder(Node p) {
        if (p != null) {
            postorder(p.left);
            postorder(p.right);
            System.out.print(p.data + " ");
        }
    }


    // HEIGHT (Yükseklik)
    // height = en uzun path (node → leaf)
    int height(Node p) {
        if (p == null) return -1;
        int leftH = height(p.left);
        int rightH = height(p.right);
        return Math.max(leftH, rightH) + 1;
    }


    //  COUNT LEAVES (yaprak sayısı)
    // leaf = çocuğu olmayan node
    int countLeaves(Node p) {
        if (p == null) return 0;
        if (p.left == null && p.right == null) return 1;
        return countLeaves(p.left) + countLeaves(p.right);
    }


    // FIND MAX VALUE IN BINARY TREE
    // (BST değil, normal binary tree)
    int findMax(Node p) {
        if (p == null) return Integer.MIN_VALUE;
        int rootVal = p.data;
        int leftVal = findMax(p.left);
        int rightVal = findMax(p.right);
        return Math.max(rootVal, Math.max(leftVal, rightVal));
    }


    // SUM OF ALL VALUES
    int sum(Node p) {
        if (p == null) return 0;
        return p.data + sum(p.left) + sum(p.right);
    }


    // INVERT TREE (Left–Right Subtrees Swap)
    // Ağaçtaki tüm left-right çocuklarını değiştir
    void invert(Node p) {
        if (p == null) return;

        Node temp = p.left;
        p.left = p.right;
        p.right = temp;

        invert(p.left);
        invert(p.right);
    }


    // --------------------------------------------
    // INSERT
    // --------------------------------------------
    Node insert(Node p, int value) {
        if (p == null) return new Node(value);

        if (value < p.data)
            p.left = insert(p.left, value);
        else if (value > p.data)
            p.right = insert(p.right, value);

        return p;
    }


    //  SEARCH
    // --------------------------------------------
    Node search(Node p, int key) {
        if (p == null || p.data == key)
            return p;
        if (key < p.data)
            return search(p.left, key);
        return search(p.right, key);
    }

    // --------------------------------------------
    // DELETE
    // --------------------------------------------
    Node delete(Node p, int key) {
        if (p == null) return null; // Ağaç boşsa

        if (key < p.data)
            p.left = delete(p.left, key); // Sola git ve sonucu sola bağla
        else if (key > p.data)
            p.right = delete(p.right, key); // Sağa git ve sonucu sağa bağla
        else {
            // Case 1: Leaf
            if (p.left == null && p.right == null)
                return null;
                // Case 2: One child
            else if (p.left == null)
                return p.right;
            else if (p.right == null)
                return p.left;
                // Case 3: Two children
            else {
                // inorder successor = right subtree’s min
                Node successor = findMinNode(p.right);
                p.data = successor.data;
                p.right = delete(p.right, successor.data);
            }
        }
        return p;
    }

    Node findMinNode(Node p) {
        while (p.left != null)
            p = p.left;
        return p;
    }


    // TREESORT
    // Build BST → Inorder → Sorted Output
    void treeSort(int[] arr) {
        // BST oluştur
        for (int val : arr)
            root = insert(root, val);

        // BST sıralı hale getirdi
        index = 0;
        inorderFill(root, arr);
    }

    int index = 0;

    void inorderFill(Node p, int[] arr) {
        if (p != null) {
            inorderFill(p.left, arr);
            arr[index++] = p.data;
            inorderFill(p.right, arr);
        }
    }
    void printTree(Node root) {
        printTreeRec(root, 0);
    }

    void printTreeRec(Node p, int level) {
        if (p == null) return;

        // Önce sağ alt ağacı yaz (yukarıya denk gelir)
        printTreeRec(p.right, level + 1);

        // Kökü sola doğru boşluk vererek yaz
        for (int i = 0; i < level; i++) {
            System.out.print("    ");  // 4 boşluk
        }
        System.out.println(p.data);

        // Sonra sol alt ağacı yaz (aşağıya denk gelir)
        printTreeRec(p.left, level + 1);
    }

}



