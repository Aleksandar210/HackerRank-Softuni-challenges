using System;
using System.Collections;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Dynamic;
using System.Linq;
using System.Net.Http.Headers;
using System.Reflection.PortableExecutable;
using System.Security.Cryptography;
using System.Text;
using System.Text.RegularExpressions;
using System.Transactions;

namespace SoftuniFundamentals
{
    class SoftuniTasks
    {


        public void StackSum()
        {
            int[] currentInput = Console.ReadLine().Split().Select(e => int.Parse(e)).ToArray();
            Stack<int> currentStack = new Stack<int>(currentInput);

            string enterCommand;
            string[] commandDetails;
            do
            {
                enterCommand = Console.ReadLine();
                if (!enterCommand.Equals("end", StringComparison.OrdinalIgnoreCase))
                {
                    commandDetails = enterCommand.Split();
                    ExecuteStackSumCommands(currentStack, commandDetails);
                }
            }
            while (!enterCommand.Equals("end", StringComparison.OrdinalIgnoreCase));

            int sum = currentStack.Aggregate((a, b) => a + b);
            Console.WriteLine(sum);

        }

        private void ExecuteStackSumCommands(Stack<int> currentStack, string[] commands)
        {
            List<int> listToHoldRemoved = new List<int>();
            HashSet<int> elementsToRemove = new HashSet<int>();
            switch (commands[0].ToLower())
            {
                case "add":
                    for(int i = 1; i < commands.Length; i++)
                    {
                        currentStack.Push(int.Parse(commands[i]));
                    }
                    break;

                case "remove":
                    for(int i = 1; i < commands.Length; i++)
                    {
                        elementsToRemove.Add(int.Parse(commands[i]));
                    }
                    listToHoldRemoved = currentStack.Where(e => !elementsToRemove.Contains(e)).ToList();
                    currentStack = new Stack<int>(listToHoldRemoved.ToArray().Reverse());
                    break;
            }
        }


        public void Rotation()
        {
            string[] elements = Regex.Split(Console.ReadLine(), "\\s+");
            int numberRotations = int.Parse(Console.ReadLine());
            while (numberRotations-- > 0)
            {
                string firstElement = elements[0];
                for (int i = 1; i < elements.Length; i++)
                {
                    elements[i - 1] = elements[i];
                }
                elements[elements.Length - 1] = firstElement;
            }

            foreach (string item in elements)
            {
                Console.Write(item + " ");
            }

        }

        public void EqualSums()
        {
            int[] numbers = Regex.Split(Console.ReadLine(), "\\s+").Select(e => int.Parse(e)).ToArray();
            int leftSum = 0;
            int rightSum = 0;
            for (int i = 0; i < numbers.Length - 1; i++)
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
                    for (int l = i + 1; l < numbers.Length; l++)
                    {
                        rightSum += numbers[l];
                    }

                    for (int k = 0; k < i; k++)
                    {
                        leftSum += numbers[k];
                    }
                }


                if (leftSum == rightSum)
                {
                    Console.Write(numbers[i] + " ");
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
                if (enterSequence.Equals("Clone Them!", StringComparison.OrdinalIgnoreCase))
                {
                    break;
                }
                else
                {
                    sequences.Add(string.Join("", Regex.Split(enterSequence, "\\s+")));

                }


            }
            while (!enterSequence.Equals("Clone Them!", StringComparison.OrdinalIgnoreCase));

            newSortedList = sequences.OrderByDescending(c => c).ToList();
            int bestIndex = GetDnaPosition(sequences, newSortedList.First());

            Console.WriteLine("Best DNA is {0} -> {1}", bestIndex, newSortedList[bestIndex - 1]);
        }

        private int GetDnaPosition(List<string> sequences, string bestSequence)
        {
            int bestIndex = 0;
            for (int i = 0; i < sequences.Count; i++)
            {
                if (sequences[i].Equals(bestSequence))
                {
                    bestIndex = i + 1;
                }
            }

            return bestIndex;
        }

        public void LadyBug()
        {
            int size = int.Parse(Console.ReadLine());
            string[] enterLadyBugIndexex = Regex.Split(Console.ReadLine(), "\\s+");

            int[] field = new int[size];
            FillField(enterLadyBugIndexex.Select(e => int.Parse(e)).ToArray(), field);
            string enterCommand;
            do
            {
                enterCommand = Console.ReadLine();
                if (enterCommand.Equals("end", StringComparison.OrdinalIgnoreCase))
                {
                    break;
                }
                else
                {
                    int indexOfBug = int.Parse(Regex.Split(enterCommand, "\\s+")[0]);
                    string command = Regex.Split(enterCommand, "\\s+")[1];
                    int length = int.Parse(Regex.Split(enterCommand, "\\s+")[2]);

                    indexOfBug += length;
                    if ((indexOfBug += length) > field.Length || (indexOfBug += length) < field.Length)
                    {

                    } else
                    {
                        if (field[indexOfBug] == 1)
                        {
                            indexOfBug += length;
                            if ((indexOfBug += length) > field.Length || (indexOfBug += length) < field.Length)
                            {

                            }
                            else
                            {
                                field[indexOfBug] = 1;
                            }
                        }
                        else
                        {
                            field[indexOfBug] = 1;
                        }
                    }


                }

            }
            while (!enterCommand.Equals("end", StringComparison.OrdinalIgnoreCase));


        }

        private void FillField(int[] indexes, int[] field)
        {

            for (int i = 0; i < field.Length; i++)
            {
                if (indexes.Contains(i))
                {
                    field[i] = 1;
                }
                else
                {
                    field[i] = 0;
                }
            }
        }


        public void Messaging()
        {
            string enterNumbers = Console.ReadLine();
            string[] indexes = enterNumbers.Split().ToArray();
            string message = Console.ReadLine();

            StringBuilder sb = new StringBuilder();

            for (int i = 0; i < indexes.Length; i++)
            {
                sb.Append(message.ElementAt(GetSumDigits(indexes[i])));
            }

            Console.WriteLine(sb.ToString());

        }

        private int GetSumDigits(string digits)
        {
            int sum = digits.ToCharArray().Select(a => int.Parse(a.ToString())).Aggregate((a, b) => a + b);
            return sum;
        }

        public void CarRace()
        {
            int[] numbers = Console.ReadLine().Split().Select(e => int.Parse(e)).ToArray();
            int leftTime = 0;
            int rightTime = 0;
            for (int i = 0, k = numbers[numbers.Length - 1]; i < numbers.Length / 2; i++, k--)
            {
                if (numbers[i] == 0)
                {
                    leftTime -= leftTime / 20;
                }
                if (numbers[k] == 0)
                {
                    rightTime -= rightTime / 20;
                }

                leftTime += numbers[i];
                rightTime += numbers[k];

            }

            if (leftTime > rightTime)
            {
                Console.WriteLine($"Winner is Right Car with {rightTime} time");
            }
            else
            {
                Console.WriteLine($"Winner is Left Car with {leftTime} time");
            }
        }

