package Hipster.Model;
/**
 * Creates the Hipster object.
 * @author Ben Hammond
 *@version 1.3 11/20/13
 */
public class HipsterModel
{
	private String name;
	private String hipsterType;
	private String hipsterPhrase;
	private String [] hipsterBooks; 
	/**
	 * Defining what the Hipster object is.
	 */
	public HipsterModel()
	{
		hipsterBooks = new String[5];
		name = "Ben";
		hipsterType = "Student Hipster";
		hipsterPhrase = "Fo Realsies";
		
		fillTheBooks();
	}
	/*
	 * Making these items objects.
	 */
	public HipsterModel(String name, String hipsterType, String hipsterPhrase, String [] hipsterBooks)
	{
		this.name = name;
		this.hipsterBooks = hipsterBooks;
		this.hipsterPhrase = hipsterPhrase;
		this.hipsterType = hipsterType;
		
	}
/**
 * The return type for getName.
 * @return
 */
	public String getName()
	{
		return name;
	}
/**
 * The return type for the hipsterType.
 * @return
 */
	public String getHipsterType()
	{
		return hipsterType;
	}
/**
 * The return type for the getHipsterPhrase
 * @return
 */
	public String getHipsterPhrase()
	{
		return hipsterPhrase;
	}
/**
 * The return type for the getHipsterBooks
 * @return
 */
	public String[] getHipsterBooks()
	{
		return hipsterBooks;
	}
/**
 * The defining statement for setName.
 * @param name
 */
	public void setName(String name)
	{
		this.name = name;
	}
/**
 * The defining statement for setHipsterType.
 * @param hipsterType
 */
	public void setHipsterType(String hipsterType)
	{
		this.hipsterType = hipsterType;
	}
/**
 * The defining statement for setHipsterPhrase.
 * @param hipsterPhrase
 */
	public void setHipsterPhrase(String hipsterPhrase)
	{
		this.hipsterPhrase = hipsterPhrase;
	}
	/**
	 * The defining statement for setHipsterBooks.
	 * @param hipsterBooks
	 */
	public void setHipsterBooks(String[] hipsterBooks)
	{
		this.hipsterBooks = hipsterBooks;
	}
	/**
	 * Showing the names of books for the Hipster.
	 */
	public void fillTheBooks()
	{
		hipsterBooks[0] = "Oxford Dictionary";
		hipsterBooks[1] = "The Uglies";
		hipsterBooks[2] = " 1984";
		hipsterBooks[3] = " V for Vendetta";
		hipsterBooks[4] = "American Gods";
				
				
	}

}
