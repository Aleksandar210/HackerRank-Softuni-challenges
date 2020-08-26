using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace SoftuniFundamentals.SantaOOPTask2019
{
  public class PresentRepository:IPresentRepo
    {

        //resources
        private List<IPresent> presentList;

        //fields
        private List<IPresent> currentPressnts;

        public PresentRepository()
        {
            this.presentList = new List<IPresent>();
            this.currentPressnts = new List<IPresent>();
        }

        public void AddPresent(IPresent presentToAdd)
        {
            this.currentPressnts.Add(presentToAdd);
        }

        public IPresent FindByName(string name)
        {
            this.presentList = this.currentPressnts.Where(e => e.Name.Length==name.Length).ToList();
            for(int i =0;i<this.presentList.Count;i++)
            {
                if(name.Equals(this.presentList[i].Name,StringComparison.OrdinalIgnoreCase))
                {
                    return this.presentList[i];
                }
            }

            return null;
            
        }

        public bool RemovePresent(IPresent presentToRemove)
        {
            if(this.currentPressnts.Contains(presentToRemove))
            {
                this.currentPressnts.Remove(presentToRemove);
                return true;
            }
            else
            {
                return false;
            }
        }
    }
}
