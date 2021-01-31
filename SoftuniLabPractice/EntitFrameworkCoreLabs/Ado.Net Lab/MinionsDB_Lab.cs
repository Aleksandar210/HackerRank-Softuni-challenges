using Microsoft.Data.SqlClient;
using System;
using System.Collections.Generic;
using System.Text;
using System.Text.RegularExpressions;

namespace EntitFrameworkCoreLabs.Ado.Net_Lab
{
    public class MinionsDB_Lab
    {

        public MinionsDB_Lab()
        {

        }

        public void Start()
        {
            //connecting to the database with a string
            using (SqlConnection dbConnection = new SqlConnection("Server=.\\SQLEXPRESS; Database=MinionsDB; Integrated Security = true") )
            {
                dbConnection.Open();
                string commandToShowCountMinions = "SELECT COUNT(*) FROM [Minions]";
                SqlCommand minionsCountCommand = new SqlCommand(commandToShowCountMinions, dbConnection);
                int minionsCount = (int)minionsCountCommand.ExecuteScalar();
                Console.WriteLine(minionsCount);
            }
        }

        public void VillainsWithMoreThan3Minions()
        {
            int minionsCount = 0;
            using (SqlConnection dbConnection = new SqlConnection("Server=.\\SQLEXPRESS; Database=MinionsDB; Integrated Security = true"))
            {
                dbConnection.Open();
                string commandToShowCountMinions = "SELECT [Name],dbo.CountMinionsOfVilainByID(Id) AS minionsCount FROM Villains";
                SqlCommand minionsCountCommand = new SqlCommand(commandToShowCountMinions, dbConnection);
                using (SqlDataReader readVillains = minionsCountCommand.ExecuteReader())
                {
                    while(readVillains.Read())
                    {
                        minionsCount = (int)readVillains["minionsCount"];
                        if (minionsCount>=3)
                        {
                            Console.WriteLine(readVillains["Name"] + " - " + minionsCount);
                        }
                    }
                }
                
            }
        }

        public void MinionsByVillainID()
        {
            int villainID;
            do
            {
                Console.Write("Enter Villain ID: ");
                villainID = int.Parse(Console.ReadLine());
            }
            while (villainID < 1);

            using (SqlConnection minionsDBconnection = new SqlConnection("Server=.\\SQLEXPRESS; Database=MinionsDB; Integrated Security = true"))
            {
                minionsDBconnection.Open();

                string villainNameCommand = "SELECT [Name] FROM Villains WHERE Id = @VillainID";
                SqlCommand currentVillainFindByIDCommand = new SqlCommand(villainNameCommand, minionsDBconnection);
                currentVillainFindByIDCommand.Parameters.AddWithValue("@VillainID", villainID);

                string villainName = null;
                using (SqlDataReader currentVillainsReader = currentVillainFindByIDCommand.ExecuteReader())
                {
                    currentVillainsReader.Read();
                    try
                    {
                         villainName = (string)currentVillainsReader["Name"];
                       
                    }
                    catch(InvalidOperationException exc)
                    {
                        Console.WriteLine("There is no villain with such ID");
                    }
                    
                }

                if(villainName!=null)
                {
                    Console.WriteLine("Villain: "+villainName);
                    foreach(var item in this.currentMinionsNamesOfVillain(villainID, minionsDBconnection))
                    {
                        Console.WriteLine(item);
                    }
                }
               
                  
            }

        }

        private List<string> currentMinionsNamesOfVillain(int villainID,SqlConnection currentConnection)
        {
            List<string> listWithMinionNames = new List<string>();
            SqlCommand currentCommandToGetMinionNames = new SqlCommand("SELECT Minions.[Name] FROM MinionsVillains JOIN Minions ON Minions.Id = MinionsVillains.MinionID WHERE VillainID = @VillainID",currentConnection);
            currentCommandToGetMinionNames.Parameters.AddWithValue("VillainID", villainID);

            using (SqlDataReader currentReader  = currentCommandToGetMinionNames.ExecuteReader())
            {
                while(currentReader.Read())
                {
                    listWithMinionNames.Add((string)currentReader["Name"]);
                }
            }
            return listWithMinionNames;
        }

