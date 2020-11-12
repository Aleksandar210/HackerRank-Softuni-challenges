--1 task
SELECT top 5 EmployeeID, JobTitle,Employees.AddressID,AddressText
FROM Employees
JOIN Addresses ON Employees.AddressId=Addresses.AddressId
ORDER BY Employees.AddressID ASC

--first name last name town and adress text
SELECT top 50 FirstName,LastName,Towns.[Name],AddressText
FROM Employees
JOIN Addresses ON Employees.AddressID = Addresses.AddressID
JOIN Towns ON Addresses.TownID = Towns.TownID
ORDER BY FirstName ASC,LastName


--select firstName Last name empl id and department id where we get only those from sales

SELECT EmployeeID,FirstName,LastName,Departments.[Name] AS DepartmentName
FROM Employees
JOIN Departments ON Employees.DepartmentID = Departments.DepartmentID
WHERE Departments.[Name] LIKE 'Sales'
ORDER BY Employees.EmployeeID ASC


--with those who are salary above 15000
SELECT top 5 EmployeeID,FirstName,LastName,Departments.[Name] AS DepartmentName
FROM Employees
JOIN Departments ON Employees.DepartmentID = Departments.DepartmentID
WHERE Employees.Salary>15000
ORDER BY Departments.DepartmentID ASC

--filter only employees without a project
SELECT top 5 Employees.EmployeeID,CONCAT_WS(' ',FirstName,LastName) AS [Full Name]
FROM Employees
FULL OUTER JOIN EmployeesProjects ON Employees.EmployeeID=EmployeesProjects.EmployeeID
WHERE ProjectID is null

--hired after some date and are from sales or finance
SELECT FirstName,LastName,HireDate,Departments.[Name]
FROM Employees
JOIN Departments ON Departments.DepartmentID=Employees.EmployeeID
WHERE HireDate>CONVERT(smalldatetime,'1999-01-01') AND Departments.[Name] IN('Sales','Finance')
ORDER BY HireDate ASC

--select employees with a project after date and is still ongoing
SELECT top 5 EmployeeS.EmployeeID as EmployeeID,FirstName,LastName,Projects.[Name] AS ProjectName
FROM Employees
JOIN EmployeesProjects ON EmployeeS.EmployeeID=EmployeesProjects.EmployeeID
JOIN Projects ON Projects.ProjectID = EmployeesProjects.ProjectID 
WHERE Projects.StartDate>'2002-08-13' AND Projects.EndDate IS NULL
ORDER BY EmployeeID ASC

--Employee 24 and select null project name if the project has started during ora fter 2005
SELECT Employees.EmployeeID,CONCAT_WS(' ',FirstName,LastName) AS [Full name],
CASE 
WHEN Projects.StartDate>=Convert(smalldatetime,'2005-01-01') THEN NULL
ELSE Projects.[Name]
END AS [Project Name]
FROM Employees
JOIN EmployeesProjects ON Employees.EmployeeID=EmployeesProjects.EmployeeID
JOIN Projects ON Projects.ProjectID = EmployeesProjects.ProjectID
WHERE Employees.EmployeeID = 24


--Employee and Manager
SELECT Employees.EmployeeID,Employees.FirstName,Employees.ManagerID,Managers.FirstName
FROM Employees
JOIN Employees AS Managers ON Employees.ManagerID = Managers.EmployeeID 
WHERE Employees.ManagerID IN (3,7)
ORDER BY Employees.EmployeeID ASC


--Employee Summary
SELECT TOP 50 CONCAT_WS(' ',Employees.FirstName,Employees.LastName),CONCAT_WS(' ',Managers.[FirstName],Managers.[LastName]),Departments.[Name]
FROM Employees
JOIN Employees AS Managers ON Employees.ManagerID = Managers.EmployeeID
JOIN Departments ON Employees.DepartmentID = Departments.DepartmentID
ORDER BY Employees.EmployeeID ASC

--test
SELECT (SELECT [Name] FROM Departments WHERE Employees.DepartmentID = Departments.DepartmentID),AVG(Salary)
FROM Employees
GROUP BY DepartmentID

--Select the min salary from the departments and the department name of that min salary
SELECT TOP 1 AVG(Salary) as avgSalary
FROM Employees
GROUP BY DepartmentID
Order by avgSalary ASC


