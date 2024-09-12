package org.example.memorepo;

import java.util.HashSet;
import java.util.Set;

public class HashSetBasedRepository<T> implements InMemoryRepository<T>{
    private Set<T> set;
    public HashSetBasedRepository() {
        set = new HashSet<T>();
    }
    @Override
    public void add(T element) {
        set.add(element);
    }
    @Override
    public boolean contains(T element) {
       return set.contains(element);
    }
    @Override
    public void remove(T element) {
        set.remove(element);
    }
}
