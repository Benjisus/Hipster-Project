package Hipster.View;

import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.net.URL;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SpringLayout;

import Hipster.Controller.HipsterController;
import Hipster.Model.HipsterModel;

/**
 * Creates the panel of the GUI. What you see in it.
 * 
 * @author Ben Hammond 1.2 11/21/13
 */
public class HipsterPanel extends JPanel
{
	private JButton addHipsterButton;
	private JButton showRandomButton;
	private JButton showSpecificButton;
	private JButton showSelfButton;
	private JLabel nameLabel;
	private JLabel phraseLabel;
	private JLabel typeLabel;
	private JLabel booksLabel;
	private JComboBox selectedHipsterComboBox;
	private JTextField nameField;
	private JTextField phraseField;
	private JTextField typeField;
	private JTextArea booksArea;
	private PicturePanel picturePanel;
	private URL imageURL;
	private SpringLayout baseLayout;
	private String[] baseArray;

	private HipsterController baseController;

	public HipsterPanel(HipsterController baseController)
	{
		this.baseController = baseController;

		addHipsterButton = new JButton("Add a Hipster");
		showRandomButton = new JButton("Show a random Hipster");
		showSpecificButton = new JButton("Show a certain Hipster");
		showSelfButton = new JButton("Show the Original Hipster");
		nameField = new JTextField(25);
		phraseField = new JTextField(25);
		typeField = new JTextField(25);
		nameLabel = new JLabel("Hipster Name:");
		booksLabel = new JLabel("Hipster's Books:");
		phraseLabel = new JLabel("Hipster's Phrase");
		typeLabel = new JLabel("Hipster's Type");
		booksArea = new JTextArea(5, 25);
		baseArray = new String[3];

		imageURL = getClass().getResource("/Hipster/View/images/Hipster Image.jpg");
		picturePanel = new PicturePanel(imageURL, 150, 150);

		baseLayout = new SpringLayout();
		

		setupComboBox();
		setupPanel();
		setupLayout();
		setupListeners();

	}

	private String[] getNamesForComboBox()
	{
		int realValues = 0;
		for (int count = 0; count < baseController.getClassHipsters().length; count++)
		{
			if (baseController.getClassHipsters()[count] != null)
			{
				realValues++;
			}
		}

		String[] tempNames = new String[realValues];
		for (int realSize = 0; realSize < realValues; realSize++)
		{
			tempNames[realSize] = baseController.getClassHipsters()[realSize].getName();
		}
		return tempNames;
	}

	private void updateHipsterComboBox()
	{
		String[] comboValues = getNamesForComboBox();
		selectedHipsterComboBox.setModel(new DefaultComboBoxModel(comboValues));
	}

	private void setupComboBox()
	{
		baseArray[0] = "Me";
		baseArray[1] = "Myself";
		baseArray[2] = "I";

		selectedHipsterComboBox = new JComboBox(baseArray);

	}

	/**
	 * Populates the fields based on the current Hipster object.
	 * 
	 * @param currentHipster
	 *            The current specified Hipster.
	 */
	private void populateFields(HipsterModel currentHipster)
	{
		nameField.setText(currentHipster.getName());
		typeField.setText(currentHipster.getHipsterType());
		phraseField.setText(currentHipster.getHipsterPhrase());
		booksArea.setText("");
		for (String temp : currentHipster.getHipsterBooks())
		{
			booksArea.append(temp + ", ");
		}
	}

	private void blankFields(boolean poorInput)
	{
		nameField.setText("");
		typeField.setText("");
		phraseField.setText("");
		booksArea.setText("");
		if (poorInput)
		{
			JOptionPane.showMessageDialog(this, "Please use valid options");
		}
	}

	/**
	 * Send information to the HipsterController.
	 */

	private void sendHipsterInfoToController()
	{
		String[] books = booksArea.getText().split("' ");
		baseController.addHipster(books, nameField.getText(),typeField.getText(), phraseField.getText());
		JOptionPane.showMessageDialog(this, "Hipster " + nameField.getText()+ "added to the array");
	}

	/**
	 * Creates the setup for the panel.
	 */
	private void setupPanel()
	{
		this.setLayout(baseLayout);
		this.add(addHipsterButton);
		this.add(showRandomButton);
		this.add(showSpecificButton);
		this.add(showSelfButton);
		this.add(nameLabel);
		this.add(phraseLabel);
		this.add(typeLabel);
		this.add(booksLabel);
		this.add(nameField);
		this.add(typeField);
		this.add(phraseField);
		this.add(booksArea);
		this.add(picturePanel);
		this.add(selectedHipsterComboBox);

		this.setBackground(new Color(130, 100, 50));
		this.setSize(418, 477);
		booksArea.setWrapStyleWord(true);
		booksArea.setLineWrap(true);

	}

	/*
	 * Sets up where all the buttons,frames, and so on are placed on the pop up.
	 */

