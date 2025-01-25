using System.Data;
using System.Data.SqlClient;

namespace ADOClientConsole;

public class Client
{
    public static bool CreateTable()
    {
        try
        {
            //Creating DataSet
            DataSet classRecords = new DataSet("ClassRecords"); 

            //Creating data table
            DataTable dataTable = classRecords.Tables.Add("Student");

            //Add the DataColumn using all properties
            DataColumn Id = new DataColumn("ID");
            Id.DataType = typeof(int);
            Id.Unique = true;
            Id.AllowDBNull = false;
            Id.Caption = "Student ID";
            dataTable.Columns.Add(Id);

            DataColumn Name = new DataColumn("Name");
            Name.MaxLength = 50;
            Name.AllowDBNull = false;
            dataTable.Columns.Add(Name);

            DataColumn Email = new DataColumn("Email");
            dataTable.Columns.Add(Email);

            //Setting the Primary Key
            dataTable.PrimaryKey = new DataColumn[] { Id };

            //Add New DataRow
            DataRow row1 = dataTable.NewRow();
            row1["Id"] = 101;
            row1["Name"] = "Anurag";
            row1["Email"] = "Anurag@metacube.net";
            dataTable.Rows.Add(row1);

            dataTable.Rows.Add(102, "Mohanty", "Mohanty@metacube.net");


            //Creating data table
            DataTable dataTable2 = classRecords.Tables.Add("Teachers");

            //Add the DataColumn
            DataColumn Id2 = new DataColumn("ID");
            Id2.DataType = typeof(int);
            Id2.Unique = true;
            Id2.AllowDBNull = false;
            Id2.Caption = "Student ID";
            dataTable2.Columns.Add(Id2);

            DataColumn Name2 = new DataColumn("Name");
            Name2.MaxLength = 50;
            Name2.AllowDBNull = false;
            dataTable2.Columns.Add(Name2);

            DataColumn Email2 = new DataColumn("Email");
            dataTable2.Columns.Add(Email2);

            //Setting the Primary Key
            dataTable2.PrimaryKey = new DataColumn[] { Id2 };

            //Adding new DataRow by simply adding the values
            dataTable2.Rows.Add(1, "Arya", "arya@metacube.net");
            dataTable2.Rows.Add(2, "Moksha", "moksha@metacube.net");


            foreach(DataTable table in classRecords.Tables){
                Console.WriteLine("\n"+table.TableName);
                foreach (DataRow row in table.Rows){
                    Console.WriteLine(row["Id"] + ",  " + row["Name"] + ",  " + row["Email"]);
                }
            }
        }
        catch (Exception e)
        {
            Console.WriteLine("OOPs, something went wrong.\n" + e);
            return false;
        }

        Console.ReadKey();
        return true;
    }
}


