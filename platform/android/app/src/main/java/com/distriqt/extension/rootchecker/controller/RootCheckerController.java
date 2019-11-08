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
 * @author 		"Michael Archbold (ma&#64;distriqt.com)"
 * @created 16/11/2017
 * @copyright http://distriqt.com/copyright/license.txt
 */
package com.distriqt.extension.rootchecker.controller;

import com.distriqt.core.ActivityStateListener;
import com.distriqt.core.utils.IExtensionContext;
import com.distriqt.extension.rootchecker.utils.Errors;
import com.scottyab.rootbeer.RootBeer;

public class RootCheckerController extends ActivityStateListener
{
	////////////////////////////////////////////////////////////
	//	CONSTANTS
	//

	public static final String TAG = RootCheckerController.class.getSimpleName();


	////////////////////////////////////////////////////////////
	//	VARIABLES
	//


	private IExtensionContext _extContext;


	////////////////////////////////////////////////////////////
	//	FUNCTIONALITY
	//

	public RootCheckerController( IExtensionContext extensionContext )
	{
		_extContext = extensionContext;
	}


	public void dispose()
	{

	}



	public boolean isRooted()
	{
		try
		{
			RootBeer rb = new RootBeer( _extContext.getActivity() );
			return rb.isRooted();
		}
		catch (Exception e)
		{
			Errors.handleException( e );
		}
		return false;
	}



}
