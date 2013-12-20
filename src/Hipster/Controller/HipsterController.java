package Hipster.Controller;


import javax.swing.JOptionPane;


import Hipster.Model.HipsterModel;
import Hipster.View.HipsterFrame;
import Hipster.View.HipsterFrame;
/**
 * Controller for the Hipsters project.
 * @author Ben Hammond
 * 1.2 11/20/13 Added constructor information. Added methods for retrieval of Hipsters and documentation.
 */
public class HipsterController
{
	/**
	 * Hipster object representing me.
	 */
	private  HipsterModel selfHipster;
	/**
	 * The Hipster Frame reference for MVC.
	 */
	private HipsterFrame appFrame;
	/**
	 * The array of Hipsters for the class.
	 */
	private HipsterModel [] classHipsters;
	/**
	 * The current Hipster in the Array list.
	 */
	private int hipsterCount;
	
	
	/**
	 * Creates a HipsterController to be used as part of the MVC paradigm.
	 */
	public HipsterController()
	{
		
		selfHipster = new HipsterModel();
		classHipsters = new HipsterModel [5];
		hipsterCount = 0;
		
	}
	public HipsterModel[] getClassHipsters()
	{
		return classHipsters;
	}
	/**
	 * Getter method for the Hipster representing myself.
	 * @return
	 */
	public HipsterModel getSelfHipster()
	{
		return selfHipster;
	}
/**
 * Replacing the current Hipster.
 * @param selfHipster
 */
	public void setSelfHipster(HipsterModel selfHipster)
	{
		this.selfHipster = selfHipster;
	}
/**
 * Start method for the GUI application of the Hipster Program.
 */
	public void start()
	{
		appFrame = new HipsterFrame(this);
		
	}
	/**
	 * Retrieves the Hipster from the specified position in the array.
	 * @param position
	 * @return
	 */
	public HipsterModel getSpecifiedHipster(int position)
	{
		HipsterModel currentHipster = null;
		
		if(position < classHipsters.length && position >= 0)
		{
			currentHipster = classHipsters[position];
		}
		
		return currentHipster;
	}
	/**
	 * Used to retrieve a random Hipster object from the array of class Hipsters.
	 * @return
	 */
	public HipsterModel getRandomHipster()
	{
		HipsterModel currentHipster = null;
		int randomIndex = 0;
		double random = Math.random();
		randomIndex = (int) random*classHipsters.length;
		currentHipster = classHipsters[randomIndex];
		
		return currentHipster;
	}
	/**
	 * Creates and adds a Hipster to the array of class Hipsters from the specified values.
	 * @param books The array of books for the current Hipster.
	 * @param name The name of the current Hipster.
	 * @param type The type of the current Hipster.
	 * @param phrase This Hipsters current phrase of Hipsterness.
	 */
	public void addHipster(String [] books, String name, String type, String phrase)
	{
		if(hipsterCount < classHipsters.length)
		{
			HipsterModel tempHipster = new HipsterModel(name, type, phrase, books);
			classHipsters[hipsterCount] = tempHipster;
			hipsterCount++;
		}
		else
		{
			JOptionPane.showMessageDialog(appFrame, "The class is full... You are not hip enough to join.");
		}
		
	}

	
}
