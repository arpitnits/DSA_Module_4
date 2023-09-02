package Hashing;

import java.util.ArrayList;

public class HashTableImplementation {

    static class HashNode<K,V> {
        K key;
        V value;
        HashNode<K,V> next = null;

        HashNode(K key, V val) {
            this.key = key;
            this.value = val;
        }
    }

    static class Map<K,V> {
        int numberBucket, size;
        ArrayList<HashNode<K,V>> bucketArray;
        Map() {
            bucketArray = new ArrayList<>();
            numberBucket = 8;
            size = 0;

            for(int i=0;i<numberBucket;i++) {
                bucketArray.add(null);
            }
        }

        private int getBucketIndex(K key) {
            int index = key.hashCode() % numberBucket;
            return index<0 ? index * -1 : index;
        }

        public void remove(K key) {
            int bucketIndex = getBucketIndex(key);
            HashNode<K,V> head = bucketArray.get(bucketIndex);
            HashNode<K,V> prev = null;

            while (head!=null) {
                if(head.key.equals(key))
                    break;
                prev = head;
                head = head.next;
            }
            if(head==null)
                return;

            if(prev!=null)
                prev.next = head.next;
            else
                bucketArray.set(bucketIndex, head.next);

            size--;
        }

        public V get(K key) {
            int bucketIndex = getBucketIndex(key);
            HashNode<K,V> head = bucketArray.get(bucketIndex);

            while(head!= null) {
                if(head.key.equals(key)) {
                    return head.value;
                }
                head = head.next;
            }
            return null;
        }


        public void add(K key, V value) {
            int bucketIndex = getBucketIndex(key);
            HashNode<K, V> head = bucketArray.get(bucketIndex);

            //might already exist, so update
            while(head!=null) {
                if(head.key.equals(key)) {
                    head.value = value;
                }
                head = head.next;
            }

            head = bucketArray.get(bucketIndex);
            HashNode<K,V> newNode = new HashNode<>(key, value);

            //add New node at head
            newNode.next = head;
            bucketArray.set(bucketIndex, newNode);
            size++;

            //if loadFactor is more than threshold then increase the size of hashTable
            if((1.0 * size)/numberBucket > 0.8) {
                System.out.println("Load Factor is more than threshold, increase the size of buckets");
            }

        }
    }


}
