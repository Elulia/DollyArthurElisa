package fr.iutvalence.java.s2.projet;
/**
 * Attribut.
 * @author MaximeBlo
 *
 */
public class Attribut
{
	
	public static final int ATTRIBUT_DEFAULT_LENGTH = 8;
	
	public static final boolean DESACTIVE = false;
	private int length;
	private boolean useSpecialChar;
	private boolean useUppercase;
	private boolean useNumber;
	
	
	public Attribut(){
		this.length = Attribut.ATTRIBUT_DEFAULT_LENGTH;
		this.useSpecialChar = Attribut.DESACTIVE;
		this.useUppercase = Attribut.DESACTIVE;
		this.useNumber = Attribut.DESACTIVE;
	}
	
	public Attribut(int length,boolean ifSpecialChar, boolean ifUppercase, boolean ifNumber){
		this.useSpecialChar = ifSpecialChar;
		this.useUppercase = ifUppercase;
		this.useNumber = ifNumber;
		this.length = length;
	}
	
	
	public int getLength(){
		return this.length;
	}
	

	public boolean getUseSpecialChar(){
		return this.useSpecialChar;
	}
	

	public boolean getUseUppercase(){
		return this.useUppercase;
	}
	
	public boolean getUseNumber(){
		return this.useNumber;
	}
}
