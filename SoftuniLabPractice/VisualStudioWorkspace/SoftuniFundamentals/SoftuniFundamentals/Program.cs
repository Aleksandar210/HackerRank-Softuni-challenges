
using SoftuniFundamentals.TelerikDefClassesPartTwo;
using SoftuniFundamentals.TelerikGSMTask;
using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Diagnostics;
using System.Linq;
using System.Reflection.PortableExecutable;
using System.Runtime.Intrinsics.X86;
using System.Text;
using System.Text.RegularExpressions;
using System.Transactions;

namespace SoftuniFundamentals
{
    class Program
    {
        static void Main(string[] args)
        {
             SoftuniTasks currentTasks = new SoftuniTasks();
            //currentTasks.Rotation();
            //currentTasks.EqualSums();
            //currentTasks.KaminoFactory();
            //currentTasks.LadyBug();
            //currentTasks.SongTask();
            //currentTasks.SecretMessage();
            //currentTasks.MixingRules();
            //currentTasks.DrumSet();
            //currentTasks.WordSynonims();
            //currentTasks.TopThree();
            //currentTasks.DataTypes();
            //currentTasks.CenterPoint();
            //currentTasks.Tribonachi();
            //currentTasks.AddAndSubstract();
            //currentTasks.CharactesInRange('a','z');
            //currentTasks.SmallestOfThree(Console.ReadLine().Split().Select(int.Parse).ToArray());
            //currentTasks.NxN(int.Parse(Console.ReadLine()));
            //currentTasks.Palindrom();
            //currentTasks.TopNumber();
            //currentTasks.AddAndSubstract();
            //currentTasks.ArrayManipulating();
            //currentTasks.Resources();
            //currentTasks.LegendaryFarming();
            //currentTasks.Products();
            //currentTasks.CarParking();
            //currentTasks.CoursesNames();
            //currentTasks.StudentGrades();
            //TelericGSMTask();
            //GenericListTask();
            //currentTasks.CompanyTask();
            //currentTasks.ForceUsers();
            //currentTasks.JudgeSubmisions();
            //currentTasks.DragonArmyHeroesIIIFundamentals();
            //urrentTasks.SpellingBee();
            //currentTasks.SecretChat();
            //currentTasks.NeefForSpeedExamTask();
            //currentTasks.NationalCourt();
            //currentTasks.ShopingListTask();
            //currentTasks.HearthDelviery();
            //SoftuniadaStarClusterTask();
            //SimpleStackCalc();
            //currentTasks.StackSum();
            //currentTasks.GetBracketContents();

            // currentTasks.Bombs();

            //some algorithm 
            //-------------------------------------------------------------------
            // string currentInput = Console.ReadLine();
            //  Regex currentRegex = new Regex("\\(");

            //  Stack<int> currentOpeningBracketsIndexes = new Stack<int>();
            //  Stack<int> currentClosingBraketsIndexes = new Stack<int>();

            // foreach(Match item in currentRegex.Matches(currentInput))
            // {
            //     currentOpeningBracketsIndexes.Push(item.Index);

            //  }

            //  foreach(Match item in currentRegex.Matches("\\)"))
            // {
            //     currentClosingBraketsIndexes.Push(item.Index);
            //  }
            //  currentClosingBraketsIndexes.Reverse();

            // string input = Console.ReadLine();
            //  int start = input.IndexOf("(");
            // int end = input.IndexOf(")");
            // Console.WriteLine(input.Substring(start, end+1));
            //--------------------------------------------------------------------



            //1
            //currentTasks.SelectionSort();

            //currentTasks.Best2x2Matrix();


            // string enterNumbers = Console.ReadLine();
            // int[] numbers = enterNumbers.Trim().Split().Select(e => int.Parse(e)).ToArray();
            // List<int> allNumbersOnce = new List<int>();
            //
            // for(int i = 0; i < numbers.Length; i++)
            // {
            //   if (allNumbersOnce.Count != 0)
            //   {
            //     if (!allNumbersOnce.Contains(numbers[i]))
            //     {
            //      allNumbersOnce.Add(numbers[i]);
            //    }
            //  }
            // else
            //  {
            //     allNumbersOnce.Add(numbers[i]);
            // }
            // } 


            // int[,] currentMatrix = new int[,]       // the Matrix
            // {
            //   { 1, 2, 3, 4, 5 },
            //   { 2, 3, 4, 5, 6 },
            //   { 1, 1, 1, 1, 1 },
            //   { 2, 2, 2, 2, 2 } 
            // };


            //int[] currentIndexLocation = Console.ReadLine().Split().Select(e => int.Parse(e)).ToArray();


            // if((currentIndexLocation[0]>0 && currentIndexLocation[0]<currentMatrix.GetLength(0)) 
            //     && (currentIndexLocation[1]>0 && currentIndexLocation[1] < currentMatrix.GetLength(1)))
            // {
            // UpperRightDiagonal(currentMatrix, currentIndexLocation);
            //  UpperLeftDiagonal(currentMatrix, currentIndexLocation);
            //   DownLeftDiagonal(currentMatrix, currentIndexLocation);
            //   DownRightDiagonal(currentMatrix, currentIndexLocation);
            //}
            //  else if(currentIndexLocation[0]==0 && currentIndexLocation[1] < currentMatrix.GetLength(1))
            //  {
            //      DownRightDiagonal(currentMatrix, currentIndexLocation);
            //  }
            // else if (currentIndexLocation[0]== currentMatrix.GetLength(0) && currentIndexLocation[1]!=currentMatrix.GetLength(1))
            // {
            //     UpperRightDiagonal(currentMatrix, currentIndexLocation);
            // }
            // else if((currentIndexLocation[0]!=0 && currentIndexLocation[0]!=currentMatrix.GetLength(0)) 
            //    && currentIndexLocation[1] == 0)
            // {
            //    UpperRightDiagonal(currentMatrix, currentIndexLocation);
            //    DownRightDiagonal(currentMatrix, currentIndexLocation);
            // }
            // else
            // {

            //}
            //  Console.WriteLine("Enter size: ");
            //  int enterDimensions = int.Parse(Console.ReadLine());
            // 
            //  Console.Clear();
            //  char[,] currentMatrix = new char[enterDimensions,enterDimensions];
            //
            //  for(int i = 0; i < currentMatrix.GetLength(0); i++)
            //  {
            //      Console.Write("Enter {0} chars (x/o): ", currentMatrix.GetLength(1));
            //     char[] currentChars = Console.ReadLine().Split(" ").Select(e => e[0]).ToArray();
            //     for(int z = 0; z < currentMatrix.GetLength(1); z++)
            //    {
            //       currentMatrix[i, z] = currentChars[z];
            //   }
            //    Console.Clear();
            //}

            //   for(int i = 0; i < currentMatrix.GetLength(0); i++)
            //  {
            //     for(int j = 0; j < currentMatrix.GetLength(1); j++)
            //     {
            //        Console.Write(currentMatrix[i, j] + " ");
            //     }
            //    Console.WriteLine();
            // }

            //int[] arrayWithNumbers = Console.ReadLine().Split().Select(e => int.Parse(e)).ToArray();
           // SortBuble(arrayWithNumbers);

            StringBuilder sb = new StringBuilder();


            //Testing MinPosFinderMethod
           // Console.WriteLine(FindMinElementIndex(Console.ReadLine().Split().Select(e => int.Parse(e)).ToArray(), 0));


           // for(int i = 0; i < arrayWithNumbers.Length; i++)          // testing Buble sort
           // {
           //     sb.Append(arrayWithNumbers[i] + " ");
          //  }
          // Console.WriteLine(sb.ToString().Trim());
           



        }




