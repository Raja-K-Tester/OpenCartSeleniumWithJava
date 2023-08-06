package resources;

//import org.apache.commons.lang3.RandomStringUtils;

import net.datafaker.Faker;

public class RandomGenerator {

		static Faker randomdata=new Faker();


	    public String randomFirstName()
	    {
	    	return randomdata.name().firstName();
	    }

	    public String randomLastName()
	    {
	    	return randomdata.name().lastName();
	    }

	    public static String randomEmail()
	    {
	    	return randomdata.internet().emailAddress();

	    }

	    public String randomNumber()
	    {
	        return randomdata.phoneNumber().cellPhone();
	    	//String generatedString = RandomStringUtils.randomNumeric(10);
	        //return generatedString;

	    }

	    public static String randomPassword()
	    {
	    	return randomdata.internet().password(4, 20);


	    }
}
