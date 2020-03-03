/*
 * @Author Art Garcia
 * Copyright (c) 3/2020
 * Project: GeneticAlgorithm
 * Last Modified: 3/1/20, 1:07 PM
 * License: GNU Lesser General Public License v3.0
 */

package DNA.Genes;

public abstract class Gene<T> {
	/**
	 * The name of this gene, useful for signifying its role in a phenotype.
	 */
	protected final String name;
	
	/**
	 * The expression of a Gene, or its functional value. For example, a
	 * Gene&lt;String&gt; would return a String value, and a Gene&lt;Integer&gt;
	 * would return an int value.
	 */
	protected T expression;
	
	/**
	 * @param name @see #name
	 * @param expression @see #expression
	 */
	public Gene(String name, T expression) {
		this.name = name;
		this.expression = expression;
	}
	
	/**
	 * When only given a name, a Gene will be initialized with a random
	 * expression.
	 * @param name @see #name
	 */
	public Gene(String name) {
		this.name = name;
		randomizeExpression();
	}
	
	/**
	 * @return Returns the {@link #name} of this gene.
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * @return the {@link #expression }
	 */
	public T getExpression() {
		return this.expression;
	}
	
	
	/**
	 * @return Returns the Class of this genes {@link #expression}.
	 */
	public Class getType() {
		return expression.getClass();
	}
	
	
	/**
	 * @param gene A gene of the same type as the gene on which this method is
	 *             called. This method will compare the expression of this gene
	 *             with another. Use {@link #equals(Object)} to compare two
	 *             genes with each other, excluding their expression.
	 * @return returns true if this genes expression == the expression of the
	 * gene given as a param.
	 * @see #equals(Object)
	 */
	public boolean expressionEquals(Gene<T> gene) {
		if (!this.getType().equals(gene.getType())) {
			return false;
		} else if (!this.expression.equals(gene.expression)) {
			return false;
		} else {
			return true;
		}
	}
	
	/**
	 * @param gene Any gene. Will return false if the gene given is of a
	 *             different Class.
	 * @return Returns true if the given gene's Name and Type are equal to the
	 * gene on which this method was called. A Gene's expression is not checked
	 * by this method; to check that, please see {@link #expressionEquals(Gene)}
	 * @see #expressionEquals(Gene)
	 */
	@Override
	public boolean equals(Object gene) {
		if (gene == null) {
			return false;
		} else if (!getClass().equals(gene.getClass())) {
			return false;
		}
		
		Gene compared = (Gene) gene;
		return this.name.equals(compared.name) &&
				this.getType().equals(compared.getType());
	}
	
	public abstract void randomizeExpression();
}
