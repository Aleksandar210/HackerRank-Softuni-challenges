--USED FOR HOTEL DATA BASE 
CREATE TABLE Employees(
Id INT PRIMARY KEY IDENTITY NOT NULL,
FirstName nvarchar(50) NOT NULL,
LastName nvarchar(50) NOT NULL,
Title varchar(50) NOT NULL,
Notes varchar(max) NULL DEFAULT('Not included')
)

--Creating table customers
CREATE TABLE Customers(
AccountNumber INT PRIMARY KEY IDENTITY(1,1) NOT NULL,
FirstName nvarchar(50) NOT NULL,
LastName  nvarchar(50) NOT NULL,
PhoneNumber char(11) NOT NULL,
EmergencyName nvarchar(50) NULL DEFAULT('Not specified'), --emerency name is the person to call in case something happens to you
EmergencyNumber char(11) NULL DEFAULT('Unknown!!!!'),
Notes varchar(MAX) NULL DEFAULT('Not included'),
CONSTRAINT CHK_PhoneNumber_Value_Length CHECK(LEN(PhoneNumber)=11),
constraint CHK_NumberOfEmergencyName CHECK(LEN(EmergencyNumber)=11)
)

--correcting a mistake in columns
ALTER TABLE Customers
DROP CONSTRAINT CHK_PhoneNumber_Value_Length 

ALTER TABLE Customers
DROP CONSTRAINT CHK_NumberOfEmergencyName


--Correcting phone number constraint it has to be 10 digits
ALTER TABLE Customers
ADD CONSTRAINT CHK_PhoneNumber_Value_Length CHECK(LEN(PhoneNumber)=10)

ALTER TABLE Customers
ADD CONSTRAINT CHK_NumberOfEmergencyName CHECK(LEN(EmergencyNumber)=10)



--CREATING TABLE ROOM STATUS 
CREATE TABLE RoomStatus(
RoomStatus varchar(50) PRIMARY KEY NOT NULL,
Notes varchar(MAX) NOT NULL
)

CREATE TABLE RoomTypes(
RoomType varchar(50) primary key not null,
Notes varchar(Max) NOT NULL
)

CREATE TABLE BedTypes(
BedType varchar(50) Primary key not null,
Notes varchar(MAX) NOT NULL
)

CREATE TABLE Rooms(
RoomNumber int primary key identity(100,1) not null,
RoomType varchar(50) NOT NULL,
BedType varchar(50) NOT NULL,
Rate DECIMAL(6,2) NOT NULL,
RoomStatus varchar(50) NOT NULL FOREIGN KEY REFERENCES RoomStatus(RoomStatus),
Notes varchar(MAX) NULL DEFAULT('NOT INCLUDED'),
CONSTRAINT CHK_Rate_IsNotBelowZero CHECK(Rate>0),
CONSTRAINT FK_RoomType_RoomTypes_RoomType FOREIGN KEY(RoomType) REFERENCES RoomTypes(RoomType),
Constraint FK_BedType_BedTypes_BedType FOREIGN KEY(BedType) REFERENCES BedTypes(BedType)
)

--INSERTING DATA 
--FIRST WE START WITH THE NONRELATIONAL TABLE
INSERT INTO EMployees(FirstName,LastName,Title)
	VALUES
		('Erich','Bochman','Assistant-manager'),
		('Santiago','Lopez','Head Chief'),
		('Enrico','Diego','Loby-Staff'),
		('David','Shmit','Room-Assigning Team'),
		('Stoyan','Jekov','Deputy-Bar-Assistant')

--Inserting into customers which is the second table with no relations in it
INSERT INTO Customers(FirstName,LastName,PhoneNumber,EmergencyName,EmergencyNumber)
	VALUES
		('Alehoi','Mandarinov','0692767816','Lidl Kauflandov','7894555234'),
		('Pumpkin','Head','0897777234','Halloween Man','1234111231'),
		('New ','Skelet','7777777777','Ravv','0897777132')

--Inserting into Room types
INSERT INTO RoomTypes(RoomType,Notes)
	VALUES
		('Single Room','Room for one'),
		('Two person room','room for two'),
		('prezident room','vip room'),
		('First-Class-Room','Even better than the president room')

--Inserting data for the room status
INSERT INTO RoomStatus(RoomStatus,Notes)
	VALUES
		('Very Bad','The room hasnt been maintaned since 5 months or more'),
		('Bad','The room hasnt been maintaned since 3 months'),
		('Good','The room has been maintaned 1 week ago and hasnt been touched since then'),
		('Very good','The room has been maintaned 2 days ago'),
		('Excellent','The room has been maintaned 30 minutes before your arrival')

--Inserting data for the bed types
INSERT INTO BedTypes
	VALUES
		('Basic bed','Basic hard matrace'),
		('Medium Bed','Flufy matrace bed'),
		('Water bed','Water based bed'),
		('Dormeo bed','dormeo product')

--Selecting tables which have relations to room to know what to insert (for my ease of use)
select * from RoomStatus
Select * from BedTypes
Select * from RoomTypes

--inserting into rooms
INSERT INTO Rooms(RoomType,BedType,Rate,RoomStatus,Notes)
	VALUES
		('First-Class-Room','Water bed',50,'Excellent',Null)

--check entered values
SELECT * FROM Rooms