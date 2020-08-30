

using SoftuniFundamentals.TelerikDefClassesPartTwo;
using SoftuniFundamentals.TelerikGSMTask;
using System;
using System.Collections.Generic;
using System.IO;
using System.Linq;
using System.Text;
using System.Text.RegularExpressions;

//this will reference everything from that folder when used directly without specifing from where
using SoftuniFundamentals.Csharp_Advanced_Classes;
using System.Runtime.InteropServices;
using System.Runtime.CompilerServices;
using System.Threading.Tasks.Dataflow;
using SoftuniFundamentals.TelerikCompProgrammingFolder;
using System.Net.Sockets;
using System.Xml.Serialization;
using MoreLinq;
using MoreLinq.Extensions;
using SoftuniFundamentals.SantaOOPTask2019;
using System.Collections.ObjectModel;
using SoftuniFundamentals.Csharp_Advanced_Classes.StorageMaster2019;

namespace SoftuniFundamentals
{
    class Program
    {
        static void Main(string[] args)
        {
            // SoftuniTasks currentTasks = new SoftuniTasks();
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
            // NameSumChars(currentSumCharsFunc);
            //ForbidenWords();
            //BombHostagesJoker();
            //SoftuiParkingDefinignClasses();
            //CarDriveDistanceDefiningClases();
            //RawDataCarDefinignClasses();
            //ReVolt();
            //GuildWar();
            // BookWormQuest();
            //RabbitTask();
            //JediGlaxy();
            // currentTasks.Bombs();
            // HospitalRegistration();
            //SamSneak();
            //FootballTask();

            //some algorithm for balaned paranthesis task ()->yes ({)->no
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

            //  int[] arrayWithNumbers = Console.ReadLine().Split().Select(e => int.Parse(e)).ToArray();
            //, merge sort, quick sort, shell sort,


            // SortBuble(arrayWithNumbers);
            //SelectionSortAlg(arrayWithNumbers);
            //CountingSort


            // StringBuilder sb = new StringBuilder();


            //TEST1 (MIN ELEM)
            //Testing MinPosFinderMethod
            // Console.WriteLine(FindMinElementIndex(Console.ReadLine().Split().Select(e => int.Parse(e)).ToArray(), 0));


            //Test(CountSort)
            //CountingSort(arrayWithNumbers);

            //getting the sum of array
            //int countingSum = arrayWithNumbers.Aggregate((a, b) => a + b);

            //Console.WriteLine(countingSum);


            //unfinishedCode
            //int[,] currentRanges = new int[numberBuckers,]



            // for(int i = 0; i < currentRanges.Count - 1; i++)
            //  {
            //     Console.Write(currentRanges[i] + "," + currentRanges[i + 1] + "| ");
            // }


            //  for(int i = 0; i < arrayWithNumbers.Length; i++)          // testing Buble sort
            //   {
            //       sb.Append(arrayWithNumbers[i] + " ");
            //  }
            //  Console.WriteLine(sb.ToString().Trim());

            //PolindromeWords();
            // StudentBonuses();
            // ShopProducts();
            //EmojiFinder();
            //Pirates();
            //  string currentString = "::Emoji:*:";

            //GET ASCI VALUES OF CAHR SUM
            //int result = currentString.ToCharArray().Select(e=>(int)e).Aggregate((a, b) => a + b);
            //Console.WriteLine(result);

            //Algortihm Linq for adding key value with selet while creating array
            // Dictionary<double, int> currentCountOfNumbers = new Dictionary<double, int>();
            // var numbers = Console.ReadLine().Split()
            //    .Select(e =>
            //     {
            //       double element = double.Parse(e);
            //   if (currentCountOfNumbers.ContainsKey(element))
            //   {
            //       currentCountOfNumbers[element]++;
            //   }
            //   else
            //   {
            //       currentCountOfNumbers.Add(element, 1);
            //    }

            //   return element;
            //   }

            //  ).ToArray();

            //  VlogerTask();
            // ParkingLot();
            //  Ranking();

            //ReadOddLines();
            //AddNumericsToFileLines();
            //WordsCount();

            // EvenNumbersLinq();

            //func to parse all elements and return count and sum
            // Func<string, int[]> currentFuncParseSum = elements =>
            //  elements.Split(", ", StringSplitOptions.RemoveEmptyEntries).Select(elements => int.Parse(elements)).ToArray();
            //int[] result = currentFuncParseSum(Console.ReadLine());
            // int[] currentSumAndCount = new int[2];
            //currentSumAndCount[0] = result.Sum();
            //currentSumAndCount[1] = result.Length;
            //Console.WriteLine($"Sum {currentSumAndCount[0]} Count of elements {currentSumAndCount[1]}");

            //Print upper words
            // Func<string, string[]> currentUpperFunc = sentence => sentence.Split(" ", StringSplitOptions.RemoveEmptyEntries)
            //  .Where(w => char.IsUpper(w[0]))
            // .ToArray();

            // Console.WriteLine(String.Join(" ", currentUpperFunc(Console.ReadLine())));

            //read data and add 0% VAT
            // Func<string, double[]> currentVatFunc = number => number.Split(", ", StringSplitOptions.RemoveEmptyEntries)
            // .Select(e => double.Parse(e) * 1.2)
            // .ToArray();


            //  StringBuilder sb = new StringBuilder();
            // foreach(var item in currentVatFunc(Console.ReadLine()))
            //{
            //    sb.Append(item + Environment.NewLine);

            //}
            //Console.WriteLine(sb.ToString());

            //FilterByAgeLinq()

            //print collection on new lines linq and action
            // StringBuilder sb = new StringBuilder();
            // Action<string> addCurrentNameToSb = name => sb.Append(name + Environment.NewLine);

            // Console.ReadLine().Split(" ", StringSplitOptions.RemoveEmptyEntries)
            //    .Select(e => { addCurrentNameToSb(e); return e; });
            // Console.WriteLine(sb.ToString());


            //KnightsOfHonor
            //StringBuilder sb = new StringBuilder();
            // Action<string> appendSir = e => sb.Append("sir " + e + Environment.NewLine);
            //Console.ReadLine().Split().ToList().ForEach(e => appendSir(e));
            //Console.WriteLine(sb.ToString());

            //UpperLowerBoundEvenOddLine();
            //AppliedArithmetics();
            //PredicateByNames();
            //ReverseFilter()
            // CustomComparator();
            //DivisibleRangeOfSequeneLinq();
            //PartyIvancho();
            //PartyFilterSoftware();


            //function related to the last task of LINQ
            // Func<string, int, bool> currentSumCharsFunc = (word, targetSum) =>
            //  {
            //     int sum = 0;
            //    foreach (var item in word.ToCharArray())
            //   {
            //       sum += item;
            //   }

            //  if (sum >= targetSum)
            //  {
            //      return true;
            //  }

            //  return false;
            //  };


            //AnAmazingRace();      //work in progress
            //Numbers();
            //SandClockTelerikAlgo();
            //ShepardTask();
            //SantaShopTask();

            //EXPERIMENT FOR SANTA TASK

            //Dwarf current = new SleepyDwarf("Sashko");
            //Dwarf anotherCurrent = new SleepyDwarf("Stamat");
            //Dwarf anotherMoreCurrent = new HappyDwarf("Nasko");
            //Dwarf moreDwarfs = new HappyDwarf("bAGO");
            //List<IDwarf> currentDwarfs = new List<IDwarf>();
            //currentDwarfs.Add(current);
            //currentDwarfs.Add(anotherCurrent);

            //Console.WriteLine(RemoveDwarf(currentDwarfs, current));
            //Console.WriteLine(RemoveDwarf(currentDwarfs, moreDwarfs));
            //Console.WriteLine(RemoveDwarf(currentDwarfs, anotherCurrent));      //works



            //List<int> numbers = new List<int>();        //this is the inner collection of the class
            //numbers.Add(100);
            //ReadOnlyCollection<int> current = new ReadOnlyCollection<int>(numbers);
            //var item = current[0];
            //Console.WriteLine(item);

            //var item = new Warehouse("Hello");
            //to get type name GetType().Name



        }

        //StorageMaster task
        private static void StorageMasterTask2019OOP()
        {
            StorageMaster currentMaster = new StorageMaster();
            string enterInput;
            string[] temp;

            enterInput = Console.ReadLine();
            while(!enterInput.Equals("End",StringComparison.OrdinalIgnoreCase))
            {
                enterInput = Console.ReadLine();
                temp = enterInput.Split(" ", StringSplitOptions.RemoveEmptyEntries).ToArray();
                try
                {
                    ExecuteStorageCommand(currentMaster, temp);
                }
                catch(Exception ex)
                {
                    Console.WriteLine(ex.Message);
                }
            }
        }
        private static void ExecuteStorageCommand(StorageMaster master,params string[] currentData)
        {
            switch(currentData[0].ToLower())
            {
                case "addproduct":
                    master.AddProduct(currentData[1], double.Parse(currentData[2]));
                    break;
                case "registerstorage":
                    master.RegisterStorage(currentData[1], currentData[2]);
                    break;
                case "selectvehicle":
                    master.SelectVehicle(currentData[1], int.Parse(currentData[2]));
                    break;
                case "sendvehiclto":
                   Console.WriteLine(master.SendVehicleTo(currentData[1], int.Parse(currentData[2]), currentData[3]));
                    break;
                case "unloadvehicle":
                    master.UnloadVehicle(currentData[1], int.Parse(currentData[2]));
                    break;
            }
        }

        //Santa Shop task
        private static void SantaShopTask()
        {
            SantaOOPTask2019.Engine currentEngine = new SantaOOPTask2019.Engine();

            while(!currentEngine.IsExit)
            {
                currentEngine.ReadInput(Console.ReadLine());
            }

        }
        

        //experiment
        private static bool RemoveDwarf(List<IDwarf> currentDwarfs,IDwarf toRemove)
        {
            if(currentDwarfs.Contains(toRemove))
            {
                return true;
            }
            else
            {
                return false;
            }
        }
      
       

        //an amazing race task
        private static void AnAmazingRace()
        {
            HashSet<char> notCheckPointChars = new HashSet<char>(new char[] { '~', '#' }); 
           
            StringBuilder sb = new StringBuilder();
            int[] initialInput = Console.ReadLine().Split(" ", StringSplitOptions.RemoveEmptyEntries).Select(int.Parse).ToArray();
            
            int row = initialInput[0];
            int col = initialInput[1];
            int numberCheckpoints = initialInput[2];
            char[,] currentLand = new char[row,col];
            
            for(int i =0;i<currentLand.GetLength(0);i++)
            {
                EnterDataLand(i, sb, currentLand);
            }
            Console.Clear();
            Console.WriteLine(sb.ToString());       //for find path
        }

        private static void FindPath(char[,] currentLand,Dictionary<char,string> currentCheckPoints)        //reverse the Dictionary
        {
            //use algorithm for maze tracking maybe
        }

        private static void EnterDataLand(int row,StringBuilder sb, char[,] land)
        {
            string enterData;
            do
            {
                Console.Clear();
                if(sb.Length>0)
                {
                    Console.WriteLine(sb.ToString());
                }
                enterData = Console.ReadLine();
            }
            while (enterData.Length!=land.GetLength(1));


            for(int i =0;i<land.GetLength(1);i++)
            {
                land[row, i] = enterData[i];
            }
            sb.Append(enterData + Environment.NewLine);
        }

       

        //Telerik Algo
        //-----------------------------------------------------------------------------------

            //for experiments
        private static double GetEuclidianDistance(int[] firstPair, int[] secondPair)
        {
            return Math.Sqrt(Math.Pow(firstPair[0] - secondPair[0], 2) + Math.Pow(firstPair[1] - secondPair[1], 2));
        }

        //LightCalculator
        private static void LightCalcTask()
        {
            Dictionary<string,int> currentSegmentCombinations = new Dictionary<string,int>();
            AddSegmentCombinations(currentSegmentCombinations);
            int enterNumberOfSegments = int.Parse(Console.ReadLine());
            int[][] enteredSegments = new int[enterNumberOfSegments][];
            for(int i =0;i<enterNumberOfSegments;i++)
            {
                Console.Clear();
                if(!EnterSegmentInArray(enteredSegments, i))
                {
                    i--;
                }
            }

            for(int i =0;i<enteredSegments.Length;i++)
            {
               int[] temp =  enteredSegments[i];
            }
            
        }

        private static bool EnterSegmentInArray(int[][] segments,int index)
        {
            Console.Write("Enter segments: ");
            int[] segment = Console.ReadLine().Select(e=>(int)e-'0').ToArray();
           if(segment.Length==7)
            {
               if(segment.Aggregate((a,b)=>a+b)<=7)
                {
                    segments[index] = segment;
                    return true;
                }
                else
                {
                    return false;
                }
            }
            else
            {
                return false;
            }
        }

        private static void AddSegmentCombinations(Dictionary<string,int> currentDict)
        {
            currentDict.Add("1111110",0);
            currentDict.Add("0110000",1);
            currentDict.Add("1101101",2);
            currentDict.Add("1111001",3);
            currentDict.Add("0110011",4);
            currentDict.Add("1011011",5);
            currentDict.Add("1011111",6);
            currentDict.Add("1110000",7);
            currentDict.Add("1111111",8);
            currentDict.Add("1111011",9);
        }

