# Assignment

> Question 1 : List the responsibilities of CLR

CLR stands for Common Language Runtime. CLR is a runtime environment that manages and executes the code written in any .NET programming language.
CLR is responsible for many things including
- Memory Management - it manages memory allocation and cleanup through garbage collection.
- Thread Management - it manages threads for parallel and asynchronous programming.
- Exception Handling - allows developers to cath and handle exceptions.
- Code execution - is responsible for executing the .NET code(MSIL).
- Code Access Security - prevents unauthorised access to resources.
- Type Safety - enforces type safety to prevent type mismatches.
- Compilation - Uses JIT to compile programs
- Assembly Loading and Execution - loads and executes assemblies that contain code, metadata and resources.
- Performance Optimisation - includes various optimisations.

<br>

> Question 2 : What is the significance of Private and Shared assemblies? Provide steps to register an assembly as shared.

We can categorize assemblies in .NET as private or shared based on how they are deployed or accessed.

- Private Assembly - Used for applications where the assembly is intended to be used exclusively by that application. These assemblies are stored in the applications directory and do not need to be shared with other applications

- Shared Assembly - They are intended to be used by multiple applications. They are stored in the Global Assembly Cache(GAC), which allows them to be accessed by multiple applications on the same machine.

To share an assembly we need to take the following steps.

- Create your assembly.
- Assign a strong name to your assembly.
- Use the GAC tool(gacutil.exe) to install assembly into GAC. <br> 
```gacutil /i <AssemblyName.dll>``` 