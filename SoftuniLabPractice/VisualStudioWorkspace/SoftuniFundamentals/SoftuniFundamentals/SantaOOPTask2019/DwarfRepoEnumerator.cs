using System;
using System.Collections;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace SoftuniFundamentals.SantaOOPTask2019
{
    class DwarfRepoEnumerator : IEnumerator<Dwarf>
    {
        private int index = -1;
        private List<Dwarf> dwarfCollection;

        public DwarfRepoEnumerator(Dictionary<string,Dwarf> dwarfCollection)
        {
            this.dwarfCollection = dwarfCollection.Values.ToList();
        }
        public Dwarf Current => this.dwarfCollection[index];

        object IEnumerator.Current => this.Current;

        public void Dispose()
        {
            
        }

        public bool MoveNext()
        {
            this.index++;
            if(index<=this.dwarfCollection.Count-1)
            {
                return true;
            }
            else
            {
                return false;
            }
        }

        public void Reset()
        {
            this.index = -1;
        }
    }
}
