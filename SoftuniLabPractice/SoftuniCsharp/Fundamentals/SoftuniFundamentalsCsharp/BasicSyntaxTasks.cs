using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace SoftuniFundamentalsCsharp
{
    class BasicSyntaxTasks
    {
       
        public void TimeCalculator()
        {
            int hours;
            do
            {
                hours = int.Parse(Console.ReadLine());
            }
            while (hours<0 || hours>23);


            int minutes;
            do
            {
                minutes = int.Parse(Console.ReadLine());
            }
            while (minutes < 0 || minutes > 59);

            int addMinutes = int.Parse(Console.ReadLine());

            if(addMinutes +minutes >59)
            {
               minutes =  addMinutes + minutes - 60;
                hours += 1;
            }
            else
            {
                minutes = addMinutes += minutes;
            }

            if(hours>23)
            {
                hours = hours - 24;
            }

            Console.WriteLine($"{hours:d2}:{minutes:d2}");


            
        }

        public void DivisibleByThree()
        {

            for(int i = 1; i <= 100; i += 3)
            {
                if (i % 3 == 0)
                {
                    Console.WriteLine(i);
                }
            }

        }


        public void SortNumbers()
        {
            int[] numbers = new int[3];
            for(int i = 0; i < 3; i++)
            {
                numbers[i] = int.Parse(Console.ReadLine());
            }
            Array.Sort<int>(numbers, new Comparison<int>((a, b)=>a.CompareTo(b)));

           foreach (int number in numbers)
            {
                Console.WriteLine(number);
            }
        }


        public void LastNumber()
        {
            int enterNumber = int.Parse(Console.ReadLine());
            string lastNumber="";
            switch (enterNumber.ToString().ElementAt(enterNumber.ToString().Length - 1))
            {
                case '0':
                    lastNumber = "zero";
                    break;
                case '1':
                    lastNumber = "one";
                    break;
                case '2':
                    lastNumber = "two";
                    break;
                case '3':
                    lastNumber = "three";
                    break;
                case '4':
                    lastNumber = "four";
                    break;
                case '5':
                    lastNumber = "five";
                    break;
                case '6':
                    lastNumber = "six";
                    break;
                case '7':
                    lastNumber = "seven";
                    break;
                case '8':
                    lastNumber = "eight";
                    break;
                case '9':
                    lastNumber = "nine";
                    break;
            }
            Console.WriteLine(lastNumber);
        }

    }
}
