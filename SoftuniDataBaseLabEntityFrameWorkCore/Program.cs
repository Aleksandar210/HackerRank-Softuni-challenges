using System.Linq;
using SoftuniDataBaseLabEntityFrameWorkCore.Models;
using System;
using System.Text;
using System.Collections.Generic;

namespace SoftuniDataBaseLabEntityFrameWorkCore
{
    class Program
    {
        static void Main(string[] args)
        {
           using var dbContext = new SoftuniContext();
            //Console.WriteLine(GetEmployeeFullNames(dbContext));
            //Console.WriteLine(EmployeesWithSalaryOver5000(dbContext));
            //Console.WriteLine(EmployeesFromResearchAndDevelopment(dbContext));
            //AddNewAddressToEmployee(dbContext);
            //Console.WriteLine(AddNewAddressToEmployee(dbContext));
            //Console.WriteLine(EmployeesWithProjectsInPeriod2001_2003(dbContext));
            //Console.WriteLine(GetAddressesByTown(dbContext));
            //Console.WriteLine(GetEmployee147(dbContext));
            //Console.WriteLine(DepartmentsWithMoreThan5Employees(dbContext));
            //Console.WriteLine(GetLatest10Projects(dbContext));
            //Console.WriteLine(IncreaseSalaries(dbContext));
            //Console.WriteLine(IncreaseSalaryBy12Procent(13500.0000m));
            //Console.WriteLine(RemoveTown(dbContext));
            //Console.WriteLine(EmployeesNameStartsWithSa(dbContext));

        }

        //Getting Employee's three names and job title
        public static string GetEmployeeFullNames(SoftuniContext context)
        {
           StringBuilder sb = new StringBuilder();

           var employees =  context.Employees.OrderBy(employee => employee.EmployeeId)
                .Select(employee => new
                {
                    FirstName = employee.FirstName,
                    MiddleName = employee.MiddleName,
                    LastName = employee.LastName,
                    JobTitle = employee.JobTitle,
                    EmployeeSalary = employee.Salary
                }
                ).ToArray();

            foreach(var employee in employees)
            {
                sb.Append("Name: " + employee.FirstName + " " + employee.MiddleName + " " + employee.LastName
                    + " Job title: " + employee.JobTitle
                    +" Salary: "+ String.Format("{0:0.00}", employee.EmployeeSalary)
                + Environment.NewLine);
            }

            return sb.ToString();
        }

        //returns string with employees with salary over 50000
        public static string EmployeesWithSalaryOver5000(SoftuniContext dbContext)
        {
            StringBuilder sb = new StringBuilder();

            var employeesWithOver50000Salary = dbContext.Employees.Where(employee => employee.Salary > 50000)
                .OrderBy(employee => employee.FirstName)
                .Select(employee => new
                {
                    Name = employee.FirstName,
                    Salary = employee.Salary
                }
                ).ToArray();

            foreach(var item in employeesWithOver50000Salary)
            {
                sb.Append(item.Name + " -> " + String.Format("{0:0.00}",item.Salary)+Environment.NewLine);
            }

            return sb.ToString();
        }

        //Getting all employees from research and development department
        public static string EmployeesFromResearchAndDevelopment(SoftuniContext dbContext)
        {
            //finding the departmentID of Research and Development
            int researchAndDevelopemntID = dbContext.Departments.Where(department => department.Name.Equals("Research and Development"))
                .FirstOrDefault().DepartmentId;

            //getting the employees
            var employeesFromResearchAndDevelopment = dbContext.Employees.Where(employee => employee.DepartmentId == researchAndDevelopemntID)
                .OrderBy(employee => employee.Salary)
                .ThenByDescending(employee => employee.FirstName)
                .Select(employee => new
                {
                    FirstNameOfEmployee = employee.FirstName,
                    MiddleNameOfEmployee = employee.MiddleName,
                    LastNameOfRmployee = employee.LastName,
                    DepartmentName = "Research and Development",
                    SalaryOfEmployee = employee.Salary
                }
                ).ToArray();

            StringBuilder sb = new StringBuilder();

            //appendint the employees data into the stringbuilder
            foreach(var employee in employeesFromResearchAndDevelopment)
            {
                sb.Append("Name: " + employee.FirstNameOfEmployee + " " + employee.MiddleNameOfEmployee + " " + employee.LastNameOfRmployee
                    + " Department Name: " + employee.DepartmentName +
                    " Salary: " + String.Format("{0:0.00}", employee.SalaryOfEmployee)
                    + Environment.NewLine);
            }

            return sb.ToString();
        }

