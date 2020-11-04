--one to one relation 
--Creating two tables
CREATE TABLE Persons(
Id INT PRIMARY KEY IDENTITY NOT NULL,
FirstName nvarchar(50) NOT NULL,
MiddleName nvarchar(50) NULL,
LastName nvarchar(50) NOT NULL,
PassportId INT NOT NULL,
Constraint FK_Persons_Passports FOREIGN KEY(PassportId) REFERENCES Passports(PassportId)
)



--altering table passports because I forgot to make the passportforeign key unique(1 person - 1 passport)
ALTER TABLE Persons
ADD UNIQUE (PassportId)

--Creating second table with passports
CREATE TABLE Passports(
PassportId INT PRIMARY KEY IDENTITY NOT NULL,
PassportNumber varchar(9) NOT NULL,
CONSTRAINT CHK_PassportNumber_Length CHECK(LEN(PassportNumber)=9)
)


--INSERTING DATA INTO THE TABLES SO THAT WE CAN TEST THE JOIN 
INSERT INTO Passports(PassportNumber)
	VALUES
		('N34FG21BD'),
		('K65LO4R7S'),
		('ZE657QP2F')

		--checking the inserted data
SELECT * FROM Passports

--Inserting into Persons and assigning them a passport
INSERT INTO Persons(FirstName,MiddleName,LastName,PassportId)
	VALUES
		('Ivan',NULL,'Kolev',2),
		('Peyo','Angelov','Dimitrov',3),
		('Atanas','Andreanov','Kirilov',4)


DECLARE @nullMiddleNameCount INT = (select sum(case when MiddleName is null then 1 else 0 end) AS count_nulls
     --, count(MiddleName) AS count_not_nulls -- this is for the count of no nulls
  from Persons);

--JOINING TWO TABLES THIS MEANS ADDING TWO TABLES IN ONE projection TABLE
SELECT FirstName,MiddleName,LastName,Passports.PassportNumber
FROM Persons
JOIN Passports ON Persons.PassportId = Passports.PassportId
--WHERE MiddleName IS NOT NULL
ORDER BY 
--I want to order the table in ascending order if there is a null value in the middleName anywhere
--and in descending if there isnt
CASE WHEN @nullMiddleNameCount >=1 THEN (FirstName+' '+LastName) END ASC,
CASE WHEN @nullMiddleNameCount <= 0 THEN(FirstName+' '+MiddleName+' '+LastName) END DESC

--testing with no nulls
UPDATE Persons
SET MiddleName = 'Aleksandrov'
Where FirstName = 'Ivan'

--Explanation about the variable
--this creats a varriable int where it stores the number of null MiddleName occurences
--DECLARE @nullMiddleNameCount INT = (select sum(case when MiddleName is null then 1 else 0 end) AS count_nulls
     --, count(MiddleName) AS count_not_nulls -- this is for the count of no nulls
 -- from Persons);

  --Print(@nullMiddleNameCount)

  --Clearing table after work with them
DROP TABLE Persons
DROP TABLE Passports
------------------------------------------------------------------------------------------


  --TASK 2
  --One to Many because 1 manufacturer can have multuple Models
  --ITS ABOUT CARS
  CREATE TABLE Manufacturers(
  ManufacturerId INT PRIMARY KEY IDENTITY(1,1) NOT NULL,
  [Name] VARCHAR(50) NOT NULL,
  EstablishedOn DATETIME2 NOT NULL,
  CONSTRAINT CHK_YearOfEstablishement CHECK(YEAR(EstablishedOn)>=1901)
  )


  

  CREATE TABLE Models (
  ModelId INT PRIMARY KEY IDENTITY(100,1) NOT NULL,
  [Name] VARCHAR(50) NOT NULL,
  ManufacturerId INT NOT NULL,
  CONSTRAINT FK_Models_Manufacturers FOREIGN KEY(ManufacturerId) REFERENCES Manufacturers(ManufacturerId)
  )

  --inserting test data for the joins

  INSERT INTO Manufacturers([Name],EstablishedOn)
	VALUES
		('BMW','1916-03-07'),
		('Tesla','2003-01-01'),
		('Lesla','2000-03-16')

INSERT INTO Models([Name],ManufacturerId)
	VALUES
		('x5',1),
		('tesla-7',2),
		('X7 Winter drive',1),
		('Lada-Electirc',3),
		('Rover-Dover',2)

--Selecting the results 
SELECT Manufacturers.[Name],Manufacturers.EstablishedOn,Models.[Name]
FROM Models
JOIN Manufacturers ON Models.ManufacturerId=Manufacturers.ManufacturerId
Order By Manufacturers.EstablishedOn DESC
---------------------------------------------------------------------------------------------------


