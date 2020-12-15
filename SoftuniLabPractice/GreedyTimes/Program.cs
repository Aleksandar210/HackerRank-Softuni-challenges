using System;

namespace GreedyTimes
{
    class Program
    {
        static void Main(string[] args)
        {
            Bag currentbag;
            //enter bag capacity
            try
            {
                Console.Write("Enter bag capacity:  ");
                int capacity = int.Parse(Console.ReadLine());
                currentbag = new Bag(capacity);
            }
            catch(ArgumentException exc)
            {
                Console.WriteLine(exc.Message);
                return;
            }

            //enter safe data
            Console.Write("Enter safe contents:  ");
            string[] currentSafeItems = Console.ReadLine().Split(" ", StringSplitOptions.RemoveEmptyEntries);
            for(int i =0;i<=currentSafeItems.Length-2;i+=2)
            {
                currentbag.PutItemInBag(String.Concat(currentSafeItems[i] + " " + currentSafeItems[i + 1]));
            }

            Console.WriteLine("Bag content: ");
            Console.WriteLine(currentbag);
        }
    }
}
