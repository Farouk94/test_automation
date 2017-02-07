package Configuration;




import org.apache.log4j.Logger;
/*
 * Class Conf contient les différente variable static
 */
public class Conf {


	public static final int appiumport = 4724;
	//verison fb 
	public static final String androidapk = "C:\\Users\\farou_000\\Desktop\\TSEssential Agenda TSE_v2.0.6_apkpure.com.apk";

	//Fb
	public static final String tse_login = "ennia.farouk";
	
	//Process

	public static TestExec exec;
	public static final Logger logger = Logger.getLogger(Automation.class.getName());
	public static Automation auto = new Automation(Conf.appiumport);
	

}
