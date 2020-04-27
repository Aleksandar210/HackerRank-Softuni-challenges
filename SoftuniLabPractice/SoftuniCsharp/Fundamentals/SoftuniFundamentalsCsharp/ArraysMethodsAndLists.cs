using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace SoftuniFundamentalsCsharp
{
    class ArraysMethodsAndLists
    {
        public void EncrpytSortPrint()
        {
            Dictionary<string, int> words = new Dictionary<string, int>();
            int numberInputs = int.Parse(Console.ReadLine());
            while(numberInputs-- > 0)
            {
                string enterWord = Console.ReadLine();
                words.Add(enterWord, GetSumOfVolews(enterWord));


            }

            

            foreach (KeyValuePair<string, int> item in words.OrderBy(key => key.Value))
            {
                Console.WriteLine(item.Key + " -> " + item.Value);
            }
        }

        private int GetSumOfVolews(string word)
        {
            int sum = 0;
            char[] c =  word.ToCharArray();
            for(int i = 0; i < c.Length; i++)
            {
                switch (c[i].ToString().ToLower())
                {
                    case "a":
                       
                    case "e":
                        
                    case "i":
                       
                    case "o":

                    case "u":
                        sum += (int)c[i];
                        break;
                }
            }
            return sum;

        }


        public void Train()
        {
            int numberWagons = int.Parse(Console.ReadLine());
            int[] train = new int[numberWagons];
            int counter = 0;
            while(numberWagons-- > 0)
            {
                int numberPeople = int.Parse(Console.ReadLine());
                train[counter] = numberPeople;
                counter++;
            }

            List<int> temp = train.ToList();
           int result =  temp.Aggregate((a, b) => a + b);
            Console.WriteLine(result);
                
        }

    }
}
