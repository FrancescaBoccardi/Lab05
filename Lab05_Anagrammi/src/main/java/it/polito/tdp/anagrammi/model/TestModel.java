package it.polito.tdp.anagrammi.model;

import java.util.Set;

public class TestModel {

	public static void main(String[] args) {
		
		Model m = new Model();
		Set<String> anagrammi = m.anagrammi("si");
		
		System.out.println(anagrammi.toString());
	}

}
