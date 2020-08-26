using System;
using System.Collections.Generic;
using System.Diagnostics.CodeAnalysis;
using System.Text;

namespace SoftuniFundamentals.SantaOOPTask2019
{
    class PresentNameEquality : IEqualityComparer<IPresent>
    {
        public bool Equals([AllowNull] IPresent x, [AllowNull] IPresent y)
        {
            if(x.Name.Length==y.Name.Length)
            {
                return true;
            }
            else
            {
                return false;
            }
        }

        public int GetHashCode([DisallowNull] IPresent obj)     //dont really need this one for the task
        {
            return obj.Name.GetHashCode();
        }
    }
}
