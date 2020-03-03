/*
 * @Author Art Garcia
 * Copyright (c) 3/2020
 * Project: GeneticAlgorithm
 * Last Modified: 3/2/20, 6:35 PM
 * License: GNU Lesser General Public License v3.0
 */

package DNA.Genes;

import java.util.Random;


/**
 *
 */
public class IntegerGene extends Gene<Integer>{
	
	/**
	 * Maximum value (exclusive) returned by the {@link #randomizeExpression()}
	 * method. Maximum value must be greater than 0. By default, this value is
	 * Integer.MAX_VALUE.
	 */
	private int max;
	
	/**
	 * Determines whether or not integers generated in
	 * {@link #randomizeExpression()} can be negative. The default value is
	 * false.
	 */
	private boolean allowNegatives;
	
	public IntegerGene(String name, Integer expression) {
		super(name, expression);
		max = Integer.MAX_VALUE;
		allowNegatives = false;
	}
	
	public IntegerGene(String name) {
		super(name);
		max = Integer.MAX_VALUE;
		allowNegatives = false;
	}
	
	/**
	 * @param max The new maximum value that can be returned
	 *               by {@link #randomizeExpression()}.
	 * @return returns true if the value of {@link #max} was successfully
	 * changed.
	 * @see #max
	 * @see #randomizeExpression()
	 */
	public boolean setMaximumRandom(int max) {
		if (max > 0) {
			this.max = max;
			return true;
		} else {
			return false;
		}
	}
	
	/**
	 * @param allow Determines whether or not negative values are allowed by
	 *              {@link #randomizeExpression()}.
	 * @see #allowNegatives
	 * @see #randomizeExpression()
	 */
	public void setAllowNegatives(boolean allow) {
		this.allowNegatives = allow;
	}
	
	/**
	 * Randomizes the 'expression' variable for this instance of IntegerGene
	 * the randomized value is between 0 (inclusive) and
	 * {@link #max}(exclusive).
	 * @see #setMaximumRandom(int)
	 */
	public void randomizeExpression() {
		Random r = new Random();
		int express = r.nextInt(max);
		if (allowNegatives) {
			int toNegative = r.nextInt(2);
			if (toNegative == 0) {
				this.expression = express * -1;
			} else {
				this.expression = express;
			}
		} else {
			this.expression = express;
		}
	}
}