        public void SecretMessage()
        {
            List<string> currentMessage = new List<string>(Console.ReadLine().ToCharArray()
                .Select(e => e.ToString()).ToArray().ToList());
            // List<int> numbers = new List<int>(currentMessage.Where(e=> Regex.IsMatch(e, "[0-9]"))
            //   .Select(e=> {
            //      currentMessage.Remove(e);
            //      return int.Parse(e);
            //   }).ToList());

            int[] numbers = (from t in currentMessage
                             where char.IsDigit(char.Parse(t))
                             select (int.Parse(t))).ToArray();


            List<string> noWords = (from t in currentMessage
                                    where !char.IsDigit(char.Parse(t))
                                    select t).ToList();

            List<int> skip = new List<int>();
            List<int> take = new List<int>();
            StringBuilder message = new StringBuilder();
            for (int i = 0; i < numbers.Length; i++)
            {
                if (i % 2 == 0)
                {
                    take.Add(numbers[i]);
                }
                else
                {
                    skip.Add(numbers[i]);
                }
            }

            if (skip.Count > take.Count)
            {
                for (int i = 0; i < skip.Count; i++) {
                    if (i < take.Count)
                    {
                        message.Append(noWords.GetRange(0, take[i]));
                        noWords.RemoveRange(0, take[i]);
                        noWords.RemoveRange(0, skip[i]);
                    }
                }
            }
            else
            {
                for (int i = 0; i < take.Count; i++)
                {
                    if (i < skip.Count)
                    {
                        message.Append(noWords.GetRange(0, take[i]));
                        noWords.RemoveRange(0, take[i]);
                        noWords.RemoveRange(0, skip[i]);
                    }
                    else
                    {
                        message.Append(noWords.GetRange(0, take[i]));
                        noWords.RemoveRange(0, take[i]);
                    }
                }
            }
            Console.WriteLine(message.ToString());
        }


        public void MixingRules()
        {
            List<int> firstList = Console.ReadLine().Split().Select(e => int.Parse(e)).ToList();
            List<int> secondList = Console.ReadLine().Split().Select(e => int.Parse(e)).ToList();
            int length = Math.Min(firstList.Count, secondList.Count);
            List<int> currentList = new List<int>();

            int from;
            int to;
            if (firstList.Count < secondList.Count)
            {
                from = GetLastTwoElemsOfList(secondList)[1];
                to = GetLastTwoElemsOfList(secondList)[0];

            }
            else
            {
                from = GetLastTwoElemsOfList(firstList)[1];
                to = GetLastTwoElemsOfList(firstList)[0];
            }

            for (int i = 0, k = secondList.Count - 1; i < length; i++, k--)
            {
                currentList.Add(firstList[i]);
                currentList.Add(secondList[k]);

            }

            currentList.Sort();
            currentList.Where(e => e >= from || e <= to).ToList().ForEach(Console.WriteLine);



        }





        public void DrumSet()
        {
            double savings = double.Parse(Console.ReadLine());
            List<int> currentDrumSetOriginal = Console.ReadLine().Split().Select(e => int.Parse(e)).ToList();
            List<int> currentDrumSet = new List<int>(currentDrumSetOriginal.GetRange(0, currentDrumSetOriginal.Count - 1));

            string command = Console.ReadLine();
            currentDrumSet.Sort();

            while (!command.Equals("Hit them again!", StringComparison.OrdinalIgnoreCase))
            {

                int power = int.Parse(Console.ReadLine());
                currentDrumSet.Select(e => e -= power);
                savings = ReplaceDrum(currentDrumSet, currentDrumSetOriginal, savings);
                command = Console.ReadLine();

            }

            Console.WriteLine($"Gabsy has {savings} with {string.Join(" ", currentDrumSet)}");

        }
        private double ReplaceDrum(List<int> currentList, List<int> currentListOriginal, double currentSavings)
        {
            for (int i = 0; i < currentList.Count; i++)
            {
                if (currentList[i] <= 0)
                {
                    if (currentSavings >= currentListOriginal[i] * 3)
                    {
                        currentSavings -= currentListOriginal[i] * 3;
                        currentList[i] = currentListOriginal[i];

                    }
                    else
                    {
                        currentList.RemoveAt(i);
                        currentListOriginal.RemoveAt(i);
                    }
                }
            }

            return currentSavings;
        }





        private int[] GetLastTwoElemsOfList(List<int> current)
        {
            int[] a = new int[2];
            a[0] = current.Count - 1;
            a[1] = current.Count - 2;
            return a;

        }

        public void SongTask()
        {
            Dictionary<string, List<Song>> currentSongs = new Dictionary<string, List<Song>>();
            int numberSongs = int.Parse(Console.ReadLine());
            while (numberSongs-- > 0)
            {
                string enterSong = Console.ReadLine();
                string[] songData = enterSong.Split('-');
                Song currentSong = new Song(songData[0], songData[1], songData[2]);
                if (currentSongs[songData[0]] == null)
                {
                    currentSongs[songData[0]] = new List<Song>();
                    currentSongs[songData[0]].Add(currentSong);
                }
                else
                {
                    currentSongs[songData[0]].Add(currentSong);
                }
            }

            string searchBy = Console.ReadLine();

            if (currentSongs[searchBy] == null)
            {

            }
            else
            {
                currentSongs[searchBy].ForEach(e => Console.WriteLine(e.Name));
            }

        }

        public void WordSynonims()
        {
            SortedDictionary<string, List<string>> currentWordSynonims = new SortedDictionary<string, List<string>>();


            int numberWords = int.Parse(Console.ReadLine());
            numberWords *= 2;
            string enterWord;
            int counter = 1;
            Stack<string> currentStack = new Stack<string>();
            while (numberWords-- > 0)
            {
                enterWord = Console.ReadLine();
                if (counter % 2 == 0)
                {
                    if (currentWordSynonims.ContainsKey(currentStack.Peek()))
                    {
                        currentWordSynonims[currentStack.Peek()].Add(enterWord);
                    }
                    else
                    {
                        currentWordSynonims.Add(currentStack.Peek(), new List<string>());
                        currentWordSynonims[currentStack.Peek()].Add(enterWord);

                    }
                }
                else
                {
                    currentStack.Push(enterWord);
                }
                counter++;
            }

            foreach (var item in currentWordSynonims)
            {
                Console.WriteLine(item.Key + " -> ");
                foreach (var currentSynonims in item.Value)
                {
                    Console.Write(currentSynonims + " ");
                }
            }
        }
        public void TopThree()
        {
            List<int> currentNumbers = Console.ReadLine().Split().Select(int.Parse)
                .OrderByDescending(e => e).ToList();

            if (currentNumbers.Count < 3)
            {
                foreach (var item in currentNumbers)
                {
                    Console.Write(item + " ");
                }

            }
            else
            {
                for (int i = 0; i < 3; i++)
                {
                    Console.Write(currentNumbers[i] + " ");
                }
            }
        }


        public void DataTypes()
        {
            string enter = Console.ReadLine();
            string enterData = Console.ReadLine();
            if (enter.Equals("string", StringComparison.OrdinalIgnoreCase))
            {
                DataTypeMethod(enterData);
            }
            else if (enter.Equals("int", StringComparison.OrdinalIgnoreCase))
            {
                DataTypeMethod(int.Parse(enterData));
            }
            else
            {
                DataTypeMethod(double.Parse(enterData));
            }
        }

        private void DataTypeMethod(int type)
        {
            Console.WriteLine(type * 2);

        }

        private void DataTypeMethod(double type)
        {
            Console.WriteLine("{0:2f}", type * 1.5);

        }

        private void DataTypeMethod(string type)
        {
            Console.WriteLine("$" + type + "$");

        }

        public void CenterPoint()
        {
            int[,] currentCoordinates = new int[2, 2];
            int enterX;
            int enterY;
            for (int i = 0; i < 2; i++)
            {
                enterX = int.Parse(Console.ReadLine());
                enterY = int.Parse(Console.ReadLine());
                currentCoordinates[i, 0] = enterX;
                currentCoordinates[i, 1] = enterY;
            }

            int[] printThis = GetClosest(currentCoordinates);
            Console.WriteLine(printThis[0] + "," + printThis[1]);
        }

