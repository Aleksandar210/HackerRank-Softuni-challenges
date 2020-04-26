using System;
using System.Collections.Generic;
using System.Text;

namespace SoftuniFundamentalsCsharp
{
    class DataTypes
    {
        public void LeftToRight()
        {
            int numberLines = int.Parse(Console.ReadLine());
            while (numberLines-- > 0)
            {
                string enter = Console.ReadLine();
                string[] numbers = enter.Split(@"\s\s+");
                int left = int.Parse(numbers[0]);
                int right = int.Parse(numbers[1]);

                int sum;
                if (left > right)
                {
                     sum = 0;
                    int m;
                    int counter = left.ToString().Length;
                    while ( counter -- > 0)
                    {
                        m = left % 10;
                        sum += m;
                        left /= 10;
                    }


                }
                else
                {
                     sum = 0;
                    int m;
                    int counter = right.ToString().Length;
                    while (counter-- > 0)
                    {
                        m = left % 10;
                        sum += m;
                        left /= 10;
                    }
                }
                Console.WriteLine(sum);
            }
        }

        public void CompareFlaots()
        {
            const float EPS = 0.000001f;
            float number1 = float.Parse(Console.ReadLine());
            float number2 = float.Parse(Console.ReadLine());
            if (number1 - number2 < EPS)
            {
                Console.WriteLine(true);
            }
            else
            {
                Console.WriteLine(false);
            }

        }
    }
}