        //Shepard Task
        private static void ShepardTask()
        {
            int[] enterFencesAndSheeps;
            do
            {
                Console.Clear();
                enterFencesAndSheeps = Console.ReadLine().Split(" ", StringSplitOptions.RemoveEmptyEntries)
                    .Select(int.Parse).ToArray();
            } while ((enterFencesAndSheeps[0] > 0 && enterFencesAndSheeps[0] < 101) &&
            enterFencesAndSheeps[1] > 0 && enterFencesAndSheeps[1] < 101);

            List<Fence> fences = new List<Fence>();

            Fence currentFence = null;
            int[] enterCoordinates;
            for(int i =0;i<enterFencesAndSheeps[0];i++)
            {
                enterCoordinates = Console.ReadLine().Split(" ", StringSplitOptions.RemoveEmptyEntries)
                     .Select(int.Parse).ToArray();
                currentFence = new Fence(new int[] { enterCoordinates[0], enterCoordinates[1] },
                    new int[] { enterCoordinates[2], enterCoordinates[1] }, new int[] { enterCoordinates[2], enterCoordinates[3] },
                    new int[] { enterCoordinates[0], enterCoordinates[3] });
                fences.Add(currentFence);
                
            }

            Dictionary<string, int[]> currentSheeps = new Dictionary<string, int[]>();
            string enterSheepCoordinates;
            for(int i =0;i<enterFencesAndSheeps[1];i++)
            {
                enterSheepCoordinates = Console.ReadLine();
                currentSheeps.TryAdd(enterSheepCoordinates, enterSheepCoordinates.Split(" ", StringSplitOptions.RemoveEmptyEntries)
                    .Select(int.Parse).ToArray());
            }
            StringBuilder sb = new StringBuilder();
            sb.Append("Sheeps outside teh fences");
            bool hasBeenAddedToFence;
            foreach(var item in currentSheeps)
            {
                hasBeenAddedToFence = false;
                foreach(var fence in fences)
                {
                    if(fence.IsSheepInside(item.Value))
                    {
                        fence.AddSheepInsideFence(item.Key,currentSheeps);
                        hasBeenAddedToFence = true;
                        break;
                    }
                }
                if(!hasBeenAddedToFence)
                {
                    sb.Append(item.Key + Environment.NewLine);
                }
            }

            Console.WriteLine(sb.ToString());
           
        }


        //Numbers task
        private static void Numbers()
        {
            const int Limit = 10000000;

            int start;
            int end;
            int divisibleBy;
            int leftover;

            int[] input;
            do
            {
                Console.Clear();
                Console.Write("Enter: ");
                input = Console.ReadLine().Split(" ", StringSplitOptions.RemoveEmptyEntries)
                    .Select(int.Parse).ToArray();
                start = input[0];
                end = input[1];
                divisibleBy = input[2];
                leftover = input[3];
            }
            while ((end <= Limit && (start <= 1 && start <= end)) && (leftover <= Limit &&(divisibleBy <= 0 && divisibleBy < leftover)));

            List<int> numbersDivisiblBy = new List<int>();

            for(int i= start;i<end;i++)
            {
                if(i%divisibleBy==leftover)
                {
                    numbersDivisiblBy.Add(i);
                }
            }

            Console.Clear();
            Console.WriteLine(numbersDivisiblBy.Count);
            Console.WriteLine("The numbers are: {0}", String.Join(",", numbersDivisiblBy));

        }

        private static void SandClockTelerikAlgo()
        {
            StringBuilder sb = new StringBuilder();
            int enterNumber = int.Parse(Console.ReadLine());

            Console.Clear();
            int counter = enterNumber;
            int lineNumber = 0;
            while(counter>0)
            {
                switch(lineNumber)
                {
                    case 0:
                        sb.Append(drawStars(counter));
                        
                        sb.Append(Environment.NewLine);
                        lineNumber++;
                        counter -= 2;
                        break;
                    default:
                        sb.Append(drawDots(lineNumber) + drawStars(counter) + drawDots(lineNumber));
                        sb.Append(Environment.NewLine);
                        lineNumber++;
                        counter -= 2;
                        break;
                }
            }
            var result = sb.ToString().Split(Environment.NewLine, StringSplitOptions.None);

            Array.Reverse(result);
            for (int i = 2; i < result.Length; i++)
            {
                sb.Append(result[i]);
                sb.Append(Environment.NewLine);
            }

            Console.WriteLine(sb.ToString());
        }

        private static Func<int, string> drawStars = (numberStars) =>
         {
             return new String('*', numberStars);
         };

        private static Func<int, string> drawDots = (numberDots) =>
         {
             return new String('.', numberDots);
         };
        //------------------------------------------------------------------------------------

        //FootbalPlyersTask
        private static void FootballTask()
        {
            Dictionary<string, FootballTeam> teams = new Dictionary<string, FootballTeam>();
            string command = Console.ReadLine();

            string[] gatherCommandData;

            while(!command.Equals("end",StringComparison.OrdinalIgnoreCase))
            {
                gatherCommandData = command.Split(";", StringSplitOptions.RemoveEmptyEntries);
                try
                {
                    ExecuteFootballTeamCommand(teams, gatherCommandData);
                }
                catch(ArgumentException exc)
                {
                    if (exc.Message.StartsWith("Player"))
                    {
                        Console.WriteLine(exc.Message);
                        continue;
                    }
                    else
                    {
                        continue;
                    }

                }
                
                command = Console.ReadLine();
            }


        }

        private static void ExecuteFootballTeamCommand(Dictionary<string,FootballTeam> teams,string[] data)
        {
            FootBallPlayer player = null;
            int[] playerStats;

            switch(data[0].ToLower())
            {
                case "team":
                    if(!teams.ContainsKey(data[1]))
                    {
                        teams.Add(data[0], new FootballTeam(data[0]));
                    }
                   
                    break;
                case "add":
                    if(!teams.ContainsKey(data[1]))
                    {
                        Console.WriteLine($"Team {data[1]} does not exist.");
                    }
                    else
                    {
                        if(!teams.ContainsKey(data[2]))
                        {
                            playerStats = new int[5];
                            int counter = 0;
                            for (int i = 3; i <= 7; i++)
                            {
                                playerStats[counter] = int.Parse(data[i]);
                                counter++;
                            }
                            player = new FootBallPlayer(data[2], playerStats);
                            teams[data[1]].AddPlayer(player);
                        }

                       

                    }
                    break;


                case "remove":
                    if(teams.ContainsKey(data[1]))
                    {
                        teams[data[1]].RemovePlayer(data[2]);
                    }
                    
                    break;
                case "rating":
                    if(teams.ContainsKey(data[1]))
                    {
                        Console.WriteLine($"{data[1]} - {teams[data[1]].Rating}");
                    }
                    else
                    {
                        Console.WriteLine($"Team {data[1]} does not exist");
                    }
                    break;
                default:

                    break;
            }
        }






        //GreedyTimes
        public static void GreedyTimes()
        {
            //entering capacity
            int bagCapacity = int.Parse(Console.ReadLine());

            //entering content of safe
            string enterContentOfSafe = Console.ReadLine();

            Dictionary<string, int> currentInventoryOfSpace = new Dictionary<string, int>();

            //split data and add it to the collection
            string[] safeContentData = enterContentOfSafe.Split(" ", StringSplitOptions.RemoveEmptyEntries);
            for(int i =0;i<safeContentData.Length;i++)
            {

            }

          

        }

        //SneakySam
        private static void SamSneak()
        {
            int numberRows = int.Parse(Console.ReadLine());
            char[][] currentRoom = new char[numberRows][];

            //Coordinates of NPC   
            List<int[]> currentNpcCoordinates = new List<int[]>();      //all npc minion coordinates

            //main character coordinates
            int[] samCoordinates = new int[2];

            //main enemy cooridnates
            int[] mainEnemyCoordinates = new int[2];

            //creating room
            string enterRowData;
            for(int i =0;i<numberRows;i++)
            {
                enterRowData = Console.ReadLine();
                PinPointCoordinates(i, enterRowData, currentNpcCoordinates, samCoordinates, mainEnemyCoordinates);
                currentRoom[i] = enterRowData.ToCharArray();
            }

            //enter Commands;
            Console.Clear();
            Console.Write("Enter Commands: ");
            string enterCommands = Console.ReadLine();
            ExecuteSamCommandMovement(enterCommands,currentRoom,currentNpcCoordinates,samCoordinates,mainEnemyCoordinates);

        }


        //kill npc
       static Action<List<int[]>, int[]> KillNPC = (npc, sam) =>
        {
            npc = npc.Where(n => n[0] != sam[0] && n[1] != sam[1]).ToList();
        };


        //Execute Commands 
        private static void ExecuteSamCommandMovement(string commands,char[][] currentRoom,List<int[]> currentNpc,int[] sam,int[] nik)
        {
            bool isSamDead = false;
            bool isNikDead = false;
           
            Action<char,int[], char[][], List<int[]>, int[]> SamAction = (dir,sam, room, npc, nik) =>
               {
                   room[sam[0]][sam[1]] = '.';
                   switch (dir)
                   {
                       case 'U': 
                           sam[0] -= 1;
                           if(sam[0]==nik[0])
                           {
                               Console.WriteLine("Sam Wins");
                               isNikDead = true;
                               
                           }
                           room[sam[0]][sam[1]] = 'S';
                           KillNPC(currentNpc, sam);
                           if(IsSamSpoted(sam,currentNpc,currentRoom))
                           {
                               Console.WriteLine("Game Over Sma Was Killed!");
                               isSamDead = true;
                           }
                           break;

                       case 'D':
                           sam[0] += 1;
                           if (sam[0] == nik[0])
                           {
                               Console.WriteLine("Sam Wins");
                               isNikDead = true;

                           }
                           room[sam[0]][sam[1]] = 'S';
                           KillNPC(currentNpc, sam);
                           if (IsSamSpoted(sam, currentNpc, currentRoom))
                           {
                               Console.WriteLine("Game Over Sma Was Killed!");
                               isSamDead = true;
                           }
                           break;

                       case 'W':
                          
                           break;
                       case 'L':
                           if (IsSamSpoted(sam, currentNpc, currentRoom))
                           {
                               Console.WriteLine("Game Over Sma Was Killed!");
                               isSamDead = true;
                           }
                           else
                           {
                               sam[1] -= 1;
                               room[sam[0]][sam[1]] = 'S';
                               KillNPC(currentNpc, sam);
                           }
                           break;


                       case 'R':
                           if (IsSamSpoted(sam, currentNpc, currentRoom))
                           {
                               Console.WriteLine("Game Over Sma Was Killed!");
                               isSamDead = true;
                           }
                           else
                           {
                               sam[1] += 1;
                               room[sam[0]][sam[1]] = 'S';
                               KillNPC(currentNpc, sam);
                           }
                           break;


                   }

               };

            for(int i=0;i<commands.Length;i++)
            {
                MoveEnemies(currentNpc, currentRoom);
                SamAction(commands[i], sam, currentRoom, currentNpc, nik);
                if(isSamDead || isNikDead)
                {
                    break;
                }
            }

        
        }

        private static bool IsSamSpoted(int[] samCoordiantes, List<int[]> npcCoordinates,char[][]currentRoom)
        {

            for (int i = 0; i < npcCoordinates.Count; i++)
            {
                if (npcCoordinates[i][0] == samCoordiantes[0])
                {
                    switch (currentRoom[npcCoordinates[i][0]][npcCoordinates[i][1]])
                    {
                        case 'b':
                            if (samCoordiantes[1] > npcCoordinates[i][1])
                            {

                                return true;
                            }
                            break;
                        case 'd':
                            if(samCoordiantes[1]< npcCoordinates[i][1])
                            {
                                return true;
                            }
                            break;
                    }
                }

            }



            return false;
        }

        private static void MoveEnemies(List<int[]> currentNPC,char[][] currentRoom)
        {
            Func<int[], bool> IsEnemyOnEdge = enemy =>
             {
                 if(enemy[1]==currentRoom[0].Length-1|| enemy[1]==0)
                 {
                     return true;
                 }
                 else
                 {
                     return false;
                 }
             };

            for(int i =0;i<currentNPC.Count;i++)
            {
                switch(currentRoom[currentNPC[i][0]][currentNPC[i][1]])
                {
                    case 'd':
                        if(IsEnemyOnEdge(currentNPC[i]))
                        {
                            currentRoom[currentNPC[i][0]][currentNPC[i][1]]='b';
                            continue;
                        }
                        else
                        {
                            currentRoom[currentNPC[i][0]][currentNPC[i][1]] = '.';
                            currentRoom[currentNPC[i][0]][currentNPC[i][1] - 1] = 'd';
                        }

                        break;
                    case 'b':
                        if (IsEnemyOnEdge(currentNPC[i]))
                        {
                            currentRoom[currentNPC[i][0]][currentNPC[i][1]] = 'd';
                            continue;
                        }
                        else
                        {
                            currentRoom[currentNPC[i][0]][currentNPC[i][1]] = '.';
                            currentRoom[currentNPC[i][0]][currentNPC[i][1] + 1] = 'b';
                        }

                        break;
                }
            }
        }

        private static void PinPointCoordinates(int row,string currentLine,List<int[]> npcCoordiantes, int[] sam,int[] mainEnemy)
        {
            for(int i =0;i<currentLine.Length;i++)
            {
                switch(currentLine[i])
                {
                    case 'b':
                        npcCoordiantes.Add(new int[] { row, i });
                        break;
                    case 'd':
                        npcCoordiantes.Add(new int[] { row, i });
                        break;
                    case 'S':
                        sam[0] = row;
                        sam[1] = i;
                        break;
                    case 'N':
                        mainEnemy[0] = row;
                        mainEnemy[1] = i;
                        break;
                }
            }

        }