        private int[] GetClosest(int[,] coordinates)
        {

            int[] allX = new int[coordinates.GetLength(0)];
            for (int i = 0; i < coordinates.GetLength(0); i++)
            {
                allX[i] = coordinates[i, 0];
            }


            int[] allY = new int[coordinates.GetLength(1)];
            for (int i = 0; i < coordinates.GetLength(0); i++)
            {
                allY[i] = coordinates[i, 1];
            }

            int[] closestCoordinates = new int[2];
            closestCoordinates[0] = allX.Min();
            closestCoordinates[1] = allY.Min();

            return closestCoordinates;
        }

        public void Tribonachi()
        {
            int start = 1;
            int enter = int.Parse(Console.ReadLine());
            StringBuilder sb = new StringBuilder();
            for (int i = 1; i < enter - 1; i++)
            {
                sb.Append(i + (i - 1));
            }

            sb.Insert(0, start);

            Console.WriteLine(sb.ToString());
        }

        public void Multiplication()
        {
            int numberNegative = 0;
            int numberZeroes = 0;
            for (int i = 0; i < 3; i++)
            {
                int enter = int.Parse(Console.ReadLine());
                if (enter < 0)
                {
                    numberNegative++;
                }
                else if (enter == 0)
                {
                    numberZeroes++;
                }
            }

            if (numberZeroes > 0)
            {
                Console.WriteLine("Zero");
            } else if (numberNegative < 2 || numberNegative == 3)
            {
                Console.WriteLine("Negative");
            }
            else
            {
                Console.WriteLine("Positive");
            }

        }

        public int SmallestOfThree(int[] numbers)
        {

            return numbers.Min();
        }

        public void VolewCount()
        {
            string pattern = "[a|A|E|e|i|I|o|O|u|U]";
            string enter = Console.ReadLine();
            MatchCollection matches = Regex.Matches(enter, pattern);

            Console.WriteLine(matches.Count);
        }

        public void CharactesInRange(char a, char b)
        {
            StringBuilder sb = new StringBuilder();
            int from = (int)a;
            int to = (int)b;
            for (int i = from; i <= to; i++)
            {
                sb.Append((char)i);
            }

            Console.WriteLine(sb.ToString());

        }

        public void PasswordValidator()
        {
            Regex currentRegex = new Regex("^\\d{2,}\\w+$");
            string enterPassword = Console.ReadLine();
            if (enterPassword.Length >= 6 || enterPassword.Length < 11)
            {
                if (currentRegex.IsMatch(enterPassword))
                {
                    Console.WriteLine("Password Is Valid");
                }
                else
                {
                    Console.WriteLine("Password Is Invalid");
                }
            }
            else
            {
                Console.WriteLine("Password Is Invalid");
            }
        }

        public void AddAndSubstract()
        {
            int[] currentNumbers = new int[3];
            for (int i = 0; i < 3; i++)
            {
                currentNumbers[i] = int.Parse(Console.ReadLine());
            }

            Console.WriteLine(Substract(Sum(currentNumbers), currentNumbers[2]));
        }

        private int Sum(int[] numbers)
        {
            return numbers[0] + numbers[1];
        }

        private int Substract(int num, int num1)
        {
            return num - num1;
        }

        public void MiddleCharacters()
        {
            Console.WriteLine(GetMiddle(Console.ReadLine()));
        }

        private string GetMiddle(string word)
        {
            StringBuilder sb = new StringBuilder();
            char[] letters = word.ToCharArray();
            if (word.Length % 2 == 0)
            {
                sb.Append(letters[word.Length / 2]).Append(letters[(word.Length / 2) + 1]);
                return sb.ToString();
            }

            sb.Append(letters[word.Length / 2]);
            return sb.ToString();
        }

        public void NxN(int number)
        {
            for (int i = 0; i < number; i++)
            {
                for (int j = 0; j < number; j++)
                {
                    Console.Write(number + " ");
                }
                Console.WriteLine();
            }
        }

        public void FactorialDivision()
        {
            int number = int.Parse(Console.ReadLine());
            int secondNumber = int.Parse(Console.ReadLine());

            Console.WriteLine(GetFactorial(number) / GetFactorial(secondNumber));

        }

        private int GetFactorial(int number)
        {
            int[] current = Enumerable.Range(0, number).ToArray();
            int result = current.Aggregate((a, b) => a + b);
            return result;
        }

        public void Palindrom()
        {
            string enter;
            char[] a;

            do
            {
                enter = Console.ReadLine();
                a = enter.ToCharArray();
                if (String.Join("", a).Equals(String.Join("", a.Reverse()), StringComparison.OrdinalIgnoreCase))
                {
                    Console.WriteLine(true);
                }
                else
                {
                    Console.WriteLine(false);
                }
            }
            while (!enter.Equals("End", StringComparison.OrdinalIgnoreCase));


        }

        //Slow 
        public void TopNumber()
        {
            int enter = int.Parse(Console.ReadLine());
            for (int i = 0; i < enter; i++)
            {
                if (CheckTopNumber(i.ToString()))
                {
                    Console.WriteLine(i);
                }
            }
        }
        //

        private bool CheckTopNumber(string number)
        {
            int numberOdds = 0;
            int sum = 0;


            number.ToCharArray().Select(a => {
                if (int.Parse(a.ToString()) % 2 != 0) {
                    numberOdds++;
                }
                sum += int.Parse(a.ToString());
                return int.Parse(a.ToString());
            }
        );

            if (sum % 8 == 0 && numberOdds > 0)
            {
                return true;
            }

            return false;
        }

        public void ArrayManipulating()
        {
            int[] array = Console.ReadLine().Split().Select(int.Parse).ToArray();
            string enterCommand = Console.ReadLine();
            while (!enterCommand.Equals("End", StringComparison.OrdinalIgnoreCase))
            {

            }

        }

