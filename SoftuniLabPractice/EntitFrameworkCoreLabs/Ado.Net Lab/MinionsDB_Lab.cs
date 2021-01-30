using Microsoft.Data.SqlClient;
using System;
using System.Collections.Generic;
using System.Text;

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

            }
        }
    }
}