--Many to many relationship
--many students can attend many exams
-- many to many is used with a middle table

--First we create the talbes and insert the data
CREATE TABLE Students(
StudentId INT PRIMARY KEY IDENTITY(100,1) NOT NULL,
[FirstName] NVARCHAR(50) NOT NULL,
[MiddleName] NVARCHAR(50) NULL,
[LastName] NVARCHAR(50) NOT NULL
)

INSERT INTO Students(FirstName,MiddleName,LastName)
	VALUES
		('Atanas','Bogdanov','Kolev'),
		('Alex','Georgiev','Nestorov'),
		('Dean','Stoqnov','Atanasov'),
		('Georgi','Rusev','Georgiev')

CREATE TABLE Exams(
ExamId INT PRIMARY KEY IDENTITY(1,1) NOT NULL,
ExamName VARCHAR(50) NOT NULL UNIQUE
)

INSERT INTO Exams([ExamName])
	VALUES
		('.NET'),
		('Excel programming'),
		('Video-Game Design'),
		('Mathematics'),
		('Literature'),
		('Biology')



--the middle table that holds info about which student which exam he attended
CREATE TABLE StudentExam(
StudentId INT NOT NULL,
ExamId INT NOT NULL,
Constraint PK_StudentIdAndExamId_Composite PRIMARY KEY(StudentId,ExamId),
Constraint FK_StudentId_Students FOREIGN KEY(StudentId) REFERENCES Students(StudentId),
Constraint FK_ExamId_Exams FOREIGN KEY(ExamId) REFERENCES Exams(ExamId)
)

--Inserting Data
INSERT INTO StudentExam(StudentId,ExamId)
	VALUES
		(101,2),
		(100,4),
		(102,1),
		(103,6),
		(103,2)
  
SELECT CONCAT_WS(' ',FirstName,MiddleName,LastName),ExamName
FROM StudentExam
JOIN Exams ON Exams.ExamId=StudentExam.ExamId
Join Students ON StudentExam.StudentId=Students.StudentId

--SELF REFERENCING 
--First we create table
CREATE TABLE Teachers(
TeacherId INT PRIMARY KEY IDENTITY(100,1) NOT NULL,
[Name] NVARCHAR(50) NOT NULL,
ManagerId INT NULL,
CONSTRAINT FK_ManagerId_TeacherId FOREIGN KEY(ManagerId) REFERENCES Teachers(TeacherId)
)

INSERT INTO Teachers([Name],ManagerId)
	VALUES
		('Julian',NULL),
		('Kole',NULL),
		('Atanas',NULL),
		('Zeer',NULL),
		('Barnie',NULL)
	
SELECT * FROM Teachers
------------------------------------------------------------------------------------------




--TASK 4 CREATING DATA BASE STRUCTURE FOR ONLINE STORES

--First we need a customer the guy who will buy stuff from the store with his account
CREATE TABLE Cities(
CityId INT PRIMARY KEY IDENTITY NOT NULL,
[Name] NVARCHAR(50) NOT NULL
--it can have more info down which if we store just in the customer table we will have to repeat inserts
)

CREATE TABLE Customers(
CustomerId INT PRIMARY KEY IDENTITY(100,1) NOT NULL,
FirstName VARCHAR(50) NOT NULL,
MiddleName VARCHAR(50) NULL,
LastName VARCHAR(50) NOT NULL,
BirthDay DATETIME2 NOT NULL,   --In case the store sells stuff not suitable for below 18 years old
CityId INT NOT NULL   --FOREIGN KEY THAT REFERENCES THE CITY TABLE why is the city in a different table because it can have extra info for the city that doesnt need to be in the customer(repaeating data)
CONSTRAINT FK_CityId_Cities FOREIGN KEY(CityId) REFERENCES Cities(CityId)
)

--ALTER TABLE Customers
--ADD CONSTRAINT FK_CityId_City FOREIGN KEY(CityId) REFERENCES Cities(CityId)

--We create first the cities then the customer becase we cannot create a table with city key where there is no such table

--Table Item type stores additional infor for table ITEMS and it has no relations so i create it first
CREATE TABLE ItemTypes(
ItemTypeId INT PRIMARY KEY IDENTITY(1,1) NOT NULL,
[Name] VARCHAR(50) NOT NULL
)

