using System;
using System.Collections.Generic;
using System.Runtime.CompilerServices;
using System.Text;

namespace SoftuniFundamentals.Csharp_Advanced_Classes
{
    class Parking
    {
        //adding fields
        private Dictionary<string, Car> currentParking;
        private int capacity;
        private string name;
        

        public Parking()
        {
            this.currentParking = new Dictionary<string, Car>();
            this.capacity = 0;

        }

        public Parking(int capacity,string name):this()
        {
            this.Capacity = capacity;
            this.Name = name;
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

        public string Name { private set; get; }
       

        public int Count
        {
            get { return this.currentParking.Count; }
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

        public void RemoveCar(string registrationNumber)
        {
            if(this.currentParking.ContainsKey(registrationNumber))
            {
                this.currentParking.Remove(registrationNumber);
                Console.WriteLine($"Removed car with plate {registrationNumber}");
            }
            else
            {
                throw new ArgumentException("Car doesnt exist");
            }
        }

        public Car GetCar(string registrationNumber)
        {
            if(this.currentParking.ContainsKey(registrationNumber))
            {
                return this.currentParking[registrationNumber];
            }
            else
            {
                throw new ArgumentException("No such car found");
            }
            
        }


        //Action function used for RemoveSetOfRegistration just for practice.
        private Action<List<string>,Dictionary<string,Car>> RemoveSetOfCars = (sets,cars) =>
        {
            
            for(int i =0;i<sets.Count;i++)
            {
                if(cars.ContainsKey(sets[i]))
                {
                    cars.Remove(sets[i]);
                }
            }
        };

        public void RemoveSetOfRegistrationNumber(List<string> currentSetOfNumbers)
        {
            this.RemoveSetOfCars(currentSetOfNumbers, this.currentParking);

        }
    }
}
