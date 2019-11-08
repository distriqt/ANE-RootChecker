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
 * @brief  		Main Context for an ActionScript Native Extension
 * @author 		Michael Archbold
 * @created		Jan 19, 2012
 * @copyright	http://distriqt.com/copyright/license.txt
 *
 */
package com.distriqt.extension.rootchecker;

import android.content.Intent;
import android.content.res.Configuration;

import com.adobe.air.ActivityResultCallback;
import com.adobe.air.AndroidActivityWrapper;
import com.adobe.air.StateChangeCallback;
import com.adobe.fre.FREContext;
import com.adobe.fre.FREFunction;
import com.distriqt.core.utils.IExtensionContext;
import com.distriqt.extension.rootchecker.controller.RootCheckerController;
import com.distriqt.extension.rootchecker.functions.ImplementationFunction;
import com.distriqt.extension.rootchecker.functions.IsRootedFunction;
import com.distriqt.extension.rootchecker.functions.IsSupportedFunction;
import com.distriqt.extension.rootchecker.functions.VersionFunction;

import java.util.HashMap;
import java.util.Map;

public class RootCheckerContext extends FREContext implements IExtensionContext, ActivityResultCallback, StateChangeCallback
{
	public static final String TAG = RootCheckerContext.class.getSimpleName();
	public static final String VERSION = "1.0";
	public static final String IMPLEMENTATION = "Android";


	////////////////////////////////////////////////////////////
	//	VARIABLES
	//

	private AndroidActivityWrapper _aaw;

	private RootCheckerController _controller = null;



	////////////////////////////////////////////////////////////
	//	FUNCTIONALITY
	//

	public RootCheckerContext()
	{
		_aaw = AndroidActivityWrapper.GetAndroidActivityWrapper();
		_aaw.addActivityResultListener( this );
		_aaw.addActivityStateChangeListner( this );
	}


	@Override
	public void dispose() 
	{
		if (_aaw != null)
		{
			_aaw.removeActivityResultListener( this );
			_aaw.removeActivityStateChangeListner( this );
			_aaw = null;
		}
		if (_controller != null)
		{
			_controller.dispose();
			_controller = null;
		}
	}

	
	@Override
	public Map<String, FREFunction> getFunctions() 
	{
		Map<String, FREFunction> functionMap = new HashMap<String, FREFunction>();
		
		functionMap.put( "isSupported", 	new IsSupportedFunction() );
		functionMap.put( "version",   		new VersionFunction() );
		functionMap.put( "implementation", 	new ImplementationFunction() );

		functionMap.put( "isRooted", 		new IsRootedFunction() );

		return functionMap;
	}



	//
	//	CONTROLLER
	//

	public RootCheckerController controller()
	{
		if (_controller == null)
		{
			_controller = new RootCheckerController( this );
		}
		return _controller;
	}


	//
	//	ActivityResultCallback
	//

	@Override
	public void onActivityResult( int requestCode, int resultCode, Intent intent )
	{
		if (_controller != null)
		{
			_controller.onActivityResult( requestCode, resultCode, intent );
		}
	}


	//
	//	StateChangeCallback
	//

	@Override
	public void onActivityStateChanged( AndroidActivityWrapper.ActivityState state )
	{
		if (_controller != null)
		{
			switch (state)
			{
				case STARTED:
					_controller.onStart();
					break;

				case STOPPED:
					_controller.onStop();
					break;

				case PAUSED:
					_controller.onPause();
					break;

				case RESTARTED:
					_controller.onRestart();
					break;

				case DESTROYED:
					_controller.onDestroy();
					break;

				case RESUMED:
					_controller.onResume();
					break;
			}
		}
	}


	@Override
	public void onConfigurationChanged( Configuration paramConfiguration )
	{
		_controller.onConfigurationChanged( paramConfiguration );
	}


	//
	//	IExtensionContext
	//

	@Override
	public void dispatchEvent( final String code, final String data )
	{
		try
		{
			dispatchStatusEventAsync( code, data );
		}
		catch (Exception e)
		{
		}
	}
	
}
