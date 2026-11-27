
class TrieNode {
    public TrieNode[] nextNodes;
    public boolean isWord;

    public TrieNode() {
        this.nextNodes = new TrieNode[128];
    }
}

class PrefixTree {

    private TrieNode root;

    public PrefixTree() {
         this.root = new TrieNode();
    }

    public void insert(String word) {
        TrieNode tempRoot = root;
        for (Character ch : word.toCharArray()) {
            int ascii = (int) ch;
            if (tempRoot.nextNodes[ascii] == null) {
                tempRoot.nextNodes[ascii] = new TrieNode();
            }
            tempRoot = tempRoot.nextNodes[ascii];
        }
        tempRoot.isWord = true;
    }

    public boolean search(String word) {
        TrieNode tempRoot = root;
        for (Character ch : word.toCharArray()) {
            int ascii = (int) ch;
            if (tempRoot.nextNodes[ascii] == null) {
                return false;
            }
            tempRoot = tempRoot.nextNodes[ascii];
        }
        return true && tempRoot.isWord;
    }

    public boolean startsWith(String prefix) {
        TrieNode tempRoot = root;
        for (Character ch : prefix.toCharArray()) {
            int ascii = (int) ch;
            if (tempRoot.nextNodes[ascii] == null) {
                return false;
            }
            tempRoot = tempRoot.nextNodes[ascii];
        }
        return true;
    }
}
