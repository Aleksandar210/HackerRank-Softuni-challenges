using System;
using System.Collections;
using System.Collections.Generic;
using System.Text;

namespace SoftuniFundamentals.SantaOOPTask2019
{
    class DwarfRepository : IEnumerable<IDwarf>,IDwarfRepo
    {
        private Dictionary<string, IDwarf> dwarfs;

        public DwarfRepository()
        {
            this.dwarfs = new Dictionary<string, IDwarf>();
        }

        public void Add(IDwarf dwarfToAdd)
        {
            if(!this.dwarfs.ContainsKey(dwarfToAdd.Name))
            {
                this.dwarfs.Add(dwarfToAdd.Name, dwarfToAdd);
            }
            
        }

        public IDwarf FindByName(string name)
        {
            if(this.dwarfs.ContainsKey(name))
            {
                return this.dwarfs[name];
            }
            else
            {
                return null;
            }
        }


        //has to return an object of type IEnumerator 
        public IEnumerator<IDwarf> GetEnumerator()
        {
            return new  DwarfRepoEnumerator(dwarfs);
        }

        public bool Remove(IDwarf dwarfToRemove)
        {
            if(this.dwarfs.ContainsKey(dwarfToRemove.Name))
            {
                this.dwarfs.Remove(dwarfToRemove.Name);
                return true;
            }
            else
            {
                return false;
            }
        }


        //Legacy
        IEnumerator IEnumerable.GetEnumerator()
        {
            return (IEnumerator)GetEnumerator();
        }
    }
}
