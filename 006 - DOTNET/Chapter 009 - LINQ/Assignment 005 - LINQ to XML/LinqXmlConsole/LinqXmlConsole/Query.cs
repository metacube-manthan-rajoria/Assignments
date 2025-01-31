using System.Xml.Linq;

namespace LinqXmlConsole;

public class Query{
    public static XElement? GetXmlDocument(){
        try{
            XElement document = XElement.Load("../../../Calatog.xml");
            return document;
        }catch(FileNotFoundException e){
            Console.WriteLine("Error - File at location not found\nLocation : " + e.FileName);
        }catch(UnauthorizedAccessException){
            Console.WriteLine("Error - File access not allowed.");
        }catch(NullReferenceException){
            Console.WriteLine("Error - Invalid path string.");
        }catch(Exception e){
            Console.WriteLine("Error\n" + e.Message);
        }
        return null;
    }

    public static void GetBookTable(){
        XElement? document = GetXmlDocument();
        if(document == null) return;

        var books = from book in document.Elements("book")
            let id = book.Attribute("id")
            let title = book.Element("title")
            let genre = book.Element("genre")
            let price = book.Element("price")
            orderby title.Value
            select new { 
                id = id.Value,
                title = title.Value, 
                genre = genre.Value,
                price = price.Value
            };

        foreach(var book in books){
            Console.WriteLine(book);
        }
    }

    public static void GetGenreCount(){
        XElement? document = GetXmlDocument();
        if(document == null) return;

        var books = from book in document.Elements("book")
            let id = book.Attribute("id")
            let title = book.Element("title")
            let genre = book.Element("genre")
            let price = book.Element("price")
            orderby title.Value
            select new { 
                id = id.Value,
                title = title.Value, 
                genre = genre.Value,
                price = price.Value
            };

        var booksUnderEachGenre = from book in books
            group book by book.genre
            into teams
            let count = teams.Count()
            orderby count
            select new {
                key = teams.Key,
                count
            }; 

        Console.WriteLine();
        foreach(var group in booksUnderEachGenre){
            Console.WriteLine(group);
        }
    }
}