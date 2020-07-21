using System;
using System.Collections.Generic;
using System.Runtime.CompilerServices;
using System.Text;

namespace SoftuniFundamentals.Csharp_Advanced_Classes
{
    class FootballTeam
    {
        //consts
        private int DefaultRating = 0;

        //fields
        private string name;
        private int rating;
        private Dictionary<string, FootBallPlayer> players; // the players

        // constructs
        public FootballTeam(string name)
        {
            this.players = new Dictionary<string, FootBallPlayer>();
            this.Name = name;
            this.rating = DefaultRating;
        }
        //properties
        public string Name
        {
            private set
            {
                if(String.IsNullOrEmpty(value))
                {
                    throw new NullReferenceException("Invalid or empty name!");
                }
                else
                {
                    this.name = value;
                }
            }
            get { return this.name; }
        }
        public int Rating
        {
           private set
            {
                if(value<0)
                {
                    throw new ArgumentException("Skill Set cannot be negative.");
                }
                else
                {
                    this.rating += value;
                }
            }
            get { return this.rating; }
        }

        // behaviour

        public void AddPlayer(FootBallPlayer player)
        {
            this.Rating = CalculatePlayerRating(player);
            if(!this.players.ContainsKey(player.Name))
            {
                this.players.Add(player.Name, player);
            }
           
        }

        public void RemovePlayer(string player)
        {
            if(this.players.ContainsKey(player))
            {
                this.players.Remove(player);
            }
            else
            {
                throw new ArgumentException("Player not found");
            }
        }

        private int CalculatePlayerRating(FootBallPlayer player)        //used for AddPlayer
        {
            int ratning = 0;
            rating = player.Endurance + player.Sprint + player.Drible + player.Shooting + player.Passing;
            switch(rating)
            {
                case 0:
                    return rating;
                    break;
                default:
                    rating /= 5;
                    return rating;
                    break;
            }
        }

    }
}
