using System;
using System.Collections.Generic;
using System.Diagnostics.CodeAnalysis;
using System.Text;

namespace SoftuniFundamentals.Csharp_Advanced_Classes.StorageMaster2019
{
    public class ProductCountComparer : IComparer<Product>
    {
        public int Compare([AllowNull] Product x, [AllowNull] Product y)
        {
            throw new NotImplementedException();
        }
    }
}
