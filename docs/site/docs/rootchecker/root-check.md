---
title: Root Check
sidebar_label: Root Check
---


To check whether the device has been "rooted" or jail broken you check the `isRooted` flag.

Calling this will perform several native tests in order to guess whether the device is rooted. It is not a complete check as once a device has root access they can modify the device as they see fit to avoid detection.

```actionscript
if (RootChecker.instance.isRooted)
{
    // device has been rooted / jail broken 
}
```