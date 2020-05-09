using SoftuniFundamentals.TelerikGSMTask;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

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
            // currentTasks.SongTask();
            //currentTasks.SecretMessage();
            //currentTasks.MixingRules();
            //currentTasks.DrumSet();
            // currentTasks.WordSynonims();
            // currentTasks.TopThree();
            //currentTasks.DataTypes();
            //currentTasks.CenterPoint();
            //currentTasks.Tribonachi();
            //currentTasks.AddAndSubstract();
            //currentTasks.CharactesInRange('a','z');
            //currentTasks.SmallestOfThree(Console.ReadLine().Split().Select(int.Parse).ToArray());
            //currentTasks.NxN(int.Parse(Console.ReadLine()));
            //currentTasks.Palindrom();
            //currentTasks.TopNumber();
            // currentTasks.AddAndSubstract();
            // currentTasks.ArrayManipulating();
            //currentTasks.Resources();
            //currentTasks.LegendaryFarming();
            //currentTasks.Products();
            //currentTasks.CarParking();
            //currentTasks.CoursesNames();
            //currentTasks.StudentGrades();
            

        }

        private static void TelericGSMTask()
        {
            Dictionary<string,GSM> currentGSM = new Dictionary<string,GSM>();
           

        }

        private void GSM_Creation(Dictionary<string,GSM> currentPhones)
        {
            Console.Clear();
            bool exit = false;
            GSM currentSelected = null;
            while (exit == false)
            {
                Console.Clear();
                Console.WriteLine("1|Add GSM");
                Console.WriteLine("2|Remove GSM");
                Console.WriteLine("3|Exit");
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
                        exit = true;
                        break;

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
                Console.WriteLine(counter + " ->");
                Console.WriteLine(item);
                currentPhonesOrdered.Add(counter, item.Key);
               
                counter++;
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
                currentPhone.Model = manufacturer;
            }
            catch (ArgumentException argument)
            {
                ReEnter(argument.Message, currentPhone);
            }



            try
            {
                Console.Write("Name: ");
                name = Console.ReadLine();
                currentPhone.Model = name;
            }
            catch (ArgumentException argument)
            {
                ReEnter(argument.Message, currentPhone);
            }




            try
            {
                Console.Write("Number :");
                number = Console.ReadLine();
                currentPhone.Model = number;
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


            

        }

        private void ReEnter(string warningMessage,GSM currentPhone)
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
    }
}
