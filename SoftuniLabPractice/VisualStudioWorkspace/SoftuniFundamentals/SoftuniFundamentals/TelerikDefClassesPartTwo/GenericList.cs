using System;
using System.Collections.Generic;
using System.Linq;
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

        public void RemoveAt( int index)
        {
            if (Count == this.elements.Length / 2)
            {
                T[] currentNewArray = new T[this.elements.Length / 2];
                Array.Copy(this.elements, 0, currentNewArray, 0, Count);
                this.elements = currentNewArray;
            }
            this.Resize(index);


        }

        public void Remove(T element)
        {
            
        }

        public void RemoveAll()
        {
            this.elements = new T[InitialCapacity];
            Count = 0;
        }

        public int IndexOf(T element)
        {
            
            
           for(int i = 0; i < this.elements.Length; i++)
            {
                if (this.elements[i].Equals(element))
                {
                    return i;
                }
            }

            return -1;
        }

        private void Expand()
        {
            T[] currentNewElementsArray = new T[this.elements.Length * 2];
            Array.Copy(this.elements, currentNewElementsArray, Count);
            this.elements = currentNewElementsArray;

        }

        private void Resize(int index)
        {
            T[] currentNewElementArray = new T[this.elements.Length - 1];
            if(index<0 || index > Count)
            {
                throw new ArgumentException("Index out of bounds");
            }

            if (index == 0)
            {
                Array.Copy(this.elements, 1, currentNewElementArray, 0, Count);
                this.elements = currentNewElementArray;
                
            }
            else if(index>0 && index < Count)
            {
                Array.Copy(this.elements, 0, currentNewElementArray, 0, index);
                for(int i = index + 1; i < this.elements.Length; i++)
                {
                    currentNewElementArray[i - 1] = this.elements[i];
                }
            }
            else if (index==Count)
            {
                Array.Copy(this.elements, 0, currentNewElementArray, 0, Count - 1);
            }

            Count--;
        }
    }
}
