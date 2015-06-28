package com.centric.dqm;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import com.centric.dqm.data.DataUtils;
import com.centric.dqm.testing.Harness;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

public class Application {
	
	public static final Logger logger = LogManager.getLogger();
	
	public static void main(String[] args) throws Exception
	{
		
    	/*
    	 * -c "{Configuration File Path (String)}"
    	 * -t "{Tag (String)}"
    	 * -s "{Scenario Identifier (String)}" 
    	 */

		// #################################################
        logger.info("Entering application.");       
		
        // #################################################
        logger.info("Interpreting command line parameters."); 
    	
    	String tags = null;
    	String scenarioIdentifiers = null;
        
    	try
    	{
	    	
	    	for (int n = 0; n < args.length; n++)
	    	{
	    		
	    		if(args[n].equals("-t"))
	    		{
	    			tags = args[n+1];
	    			n++;  // advance the arg counter    			
	    			
	    		} else if(args[n].equals("-s"))
	    		{
	    			scenarioIdentifiers = args[n+1];
	    			n++;  // advance the arg counter    		    	
	    		}    		    		
	    	}
	    	
    	} catch (Exception e)
    	{
    		logger.error("Encountered exception.", e);
    		throw e;
    	} 
    	
    	logger.info("Tags: " + ((tags.length()==0) ? "(not specified)" : tags));
    	logger.info("Scenarios: " + ((scenarioIdentifiers.length()==0) ? "(not specified)" : scenarioIdentifiers));
    	
    	// #################################################
    	logger.info("Establishing management database.");    	
    	Configuration config = null;
    	
    	try
    	{
    		config = new Configuration();
    		
    	} catch(Exception e)
    	{
    		logger.error("Encountered exception.", e);

    		throw e;
    	}
    	
    	// #################################################
    	logger.info("Initiating testing harness.");    	
    	Harness harness = null;
    	
    	try
    	{

        	harness = new Harness();
        	
        	harness.ScenarioFilterList = DataUtils.getListFromString(scenarioIdentifiers);
        	harness.TagList = DataUtils.getListFromString(tags);
    				    	
        	config.Connection.readHarness(harness);
    		
    	} catch(Exception e)
    	{
    		logger.error("Encountered exception.", e);
    		throw e;
    	}
    	

    	// #################################################
    	logger.info("Performing tests.");    	
    	try
    	{

    		harness.perfomTests();
    		
    	} catch(Exception e)
    	{
    		logger.error("Encountered exception.", e);
    		throw e;
    	}
    	
    	// #################################################
    	logger.info("Writing test results.");    	
    	try
    	{

    		config.Connection.writeHarness(harness);
    		
    	} catch(Exception e)
    	{
    		logger.error("Encountered exception.", e);
    		throw e;
    	}    	

    	
    	// #################################################
    	logger.info("Exiting application.");
    	
    	
	}
	
	public static String getJarPath() throws UnsupportedEncodingException
	{
		String path = Application.class.getProtectionDomain().getCodeSource().getLocation().getPath();
		String decodedPath = URLDecoder.decode(path, "UTF-8");
		
		return decodedPath;
	}
	    
}
