using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace SoftuniOOP2019Lab
{
    class Program
    {
        static void Main(string[] args)
        {
            //Small test for new project run
            Console.Write("Enter numbers separated by space: ");
            List<int> currentListWithNumbers = Console.ReadLine().Split(" ", StringSplitOptions.RemoveEmptyEntries).Select(e => int.Parse(e))
                .ToList();
            int currentMinNumberInStream = int.MinValue;
            int currentMaxNumberToDisplay;
            for(int i=0;i<currentListWithNumbers.Count();i++)
            {
                if(currentListWithNumbers[i]>currentMinNumberInStream)
                {
                    currentMinNumberInStream = currentListWithNumbers[i];
                }
            }
            Console.WriteLine(currentMinNumberInStream);
                
        }
    }
}
