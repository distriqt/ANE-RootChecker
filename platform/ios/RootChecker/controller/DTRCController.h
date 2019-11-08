//
//  DTRCController.h
//  RootChecker
//
//  Created by Michael Archbold on 22/09/2015.
//  Copyright © 2015 distriqt. All rights reserved.
//

#import <Foundation/Foundation.h>
#import "DTRCContext.h"


@interface DTRCController : NSObject

@property id<DTRCContext> extContext;


-(Boolean) isRooted;



@end
