--Car Rental Service task
/*
Using SQL queries create CarRental database with the following entities:
1 Categories (Id, CategoryName, DailyRate, WeeklyRate, MonthlyRate, WeekendRate)
2 Cars (Id, PlateNumber, Manufacturer, Model, CarYear, CategoryId, Doors, Picture, Condition, Available)
3 Employees (Id, FirstName, LastName, Title, Notes)
4 Customers (Id, DriverLicenceNumber, FullName, Address, City, ZIPCode, Notes)
5 RentalOrders (Id, EmployeeId, CustomerId, CarId, TankLevel, KilometrageStart, KilometrageEnd,
TotalKilometrage, StartDate, EndDate, TotalDays, RateApplied, TaxRate, OrderStatus, Notes)

Set most appropriate data types for each column. Set primary key to each table. Populate each table with only 3
records. Make sure the columns that are present in 2 tables would be of the same data type. Consider which fields
are always required and which are optional. Submit your CREATE TABLE and INSERT statements as Run queries &amp;
check DB.

*/

-- Creating category table
CREATE TABLE Categories(
Id int PRIMARY KEY IDENTITY NOT NULL,
CategoryName varchar(50) NOT NULL,
DailyRate DECIMAL(4,2) NOT NULL,
WeeklyRate DECIMAL(5,2) NOT NULL,
MonlthlyRate DECIMAL(6,2) NOT NULL,
WeekendRate DECIMAL(4,2) NOT NULL
)

--Creating Cars Table
CREATE TABLE Cars(
Id int PRIMARY KEY IDENTITY NOT NULL,
PlateNumber char(8) UNIQUE NOT NULL,
Manufacturer varchar(50) NULL DEFAULT('Not Specified'),
Model varchar(50) NULL DEFAULT('Not Specified'),
CarYear smallINT NOT NULL,
CategoryId INT NOT NULL,
Doors TINYINT NOT NULL,
Picture varbinary(Max) NULL,
Condition varchar(50) NOT NULL,
Available BIT NOT NULL,
--Constraints - conditions and rules basicaly
Constraint CHK_Car_Year CHECK(CarYear>=1769 OR CarYear<=2021),
Constraint FK_CategoryId FOREIGN KEY(CategoryId) REFERENCES Categories(Id),
CONSTRAINT CHK_Door_Value CHECK(Doors>=1),
CONSTRAINT CHK_Condition_Value CHECK(Condition='Very Bad' OR Condition ='Bad' OR Condition ='Good' oR Condition ='Vety Good')
)

--Creating Table Employees
CREATE TABLE Employees(
Id int primary key identity not null,
FirstName nvarchar(50) NOT NULL,
LastName nvarchar(50) NOT NULL,
Title varchar(50) NOT NULL,
Notes varchar(MAX) NULL
)

--Creating table Customers
CREATE TABLE Customers(
Id int primary key identity not null,
DriverLicenseNumber varchar(50) NOT NULL,
FirstName nvarchar(50) NOT NULL,
SecondName varchar(50) NOT NULL,
LastName varchar(50) NOT NULL,
Adress varchar(50) NOT NULL,
City varchar(50) NOT NULL,
ZIPcode char(4) NOT NULL,
Notes varchar(MAX) NULL DEFAULT('Not included'),
Constraint CHK_ZIPcode_Length CHECK(LEN(ZIPcode)=4)
)


--TO DO ASK QUESTIONA BOUT IT IN STACKOVERFLOW
--CREATING TABLE RENTAL ORDERS
CREATE TABLE RentalOrders(
Id int primary key identity not null,
EmployeeId int NOT NULL,
CustomerId int not null,
CarId int NOT NULL,
TankLevel varchar(3) NOT NULL,
KilometrageStart DECIMAL(6,3) NULL DEFAULT(000000),
KilometrageEnd DECIMAL(6,3) NULL DEFAULT(900000),
TotalKilometrage Decimal(6,3) NULL DEFAULT(000000),
StartDate DATETIME2 NULL DEFAULT(GETDATE()),
EndDate DATETIME2 NULL DEFAULT('2025-10-23'),
TotalDays int NULL DEFAULT(0),
RateApplied varchar(40) NULL,
TaxRate DECIMAL NULL,
Notes varchar(Max) NULL Default('Not included'),
CONSTRAINT CHK_TotalDays_Value CHECK(TotalDays>-1),
CONSTRAINT CHK_EndDate_Value CHECK(EndDate<='2025-10-23'),
CONSTRAINT CHK_StartDate_Value CHECK(StartDate>='2020-10-23'),
CONSTRAINT CHK_TankLevel_Value CHECK(TankLevel='E' OR TankLevel='1/2' OR TankLevel='F'),
CONSTRAINT FK_CarId_Cars_Id FOREIGN KEY(CarId) REFERENCES Cars(Id),
Constraint FK_CustomerId_Customers_Id FOREIGN KEY(CustomerId) REFERENCES Customers(Id),
Constraint FK_EmployeeId_Employees_Id FOREIGN KEY(EmployeeId) REFERENCES Employees(Id)
)