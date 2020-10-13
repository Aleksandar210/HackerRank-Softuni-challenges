using System;
using System.Collections.Generic;
using System.Text;

namespace SoftuniFundamentals.SoftuniOOPCsharpClasses.WildFarm
{
    public  class AnimalFactoryBase
    {
        public AnimalFactoryBase()
        {

        }
        
        public Bird GetBird(string[] birdData)
        {
            switch(birdData[0])
            {
                case "Owl":
                    return new Owl(birdData[1], double.Parse(birdData[1]), double.Parse(birdData[2]),int.Parse(birdData[3]));
                case "Hen":
                    return new Hen(birdData[1], double.Parse(birdData[1]), double.Parse(birdData[2]),int.Parse(birdData[3]));
                default:
                    throw new NullReferenceException("Invalid or Unkown bird type");
            }
            
        }

        public Feline GetFeline(string[] felineData)
        {
            switch(felineData[0])
            {
                case "Cat":
                    return new Cat(felineData[1], double.Parse(felineData[2]), felineData[3], felineData[4]);
                case "Tiger":
                    return new Tiger(felineData[1], double.Parse(felineData[2]), felineData[3], felineData[4]);
                default:
                    throw new NullReferenceException("Invalid type or unknown");
            }
        }

        public Mammal GetMammal(string[] mammalData)
        {
            switch (mammalData[0])
            {
                case "Mouse":
                    return new Mouse(mammalData[1],double.Parse(mammalData[2]),mammalData[3]);
                case "Dog":
                    return new Dog(mammalData[1], double.Parse(mammalData[2]), mammalData[3]);
                default:
                    throw new NullReferenceException("Invalid type or unknown");
            }
        }
    }
}
