--This Querry is used to work on Database Softuni for Selects and other DDL commands

--Find all info about Departments
SELECT * FROM [Departments]

--Find all Department names distinct
Select Distinct [Name] From [Departments]

--or you can do it like this
SELECT [Name] FROM Departments		-- now each job title column is a container which holds all the fields(stored data that are from this Name)
									--This means I can do stuff liek Count(*) and will get every one who are in that Name(container)
GROUP BY [Name] 

SELECT [Name], Count(*) FROM Departments
GROUP BY [Name]


--find the salaraies of the employees
SELECT FirstName+' '+LastName AS [Name], Salary
FROM Employees
ORDER BY Salary DESC

--find all the names of the employees
SELECT FirstName,MiddleName,LastName 
FROM Employees
WHERE MiddleName IS NOT NULL

SELECT FirstName+'.'+LastName+'Softuni@.bg'
FROM Employees

--gets the unique slaries and a full name associated with that salary probaby the first that appeared
SELECT DISTINCT Salary,FirstName+' '+MiddleName+' '+LastName AS [Name]
From Employees

--find all info about employees whose job title is Sales Representative
SELECT * FROM Employees
Where JobTitle Like('Sales Representative')

--this querry gets the infor about the employees whose salary is either 20000 or 30000
Select FirstName+' '+LastName AS [Name],JobTitle
FROM Employees
Where Salary IN (20000,30000)

--this querry gets infor about employees whose salary is between 20000 and 30000
SELECT FirstName,LastName,JobTitle
FROM Employees
Where Salary>=20000 AND Salary<=30000

--gets all employee full name which salaries are either one of thsoe salary values
SELECT FirstName+' '+MiddleName+' '+LastName AS [Full Name]
FROM Employees
WHERE Salary IN(25000,14000,12500,23600)

--get employees with no manager
SELECT FirstName,LastName,JobTitle
FROM Employees
WHERE ManagerId IS NULL

--employees with salary more than 50000 in descending order
SELECT FirstName,LastName,Salary
FROM Employees 
WHERE Salary>50000
ORDER BY Salary DESC

--top 5 best paid employyes
SELECT TOP 5 FirstName,LastName,Salary
FROM Employees 
ORDER BY Salary DESC

--every one except marketing who are with id 4 
SELECT FirstName,LastName,Salary
FROM Employees
Where DepartmentId !=4

--Sort Employees table 
SELECT * FROM Employees
ORDER BY Salary DESC,FirstName ASC,LastName DESC,MiddleName ASC

--CREATE A VIEW FOR FIRST NAME LAST NAME AND SALARY 
CREATE VIEW v_FirstLastNameAndSalary AS
SELECT FirstName,LastName,Salary
FROM Employees

-- now to use the view
SELECT FirstName FROM v_FirstLastNameAndSalary
Where [FirstName] LIKE('A%')

--VIEW With FullName and Job Title
CREATE VIEW v_FullNameAndTitle AS
SELECT FirstName+' '+MiddleName+' '+LastName AS [Full Name],JobTitle
FROM Employees

SELECT * FROM v_FullNameAndTitle
Where [Full Name] IS NOT NULL

--Distinct JobTitles
SELECT DISTINCT JobTitle FROM Employees

SELECT TOP 10 * FROM Projects
ORDER BY StartDate,[Name]

--get last 7 hired Employees
SELECT TOP 7 FirstName,LastName,JobTitle FROM Employees
Order BY EmployeeId Desc

SELECT * FROM Departments

--INCREASE SALARY
UPDATE Employees
SET Salary = ((12*0.01)*Salary)+Salary
WHERE  DepartmentId IN(1,2,4,11)

--ALL PEAKS IN ALPHABETIC ORDER
SELECT PeakName FROM Peaks
ORDER BY PeakName ASC

SELECT * FROM Continents

--find 30 biggest countries by population
SELECT TOP 30 [CountryName],[Population] FROM Countries
Where ContinentCode = 'EU'
ORDER BY [Population] DESC


--Countries and Currencies with case when for euor or not euro
SELECT [CountryName],[CountryCode],
CASE
    WHEN CurrencyCode LIKE('EUR') THEN 'EURO'
    ELSE 'NOT EURO'
END AS Currency
FROM Countries
Order By CountryName ASC

