/**
 * 
 */
package fr.epita.java.ex;

/**
 * @author mikael
 *
 */
public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		IamLog logger = new IamLog(Main.class.getSimpleName());
		logger.debug("sample msg");
	}

}
