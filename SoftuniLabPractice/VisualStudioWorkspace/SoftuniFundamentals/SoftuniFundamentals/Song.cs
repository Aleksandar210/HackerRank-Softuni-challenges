﻿using System;
using System.Collections.Generic;
using System.Text;

namespace SoftuniFundamentals
{
    class Song
    {
        private string type {  get; set; }
        public string Name
        {
             get;
            private set;
        }
        private string duration {  get; set; }

        public Song()
        {

        }

        public Song(string type, string name, string duration)
        {
            this.type = type;
            this.Name = name;
            this.duration = duration;
        }

       
        
       
    }
}
