
using System;
using System.Linq;


namespace Red_vs_Green
{
    class Program
    {
        static void Main(string[] args)
        {
           int[] matrixData = Console.ReadLine().Split(", ", StringSplitOptions.RemoveEmptyEntries)
               .Select(int.Parse).ToArray();

            //initialise matrix
            Matrix currentMatrix = new Matrix(matrixData[0], matrixData[1]);

            int[] finalInput = Console.ReadLine().Split(", ", StringSplitOptions.RemoveEmptyEntries)
                .Select(int.Parse).ToArray();

            currentMatrix.ExecuteNGenerations(finalInput[2]);
            currentMatrix.DisplayCellGreenStateCount(finalInput[0], finalInput[1]);
            

        }
    }
}