        //Sorting Algorithms
        //-----------------------------------------------------------

            //Exchange Values in Array Method
         private static void ExchangeValues(int[] array, int biggestValIndex, int lowestValIndex)
        {
            int temp = array[biggestValIndex];
            array[biggestValIndex] = array[lowestValIndex];
            array[lowestValIndex] = temp;

        }


            //Buble sort
        private static void SortBuble(int[] arrayWithNumbers)
        {
            int Length = arrayWithNumbers.Length;

            for(int i = Length - 1; i > 0; i--)     //we start from the last element to the first
            {
                for (int j = 0; j < i; j++)      //then we begin from the first to the last and swap the biggest of two to the right
                {
                    if (arrayWithNumbers[j] > arrayWithNumbers[j + 1])
                    { 
                    ExchangeValues(arrayWithNumbers, j, j + 1);
                    }

                }

            }
        }

        private static int FindMinElementIndex(int[] array, int startFromIndex)
        {
            
            int minPosIndex = startFromIndex;
            for(int pos = startFromIndex += 1; pos < array.Length; pos++)
            {
                if (array[pos] < array[minPosIndex])
                {
                    minPosIndex = pos;
                }
            }

            return minPosIndex;

        }

        private static void SelectionSortAlg(int[] arrayWithNumbers)
        {


        }

