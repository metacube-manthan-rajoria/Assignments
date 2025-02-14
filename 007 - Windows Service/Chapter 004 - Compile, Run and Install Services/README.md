# Compile, Run and Install Services

Here are a few steps to compile, register and start your service

### How to Build

Publish your Windows Service Application

```bash
dotnet publish -c Release -o ./publish
```

Register your service application to Services Control Manager

```bash
sc.exe create "[Write your service name here]" binpath="[Your Executable's Path]" 
```

Start your service

```bash
sc.exe start "[Your service name]"
```

> [!Note]
> The service name you give in `builder.Services` options will show up in `Event Viewer`

### Links

- [How to Install and Uninstall Services - Microsoft Docs](https://learn.microsoft.com/en-us/dotnet/framework/windows-services/how-to-install-and-uninstall-services)
