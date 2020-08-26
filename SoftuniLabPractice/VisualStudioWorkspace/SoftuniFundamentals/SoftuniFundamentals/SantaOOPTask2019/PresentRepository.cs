using System;
using System.Collections.Generic;
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
        }

        public void AddPresent(IPresent presentToAdd)
        {
            this.currentPressnts.Add(presentToAdd);
        }

        public IPresent FindByName(string name)
        {
            int index;
            
        }

        public bool RemovePresent(IPresent presentToRemove)
        {
            throw new NotImplementedException();
        }
    }
}
