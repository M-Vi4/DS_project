public class Trie {
    private final TrieNode root;
    public Trie(){
        this.root = new TrieNode();
    }

    public void insertBank(String word , Bank bank){
        TrieNode current = root;
        for (int i = 0; i < word.length(); i++) {
            int index = getIndex(i , word);
            if (current.getChildren()[index] == null){
                TrieNode trieNode = new TrieNode();
                current.setChildren(index , trieNode);
            }
            current = current.getChildren()[index];
        }
        current.setWord(true);
        current.setBank(true);
        current.setBank(bank);
    }

    public void insertNeighborhood(String word , Neighborhood neighborhood){
        TrieNode current = root;
        for (int i = 0; i < word.length(); i++) {
            int index = getIndex(i , word);
            if (current.getChildren()[index] == null){
                TrieNode trieNode = new TrieNode();
                current.setChildren(index , trieNode);
            }
            current = current.getChildren()[index];
        }
        current.setWord(true);
        current.setBank(false);
        current.setNeighborhood(neighborhood);
    }

    public TrieNode search(String word){
        TrieNode current = root;
        for (int i = 0; i < word.length(); i++) {
            int index = getIndex(i , word);
            if (current.getChildren()[index] == null)
                return null;
            current = current.getChildren()[index];
        }
        if (current.isWord())
            return current;
        return null;
    }

    public int getIndex(int c , String word){
        int index = -1;
        if (word.charAt(c) > 64 && word.charAt(c) < 91)
            index = word.charAt(c) + 26 - 'A';
        else if (word.charAt(c) > 96 && word.charAt(c) < 122)
            index = word.charAt(c) - 'a';
        return index;
    }
}