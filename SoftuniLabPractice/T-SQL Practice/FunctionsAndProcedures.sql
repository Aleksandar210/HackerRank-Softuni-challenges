--Stored Procedure fr employees with salary highest thatn 30000
GO
CREATE OR ALTER PROC usp_GetEmployeesWithSalaryAbove35000
AS
Begin
SELECT CONCAT_WS(' ',FirstName,LastName) AS [FullName],Salary AS [Employee Salary]
FROM Employees
WHERE Salary > 35000
End

EXEC usp_GetEmployeesWithSalaryAbove35000

--Stored procedure for custom salary number above
GO
CREATE OR ALTER PROC usp_GetEmployeesWithSalariesAboveN @AboveSalary money
AS
BEGIN

IF(@AboveSalary<0)
BEGIN
SELECT 'Invalid Salary'
END
ELSE
BEGIN
SELECT CONCAT_WS(' ',FirstName,LastName) AS [Full Name], Salary AS [Employee Salary]
FROM Employees
WHERE SALARY > @AboveSalary
END

END

EXEC usp_GetEmployeesWithSalariesAboveN 100

--LIST WITH TOWNS STARTING WITH
GO
CREATE PROC usp_TownsStartingWith @With VARCHAR(1)
AS
BEGIN
SELECT [Name] FROM Towns
WHERE [Name] LIKE(@With+'%')
END

EXEC usp_TownsStartingWith 'g'


--Stored proc employees that live in this town
GO
CREATE PROC usp_EmployeesThatLiveInTown @TownName VARCHAR(50)
AS
BEGIN

--First connect employees to towns
SELECT CONCAT_WS(' ',FirstName,LastName) as [Employee full name],Towns.[Name] AS [Lives in]
FROM Employees
JOIN Addresses ON Employees.AddressID = Addresses.AddressID
JOIN Towns ON Towns.TownID = Addresses.TownID
WHERE Towns.[Name] LIKE(@TownName)

END

EXEC usp_EmployeesThatLiveInTown 'Redmond'


--SALARY LEVEL FUNCTION
GO
CREATE PROC usp_GetEmployeesAndSalaryLevelBasedOnSalaryGiven @SalaryGiven money
AS
BEGIN 

DECLARE @SalaryLevel VARCHAR(50);

IF(@SalaryGiven<30000)
SET @SalaryLevel = 'Low'
ELSE IF(@SalaryGiven BETWEEN 30000 AND 50000)
SET @SalaryLevel = 'Medium'
ELSE 
SET @SalaryLevel = 'High'

SELECT CONCAT_WS(' ',FirstName,LastName) AS [Employee full name],Salary,@SalaryLevel
FROM Employees
WHERE Salary = @SalaryGiven

END

EXEC usp_GetEmployeesAndSalaryLevelBasedOnSalaryGiven 25000

--Salary level function
GO
CREATE FUNCTION udf_GetEmployeeSalaryLevel(@SalaryGiven money)
RETURNS VARCHAR(50)
BEGIN

DECLARE @SalaryLevel VARCHAR(50);

IF(@SalaryGiven<30000)
SET @SalaryLevel = 'Low'
ELSE IF(@SalaryGiven BETWEEN 30000 AND 50000)
SET @SalaryLevel = 'Medium'
ELSE 
SET @SalaryLevel = 'High'

RETURN @SalaryLevel

END
GO

SELECT CONCAT_wS(' ',FirstName,LastName) AS[Employee full name],Salary,dbo.udf_GetEmployeeSalaryLevel(Salary)
FROM Employees

--Employees by level of salary
GO
CREATE PROC usp_GetEmployeesByLevelOfSalary @LevelSalary VARCHAR(30)
AS 
BEGIN

IF(@LevelSalary NOT IN('Low','Medium','High'))
BEGIN 
SELECT 'Cannot compute this'
END
ELSE
BEGIN 

SELECT *
FROM
(SELECT CONCAT_WS(' ',FirstName,LastName) AS [Employee full name],Salary AS [Employee Salary],dbo.udf_GetEmployeeSalaryLevel(Salary) AS [Salary level]
FROM Employees) AS SalariesByLevel
WHERE [Salary level] LIKE(@LevelSalary)
END
END

EXEC usp_GetEmployeesByLevelOfSalary 'Low'


