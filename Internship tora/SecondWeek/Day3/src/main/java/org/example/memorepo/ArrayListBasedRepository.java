package org.example.memorepo;

import java.util.ArrayList;
import java.util.List;

public class ArrayListBasedRepository <T> implements InMemoryRepository<T>{
    private List<T> list;
    public ArrayListBasedRepository() {
        list = new ArrayList<T>();
    }
    @Override
    public void add(T element) {
        list.add(element);
    }
    @Override
    public boolean contains(T element) {
        return list.contains(element);
    }
    @Override
    public void remove(T element) {
        list.remove(element);
    }
}