        //Hospital Task for abstraction slides
        private static void HospitalRegistration()
        {
            //current Doctors and patients assigned to them
            Dictionary<string, List<string>> currentDoctorPatient = new Dictionary<string, List<string>>();

            //Collection of all Departments
            Dictionary<string, Department> currentDepartments = new Dictionary<string, Department>();

            string enterData=Console.ReadLine();
            string[] gatherData;
            while(!enterData.Equals("output",StringComparison.OrdinalIgnoreCase))
            {
                gatherData = enterData.Split(" ", StringSplitOptions.RemoveEmptyEntries);
                
                if(!currentDepartments.ContainsKey(gatherData[0]))
                {
                    currentDepartments.Add(gatherData[0], new Department(gatherData[0]));

                }

                if(!currentDoctorPatient.ContainsKey(gatherData[1]+" "+ gatherData[2]))
                {
                    currentDoctorPatient.Add(gatherData[1] + " " + gatherData[2], new List<string>());
                    currentDoctorPatient[gatherData[1] + " " + gatherData[2]].Add(gatherData[3]);
                }
                else
                {
                    currentDoctorPatient[gatherData[1] + " " + gatherData[2]].Add(gatherData[3]);
                }

                enterData = Console.ReadLine();
            }

            string enterOutputRequest = Console.ReadLine();
            string[] getRequestData;
            while(!enterOutputRequest.Equals("end",StringComparison.OrdinalIgnoreCase))
            {
                if(enterOutputRequest.Contains(" "))
                {
                    getRequestData = enterOutputRequest.Split(" ", StringSplitOptions.RemoveEmptyEntries);
                    int room = int.Parse(getRequestData[1]);
                    if(room-1>=0 && room-1<=currentDepartments[getRequestData[0]].FreeRooms)
                    {
                        Console.WriteLine(currentDepartments[getRequestData[0]].DisplayRoom(room - 1));
                    }
                }
                else
                {
                    if(currentDepartments.ContainsKey(enterOutputRequest))
                    {
                        Console.WriteLine(currentDepartments[enterOutputRequest].DiplayRegiteredPatients());
                    }
                    else if(currentDoctorPatient.ContainsKey(enterOutputRequest))
                    {
                        Console.WriteLine(PatientsHealedByDoctor(enterOutputRequest, currentDoctorPatient[enterOutputRequest]));
                    }
                }
                enterOutputRequest = Console.ReadLine();
            }

        }

        private static string PatientsHealedByDoctor(string doctor, List<string> currentPatients)
        {
            currentPatients.Sort();
            StringBuilder sb = new StringBuilder();
            sb.Append(doctor + " Healed:" + Environment.NewLine);
            foreach(var item in currentPatients)
            {
                sb.Append(item + Environment.NewLine);
            }
            return sb.ToString();
        }



        //jedi galaxy task from OOP basics
        private static void JediGlaxy()
        {
            //game results after the game
            int[] results;

            //adding matrix coordinates
            int[] enterMatrixCoordinates = Console.ReadLine().Split(" ", StringSplitOptions.RemoveEmptyEntries)
                .Select(e => int.Parse(e)).ToArray();

            //create matrix
            int[,] currentMatrix = new int[enterMatrixCoordinates[0], enterMatrixCoordinates[1]];
            CreateJediGalaxyMatrix(currentMatrix);
             
            //player coordinates
            int[] coordinates;      //to store coordinates
            string enterCoordinates;                //to enter coordinates

            List<int[]> currentEnteredCoordinates = new List<int[]>();

            enterCoordinates = Console.ReadLine();
            while(!enterCoordinates.Equals("Let the force be with you",StringComparison.OrdinalIgnoreCase))
            {
                coordinates = enterCoordinates.Split(" ", StringSplitOptions.RemoveEmptyEntries)
                    .Select(int.Parse).ToArray();
                if(coordinates.Length==2)
                {
                    currentEnteredCoordinates.Add(coordinates);
                }
                enterCoordinates = Console.ReadLine();

            }

            if(currentEnteredCoordinates.Count<2)
            {
                Console.Clear();
                Console.WriteLine("Player Paths not detected!");
                Console.WriteLine("Please Note that the last or only path entered is always the enemy!");
                return;
            }
            else
            {
                results = GatherStars(currentMatrix, currentEnteredCoordinates);
                Console.WriteLine($"Jedi Power: {results[0]}" + Environment.NewLine +
                    $"Sith Power{results[1]}");
            }
           

        }


        //start JediGalaxyDataGather from matrix

        private static int[] GatherStars(int[,]currentMatirx,List<int[]> currentCoordinates)

        {
            int[] results = new int[2] { 0, 0 };        //0-hero data gathered  1-enemy data gathered 

            int[] enemyCoordinates = currentCoordinates[currentCoordinates.Count - 1];
            currentCoordinates.RemoveAt(currentCoordinates.Count - 1);

            //move enemy to gather data
            while(enemyCoordinates[0]!=-1 && enemyCoordinates[1]!=-1)
            {
                enemyCoordinates[0]--;
                enemyCoordinates[1]--;

                results[1] += currentMatirx[enemyCoordinates[0], enemyCoordinates[1]];
                currentMatirx[enemyCoordinates[0], enemyCoordinates[1]] = -1;
            }


            //TO DO
            //modify to work with multiple
            //move player to gather data
            int[] playerCoordiantes = new int[2];
           for(int i =0;i<currentCoordinates.Count;i++)
           {
                    playerCoordiantes = currentCoordinates[i];
                    if(playerCoordiantes[1]==-1)
                    {
                        goto outsideAproach;
                    }
                    else
                    {
                        goto inneAproach;
                    }
           }

            return results; // method ends here the null part below is because of intelisense

        outsideAproach:
           while(playerCoordiantes[0]!=-1)
            {
                playerCoordiantes[0]--;
                playerCoordiantes[1]++;

                if(currentMatirx[playerCoordiantes[0],playerCoordiantes[1]]!=-1)
                {
                    results[0] += currentMatirx[playerCoordiantes[0], playerCoordiantes[1]];
                }
            }


           inneAproach:
            while (playerCoordiantes[0] != -1)
            {
             
                if (currentMatirx[playerCoordiantes[0], playerCoordiantes[1]] != -1)
                {
                    results[0] += currentMatirx[playerCoordiantes[0], playerCoordiantes[1]];
                }

                playerCoordiantes[0]--;
                playerCoordiantes[1]++;
            }

            return null;
        }


        //create 2d matrix with data from 0 to n
        private static void CreateJediGalaxyMatrix(int[,] currentMatrix)
        {
            int counter = -1;
            for(int i =0;i<currentMatrix.GetLength(0);i++)
            {
                for(int j=0;j<currentMatrix.GetLength(1);j++)
                {
                    counter++;
                    currentMatrix[i, j] = counter;
                }
            }
        }

        //check if player is in correct position of start
        private static bool IsInRightPlacePlayer(int[] playerCoordinates,int[] matrixData)
        {
            bool isPlayerInPlace = true;
           if((playerCoordinates[0]> matrixData[0] + 1 || playerCoordinates[0]<=0)
                && (playerCoordinates[1]<-1 || playerCoordinates[1]>=matrixData[1]))
            {
                isPlayerInPlace = false;
            }

            return isPlayerInPlace;
        }

        //check if enemy is in right place
        private static bool IsInRightPlaceEnemy(int[] enemyCoordinates,int[] matrixData)
        {
            bool isEnemyInPlace = true;
            if(enemyCoordinates[0]!=matrixData[0]+1 && enemyCoordinates[1]!=matrixData[1]+1)
            {
                isEnemyInPlace = false;
            }
            return isEnemyInPlace;
        }

        //Exam Tasks
        private static void RabitTask()
        {
            Console.Write("Enter number of rabbits: ");
            int numberRabbits =int.Parse(Console.ReadLine());

            Cage currentCage = new Cage("theCage", numberRabbits);

            Rabbit currentRabbit = null;
            for(int i =0;i<numberRabbits;i++)
            {
                try
                {
                    currentRabbit = new Rabbit(Console.ReadLine(), Console.ReadLine());
                    currentCage.AddRabbit(currentRabbit);
                }
                catch (Exception)
                {
                    i--;
                }
            }

            

        }


        static string enterWord;        //relevant for WormBook
        private static void BookWormQuest()
        {
            Console.Write("Enter word or sentence: ");
           enterWord = Console.ReadLine();

            string[] sentence = null;  //optional if its more than one word         //currently not implemented to work with it
            if (enterWord.Contains(" "))
            {
                sentence = enterWord.Split(" ", StringSplitOptions.RemoveEmptyEntries);
            }
            // paramaters for the book or matrix
            int numberRows = int.Parse(Console.ReadLine());
            //the field in which the worm wil be moving
            char[][] currentBook = new char[numberRows][];

            //player position
            int[] playerCooridnates = new int[2];

            //adding the data for the matrix like enemies, you etc
            string enterRowData;
            for(int i=0;i<numberRows;i++)
            {
                Console.Clear();
                Console.WriteLine("Enter Data for row: {0}", i);
                enterRowData = Console.ReadLine();
                if(enterRowData.Length==numberRows)
                {
                    currentBook[i] = enterRowData.ToCharArray();
                    if(enterRowData.Contains("P"))
                    {
                        playerCooridnates[0] = i;
                        playerCooridnates[1] = enterRowData.IndexOf("P");
                    }
                }
                else
                {
                    i--;
                }
            }

          //  StringBuilder sb = new StringBuilder();
          //  for(int i =0;i<currentBook.Length;i++)
          //  {
           //     for(int j=0;j<currentBook[i].Length;j++)
            //    {
               //     sb.Append(currentBook[i][j]);
              //  }
               // sb.Append(Environment.NewLine);
           // }
            //Console.WriteLine(sb.ToString());

            //game data: health, points etc
            int[] gameData = new int[3] { 0, 0,GetLetterCountInMatrix(currentBook)};        // 0-letters consumed, 1-times outside the field, 2-letters on the field ,
                                                 //   4(optional) -> out of field limit

            while(gameData[0]!=gameData[2])         // TO DO IMPLEMENT GAME END DATA IN GAMEDATA ARRAY <---- and word in actuponevent REFERENCE problem
                                //reference problem use the static sb to do sometihn may require some several validations
            {
                Console.Clear();
                DisplayBookWormField(currentBook,enterWord);
                var keyPressed = Console.ReadKey(false).Key;
                switch (keyPressed)
                {
                    case ConsoleKey.UpArrow:
                        ActUponBookEvent(currentBook,enterWord,gameData,playerCooridnates,
                            new int[] {playerCooridnates[0]-=1,playerCooridnates[1]});
                        return;
                    case ConsoleKey.DownArrow:
                        ActUponBookEvent(currentBook, enterWord, gameData, playerCooridnates,
                            new int[] { playerCooridnates[0] += 1, playerCooridnates[1] });
                        break;
                    case ConsoleKey.RightArrow:
                        ActUponBookEvent(currentBook, enterWord, gameData, playerCooridnates,
                            new int[] { playerCooridnates[0], playerCooridnates[1]+=1 });
                        break;
                    case ConsoleKey.LeftArrow:
                        ActUponBookEvent(currentBook, enterWord, gameData, playerCooridnates,
                            new int[] { playerCooridnates[0], playerCooridnates[1]-=1 });
                        break;
                }
            }
            
            
        }

        private static int GetLetterCountInMatrix(char[][] currentBook)
        {
            int numberLetters = 0;
            for(int i =0;i<currentBook.Length;i++)
            {
                for(int j=0;j<currentBook[i].Length;j++)
                {
                    switch(currentBook[i][j])
                    {
                        case '-':
                            break;
                        case 'P':
                            break;
                        default:
                            numberLetters++;
                            break;
                    }
                }
            }
            return numberLetters;
        }

        private static Action<char[][],string> DisplayBookWormField = (currentBook,word) =>
        {
            
              StringBuilder sb = new StringBuilder();
              for(int i =0;i<currentBook.Length;i++)
              {
                 for(int j=0;j<currentBook[i].Length;j++)
                {
                 sb.Append(currentBook[i][j]);
              }
             sb.Append(Environment.NewLine);
             }
            Console.WriteLine(word+Environment.NewLine);
           Console.WriteLine(sb.ToString());
        };

        static StringBuilder bookWormTaskWordSb = new StringBuilder(enterWord);  //used for the below delegate

        private static Action<char[][],string,int[],int[], int[]> ActUponBookEvent =(book,word,gameData,currentPosition,estimated) =>
            {
                if(currentPosition[0]<0 || currentPosition[0]>book.Length-1 )
                {
                    gameData[1]++;
                    return;
                }
                else if(currentPosition[1]<0 || currentPosition[1]>book.Length-1)
                {
                    gameData[1]++;
                    return;
                }
                else
                {
                    book[currentPosition[0]][currentPosition[1]] = '-';
                    currentPosition = estimated;
                   
                }


                
                switch (book[currentPosition[0]][currentPosition[1]])
                {
                    case '-':
                        book[currentPosition[0]][currentPosition[1]] = 'P';
                        break;

                    default:
                        bookWormTaskWordSb.Append(book[currentPosition[0]][currentPosition[1]]);
                        gameData[0]++;
                        word = bookWormTaskWordSb.ToString();
                        book[currentPosition[0]][currentPosition[1]] = 'P';
                        break;
                }
            };
            
        private static void DatingApp()
        {
            int[] matchesDone = new int[1];
            matchesDone[0] = 0;
            //adding females
            List<int> females = Console.ReadLine().Split(" ", StringSplitOptions.RemoveEmptyEntries)
                .Select(e => int.Parse(e)).ToList();

            //adding males
            List<int> males = Console.ReadLine().Split(" ", StringSplitOptions.RemoveEmptyEntries)
                .Select(e => int.Parse(e)).ToList();

            //func delegate void to remove member of the lists depending on the gender
            Action<List<int>, string> RemoveMemeberOfApp = (members, gender) =>
             {
                 switch(gender.ToLower())
                 {
                     case "females":
                         members.RemoveAt(0);
                         break;
                     case "males":
                         members.RemoveAt(members.Count - 1);
                         break;
                 }
             };

            while(females.Count!=0 || males.Count!=0)
            {
                MatchAction(males[0], females[females.Count - 1], RemoveMemeberOfApp, males, females, matchesDone);
            }

            StringBuilder sb = new StringBuilder();
            sb.Append($"Matches: {matchesDone[0]}" + Environment.NewLine);
            if(males.Count!=0)
            {
                sb.Append($"Males left: {males.Count}"+Environment.NewLine);
            }
            else
            {
                sb.Append($"Males left: none"+Environment.NewLine);
            }

            if(females.Count!=0)
            {
                sb.Append($"Females left: {females.Count}" + Environment.NewLine);
            }
            else
            {
                sb.Append($"Females left: none" + Environment.NewLine);
            }

            Console.WriteLine(sb.ToString());
            
        }

