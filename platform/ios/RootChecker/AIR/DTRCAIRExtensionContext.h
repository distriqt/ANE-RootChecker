//
//  DTRCAIRExtensionContext.h
//  RootChecker
//
//  Created by Michael Archbold on 22/09/2015.
//  Copyright © 2015 distriqt. All rights reserved.
//

#import <Foundation/Foundation.h>
#import "DTRCContext.h"
#import "FlashRuntimeExtensions.h"


@interface DTRCAIRExtensionContext : NSObject<DTRCContext>

@property FREContext context;

@end
