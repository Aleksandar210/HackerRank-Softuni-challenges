using System;
using System.Collections.Generic;
using System.Text;

namespace SoftuniFundamentals.SoftuniOOPCsharpClasses.WildFarm
{
    public class FoodFactory
    {
        public FoodFactory()
        {

        }

        public Food GetFood(string[] foodData)
        {
            switch(foodData[0])
            {
                case "Vegetble":
                    return new Vegetable(int.Parse(foodData[1]));
                case "Seeds":
                    return new Seeds(int.Parse(foodData[1]));
                case "Meat":
                    return new Meat(int.Parse(foodData[1]));
                case "Fruit":
                    return new Fruits(int.Parse(foodData[1]));
                default:
                    throw new NullReferenceException("Invalid food type");
            }
        }
    }
}
