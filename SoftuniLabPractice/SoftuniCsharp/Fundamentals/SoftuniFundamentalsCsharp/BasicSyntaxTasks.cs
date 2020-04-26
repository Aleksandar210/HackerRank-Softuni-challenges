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
                numbers.[i] = int.Parse(Console.ReadLine());
            }
            Array.Sort<int>(numbers, new Comparison<int>((a, b)=>a.CompareTo(b)));

           foreach (int number in numbers)
            {
                Console.WriteLine(number);
            }
        }




    }
}
