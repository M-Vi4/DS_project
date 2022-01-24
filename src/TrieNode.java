public class TrieNode {
    private TrieNode[] children;
    private boolean isWord;
    private Bank bank;
    private Neighborhood neighborhood;
    private boolean isBank;

    public TrieNode() {
        this.children = new TrieNode[26];
        this.isWord = false;
        for (int i = 0; i < 26; i++) {
            children[i] = null;
        }
    }

    public TrieNode[] getChildren(){
        return children;
    }

    public void setChildren(int i , TrieNode trieNode){
        this.children[i] = trieNode;
    }

    public boolean isWord() {
        return isWord;
    }

    public void setWord(boolean word) {
        isWord = word;
    }

    public Bank getBank() {
        return bank;
    }

    public void setBank(Bank bank) {
        this.bank = bank;
    }

    public Neighborhood getNeighborhood() {
        return neighborhood;
    }

    public void setNeighborhood(Neighborhood neighborhood) {
        this.neighborhood = neighborhood;
    }

    public boolean isBank() {
        return isBank;
    }

    public void setBank(boolean bank) {
        isBank = bank;
    }
}
