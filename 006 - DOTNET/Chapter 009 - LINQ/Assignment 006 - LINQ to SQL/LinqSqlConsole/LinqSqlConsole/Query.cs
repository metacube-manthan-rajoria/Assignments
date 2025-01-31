using Microsoft.Data.SqlClient;
using System.Data;

namespace LinqSqlConsole;

public class Query
{
    private static string connectionString =
        "Server=MANTHANRAJ-RAJO\\SQLEXPRESS2022;" +
        "Database=LinqSqlConsole;" +
        "Trusted_Connection=True;TrustServerCertificate=True;" +
        "Connection Timeout=30;" +
        "Encrypt=True;";

    private static readonly DataSet products;
    private static readonly DataSet categories;

    static Query()
    {
        products = new DataSet();
        categories = new DataSet();

        SqlConnection connection = new SqlConnection(connectionString);
        connection.Open();

        SqlCommand category = new SqlCommand("SELECT * FROM Category", connection);
        SqlCommand product = new SqlCommand("SELECT * FROM Product", connection);

        SqlDataAdapter adapter = new SqlDataAdapter();

        adapter.SelectCommand = category;
        adapter.Fill(categories, "Category");

        adapter.SelectCommand = product;
        adapter.Fill(products, "Product");

        connection.Close();
    }

    public static void PrintProductTable()
    {
        var productTable = from product in products.Tables[0].AsEnumerable()
                           join category in categories.Tables[0].AsEnumerable()
                           on product.Field<int>("CategoryId") equals category.Field<int>("CategoryId")
                           select new
                           {
                               ProductId = product["ProductId"],
                               ProductTitle = product["ProductTitle"],
                               CategoryName = category["CategoryTitle"]
                           };

        Console.WriteLine("\n" + products.Tables[0].TableName);
        foreach (var row in productTable)
        {
            Console.WriteLine(row);
        }
    }

    public static void PrintProductInCategories()
    {
        try
        {
            var query = from category in categories.Tables[0].AsEnumerable()
                        join product in products.Tables[0].AsEnumerable()
                        on category.Field<int>("CategoryId") equals product.Field<int>("CategoryId") into newTable
                        from product in newTable.DefaultIfEmpty()
                        let ct = category.Field<string>("CategoryTitle")
                        orderby ct
                        select new
                        {
                            ProductTitle = product != null ? product.Field<string>("ProductTitle") : "No Product",
                            CategoryTitle = ct,
                        };

            Console.WriteLine("\nProducts In each category");
            foreach (var row in query)
            {
                Console.WriteLine($"{row.ProductTitle} : {row.CategoryTitle}");
            }

        }
        catch (ArgumentException e)
        {
            Console.WriteLine(e.Message);
        }
    }

    public static void PrintTables()
    {
        Console.WriteLine("\n" + categories.Tables[0].TableName);
        foreach (DataTable table in categories.Tables)
        {
            foreach (DataRow row in table.Rows)
            {
                Console.WriteLine($"{row["CategoryId"]}, \t{row["CategoryTitle"]}");
            }
        }

        Console.WriteLine("\n" + products.Tables[0].TableName);
        foreach (DataTable table in products.Tables)
        {
            foreach (DataRow row in table.Rows)
            {
                Console.WriteLine($"{row["ProductId"]}, \t{row["CategoryId"]}, \t{row["ProductTitle"]}");
            }
        }
    }
}