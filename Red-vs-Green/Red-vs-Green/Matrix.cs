using System;
using System.Collections.Generic;
using System.Linq;
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
            this.CreateField(rows, cols);
            this.FillMatrixOnStart();
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
            int[] enterData;
            for(int i=0;i<this.field.GetLength(0);i++)
            {
                enterData = Console.ReadLine().Select(e=>(int)e-'0').ToArray();
                for(int j=0;j<enterData.Length;j++)
                {
                    this.field[i, j] = new Cell(i, j, enterData[j]);
                }
            }
       }

        

        public void ExecuteNGenerations(int numberGenerations)
        {
            for(int z=0;z<numberGenerations;z++)
            {
                for (int i = 0; i < this.field.GetLength(0); i++)
                {
                    for (int j = 0; j < this.field.GetLength(1); j++)
                    {
                        this.field[i, j].DetermineFutureState(this.field);
                    }
                }

                for (int i = 0; i < this.field.GetLength(0); i++)
                {
                    for (int j = 0; j < this.field.GetLength(1); j++)
                    {
                        this.field[i, j].UpdateState();
                    }
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

        public void PrintMatrix()
        {
            StringBuilder sb = new StringBuilder();
            for(int i=0;i<this.field.GetLength(0);i++)
            {
                for(int j=0;j<this.field.GetLength(1);j++)
                {
                    sb.Append(this.field[i, j].CurrentState);
                }
                sb.Append(Environment.NewLine);
            }

            Console.WriteLine(sb.ToString());
        }
    }
}
