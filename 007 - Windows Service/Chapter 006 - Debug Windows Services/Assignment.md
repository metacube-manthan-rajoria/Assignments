# Assignment

There are two types of windows services.

1. Windows Service (ServiceBase Class)

2. Worker Services (BackgroundService Class)

### Windows Service

Windows services are long-running applications that run in the background and can be started automatically when the operating system boots. They do not have a user interface and can be managed through the Windows Services management console.<br>

Windows Services are the default services that are part of windows. It is specifically made for creating windows services

> `ServiceBase` is part of the `System.ServiceProcess` namespace.

You need to handle the service lifecycle manually by overriding methods like `OnStart`, `OnStop`, `OnPause`, etc. <br>

Best suited for applications that need to run continuously in the background on Windows servers, such as monitoring applications, scheduled tasks, or services that respond to system events.

```
In case of Services made with ServiceBase cannot be debugged normally. To debug a service, you must start the service and then attach a debugger to the process in which it is running. You can then debug your application by using all of the standard debugging functionality of Visual Studio.

1. Build your service in the Debug configuration.

2. Install your service. For more information, see How to: Install and Uninstall Services.

3. Start your service, either from Services Control Manager, Server Explorer, or from code. For more information, see How to: Start Services.

4. Start Visual Studio with administrative credentials so you can attach to system processes.

5. (Optional) On the Visual Studio menu bar, choose Tools, Options. In the Options dialog box, choose Debugging, Symbols, select the Microsoft Symbol Servers check box, and then choose the OK button.

6. On the menu bar, choose Attach to Process from the Debug or Tools menu. (Keyboard: Ctrl+Alt+P)

7. The Processes dialog box appears.

8. Select the Show processes from all users check box.

9. In the Available Processes section, choose the process for your service, and then choose Attach.
```

### Worker Service

Part of the ASP.NET Core framework, specifically designed for creating hosted services in .NET Core applications.<br>

Runs within the context of a .NET Core application, such as a web application or a console application. It is not limited to Windows and can run on any platform supported by .NET Core.<br>

Inherits from BackgroundService, which provides a simplified way to implement long-running tasks using the ExecuteAsync method. The framework handles starting and stopping the service.<br>

Ideal for background processing in web applications, such as processing queues, scheduled tasks, or any long-running operations that need to run alongside a web server.<br>

```
Worker services can be debugged normally, we just need to add console to the application
```