        private static void MatchAction(int male, int female,Action<List<int>,string> removeMember,List<int> males,List<int> females,int[] matchesDone)
        {
            if(male%25==0)
            {
                for(int i=0;i<2;i++)
                {
                    removeMember(males, "males");
                }
                return;
            }else if(female%25==0)
            {
                for (int i = 0; i < 2; i++)
                {
                    removeMember(females, "females");
                }
                return;
            }
            else if(female%25==0 && male%25==0)
            {
                for (int i = 0; i < 2; i++)
                {
                    removeMember(males, "males");
                    removeMember(females, "females");
                }
                return;
            }


            if(female==male)
            {
                removeMember(males, "males");
                removeMember(females, "females");
                matchesDone[0]++;
            }
            else
            {
                removeMember(females, "females");
                males[0] -= 2;
                if (males[0] <= 0)
                {
                    removeMember(males, "males");
                }
            }
        }

       


         private static void ReVolt()
        {
            //adding amtrix size rows and columns
            Console.Write("Enter matrix data: ");
            int matrixData = int.Parse(Console.ReadLine());

            Console.Write("Enter number commands: ");
            int numberCommands = int.Parse(Console.ReadLine());

            //initialising matrix
            char[][] currentMatrix = new char[matrixData][];
           int[] playerCoordinates =  GenerateMatrix(currentMatrix);

            string enterCommand;
            bool gameWon;
            while(numberCommands-- >0)
            {
                enterCommand = Console.ReadLine();
                gameWon = ReVoldCommands(currentMatrix, playerCoordinates,enterCommand);
                if(gameWon)
                {
                    Console.Clear();
                    Console.WriteLine("Game over you WIN");
                    break;
                }
                else
                {
                    Console.Clear();
                    Console.WriteLine("Game over you Lose");
                    break;
                }
            }

            

        }

        //fill matrix with content and return the player coordinates
        private static int[] GenerateMatrix(char[][] currentMatrix)
        {
            int[] playerCoordinates = new int[2];       //0 is the row pos and 1 is the col pos


            string temp;
            //adding dashes (free space and data) to the matrix;
            for(int i = 0; i < currentMatrix.GetLength(0); i++)
            {
                Console.Clear();
                Console.Write($"Enter data for row: {i}: ");
                temp = Console.ReadLine();
                if(temp.Length!=currentMatrix.GetLength(0))
                {
                    i--;
                }
                else
                {
                    currentMatrix[i] = new char[currentMatrix.GetLength(0)];
                    currentMatrix[i] = temp.ToCharArray();
                    if(temp.Contains('f'))
                    {
                        playerCoordinates[0] = i;
                        playerCoordinates[1] = temp.IndexOf('f');
                    }
                }
            }

            Console.Clear();
            return playerCoordinates;

        }       
        
        private static void GuildWar()
        {
            //enter number of players
            Console.Write("Enter number players: ");
            int numberPlayers = int.Parse(Console.ReadLine());

            List<Player> currentPlayersNotInGuild = new List<Player>(numberPlayers);

            // keep enetring players n times
            string[] playerData;
            while(numberPlayers-- > 0)
            {
                playerData = Console.ReadLine().Split(" ", StringSplitOptions.RemoveEmptyEntries);
                currentPlayersNotInGuild.Add(new Player(playerData[0], playerData[1]));

            }


            StringBuilder generalActionsMenue = new StringBuilder();
            generalActionsMenue.Append(1 + "| Select Player" + Environment.NewLine);
            generalActionsMenue.Append(2 + "| Select Guild"+Environment.NewLine);
            generalActionsMenue.Append(3 + "| Player Actions" + Environment.NewLine);
            generalActionsMenue.Append(4 + "| Guild Actions" + Environment.NewLine);
            generalActionsMenue.Append(5 + "| Exit" + Environment.NewLine);
            int select;
            Player selectedPlayer = null;
            while(true)
            {
                Console.WriteLine(generalActionsMenue.ToString());
                select = int.Parse(Console.ReadLine());
                switch (select)
                {
                    case 1: selectedPlayer = SelectPlayer(currentPlayersNotInGuild); break;
                        
                }
            }

        } 
        private static Player SelectPlayer(List<Player> currentPlayers)
        {
            StringBuilder sb = new StringBuilder();
            int index = 0;
            currentPlayers.Select(p =>
            {
                sb.Append((index+1) +"| "+ p.Name + ": " + p.Class + Environment.NewLine);
                return p;
            }
            );
            
            int selected=-1;
            do
            {
                Console.Clear();
                enterPhase:
                Console.WriteLine("Select player: ");
                Console.WriteLine(sb.ToString());
                Console.Write("Enter player number: ");
                selected = int.Parse(Console.ReadLine());
                if(selected < 1 || selected > currentPlayers.Count - 1)
                {
                    Console.Clear();
                    Console.WriteLine("Invalid player number");
                    goto enterPhase;
                }
            } 
            while (selected<1 || selected>currentPlayers.Count-1);

            Player currentPlayerToReturn = currentPlayers[selected];
            currentPlayers.RemoveAt(selected);
            return currentPlayerToReturn;

        }


        //PLAYERS
        //---------------
        private static bool ReVoldCommands(char[][] currentMatrix,int[] playerCoordinates ,string command)
        {
            bool wonGame = false;

            Action<char[][],string ,Func<int[],int>,Func<int[],int,int[]>,int[]> actUponEvent = (field,prevCommand,isOutside,rePosition,pos) =>
             {
                

                 switch (field[pos[0]][pos[1]])
                 {
                     case 'B':
                         field[pos[0]][pos[1]] = '-';
                         
                         switch(prevCommand)
                         {
                             case "up":
                                 pos[0]--;
                                 break;
                             case "down":
                                 pos[0]++;
                                 break;
                             case "right":
                                 pos[1]++;
                                 break;
                             case "left":
                                 pos[1]--;
                                 break;
                         }
                         //reposition again fi have to
                         int isOutsideResult = isOutside(pos);
                          if (isOutsideResult!=-1)
                         {
                             pos = rePosition(pos, isOutsideResult);
                         }
                         break;

                     case 'T':
                         field[pos[0]][pos[1]] = '-';
                         switch(prevCommand.ToLower())
                         {
                             case "up":
                                 pos[0]++;
                                 break;
                             case "down":
                                 pos[0]--;
                                 break;
                             case "right":
                                 pos[1]--;
                                 break;
                             case "left":
                                 pos[1]++;
                                 break;
                         }
                         break;
                     case 'F':
                         wonGame = true;
                         break;
                     default:
                          isOutsideResult = isOutside(pos);
                         if (isOutsideResult != -1)
                         {
                             pos = rePosition(pos, isOutsideResult);
                         }
                         break;
                 }
             };


            Func<int[], int> isOutsideField = pos =>
             {
                 if (pos[0] == -1)
                 {
                     return 0;
                 }
                 else if (pos[0] > currentMatrix.GetLength(0))
                 {
                     return 1;
                 }
                 else if (pos[1] == -1)
                 {
                     return 2;
                 }
                 else if (pos[1] > currentMatrix.GetLength(0))
                 {
                     return 3;
                 }
                 return -1;
                 
             };


            Func<int[],int,int[]> RePosition = (pos,actionNumber) =>
            {
                switch(actionNumber)
                {
                    case 0: pos[0] = -1 + currentMatrix.GetLength(0) + 1; break;
                    case 1: pos[0] -= currentMatrix.GetLength(0) + 1; break;
                    case 2: pos[1] = -1 + currentMatrix.GetLength(0) + 1; break;
                    case 3: pos[0] -= currentMatrix.GetLength(0) + 1; break;
                    default: break;
                }
                return pos;
            };
            //-1
            /*0 - - - - -
             *1 - - - - -
             *2 - - - - - 
             *3 - - - - - 
             *4 - - - - -
             *5 - - - - - 
             */

           

           switch(command.ToLower())
            {
                case "up":
                    currentMatrix[playerCoordinates[0]][playerCoordinates[1]] = '-';
                    playerCoordinates[0]--;
                    actUponEvent(currentMatrix, command, isOutsideField, RePosition, playerCoordinates);
                    return wonGame;
                    
                case "down":
                    currentMatrix[playerCoordinates[0]][playerCoordinates[1]] = '-';
                    playerCoordinates[0]++;
                    actUponEvent(currentMatrix, command, isOutsideField, RePosition, playerCoordinates);
                    return wonGame;
                    
                case "right":
                    
                    currentMatrix[playerCoordinates[0]][playerCoordinates[1]] = '-';
                    playerCoordinates[1]++;
                   actUponEvent(currentMatrix, command, isOutsideField, RePosition, playerCoordinates);
                    return wonGame;
                    
                case "left":
                   
                    currentMatrix[playerCoordinates[0]][playerCoordinates[1]] = '-';
                    playerCoordinates[1]--;
                     actUponEvent(currentMatrix, command, isOutsideField, RePosition, playerCoordinates);
                    return wonGame;
                    
            }

            return false;
        }

        private static void LootBox()
        {
            Console.Write("Enter number of boxes: ");
            int numberBoxes = int.Parse(Console.ReadLine());

            //this will hold our items
            List<int> itemsObtained = new List<int>();

            string[] boxes = GenerateBoxes(numberBoxes);

            foreach (var item in boxes)
            {
                OpenBox(itemsObtained, item);
            }

            //checking items obtained  for type epic/poor
            StringBuilder sb = new StringBuilder();
            itemsObtained.Select(e =>
            {
                if(e>=100)
                {
                    sb.Append($"Epic item obtained value:{e}" + Environment.NewLine);
                }
                else
                {
                    sb.Append($"Poor item obtained value:{e}" + Environment.NewLine);
                }
                return e;
            }
            );

            Console.WriteLine(sb.ToString());

        }
        private static void OpenBox(List<int> currentInventory,string item)
        {
            string[] sequenes = item.Split("|");        //getting both sequences

            //first sequence
            List<int> firstSequence = sequenes[0].Split(" ",StringSplitOptions.RemoveEmptyEntries)
                .Select(int.Parse).ToList();

            //second sequence
            List<int> secondSequence = sequenes[1].Split(" ", StringSplitOptions.RemoveEmptyEntries)
                .Select(int.Parse).ToList();


            //we sum first form fristSeq and last from secondSeq
            // int sum = firstSequence[0] + secondSequence[secondSequence.Count - 1];


            List<int> currentPartsFromSequences = new List<int>();

            int sum;
            while (firstSequence.Count!=0 || secondSequence.Count!=0)
            {
                sum = firstSequence[0] + secondSequence[secondSequence.Count - 1];
                if (sum%2==0)
                {
                    currentPartsFromSequences.Add(sum);
                    firstSequence.RemoveAt(0);
                    secondSequence.RemoveAt(secondSequence.Count-1);
                }
                else
                {
                    firstSequence.Add(secondSequence[secondSequence.Count - 1]);
                    secondSequence.RemoveAt(secondSequence.Count - 1);
                }
            }

            currentInventory.Add(currentPartsFromSequences.Aggregate((a, b) => a + b));
        }

        private static string[] GenerateBoxes(int number)
        {
            string[] currentBoxes = new string[number];
            int counter = 0;
            while(number-- >0)
            {
                currentBoxes[counter++] = Console.ReadLine();
            }
            return currentBoxes;
        }

            //--------------------------


        //Generics






        //------------------------------------------------


        //Defining classes
        
        public static void RawDataCarDefinignClasses()
        {
            

            //adding number cars
            int numberCars = int.Parse(Console.ReadLine());

            List<Car> currentCars = new List<Car>(numberCars);

            string enterData;
            string[] collectData;

            Car currentCar = null;
            int counter = numberCars;
            //adding car data
            while (counter-- >0)
            {
                enterData = Console.ReadLine();
                collectData = enterData.Split(" ", StringSplitOptions.RemoveEmptyEntries);
                try
                {
                    currentCar = new Car(collectData[0],int.Parse(collectData[1]),int.Parse(collectData[2]),
                        double.Parse(collectData[3]),collectData[4],double.Parse(collectData[5]),
                        int.Parse(collectData[6]),double.Parse(collectData[7]),int.Parse(collectData[8]),double.Parse(collectData[9]),
                        int.Parse(collectData[10]),double.Parse(collectData[11]),int.Parse(collectData[12]));
                    currentCars.Add(currentCar);
                }
                catch(ArgumentException exc)
                {
                    counter++;
                    continue;
                }
            }

            string filterBy = Console.ReadLine();
            StringBuilder sb = new StringBuilder();
            switch(filterBy.ToLower())
            {
                case "fragile":
                    currentCars.Where(e =>
                    {
                        if(e.Cargo.Type.Equals("fragile",StringComparison.OrdinalIgnoreCase))
                        {
                            for(int i =0;i<e.Tires.Length;i++)
                            {
                                if(e.Tires[i].Pressure<1)
                                {
                                    sb.Append(e.Model + Environment.NewLine);
                                    return true;
                                    
                                }
                            }
                        }

                        return false;
                        
                    }
                    );

                    Console.WriteLine(sb.ToString());
                    break;

                case "famable":
                    currentCars.Where(e =>
                    {
                        if (e.Cargo.Type.Equals("flamable", StringComparison.OrdinalIgnoreCase) && e.Engine.EnginePower>250)
                        {
                            sb.Append(e.Model + Environment.NewLine);
                            return true;
                        }

                        return false;

                    }
                   );
                    Console.WriteLine(sb.ToString());
                    break;
            }
        }



