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
 * @brief
 * @author Michael Archbold (https://github.com/marchbold)
 * @created 13/04/2017
 * @copyright http://distriqt.com/copyright/license.txt
 */
package com.distriqt.extension.rootchecker.utils;

import com.adobe.fre.FREContext;
import com.distriqt.core.utils.FREUtils;
import com.distriqt.extension.rootchecker.RootCheckerExtension;

public class Errors
{


	public static void handleException( FREContext context, Throwable e )
	{
		FREUtils.handleException( context, e );
	}


	public static void handleException( Throwable e )
	{
		FREUtils.handleException( RootCheckerExtension.context, e );
	}


}
