/*
 * @Author Art Garcia
 * Copyright (c) 3/2020
 * Project: GeneticAlgorithm
 * Last Modified: 3/2/20, 7:01 PM
 * License: GNU Lesser General Public License v3.0
 */

package DNA.Genes;

import java.util.Random;

public class CharacterGene extends Gene<Character>{

	private boolean allowLowercase, allowUppercase, allowDigits,
			allowSymbols, allowSpace;
	public CharacterGene(String name, Character expression) {
		super(name, expression);
		allowDigits = true;
		allowLowercase = true;
		allowUppercase = true;
		allowSymbols = true;
		allowSpace = true;
	}
	
	public CharacterGene(String name) {
		super(name);
		allowDigits = true;
		allowLowercase = true;
		allowUppercase = true;
		allowSymbols = true;
		allowSpace = true;
	}
	
	/**
	 * @param allow determines if digits (0-9) are included in
	 * {@link #randomizeExpression()}.
	 */
	public void allowDigits(boolean allow) {
		this.allowDigits = allow;
	}
	/**
	 * @param allow determines if lowercase letters are included in
	 * {@link #randomizeExpression()}.
	 */
	public void allowLowercase(boolean allow) {
		this.allowLowercase = allow;
	}
	/**
	 * @param allow determines if uppercase letters are included in
	 * {@link #randomizeExpression()}.
	 */
	public void allowUppercase(boolean allow) {
		this.allowUppercase = allow;
	}
	/**
	 * @param allow determines if symbols (except the ' ' space character)
	 * are included in  {@link #randomizeExpression()}.
	 */
	public void allowSymbols(boolean allow) {
		this.allowSymbols = allow;
	}
	/**
	 * @param allow determines the ' ' space character is included in
	 * {@link #randomizeExpression()}.
	 */
	public void allowSpace(boolean allow) {
		this.allowSpace = allow;
	}
	
	/**
	 * Randomizes the {@link Gene#expression} as a random character, given the
	 * constraints of  {@link #allowDigits},
	 * {@link #allowLowercase}, {@link #allowUppercase}, {@link #allowSymbols},
	 * and {@link #allowSpace}. If none of the constraints are set to'true',
	 * this method sets the expression as null.
	 */
	public void randomizeExpression() {
		
		if (! allowSpace && ! allowDigits && ! allowLowercase &&
				! allowUppercase && ! allowSymbols) {
			expression = null;
			return;
		}
		
		int c;
		Random r = new Random();
		while (true) {
			c = r.nextInt(95) + 32;
			
			// Checks validity
			if (! allowSpace && c <= 32) { // space: 32
				continue;
			} else if (! allowDigits && (c >= 48 && c <= 57)) { // digits: 48-57
				continue;
			} else if (! allowLowercase && (c >= 97 && c <= 122)) {// lowercase: 97-122
				continue;
			} else if (! allowUppercase && (c >= 65 && c <= 90)) { // uppercase: 65-90
				continue;
			} else if (! allowSymbols && ( // symbols: 33-47, 58-64, 91-96, 123-126
					(c >= 33 && c <= 47) ||
					(c >= 58 && c <= 64) ||
					(c >= 91 && c <= 96) ||
					(c >= 123 && c <= 126))) {
				continue;
			}
			
			break;
		}
		
		expression = (char) c;
	}
}
