using System;
using System.Collections.Generic;
using System.Text;

namespace SoftuniFundamentals.TelerikCompProgrammingFolder
{
    class Fence
    {
        //fields
        private int topLeftAngle;
        private int bottomLeftAngle;
        private int topRightAngle;
        private int bottomRightAngle;

        //constructors
        public Fence(int[] bottomLeft, int[] topLeft, int[] topRight, int[] bottomRight)
        {

        }

        //behaviour
        private void EvaluateFenceCoordinates(List<int[]> coordinates)
        {
            if((coordinates[0][0]==coordinates[3][0] && coordinates[0][1]<coordinates[3][1])
                && (coordinates[1][0]==coordinates[2][0] && coordinates[1][1] < coordinates[2][1]))
            {

            }
        }

    }
}