--After I created the ITEMTPYES TABLE I can freely create the Items table which has relationto already created table
CREATE TABLE Items(
ItemId INT PRIMARY KEY IDENTITY(1,1) NOT NULL,
[Name] VARCHAR(50) NOT NULL,
ItemTypesId INT NOT NULL,
CONSTRAINT FK_ItemsTypeId_ItemTypes_Id FOREIGN KEY(ItemTypesId) REFERENCES ItemTypes(ItemTypeId)
)

--Now we need table orders which is a middle table with composite key this table links the order to the customer (we get the customer info by the orderId)
CREATE TABLE Orders(	--this table holds info aout which customer the order belongs to (item ordered)
OrderId INT NOT NULL,
CustomerId INT NOT NULL,
CONSTRAINT PK_OrderId PRIMARY KEY(OrderId)
)

--Now we have a middle table which holds orderid and itemid columns we reference the info about the customer trough the order id and info about the item trough the item id
CREATE TABLE OrderItems(
OrderId INT NOT NULL,
ItemId INT NOT NULL,
CONSTRAINT PK_COMPOSITE_ORDERID_ITEMID PRIMARY KEY(OrderId,ItemId),
CONSTRAINT FK_OrderId_Orders FOREIGN KEY(OrderId) REFERENCES Orders(OrderId)
)


--Now that we ahve all tables created we can crete some views to view data without typing SELECTS MANY TIMES 
-- We need a view to view the data without me typing a select everytime I need one
GO
CREATE VIEW v_ShowOrderInfo
AS
SELECT CONCAT_WS(' ',FirstName,MiddleName,LastName) AS [CustomerName],Items.[Name] AS [ItemOrdered],ItemTypes.[Name] AS [Item Category]
FROM Orders
JOIN Customers ON Orders.CustomerId=Customers.CustomerId
JOIN OrderItems ON Orders.OrderId=OrderItems.OrderId --We dont use this in the selects except to get acces to the item table
JOIN Items ON Items.ItemId= OrderItems.ItemId -- we acces the item name and we use it to get acces to the itemtypes table
JOIN ItemTypes ON ItemTypes.ItemTypeId=Items.ItemTypesId
ORDER BY CustomerName DESC,Items.[Name] DESC

--and we just have to insert data in the end

--after which we can clear the table by first cleairing the stuff that are not references by other items(tables)
Drop table OrderItems
DROP TABLE Orders
DROP TABLE Customers
DROP TABLE Cities
DROP TABLE Items
DROP TABLE ItemTypes
------------------------------------------------------------------------------------

--UniversityDataBase task

--First We create the tables that do not reference anything
CREATE TABLE Majors(
MajorId INT PRIMARY KEY IDENTITY NOT NULL,
MajorName VARCHAR(50) NOT NULL,
CONSTRAINT chk_MajorName CHECK (MajorName like '%[^0-9]%') --MajorNames cannot have numbers well at least in this table sorry
)

CREATE TABLE Subjects(
SubjectId INT PRIMARY KEY IDENTITY NOT NULL,
SubjectName VARCHAR(50) NOT NULL
)

-- We then create a table students which is referenced by many object
CREATE TABLE Students(
StudentId INT PRIMARY KEY IDENTITY NOT NULL,   -- Used to search for a entry row data
StudentNumber char(10),
FirstName NVARCHAR(50) NOT NULL,
MiddleName NVARCHAR(50) NOT NULL,
LastName NVARCHAR(50) NOT NULL,
MajorId INT NOT NULL,
CONSTRAINT chk_studentNumber CHECK (StudentNumber not like '%[^0-9]%' AND LEN(StudentNumber)=10),
CONSTRAINT FK_MajorId_Majors FOREIGN KEY(MajorId) REFERENCES Majors(MajorId)
)

--Agenda holds info what subjects, students go to it can have many students many sibjects (many to many even tho students have majors but whatever)
CREATE TABLE Agenda(
StudentId INT NOT NULL,
SubjectId INT NOT NULL,
CONSTRAINT PK_COMPOISTE_StudID_SubId PRIMARY KEY(StudentId,SubjectId),
CONSTRAINT FK_StudentId_Students FOREIGN KEY(StudentId) REFERENCES Students(StudentId),
CONSTRAINT FK_SubjectId_Subjects FOREIGN KEY (SubjectId) REFERENCES Subjects(SubjectId)
)

CREATE TABLE Payments(
PaymentId INT PRIMARY KEY IDENTITY NOT NULL,
PaymentDate DATETIME2 NOT NULL,
PaymentAmount Decimal(5,2) NOT NULL,
StudentId INT NOT NULL FOREIGN KEY REFERENCES Students(StudentId)
)




