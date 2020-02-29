/*
 * @Author Art Garcia
 * Copyright (c) 2/2020
 * Project: GeneticAlgorithm
 * Last Modified: 2/29/20, 6:36 PM
 * License: GNU Lesser General Public License v3.0
 */

package DNA;import java.util.ArrayList;
import java.util.Random;

public class Genotype extends ArrayList<Gene> {
	public Genotype() {
	}
	
	public void mutate(double pct) throws IllegalArgumentException{
		Random r = new Random();
		if (pct >= 0.0 && pct <= 1.0) {
			for (Gene i : this) {
				if (r.nextDouble() < pct) {
					i.randomize();
				}
			}
		} else {
			throw new IllegalArgumentException(
					"Percent is a value from 0.0 - 1.0");
		}
	}
}
