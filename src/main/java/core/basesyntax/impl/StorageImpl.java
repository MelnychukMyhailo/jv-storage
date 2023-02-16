package core.basesyntax.impl;

import core.basesyntax.Storage;
import java.util.Objects;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int ARRAY_SIZE = 10;

    private K [] storegeOfKeys;
    private V [] storegeOfValues;
    private int sizeOfArrays;

    public StorageImpl() {
        storegeOfKeys = (K[]) new Object[ARRAY_SIZE];
        storegeOfValues = (V[]) new Object[ARRAY_SIZE];
    }

    private int keySearch(K key) {
        for (int i = 0; i < sizeOfArrays; i++) {
            if (Objects.equals(key, storegeOfKeys[i])) {
                return i;
            }
        }
        return sizeOfArrays++;
    }

    @Override
    public void put(K key, V value) {
        int keyPosition = keySearch(key);
        storegeOfKeys[keyPosition] = key;
        storegeOfValues[keyPosition] = value;
    }

    @Override
    public V get(K key) {
        int keyPosition = keySearch(key);
        return storegeOfValues[keyPosition];
    }

    @Override
    public int size() {
        return sizeOfArrays;
    }
}
