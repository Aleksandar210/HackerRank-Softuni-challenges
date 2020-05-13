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

        public void Add(T element)
        {
            
            if (Count == this.elements.Length)
            {
                Expand();
            }
            elements[Count++] = element;


        }

        private void Expand()
        {
            T[] currentNewElementsArray = new T[this.elements.Length * 2];
            Array.Copy(this.elements, currentNewElementsArray, Count);
            this.elements = currentNewElementsArray;

        }
    }
}
