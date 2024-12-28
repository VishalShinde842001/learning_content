package com.extra;

import java.io.*;
import java.util.BitSet;

public class BloomFilter {
	private static final int SIZE = 10000; // Size of the bit array
	private BitSet bitSet;

	public BloomFilter() {
		bitSet = new BitSet(SIZE);
		loadFromFile();
	}

	private void loadFromFile() {
		File directory = new File("src/main/resources/bloomFilterFiles");
		if (!directory.exists()) {
			directory.mkdirs(); // Create the directory if it does not exist
		}

		File file = new File(directory, "bloomfilter.dat");

		if (file.exists()) {
			try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(file))) {
				bitSet = (BitSet) in.readObject();
			} catch (IOException | ClassNotFoundException e) {
				e.printStackTrace();
			}
		} else {
			System.out.println("File does not exist, initializing a new BitSet.");
			saveToFile(); // Optionally save an empty BitSet to the file
		}
	}

	private void saveToFile() {
		File directory = new File("src/main/resources/bloomFilterFiles");
		if (!directory.exists()) {
			directory.mkdirs(); // Create the directory if it does not exist
		}

		File file = new File(directory, "bloomfilter.dat");

		try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(file))) {
			out.writeObject(bitSet);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// Method to simulate deleting (resetting bits) from the Bloom Filter
	public void delete(String value) {
		int[] hashes = getHashes(value);
		for (int hash : hashes) {
			System.out.print("Hash====>" + hash);
			bitSet.clear(hash);
		}
		saveToFile();
	}

	public void add(String value) {
		int[] hashes = getHashes(value);
		for (int hash : hashes) {
			System.out.println("Hash====>" + hash);
			bitSet.set(hash);
		}
		saveToFile(); // Save state after modifying
	}

	public boolean contains(String value) {
		int[] hashes = getHashes(value);
		for (int hash : hashes) {
			if (!bitSet.get(hash)) {
				System.out.println("Not Present");
				return false; // If any position is 0, it's definitely not present
			}
		}
		System.out.println("Might be Present");
		return true; // All positions are 1, might be present
	}

	private int[] getHashes(String value) {
		int[] hashes = new int[3]; // For 3 hash functions
		for (int i = 0; i < 3; i++) {
			hashes[i] = Math.abs(value.hashCode() + i) % SIZE;
		}
		return hashes;
	}

	public static void main(String[] args) {
		BloomFilter bloomFilter = new BloomFilter();

		// Add email and mobile to the filter

		// Check if email and mobile are present
		bloomFilter.add("vishalshinde0804@gmail.com");

		// Check again after "deletion"
		System.out.println(bloomFilter.contains("vishalshinde0804@gmail.com")); // Should be false after deletion
	}
}
