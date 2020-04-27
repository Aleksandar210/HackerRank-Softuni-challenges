using System;

namespace SoftuniFundamentals
{
    class Program
    {
        static void Main(string[] args)
        {
            string[] names = System.Text.RegularExpressions.Regex.Split(Console.ReadLine(),"\\s+");
            
            
                Console.WriteLine(names[0]);
            

        }
    }
}
