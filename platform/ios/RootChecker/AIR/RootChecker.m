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
 * @file   		RootChecker.m
 * @brief  		ActionScript Native Extension
 * @author 		Michael Archbold
 * @created		Jan 19, 2012
 * @copyright	http://distriqt.com/copyright/license.txt
 *
 */


#import "FlashRuntimeExtensions.h"
#import "DTRCController.h"
#import "DTRCAIRExtensionContext.h"

#import <CoreNativeExtension/CoreNativeExtension.h>


NSString * const RootChecker_VERSION = @"1.0";
NSString * const RootChecker_IMPLEMENTATION = @"iOS";

FREContext distriqt_rootchecker_ctx = nil;
DTRCAIRExtensionContext* distriqt_rootchecker_extContext = nil;
DTRCController* distriqt_rootchecker_controller = nil;


////////////////////////////////////////////////////////
//	ACTIONSCRIPT INTERFACE METHODS 
//

FREObject RootChecker_version(FREContext ctx, void* funcData, uint32_t argc, FREObject argv[])
{
	FREObject result = NULL;
    @autoreleasepool
    {
        result = [DTFREUtils newFREObjectFromString: RootChecker_VERSION];
    }
    return result;
}


FREObject RootChecker_implementation(FREContext ctx, void* funcData, uint32_t argc, FREObject argv[])
{
	FREObject result = NULL;
    @autoreleasepool
    {
        result = [DTFREUtils newFREObjectFromString: RootChecker_IMPLEMENTATION];
    }
    return result;
}


FREObject RootChecker_isSupported(FREContext ctx, void* funcData, uint32_t argc, FREObject argv[])
{
	FREObject result = NULL;
    @autoreleasepool
    {
        result = [DTFREUtils newFREObjectFromBoolean: true ];
    }
    return result;
}


//
//
//  EXTENSION FUNCTIONALITY
//
//

FREObject RootChecker_isRooted(FREContext ctx, void* funcData, uint32_t argc, FREObject argv[])
{
    FREObject result = NULL;
    @autoreleasepool
    {
		result = [DTFREUtils newFREObjectFromBoolean: [distriqt_rootchecker_controller isRooted]];
    }
    return result;
}



////////////////////////////////////////////////////////
// FRE CONTEXT 
//

void RootCheckerContextInitializer(void* extData, const uint8_t* ctxType, FREContext ctx, uint32_t* numFunctionsToTest, const FRENamedFunction** functionsToSet)
{

    //
	//	Add the ACTIONSCRIPT interface
	
	static FRENamedFunction distriqt_rootcheckerFunctionMap[] =
    {
        MAP_FUNCTION( RootChecker_version,          "version",          NULL ),
        MAP_FUNCTION( RootChecker_implementation,   "implementation",   NULL ),
		MAP_FUNCTION( RootChecker_isSupported,      "isSupported",      NULL ),
		
		MAP_FUNCTION( RootChecker_isRooted,			"isRooted",      	NULL )
		
    };
    
    *numFunctionsToTest = sizeof( distriqt_rootcheckerFunctionMap ) / sizeof( FRENamedFunction );
    *functionsToSet = distriqt_rootcheckerFunctionMap;
    
	
	//
	//	Store the global states
	
    distriqt_rootchecker_ctx = ctx;
    
    distriqt_rootchecker_extContext = [[DTRCAIRExtensionContext alloc] init];
    distriqt_rootchecker_extContext.context = distriqt_rootchecker_ctx;
    
    distriqt_rootchecker_controller = [[DTRCController alloc] init];
    distriqt_rootchecker_controller.extContext = distriqt_rootchecker_extContext;

}


/**	
 *	The context finalizer is called when the extension's ActionScript code calls the ExtensionContext instance's dispose() method. 
 *	If the AIR runtime garbage collector disposes of the ExtensionContext instance, the runtime also calls ContextFinalizer().
 */
void RootCheckerContextFinalizer(FREContext ctx) 
{
    if (distriqt_rootchecker_controller != nil)
    {
        distriqt_rootchecker_controller.extContext = nil;
        distriqt_rootchecker_controller = nil;
    }
    
    if (distriqt_rootchecker_extContext != nil)
    {
        distriqt_rootchecker_extContext.context = nil;
        distriqt_rootchecker_extContext = nil;
    }

	distriqt_rootchecker_ctx = nil;
}


/**
 *	The extension initializer is called the first time the ActionScript
 *		side of the extension calls ExtensionContext.createExtensionContext() 
 *		for any context.
 */
void RootCheckerExtInitializer( void** extDataToSet, FREContextInitializer* ctxInitializerToSet, FREContextFinalizer* ctxFinalizerToSet ) 
{
	*extDataToSet = NULL;
	*ctxInitializerToSet = &RootCheckerContextInitializer;
	*ctxFinalizerToSet   = &RootCheckerContextFinalizer;
} 


/**
 *	The extension finalizer is called when the runtime unloads the extension. However, it is not always called.
 */
void RootCheckerExtFinalizer( void* extData ) 
{
	// Nothing to clean up.	
}