        //Assigning new address and getting the first 10 employees and their addresses
        public static string AddNewAddressToEmployee(SoftuniContext dbContext)
        {
            int townID = 4;
            string addressToAdd = "Vitoshka 15";

            //adding the address to table Addresses
            dbContext.Addresses.Add(new Address() { AddressText = addressToAdd, TownId = townID });
            dbContext.SaveChanges();

            //getting the address's id we just added
            int? addressID = dbContext.Addresses
                .FirstOrDefault(address => address.AddressText.Equals(addressToAdd) && address.TownId == townID).AddressId;

            //get Employee with last name Nakov
            var employeeWithLastNameNakov = dbContext.Employees.FirstOrDefault(employee => employee.LastName.Equals("Nakov"));

            employeeWithLastNameNakov.AddressId = addressID;
            dbContext.SaveChanges();

            StringBuilder sb = new StringBuilder();

            var employeesAddressesFirst10 = dbContext.Employees.OrderByDescending(employee => employee.AddressId)
                .Take(10).Select(employee=>new
                {
                    Text = employee.Address.AddressText
                }
                ).ToArray();

            foreach(var employee in employeesAddressesFirst10)
            {
                sb.Append(employee.Text + Environment.NewLine);
            }

            return sb.ToString();
        }

        private static string FormatProjectValueInDictioanary(string projectName,DateTime startDate,DateTime? endDate)
        {
            string projectInformation = projectName + " - " + startDate.ToString("M/d/yyyy h:mm:ss tt");

            if(!endDate.HasValue)
            {
                projectInformation += " No end date specified";
            }
            else
            {
                projectInformation += " - " + endDate.Value.ToString("M/d/yyyy h:mm:ss tt");
            }

            return projectInformation;
        }

        public static string EmployeesWithProjectsInPeriod2001_2003(SoftuniContext dbContext)
        {
            var first10Employees = dbContext.EmployeesProjects
                .Where(employee => employee.Project.StartDate.Year >= 2001 && employee.Project.StartDate.Year <= 2003)
                .Take(10)
                .Select(employee => new
                {
                    EmployeeName = employee.Employee.FirstName+employee.Employee.MiddleName+employee.Employee.LastName,
                    ProjectName = employee.Project.Name,
                    ProjectStartDate = employee.Project.StartDate,
                    ProjectEndDate = employee.Project.EndDate
                }
                ).ToArray();

            Dictionary<string, List<string>> currentEmployeesAndTheirPorjects = new Dictionary<string, List<string>>();

            foreach(var item in first10Employees)
            {
                if(!currentEmployeesAndTheirPorjects.ContainsKey(item.EmployeeName))
                {
                    currentEmployeesAndTheirPorjects.Add(item.EmployeeName, new List<string>());
                }

                currentEmployeesAndTheirPorjects[item.EmployeeName]
                    .Add(FormatProjectValueInDictioanary(item.ProjectName,item.ProjectStartDate,item.ProjectEndDate));
            }

            StringBuilder sb = new StringBuilder();

            foreach(var item in currentEmployeesAndTheirPorjects)
            {
                sb.Append(item.Key+Environment.NewLine);

                foreach(var project in item.Value)
                {
                    sb.Append(project + Environment.NewLine);
                }

                sb.Append("---------------------------------------------------"+Environment.NewLine);
            }

            return sb.ToString();
        }

       //Getting addresses ordered by cound and employees who live there
        public static string GetAddressesByTown(SoftuniContext dbContext)
        {
            var addressesArray = dbContext.Addresses.OrderByDescending(address => address.Employees.Count)
                .ThenBy(address => address.Town.Name)
                .ThenBy(address => address.AddressText)
                .Take(10).Select(address => new
                {
                    AddressText = address.AddressText,
                    TownName = address.Town.Name,
                    EmployeesCountOnAddress = address.Employees.Count
                }
                ).ToArray();

            StringBuilder sb = new StringBuilder();

            foreach(var address in addressesArray)
            {
                sb.Append(address.AddressText + " " + address.TownName + " " + address.EmployeesCountOnAddress + " employees live there"+
                    Environment.NewLine);
            }

            return sb.ToString();
        }

        public static string GetEmployee147(SoftuniContext dbContext)
        {
            var employee147 = dbContext.Employees.FirstOrDefault(employee => employee.EmployeeId == 147);

            StringBuilder sb = new StringBuilder();

            sb.Append(employee147.FirstName + " " + employee147.LastName + " " + employee147.JobTitle
                + Environment.NewLine);

            var projectsByEmployee147 = dbContext.EmployeesProjects.Where(employee => employee.EmployeeId == 147)
                .OrderBy(project => project.Project.Name)
                .Select(projectName =>new { Name = projectName.Project.Name })
                .ToArray();
            foreach(var item in projectsByEmployee147)
            {
                sb.Append(item.Name + Environment.NewLine);
            }
            return sb.ToString();
        }

