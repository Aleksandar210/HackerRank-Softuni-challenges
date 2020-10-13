using System;
using System.Collections.Generic;
using System.Text;

namespace SoftuniFundamentals.SoftuniOOPCsharpClasses.WildFarm
{
    public abstract class AnimalFactoryBase
    {
        public Bird GetBird(string[] birdData)
        {
            switch(birdData[0])
            {
                case "Owl":
                    return new Owl(birdData[1], double.Parse(birdData[1]), double.Parse(birdData[2]));
                case "Hen":
                    return new Hen(birdData[1], double.Parse(birdData[1]), double.Parse(birdData[2]));
                default:
                    throw new NullReferenceException("Invalid or Unkown bird type");
            }
            
        }
    }
}
