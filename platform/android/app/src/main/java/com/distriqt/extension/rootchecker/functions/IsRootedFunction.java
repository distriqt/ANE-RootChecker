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
 * @created 08/11/2019
 * @copyright http://distriqt.com/copyright/license.txt
 */
package com.distriqt.extension.rootchecker.functions;

import com.adobe.fre.FREContext;
import com.adobe.fre.FREFunction;
import com.adobe.fre.FREObject;
import com.distriqt.extension.rootchecker.RootCheckerContext;
import com.distriqt.extension.rootchecker.utils.Errors;

public class IsRootedFunction implements FREFunction
{

	@Override
	public FREObject call( FREContext freContext, FREObject[] freObjects )
	{
		FREObject result = null;
		try
		{
			RootCheckerContext ctx = (RootCheckerContext) freContext;
			result = FREObject.newObject( ctx.controller().isRooted() );
		}
		catch (Exception e)
		{
			Errors.handleException( e );
		}
		return result;
	}

}
