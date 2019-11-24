using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace SwitchCase.Models
{
    public class Skin
    {
        public int SkinId { get; set; }

        public int WeaponId { get; set; }

        public string Name { get; set; }

        public int CaseId { get; set; }

        public string ImageLink { get; set; }

        public float Price { get; set; }

        public enum RarityEnum { MilSpec, Restricted, Classified, Covert }

        public RarityEnum Rarity { get; set; }

        public double DropRate { get; set; }
    }
}
