using System;
using System.Collections.Generic;
using System.Text;

namespace SoftuniFundamentals.Csharp_Advanced_Classes
{
    class Department
    {
        private const int DefaultRooms = 20;

        private string name;
        private Queue<string> patientsRegistered;
        private List<string[]> currentRooms;
        private int availableRooms;

        public Department(string name)
        {
            this.Name = name;
            this.patientsRegistered = new Queue<string>(DefaultRooms);
            this.currentRooms = new List<string[]>(DefaultRooms);
            this.availableRooms = DefaultRooms;
        }

        public string Name
        {
            private set
            {
                if(value.Length<1 || value.Length>100)
                {
                    throw new ArgumentException("Invalid Department-name length must be 1-100.");
                }
                else
                {
                    this.name = value;
                }
            }

            get { return this.name; }
        }


        public void AddPatient(string name)
        {
            //check if current free room has been created and if its full if created
            if(this.currentRooms.Count==0)
            {
                this.currentRooms.Add(new string[3]);
            }
            else if(IsRoomFull(currentRooms[0]))
            {
                this.availableRooms--;
                currentRooms.Insert(0, new string[3]);
            }
            

            if(this.availableRooms!=0)
            {
                this.patientsRegistered.Enqueue(name);
                AddPersonToRoom(name,currentRooms[0]);
            }
        }

        private void AddPersonToRoom(string person, string[] room)
        {
            for(int i =0;i<room.Length;i++)
            {
                if(room[i]==null)
                {
                    room[i] = person;
                    break;
                }
            }
        }

        //checks if currentRoom is full or not
        private bool IsRoomFull(string[] currentRoom)
        {
            bool isEmptyRoom = true;
            for(int i =0;i<currentRoom.Length;i++)
            {
                if(currentRoom[i]==null)
                {
                    isEmptyRoom = false;
                }
            }
            return isEmptyRoom;
        }
    }
}
