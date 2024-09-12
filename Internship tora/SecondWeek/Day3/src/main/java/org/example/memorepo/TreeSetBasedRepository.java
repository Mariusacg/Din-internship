package org.example.memorepo;

import java.util.Set;
import java.util.TreeSet;

public class TreeSetBasedRepository<T> implements InMemoryRepository<T>{
    private Set<T> set;
    public TreeSetBasedRepository() {
        set = new TreeSet<T>();
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