            //---------------------------------------------------------




        //Diagonals
        //----------------------------------------------------------------------------


        private static void UpperRightDiagonal(int[,] currentMatrix, int[] location)
        {
            int[] currentLocation = new int[2];
            currentLocation[0] = location[0];
            currentLocation[1] = location[1];

            do
            {
                currentLocation[0]--;
                currentLocation[1]++;
                Console.Write(currentMatrix[currentLocation[0], currentLocation[1]]);
            } while (currentLocation[0]!= 0 && currentLocation[1]!= currentMatrix.GetLength(1));
        }


        private static void UpperLeftDiagonal(int[,] currentMatrix, int[] location)
        {
            int[] currentLocation = new int[2];
            currentLocation[0] = location[0];
            currentLocation[1] = location[1];

            do
            {
                currentLocation[0]--;
                currentLocation[1]--;
                Console.Write(currentMatrix[currentLocation[0], currentLocation[1]]);
            } while (currentLocation[0] != 0 && currentLocation[1] != 0);

        }



        private static void DownRightDiagonal(int[,] currentMatrix, int[] location)
        {
            int[] currentLocation = new int[2];
            currentLocation[0] = location[0];
            currentLocation[1] = location[1];

            do
            {
                currentLocation[0]++;
                currentLocation[1]++;
                Console.Write(currentMatrix[currentLocation[0], currentLocation[1]]);
            } while (currentLocation[0] != currentMatrix.GetLength(1) && currentLocation[1] != currentMatrix.GetLength(1));
        }

       

        private static void DownLeftDiagonal(int[,] currentMatrix, int[] location)
        {
            int[] currentLocation = new int[2];
            currentLocation[0] = location[0];
            currentLocation[1] = location[1];

            do
            {
                currentLocation[0]++;
                currentLocation[1]--;
                Console.Write(currentMatrix[currentLocation[0], currentLocation[1]]);
            } while (currentLocation[0] != currentMatrix.GetLength(1) && currentLocation[1] != 0);
        }
        //-------------------------------------------------------------------------------------------




        //Calculator task
        //------------------------------------------------------------
        static void SimpleStackCalc()
        {
            string enterEquation = Console.ReadLine();
            Stack<string> currentStack = new Stack<string>(enterEquation.Split().Reverse());

            var result = int.Parse(currentStack.Pop());
            string currentSymbol="";

            while (currentStack.Any())
            {
                currentSymbol = currentStack.Pop();
                if(currentSymbol.Equals("+")|| currentSymbol.Equals("-"))
                {
                    switch (currentSymbol)
                    {
                        case "+":
                            result += int.Parse(currentStack.Pop());
                            break;
                        case "-":
                            result -= int.Parse(currentStack.Pop());
                            break;
                    }
                }
            }

            Console.WriteLine(result);
           
        }
        


         static void SoftuniadaStarClsuterTask()
        {
            int numberStarClusters = int.Parse(Console.ReadLine());
            Dictionary<string, Cluster> currentClusters = new Dictionary<string, Cluster>();
            
            AddClusterData(currentClusters, numberStarClusters);

            LinkedList<Star> currentStarsEntered = new LinkedList<Star>();

            string enterStarData = Console.ReadLine();
            StringBuilder sb = new StringBuilder();


            string[] allStarCoordinates;
            int[] coordinatesOfStar;


           while (!enterStarData.Equals("end",StringComparison.OrdinalIgnoreCase))
            {
                sb.Append(enterStarData);
                ReplaceInputSpacesWithSemicolon(sb);
                allStarCoordinates = sb.ToString().Split("!");
                foreach(var item in allStarCoordinates)
                {
                    coordinatesOfStar = item.Trim(new char[] { '(', ')' }).Replace(",", "").Split().Select(e => int.Parse(e))
                        .ToArray();
                    currentStarsEntered.AddFirst(new Star(coordinatesOfStar));
                }
                sb.Clear();
                enterStarData = Console.ReadLine();
                   
            }

           //Place Stars to theri closest cluster
           
           foreach(var item in currentStarsEntered)
            {
                item.CalculateDistanceFromGivenClusters(currentClusters);
                currentClusters[item.ClusterBelongsTo].AddStar(item);
            }

           foreach(var item in currentClusters)
            {
                Console.WriteLine($"{item.Key} with center {item.Value.CenterOfCluster} and with {item.Value.CountOfStars}");

            }



        }

