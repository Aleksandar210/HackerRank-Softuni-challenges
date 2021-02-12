using System;
using System.Collections.Generic;
using System.Text;
using System.Text.RegularExpressions;

namespace EntityFrameworkHospitalAppCodeFirst.Data
{
    public static class PatientDataValidation
    {
        public static int PatientNameLength = 50;
        public static int AddressLength = 250;
        public static int EmailAddressLength = 80;
        public static bool IsEmailAddressValid(string emailAddress)
        {
            Regex emailRegex = new Regex(@"^([\w\.\-]+)@([\w\-]+)((\.(\w){2,3})+)$");

            if(emailRegex.Match(emailAddress).Success)
            {
                return true;
            }
            else
            {
                return false;
            }
        }
    }
}
