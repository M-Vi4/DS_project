public class Trie {
    private final TrieNode root;
    public Trie(){
        this.root = new TrieNode();
    }

    public void insertBank(String word , Bank bank){
        TrieNode current = root;
        for (int i = 0; i < word.length(); i++) {
            int index = word.charAt(i) - 'a';
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
            int index = word.charAt(i) - 'a';
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
            int index = word.charAt(i) - 'a';
            if (current.getChildren()[index] == null)
                return null;
            current = current.getChildren()[index];
        }
        if (current.isWord())
            return current;
        return null;
    }
}