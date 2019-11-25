using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using Microsoft.EntityFrameworkCore;
using SwitchCase.Models;

namespace SwitchCase
{
    //хуебала
    public class SwitchCaseContext : DbContext
    {
        public DbSet<User> Users { get; set; }
        public DbSet<Skin> Skins { get; set; }
        public DbSet<Case> Cases { get; set; }

        public SwitchCaseContext(DbContextOptions<SwitchCaseContext> options)
            : base(options) { }
    }
}
