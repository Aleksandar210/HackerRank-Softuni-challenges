using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace RedVSGreen.Engine
{
    class Startup
    {
        //fields
        private int row;        //represents the rows in the field  (x)
        private int col;        //represents the columns in the field   (y)
        private int[][] field;
        private StringBuilder sb;      //used for drawing field after each generation

        //constructors
        public Startup(int row,int col)
        {
            this.EvaluateFieldData(row, col);
            this.FillTheField();
            Console.Clear();
            this.PrintField();
        }

        private Startup()
        {
            this.sb = new StringBuilder();
            
        }

        //properties
        

        //behaviour

            /// <summary>
            /// thrwos an exception if x and y have not met the requirements.
            /// and if yes the field 2d array is being initialised
            /// </summary>
            /// <param name="data">x and y </param>
        private void EvaluateFieldData(params int[] data)
        {
            if((data[1]<=1000 && data[0]<=data[1]) && data[0]>0)
            {
                this.field = new int[data[0]][];
                this.row = data[0];
                this.col = data[1];
            }
            else
            {
                throw new ArgumentException("Invalid x and y ");
            }
        }

        /// <summary>
        /// adds the intial state of the generation (generation 0)
        /// </summary>
        private void FillTheField()
        {
            StringBuilder sb = new StringBuilder();
            int[] celsOnCurrentRow;
            string enter;
            for(int i =0;i<this.row;i++)
            {
                switch(sb.Capacity)
                {
                    case 0:
                        break;
                    default:
                        Console.Clear();
                        Console.WriteLine(sb.ToString());       //displays enetered cells so far
                        break;
                }
             
                try
                {
                    //iterate over string entered and parse them to in if there isnt an in throw exception
                    enter = Console.ReadLine();
                    if (enter.Length == this.col)
                    {
                        celsOnCurrentRow = enter.ToCharArray().Select(cel =>
                        {
                            if (Char.IsDigit(cel) && (cel == '0' || cel == '1'))
                            {
                                return (int)cel-'0';
                            }
                            else
                            {
                                throw new ArgumentException("Invalid cell format expected [0,1]");
                            }
                        }
                   ).ToArray();

                        //after entering and parsing the cells add them to the field
                        this.field[i] = celsOnCurrentRow;
                        this.sb.Append(enter+Environment.NewLine);

                    }
                    else
                    {
                        throw new ArgumentException("Invalid length of cells");
                    }

                    
                }
                catch(ArgumentException exc)
                {
                    i--;
                    continue;
                }
              
            }
        }

        //test
        public void PrintField()
        {
            for(int i =0;i<this.row;i++)
            {
                for(int j=0;j<this.col;j++)
                {
                    sb.Append(this.field[i][j]);
                }
                sb.Append(Environment.NewLine);
            }

            Console.WriteLine(this.sb.ToString());
        }

        
    }
}
