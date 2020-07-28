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
            for(int i=0;i<this.field.GetLength(0);i++)
            {

            }
        }
    }
}
