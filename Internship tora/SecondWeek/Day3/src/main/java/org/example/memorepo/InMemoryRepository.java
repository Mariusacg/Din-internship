package org.example.memorepo;

public interface InMemoryRepository <T>{
    public void add(T element);
    public boolean contains(T element);
    public void remove(T element);
}
