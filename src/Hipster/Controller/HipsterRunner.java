package Hipster.Controller;

import Hipster.Controller.HipsterController;
/**
 * What runs the code.
 * @author Ben Hammond
 *1.1 11.21.13  
 */

public class HipsterRunner
{

	/**
	 * @param args
	 * The start method for the Hipster project.
	 */
	public static void main(String[] args)
	{
		HipsterController HipsterModel = new HipsterController();
		HipsterModel.start();

	}

}
