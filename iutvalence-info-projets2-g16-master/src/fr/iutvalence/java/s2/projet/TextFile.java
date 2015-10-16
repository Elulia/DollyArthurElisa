package fr.iutvalence.java.s2.projet;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Class used as a file, containing String.
 * @author MaximeBlo
 *
 */
public class TextFile {

	private String name;

	private int numberOfCharsInThisFile;
	
	private File javaBasicFile;
	
	private final Encryption encryptingKit = new Encryption();
	

	public TextFile(String name, Folder parentFolder){
		this.name = name;
		this.javaBasicFile = new File(name);
		try {
			this.javaBasicFile.createNewFile();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	

	public void renameFile(String newName){
		this.name = newName;
		this.javaBasicFile.renameTo(new File(newName));
	}


	/**
	 * Get the name of the file
	 */
	@Override
	public String toString()
	{
		return this.name;
	}
	
	
	public int getNumberOfCharsInThisFile(){
		return this.numberOfCharsInThisFile;
	}
	
	

	public String readEncryptedFile(String passphrase){
		String encryptedTextToDecryptAndReturn ="";
		FileReader filesTextContent = null;
		try {
			filesTextContent = new FileReader(this.javaBasicFile);
			while(filesTextContent.ready()){
				encryptedTextToDecryptAndReturn += (char)filesTextContent.read();
			}
			filesTextContent.close();
		} catch (FileNotFoundException e) {
			System.out.println("File not found");
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return this.encryptingKit.decrypt(encryptedTextToDecryptAndReturn, passphrase);	
	}
	
	
	public void encryptAndReWriteInTheFile(String newText, String passphrase){
		
		FileWriter textContentToChange = null;
		try {
			textContentToChange = new FileWriter(this.javaBasicFile,true);
			textContentToChange.write(this.encryptingKit.encrypt(newText, passphrase));
			textContentToChange.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	

	public void encryptAndWriteInTheFile(String textToWrite, String passphrase){
		
		FileWriter textContent = null;
		try {
			textContent = new FileWriter(this.javaBasicFile,false);
			textContent.write(this.encryptingKit.encrypt(textToWrite, passphrase));
			textContent.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	

	public void delete(){
		this.javaBasicFile.delete();
	}
	

	public File getFile(){
		return this.javaBasicFile;
	}
}
