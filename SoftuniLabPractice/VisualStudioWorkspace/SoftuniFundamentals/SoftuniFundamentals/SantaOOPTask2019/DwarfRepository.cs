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

        public IEnumerator<IDwarf> GetEnumerator()
        {
            return new  DwarfRepoEnumerator(dwarfs);
        }

        IEnumerator IEnumerable.GetEnumerator()
        {
            return (IEnumerator)GetEnumerator();
        }
    }
}
