package com.extra;

import java.io.File;
import java.io.IOException;

//Create Folder , Check if Exist , Rename Folder , Delete Folder
public class FileFolderHandling {

	public static void main(String[] args) {
		try {
			String newFolderPath = "src/main/resources/demoFolder";
			String folderPath = "src/main/resources/demoFolder1";
			// createFolder(folderPath);
			// renameFolder(folderPath, newFolderPath);
			// deleteFolder(newFolderPath);
			// deleteFolder(folderPath);
		} catch (Exception e) {

		}
	}

	public static boolean isFolderPresent(File folderName) {
		return folderName.exists();
	}

	/*
	 * Step 1: Simply crate object of File by passing filePath to it Step 2: Simply
	 * Check is folder already present or not by using object.exists() Step 3: If
	 * folder not exists() then simply create folder with mkdir() Step 4: With
	 * mkdir() you can simply create only one directory (final directory) Step 5: If
	 * you want to create folder inside folder then you can use method mkdirs()
	 */
	public static void createFolder(String filePath) throws IOException {
		File folder = new File(filePath);
		if (!isFolderPresent(folder)) {
			boolean folderCreationStatus = folder.mkdir();
			if (folderCreationStatus) {
				System.out.println("Folder Created Sucessfully...");
			} else {
				System.out.println("Folder not created due to some error...");
			}
		} else {
			System.out.println("Folder Already Present...");
		}

	}

	/*
	 * Step 1: To rename folder simply need to create object with both paths Step 2:
	 * If Previous Folder present then simply use renameTo(newPathFolder)
	 */
	public static void renameFolder(String previousPath, String newPath) throws IOException {
		File oldFolder = new File(previousPath);
		File newFolder = new File(newPath);

		if (isFolderPresent(oldFolder)) {
			boolean b = oldFolder.renameTo(newFolder);
			if (b) {
				System.out.println("Folder Renamed Sucessfully...");
			} else {
				System.out.println("Folder Not Renamed Due to error");
			}

		} else {
			System.out.println("Folder Not Present...");
		}
	}

	/*
	 * Step 1: Create File with filePath Step 2: To delete Folder simply first
	 * delete fileList Step 3: Then delete folder
	 */
	public static void deleteFolder(String filePath) throws Exception {
		File file = new File(filePath);
		if (isFolderPresent(file)) {
			for (File files : file.listFiles()) {
				files.delete();
			}
			file.delete();
			System.out.println("Folder Deleted Sucessfully...");
		} else {
			System.out.println("Folder not present already...");
		}
	}

	public static void createFile(String filePath) throws Exception {
		File file = new File(filePath);

	}
}
