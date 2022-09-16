package vm.partialkeyindex;

public class TrieLeaf<T> extends TrieNode {

    final private T value;

    public TrieLeaf(final String key, final T value) {
        super(key, null);
        this.value = value;
    }

    public T getValue() {
        return value;
    }

}
