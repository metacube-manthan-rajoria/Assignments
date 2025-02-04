# Assignment

API stands for Application Programming Interface. It is a set of rules that tell us how to interact and communicate with a software.

API's work on request and response model. The client sends a request, which is processed and a response is sent.

ASP.NET supports two approaches for API
- Controller Based API
- Minimal API

> [!Note]
> The design of minimal APIs hides the host class by default and focuses on configuration and extensibility via extension methods that take functions as lambda
> expressions.

> Minimal API's do not have some functionality provided with Controller Based API

- No built-in support for model binding (IModelBinderProvider, IModelBinder). Support can be added with a custom binding shim.
- No built-in support for validation (IModelValidator).
- No support for application parts or the application model. There's no way to apply or build your own conventions.
- No built-in view rendering support. We recommend using Razor Pages for rendering views.
- No support for JsonPatch
- No support for OData
