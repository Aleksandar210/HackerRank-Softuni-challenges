using System;
using System.Collections.Generic;
using System.Text;

namespace SoftuniFundamentals.TelerikGSMTask
{
    class Display
    {
        private const int DEFAULT_SIZE = 0;
        private const int DEFAULT_COLORS = 0;

        private int numberColors;
        private int size;

        public Display()
        {
            this.numberColors = DEFAULT_COLORS;
            this.size = DEFAULT_SIZE;

        }

        public Display(int size, int color)
        {

        }

        public int NumberColors
        {
            get
            {
                return this.numberColors;
            }
            set
            {
                if (Validated(value))
                {
                    this.numberColors = value;
                }
                else
                {
                    throw new ArgumentException("Invalid Color");
                }
            }
        }

        private bool Validated(int entered)
        {
            if (entered <= 0)
            {
                return false;
            }
            else
            {
                return true;
            }
        }
    }
}
