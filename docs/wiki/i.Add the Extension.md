
## Add the Extension

First step is always to add the extension to your development environment. 
To do this use the tutorial located [here](http://airnativeextensions.com/knowledgebase/tutorial/1).



## Required ANEs

### Core ANE

The Core ANE is required by this ANE. You must include and package this extension in your application.

The Core ANE doesn't provide any functionality in itself but provides support libraries and frameworks used by our extensions.
It also includes some centralised code for some common actions that can cause issues if they are implemented in each individual extension.

You can access this extension here: [https://github.com/distriqt/ANE-Core](https://github.com/distriqt/ANE-Core).



## Android 

Nothing specific is required for Android.


## iOS 

For iOS, you will need to add `cydia` to the allowed list of query schemes.


### Info Additions

```xml
<key>LSApplicationQueriesSchemes</key>
<array>
	<string>cydia</string>
</array>
```

i.e.

```xml
<iPhone>
    <InfoAdditions><![CDATA[
        <key>UIDeviceFamily</key>
        <array>
            <string>1</string>
            <string>2</string>
        </array>

        <key>LSApplicationQueriesSchemes</key>
        <array>
            <string>cydia</string>
        </array>

    ]]></InfoAdditions>
    <requestedDisplayResolution>high</requestedDisplayResolution>
    <Entitlements>
        <![CDATA[
        ]]>
    </Entitlements>
</iPhone>
```



## Checking for Support

You can use the `isSupported` flag to determine if this extension is supported on the current platform and device.

This allows you to react to whether the functionality is available on the device and provide an alternative solution if not.


```as3
if (RootChecker.isSupported)
{
	// Functionality here
}
```
