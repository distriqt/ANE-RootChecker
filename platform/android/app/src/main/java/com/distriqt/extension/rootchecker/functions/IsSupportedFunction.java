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
 * @brief Is Supported function implementation for this ANE
 * @author Michael Archbold (https://github.com/marchbold)
 * @created Jan 19, 2012
 * @copyright http://distriqt.com/copyright/license.txt
 *
 */
package com.distriqt.extension.rootchecker.functions;

import android.os.Build;

import com.adobe.fre.FREContext;
import com.adobe.fre.FREFunction;
import com.adobe.fre.FREObject;
import com.distriqt.extension.rootchecker.utils.Errors;

public class IsSupportedFunction implements FREFunction
{

	@Override
	public FREObject call( FREContext context, FREObject[] args )
	{
		FREObject result = null;
		try
		{
			boolean isSupported = false;
			if (Build.VERSION.SDK_INT >= 14)
			{
				isSupported = true;
			}
			result = FREObject.newObject( isSupported );
		}
		catch (Exception e)
		{
			Errors.handleException( context, e );
		}
		return result;
	}

}