        private static void ReplaceInputSpacesWithSemicolon(StringBuilder sb)
        {
            for(int i = 0; i < sb.Length; i++)
            {
                if (Char.IsWhiteSpace(sb[i]))
                {
                    if (!Char.IsDigit(sb[i + 1]))
                    {
                        sb[i] = '!';
                    }
                }
            }
        }

        private static void AddClusterData(Dictionary<string,Cluster> currentClusters,int numberClusters)
        {
            string enterClusterData;
            string[] collectClusterData;
            
            Cluster currentCluster = null;
            int[] clusterCoordinates;
            char[] trimBy =  { '(', ')' };
            for(int i = 0; i < numberClusters; i++)
            {
                enterClusterData = Console.ReadLine();
                collectClusterData = enterClusterData.Split(new char[] { ' ' }, 2, StringSplitOptions.RemoveEmptyEntries);
                
                if (!currentClusters.ContainsKey(collectClusterData[0]))
                {
                    clusterCoordinates = collectClusterData[1].Trim(trimBy).Replace(",", "").Split().Select(e => int.Parse(e)).ToArray();
                    currentCluster = new Cluster(collectClusterData[0], clusterCoordinates);
                    currentClusters.Add(collectClusterData[0], currentCluster);
                }

            }


        }



        private static void GenericListTask()
        {
            GenericList<int> currentList = new GenericList<int>();
            currentList.Add(4);
            currentList.Add(5);
            currentList.RemoveAll();
            Console.WriteLine(currentList.Count);




        }


        





        //Phone task
        //-------------------------------------------------------------------------------------------------

        private static void TelericGSMTask()
        {
            Console.Write("Enter name: ");
            string name = Console.ReadLine();
            Dictionary<string,GSM> currentGSM = new Dictionary<string,GSM>();

            GSM_Creation(currentGSM);
            Console.WriteLine("Goodbye {0}", name);
        }

        private static void GSM_Creation(Dictionary<string,GSM> currentGSM)
        {
            Console.Clear();
            bool exit = false;
            GSM currentSelected = null;
            while (exit == false)
            {
                Console.Clear();
                Console.WriteLine("1|Add GSM");
                Console.WriteLine("2|Remove GSM");
                Console.WriteLine("3|Enter Number");
                Console.WriteLine("4|GSM Operations");
                Console.WriteLine("5|Exit");
                Console.Write("Select: ");
                int select = int.Parse(Console.ReadLine());
                switch (select)
                {
                    case 1:
                        AddCell(currentGSM);
                        break;
                    case 2:
                        RemoveCell(currentGSM);
                        break;
                    case 3:
                        do
                        {
                            Console.Clear();
                            Console.Write("Enter Number: ");
                            string enterCell = Console.ReadLine();
                            if (currentGSM.ContainsKey(enterCell))
                            {
                                currentSelected = currentGSM[enterCell];
                                break;
                            }
                        }
                        while (true);
                        break;
                    case 4:
                        if (currentSelected == null)
                        {

                        }
                        else
                        {
                            GSM_Operations(currentSelected);
                        }
                        
                        break;

                    case 5:
                        exit = true;
                        break;

                }
                
            }

        }