        private void ExecuteCommand(string[] command, string[] current)
        {
            int[] temp = current.Select(int.Parse).ToArray();
            switch (command[0].ToLower())
            {
                case "exchange":
                    int index = int.Parse(command[1]);
                    if (index <= 0 || index > current.Length - 1)
                    {
                        Console.WriteLine("Invalid Index");
                    }
                    else
                    {

                        index = int.Parse(Console.ReadLine());

                        string theCenter = current[index];
                        string partOne = String.Join(" ", current).Substring(0, index);
                        string partTwo = String.Join(" ", current).Substring(index + 1, current.Length);
                        string[] tempStringArray = new string[current.Length];
                        tempStringArray = (partTwo + " " + partOne).Split().ToArray();
                        tempStringArray[tempStringArray.Length - 1] = theCenter;
                        current = tempStringArray;

                    }
                    break;

                case "max":
                    int indexCurrent = 0;
                    int maxIndex = 0;
                    int currentEvenMax = 0;
                    if (command[1].Equals("even"))
                    {
                        temp.Select(e => {
                            if (e % 2 == 0)
                            {
                                if (e > currentEvenMax)
                                {
                                    currentEvenMax = e;
                                    maxIndex = indexCurrent;
                                }
                                indexCurrent++;

                            }
                            return e;
                        });
                    }
                    else
                    {

                        temp.Select(e => {
                            if (e % 2 != 0)
                            {
                                if (e > currentEvenMax)
                                {
                                    currentEvenMax = e;
                                    maxIndex = indexCurrent;
                                }


                            }
                            indexCurrent++;
                            return e;
                        });

                    }
                    Console.WriteLine(maxIndex);
                    break;

                case "min":
                    int currentIndex = 0;
                    int desiredIndex = 0;
                    int currentMinMax = 0;

                    if (command[1].Equals("even"))
                    {
                        temp.Select(e => {
                            if (e % 2 == 0)
                            {
                                if (e > currentMinMax)
                                {
                                    currentMinMax = e;
                                    desiredIndex = currentIndex;
                                }


                            }
                            currentIndex++;
                            return e;
                        });
                    }
                    else
                    {
                        if (command[1].Equals("odd"))
                        {
                            temp.Select(e => {
                                if (e % 2 != 0)
                                {
                                    if (e > currentMinMax)
                                    {
                                        currentMinMax = e;
                                        desiredIndex = currentIndex;
                                    }


                                }
                                currentIndex++;
                                return e;
                            });
                        }
                    }

                    break;

                case "first":
                    List<int> numbers = new List<int>();
                    if (int.Parse(command[1]) > temp.Length - 1)
                    {
                        Console.WriteLine("Invalid Count");
                    }
                    else
                    {


                        if (command[2].Equals("even", StringComparison.OrdinalIgnoreCase))
                        {
                            for (int i = 0; i < int.Parse(command[1]); i++)
                            {
                                if (temp[i] % 2 == 0)
                                {
                                    numbers.Add(temp[i]);
                                }
                            }
                        }
                        else
                        {
                            for (int i = 0; i < int.Parse(command[1]); i++)
                            {
                                if (temp[i] % 2 != 0)
                                {
                                    numbers.Add(temp[i]);
                                }
                            }
                        }
                    }


                    foreach (var item in numbers)
                    {
                        Console.Write(item + " ");
                    }

                    break;


            }

        }
        public void CountChars()
        {
            string[] enterText = Console.ReadLine().Split().ToArray();
            char[] letters = String.Join("", enterText).ToCharArray();

            Dictionary<char, int> currentLetterCount = new Dictionary<char, int>();

            foreach (var item in letters)
            {
                if (currentLetterCount.ContainsKey(item))
                {
                    currentLetterCount[item] += 1;
                }
                else
                {
                    currentLetterCount.Add(item, 1);
                }
            }

            foreach (KeyValuePair<char, int> items in currentLetterCount)
            {
                Console.WriteLine(items.Key + " ->" + items.Value);
            }
        }

        public void Resources()
        {
            string enter = Console.ReadLine();
            int counter = 1;
            string lastEnteredResources = "";
            Dictionary<string, int> resources = new Dictionary<string, int>();
            while (!enter.Equals("stop", StringComparison.OrdinalIgnoreCase))
            {
                if (counter % 2 != 0)
                {
                    lastEnteredResources = enter;
                    if (!resources.ContainsKey(enter))
                    {
                        resources.Add(enter, 0);
                    }

                }
                else
                {
                    resources[lastEnteredResources] += int.Parse(enter);
                }
                counter++;
                enter = Console.ReadLine();
            }

            foreach (var item in resources)
            {
                Console.WriteLine(item.Key + "->" + item.Value);
            }
        }

        public void LegendaryFarming()
        {
            string[] enterFarming = Console.ReadLine().Split().ToArray();


            string material;
            int quantity;

            Dictionary<string, int> currentLoot = new Dictionary<string, int>();
            Dictionary<string, string> items = new Dictionary<string, string>();
            List<string> obtainedLoot = new List<string>();
            items.Add("shards", "Shadowmourne");
            items.Add("fragments", "Valanyr");
            items.Add("motes", "Dragonwarth");


            for (int i = 0; i < enterFarming.Length; i += 2)
            {
                quantity = int.Parse(enterFarming[i]);
                material = enterFarming[i - 1];

                if (currentLoot.ContainsKey(material))
                {
                    currentLoot[material] += quantity;
                    if (currentLoot[material] >= 250)
                    {
                        obtainedLoot.Add(items[material]);
                        currentLoot[material] -= 250;
                    }
                }
                else
                {
                    currentLoot.Add(material, quantity);
                }
            }

            foreach (var item in obtainedLoot)
            {
                Console.WriteLine("obtained " + item);
            }

            currentLoot.OrderByDescending(e => e.Value).ThenBy(e => e.Key);
            foreach (var item in currentLoot)
            {
                Console.WriteLine(item.Key + "->" + item.Value);
            }
        }

        public void Products()
        {
            string enter = Console.ReadLine();
            string[] current;

            Dictionary<string, double> currentProducts = new Dictionary<string, double>();
            while (!enter.Equals("buy", StringComparison.OrdinalIgnoreCase))
            {
                current = enter.Split().ToArray();

                if (currentProducts.ContainsKey(current[0]))
                {
                    currentProducts[current[0]] += (double.Parse(current[1]) * int.Parse(current[2]));
                }
                else
                {
                    currentProducts.Add(current[0], (double.Parse(current[1]) * int.Parse(current[2])));
                }
                enter = Console.ReadLine();
            }

            foreach (var item in currentProducts)
            {
                Console.WriteLine(item.Key + ":" + item.Value);
            }
        }

        public void CarParking()
        {
            int numberCommands = int.Parse(Console.ReadLine());
            string enterCommand;
            Dictionary<string, string> currentRegisteredUsers = new Dictionary<string, string>();
            while (numberCommands-- > 0)
            {
                enterCommand = Console.ReadLine();
                ExecuteCommandParking(currentRegisteredUsers, enterCommand.Split().ToArray());

            }

            foreach(var item in currentRegisteredUsers)
            {
                Console.WriteLine(item.Key + "->" + item.Value);
            }
        }


        private void ExecuteCommandParking(Dictionary<string, string> currentRegisteredUsers,params string[] commands)
        {
            switch (commands[0].ToLower())
            {
                case "register":
                    if (currentRegisteredUsers.ContainsKey(commands[1]))
                    {
                        Console.WriteLine("Error User already registered");
                    }
                    else
                    {
                        currentRegisteredUsers.Add(commands[1], commands[2]);
                    }
                    break;

                case "unregister":
                    if (currentRegisteredUsers.ContainsKey(commands[1]))
                    {
                        currentRegisteredUsers.Remove(commands[1]);
                    }
                    else
                    {
                        Console.WriteLine("Error {1} not found", commands[1]);
                    }
                    break;
            }
        }

        public void CoursesNames()
        {
            string enter = Console.ReadLine();
            Dictionary<string, List<string>> currentCourses = new Dictionary<string, List<string>>();
            char currentChars = ' ';
            while (!enter.Equals("end", StringComparison.OrdinalIgnoreCase))
            {
                string[] currentData = enter.Trim(currentChars).Split().ToArray();
                if (currentCourses.ContainsKey(currentData[0]))
                {
                    currentCourses[currentData[0]].Add(currentData[1]);
                }
                else
                {
                    currentCourses.Add(currentData[0], new List<string>());
                    currentCourses[currentData[1]].Add(currentData[1]);
                }
                enter = Console.ReadLine();
            }

            foreach(var items in currentCourses)
            {
                Console.WriteLine(items.Key + " " + items.Value.Count);
                foreach(var people in items.Value)
                {
                    Console.WriteLine(people);
                }
            }
                
        }