--Is word comprised
GO
CREATE FUNCTION udf_IsWordComprised(@Letters VARCHAR(50),@Word VARCHAR(50))
RETURNS INT
BEGIN

RETURN 1
END

SELECT FirstName
FROM EMPLOYEES
where FirstName LIKE('%a%')
--------------------------------------------------------------------------

--Delete employees from department

GO
CREATE FUNCTION udf_GetDepartmentIDByName(@DepartmentName VARCHAR(50))
RETURNS INT
BEGIN

DECLARE @DepartmentID int;

set @DepartmentID = 
(SELECT TOP 1 ID
FROM
(SELECT Employees.DepartmentID as ID,Departments.[Name] AS DepName
FROM Employees
JOIN Departments ON Employees.DepartmentID = Departments.DepartmentID
WHERE Departments.[Name] LIKE('Engineering')
) AS DepartmentID_Name
)


RETURN @DepartmentID
END

GO
CREATE OR ALTER PROC usp_DeleteEmployeesFromDepartment @DepartmentName VARCHAR(50)
AS
BEGIN

DELETE FROM Employees
WHERE Employees.DepartmentID = dbo.udf_GetDepartmentIDByName(@DepartmentName)

END

EXEC usp_DeleteEmployeesFromDepartment 'Engineering'



--Bank Database

CREATE TABLE AccountHolders(
ID BIGINT PRIMARY KEY IDENTITY NOT NULL,
FirstName NVARCHAR(50) NOT NULL,
LastName NVARCHAR(50) NOT NULL,
SSN CHAR(9) CHECK(LEN(SSN)=9) NOT NULL
)

INSERT INTO AccountHolders(FirstName,LastName,SSN)
VALUES
	('Olver','O-Brian','519905960'),
	('Alexander','Washington','619905960'),
	('Brian','Harper','719905960'),
	('Alan','McKanz','819905960'),
	('Zen','Gilbert','919905960'),
	('Nick','Fisher','119905960'),
	('Addler','Secrets','219905960')

CREATE TABLE Accounts(
ID BIGINT Primary key identity not null,
AccountHolder BIGINT FOREIGN KEY REFERENCES AccountHolders(ID) NOT NULL,
Balance DECIMAL(10,2) CHECK(Balance>=0) NOT NULL
)

INSERT INTO Accounts(AccountHolder,Balance)
 VALUES
	(1,40000),
	(2,35000),
	(4,23400),
	(5,19000),
	(6,10000),
	(7,50000)

	

GO
CREATE PROC usp_GetHoldersFullName
AS 
BEGIN
SELECT CONCAT_WS(' ',FirstName,LastName) AS [Holder's full name]
FROM AccountHolders
END

EXEC usp_GetHoldersFullName

GO 
CREATE PROC usp_GetHoldersWithBalanceAbove @Balance DECIMAL(10,2)
AS 
BEGIN
IF(@Balance<0)
BEGIN
RETURN
END
ELSE
BEGIN
SELECT CONCAT_WS(' ',FirstName,LastName) AS [Holder full name],Balance AS HolderBalance
FROM AccountHolders
JOIN Accounts ON Accounts.AccountHolder = AccountHolders.ID
WHERE Balance > @Balance
ORDER BY FirstName ASC,LastName ASC
END
END

EXEC usp_GetHoldersWithBalanceAbove 100

GO
CREATE OR ALTER FUNCTION ufn_CalculateFutureValue(@SUM DECIMAL(18, 4), @yearlyInterestRate FLOAT, @numberOfYears INT)
RETURNS DECIMAL(18, 4) 
AS
BEGIN
    RETURN @SUM * POWER((1 + @yearlyInterestRate), @numberOfYears)
END

GO
CREATE PROC usp_CalculateFutureValueForAccount @InterestRate FLOAT,@AccountId BIGINT
AS 
BEGIN 

IF EXISTS (SELECT * FROM Accounts WHERE AccountHolder = @AccountId)
BEGIN
SELECT CONCAT_WS(' ',FirstName,LastName) AS [Holder Full name],Balance AS [CurrentBalance],dbo.ufn_CalculateFutureValue(Balance,@InterestRate,5)
AS [Balance in five years with interest rate of @InterestRate]
FROM AccountHolders
JOIN Accounts ON Accounts.AccountHolder = AccountHolders.ID
END
ELSE
BEGIN
RETURN
END

END


 