        private static void CarDriveDistanceDefiningClases()
        {
            Dictionary<string, Car> currentCars = new Dictionary<string, Car>();

            //adding number of cars and adding them to the structure
            int numberCars = int.Parse(Console.ReadLine());

            string enterCarData;
            string[] collectCarData;
            while(numberCars-- >0)
            {
                enterCarData = Console.ReadLine();
                collectCarData = enterCarData.Split(" ", StringSplitOptions.RemoveEmptyEntries);
                if(!currentCars.ContainsKey(collectCarData[0]))
                {
                    currentCars.Add(collectCarData[0], new Car(collectCarData[0], double.Parse(collectCarData[1]),
                        double.Parse(collectCarData[2])));
                }

            }

            //adding commands

            string enterCommand = Console.ReadLine();
            string[] currentCommands;
            while(!enterCommand.Equals("end",StringComparison.OrdinalIgnoreCase))
            {
                currentCommands = enterCommand.Split(" ", StringSplitOptions.RemoveEmptyEntries);
                ExecuteSpeedDrivCommands(currentCommands, currentCars);
                enterCommand = Console.ReadLine();

            }

            //function to add line separator for output
            Func<int, string> currentFuncForAddingLine = e =>
             {
                 StringBuilder sb = new StringBuilder();
                 for(int i =0;i<e;i++)
                 {
                     sb.Append("-");
                 }

                 return sb.ToString();
             };


            //Displaying all cars afterwards
            Console.WriteLine("Cars with fuel amount and travelled distance: ");
            StringBuilder sb = new StringBuilder();
            currentCars.Select(e =>
            {
                sb.Append(e.Value + Environment.NewLine);
                sb.Append(currentFuncForAddingLine(20)+Environment.NewLine);
                return e;
            }
            );
            Console.WriteLine(sb.ToString());
        }
        private static void ExecuteSpeedDrivCommands(string[] commands,Dictionary<string,Car> currentCars)
        {
            switch(commands[0].ToLower())
            {
                case "drive":
                    if(currentCars.ContainsKey(commands[1]))
                    {
                        currentCars[commands[1]].DriveCar(double.Parse(commands[2]));
                    }
                   
                    break;
                case "refuel":
                    if(currentCars.ContainsKey(commands[1]))
                    {
                        currentCars[commands[1]].AddFuel(double.Parse(commands[2]));
                    }
                    break;
            }
        }

        
        private static void SoftuiParkingDefinignClasses()
        {
            //current Parking lots created
            Dictionary<string, Parking> curentParkingLots = new Dictionary<string, Parking>();

            //current cars who are not assigned to a parking lot
            Dictionary<string, Car> currentCars = new Dictionary<string, Car>();

            string enterCommand = Console.ReadLine();
            string[] currentCommands=null;
            while(!enterCommand.Equals("end",StringComparison.OrdinalIgnoreCase))
            {
                currentCommands = enterCommand.Split(" ", StringSplitOptions.RemoveEmptyEntries);
                executeDefiningClassesParking(currentCommands, curentParkingLots, currentCars);
                enterCommand = Console.ReadLine();
            }

            StringBuilder sb = new StringBuilder();
            sb.Append("Cars in parking lots:" + Environment.NewLine);
            foreach(var item in curentParkingLots)
            {
                sb.Append(item.Key + Environment.NewLine);
                sb.Append(item.Value);
            }
            sb.Append("Cars outside parkings:"+Environment.NewLine);
            foreach(var item in currentCars)
            {
                sb.Append(item.Key + Environment.NewLine);
            }

            Console.WriteLine(sb.ToString());

            
              
        }

        //execute commands for parking lots and cars with no parking lots
        private static void executeDefiningClassesParking(string[] commands,Dictionary<string,Parking> currentParkingLots,
            Dictionary<string,Car> currentCars)
        {
           // switch(commands[0].ToLower())
           // {
              //  case "addcar":
                //    if(currentParkingLots.ContainsKey(commands[]))
                 //   break;
           // }
                
        }



        //---------------------------------------------------





        //LINQ

        //-------------------------------

        private static void BombHostagesJoker()
        {
            

            //enter building specs
            Console.Write("Enter width of builing: ");
            int width = int.Parse(Console.ReadLine());
            Console.Write("Enter height of building: ");
            int height = int.Parse(Console.ReadLine());


            //enter data of your location
            Console.Write("Enter current coordinates: ");
            int[] currentLocation = Console.ReadLine().Split(" ", StringSplitOptions.RemoveEmptyEntries)
                .Select(e => int.Parse(e)).ToArray();

            // generata building
            char[,] currentBuilding = new char[height,width];
            for(int i=0;i<height;i++)
            {
                for(int j=0;j<width;j++)
                {
                    currentBuilding[i, j] = '*';
                }
            }

            //assigning your position on the map
            currentBuilding[currentLocation[0], currentLocation[1]] = 'Y';      //as YOU

            //GameData[] 0->currentBombsDefused,  2-> currentLives 3-> currentBombsOnField
            int[] gameData = new int[3] { 0, 3, 0 };

            //assign bombs to building via number of bombs and random generating location on building
            AssignBombsToBuiding(currentBuilding,gameData ,currentLocation, width, height);

          

            //DisplayFiled with the StringBuilding becaue Console Output is a slow process
            StringBuilder sb = new StringBuilder();

            //Game loop here
            while(true)
            {
                Console.Clear();
                for(int i=0;i<currentBuilding.GetLength(0);i++)
                {
                    for( int j=0;j<currentBuilding.GetLength(1);j++)
                    {
                        sb.Append(currentBuilding[i, j]+" ");
                    }
                    sb.Append(Environment.NewLine);
                }
                sb.Append(Environment.NewLine);
                
                Console.WriteLine(sb.ToString());
                sb.Clear();
                Console.WriteLine("Enter Location separated by space examp u-up,d-down,l-left,r-right,dl,dr,ul,ur.");
                Console.Write("Enter: ");
                string[] currentMoveLocation = Console.ReadLine().Split(" ", StringSplitOptions.RemoveEmptyEntries);
                MoveCurrentPositon(currentBuilding,currentLocation,gameData,currentMoveLocation);
                if(gameData[0]==gameData[2] || gameData[1]==0)
                {
                    break;
                }


            }
            Console.Clear();
            Console.WriteLine("GameOver!");



           
        }

        private static void AssignBombsToBuiding(char[,]currentBuilding,int[] gameData,int[] currentLocation,params int[] buildingSpecs)
        {
            //enter number of bombs to add 
            Console.Write("Enter number of bombs: ");
            int numberBombs = int.Parse(Console.ReadLine());
            gameData[2] = numberBombs;
            Random randX = new Random();
            int xLocation = -1;


            Random randY = new Random();
            int yLocation = -1;
            while(numberBombs-- >0)
            {
                
                while(true)
                {
                    xLocation = randX.Next(0,buildingSpecs[0]);
                    yLocation  =   randY.Next(0, buildingSpecs[1]);

                    if(xLocation!=currentLocation[0] && yLocation!=currentLocation[1])
                    {
                        currentBuilding[xLocation, yLocation] = 'B';

                        break;
                    }
                                
                }
                
            }
            
        }

        private static void MoveCurrentPositon(char[,] currentBuilding,int[] currentLocation,int[] gameData,string[] moveCommands)
        {
            //using a dummy array for location so that when exception arrises we dont lose our loc
            int[] resultLocation = new int[2];
            resultLocation[0] = currentLocation[0];
            resultLocation[1] = currentLocation[1];

            //going trough each pos and executeing movement
            for(int i =0;i<moveCommands.Length;i++)
            {
            switch(moveCommands[i].ToLower())
                {
                    case "r": resultLocation[1]++; break;
                    case "dl": resultLocation[0]++; resultLocation[1]--; break;
                    case "dr": resultLocation[0]++; resultLocation[1]++; break;
                    case "l":  resultLocation[1]--; break;
                    case "ur": resultLocation[0]--; resultLocation[1]++; break;
                    case "ul": resultLocation[0]--; resultLocation[1]--; break;        
                    case "u": resultLocation[0]--; break;
                    case "d": resultLocation[0]++; break;
                    default:
                        break;
                }
            }

            try
            {
                if(currentBuilding[resultLocation[0],resultLocation[1]]=='B')
                {
                    
                    currentBuilding[resultLocation[0], resultLocation[1]] = 'Y';
                    
                    currentBuilding[currentLocation[0], currentLocation[1]] = '*';
                    currentLocation[0] = resultLocation[0];
                    currentLocation[1] = resultLocation[1];
                    gameData[0] += 1;
                }
                else
                {
                    
                    currentBuilding[resultLocation[0], resultLocation[1]] = 'Y';
                    currentBuilding[currentLocation[0], currentLocation[1]] = '*';
                    currentLocation[0] = resultLocation[0];
                    currentLocation[1] = resultLocation[1];
                }
            }
            catch(IndexOutOfRangeException exc)
            {
                gameData[1]--;
            }
            
        }


        private static void  ForbidenWords()
        {
            List<string> text = new List<string>();     //create list to hold lines of sentences

            string enter = Console.ReadLine();      //variable used to enter sentene per line

            while(!enter.Equals("*endtext*",StringComparison.OrdinalIgnoreCase))        //adding sentence if not the end command
            {
                text.Add(enter);
                enter = Console.ReadLine();
            }


            //add forbiden words
            string[] forbidenWords = Console.ReadLine().Split(" ", StringSplitOptions.RemoveEmptyEntries);

            //func to censor
            Func<string, string> censorWord = (a) =>
            {
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < a.Length; i++)
                {
                    sb.Append("*");
                }
                return sb.ToString();

            };


            //func to censor all words in sentenes
            Action<List<string>, StringBuilder> mainLogic = (textLines, output) =>
             {
                 for(int i =0;i<textLines.Count;i++)
                 {
                     textLines[i].Split(" ",StringSplitOptions.RemoveEmptyEntries)
                     .Select(e=>
                     {
                         bool isForbiden = false;
                         e.Trim(new char[] { ' ', ',', '.', '-', '!', '?' });
                         for(int i=0;i<forbidenWords.Length;i++)
                         {
                             if(forbidenWords[i].Equals(e,StringComparison.OrdinalIgnoreCase))
                             {
                                 output.Append(censorWord(e)+" ");
                                 isForbiden = true;
                             }
                         }
                         if(!isForbiden)
                         {
                             output.Append(e+" ");
                         }
                         
                         return e;
                        } 
                      );
                     output.Append(Environment.NewLine);
                 }
             };
            

            StringBuilder currentText = new StringBuilder();        //main output will be here
            mainLogic(text, currentText);
            Console.WriteLine(currentText.ToString().Trim());
        }

        private static void NameSumChars(Func<string,int,bool> currentNameSum)
        {
            int number = int.Parse(Console.ReadLine());
            string[] currentNames = Console.ReadLine().Split(" ", StringSplitOptions.RemoveEmptyEntries);
            currentNames = currentNames.Where(currentNameSum).ToArray();

        }


        private static void PartyFilterSoftware()
        {
            //guest list
            List<string> people = Console.ReadLine().Split(" ", StringSplitOptions.RemoveEmptyEntries).ToList();

            //contains history of filters and filtered data by them
            Dictionary<string, List<string>> addedFilters = new Dictionary<string, List<string>>();

            //FilterAction
            Action<string[], List<string>, Dictionary<string, List<string>>> currentFilterAction =
                (filterCommand, guests, history) =>
                {
                    switch(filterCommand[0].ToLower())
                    {
                        case "add filter":

                            switch(filterCommand[1].ToLower())
                            {
                                case "starts with":
                                    if(!history.ContainsKey(filterCommand[1]+" "+filterCommand[2]))
                                    {
                                        history.Add(filterCommand[1] + " " + filterCommand[2],new List<string>());
                                        
                                        //keeping the filtered values
                                        history[filterCommand[1] + " " + filterCommand[2]] =
                                        guests.Where(e => e.StartsWith(filterCommand[2])).ToList();

                                        //keeping the elements which do not apply to the filter
                                        guests = guests.Where(e => !e.StartsWith(filterCommand[2])).ToList();
                                    }
                                    break;

                                case "ends with":

                                    if (!history.ContainsKey(filterCommand[1] + " " + filterCommand[2]))
                                    {
                                        history.Add(filterCommand[1] + " " + filterCommand[2], new List<string>());

                                        //keeping the filtered values
                                        history[filterCommand[1] + " " + filterCommand[2]] =
                                        guests.Where(e => e.EndsWith(filterCommand[2])).ToList();

                                        //keeping the elements which do not apply to the filter
                                        guests = guests.Where(e => !e.EndsWith(filterCommand[2])).ToList();
                                    }

                                    break;

                                case "length":
                                    if (!history.ContainsKey(filterCommand[1] + " " + filterCommand[2]))
                                    {
                                        history.Add(filterCommand[1] + " " + filterCommand[2], new List<string>());

                                        //keeping the filtered values

                                        int lengthFilter = int.Parse(filterCommand[2]);
                                        history[filterCommand[1] + " " + filterCommand[2]] =
                                        guests.Where(e => e.Length==lengthFilter).ToList();

                                        //keeping the elements which do not apply to the filter
                                        guests = guests.Where(e => e.Length!=lengthFilter).ToList();
                                    }

                                    break;

                                case "contains":
                                    if (!history.ContainsKey(filterCommand[1] + " " + filterCommand[2]))
                                    {
                                        history.Add(filterCommand[1] + " " + filterCommand[2], new List<string>());

                                        //keeping the filtered values

                                        int lengthFilter = int.Parse(filterCommand[2]);
                                        history[filterCommand[1] + " " + filterCommand[2]] =
                                        guests.Where(e => e.Contains(filterCommand[2])).ToList();

                                        //keeping the elements which do not apply to the filter
                                        guests = guests.Where(e => !e.Contains(filterCommand[2])).ToList();
                                    }


                                    break;
                            }

                            break;

                        case "remove filter":
                            if(history.ContainsKey(filterCommand[1] + " " + filterCommand[2]))
                            {
                                guests.AddRange(history[filterCommand[1] + " " + filterCommand[2]]);
                                history.Remove(filterCommand[1] + " " + filterCommand[2]);
                            }
                            break;

                           
                    }
                };

            //adding commands unitl receive print
            string enterFilterCommand = Console.ReadLine();
            while(!enterFilterCommand.Equals("print",StringComparison.OrdinalIgnoreCase))
            {
                currentFilterAction(enterFilterCommand.Split(","), people, addedFilters);
                enterFilterCommand = Console.ReadLine();
            }

            //printing guests
            switch(people.Count)
            {
                case 0:
                    Console.WriteLine("No one will come");
                    break;

                default:
                    StringBuilder sb = new StringBuilder();
                    people.Select(e => { sb.Append(e + Environment.NewLine); return e; });
                    Console.WriteLine(sb.ToString());
                    break;
            }

          

        }








