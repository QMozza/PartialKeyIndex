package vm.partialkeyindex;

import java.util.Stack;
import java.util.function.Function;

public class PartialKeyIndex<K, V> {

    private TrieNode indexRoot;
    private final Function<K, String>[] keyElementSuppliers;

    @SafeVarargs
    public PartialKeyIndex(final Function<K, String>... keyElementSuppliers) {
        this.keyElementSuppliers = keyElementSuppliers;
    }

    public V put(final K key, final V value) {

        TrieNode currentNode = indexRoot;
        for (int i = 0; i < this.keyElementSuppliers.length; i++) {

            final Function<String, TrieNode> trieNodeGenerator;
            if (i < this.keyElementSuppliers.length - 1) {
                trieNodeGenerator = TrieNode::new;
            } else {
                trieNodeGenerator = k -> new TrieLeaf<>(k, value);
            }

            final String partialKey = this.keyElementSuppliers[i].apply(key);
            if (partialKey != null) {
                currentNode = currentNode.getChildren().computeIfAbsent(partialKey, trieNodeGenerator);
            } else {
                if (currentNode.getEmptyKeyChild() == null) {
                    currentNode.setEmptyKeyChild(trieNodeGenerator.apply(null));
                }
                currentNode = currentNode.getEmptyKeyChild();
            }
        }

        //noinspection unchecked
        return ((TrieLeaf<V>)currentNode).getValue();

    }

    public V get(final K key) {

    }

}
