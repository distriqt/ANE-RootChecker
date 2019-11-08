//
//  DTRCController.m
//  RootChecker
//
//  Created by Michael Archbold on 22/09/2015.
//  Copyright © 2015 distriqt. All rights reserved.
//

#import "DTRCController.h"

#import <UIKit/UIKit.h>


@implementation DTRCController

@synthesize extContext;


-(Boolean) isRooted
{
#if !(TARGET_IPHONE_SIMULATOR)
	
	// Check 1 : existence of files that are common for jailbroken devices
	if ([[NSFileManager defaultManager] fileExistsAtPath: @"/Applications/Cydia.app"] ||
		[[NSFileManager defaultManager] fileExistsAtPath: @"/Library/MobileSubstrate/MobileSubstrate.dylib"] ||
		[[NSFileManager defaultManager] fileExistsAtPath: @"/bin/bash"] ||
		[[NSFileManager defaultManager] fileExistsAtPath: @"/usr/sbin/sshd"] ||
		[[NSFileManager defaultManager] fileExistsAtPath: @"/etc/apt"] ||
		[[NSFileManager defaultManager] fileExistsAtPath: @"/private/var/lib/apt/"] ||
		[[UIApplication sharedApplication] canOpenURL:[NSURL URLWithString: @"cydia://package/com.example.package"]])
	{
		return YES;
	}
	
	FILE *f = NULL ;
	if ((f = fopen("/bin/bash", "r")) ||
		(f = fopen("/Applications/Cydia.app", "r")) ||
		(f = fopen("/Library/MobileSubstrate/MobileSubstrate.dylib", "r")) ||
		(f = fopen("/usr/sbin/sshd", "r")) ||
		(f = fopen("/etc/apt", "r"))) {
		fclose(f);
		return YES;
	}
	fclose(f);
	
	// Check 2 : Reading and writing in system directories (sandbox violation)
	NSError *error;
	NSString *stringToBeWritten = @"Jailbreak Test.";
	[stringToBeWritten writeToFile: @"/private/jailbreak.txt"
						atomically: YES
						  encoding: NSUTF8StringEncoding
							 error: &error];
	if (error == nil)
	{
		//Device is jailbroken
		return YES;
	}
	else
	{
		[[NSFileManager defaultManager] removeItemAtPath:@"/private/jailbreak.txt" error:nil];
	}
	
#endif
	return NO;
}


@end
