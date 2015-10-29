package pl.wujko.map;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/**
 * Created by Agata on 2015-10-25.
 */
public class WujkoMap <K, V>
{
    private List<K> keyList;
    private List<V> valueList;

    public WujkoMap()
    {
        this.keyList = new ArrayList<K>();
        this.valueList = new ArrayList<V>();
    }

    public WujkoMap(WujkoMap<K, V> entryMap)
    {
        super();
        if (entryMap == null)
        {
            return;
        }
        this.keyList = new ArrayList<K>(entryMap.keyList);
        this.valueList = new ArrayList<V>(entryMap.valueList);
    }

    public WujkoMap(List<K> keyList, List<V> valueList)
    {
        if (keyList == null || valueList == null || keyList.size() != valueList.size())
        {
            this.keyList = new ArrayList<K>();
            this.valueList = new ArrayList<V>();
            return;
        }

        this.keyList = new ArrayList<K>(keyList);
        this.valueList = new ArrayList<V>(valueList);
    }

    public boolean put(K key, V value)
    {
        int indexOfKey = keyList.indexOf(key);

        if (indexOfKey == -1)
        {
            keyList.add(key);
            valueList.add(value);
        }
        else
        {
            valueList.add(indexOfKey, value);
            valueList.remove(indexOfKey + 1);
        }

        return true;
    }

    public void remove(K key)
    {
        int indexOf = indexOf(key);
        keyList.remove(indexOf);
        valueList.remove(indexOf);
    }

    public K getKey(int index)
    {
        if (index < keyList.size())
        {
            return keyList.get(index);
        }
        return null;
    }

    public V get(K key)
    {
        int indexOfKey = indexOf(key);
        return valueList.get(indexOfKey);
    }

    public V get(int index)
    {
        if (index < size())
        {
            return valueList.get(index);
        }
        return null;
    }


    public int indexOf(K key)
    {
        return keyList.indexOf(key);
    }

    public int size()
    {
        return keyList.size();
    }

    public boolean isEmpty()
    {
        return keyList.isEmpty();
    }

    public List<K> keyList()
    {
        return keyList;
    }

    public Set<K> keys()
    {
        return new HashSet<K>(keyList);
    }

    public Set<V> values()
    {
        return new HashSet<V>(valueList);
    }

    public void clear()
    {
        keyList.clear();
        valueList.clear();
    }

    public List<V> valueList()
    {
        return valueList;
    }

    public List<Pair> pairs()
    {
        LinkedList<Pair> pairs = new LinkedList<Pair>();

        for (int i = 0; i < keyList.size(); ++i)
        {
            pairs.add(new Pair(i, keyList.get(i), valueList.get(i)));
        }

        return pairs;
    }

    public class Pair {

        private int index;

        private K key;

        private V value;

        public Pair(int index, K key, V value)
        {
            this.index = index;
            this.key = key;
            this.value = value;
        }

        public int getIndex()
        {
            return index;
        }

        public void setIndex(int index)
        {
            this.index = index;
        }

        public K getKey()
        {
            return key;
        }

        public void setKey(K key)
        {
            this.key = key;
        }

        public V getValue()
        {
            return value;
        }

        public void setValue(V value)
        {
            this.value = value;
        }
    }
}
