/**
 *        __       __               __ 
 *   ____/ /_ ____/ /______ _ ___  / /_
 *  / __  / / ___/ __/ ___/ / __ `/ __/
 * / /_/ / (__  ) / / /  / / /_/ / / 
 * \__,_/_/____/_/ /_/  /_/\__, /_/ 
 *                           / / 
 *                           \/ 
 * http://distriqt.com
 *
 * @brief  		Main Extension implementation for this ANE
 * @author 		Michael Archbold
 * @created		Jan 19, 2012
 * @copyright	http://distriqt.com/copyright/license.txt
 *
 */
package com.distriqt.extension.rootchecker;

import com.adobe.fre.FREContext;
import com.adobe.fre.FREExtension;

public class RootCheckerExtension implements FREExtension
{
	public static RootCheckerContext context;
	
	public static String ID	= "com.distriqt.RootChecker";
	
	
	@Override
	public FREContext createContext(String arg0) 
	{
		context = new RootCheckerContext();
		return context;
	}

	
	@Override
	public void dispose() 
	{
		context = null;
	}

	
	@Override
	public void initialize() 
	{
	}

}