         private static void PartyIvancho()
        {
            List<string> currentGuests = Console.ReadLine().Split(" ", StringSplitOptions.RemoveEmptyEntries)
                .ToList();
            string enterCommand = Console.ReadLine();


            Action<string[], List<string>> executeCommand = (a, b) =>
             {
                 switch(a[0].ToLower())
                 {
                     case "double":
                         switch(a[1].ToLower())
                         {
                             case "startswith":
                                 b = b.Select(e =>
                                  {
                                      if (e.StartsWith(a[2]))
                                      {
                                          b.Add(e);
                                      }
                                      return e;
                                  }
                                  ).ToList();
                                 break;

                             case "endswith":
                                 b = b.Select(e =>
                                 {
                                     if (e.EndsWith(a[2]))
                                     {
                                         b.Add(e);
                                     }
                                     return e;
                                 }
                                  ).ToList();
                                 break;
                         }

                         break;

                     case "remove":
                         switch (a[1].ToLower())
                         {
                             case "startswith":
                                 b = b.Where(e => !e.StartsWith(a[2])).ToList();
                                 break;
                             case "endswith":
                                 b = b.Where(e => !e.EndsWith(a[2])).ToList();
                                 break;
                         }
                         

                         break;
                 }



             };

            string[] commandData;
            while(!enterCommand.Equals("party!",StringComparison.OrdinalIgnoreCase))
            {
                commandData = enterCommand.Split();

                executeCommand(commandData, currentGuests);
                enterCommand = Console.ReadLine();
                
            }

        }

        private static void DivisibleRangeOfSequeneLinq()
        {
            int number;
            enterRange:
            try
            {
                Console.Write("Enter range: ");
                number = int.Parse(Console.ReadLine());

            }
            catch(InvalidCastException exc)
            {
                goto enterRange;
            }


            int[] sequence = Console.ReadLine().Split(" ", StringSplitOptions.RemoveEmptyEntries)
                .Select(int.Parse).ToArray();

            Func<int, int[], bool> checkIfDivisible = (a, b) =>
            {
                bool isDivisible = true;
                foreach (var item in b)
                {
                    if (a % item != 0)
                    {
                        isDivisible = false;
                    }
                }
                return isDivisible;
            };


            StringBuilder sb = new StringBuilder();
            Action<int, int[]> addElementsDivisibleSequence = (a, b) =>
             {
                 for (int i = 1; i <= a; i++)
                 {
                     if (checkIfDivisible(i, b))
                     {
                         sb.Append(i + " ");
                     }
                 }
             };

            addElementsDivisibleSequence(number, sequence);
            Console.WriteLine(sb.ToString());
                
         
        }


      


        // custom comparator task scope of methods used together
        private static void CustomComparator()
        {
            int[] numbers = Console.ReadLine().Split(" ",StringSplitOptions.RemoveEmptyEntries).Select(int.Parse)
                .ToArray();
            Array.Sort(numbers,(a,b)=>customEvenComaprator(a,b));
            Console.WriteLine(String.Join(",",numbers));

        }

        //custom func that works as comparator
       private static Func<int, int, int> customEvenComaprator = (a, b) =>
        {
            if (a % 2 == 0 && b % 2 == 0)
            {
                return a.CompareTo(b);
            }
            else if (a % 2 != 0 && b % 2 == 0)
            {
                return 1;
            }
            else
            {
                return -1;
            }
        };
        //-----------------------------
       

        private static void PredicateByNames()
        {

            int length;
        Addlength:
            Console.Clear();
            try
            {
                Console.Write("Enter length: ");
                length = int.Parse(Console.ReadLine());
            }
            catch(InvalidCastException exc)
            {
                goto Addlength;
            }

            StringBuilder sb = new StringBuilder();
            string[] names = Console.ReadLine().Split(" ", StringSplitOptions.RemoveEmptyEntries)
                .Where(n => n.Length <= length)
                .Select(n=> { sb.Append(n + Environment.NewLine); return n; })
                .ToArray();
            Console.WriteLine();
            Console.WriteLine(sb.ToString());

        }

        private static void ReverseFilter()
        {
        int[] elements = Console.ReadLine().Split(" ", StringSplitOptions.RemoveEmptyEntries)
                .Select(int.Parse).ToArray();

            int elementToExclude;
        AddElementToExclude:
            Console.Clear();
            try
            {
                Console.Write("enter element to exclude: ");
                elementToExclude = int.Parse(Console.ReadLine());
            }
            catch(InvalidCastException exc)
            {
                goto AddElementToExclude;
            }

           


            elements = elements.Where(e => e != elementToExclude).ToArray();
            Array.Reverse(elements);
            Console.WriteLine(String.Join(",", elements));
           
        }

        



        private static void AppliedArithmetics()
        {
            int[] elements = Console.ReadLine().Split(" ", StringSplitOptions.RemoveEmptyEntries)
                .Select(e => int.Parse(e))
                .ToArray();

            Action<string, int[]> currentActionUpponData = (e, elements) =>
             {
                 StringBuilder sb = new StringBuilder();
                 switch (e.ToLower())
                 {
                     case "add":
                         elements = elements.Select(e => e + 1).ToArray();
                         break;
                     case "multiply":
                         elements = elements.Select(e => e * 2).ToArray();
                         break;
                     case "print":
                         elements.Select(e => { sb.Append(e + " "); return e; });
                         Console.WriteLine(sb.ToString().Trim());
                         break;


                 }
             };

            string enterCommand = Console.ReadLine();
            while(!enterCommand.Equals("end",StringComparison.OrdinalIgnoreCase))
            {
                currentActionUpponData(enterCommand, elements);
                enterCommand = Console.ReadLine();
            }



        }


         private static void EvenNumbersLinq()
        {
            Console.WriteLine(String.Join(",", Console.ReadLine().Split(" ",StringSplitOptions.RemoveEmptyEntries)
                .Select(e => int.Parse(e))
                .Where(e => e % 2 == 0)
                .OrderBy((e)=>e)).ToArray());
                       
        }

        public static void FilterByAgeLinq()
        {
            //func to return the parsed age
            Func<string, int> getCurrentAge = e => int.Parse(e.Split(", ", StringSplitOptions.RemoveEmptyEntries)[1]);

            int numberPeople=-1;
            try
            {
                Console.Write("Enter number of people: ");
                numberPeople = int.Parse(Console.ReadLine());
            }
            catch(InvalidCastException exc)
            {
                FilterByAgeLinq();
            }

            string[] peopleData = new string[numberPeople];
            int counter = 0;
            while(numberPeople-- >0)
            {
                peopleData[counter] = Console.ReadLine();
                counter++;

            }
            string filterBy = Console.ReadLine();
            int ageFilter = int.Parse(filterBy.Split()[1]);
            string[] filteredPeople;
            StringBuilder sb = new StringBuilder();
            switch(filterBy.Split()[0].ToLower())
            {
               
                case "younger":
                    filteredPeople = peopleData.Where(e => getCurrentAge(e) < ageFilter)
                        .Select(e=> { sb.Append(e + Environment.NewLine); return e;  })
                        .ToArray();
                    Console.WriteLine(sb.ToString());
            
                    break;

                case "older":
                    filteredPeople = peopleData.Where(e => getCurrentAge(e) > ageFilter)
                       .Select(e => { sb.Append(e + Environment.NewLine); return e;  })
                       .ToArray();
                    Console.WriteLine(sb.ToString());
                    break;
           
            }

           
        }

        private static void UpperLowerBoundEvenOddLine()
        {
            int[] enterBounds = Console.ReadLine().Split().Select(e => int.Parse(e)).ToArray();
            string filterBy = Console.ReadLine();

            //FuncToReturn array with range filtered by 
            Func<string, int[], int[]> currentFilteredResult = (a, b) =>
            {

                int[] elementsToReturn;

                StringBuilder sb = new StringBuilder();
                switch (filterBy.ToLower())
                {
                    case "even":
                        for (int i = b[0]; i <= b[1]; i++)
                        {
                            if (i % 2 == 0)
                            {
                                sb.Append(i + " ");
                            }
                        }
                        break;
                    case "odd":
                        for (int i = b[0]; i <= b[1]; i++)
                        {
                            if (i % 2 != 0)
                            {
                                sb.Append(i + " ");
                            }
                        }
                        break;
                }
                elementsToReturn = sb.ToString().Trim().Split().Select(e => int.Parse(e)).ToArray();

                return elementsToReturn;
            };


            StringBuilder sb = new StringBuilder();
            Action<int> addElementToStringBuilder = e => sb.Append(e + " ");

            var result = currentFilteredResult(filterBy, enterBounds).Select(e=> { addElementToStringBuilder(e); return e; });

                

            
           
            
        }

   



    //-------------------------------

    //Files
    //-------------------------------

    public static void WordsCount()
        {
            Console.Write("Enter string to enter it in file: ");
            string[] currentWords = Console.ReadLine().Split("|");
            var currentWriter = new StreamWriter("TextFile1.txt");      //file filled with sentences

            string[] lineSentence;
            using (currentWriter)
            {
                for(int i = 0; i < currentWords.Length; i++)
                {
                    currentWriter.WriteLine(currentWords[i]);
                }
            }
                    
            //the words we need to check for (adding them in array so that we can transfer data to file)
                Console.Write("Enter words to find count: ");
            string[] wordsToFind = Console.ReadLine().Split();


            //the file which will contain the list fo words we need to check
            currentWriter = new StreamWriter("TextFile.txt");
            using (currentWriter)
            {
                for(int i =0;i<wordsToFind.Length;i++)
                {
                    currentWriter.WriteLine(wordsToFind[i]);
                }
            }

            //current stream that is connected to file if exists or creates and opens it (this is used as first arg in stremW/R)
            FileStream currentResult = new FileStream("WordsCountResult.txt",FileMode.OpenOrCreate);
            currentWriter = new StreamWriter(currentResult);

            string[] currentCount=null;          //array for gettng all equal words and getting their count
            using (currentWriter)
            {
                var readerForListWords = new StreamReader("TextFile1.txt");
                using (readerForListWords)
                {
                  
                    while(!readerForListWords.EndOfStream)
                    {
                        var readWord = readerForListWords.ReadLine();

                        // this works on the file with sentences
                        var currentReaderForSentences = new StreamReader("TextFile.txt");
                        using (currentReaderForSentences)
                        {
                            while(!currentReaderForSentences.EndOfStream)
                            {
                                currentCount = currentReaderForSentences.ReadLine().Split()
                                .Where(e => !e.Equals(readWord, StringComparison.OrdinalIgnoreCase)).ToArray();
                               
                            }
                            currentWriter.WriteLine(readWord + "->" + currentCount.Length);

                        }

                    }
                    


                }

            }


            //readinf from the result file
            var currentReaderResult = new StreamReader("WordsCountResult.txt");
            StringBuilder sb = new StringBuilder();
            using (currentReaderResult)
            {
                while(!currentReaderResult.EndOfStream)
                {
                    sb.Append(currentReaderResult.ReadLine() + Environment.NewLine);
                }
            }

            Console.WriteLine(sb.ToString());

            currentResult.Dispose();

        }
        public static void AddNumericsToFileLines()
        {
            //enter content from console
            int counter = 1;
            string[] fileContent = Console.ReadLine().Split().Select(e=>
            {
                return $"{counter++}: {e} ";
               
            }).ToArray();

            //add content to file
            using (var writer = new StreamWriter("TextFile.txt"))
            {
                for(int i =0;i<fileContent.Length;i++)
                {
                    writer.WriteLine(fileContent[i]);
                }
            }


            //display content of file on the console
            StringBuilder sb = new StringBuilder();


            //method1
            // using (var fileReader = new StreamReader("TextFile.txt"))
            // {
            //     while(!fileReader.EndOfStream)
            //    {
            //        sb.Append(fileReader.ReadLine());
            //        sb.Append(Environment.NewLine);

            //    }
            //  }


            //method2
            List<string> currentDataInFile = File.ReadAllLines("TextFile.txt").ToList();
            for(int i = 0; i < currentDataInFile.Count - 1; i++)
            {
                sb.Append(currentDataInFile[i] + Environment.NewLine);
            }

            //display content on console
            Console.WriteLine(sb.ToString());
            

        }


        public static void ReadOddLines()
        {
            FileStream file = new FileStream("TextFile.txt", FileMode.Open);
            string[] dataInFile = Console.ReadLine().Split();

            

            using (var fileWriter = new StreamWriter(file,Encoding.UTF8))
            {
                for (int i = 0; i < dataInFile.Length; i++)
                {
                    fileWriter.WriteLine(dataInFile[i]);
                }
            }

           
            StringBuilder sb = new StringBuilder();
            using (var fileReader = new StreamReader("TextFile.txt"))
            {
                int counter = 0;
                while (!fileReader.EndOfStream)
                {
                    var readLine = fileReader.ReadLine();
                    switch (counter % 2)
                    {
                        case 1:
                            sb.Append(readLine);
                            sb.Append(Environment.NewLine);
                            counter++;
                            break;
                        default:
                            counter++;
                            break;
                    }

                }
            }

            Console.WriteLine(sb.ToString());
        }