        private static void GSM_Operations(GSM currentPhone)
        {
            
            while (true)
            {
                Console.Clear();
                Console.WriteLine("1|Dial");
                Console.WriteLine("2|Delete Calls");
                Console.WriteLine("3|Show History");
                Console.WriteLine("4|Exit");
                Console.Write("   Select: ");
                int select = int.Parse(Console.ReadLine());
                switch (select)
                {
                    case 1:
                        string entered="!";
                        Console.Clear();
              
                            do
                            {
                            Console.Write("Person you are calling:  ");

                          
                              string current = Console.ReadLine();
                            Console.Write("Phone number of  person: ");
                            string dialNumber = Console.ReadLine();

                             if (ValidatedCall(dialNumber) == true)
                             {
                             entered = current+" "+dialNumber;
                             }
                          
                            }
                            while (!entered.Equals("!"));
                        
                        currentPhone.AddCall(entered.Split());
                        do
                        {
                            Console.Clear();
                            Console.WriteLine("You are currently in a Call");
                            Console.WriteLine("Press 0 to end the call");
                            int enterNumber = int.Parse(Console.ReadLine());
                            if (enterNumber == 0)
                            {
                                currentPhone.TerminateCall();
                                
                            }

                        }
                        while (currentPhone.InCall==true);
                        break;
                    case 2:
                        Console.Clear();
                        currentPhone.DeleteCall();
                        break;
                    case 3:
                        Console.Clear();
                        currentPhone.ShowHisotry();
                        Console.ReadLine();
                        break;
                    case 4:
                        return;
                        
                    default:

                        break;
                }
            }
        }

        
        private static bool ValidatedCall(
            string entered)
        {
            Regex currentRegex = new Regex("[0-9]{10}");
            if(entered.Contains(" "))
            {
                if (currentRegex.IsMatch(entered.Split()[0]))
                {
                    return true;
                }
                else
                {
                    return false;
                }
            }
            else
            {
                if (currentRegex.IsMatch(entered))
                {
                    return true;
                }
                else
                {
                    return false;
                }
            }

            
        }

      

        private static void RemoveCell(Dictionary<string,GSM> currentPhones)
        {
            Console.Clear();
            bool canceled = false;
            Dictionary<int, string> currentPhonesOrdered = new Dictionary<int, string>();
            
            int counter = 1;
            foreach(var item in currentPhones)
            {
               
                Console.WriteLine(counter+" "+item);
                currentPhonesOrdered.Add(counter, item.Key);
               
                counter+=1;
            }
            Console.WriteLine((counter + 1)+" Cancel");
            int select;
            do
            {
                select = int.Parse(Console.ReadLine());
                if (select == counter + 1)
                {
                    return;
                }
                else if(select<0 || select > counter + 1)
                {

                }
                else
                {
                    currentPhones.Remove(currentPhonesOrdered[select]);
                    currentPhonesOrdered.Remove(select);
                    RemoveCellSubRemoveMethod(currentPhonesOrdered, currentPhones);
                    return;

                }
            }
            while (canceled==false);

        }

        private static void RemoveCellSubRemoveMethod(Dictionary<int,string> currentNotRemovedPhones,Dictionary<string,GSM> currentPhones)
        {
            Console.Clear();
            int counter = 1;
            foreach(var item in currentPhones)
            {
                Console.WriteLine(counter);
                Console.WriteLine("--------------------");
                Console.WriteLine(item);
                Console.WriteLine("--------------------");
                Console.WriteLine();
                counter++;
            }
            Console.WriteLine((counter + 1) + " Cancel");
            int select;
            do
            {
                select = int.Parse(Console.ReadLine());
                if (select < 1 || select>counter+1)
                {

                }
                else if (select == counter + 1)
                {
                    return;
                }
                else
                {
                    currentPhones.Remove(currentNotRemovedPhones[select]);
                    currentNotRemovedPhones.Remove(select);
                    RemoveCellSubRemoveMethod(currentNotRemovedPhones, currentPhones);

                }
            }
            while (true);
        }

