package Hipster.View;

import javax.swing.JFrame;
/** Creates a JFrame for the project
 * @author Ben Hammond
 * @version 1.1 11/20/13
 */

import Hipster.Controller.HipsterController;

public class HipsterFrame extends JFrame
{
	
		private HipsterController baseController;
		private HipsterPanel basePanel;
		
		
		public HipsterFrame(HipsterController baseController)
		{
			this.baseController = baseController;
			basePanel = new HipsterPanel(baseController);
			
			setupFrame();
			
		}
		
		
		/**
		 * Sets the frame size for the GUI.
		 */
		private void setupFrame()
		{
			this.setContentPane(basePanel);
			this.setSize(500,500);
			this.setVisible(true);
			
		}
}