        public static string DepartmentsWithMoreThan5Employees(SoftuniContext dbContext)
        {
            var departmentsWithMoreThan5Empl = dbContext.Departments.Where(department => department.Employees.Count > 5)
                .OrderBy(department => department.Employees.Count)
                .ThenBy(department => department.Name)
                .Select(dep => new
                {
                    DepartmentName = dep.Name,
                    DepartmentManagerName = dep.Manager.FirstName + " " + dep.Manager.LastName,
                    EmployeesInDepartment = dep.Employees.ToArray()
                }).ToArray();

            StringBuilder sb = new StringBuilder();

            foreach(var item in departmentsWithMoreThan5Empl)
            {
                sb.Append("Department information: " + Environment.NewLine);
                sb.Append("Department name: "+item.DepartmentName + " Manager: " + item.DepartmentManagerName + Environment.NewLine);
                sb.Append("Employees: " + Environment.NewLine);

                foreach(var employee in item.EmployeesInDepartment)
                {
                    sb.Append(employee.FirstName + " " + employee.LastName + " " + employee.JobTitle + Environment.NewLine);
                }

                sb.Append("-------------------------------------------------"+Environment.NewLine);
            }

            return sb.ToString();
        }

        //Getting last 10 projects and priniting them alter on the console in main
        public static string GetLatest10Projects(SoftuniContext softuniContext)
        {
            var last10Projects = softuniContext.Projects.OrderByDescending(project => project.ProjectId)
                .Take(10)
                .Select(proj => new
                {
                    ProjectName = proj.Name,
                    ProjectDescription = proj.Description,
                    ProjectStartDate = proj.StartDate

                }).ToArray();

            StringBuilder sb = new StringBuilder();

            foreach(var item in last10Projects)
            {
                sb.Append(item.ProjectName + Environment.NewLine
                    + item.ProjectDescription + Environment.NewLine
                    + item.ProjectStartDate.ToString("M/d/yyyy h:mm:ss tt")+Environment.NewLine);
            }

            return sb.ToString();
        }

        private static decimal IncreaseSalaryBy12Procent(decimal currentSalary)
        {
            decimal twelveProcent = decimal.Divide(12,100);
            decimal increaseBy = (decimal.Multiply(currentSalary, twelveProcent));
            decimal returnSalaryIncreasedBy12 = decimal.Add(increaseBy, currentSalary);
            return returnSalaryIncreasedBy12;
        }

        public static string IncreaseSalaries(SoftuniContext dbContext)
        {
            var employeesWhoseSalariesWillIncrease = dbContext.Employees
                .Where(empl => empl.Department.Name.Equals("Engineering") ||
                empl.Department.Name.Equals("Tool Design") ||
                empl.Department.Name.Equals("Marketing") ||
                empl.Department.Name.Equals("Information Services"))
                .OrderByDescending(empl => empl.FirstName)
                .ThenBy(empl => empl.LastName);

            foreach(var item in employeesWhoseSalariesWillIncrease)
            {
                item.Salary = IncreaseSalaryBy12Procent(item.Salary);
            }
            dbContext.SaveChanges();

            StringBuilder sb = new StringBuilder();

            foreach(var item in employeesWhoseSalariesWillIncrease)
            {
                sb.Append(item.FirstName + " " + item.MiddleName + " " + item.LastName + " Salary: " + item.Salary + Environment.NewLine);
            }

            return sb.ToString();
        }

        public static int RemoveTown(SoftuniContext dbContext)
        {
            //first set the addresses of the employees living in seattle to null
            var employeesLivingInSeattle = dbContext.Employees.Where(employee => employee.Address.Town.Name.Equals("Seattle"));
            
            foreach(var employeeInSeattle in employeesLivingInSeattle)
            {
                employeeInSeattle.AddressId = null;
            }
            dbContext.SaveChanges();

            //Remove the addresses which are located in seattle
            var addressesInSeattle = dbContext.Addresses.Where(address => address.TownId == 4);

            int addressDeleteCount = addressesInSeattle.Count();

            foreach(var addressToRemove in addressesInSeattle)
            {
                dbContext.Remove(addressToRemove);
            }
            dbContext.SaveChanges();

            var townToRemove = dbContext.Towns.FirstOrDefault(town => town.TownId == 4);
            dbContext.Remove(townToRemove);
            dbContext.SaveChanges();

            return addressDeleteCount;
        }

        public static string EmployeesNameStartsWithSa(SoftuniContext dbContext)
        {
            var employeesStartWithSA = dbContext.Employees.Where(empl => empl.FirstName.StartsWith("Sa"))
                .OrderBy(empl=>empl.FirstName)
                .ThenBy(empl=>empl.LastName)
                .Select(empl => new
                {
                    Name = empl.FirstName+" "+empl.LastName,
                    JobTitle = empl.JobTitle,
                    Salary = empl.Salary
                }).ToArray();

            StringBuilder sb = new StringBuilder();

            foreach(var item in employeesStartWithSA)
            {
                sb.Append(item.Name + " " + item.JobTitle + " " + item.Salary + Environment.NewLine);
            }

            return sb.ToString();
        }
    }
}