	 private void setupLayout()
	    {
	        baseLayout.putConstraint(SpringLayout.NORTH, showSelfButton, 65, SpringLayout.SOUTH, showRandomButton);
	        baseLayout.putConstraint(SpringLayout.WEST, showSelfButton, 0, SpringLayout.WEST, nameLabel);
	        baseLayout.putConstraint(SpringLayout.WEST, showRandomButton, 0, SpringLayout.WEST, nameLabel);
	        baseLayout.putConstraint(SpringLayout.NORTH, addHipsterButton, 22, SpringLayout.SOUTH, booksArea);
	        baseLayout.putConstraint(SpringLayout.WEST, addHipsterButton, 0, SpringLayout.WEST, nameLabel);
	        baseLayout.putConstraint(SpringLayout.NORTH, selectedHipsterComboBox, 18, SpringLayout.SOUTH, showRandomButton);
	        baseLayout.putConstraint(SpringLayout.WEST, selectedHipsterComboBox, 0, SpringLayout.WEST, addHipsterButton);
	        baseLayout.putConstraint(SpringLayout.NORTH, booksLabel, 0, SpringLayout.NORTH, booksArea);
	        baseLayout.putConstraint(SpringLayout.WEST, booksLabel, 0, SpringLayout.WEST, nameLabel);
	        baseLayout.putConstraint(SpringLayout.NORTH, nameField, 22, SpringLayout.NORTH, this);
	        baseLayout.putConstraint(SpringLayout.NORTH, nameLabel, 6, SpringLayout.NORTH, nameField);
	        baseLayout.putConstraint(SpringLayout.WEST, nameLabel, 0, SpringLayout.WEST, phraseLabel);
	        baseLayout.putConstraint(SpringLayout.NORTH, typeLabel, 6, SpringLayout.NORTH, typeField);
	        baseLayout.putConstraint(SpringLayout.WEST, typeLabel, 0, SpringLayout.WEST, phraseLabel);
	        baseLayout.putConstraint(SpringLayout.NORTH, phraseLabel, 6, SpringLayout.NORTH, phraseField);
	        baseLayout.putConstraint(SpringLayout.WEST, phraseLabel, 10, SpringLayout.WEST, this);
	        baseLayout.putConstraint(SpringLayout.NORTH, booksArea, 18, SpringLayout.SOUTH, phraseField);
	        baseLayout.putConstraint(SpringLayout.WEST, booksArea, 0, SpringLayout.WEST, nameField);
	        baseLayout.putConstraint(SpringLayout.NORTH, phraseField, 17, SpringLayout.SOUTH, typeField);
	        baseLayout.putConstraint(SpringLayout.NORTH, typeField, 11, SpringLayout.SOUTH, nameField);
	        baseLayout.putConstraint(SpringLayout.WEST, typeField, 0, SpringLayout.WEST, nameField);
	        baseLayout.putConstraint(SpringLayout.WEST, phraseField, 0, SpringLayout.WEST, nameField);
	        baseLayout.putConstraint(SpringLayout.WEST, nameField, 175, SpringLayout.WEST, this);
	        baseLayout.putConstraint(SpringLayout.NORTH, picturePanel, -220, SpringLayout.SOUTH, this);
	        baseLayout.putConstraint(SpringLayout.WEST, picturePanel, -200, SpringLayout.EAST, this);
	        baseLayout.putConstraint(SpringLayout.SOUTH, picturePanel, -20, SpringLayout.SOUTH, this);
	        baseLayout.putConstraint(SpringLayout.EAST, picturePanel, -20, SpringLayout.EAST, this);
	        baseLayout.putConstraint(SpringLayout.NORTH, showRandomButton, 18, SpringLayout.SOUTH, addHipsterButton);
	        baseLayout.putConstraint(SpringLayout.NORTH, showSpecificButton, 23, SpringLayout.SOUTH, showSelfButton);
			baseLayout.putConstraint(SpringLayout.WEST, showSpecificButton, 0, SpringLayout.WEST, addHipsterButton);
			baseLayout.putConstraint(SpringLayout.WEST, picturePanel, 115,SpringLayout.EAST, showSelfButton);
	    }

	/**
	 * Helper method for creating all the needed listeners for the GUI.
	 */
	private void setupListeners()
	{
		addHipsterButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent click)
			{
				sendHipsterInfoToController();
				updateHipsterComboBox();
				blankFields(false);
			}
		});
		showSelfButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent click)
			{
				HipsterModel selfHipster = baseController.getSelfHipster();
				populateFields(selfHipster);
			}
		});
		showSpecificButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent click)
			{
				HipsterModel selectedHipster = baseController
						.getSpecifiedHipster(0);
				if (selectedHipster != null)
				{
					populateFields(selectedHipster);
				}
				else
				{
					blankFields(true);
				}
			}
		});
		showRandomButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent click)
			{
				HipsterModel randomHipster = baseController.getRandomHipster();
				if (randomHipster != null)
				{
					populateFields(randomHipster);
				}
				else
				{
					blankFields(true);
				}
			}
		});
		selectedHipsterComboBox.addItemListener(new ItemListener()
		{
			@Override
			public void itemStateChanged(ItemEvent itemSelected)
			{
				int currentSelection = selectedHipsterComboBox
						.getSelectedIndex();
				if (currentSelection >= 0)
				{
					HipsterModel selectedHipster = baseController
							.getSpecifiedHipster(currentSelection);
					if (selectedHipster != null)
					{
						populateFields(selectedHipster);
					}
					else
					{
						blankFields(true);
					}
				}
			}
		});

	}

}
