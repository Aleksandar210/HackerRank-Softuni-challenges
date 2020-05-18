using SoftuniFundamentals.TelerikDefClassesPartTwo;
using SoftuniFundamentals.TelerikGSMTask;
using System;
using System.Collections.Generic;
using System.Diagnostics;
using System.Linq;
using System.Text;
using System.Text.RegularExpressions;
using System.Transactions;

namespace SoftuniFundamentals
{
    class Program
    {
        static void Main(string[] args)
        {
             ArraysMethodsLists currentTasks = new ArraysMethodsLists();
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
}
