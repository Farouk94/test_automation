package Configuration;


import org.openqa.selenium.By;
/*
 * Contient les différents Xpath utilisé
 */
public class Xpath_Conf {
	
//Button Xpath for Android 
	/*
	 * Faire attention les Xpath peuvent changer en changeant de version de l'application .
	 * 
	 */

	public static final String tse_username="//android.widget.EditText[@resource-id='air.TSEssentialFlex:id/login' and @index='0' and @text='Identifiant (nom.prenom)']";
	
	public static final String tse_logIn="//android.widget.Button[@resource-id='air.TSEssentialFlex:id/sign_in_button' and @index='1' and @text='Connexion']";
	
	
}