        public void StudentGrades()
        {
            int numberPairs = int.Parse(Console.ReadLine());
            Dictionary<string, List<double>> currentStudents = new Dictionary<string,List<double>>();
            while(numberPairs-- > 0)
            {
                string enterName = Console.ReadLine();
                double grade = double.Parse(Console.ReadLine());

                if (currentStudents.ContainsKey(enterName))
                {
                    currentStudents[enterName].Add(grade);
                }
                else
                {
                    currentStudents.Add(enterName, new List<double>());
                    currentStudents[enterName].Add(grade);
                }

            }

            Dictionary<string, double> currentAverageGrades = new Dictionary<string, double>();

            currentStudents = currentStudents.Where(e => e.Value.Aggregate((a, b) => a + b) / e.Value.Count >= 4.5)
                .Select(e=>
                {
                    currentAverageGrades.Add(e.Key, e.Value.Aggregate((a, b) => a + b) / e.Value.Count);
                    return e;
                }
                )
                .ToDictionary(e=>e.Key,e=>e.Value);

           currentAverageGrades =  currentAverageGrades.OrderByDescending(e => e.Value).ToDictionary(e => e.Key, e => e.Value);
            foreach(var item in currentAverageGrades)
            {
                Console.WriteLine(item.Key + "-> " + item.Value);
            }


        }


        public void CompanyTask()
        {
            Dictionary<string, HashSet<string>> currentEmployes = new Dictionary<string, HashSet<string>>();
            string enterData;
            do
            {
                enterData = Console.ReadLine();
                AddEmployeeToBase(currentEmployes, enterData.Trim().Split("->"));

            }
            while (!enterData.Equals("End",StringComparison.OrdinalIgnoreCase));
            currentEmployes = currentEmployes.OrderBy(e => e.Key).ToDictionary(e => e.Key, e => e.Value);

            foreach(var item in currentEmployes)
            {
                Console.WriteLine(item.Key+"->");
                foreach(var empl in item.Value)
                {
                    Console.WriteLine(empl);
                }
            }
        }

        private void AddEmployeeToBase(Dictionary<string,HashSet<string>> currentData,params string[] data)
        {
            if (currentData.ContainsKey(data[0]))
            {
                currentData[data[0]].Add(data[1]);
            }
            else
            {
                currentData.Add(data[0], new HashSet<string>());
                currentData[data[0]].Add(data[1]);
            }
            
        }

        public void ForceUsers()
        {
            Dictionary<string,HashSet<string>> currentDataBase = new Dictionary<string,HashSet<string>>();
            HashSet<string> currentSides = new HashSet<string>();
            string enterData = Console.ReadLine();
            while (!enterData.Equals("Lumpawaroo", StringComparison.OrdinalIgnoreCase)) 
            {
                string[] currentEnteredDataArray = enterData.Split();
                switch (currentEnteredDataArray[1])
                {
                    case "->":
                        currentSides.Add(currentEnteredDataArray[2]);
                        break;
                    case "|":
                        currentSides.Add(currentEnteredDataArray[0]);
                        break;
                }

                AddSides(currentDataBase, currentEnteredDataArray);

                enterData = Console.ReadLine();

            }

            var displayDataBase = currentDataBase.OrderBy(e => e.Value.OrderBy(a => a)).ToDictionary(e => e.Key, e => e.Value);

            foreach(var item in displayDataBase)
            {
                Console.WriteLine(item.Key + " has " + item.Value.Count);
                foreach(var people in item.Value)
                {
                    Console.WriteLine("!" + people);
                }
            }


        }

        private void AddUserToSide(Dictionary<string, HashSet<string>> currentDataBase,HashSet<string> sides,params string[] data)
        {
            bool exists = false;
            switch (data[1])
            {
                case "->":
                    foreach (var item in sides)
                    {
                     if (!item.Equals(data[2], StringComparison.OrdinalIgnoreCase))
                    { 
                        if (currentDataBase[item].Contains(data[0]))
                        {
                                exists = true;
                                currentDataBase[item].Remove(data[0]);
                                currentDataBase[data[2]].Add(data[0]);
                        }
                    }

                    }

                    if (exists == false)
                    {
                        currentDataBase[data[2]].Add(data[0]);
                    }

                    break;
                case "|":
                    if (!currentDataBase[data[0]].Contains(data[2]))
                    {
                        currentDataBase[data[0]].Add(data[2]);
                    }
                   

                    
                    break;
                deafault:
                    break;
            }
        }

        private void AddSides(Dictionary<string,HashSet<string>> currentSides,string[] currentData)
        {
            switch (currentData[1])
            {
                case "->":
                    if (currentSides.ContainsKey(currentData[2]))
                    {
                        AddUserToSide(currentSides, currentSides[currentData[2]], currentData);
                    }
                    else
                    {
                        currentSides.Add(currentData[2], new HashSet<string>());
                        AddUserToSide(currentSides, currentSides[currentData[2]], currentData);
                    }
                    break;
                case "|":
                    if (currentSides.ContainsKey(currentData[0]))
                    {
                        AddUserToSide(currentSides, currentSides[currentData[0]], currentData);

                    }
                    else
                    {
                        currentSides.Add(currentData[0], new HashSet<string>());
                        AddUserToSide(currentSides, currentSides[currentData[0]], currentData);
                    }
                    break;
            }
        }
        
        public void JudgeSubmisions()
        {
            Dictionary<string, int> currentPoints = new Dictionary<string, int>();
            Dictionary<string, int> currentLanguages = new Dictionary<string, int>();

            string enterData = Console.ReadLine();
            while (!enterData.Equals("exam finsihed", StringComparison.OrdinalIgnoreCase))
            {
                string[] enteredDataArray = enterData.Split("->");
                if (!currentPoints.ContainsKey(enteredDataArray[0]))
                {
                    currentPoints.Add(enteredDataArray[0], 0);
                }
                if (enteredDataArray.Length==3) 
                { 
                if (!currentLanguages.ContainsKey(enteredDataArray[1]))
                {
                    currentLanguages.Add(enteredDataArray[1], 1);
                }
                else
                {
                    currentLanguages[enteredDataArray[1]]++;
                }
            }
                ExecuteJudgeCommand(currentPoints, enteredDataArray);
                enterData = Console.ReadLine();
            }
            var currentOrderedPoints = currentPoints.OrderByDescending(e => e.Value).ThenBy(e => e.Key)
                .ToDictionary(e => e.Key, e => e.Value);

            var currentOrderedLanguages = currentLanguages.OrderByDescending(e => e.Value).ThenBy(e => e.Key)
                .ToDictionary(e => e.Key, e => e.Value);


            Console.Clear();
            Console.WriteLine("Results:");
            foreach(var item in currentOrderedPoints)
            {
                Console.WriteLine(item.Key + ":" + item.Value);
            }

            Console.WriteLine("Submisions:");
            foreach(var item in currentOrderedLanguages)
            {
                Console.WriteLine(item.Key + " -> " + item.Value);
            }
        }

        private void ExecuteJudgeCommand(Dictionary<string,int> currentParticipants,params string[] currentData)
        {
            switch (currentData.Length)
            {
                case 2:
                    currentParticipants.Remove(currentData[0]);
                    break;
                case 3:
                    currentParticipants[currentData[0]] += int.Parse(currentData[2]);

                    break;
            }

        }

