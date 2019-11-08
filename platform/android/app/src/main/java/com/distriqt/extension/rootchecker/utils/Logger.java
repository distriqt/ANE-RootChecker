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
 * @author marchbold
 * @created 13/04/2017
 * @copyright http://distriqt.com/copyright/license.txt
 */
package com.distriqt.extension.rootchecker.utils;

import com.distriqt.core.utils.LogUtil;
import com.distriqt.extension.rootchecker.RootCheckerExtension;

public class Logger
{

	public static void d( String TAG, String message, Object... args )
	{
		LogUtil.d(
				RootCheckerExtension.ID,
				TAG,
				message,
				args );
	}


	public static void i( String TAG, String message, Object... args )
	{
		LogUtil.i(
				RootCheckerExtension.ID,
				TAG,
				message,
				args );
	}


}