--Show country code and name mountain range and peak name and elevation
--First we have a country table that has only information about the country and a mountain table that has info of the mountains 
--We have a middle table which has mountain id and country id we will use this one
SELECT Countries.CountryCode,CountryName,MountainRange,Peaks.PeakName,Peaks.Elevation
FROM Countries
JOIN MountainsCountries ON Countries.CountryCode = MountainsCountries.CountryCode
JOIN Mountains ON MountainsCountries.MountainId = Mountains.Id
JOIN Peaks ON Mountains.Id = Peaks.MountainId
WHERE CountryName LIKE('Bulgaria') AND Elevation>2835
ORDER BY Elevation DESC

SELECT * FROM Countries

--Count mountain ranges in countries in USA Russia and Bulgaria
SELECT Countries.CountryCode,COUNT(Mountains.MountainRange) as MountainRangeCount
FROM Countries
JOIN MountainsCountries ON Countries.CountryCode = MountainsCountries.CountryCode
JOIN Mountains ON MountainsCountries.MountainId = Mountains.Id
WHERE Countries.CountryName IN ('Bulgaria','Russia','United states')
GROUP BY Countries.CountryCode

--Countries with or without rivers
SELECT top 5 CountryName,RiverName
FROM Countries
LEFT JOIN CountriesRivers ON Countries.CountryCode = CountriesRivers.CountryCode
LEFT JOIN Rivers ON CountriesRivers.RiverId = Rivers.Id
WHERE ContinentCode = 'AF'
ORDER BY CountryName ASC

-- not quite sure but it works in some way
SELECT Countries.ContinentCode AS ContinentCode,Countries.CurrencyCode AS CurrencyCode,COUNT(*) AS CurrencyUsage
FROM Countries
JOIN Continents as cc ON Countries.ContinentCode = cc.ContinentCode
 JOIN Currencies as ccr ON Countries.CurrencyCode = ccr.CurrencyCode
GROUP BY Countries.ContinentCode,Countries.CurrencyCode
Having COUNT(*) >1
ORDER BY ContinentCode DESC

--Countries with no mountain

SELECT COUNT(*) --Countries.CountryName,MountainsCountries.MountainId
FROM Countries
FULL OUTER JOIN MountainsCountries ON Countries.CountryCode = MountainsCountries.CountryCode
WHERE MountainsCountries.MountainId IS NULL


--Highest Peak name and Elevation  by country 

--the highest peak in Countries
SELECT CountryName,ElevationNumber,RiverLength
FROM 
(SELECT CountryName,PeakName,ElevationNumber,RiverLength,
DENSE_RANK() OVER (PARTITION BY CountryName ORDER BY ElevationNumber DESC,RiverLength DESC) AS CountryRank
FROM
(SELECT Countries.CountryName AS CountryName,Peaks.PeakName AS PeakName,Peaks.Elevation AS ElevationNumber,Rivers.[Length] AS RiverLength
FROM Countries
JOIN MountainsCountries ON Countries.CountryCode = MountainsCountries.CountryCode
JOIN Mountains ON MountainsCountries.MountainId = Mountains.Id
JOIN Peaks ON Mountains.Id = Peaks.MountainId
JOIN CountriesRivers ON Countries.CountryCode = CountriesRivers.CountryCode
JOIN Rivers ON CountriesRivers.RiverId = Rivers.Id
) AS CountriesPeaksRivers
) AS Something
WHERE CountryRank = 1

--highest peak by country and elevation in mountain range
SELECT CountryName,ISNULL(PeakName,'No highest Peak'),ISNULL(PeakElevation,0),ISNULL(MountainRange,'No mountain')
FROM
(SELECT Countries.CountryName AS CountryName,Peaks.PeakName AS PeakName,Peaks.Elevation AS PeakElevation,Mountains.MountainRange AS MountainRange,
DENSE_RANK() OVER(PARTITION BY CountryName ORDER BY Peaks.Elevation desc) AS PeakRank
FROM Countries
LEFT JOIN MountainsCountries ON Countries.CountryCode = MountainsCountries.CountryCode
LEFT JOIN Mountains ON MountainsCountries.MountainId = Mountains.Id
LEFT JOIN Peaks ON Mountains.Id = Peaks.MountainId
) AS PeakInfo
WHERE PeakRank =1 
ORDER BY CountryName