        public void RankingInterns()
        {
            Dictionary<string, string> currentContests = new Dictionary<string, string>();
            Dictionary<string, Dictionary<string, int>> currentParticipants = new Dictionary<string, Dictionary<string, int>>();
            Console.WriteLine("Enter Contests & Passwords!");

            string enterPasswords = Console.ReadLine();
            while (!enterPasswords.Equals("end of contests", StringComparison.OrdinalIgnoreCase))
            {
                string[] dataContestsPasswords = enterPasswords.Split(':');
                if (!currentContests.ContainsKey(dataContestsPasswords[0]))
                {
                    currentContests.Add(dataContestsPasswords[0], dataContestsPasswords[1]);
                }
                Console.Clear();
                Console.WriteLine("Enter Contests & Passwords!");
                enterPasswords = Console.ReadLine();
            }
            Console.Clear();
            Console.WriteLine("Enter Contest-Password-Participant-Points!");
            string enterParticipants = Console.ReadLine();
            string[] currentEnteredDataParticipants;
            while(!enterParticipants.Equals("end of submisions", StringComparison.OrdinalIgnoreCase))
            {
                currentEnteredDataParticipants = enterParticipants.Split("=>");
                if (currentContests.ContainsKey(currentEnteredDataParticipants[0])&& currentEnteredDataParticipants[1].Equals(currentContests[currentEnteredDataParticipants[0]]))
                {
                    if (currentParticipants.ContainsKey(currentEnteredDataParticipants[0]))
                    {
                        int currentScore = currentParticipants[currentEnteredDataParticipants[0]][currentEnteredDataParticipants[2]];
                        int scoreAddedOnInput = int.Parse(currentEnteredDataParticipants[3]);
                        if (currentScore < scoreAddedOnInput)
                        {
                            currentParticipants[currentEnteredDataParticipants[0]][currentEnteredDataParticipants[2]] = scoreAddedOnInput;
                        }
                        else
                        {

                        }

                    }
                    else
                    {
                        currentParticipants.Add(currentEnteredDataParticipants[0], new Dictionary<string, int>());
                        currentParticipants[currentEnteredDataParticipants[0]][currentEnteredDataParticipants[2]]=int.Parse(currentEnteredDataParticipants[3]);

                    }
                }
                Console.Clear();
                Console.WriteLine("Enter Contest-Passwor-Participant-points!");
                enterParticipants = Console.ReadLine();

            }
            foreach(var item in currentParticipants)
            {
                Console.WriteLine("#"+item.Key);
                foreach(var currentPart in item.Value)
                {
                    Console.WriteLine(currentPart.Key + " : " + currentPart.Value);
                }
            }
        }

        public void JudgeSyste()
        {
            Dictionary<string, Dictionary<string, int>> currentCourses = new Dictionary<string, Dictionary<string, int>>();
            Dictionary<string, HashSet<string>> currentNumberParticipants = new Dictionary<string, HashSet<string>>();

            

            string enterData = Console.ReadLine();
            string[] data;
            while(enterData.Equals("no more time", StringComparison.OrdinalIgnoreCase))
            {
                data = enterData.Trim().Split("->");
                if (currentCourses.ContainsKey(data[1]))
                {
                    if (currentCourses[data[1]].ContainsKey(data[0]))
                    {
                        int currentGivenScore = int.Parse(data[2]);
                        int currentScore = currentCourses[data[1]][data[0]];
                        if (currentGivenScore > currentScore)
                        {
                            currentCourses[data[1]][data[0]] = currentGivenScore;
                        }
                    }
                    else
                    {
                        currentNumberParticipants[data[1]].Add(data[0]);
                        currentCourses[data[1]].Add(data[0], int.Parse(data[2]));
                    }
                }
                else
                {
                    currentCourses.Add(data[1], new Dictionary<string, int>());
                    currentCourses[data[1]].Add(data[0], int.Parse(data[2]));
                    currentNumberParticipants.Add(data[1], new HashSet<string>());
                    currentNumberParticipants[data[1]].Add(data[0]);

                }
                enterData = Console.ReadLine();
            }

            foreach(var item in currentCourses)
            {
                Console.WriteLine(item.Key+": "+currentNumberParticipants[item.Key].Count);
                foreach(var participant in item.Value)
                {
                    Console.WriteLine(participant.Key + "<::>" + participant.Value);
                }
            }

        }

        public void MobaPlayers()
        {
            Dictionary<string, Dictionary<string, int>> currentPlayers = new Dictionary<string, Dictionary<string, int>>();
            HashSet<string> currentPositions = new HashSet<string>();
            
            string enterData = Console.ReadLine();
            string[] currentData;
            while(enterData.Equals("season is over", StringComparison.OrdinalIgnoreCase))
            {
                if (!enterData.Contains("vs"))
                {
                    currentData = enterData.Trim().Split("->");
                    currentPositions.Add(currentData[1]);
                    if (currentPlayers.ContainsKey(currentData[0]))
                    {
                        if (currentPlayers[currentData[0]].ContainsKey(currentData[1]))
                        {
                            int currentScoreGiven = int.Parse(currentData[2]);
                            int currentScoreHas = currentPlayers[currentData[0]][currentData[1]];
                            if (currentScoreGiven > currentScoreHas)
                            {
                                currentPlayers[currentData[0]][currentData[1]] = currentScoreGiven;
                            }
                        }
                        else
                        {
                            currentPlayers[currentData[0]].Add(currentData[1], int.Parse(currentData[2]));
                            
                        }
                    }
                    else
                    {
                        currentPlayers.Add(currentData[0], new Dictionary<string, int>());
                        currentPlayers[currentData[0]].Add(currentData[1], int.Parse(currentData[2]));

                    }
                }
                else
                {
                    currentData = enterData.Split(" vs ");
                    string removePlayer = RemovePlayerLostDuel(currentPlayers, currentPositions, currentData[0], currentData[1]);
                    if (removePlayer!=null)
                    {
                        currentPlayers.Remove(removePlayer);
                    }
                   

                }
                enterData = Console.ReadLine();
               
            }
            foreach(var item in currentPlayers)
            {
                Console.WriteLine(item.Key);
            }
        }

        private string RemovePlayerLostDuel(Dictionary<string,Dictionary<string,int>> currentPlayers,HashSet<string>positions,params string[] players)
        {
            int rightPlayerTotal=0;
            int leftPlayerTotal=0;
            foreach(var item in positions)
            {
                if(currentPlayers[players[0]].ContainsKey(item) && currentPlayers[players[1]].ContainsKey(item))
                {
                    rightPlayerTotal += currentPlayers[players[1]][item];
                    leftPlayerTotal += currentPlayers[players[0]][item];
                }
            }

            if (rightPlayerTotal == leftPlayerTotal)
            {
                return null;
            }
            else if (rightPlayerTotal > leftPlayerTotal)
            {
                return players[0];
            }
            else
            {
                return players[1];
            }
        }

        public void SnowWhite()
        {
            Dictionary<string, Dictionary<string, int>> dwarfs = new Dictionary<string, Dictionary<string, int>>();

            string enterDwarf = Console.ReadLine();
            while (!enterDwarf.Equals("once upona  time", StringComparison.OrdinalIgnoreCase))
            {
                string[] currentData = enterDwarf.Split(" <::> ");
                if (dwarfs.ContainsKey(currentData[1]))
                {
                    if (dwarfs[currentData[1]].ContainsKey(currentData[0]))
                    {
                        int givenPhysic = int.Parse(currentData[2]);
                        int dwarfPhysiscs = dwarfs[currentData[1]][currentData[0]];
                        if (givenPhysic > dwarfPhysiscs)
                        {
                            dwarfs[currentData[1]][currentData[0]] = givenPhysic;
                        }
                    }
                }
                else
                {
                    dwarfs.Add(currentData[1], new Dictionary<string, int>());
                    dwarfs[currentData[1]].Add(currentData[0], int.Parse(currentData[2]));

                }
                enterDwarf = Console.ReadLine();

            }

            
            foreach(var item in dwarfs)
            {
                Console.WriteLine(item.Key);
                foreach(var itemNested in item.Value)
                {
                    Console.WriteLine(itemNested.Key+" with "+itemNested.Value+" physics");
                }
            }
        }

