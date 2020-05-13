using System;
using System.Collections.Generic;
using System.Text;

namespace SoftuniFundamentals.TelerikDefClassesPartTwo
{
    class GenericList<T>
    {
        private const int InitialCapacity = 4;
        public int Count { get; private set; }

        private T[] elements;

        public GenericList()
        {
            Count = 0;
            elements = new T[InitialCapacity];
        }

    }
}
