using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Linq;
using System.Text;

namespace SoftuniFundamentals.TelerikCompProgrammingFolder
{
    class Fence
    {
        //fields
        private readonly int[] topLeftAngle;
        private readonly int[] bottomLeftAngle;
        private readonly int[] topRightAngle;
        private readonly int[] bottomRightAngle;

        //constructors
        public Fence(int[] bottomLeft, int[] topLeft, int[] topRight, int[] bottomRight)
        {
            if (EvaluateFenceCoordinates(new List<int[]> { bottomLeft, topLeft, topRight, bottomRight }))
            {
                this.topLeftAngle = topLeft;
                this.bottomLeftAngle = bottomLeft;
                this.topRightAngle = topRight;
                this.bottomRightAngle = bottomRight;
            }

        }

        //properties
        public int[] TopLeftAngle
        {
            get { return this.topLeftAngle; }
        }

        public int[] BottomLeftAgle
        {
            get { return this.bottomLeftAngle; }
        }

        public int[] TopRightAngle
        {
            
            get { return this.topRightAngle; }
        }

        public int[] BottomRightAngle
        {

            get { return this.bottomRightAngle; }
            
        }

        //behaviour
        private bool EvaluateFenceCoordinates(List<int[]> coordinates)
        {
            if((coordinates[0][0]==coordinates[3][0] && coordinates[0][1]<coordinates[3][1])
                && (coordinates[1][0]==coordinates[2][0] && coordinates[1][1] < coordinates[2][1]))
            {
                return true;
            }
            else
            {
                return false;
            }
        }

        

        public bool IsSheepInside(int[] sheepCoordinates)
        {

            return false;
        }

    }
}