        public void DragonArmyHeroesIIIFundamentals()
        {
            Dictionary<string, Dictionary<string,Dragon>> currentDragons = new Dictionary<string, Dictionary<string,Dragon>>();
            Dictionary<string, int[]> currentDragonTypeStats = new Dictionary<string, int[]>();
            Dictionary<string, HashSet<string>> currentDragonNames = new Dictionary<string, HashSet<string>>();
            
            int numberDragons = int.Parse(Console.ReadLine());
            string enterDragon;
            string[] dragonData;
            Dragon currentDragonEntered;
            for (int i = 0; i < numberDragons; i++)
            {
                enterDragon = Console.ReadLine();
                dragonData = enterDragon.Split();
                currentDragonEntered = new Dragon(dragonData[1], TransformStatsDragon(dragonData[2], dragonData[3], dragonData[4]));

                if (currentDragons.ContainsKey(dragonData[0]))
                {
                    if (currentDragonNames[dragonData[0]].Contains(dragonData[1]))
                    {
                        currentDragons[dragonData[0]][dragonData[1]].UpdateStats(TransformStatsDragon(dragonData[2], dragonData[3], dragonData[4]));


                    }
                    else
                    {
                        currentDragons[dragonData[0]].Add(dragonData[1], currentDragonEntered);
                        currentDragonNames[dragonData[0]].Add(dragonData[1]);
                    }
                }
                else
                {
                    currentDragons.Add(dragonData[0], new Dictionary<string, Dragon>());
                    currentDragons[dragonData[0]].Add(dragonData[1],currentDragonEntered);
                    currentDragonNames.Add(dragonData[0], new HashSet<string>());
                    currentDragonNames[dragonData[0]].Add(dragonData[1]);
                    
                }
                

            }

            foreach(var item in currentDragons)
            {
                currentDragonTypeStats.Add(item.Key, new int[3]);
                foreach(var name in item.Value)
                {
                    AddSumStats(currentDragonTypeStats, name.Key, name.Value.Stats);
                }
                Console.WriteLine(item.Key + ": " + ShowStats(currentDragonTypeStats[item.Key]));
                foreach(var currentName in item.Value)
                {
                    Console.WriteLine(currentName.Key+":"+ currentDragons[item.Key][currentName.Key].ShowStats());
                }
                
            }

            
        }
        private void AddSumStats(Dictionary<string,int[]> current,string type,params int[] stats)
        {
            current[type][0] += stats[0];
            current[type][1] += stats[1];
            current[type][2] += stats[2];
        }

        private int[] TransformStatsDragon(params string[] stats)
        {
            int[] statsInArray = new int[3];
            for(int i = 1; i <= stats.Length; i++)
            {
                if (stats[i - 1].Equals("null"))
                {
                    switch (i)
                    {
                        case 1:
                            statsInArray[i - 1] = 250;
                            break;
                        case 2:
                            statsInArray[i - 1] = 45;
                            break;
                        case 3:
                            statsInArray[i - 1] = 10;
                            break;
                    }
                }
                else
                {
                    statsInArray[i - 1] = int.Parse(stats[i - 1]);
                }
            }

            return statsInArray;
        }
        private string ShowStats(int[] Stats)
        {
            StringBuilder sb = new StringBuilder();
            sb.Append(Stats[0]).Append("/" + Stats[1]).Append("/" + Stats[2]);
            return sb.ToString();
        }

        private struct Dragon
        {
            

            public Dragon(string name,params int[] currentDataEntered)
            {
                this.Health = currentDataEntered[0];
                this.Damage = currentDataEntered[1];
                this.Armour = currentDataEntered[2];
                Name = name;
                Stats = currentDataEntered;
                

            }

            public int Health { get; set; }
            public int Damage { get; set; }
            public int Armour { get; set; }
            public string Name { get; set; }

            public int[] Stats { get; private set; }

            public void UpdateStats(params int[] currentNewStats)
            {
                this.Health = currentNewStats[0];
                this.Damage = currentNewStats[1];
                this.Armour = currentNewStats[2];
                Stats = currentNewStats;
            }

            public string ShowStats()
            {
                StringBuilder sb = new StringBuilder();
                sb.Append(this.Stats[0]).Append("/" + this.Stats[1]).Append("/" + this.Stats[2]);
                return sb.ToString();
            }

            public override string ToString()
            {
                return $"{this.Name}:{this.Health}-{this.Damage}-{this.Armour}";
                
            }
        }

       
        public void SecretChat()
        {
            StringBuilder sb = new StringBuilder();
            string enterString = Console.ReadLine();
            sb.Append(enterString);
            Console.Clear();
            string enterCommand = Console.ReadLine();
            while (!enterCommand.Equals("Reveal", StringComparison.OrdinalIgnoreCase))
            {

                ExecuteSecretChatCommands(sb, enterCommand.Split(":|:"));
                Console.WriteLine(sb.ToString());
                enterCommand = Console.ReadLine();
                Console.Clear();
                
            }
        }
        private void ExecuteSecretChatCommands(StringBuilder sb,params string[] commands)
        {
            switch (commands[0].ToLower())
            {
                case "changeall":
                    sb.Replace(commands[2], commands[1]);
                    break;
                case "reverse":
                    string currentString = sb.ToString();
                    if (currentString.Contains(commands[1]))
                    {
                        int start = currentString.IndexOf(commands[1]);
                        int length = commands[1].Length - 1;
                        sb.Remove(start, length);
                        sb.Append(commands[1].ToCharArray().Reverse().ToString());
                    }
                    else
                    {
                        Console.WriteLine("Error");
                    }
                    break;
                case "insertspace":
                    sb.Insert(int.Parse(commands[1]), " ");
                    break;
            }
        }

        public void SpellingBee()
        {
            Dictionary<string,List<int>> pairs = new Dictionary<string, List<int>>();
            Regex currentRegex = new Regex("([@|#])\\w+\\1");
            string enterText = Console.ReadLine();
            MatchCollection currentMatches = Regex.Matches(enterText, currentRegex.ToString());
            
            List<Match> currentList = currentMatches.ToList();
            currentList.Sort();

            pairs = GetAllPairs(currentList, pairs);

            foreach(var item in pairs)
            {
                Console.WriteLine(item.Key + " is pair with items at index" + String.Join(",", item.Value));

            }
            

        }

        private Dictionary<string,List<int>> GetAllPairs(List<Match> found,Dictionary<string,List<int>> currentPairsStructure)
        {
            string wordInTheIndex;
            string wordInIndexReversed;
            
            for(int i = 0; i < found.Count-1; i++)
            {
                

                wordInTheIndex = found[i].Value;
                wordInIndexReversed = String.Join("", wordInTheIndex.ToCharArray().Reverse());

                if (!currentPairsStructure.ContainsKey(wordInTheIndex))
                {
                    currentPairsStructure.Add(wordInTheIndex, new List<int>());
                    if (!currentPairsStructure.ContainsKey(wordInIndexReversed))
                    {
                        currentPairsStructure.Add(wordInIndexReversed,new List<int>());

                    }
                }

                for (int j = i + 1; j < found.Count; j++)
                {
                    if(String.Join("", found[j].Value.ToCharArray().Reverse()).Equals(wordInTheIndex))
                    {
                        if (!currentPairsStructure[wordInIndexReversed].Contains(i))
                        {
                            currentPairsStructure[wordInIndexReversed].Add(i);
                        }
                        currentPairsStructure[wordInTheIndex].Add(j);
                    }
                }
            }

            return currentPairsStructure;


        }

