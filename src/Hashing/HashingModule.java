package Hashing;

import java.util.HashMap;

public class HashingModule {

    public static void main(String[] args) {
        HashTableImplementation.Map<String, Integer> map = new HashTableImplementation.Map<>();

        map.add("Arpit", 88);
        map.add("Praful", 89);
        map.add("Nitin", 90);

        System.out.println(map.get("Nitin"));
        map.remove("Nitin");

        System.out.println(map.get("Nitin"));

    }
}
