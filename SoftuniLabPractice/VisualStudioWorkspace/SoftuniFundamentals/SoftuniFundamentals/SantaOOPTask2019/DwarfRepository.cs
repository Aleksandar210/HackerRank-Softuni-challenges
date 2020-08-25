using System;
using System.Collections;
using System.Collections.Generic;
using System.Text;

namespace SoftuniFundamentals.SantaOOPTask2019
{
    class DwarfRepository : IEnumerable<IDwarf>
    {
        private Dictionary<string, Dwarf> dwarfs;

        public DwarfRepository()
        {
            this.dwarfs = new Dictionary<string, Dwarf>();
        }


        //has to return an object of type IEnumerator 
        public IEnumerator<IDwarf> GetEnumerator()
        {
            return new  DwarfRepoEnumerator(dwarfs);
        }


        //Legacy
        IEnumerator IEnumerable.GetEnumerator()
        {
            return (IEnumerator)GetEnumerator();
        }
    }
}
