/*
 * Title:        CloudSim Toolkit
 * Descripimport java.util.Random;
mulation) Toolkit for Modeling and Simulation of Clouds
 * Licence:      GPL - http://www.gnu.org/copyleft/gpl.html
 *
 * 
 */

package org.cloudbus.cloudsim.distributions;

import java.util.Random;

/**
 * The Class WeibullDistr.
 * 
 * @author Marcos Dias de Assuncao
 * @since CloudSim Toolkit 1.0
 */
public class WeibullDistr implements ContinuousDistribution {

	/** The num gen. */
	private final Random numGen;

	/** The alpha. */
	private final double alpha;

	/** The beta. */
	private final double beta;

	/**
	 * Instantiates a new weibull distr.
	 * 
	 * @param seed the seed
	 * @param alpha the alpha
	 * @param beta the beta
	 */
	public WeibullDistr(Random seed, double alpha, double beta) {
		if (alpha <= 0.0 || beta <= 0.0) {
			throw new IllegalArgumentException("Alpha and beta must be greater than 0.0");
		}

		numGen = seed;
		this.alpha = alpha;
		this.beta = beta;
	}

	/**
	 * Instantiates a new weibull distr.
	 * 
	 * @param alpha the alpha
	 * @param beta the beta
	 */
	public WeibullDistr(double alpha, double beta) {
		if (alpha <= 0.0 || beta <= 0.0) {
			throw new IllegalArgumentException("Alpha and beta must be greater than 0.0");
		}

		numGen = new Random(System.currentTimeMillis());
		this.alpha = alpha;
		this.beta = beta;
	}

	/*
	 * (non-Javadoc)
	 * @see cloudsim.distributions.ContinuousDistribution#sample()
	 */
	@Override
	public double sample() {
		return beta * Math.pow(-Math.log(numGen.nextDouble()), 1 / alpha);
	}

}
