using System;
using System.Collections.Generic;

namespace ToyStoreBasics
{
    public class Program
    {
        static void Main(string[] args)
        {
            Dictionary<string, double> pricesOfToys = new Dictionary<string, double>();
            FillDictioanryWithPrices(pricesOfToys);

            Dictionary<string, int> numberToysOrdered = new Dictionary<string, int>();
            numberToysOrdered.Add("Puzzle", 0);
            numberToysOrdered.Add("Truck", 0);
            numberToysOrdered.Add("Minion", 0);
            numberToysOrdered.Add("Stuffed Teddy", 0);
            numberToysOrdered.Add("Talking doll", 0);

            Console.Write("Enter the price of the trip: ");
            double tripPrice = double.Parse(Console.ReadLine());

            Console.Write("Enter number of puzzles: ");
            int numberPuzzles = int.Parse(Console.ReadLine());
            numberToysOrdered["Puzzle"] += numberPuzzles;

            Console.Write("Enter number of talking dolls: ");
            int numberTalkingDolls = int.Parse(Console.ReadLine());
            numberToysOrdered["Talking doll"] += numberTalkingDolls;

            Console.Write("Enter number of Teddy bears: ");
            int numberTeddyBears = int.Parse(Console.ReadLine());
            numberToysOrdered["Stuffed Teddy"] += numberTeddyBears;

            Console.Write("Enter number of minions: ");
            int numberMinions = int.Parse(Console.ReadLine());
            numberToysOrdered["Minion"] += numberMinions;

            Console.Write("Enter number of trucks: ");
            int numberTrucks = int.Parse(Console.ReadLine());
            numberToysOrdered["Truck"] += numberTrucks;

            int overallToysOrdered = numberMinions + numberPuzzles + numberTalkingDolls + numberTeddyBears
                                        + numberTrucks;
            double result = 0;

            result = CalcualtePriceAfterOrder(overallToysOrdered, numberToysOrdered, pricesOfToys);

            if (result>=tripPrice)
            {
                Console.WriteLine($"Yes! {result-tripPrice} lv left.");
            }
            else
            {
                Console.WriteLine($"Not enough money! {result} lv needed.");
            }
        }

        private static void FillDictioanryWithPrices(Dictionary<string,double> pricesOfToys)
        {
            pricesOfToys.Add("Puzzle", 2.60);
            pricesOfToys.Add("Talking doll", 3.0);
            pricesOfToys.Add("Stuffed Teddy", 4.10);
            pricesOfToys.Add("Minion", 8.20);
            pricesOfToys.Add("Truck", 2.0);
        }

        private static double CalcualtePriceAfterOrder(int overallToysOrdered,Dictionary<string,int> numberToysOrdered,Dictionary<string,double> toyPrices)
        {
            double totalEarnings = 0;

            foreach(var item in numberToysOrdered)
            {
                totalEarnings += item.Value * toyPrices[item.Key];
            }
            totalEarnings = Math.Round(totalEarnings);
        
            if(overallToysOrdered>=50)
            {            
                totalEarnings -= totalEarnings * 0.25; 
                totalEarnings -= totalEarnings * 0.10;        
            }
            else
            {
               totalEarnings -= totalEarnings * 0.10;
            }

            return totalEarnings;
        }

    }
}
