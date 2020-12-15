using System;
using System.Collections.Generic;
using System.Text;

namespace HospitalElectronicRegister
{
    public class Room
    {
        private Patient[] currentPatientsInRoom;
        public Room()
        {
            this.currentPatientsInRoom = new Patient[3];
        }

        public bool AddPatientToRoom(Patient currentPatientToBeAdded)
        {
            if(this.IsThereFreeBed()==true)
            {
                for(int i=0;i<this.currentPatientsInRoom.Length;i++)
                {
                    if(this.currentPatientsInRoom[i] is null)
                    {
                        this.currentPatientsInRoom[i] = currentPatientToBeAdded;
                        return true;
                    }
                }
            }

            return false;
        }

        

        private bool IsThereFreeBed()
        {
            int itemsThatAreNull = 0;
            foreach(var item in this.currentPatientsInRoom)
            {
                switch(item)
                {
                    case null:
                        itemsThatAreNull++;
                        break;
                    
                }
            }

            if(itemsThatAreNull==0)
            {
                return false;
            }
            else
            {
                return true;
            }
        }
    }
}
