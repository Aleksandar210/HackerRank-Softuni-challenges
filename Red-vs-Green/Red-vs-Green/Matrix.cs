using System;
using System.Collections.Generic;
using System.Text;

namespace Red_vs_Green
{
    class Matrix
    {

        //fields
        Cell[,] field;
        

        //constructors
        public Matrix(int rows, int cols)
        {

        }

        //behaviour
        private void CreateField(int rows, int cols)
        {
            if(cols<=1000 && rows <= cols)
            {
                this.field = new Cell[rows, cols];
            }
        }

        private void FillMatrixOnStart()
        {
            string enterData;
            for(int i=0;i<this.field.GetLength(0);i++)
            {
                enterData = Console.ReadLine();
                if(enterData.Length==this.field.GetLength(1))
                {
                   for(int j=0;i<enterData.Length;j++)
                    {
                        this.field[i, j] = new Cell(i, j, (int)enterData[j] - '0');
                    }
                }
               
            }
        }

        public void ExecuteNGenerations(int numberGenerations)
        {
            for(int i =0;i<this.field.GetLength(0);i++)
            {
                for(int j=0;j<this.field.GetLength(1);j++)
                {
                    this.field[i, j].DetermineFutureState(this.field);
                }
            }

        }

        public void DisplayCellGreenStateCount(params int[] coordinates)
        {
            if(coordinates.Length==2)
            {
                Console.WriteLine("# expected result {0}", this.field[coordinates[0], coordinates[1]].TimesGreen);
            }

        }
    }
}