        //Softuni Advanced Sets and Dicts
        //----------------------------------------------------------------------------------------
        


         public static void VlogerTask()
        {
            //the 0 index of the value is following
            //the 1 index of the value is followers
            Dictionary<string, HashSet<string>[]> currentVloger = new Dictionary<string, HashSet<string>[]>();

            string enterCommand;
            string[] currentCommands;
            while (true)
            {
                try
                {
                    enterCommand = Console.ReadLine();

                    currentCommands = enterCommand.Split();

                    switch (currentCommands[1].ToLower())
                    {
                        case "joined":
                            if (!currentVloger.ContainsKey(currentCommands[0]))
                            {
                                currentVloger.Add(currentCommands[0], new HashSet<string>[2]);

                            }
                            break;
                        case "followed":
                            if (currentVloger.ContainsKey(currentCommands[1]) && currentVloger.ContainsKey(currentCommands[0]))
                            {
                                currentVloger[currentCommands[1]][1].Add(currentCommands[0]);
                                currentVloger[currentCommands[0]][0].Add(currentCommands[1]);
                            }
                            break;
                    }
                }
                catch(IndexOutOfRangeException exc)
                {
                    goto printPhase;
                }
            }

        printPhase:
            currentVloger = currentVloger.OrderByDescending(e => e.Value[1]).ThenBy(e => e.Value[0]).ToDictionary(e => e.Key, e => e.Value);
            StringBuilder sb = new StringBuilder();
            string famouseVloger=" ";
            foreach(var item in currentVloger)
            {
                sb.Append($"Most famous vloger: {item.Key} followers: {item.Value[1]} and {item.Value[0]} following");
                sb.Append(Environment.NewLine);
                famouseVloger = item.Key;
                foreach(var follower in item.Value[1])
                {
                    sb.Append($"Follower: {follower}");
                    sb.Append(Environment.NewLine);
                }

                break;
            }

            currentVloger.Remove(famouseVloger);
            Console.WriteLine(sb.ToString());
            sb.Clear();

            int count = 2;
            foreach(var item in currentVloger)
            {
                sb.Append($"{count}: {item.Key} Followers:{item.Value[1]} following {item.Value[0]}");
                sb.Append(Environment.NewLine);
            }
            Console.WriteLine(sb.ToString());

        }

        public static void SoftuniParty()
        {
            HashSet<string> regular = new HashSet<string>();
            HashSet<string> vip = new HashSet<string>();


            string enterCommand;
            while (true)
            {
                enterCommand = Console.ReadLine();
                if (enterCommand.Equals("Party", StringComparison.OrdinalIgnoreCase))
                {
                    goto commandForGuestsCome;
                }
                else
                {
                    if (Char.IsDigit(enterCommand[0]))
                    {
                        vip.Add(enterCommand);
                    }
                    else
                    {
                        regular.Add(enterCommand);
                    }
                }

            }


           
            commandForGuestsCome:

            HashSet<string> guestsWhoArrived = new HashSet<string>();
            while (true)
            {
                enterCommand = Console.ReadLine();
                if (enterCommand.Equals("End", StringComparison.OrdinalIgnoreCase))
                {
                    break;
                }

                if (Char.IsDigit(enterCommand[0]) && vip.Contains(enterCommand))
                {
                    guestsWhoArrived.Add(enterCommand);
                }
                else if(!(Char.IsDigit(enterCommand[0]))&& regular.Contains(enterCommand))
                {
                    guestsWhoArrived.Add(enterCommand);
                }
            }

            Console.WriteLine(guestsWhoArrived.Count);
           foreach(var item  in guestsWhoArrived)
            {
                Console.WriteLine(item);
            }
        }

        public static void ParkingLot()
        {
            HashSet<string> currentParkingLot = new HashSet<string>();
            string enterCommand;
            string[] commandsData;
            while (true)
            {
                enterCommand = Console.ReadLine();
                if (enterCommand.Equals("End"))
                {
                    break;
                }

                commandsData = enterCommand.Split(",");
                switch (commandsData[0])
                {
                    case "OUT":
                        if (currentParkingLot.Contains(commandsData[1]))
                        {
                            currentParkingLot.Remove(commandsData[1]);
                        }
                        break;

                    case "IN":
                        currentParkingLot.Add(commandsData[1]);

                        break;
                }

                

            }

            switch (currentParkingLot.Count)
            {
                case 0:
                    Console.WriteLine("No Cars left");
                    break;
                default:
                    foreach (var item in currentParkingLot)
                    {
                        Console.WriteLine(item);
                    }
                    break;
            }

            
        }


        public void AverageGradesStudent()
        {
            Dictionary<string, List<double>> currentStudents = new Dictionary<string, List<double>>();
            int enterNumberStudnets = int.Parse(Console.ReadLine());

            string[] studentData;
            while(enterNumberStudnets-- > 0)
            {
                studentData = Console.ReadLine().Split();
                if (!currentStudents.ContainsKey(studentData[0]))
                {
                    currentStudents.Add(studentData[0], new List<double>());
                }

                currentStudents[studentData[0]].Add(double.Parse(studentData[1]));
            }

            StringBuilder sb = new StringBuilder();
            currentStudents.Select(e =>
            {
                sb.Append(e.Key + "-> ");
                sb.Append(String.Join(" ", e.Value));
                sb.Append(String.Format($" Average:{e.Value.Average():2F}"));
                sb.Append(Environment.NewLine);
                return 0;
            });

            Console.WriteLine(sb.ToString());
        }

        public void CountSomeValues()
        {
            Dictionary<string, int> currentCountOfElements = new Dictionary<string, int>();
            double[] numbers = Console.ReadLine().Split().Select(e =>
           {
               if (!currentCountOfElements.ContainsKey(e))
               {
                   currentCountOfElements.Add(e, 0);
               }

               currentCountOfElements[e]++;
               return double.Parse(e);


            }).ToArray();

            StringBuilder sb = new StringBuilder();
            foreach(var item in currentCountOfElements)
            {
                sb.Append(item.Key + " ->" + item.Value + " Times");
                sb.Append(Environment.NewLine);
            }
            Console.WriteLine("Average of the numbers is {0}", numbers.Average());
        }

        public static void Ranking()
        {
            HashSet<string> currentContests = new HashSet<string>();
            StringBuilder sb = new StringBuilder();
            
            string[] contestPasswords;
            while (true)
            {
                try
                {

                    contestPasswords = Console.ReadLine().Split(":");
                    sb.Append(contestPasswords[0] + " " + contestPasswords[1]);
                    if (!currentContests.Contains(sb.ToString()))
                    {
                        currentContests.Add(sb.ToString());
                        sb.Clear();
                    }
                    else
                    {
                        sb.Clear();
                    }

                }
                catch(IndexOutOfRangeException exception)
                {
                    goto enterCandidatesPart;
                }
            }

        enterCandidatesPart:

            switch (sb.Length)      //clears if necessary
            {
                case 0:

                    break;
                default:
                    sb.Clear();
                    break;
            }

            Dictionary<string, Dictionary<string, int>> currentStudents = new Dictionary<string, Dictionary<string, int>>();
            string[] studentData;
            while (true)
            {

                try
                {

                    studentData = Console.ReadLine().Split("=>");
                    sb.Append(studentData[0] + " " + studentData[1]);

                    if (currentContests.Contains(sb.ToString()))
                    {

                        if (!currentStudents.ContainsKey(studentData[2]))
                        {
                            currentStudents.Add(studentData[2], new Dictionary<string, int>());
                        }

                        if (!currentStudents[studentData[2]].ContainsKey(studentData[0]))
                        {
                            currentStudents[studentData[2]].Add(studentData[0], int.Parse(studentData[3]));
                        }
                        else
                        {
                            if (int.Parse(studentData[3]) > currentStudents[studentData[2]][studentData[0]])
                            {
                                currentStudents[studentData[2]][studentData[0]] = int.Parse(studentData[3]);
                            }
                        }


                        sb.Clear();

                    }
                    else
                    {
                        sb.Clear();
                    }
                }
                catch (IndexOutOfRangeException exc)
                {
                    goto printValues;
                }

                }


        printValues:
            sb.Clear();
            currentStudents = currentStudents.OrderBy(e => e.Value.Values.Sum()).ToDictionary(e=>e.Key,e=>e.Value);
            string idealCandidate=null;
            int points = 0;
            foreach(var item in currentStudents)
            {
                idealCandidate = item.Key;
                points = item.Value.Values.Sum();
                break;
            }

            sb.Append($"Ideal candidate is {idealCandidate} with {points} points");
            Console.WriteLine(sb.ToString());
            sb.Clear();
            foreach(var item in currentStudents)
            {
                sb.Append(item.Key);
                sb.Append(Environment.NewLine);
                foreach(var currentCourseInCl in item.Value)
                {
                    sb.Append("# " + currentCourseInCl.Key + " ->" + currentCourseInCl.Value);
                    sb.Append(Environment.NewLine);
                }
            }

            Console.WriteLine(sb.ToString());
            



        }

        private static void ShopProducts()
        {
            Dictionary<string, Dictionary<string, double>> currentShops = new Dictionary<string, Dictionary<string, double>>();

            string enterCommand = Console.ReadLine();
            string[] commandData;
            while (true)
            {
                if (enterCommand.Equals("Revision", StringComparison.OrdinalIgnoreCase))
                {
                    break;
                }


                commandData = enterCommand.Split();

                if (!currentShops.ContainsKey(commandData[0]))
                {
                    currentShops.Add(commandData[0], new Dictionary<string, double>());
                    currentShops[commandData[0]].Add(commandData[1], double.Parse(commandData[2]));
                }
                else
                {
                    currentShops[commandData[0]][commandData[1]] = double.Parse(commandData[2]);
                    
                }

                enterCommand = Console.ReadLine();
            }
            Console.WriteLine();
            StringBuilder sb = new StringBuilder();
            foreach(var item in currentShops)
            {
                sb.Append(item.Key + "->");
                sb.Append(Environment.NewLine);
                foreach(var products in item.Value)
                {
                    sb.Append(products.Key);
                    sb.Append("->");
                    sb.Append(String.Format($"{products.Value:F3}"));
                    sb.Append(Environment.NewLine);
                }
                sb.Append("---------------------");
                sb.Append(Environment.NewLine);
            }

            Console.WriteLine(sb.ToString());

            
        }




            //---------------------------------------------------------------------------------


        //Softuni Fundamentals Exam Collection
        //-----------------------------------------------------------------------------------------



            


        public static void Pirates()
        {
            Console.Write("Enter Pirate Name: ");
            Captain captain = new Captain(Console.ReadLine());
            Console.Clear();
            Dictionary<string, int[]> currentTowns = new Dictionary<string, int[]>();
            string enterTownCommand = Console.ReadLine();
            string[] townData;
            while (!enterTownCommand.Equals("Sail", StringComparison.OrdinalIgnoreCase))
            {
                townData = enterTownCommand.Split("||");
                if (!currentTowns.ContainsKey(townData[0]))
                {
                    currentTowns.Add(townData[0], new int[2]);
                    currentTowns[townData[0]][0] = int.Parse(townData[1]);
                    currentTowns[townData[0]][1] = int.Parse(townData[2]);
                }
                else
                {
                    currentTowns[townData[0]][0] += int.Parse(townData[1]);
                    currentTowns[townData[0]][1] += int.Parse(townData[2]);
                }

                enterTownCommand = Console.ReadLine();
            }


            string enterEventCommand = Console.ReadLine();
            string[] eventData;

            while (enterEventCommand.Equals("End", StringComparison.OrdinalIgnoreCase))
            {
                eventData = enterEventCommand.Split("=>");
                ExecutePirateEventCommand(captain, currentTowns, eventData);
                enterEventCommand = Console.ReadLine();
            }

             if (currentTowns.Count == 0)
             {
              Console.WriteLine("No more towns");
               Environment.Exit(0);
             }
            else 
            {
                Console.WriteLine("Towns Left: ");

                foreach (var item in currentTowns)
                {
                    Console.WriteLine(item.Key + " People:" + item.Value[0] + "  Gold:" + item.Value[1]);
                }

            }
            

           


        }

        private static void ExecutePirateEventCommand(Captain currentCaptain, Dictionary<string,int[]> currentTowns,params string[] currentCommand)
        {
            switch (currentCommand[0].ToLower())
            {
                case "plunder":
                    if (currentTowns.ContainsKey(currentCommand[1]))
                    {

                        if (int.Parse(currentCommand[2]) > currentTowns[currentCommand[1]][0])
                        {
                            currentCaptain.KillPeople(currentTowns[currentCommand[1]][0]);
                            currentCaptain.IncreaseGold(currentTowns[currentCommand[1]][1]);
                            currentTowns.Remove(currentCommand[1]);
                            return;
                        }
                        
                        currentTowns[currentCommand[1]][0] -= int.Parse(currentCommand[2]);     //people killed
                        currentTowns[currentCommand[1]][1] -= int.Parse(currentCommand[3]);

                        if(currentTowns[currentCommand[1]][0]<=0 || currentTowns[currentCommand[1]][1] <= 0)
                        {
                            currentTowns.Remove(currentCommand[1]);
                        }
                    }
                    break;

                case "prosper":
                    if (int.Parse(currentCommand[2]) < 0)
                    {
                        Console.WriteLine("Gold cannot be negative");
                        return;
                    }

                    currentTowns[currentCommand[1]][1] += int.Parse(currentCommand[2]);

                    break;
            }

        }


