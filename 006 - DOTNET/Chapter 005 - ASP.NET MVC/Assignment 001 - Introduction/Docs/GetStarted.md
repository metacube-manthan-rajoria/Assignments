# How to get started with MVC

This tutorial teaches ASP.NET Core MVC web development with controllers and views.

##### Prerequisites
- Visual Studio Code
- C# Dev Kit for Visual Studio Code
- .NET 9.0 SDK

### Get Started
- Change to the directory (cd) that will contain the project. The project can be located anywhere.
- Run the following commands. The dotnet new command creates a new ASP.NET Core MVC project in the MvcMovie folder. The code command opens the MvcMovie project folder in the current instance of Visual Studio Code.

```bash
dotnet new mvc -o MvcMovie
code -r MvcMovie
```

When Visual Studio Code requests that you add assets to build and debug the project, select Yes. If Visual Studio Code doesn't offer to add build and debug assets, select View > Command Palette and type ".NET" into the search box. From the list of commands, select the .NET: Generate Assets for Build and Debug command.

### Running the app

- Trust the HTTPS development certificate by running the following command

```bash
dotnet dev-certs https --trust
```

- Select Yes if you agree to trust the development certificate.
- In Visual Studio Code, press Ctrl+F5 (Windows)/^+F5 (macOS) to run the app without debugging.
- In Visual Studio Code, from the Run menu, select Stop Debugging or press Shift+F5 to stop the app.
