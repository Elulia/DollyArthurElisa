package fr.iutvalence.java.s2.projet;

import java.util.ArrayList;

/**
 * Class folder used to contain one or many files.
 * @author MaximeBlo
 *
 */
public class Folder {
	

	private String foldersName;

	private int numberOfFileInTheFolder;

	private ArrayList<TextFile> listeOfFile;
	
	public Folder(String foldersName){
		this.foldersName = foldersName;
		this.numberOfFileInTheFolder = 0;
		this.listeOfFile = new ArrayList<TextFile>();
	}
	
	public void addFileToTheFolder(TextFile fileToAdd){
		this.listeOfFile.add(fileToAdd);
		this.numberOfFileInTheFolder++;
	}

	public void deleteFileFromTheFolder(TextFile fileToDelete){
		int fileNumber = 0;
		
		while(!(fileToDelete.equals(this.listeOfFile.get(fileNumber)))){
			fileNumber++;
		}
		
		this.listeOfFile.get(fileNumber).delete();
		this.listeOfFile.remove(fileNumber);
		this.numberOfFileInTheFolder--;
	}
	
	public void renameFolder(String newName){
		this.foldersName = newName;
	}
	
	public int getNumberOfFile(){
		return this.numberOfFileInTheFolder;
	}
	
	public ArrayList<TextFile> getFile(){
		return this.listeOfFile;
	}
	
	public TextFile getFile(String fileName){
		TextFile fileFound = null;
		
		for(int numberOfFile = 0; numberOfFile < this.numberOfFileInTheFolder;numberOfFile++){
			if(this.listeOfFile.get(numberOfFile).toString().equals(fileName)){
				fileFound = this.listeOfFile.get(numberOfFile);
			}
		}
		
		return fileFound;
	}

	
	/**
	* Return the name of the folder.
	* @return name The name of the folder
	*/
	public String getName()
	{
		return this.foldersName;
	}
	
	
}
