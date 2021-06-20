package it.polito.tdp.anagrammi.model;

import java.util.HashSet;
import java.util.Set;

import it.polito.tdp.anagram.db.AnagrammaDAO;

public class Model {
	
	private Set<String> anagrammi; 
	private AnagrammaDAO anagrammaDAO;
	
	public Model() {
		anagrammaDAO = new AnagrammaDAO();
	}
	
	public Set<String> anagrammi(String word) {
		anagrammi =  new HashSet<String>();
		permuta("", word);
		return anagrammi;
	}
	
	private void permuta(String parziale, String word) {
		
		if(word.length() == 0) {
			anagrammi.add(parziale);
			return;
		}
		
		
		for(int i=0;i<word.length();i++) {
			parziale += word.charAt(i);
			word = word.substring(0,i)+word.substring(i+1);
			
			permuta(parziale, word);
			
			//backtracking 
			word = parziale.charAt(parziale.length()-1) + word;
			parziale = parziale.substring(0,parziale.length()-1);
		
		}
	}
	
	public boolean isCorrect(String word) {
		return anagrammaDAO.isCorrect(word);
	}
}
