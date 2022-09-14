package com.travelcompany.eshop.model;


import lombok.Data;

@Data
public class KeyValue<K, V> {
    private final K key;
    private final V value;


    public KeyValue(K key, V value) {
        this.key = key;
        this.value = value;
    }


    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("KeyValue{");
        sb.append("key=").append(key);
        sb.append(", value=").append(value);
        sb.append('}');
        return sb.toString();
    }
}

