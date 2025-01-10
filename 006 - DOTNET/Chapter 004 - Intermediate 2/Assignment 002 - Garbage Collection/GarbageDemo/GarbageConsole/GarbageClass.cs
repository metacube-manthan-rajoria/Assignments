using System;

namespace GarbageConsole;

public class ResourceHolder : IDisposable
{
    private bool disposed = false;

    private IntPtr unmanagedResource;

    private System.IO.StreamReader? managedResource;

    public ResourceHolder(string filePath)
    {
        unmanagedResource = 2;

        managedResource = new System.IO.StreamReader(filePath);
    }

    public void Dispose()
    {
        Dispose(true);
        GC.SuppressFinalize(this);
    }

    protected virtual void Dispose(bool disposing)
    {
        if (!disposed)
        {
            if (disposing)
            {
                if (managedResource != null)
                {
                    managedResource.Dispose();
                    managedResource = null;
                }
            }

            if (unmanagedResource != IntPtr.Zero)
            {
                unmanagedResource = IntPtr.Zero;
            }

            disposed = true;
        }
    }

    ~ResourceHolder()
    {
        Dispose(false);
    }
}

