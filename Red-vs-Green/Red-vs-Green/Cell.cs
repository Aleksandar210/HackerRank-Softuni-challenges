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
            this.CurrentState = current;
            this.timesGreen = DefaultTimesGreenVal;
            this.greenNegihbourCount = DefaultNeighbourCount;
            this.IncreaseIfGreen();
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
        private void IncreaseIfGreen()
        {
            if(this.CurrentState==1)
            {
                this.IncreaseTimesGreen();
            }
        }

        private void IncreaseTimesGreen()
        {
            this.timesGreen += 1;
        }

        //Update current state with future state
        private void UpdateState()
        {
            this.CurrentState = FutureState;
            this.IncreaseIfGreen();

        }

        

        //Determine Future State by the rules
        public void DetermineFutureState(Cell[,] field)
        {
            this.CountGreenNeighbours(field);

            switch(this.CurrentState)
            {
                case 1:
                    switch(this.greenNegihbourCount)
                    {
                        case 2:
                        case 3:
                        case 6:
                            this.FutureState = 1;
                            break;
                        default:
                            this.FutureState = 0;
                            break;
                    }
                    break;
                case 0:
                    switch(this.greenNegihbourCount)
                    {
                        case 3:
                        case 6:
                            this.FutureState = 1;
                            break;
                        default:
                            this.FutureState = 0;
                            break;
                    }
                    break;

            }

            this.UpdateState();
        }
        
        //Get Number of green neighbours
        private void CountGreenNeighbours(Cell[,] field)
        {
            this.greenNegihbourCount = 0;

            if (this.RowPosition == 0)
            {
                if (this.ColPosition == 0)
                {
                    this.greenNegihbourCount += this.RightNeighbour(field);
                    this.greenNegihbourCount += this.DownRightNeighbour(field);
                    this.greenNegihbourCount += this.DownNeighbour(field);
                }
                else if (this.ColPosition > 0 && this.ColPosition < field.GetLength(1) - 1)
                {
                    this.greenNegihbourCount += this.DownNeighbour(field);
                    this.greenNegihbourCount += this.DownRightNeighbour(field);
                    this.greenNegihbourCount += this.DownLeftNeighbour(field);
                    this.greenNegihbourCount += this.RightNeighbour(field);
                    this.greenNegihbourCount += this.LeftNeighbour(field);
                   
                }
                else if (this.ColPosition == field.GetLength(1) - 1)
                {
                    this.greenNegihbourCount += this.DownLeftNeighbour(field);
                    this.greenNegihbourCount += this.DownNeighbour(field);
                    this.greenNegihbourCount += this.LeftNeighbour(field);
                }
            }
            else if (this.RowPosition > 0 && this.RowPosition < field.GetLength(0) - 1)
            {

                if (this.ColPosition == 0)
                {
                    this.greenNegihbourCount += this.DownNeighbour(field);
                    this.greenNegihbourCount += this.UpperNeighbour(field);
                    this.greenNegihbourCount += this.RightNeighbour(field);
                    this.greenNegihbourCount += this.DownRightNeighbour(field);
                    this.greenNegihbourCount += this.UpperRightNeighbour(field);

                }
                else if (this.ColPosition > 0 && this.ColPosition < field.GetLength(1) - 1)
                {
                    this.greenNegihbourCount += this.RightNeighbour(field);
                    this.greenNegihbourCount += this.LeftNeighbour(field);
                    this.greenNegihbourCount += this.DownRightNeighbour(field);
                    this.greenNegihbourCount += this.DownLeftNeighbour(field);
                    this.greenNegihbourCount += this.DownNeighbour(field);
                    this.greenNegihbourCount += this.UpperRightNeighbour(field);
                    this.greenNegihbourCount += this.UpperNeighbour(field);
                    this.greenNegihbourCount += this.UpperLeftNeighbour(field);
                }
                else if (this.ColPosition == field.GetLength(1) - 1)
                {
                    this.greenNegihbourCount += this.DownNeighbour(field);
                    this.greenNegihbourCount += this.LeftNeighbour(field);
                    this.greenNegihbourCount += this.DownLeftNeighbour(field);
                    this.greenNegihbourCount += this.UpperLeftNeighbour(field);
                    this.greenNegihbourCount += this.UpperNeighbour(field);

                }

            }
            else if(this.RowPosition==field.GetLength(0)-1)
            {

                if (this.ColPosition == 0)
                {
                    this.greenNegihbourCount += this.UpperNeighbour(field);
                    this.greenNegihbourCount += this.UpperRightNeighbour(field);
                    this.greenNegihbourCount += this.RightNeighbour(field);
                }
                else if (this.ColPosition > 0 && this.ColPosition < field.GetLength(1) - 1)
                {
                    this.greenNegihbourCount += this.UpperRightNeighbour(field);
                    this.greenNegihbourCount += this.UpperNeighbour(field);
                    this.greenNegihbourCount += this.UpperLeftNeighbour(field);
                    this.greenNegihbourCount += this.LeftNeighbour(field);
                    this.greenNegihbourCount += this.RightNeighbour(field);
                }
                else if (this.ColPosition == field.GetLength(1) - 1)
                {
                    this.greenNegihbourCount += this.LeftNeighbour(field);
                    this.greenNegihbourCount += this.UpperLeftNeighbour(field);
                    this.greenNegihbourCount += this.UpperNeighbour(field);
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
