using System;

namespace Restaurant
{
    class Program
    {
        static void Main(string[] args)
        {
            Coffee currentCoffee = new Coffee("Lavaza", 0.60m, 50);
            Console.WriteLine(currentCoffee.Name);
        }
    }
}