        private static void AddCell(Dictionary<string,GSM> currentPhones)
        {
            GSM currentPhone = new GSM();

            string model;
            string manufacturer;
            string name;
            string number;


            Console.Clear();
                try
                {
                    Console.Write("Model:");
                     model = Console.ReadLine();
                    currentPhone.Model = model;
                }
                catch (ArgumentException argument)
                {
                ReEnter(argument.Message, currentPhone);
                }



            try
            {
                Console.Write("Manufacturer: ");
                manufacturer = Console.ReadLine();
                currentPhone.Manufacturer = manufacturer;
            }
            catch (ArgumentException argument)
            {
                ReEnter(argument.Message, currentPhone);
            }



            try
            {
                Console.Write("Name: ");
                name = Console.ReadLine();
                currentPhone.OwnerName = name;
            }
            catch (ArgumentException argument)
            {
                ReEnter(argument.Message, currentPhone);
            }




            try
            {
                Console.Write("Number :");
                number = Console.ReadLine();
                currentPhone.CurrentNumber = number;
                if (currentPhones.ContainsKey(number))
                {
                    Console.WriteLine("Phone already is regeistered!");
                    Console.WriteLine("Press Enter to reEnter it!");
                    Console.ReadLine();
                    ReEnter("number", currentPhone);

                }
               
            }
            catch (ArgumentException argument)
            {
                ReEnter(argument.Message, currentPhone);
            }


            Console.Write("BatteryType: ");
                string enterBattery = Console.ReadLine();


            currentPhones.Add(currentPhone.CurrentNumber, currentPhone);

        }

        private static void ReEnter(string warningMessage,GSM currentPhone)
        {
            if (warningMessage.Equals("number"))
            {
                try
                {
                    currentPhone.CurrentNumber = Console.ReadLine();
                    return;
                }
                catch (ArgumentException argumentExc)
                {
                    ReEnter("number", currentPhone);
                }
            }

            string reEntering = warningMessage.Split()[1];    
            bool current = false;
            Console.Clear();
            do
            {
                try
                {
                    Console.WriteLine(warningMessage);
                    Console.Write("Enter again: ");
                    switch (reEntering.ToLower())
                    {
                        case "model":
                            currentPhone.Model = Console.ReadLine();
                        break;
                        case "manufacturer":
                            currentPhone.Manufacturer = Console.ReadLine();
                            break;
                        case "number":
                            currentPhone.CurrentNumber = Console.ReadLine();
                            break;
                        case "name":
                            currentPhone.OwnerName = Console.ReadLine();
                            break;
                        
                           
                    }
                    current = true;
                }
                catch (ArgumentException currentArgument)
                {
                    ReEnter(warningMessage,currentPhone);
                }

            }
            while (current == false);

            
        }
        //-------------------------------------------------------------------------------------------------




    }
    public class Cluster
    {
        
        private int[] coordinates;
        private LinkedList<Star> currentStarsInCluster;

        public Cluster(string name,params int[] coordiantes)
        {

            this.Name = name;
           
        }
        private void setCoordinates(int[] currentCoordinates)
        {
            this.coordinates[0] = currentCoordinates[0];
            this.coordinates[1] = currentCoordinates[1];

        }
        public void AddStar(Star star)
        {
            this.currentStarsInCluster.AddFirst(star);

        }

        private void CaclulateCenter()
        {
            int x=0;
            int y=0;
            foreach(var item in this.currentStarsInCluster)
            {
                x+=item.Coordinates[0];
                y += item.Coordinates[1];
            }

            x /= this.currentStarsInCluster.Count;
            y /= this.currentStarsInCluster.Count;
            this.CenterOfCluster = new int[] { x, y };

        }

        public int[] CenterOfCluster { get; private set; }



        public string Name { get; private set; }

        public int[] Coordinates
        {
            get
            {
                return this.coordinates;
            }
        }

        public int CountOfStars
        {
            get
            {
                return this.currentStarsInCluster.Count;
            }
        }

    }

    public class Star
    {
       
        
      


        public Star(int[] coordinates)
        {
            this.Coordinates = new int[]{ coordinates[0],coordinates[1]};
            
            
        }

        public void CalculateDistanceFromGivenClusters(Dictionary<string,Cluster> currentClusters)
        {
            double minDistanceToCluster= double.MaxValue;
            string nameOfClusterMinDistance=" ";

            double currentDistance;
            foreach(var item in currentClusters)
            {
                currentDistance = Math.Sqrt(Math.Pow(this.Coordinates[0] - item.Value.Coordinates[0], 2) + Math.Pow(this.Coordinates[1] - item.Value.Coordinates[1], 2));
                if (currentDistance<minDistanceToCluster)
                {
                    minDistanceToCluster = currentDistance;
                    nameOfClusterMinDistance = item.Value.Name;
                }
            }

            ClusterBelongsTo = nameOfClusterMinDistance;
        }
        public int[] Coordinates { get; private set; }

        public string ClusterBelongsTo { get;  private set; }
    }
}
