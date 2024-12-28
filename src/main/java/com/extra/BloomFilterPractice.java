package com.extra;

import java.util.BitSet;

public class BloomFilterPractice {

    private final int hashFunctionSize;
    private final int bitSetSize;
    private final BitSet bitSet;

    // Constructor with custom size for hash functions and bit set
    public BloomFilterPractice(int hashFunctionSize, int bitSetSize) {
        this.hashFunctionSize = hashFunctionSize;
        this.bitSetSize = bitSetSize;
        this.bitSet = new BitSet(bitSetSize);
    }

    // Default constructor with predefined size
    public BloomFilterPractice() {
        this.bitSetSize = 1000;
        this.hashFunctionSize = 5;
        this.bitSet = new BitSet(this.bitSetSize);
    }

    // Create hash values for a given string
    public int[] createHashes(String value) {
        int[] hashes = new int[hashFunctionSize];
        for (int i = 0; i < hashFunctionSize; i++) {
            System.out.println("value.hashCode()========>" + value.hashCode());
            hashes[i] = Math.abs(value.hashCode() + i) % bitSetSize; // Generate hash and map to BitSet size
        }
        return hashes;
    }

    // Check if the value might be present in the Bloom Filter
    public boolean isMightPresent(String value) {
        int[] hash = createHashes(value);
        for (int i : hash) {
            if (!bitSet.get(i)) { // If any hash position is 0, it's definitely not present
                return false;
            }
        }
        return true; // All hash positions are set to 1, the value might be present
    }

    // Add a value to the Bloom Filter
    public void add(String value) {
        int[] hash = createHashes(value);
        System.out.println("==============================");
        for (int i : hash) {
            System.out.println("BitSet---->" + i);
            bitSet.set(i); // Set the bit corresponding to the hash position
        }
        System.out.println("==============================");
    }

    public static void main(String[] args) {
        BloomFilterPractice bm = new BloomFilterPractice(); // Create an instance of BloomFilter

        bm.add("vishal"); // Add a value to the Bloom Filter

        // Check if the value "vishal" might be present in the Bloom Filter
        System.out.println(bm.isMightPresent("vishal")); // Expected: true (as "vishal" was added)
        System.out.println(bm.isMightPresent("notvishal")); // Expected: false (as "notvishal" was not added)
    }
}
