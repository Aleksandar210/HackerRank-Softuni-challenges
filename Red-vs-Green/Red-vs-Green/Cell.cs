using System;
using System.Collections.Generic;
using System.Reflection.Metadata.Ecma335;
using System.Text;

namespace Red_vs_Green
{
    class Cell
    {
        //consts 
        private const int DefaultTimesGreenVal = 0;
        private const int DefaultNeighbourCount = 0;


        //fields
        private int xCoordinate;
        private int yCoordinate;
        private int currentState;       //green or red
        private int futureState;        //this will become the current in the next gen
        private int greenNegihbourCount;
        private int timesGreen;         //the number of times it has been green

        //constructors
        public Cell(int x, int y, int current)
        {
            this.RowPosition = x;
            this.ColPosition = y;
            this.currentState = current;
            this.timesGreen = DefaultTimesGreenVal;
            this.greenNegihbourCount = DefaultNeighbourCount;
            this.CountColorOnStart(current);
        }

        //properties
       public int RowPosition
        {
            private set
            {
                this.xCoordinate = value;
            }

            get { return this.xCoordinate; }
        }

        public int ColPosition
        {
            private set
            {
                this.yCoordinate = value;
            }
            get { return this.yCoordinate; }
        }

        public int CurrentState
        {
            private set
            {
                if(value==1 || value==0)
                {
                    this.currentState = value;
                }
            }

            get { return this.currentState; }
        }

        private int FutureState
        {
            set 
            {
                if(value==1 || value==0)
                {
                    this.futureState = value;
                }
            }

            get { return this.futureState; }
        }


       

        //behaviour
        private void CountColorOnStart(int startingState)
        {
            if(startingState==1)
            {
                this.IncreaseTimesGreen();
            }
        }

        private void IncreaseTimesGreen()
        {
            this.timesGreen += 1;
        }

        
        //Get Number of green neighbours
        private void CountGreenNeighbours(Cell[,] field)
        {
            this.greenNegihbourCount = 0;

            if (this.RowPosition == 0)
            {
                if (this.ColPosition == 0)
                {
                    greenNegihbourCount += this.RightNeighbour(field);
                    greenNegihbourCount += this.DownRightNeighbour(field);
                    greenNegihbourCount += this.DownNeighbour(field);
                }
                else if (this.ColPosition > 0 && this.ColPosition < field.GetLength(1) - 1)
                {
                    greenNegihbourCount += this.DownNeighbour(field);
                    greenNegihbourCount += this.DownRightNeighbour(field);
                    greenNegihbourCount += this.DownLeftNeighbour(field);
                    greenNegihbourCount += this.RightNeighbour(field);
                    greenNegihbourCount += this.LeftNeighbour(field);
                   
                }
                else if (this.ColPosition == field.GetLength(1) - 1)
                {
                    greenNegihbourCount += this.DownLeftNeighbour(field);
                    greenNegihbourCount += this.DownNeighbour(field);
                    greenNegihbourCount += this.LeftNeighbour(field);
                }
            }
            else if (this.RowPosition > 0 && this.RowPosition < field.GetLength(0) - 1)
            {

                if (this.ColPosition == 0)
                {
                    greenNegihbourCount += this.DownNeighbour(field);
                    greenNegihbourCount += this.UpperNeighbour(field);
                    greenNegihbourCount += this.RightNeighbour(field);
                    greenNegihbourCount += this.DownRightNeighbour(field);
                    greenNegihbourCount += this.UpperRightNeighbour(field);

                }
                else if (this.ColPosition > 0 && this.ColPosition < field.GetLength(1) - 1)
                {
                    greenNegihbourCount += this.RightNeighbour(field);
                    greenNegihbourCount += this.LeftNeighbour(field);
                    greenNegihbourCount += this.DownRightNeighbour(field);
                    greenNegihbourCount += this.DownLeftNeighbour(field);
                    greenNegihbourCount += this.DownNeighbour(field);
                    greenNegihbourCount += this.UpperRightNeighbour(field);
                    greenNegihbourCount += this.UpperNeighbour(field);
                    greenNegihbourCount += this.UpperLeftNeighbour(field);
                }
                else if (this.ColPosition == field.GetLength(1) - 1)
                {
                    greenNegihbourCount += this.DownNeighbour(field);
                    greenNegihbourCount += this.LeftNeighbour(field);
                    greenNegihbourCount += this.DownLeftNeighbour(field);
                    greenNegihbourCount += this.UpperLeftNeighbour(field);
                    greenNegihbourCount += this.UpperNeighbour(field);

                }

            }
            else if(this.RowPosition==field.GetLength(0)-1)
            {

                if (this.ColPosition == 0)
                {
                    greenNegihbourCount += this.UpperNeighbour(field);
                    greenNegihbourCount += this.UpperRightNeighbour(field);
                    greenNegihbourCount += this.RightNeighbour(field);
                }
                else if (this.ColPosition > 0 && this.ColPosition < field.GetLength(1) - 1)
                {

                }
                else if (this.ColPosition == field.GetLength(1) - 1)
                {

                }

            }
        }

        //Check colors Surrounding neighbours
        //-----------------------------------------------------
        private int RightNeighbour(Cell[,] field)
        {
            return field[this.RowPosition, this.ColPosition + 1].CurrentState;
        }

        private int LeftNeighbour(Cell[,] field)
        {
            return field[this.RowPosition, this.ColPosition - 1].CurrentState;
        }

        private int UpperNeighbour(Cell[,] field)
        {
            return field[this.RowPosition-1, this.ColPosition].CurrentState;
        }

        private int UpperRightNeighbour(Cell[,] field)
        {
            return field[this.RowPosition-1, this.ColPosition + 1].CurrentState;
        }

        private int UpperLeftNeighbour(Cell[,] field)
        {
            return field[this.RowPosition-1, this.ColPosition - 1].CurrentState;
        }


        private int DownNeighbour(Cell[,] field)
        {
            return field[this.RowPosition +1, this.ColPosition].CurrentState;
        }

        private int DownLeftNeighbour(Cell[,] field)
        {
            return field[this.RowPosition + 1, this.ColPosition - 1].CurrentState;
        }

        private int DownRightNeighbour(Cell[,] field)
        {
            return field[this.RowPosition + 1, this.ColPosition + 1].CurrentState;
        }

        //------------------------------------------------------------------------------
    }
}
