using System;
using System.Collections.Generic;
using System.Linq;

namespace SoftuniOOP_2019
{
    class Program
    {
        static void Main(string[] args)
        {

            //test
          List<int> currentListOne = Console.ReadLine().Split(" ",StringSplitOptions.RemoveEmptyEntries).Select(e=>int.Parse(e)).ToList();
          List<int> currentListTwo = Console.ReadLine().Split(" ", StringSplitOptions.RemoveEmptyEntries).Select(e => int.Parse(e)).ToList();
            Console.WriteLine(GetSmallestNumberInList(currentListOne) + GetSmallestNumberInList(currentListTwo));
        }

        private static int GetSmallestNumberInList(List<int> currentList)
        {
            int smallest = int.MaxValue;
            for(int i=0;i<currentList.Count();i++)
            {
                if(currentList[i]<smallest)
                {
                    smallest = currentList[i];                }
            }

            return smallest;
        }
    }
}