        public void NeefForSpeedExamTask()
        {
            int numberCars = int.Parse(Console.ReadLine());
            string enterCarData;
            Dictionary<string, int[]> currentCars = new Dictionary<string, int[]>();
            string[] dataCollectedInput;
            for(int i = 0; i < numberCars; i++)
            {
                enterCarData = Console.ReadLine();
                dataCollectedInput = enterCarData.Split("|");


                if (!currentCars.ContainsKey(dataCollectedInput[0]))
                {
                    currentCars.Add(dataCollectedInput[0], new int[2]);
                    currentCars[dataCollectedInput[0]][0] = int.Parse(dataCollectedInput[1]);
                    currentCars[dataCollectedInput[0]][1] = int.Parse(dataCollectedInput[2]);
                }
            }

            string[] commandsCollected;
            string enterCommands = Console.ReadLine();
            while (!enterCommands.Equals("stop"))
            {
                commandsCollected = enterCommands.Split(":");
                ExecuteCommandsNeedForSpeed(currentCars,commandsCollected);
                enterCommands = Console.ReadLine();
            }

            currentCars = currentCars.OrderByDescending(e => e.Value[0]).ThenBy(e=>e.Key)
                .ToDictionary(e => e.Key, e => e.Value);
            foreach(var item in currentCars)
            {
                Console.WriteLine($"{item.Key} -> Mileage: {item.Value[0]} kms, Fuel in the tank: {item.Value[1]} lt.");

            }
        }


        private void ExecuteCommandsNeedForSpeed(Dictionary<string, int[]> currentCars, string[] commands)
        {
           
            switch (commands[0].ToLower())
            {
                case "drive":
                    int fuel = int.Parse(commands[2]);
                    int distance = int.Parse(commands[1]);
                    if (fuel>currentCars[commands[0]][1])
                    {
                        Console.WriteLine("Not enough fuel to make that ride");

                    }
                    else if(fuel <= currentCars[commands[0]][1])
                    {
                        if (currentCars[commands[0]][0] + distance >= 100000)
                        {
                            Console.WriteLine("Time to sell {0}",commands[0]);
                            currentCars.Remove(commands[0]);
                            return;
                        }

                        currentCars[commands[0]][0] += distance;
                        currentCars[commands[0]][1] -= fuel;
                        Console.WriteLine($"{commands[0]} driven for {commands[1]} kilometers. {commands[2]} liters of fuel consumed.");
                    }
                    break;


                case "refil":
                    int fuelToRefil = int.Parse(commands[1]);
                    if (currentCars[commands[0]][1] + fuelToRefil > 75)
                    {
                        int neededFule = 75 - currentCars[commands[0]][1];
                        fuelToRefil -= neededFule;
                        currentCars[commands[0]][1] += neededFule;
                        Console.WriteLine($"{commands[0]} refueled with {neededFule} liters");
                    }
                    else if(currentCars[commands[0]][1] + fuelToRefil <= 75)
                    {
                        currentCars[commands[0]][1] += fuelToRefil;
                        Console.WriteLine($"{commands[0]} refueled with {fuelToRefil} liters");
                    }
                    

                    break;

                case "revert":
                    int revertWith = int.Parse(commands[1]);
                    if(currentCars[commands[0]][0]-revertWith<=10000)
                    {
                        currentCars[commands[0]][0] = 10000;
                    }
                    else
                    {
                        currentCars[commands[0]][0] -= revertWith;
                        Console.WriteLine($"{commands[0]} mileage decreased by {revertWith} kilometers");
                    }
                    break;
            }
        }

        public void ShopingListTask()
        {
            LinkedList<string> currentList = new LinkedList<string>(Console.ReadLine().Split("!"));
            HashSet<string> itemsInListPresent = new HashSet<string>();
            foreach (var item in currentList)
            {
                itemsInListPresent.Add(item);
            }

            string enterCommand = Console.ReadLine();
            string[] commands;
            while(!enterCommand.Equals("Go Shopping!"))
            {
                commands = enterCommand.Split();
                ExecuteCommandListShop(commands, currentList, itemsInListPresent);
                enterCommand = Console.ReadLine();

            }

            string itemsInTheListPrint = String.Join(",", currentList);
            Console.WriteLine(itemsInTheListPrint);

          
           
        }

        private void ExecuteCommandListShop(string[] commands,LinkedList<string> currentList,HashSet<string> currentPresentItems)
        {
            switch (commands[0].ToLower())
            {
                case "urgent":

                    if (!currentPresentItems.Contains(commands[1]))
                    {
                        currentList.AddFirst(commands[1]);

                    }
                    break;


                case "unnecessary":
                    LinkedListNode<string> toRemove = currentList.Find(commands[1]);
                    currentList.Remove(toRemove);
                    currentPresentItems.Remove(commands[1]);
                    break;


                case "correct":
                    currentList.Find(commands[1]).Value = commands[2];
                    break;

                case "rearange":
                    LinkedListNode<string> currentNode = null;
                    currentNode = currentList.Find(commands[1]);

                    if (currentNode != null)
                    {
                        currentList.Remove(currentNode);
                        currentList.AddLast(commands[1]);
                    }
                    break;
                    
            }
        }

        public void NationalCourt()
        {
            int[] numberPeoplePerHour = new int[3];
            for(int i = 0; i < 3; i++)
            {
                numberPeoplePerHour[i] = int.Parse(Console.ReadLine());
            }

            int numberOfPeople = int.Parse(Console.ReadLine());
            int counter = 1;
            while (numberOfPeople>0)
            {
                if (counter % 4 == 0)
                {
                    counter++;
                }
                else 
                {
                    if (numberPeoplePerHour.Sum() >= numberOfPeople)
                    {
                        Console.WriteLine($"Time needed {counter}h");
                    }
                    else if (numberPeoplePerHour.Sum() < numberOfPeople)
                    {
                        numberOfPeople -= numberPeoplePerHour.Sum();
                        counter++;
                    }

                }
                

            }
        }

        public void HearthDelviery()
        {
            int[] houses = Console.ReadLine().Split("@").Select(e => int.Parse(e)).ToArray();
            string enterCommand = Console.ReadLine();
            int cupidPosition = 0;
            int lengthJump = 0;
            while (!enterCommand.Equals("Love!"))
            {
                lengthJump = int.Parse(enterCommand.Split()[1]);
                if (cupidPosition + lengthJump > houses.Length)
                {
                    if (houses[0] == 0)
                    {
                        Console.WriteLine($"Place {0} already had Valentine's day.");
                    }
                    else
                    {
                        houses[0] -= 2;
                        Console.WriteLine($"Place {cupidPosition + lengthJump} has Valentine's day.");
                        if (houses[0] < 0)
                        {
                            houses[0] = 0;
                        }
                    }
                }
                else
                {
                    if(houses[cupidPosition + lengthJump] == 0)
                    {
                        Console.WriteLine($"Place {0} already had Valentine's day.");
                    }
                    else
                    {
                        houses[cupidPosition + lengthJump] -= 2;
                        Console.WriteLine($"Place {cupidPosition + lengthJump} has Valentine's day.");
                        if(houses[cupidPosition + lengthJump] < 0)
                        {
                            houses[cupidPosition + lengthJump] = 0;
                        }
                    }
                }
                enterCommand = Console.ReadLine();
            }
        }


}


}
   

