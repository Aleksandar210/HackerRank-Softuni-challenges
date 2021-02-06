GO
SELECT  TOP 10 * FROM EmployeesProjects
JOIN Employees ON Employees.EmployeeID=EmployeesProjects.EmployeeID
JOIN Projects ON Projects.ProjectID=EmployeesProjects.ProjectID
WHERE YEAR(StartDate)>=2001 AND YEAR(StartDate)<=2003

GO
SELECT * FROM Employees
WHERE EmployeeID=147

GO
SELECT * FROM EmployeesProjects
WHERE EmployeeID=147

SELECT * FROM Departments


GO
SELECT * FROM Employees
WHERE DepartmentID = 1 OR DepartmentID = 2 OR DepartmentID = 4 OR DepartmentID=11

GO
SELECT * FROM Towns

GO 
SELECT * FROM Employees

GO
SELECT * FROM Addresses
WHERE TownID =4

GO
SELECT * FROM Employees
WHERE FirstName LIKE 'Sa%'