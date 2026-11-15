import java.util.*;

public class PharmacyInventory {
    public static void main(String[] args) {
        HashMap<String, Integer> hashMap =
            new HashMap<>();

        TreeMap<String, Integer> treeMap =
            new TreeMap<>();

        LinkedHashMap<String, Integer> linkedMap =
            new LinkedHashMap<>();

        String[] codes = {
            "M103", "M101", "M105", "M102"
        };

        int[] stocks = {50, 100, 30, 80};

        for (int i = 0; i < codes.length; i++) {
            hashMap.put(codes[i], stocks[i]);
            treeMap.put(codes[i], stocks[i]);
            linkedMap.put(codes[i], stocks[i]);
        }

        System.out.println("Stock Lookup: " +
            hashMap.get("M101"));

        System.out.println("HashMap: " + hashMap);

        System.out.println("TreeMap (Code Order): " +
            treeMap);

        System.out.println("LinkedHashMap (Insertion Order): " +
            linkedMap);

        System.out.println("Total Medicines: " +
            hashMap.size());
    }
}
