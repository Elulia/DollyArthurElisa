package fr.iutvalence.java.s2.projet;

/**
 * Generator of password.
 * @author maximeBlo
 *
 */
public class Generator
{

	private Attribut passwordOptions;
	

	public Generator(){
		this.passwordOptions = new Attribut();	
	}

	public Generator(Attribut attribut){
		this.passwordOptions=attribut;
	}
	

	public String generatePassword(){
		
		String passwordGenerate = "";
		
		for(int numberOfCharacter = 0; numberOfCharacter < this.passwordOptions.getLength();numberOfCharacter++){
			int random = (int) (Math.random()*400);
		
			if(random < 100 && this.passwordOptions.getUseSpecialChar()){
				passwordGenerate += generateSpecialCharacter();
			} else if(random >= 100 && random < 200 && this.passwordOptions.getUseUppercase()){
				passwordGenerate += generateUppercase();
			} else if(random >= 200 && random < 300 && this.passwordOptions.getUseNumber()){
				passwordGenerate += generateInt();
			}else{
				passwordGenerate += generateChar();
			}
		}
		return passwordGenerate;
	}
	

	private static int generateInt(){
		int generateInt;
		
		generateInt = (int) (Math.random()*10);
		
		return generateInt;
	}
	

	private static char generateChar(){
		char generateChar;
		generateChar = (char)((int) (Math.random()*25)+97);
		return generateChar;
	}
	

	private static char generateUppercase(){
		char generateUppercase;
		
		generateUppercase = (char)((int) (Math.random()*25)+65);
		
		return generateUppercase;
	}
	
	private static char generateSpecialCharacter(){
		char generateSpec;
		
		generateSpec = (char)((int) (Math.random()*14)+33);
		
		return generateSpec;
	}
}
