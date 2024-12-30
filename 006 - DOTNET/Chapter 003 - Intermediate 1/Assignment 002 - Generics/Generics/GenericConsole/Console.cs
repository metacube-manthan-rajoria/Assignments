using GenericApp;

class Console
{
    static void Main(string[] args)
    {
        GenericClass<int>.Compare(1, 2);
        GenericClass<int>.Compare(2, 2);
        GenericClass<string>.Compare("hello", "hell");
        GenericClass<string>.Compare("hello", "hello");

        List<int> iList = new List<int>();
        iList.Add(1);
        List<string> sList = new List<string>();

        CheckList.IsListEmpty(iList);
        CheckList.IsListEmpty(sList);
    }
}
