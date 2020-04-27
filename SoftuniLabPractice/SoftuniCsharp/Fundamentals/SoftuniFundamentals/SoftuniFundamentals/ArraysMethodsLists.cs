using System;
using System.Collections.Generic;
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
    }
}
