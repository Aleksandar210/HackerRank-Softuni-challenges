using System;
using System.Collections.Generic;
using System.Linq;
using System.Runtime.ConstrainedExecution;
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

        public void PrimeChecker()
        {
            int number = int.Parse(Console.ReadLine());
            for(int i = 2; i <= number; i++)
            {
                if (i % 2 == 0)
                {
                    Console.WriteLine($"{i}->{true}");
                }
                else
                {
                    Console.WriteLine($"{i}->{false}");
                }
            }
        }

        public void Decrpyt()
        {
            int key = int.Parse(Console.ReadLine());
            int numberLines = int.Parse(Console.ReadLine());
            StringBuilder sb = new StringBuilder();
            while(numberLines-- > 0)
                
            {
                char c = Console.ReadLine().ElementAt(0);
                c += (char)((int)c+key);
                sb.Append(c);
            }

            Console.WriteLine(sb.ToString());
        }

        public void BalancedBrackets()
        {
            int numberCommands = int.Parse(Console.ReadLine());
            int numberLeft = 0;
            int numberRight = 0;
            string entered;
            while(numberCommands-- > 0)
            {
                entered = Console.ReadLine();
                if (entered.Equals("("))
                {
                    numberLeft++;
                }
                else if (entered.Equals(")"))
                {
                    numberRight++;
                }
            }

            if (numberLeft != numberRight)
            {
                Console.WriteLine("Unbalanced");
            }
            else
            {
                Console.WriteLine("Balanced");
            }
        }

        public void IntegerOperations()
        {
            int[] numbers = new int[4];
            int res = 0;
            for(int i = 0; i < 4; i++)
            {
                
                numbers[i] = int.Parse(Console.ReadLine());
                if (i == 1)
                {
                    res = numbers[i - 1] + numbers[i];
                }else if (i == 2)
                {
                    res /= numbers[i];
                }
            }
            Console.WriteLine("Result is {0}", res *= numbers[numbers.Length - 1]);

        }

        public void SumDigits()
        {
            int number = int.Parse(Console.ReadLine());
            int sum = number.ToString().ToCharArray().Select(c => int.Parse(c.ToString())).Aggregate((a, b) => a + b);
            Console.WriteLine(sum);
        }

        public void WaterOverflow()
        {
            const int CAPACITY = 255;
            int currentFull = 0;
            int numberCommands = int.Parse(Console.ReadLine());
            while(numberCommands-- > 0)
            {
                int command = int.Parse(Console.ReadLine());
                if (command + currentFull > CAPACITY)
                {
                    Console.WriteLine("Insufcient ammount");

                }
                else
                {
                    currentFull += command;
                }
            }
            Console.WriteLine(currentFull);
        }

        public void BeerKeg()
        {
            string biggestModel ="";

            double currentVolume = 0;
           for(int i = 0; i < 3; i++)
            {
                string model = Console.ReadLine();
                int height = int.Parse(Console.ReadLine());
                double radius = double.Parse(Console.ReadLine());
                double volume = Math.PI * (radius * radius) * height;
                if (volume > currentVolume)
                {
                    currentVolume = volume;
                    biggestModel = model;
                }

            }

            Console.WriteLine(biggestModel);

        }

        public void SpiceFlow()
        {
            int sourceYield = int.Parse(Console.ReadLine());
            int days = 1;
            int spiceCollected = 0;
            while (true)
            {
                if (sourceYield < 100)
                {
                    if (sourceYield > 26)
                    {
                        spiceCollected += 26;
                        sourceYield -= 26;
                    }else
                    {
                        spiceCollected += sourceYield;
                        sourceYield = 0;
                    }
                    break;
                }

                if (sourceYield > 26)
                {
                    spiceCollected += 26;
                    sourceYield -= 26;
                    days++;
                    sourceYield -= 10;
                }
            }
            Console.WriteLine(days + "\n" + spiceCollected);

        }
    }
}
