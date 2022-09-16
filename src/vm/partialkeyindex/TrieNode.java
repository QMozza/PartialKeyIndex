package vm.partialkeyindex;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class TrieNode {

    private final String key;

    private final HashMap<String, TrieNode> children;
    private TrieNode emptyKeyChild;

    public TrieNode(String key) {
        this.key = key;
        this.children = new HashMap<>();
    }

    protected TrieNode(String key, Object dummyParameterDoNotInitializeChildren) {
        this.key = key;
        this.children = new HashMap<>();
    }

    public String getKey() {
        return this.key;
    }

    public Map<String, TrieNode> getChildren() {
        return this.children;
    }

    public TrieNode getEmptyKeyChild() {
        return emptyKeyChild;
    }

    public void setEmptyKeyChild(final TrieNode emptyKeyChild) {
        this.emptyKeyChild = emptyKeyChild;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TrieNode trieNode = (TrieNode) o;
        return this.key.equals(trieNode.key);
    }

    @Override
    public int hashCode() {
        return Objects.hash(key);
    }
}
