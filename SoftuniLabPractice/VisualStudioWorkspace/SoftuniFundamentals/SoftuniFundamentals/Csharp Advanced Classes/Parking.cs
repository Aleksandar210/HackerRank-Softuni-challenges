using System;
using System.Collections.Generic;
using System.Text;

namespace SoftuniFundamentals.Csharp_Advanced_Classes
{
    class Parking
    {
        //adding fields
        private Dictionary<string, Car> currentParking;
        private int capacity;           
        

        public Parking()
        {
            this.currentParking = new Dictionary<string, Car>();
            this.capacity = 0;
        }

        public Parking(int capacity):this()
        {
            this.Capacity = capacity;
        }

        //adding prperties
        public int Capacity
        {
            get { return this.capacity; }

            private set 
            {
                if(value<=0)
                {
                    throw new ArgumentException("Space cannot be 0 or below");
                }
                else
                {
                    this.capacity = value;
                }
            }
        }

        //adding Behavior
        public void AddCar(Car car)
        {
            if(this.currentParking.ContainsKey(car.RegistrationNumber))
            {
                throw new ArgumentException($"Car with plate {car.RegistrationNumber} already is in");
            }
            else if(!this.currentParking.ContainsKey(car.RegistrationNumber) && this.Capacity==this.currentParking.Count)
            {
                throw new ArgumentException("Not enough spae in the prking lot");
            }
            else
            {
                this.currentParking.Add(car.RegistrationNumber, car);
                Console.WriteLine($"Successfully added new car {car.Make} {car.RegistrationNumber}");
            }

        }

        public void RemoveCar()
        {

        }
    }
}
