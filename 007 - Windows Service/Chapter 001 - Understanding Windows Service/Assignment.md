# Assignment

Windows Service enables you to create long-running executable applications that run in their own Windows sessions. These services can be automatically started when the computer boots, can be paused and restarted, and do not show any user interface.

After you create and build the application, you can install it by running the command-line utility InstallUtil.exe and passing the path to the service's executable file. You can then use the Services Control Manager to start, stop, pause, resume, and configure your service.

There are two types of services you can create in Visual Studio using the .NET Framework. Services that are the only service in a process are assigned the type Win32OwnProcess. Services that share a process with another service are assigned the type Win32ShareProcess. You can retrieve the service type by querying the ServiceType property.