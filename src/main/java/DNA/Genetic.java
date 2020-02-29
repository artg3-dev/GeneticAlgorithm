/*
 * @Author Art Garcia
 * Copyright (c) 2/2020
 * Project: GeneticAlgorithm
 * Last Modified: 2/29/20, 6:40 PM
 * License: GNU Lesser General Public License v3.0
 */

package DNA;

public interface Genetic<T> {
	Genotype getGenotype();
	Genetic<T> crossover(T t);
}
