using System;
using System.Collections.Generic;
using System.Text;

namespace SalesDataBaseCodeFirstEntityFrameworkCore.Data.DataValidations
{
    public static class Validation
    {
        public static class StoreValidation
        {
            public static int storeNameMaxLength = 80;
        }

        public static class ProductValidation
        {
            public static int productNameLength = 50;
            
        }

        public static class CustomerVaidation
        {
            public static int customerNameMaxLength=100;
            public static int customerEmailMaxLength = 80;

        }
    }
}