        public void AddVillainAndMinionToDB()
        {
            using (SqlConnection minionsDBConnection = new SqlConnection("Server=.\\SQLEXPRESS; Database =MinionsDB; Integrated Security = true;"))
            {
                minionsDBConnection.Open();

                string[] currentMinionDataEntered = InsertMinionData();

                if(!this.CheckTownNameDB(currentMinionDataEntered[2],minionsDBConnection))
                {
                    SqlCommand insertTownName = new SqlCommand("INSERT INTO Towns(TownName,CountryCode) VALUES(@TownNameEntered,dbo.GenerateRandomNumberBetween1and50(1,50))");
                    insertTownName.Parameters.AddWithValue("@TownNameEntered", currentMinionDataEntered[2]);
                    insertTownName.ExecuteNonQuery();
                }
                else
                {
                    SqlCommand InsertMinion = new SqlCommand("INSERT INTO Minions([Name],Age,TownId ) VALUES ('@MinionName',@Age,@Town)");
                    InsertMinion.Parameters.AddWithValue("@MinionName", currentMinionDataEntered[0]);
                    InsertMinion.Parameters.AddWithValue("@Age", int.Parse(currentMinionDataEntered[1]));

                    //Finding town id by name of town
                    SqlCommand currentCommandToFindIDOfCity = new SqlCommand("SELECT Id FROM Towns WHERE TownName LIKE('@TownNameFind')");
                    currentCommandToFindIDOfCity.Parameters.AddWithValue("@TownNameFind", currentMinionDataEntered[2]);
                    int townID;
                    using (SqlDataReader townIDReader = currentCommandToFindIDOfCity.ExecuteReader())
                    {
                        townIDReader.Read();
                        townID = (int)townIDReader["Id"];
                    }

                        InsertMinion.Parameters.AddWithValue("@Town",townID);

                    InsertMinion.ExecuteNonQuery();
                }

                SqlCommand checkVillainNameDB = new SqlCommand("SELECT COUNT(*) FROM Villains WHERE [Name] LIKE '@[VillainName]'", minionsDBConnection);
                if((int)checkVillainNameDB.ExecuteScalar()==0)
                {
                    //inserting VillainName
                    SqlCommand insertVillain = new SqlCommand("INSERT INTO Villains([Name],EvilnessFactor) VALUES(@VillainName,'evil')");
                    insertVillain.Parameters.AddWithValue("@VillainName", currentMinionDataEntered[3]);
                    insertVillain.ExecuteNonQuery();
                }
                else
                {
                    int villainID;

                    SqlCommand currentReadVillainiDcommand = new SqlCommand("SELECT Id FROM Villains WHERE [Name] LIEK('@VillainNmae')");
                    currentReadVillainiDcommand.Parameters.AddWithValue("@VillainNmae", currentMinionDataEntered[3]);
                    using (SqlDataReader villainIDReader = currentReadVillainiDcommand.ExecuteReader())
                    {
                        villainIDReader.Read();
                        villainID = (int)
                    }
                }

            }
        }

        private string[] InsertMinionData()
        {
            string[] minionData = Console.ReadLine().Split(" ",StringSplitOptions.RemoveEmptyEntries);
            
            if (!this.VerifyMinionNmae(minionData[1]))
            {
                InsertMinionData();
            }
            else if(int.Parse(minionData[2]) <= 5)
            {
                InsertMinionData();
            }

            string villainName = Console.ReadLine().Split(" ",StringSplitOptions.RemoveEmptyEntries)[1];
         
            return new string[] { minionData[1], minionData[2], minionData[3], villainName };
           
        }

        private bool VerifyMinionNmae(string minionName)
        {
            string correctMinionNameRegex = @"(([A-Z][a-z]+) ([A-z][a-z]+))|([A-z]+)";
            Regex regex = new Regex(correctMinionNameRegex);

            if(regex.IsMatch(minionName))
            {
                return true;
            }
            else
            {
                return false;
            }
        }

        private bool CheckTownNameDB(string townName,SqlConnection connectionDB)
        {
            SqlCommand currentCountOfTownsByThisName = new SqlCommand("SELECT COUNT(*) FROM Towns WHERE TownName LIKE('@TownName')", connectionDB);
            currentCountOfTownsByThisName.Parameters.AddWithValue("@TownNmae", townName);

            int numberOfTownsWithThatName = (int)currentCountOfTownsByThisName.ExecuteScalar();

            if(numberOfTownsWithThatName>=1)
            {
                return true;
            }

            return false;
        }
    }
}
