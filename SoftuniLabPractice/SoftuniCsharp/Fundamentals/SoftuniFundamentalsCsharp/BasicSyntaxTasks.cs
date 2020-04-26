using System;
using System.Collections.Generic;
using System.Linq;
using System.Security;
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

        public void Games()
        {
            Dictionary<String, double> currentGames = new Dictionary<string, double>();
            currentGames.Add("CS: OG", 15.99);
            currentGames.Add("OutFall4", 39.99);
            currentGames.Add("Honored 2",59.99);
            currentGames.Add("Zplinter Zell", 19.99);
            currentGames.Add("RoverWatch", 29.99);
            currentGames.Add("RoverWatch Origins Edition", currentGames["RoverWatch"] + 10);

            double currentBalance = double.Parse(Console.ReadLine());
            string enterCommand = "";
            do
            {
                if (currentBalance <= 0)
                {
                    Console.WriteLine("Out of money!");
                    return;
                }
                enterCommand = Console.ReadLine();

                if(enterCommand.Equals("Game time!", StringComparison.OrdinalIgnoreCase))
                {
                    break;
                }
                else
                {
                    if (currentGames.ContainsKey(enterCommand))
                    {
                        if (currentBalance >= currentGames[enterCommand])
                        {
                            currentBalance -= currentGames[enterCommand];
                            Console.WriteLine("Bought {0}", enterCommand);
                        }
                        else
                        {
                            Console.WriteLine("Too Expensive!");
                        }
                    }
                    else
                    {
                        Console.WriteLine("Not found");
                    }
                }

            }
            while (!enterCommand.Equals("Game time!", StringComparison.OrdinalIgnoreCase));
        }

        public void ReverseString()
        {
            string word = Console.ReadLine();
            char[] currentLetters = word.ToCharArray();
            string[] reversed = currentLetters.Select(c => c.ToString()).ToArray<string>();
            Array.Reverse(reversed);
            word = string.Join("",reversed);
            Console.WriteLine(word);

        }

        public void PhoneText()
        {
            Dictionary<int, char> currentLetters = new Dictionary<int, char>();
            Dictionary<int, int> currentPhoneDigits = new Dictionary<int, int>();
            int startLetterAsci = 97;
            for(int i = 0; i <= 26; i++)
            {

                if(i>=2 && i <= 9)
                {
                    FillPhoneDigits(i, 0, currentPhoneDigits);
                }

                char c = (char)startLetterAsci;
                currentLetters.Add(i,c);
                startLetterAsci++;
            }


            int numberCommands = int.Parse(Console.ReadLine());
            int enteredCommand = 0;
            StringBuilder sb = new StringBuilder();
            while(numberCommands-- > 0)
            {
                enteredCommand = int.Parse(Console.ReadLine());
                sb.Append(currentLetters[currentPhoneDigits[enteredCommand]]);
            }
            Console.WriteLine(sb.ToString());
        }

        
        private void FillPhoneDigits(int digit, int times, Dictionary<int, int> currentPhoneDigits)
            
        {
            int from=0;
            int to=0;
            times = 3;
            switch (digit)
            {
                case 2:
                    from = 0;
                    to = 2;
                    
                    break;
                case 3:
                    from =  3;
                    to =  5;
                    break;
                case 4:
                    from = 6;
                    to = 8;
                    break;
                case 5:
                    from = 9;
                    to = 12;
                    break;
                case 6:
                    from = 13;
                    to = 15;
                    break;
                case 7:
                    from = 16;
                    to = 19;
                    times = 4;
                    break;
                case 8:
                    from = 20;
                    to = 22;
                    break;
                case 9:
                    from = 23;
                    to = 26;
                    times = 4;
                    break;
            }

            int currentDigit = 0;
            for(int i = 1; i <= times; i++)
            {
                currentDigit += digit;
               for(int k = from; k < to; i++)
                {
                    currentPhoneDigits.Add(currentDigit, k);
                }
            }
            

        }

        

    }
}
