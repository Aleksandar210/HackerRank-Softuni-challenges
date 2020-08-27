using System;
using System.Collections.Generic;
using System.Diagnostics.CodeAnalysis;
using System.Text;

namespace SoftuniFundamentals.Csharp_Advanced_Classes.StorageMaster2019
{
    public class ProductCountComparer : IComparer<List<Product>>
    {
        public int Compare([AllowNull] List<Product> first, [AllowNull] List<Product> second)
        {
            return second.Count - first.Count;
        }
    }
}