        private struct Captain
        {
            public string Name { private set; get; }
            public int Gold { private set; get; }
            public int PeopleKilled { private set; get; }

            public Captain(string name): this()
            {
                this.Name = name;
                this.Gold = 0;
                this.PeopleKilled = 0;
            }

            public void IncreaseGold(int currentGoldPlundered)
            {
                if (currentGoldPlundered < 0)
                {
                    Console.WriteLine("Current Gold cannot be negative");
                    return;
                }

                this.Gold += currentGoldPlundered;
            }

            public void KillPeople(int people)
            {
                this.PeopleKilled += people;
            }




        }



        public static void EmojiFinder()
        {
            string enterString = Console.ReadLine();
            var treshHoldSum = GetTreshHoldSum(enterString.Split().Where(e=>e.Any(char.IsDigit)).ToArray());
            Regex currentRegex = new  Regex("[\\:|\\*]{2}(?<emoji>[A-Z][a-z]+)[\\:|\\*]{2}");
            var results = currentRegex.Matches(enterString);
            Dictionary<string, int> EmojiTresh = new Dictionary<string, int>(results.Count);

            string currentEmojiFound;
            foreach(Match item in results)
            {
                currentEmojiFound = item.Groups["emoji"].Value.Trim(new char[] { ':', '*' });
                if (!EmojiTresh.ContainsKey(currentEmojiFound) && currentEmojiFound.Length>=3)
                {
                    EmojiTresh.Add(currentEmojiFound, GetEmojiTresh(currentEmojiFound));
                }
            }

            EmojiTresh = EmojiTresh.Where(e => e.Value == treshHoldSum).ToDictionary(e=>e.Key,e=>e.Value);
            foreach(var item in EmojiTresh)
            {
                Console.WriteLine(item.Key);
            }
                

        }

        private static int GetTreshHoldSum(string[] elements)
        {
            int treshHoldSum = 1;
            foreach(var item in elements)
            {
                if(item.Length==1 && Char.IsDigit(item[0]))
                {
                    treshHoldSum *= int.Parse(item);
                }
                else if (item.Length > 1)
                {
                    foreach(var currentElement in item.ToCharArray())
                    {
                        if (Char.IsDigit(currentElement))
                        {
                            treshHoldSum *= currentElement-0;
                        }
                    }
                }
            }
            return treshHoldSum;
        }

        private static int GetEmojiTresh(string currentEmoji)
        {
            return currentEmoji.ToCharArray().Select(e => (int)e).Aggregate((a, b) => a + b);
        }

        public static void ActivationKey()
        {
            string enterRawKey = Console.ReadLine();
            StringBuilder sb = new StringBuilder(enterRawKey);


            string enterCommands = Console.ReadLine();
            while (!enterCommands.Equals("Generate!", StringComparison.OrdinalIgnoreCase))
            {
                ExecuteActivationKeyCommands(sb, enterCommands.Split(">>>"));
                enterCommands = Console.ReadLine();
            }

            Console.WriteLine("Code generated: " + " " + sb.ToString());
        }

        private static void ExecuteActivationKeyCommands(StringBuilder sb, params string[] commands)
        {
            switch (commands[0].ToLower())
            {
                case "flip":
                    var text = sb.ToString().Substring(int.Parse(commands[2]), int.Parse(commands[3]));
                    switch (commands[1].ToLower())
                    {
                        case "upper":
                            sb.Remove(int.Parse(commands[2]), int.Parse(commands[3]));
                            sb.Insert(int.Parse(commands[2]), text.ToUpper());
                            break;
                        case "lower":
                            sb.Remove(int.Parse(commands[2]), int.Parse(commands[3]));
                            sb.Insert(int.Parse(commands[2]), text.ToLower());
                            break;
                    }

                    Console.WriteLine(sb.ToString());

                    break;
                case "slice":
                    sb.Remove(int.Parse(commands[1]), int.Parse(commands[2]));
                    Console.WriteLine(sb.ToString());
                    break;
                case "contains":
                    if (sb.ToString().Contains(commands[1]))
                    {
                        Console.WriteLine(sb.ToString() + "Contains " + commands[1]);
                    }
                    else
                    {
                        Console.WriteLine("Substring not found");
                    }
                    break;
            }
        }

        public static void InventorySystem()
        {
            List<string> currentInventory = new List<string>();
            string[] enterInventoryDefault = Console.ReadLine().Split(", ");
            currentInventory.AddRange(enterInventoryDefault);

            string enterCommand = Console.ReadLine();
            while (!enterCommand.Equals("Craft!", StringComparison.OrdinalIgnoreCase))
            {

            }


        }
        private static void ExecuteInventoryCommands(string[] commands, List<string> currentInventorty)
        {
            switch (commands[0].ToLower())
            {
                case "drop":
                    if (currentInventorty.Contains(commands[1]))
                        currentInventorty.Remove(commands[1]);

                    break;
                case "collect":
                    if (!currentInventorty.Contains(commands[1]))
                        currentInventorty.Add(commands[1]);
                    break;
                case "combine items":
                    if (currentInventorty.Contains(commands[1].Split(":")[0]))
                    {
                        if(currentInventorty.IndexOf(commands[1].Split(":")[0])== currentInventorty.Count - 1)
                        {
                            currentInventorty.Add(commands[1].Split()[1]);
                        }
                        else if (currentInventorty.IndexOf(commands[1].Split()[0]) == 0)
                        {
                            currentInventorty.Insert(0, commands[1].Split()[1]);
                        }
                        else
                        {

                        }
                    }
                    break;
            }
        }




        public static void MuQuest()
        {
            string enterName = Console.ReadLine();
            MuCharacter currentCharacter = new MuCharacter(enterName);

           
            
            string enterDungeons = Console.ReadLine();
            string[] currentDungeons = enterDungeons.Split("|").ToArray();

            string currentDungeon=null;      //dungeon you reached // current
            int roomCounter = 0;
            string[] dungeonData;
            while (currentCharacter.IsAlive)
            {
                
                dungeonData = currentDungeons[roomCounter].Split();
                currentDungeon = dungeonData[0];
                ExecuteMuQuestDungeonCommand(currentCharacter,dungeonData);
                if (roomCounter == currentDungeons.Length - 1)
                {
                    break;
                }
                roomCounter++;
            }

            if(!currentCharacter.IsAlive && roomCounter == currentDungeons.Length - 1)
            {
                Console.WriteLine($"You died in the last room {currentDungeon}");
            }
            else if(currentCharacter.IsAlive && roomCounter == currentDungeons.Length - 1)
            {
                Console.WriteLine("You made it {0} hp with {1} in the bag", currentCharacter.Health, currentCharacter.Bitcoins);
            }
            else
            {
                Console.WriteLine("You made it to {0} room with the name {1}", roomCounter, currentDungeon);
            }



        }

        private  struct MuCharacter
        {
            private string name;
            private int health;
            private int bitcoins;
            private bool isAlive;

            public MuCharacter(string name) : this()
            {
                this.Health = 100;
                this.Bitcoins = 0;
                this.Name = name;
                this.IsAlive = true;
            }

            public string Name { private set; get; }
            public int Health { private set; get; }
            public int Bitcoins { private set; get; }
            public bool IsAlive { private set; get;}

            public void IncreaseHealth(int healthPointsReceived,bool isOverHundred)
            {
                if (isOverHundred)
                {
                    this.Health = 100;
                    return;
                }
                this.Health += healthPointsReceived;
                
   
            }

            public void AddBitcoinsToLoot(int bitCoinsReceived)
            {
                this.Bitcoins += bitCoinsReceived;

            }

            public void FightMonster(int monsterDamage, string monsterName)
            {
                this.Health -= monsterDamage;
                if (this.Health <= 0)
                {
                    this.IsAlive = false;
                    Console.WriteLine("You Died");
                    return;
                }

                Console.WriteLine("You slayed {0}", monsterName);

            }

        }

        private static void ExecuteMuQuestDungeonCommand(MuCharacter character, params string[] currentData)
        {
            switch (currentData[0].ToLower())
            {
                case "potion":
                    if (character.Health + int.Parse(currentData[1]) <= 100)
                    {
                        character.IncreaseHealth(int.Parse(currentData[1]),false);
                        Console.WriteLine("You healed for {0}", int.Parse(currentData[1]));
                    }
                    else
                    {
                        Console.WriteLine("You healed for {0}", 100-character.Health);
                        character.IncreaseHealth(int.Parse(currentData[1]), true);
                        
                    }
                    
                    break;

                case "chest":
                    character.AddBitcoinsToLoot(int.Parse(currentData[1]));
                    Console.WriteLine("You looted {0}", int.Parse(currentData[1]));
                    break;

                default:
                    character.FightMonster(int.Parse(currentData[1]),currentData[0]);
                    break;
            }
        }

        


        public static void StudentBonuses()
        {
            int numberStudnets = int.Parse(Console.ReadLine());
            int numberLectures = int.Parse(Console.ReadLine());
            int initialBonus = int.Parse(Console.ReadLine());

            //List<double[]> currentStudentData = new List<double[]>();
            Dictionary<int, double[]> currentStudentData = new Dictionary<int, double[]>();
            double enterAttendance;
            for(int i =0; i < numberStudnets; i++)
            {
                enterAttendance = double.Parse(Console.ReadLine());
                // enterAttendance = double.Parse(Console.ReadLine());
                // currentStudentData.Add(new double[2]);
                // currentStudentData[i][0] = enterAttendance;
                // currentStudentData[i][1]= Math.Ceiling((enterAttendance / numberLectures) * (5 + initialBonus));

                currentStudentData.Add(i, new double[2]);
                currentStudentData[i][0] = enterAttendance;
                currentStudentData[i][1] = Math.Ceiling((enterAttendance / numberLectures) * (5 + initialBonus));
            }

            // currentStudentData = currentStudentData.OrderByDescending(e => e.Value[1]).ToDictionary(e => e.Key, e => e.Value);
            //var firstItem = currentStudentData.Max(e => e.Value[1]);  //gets only double value 
            var max = currentStudentData.Aggregate((l, r) => l.Value[1] > r.Value[1] ? l : r);      //works
            Console.Clear();
            //  foreach(var item in currentStudentData)
            // {
            //    Console.Write(item.Value[0] + "-> " + item.Value[1]);
            //    break;
            //
            // }
            Console.WriteLine("Attendance:"+ max.Value[0]+" Max Bonus: "+max.Value[1]);
            
            //currentStudentData = currentStudentData.OrderByDescending(e => e[1]).ToList();
          //  Console.WriteLine($"Max Bonus:{currentStudentData[0][1]} Attendance: {currentStudentData[0][0]}");
            
        }




        //------------------------------------------------------------------------------------------
        private void EqualElemSequences(List<int> numbersArray)
        {
            int bestCount = 0;
            int currentCount = 0;
            int element = 0;

            for (int i = 0; i < numbersArray.Count - 1; i++)
            {
                if (numbersArray[i] == numbersArray[i + 1])
                {
                    currentCount++;


                    if (currentCount > bestCount)
                    {
                        bestCount = currentCount;
                        element = numbersArray[i];
                    }
                }
                else
                {
                    currentCount = 0;

                }

            }

            List<int> currentSequenceElements = new List<int>(bestCount);
            for(int i = 0; i < bestCount; i++)
            {
                currentSequenceElements.Add(element);
            }

            currentSequenceElements.ForEach(e => Console.Write(e + " "));
          

        }



        private static void PolindromeWords()
        {
            string enterWord = Console.ReadLine();
            char[] lettersInWord = enterWord.ToLower().ToCharArray();
            
            Queue<char> fromEndToBeginning = new Queue<char>(lettersInWord);
            Stack<char> beginningToEnd = new Stack<char>(lettersInWord);
            bool isPolindrome = true;
            while (fromEndToBeginning.Count > 0)
            {
                if (fromEndToBeginning.Dequeue() != beginningToEnd.Pop())
                {
                    isPolindrome = false;
                    break;
                }
            }

            if (isPolindrome)
            {
                Console.WriteLine("Yes");
            }
            else
            {
                Console.WriteLine("No");
            }
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




        //Method to find Min Pos required for SelectionSrot

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
            int minElementIndex;
            for(int i = 0; i < arrayWithNumbers.Length; i++)        // we strt for the begingin of the array
            {
                minElementIndex = FindMinElementIndex(arrayWithNumbers, i);     //we find the pos of min elem from i pos to end
                if (i != minElementIndex)   //if its not the current start point we swap
                {
                    ExchangeValues(arrayWithNumbers, i, minElementIndex);
                }

            }

        }



        //Insert Sort
        private static void InsertSort(int[] arrayWithNumbers)
        {
            for(int i = 0; i < arrayWithNumbers.Length-1; i++)
            {
                for(int j = i + 1; j > 0; j--)      // if(the previous element is bigger swap them and so on if more)
                {
                    if (arrayWithNumbers[j - 1] > arrayWithNumbers[j])
                    {
                        ExchangeValues(arrayWithNumbers, j - 1, j);
                    }
                }
            }

        }

        private static void CountingSort(int[] arrayWithNumbers) //Works only for ints or any other primitiveData 
        {
          
            SortedDictionary<int, int> currentCountOfElements = new SortedDictionary<int, int>();
            
            foreach(var item in arrayWithNumbers)
            {
                if (currentCountOfElements.ContainsKey(item))
                {
                    currentCountOfElements[item]++;
                }
                else
                {
                    currentCountOfElements.Add(item, 1);
                }
                
            }

            StringBuilder sb = new StringBuilder();
            foreach(var item in currentCountOfElements)
            {
                for(int i = 0; i < item.Value; i++)
                {
                    sb.Append(item.Key + " ");
                }
            }

            arrayWithNumbers = sb.ToString().Trim().Split().Select(e=>int.Parse(e)).ToArray();

            

        }

       


        

            //-------------------------------------------------------------------------




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






