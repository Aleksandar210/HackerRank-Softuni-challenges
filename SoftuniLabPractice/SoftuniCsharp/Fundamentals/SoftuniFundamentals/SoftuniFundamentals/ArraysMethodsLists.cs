using System;
using System.Collections;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Text.RegularExpressions;

namespace SoftuniFundamentals
{
    class ArraysMethodsLists
    {
        public void Rotation()
        {
            string[] elements = Regex.Split(Console.ReadLine(), "\\s+");
            int numberRotations = int.Parse(Console.ReadLine());
            while(numberRotations-- > 0)
            {
                string firstElement = elements[0];
                for(int i = 1; i < elements.Length; i++)
                {
                    elements[i - 1] = elements[i];
                }
                elements[elements.Length - 1] = firstElement;
            }

            foreach(string item in elements)
            {
                Console.Write(item+" ");
            }

        }

        public void EqualSums()
        {
            int[] numbers = Regex.Split(Console.ReadLine(), "\\s+").Select(e => int.Parse(e)).ToArray();
            int leftSum = 0;
            int rightSum = 0;
            for(int i = 0; i < numbers.Length-1; i++)
            {
                if (i == 0)
                {
                    for (int l = i + 1; l < numbers.Length; l++)
                    {
                        rightSum += numbers[l];
                    }

                }
                else
                {
                    for(int l = i + 1; l < numbers.Length; l++)
                    {
                        rightSum += numbers[l];
                    }

                    for(int k = 0; k < i; k++)
                    {
                        leftSum += numbers[k];
                    }
                }


                if (leftSum == rightSum)
                {
                    Console.Write(numbers[i]+" ");
                }
            }

           

        }

        public void KaminoFactory()
        {
            List<string> sequences = new List<string>();
            List<string> newSortedList;
            string enterSequence;
            do
            {
                enterSequence = Console.ReadLine();
                if(enterSequence.Equals("Clone Them!", StringComparison.OrdinalIgnoreCase))
                {
                    break;
                }
                else
                {
                    sequences.Add(string.Join("",Regex.Split(enterSequence, "\\s+")));
                    
                }


            }
            while (!enterSequence.Equals("Clone Them!", StringComparison.OrdinalIgnoreCase));

            newSortedList = sequences.OrderByDescending(c => c).ToList();
            int bestIndex = GetDnaPosition(sequences, newSortedList.First());
            
            Console.WriteLine("Best DNA is {0} -> {1}",bestIndex,newSortedList[bestIndex-1]);
        }

        private int GetDnaPosition(List<string> sequences, string bestSequence)
        {
            int bestIndex = 0;
            for(int i = 0; i < sequences.Count; i++)
            {
                if (sequences[i].Equals(bestSequence))
                {
                    bestIndex = i + 1;
                }
            }

            return bestIndex;
        }
    }
}
