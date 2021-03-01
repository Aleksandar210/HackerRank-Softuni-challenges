GO
CREATE DATABASE BioBakeryDb

GO
USE BioBakeryDb

GO
CREATE TABLE Countries(
CountryId INT PRIMARY KEY IDENTITY NOT NULL,
CountryName VARCHAR(50) UNIQUE NOT NULL
)

GO
CREATE TABLE Customers(
CustomerId INT PRIMARY KEY IDENTITY NOT NULL,
FirstName VARCHAR(25),
LastName VARCHAR(50),
Gender char(1) CHECK(Gender IN ('M','F','f','m')),
Age INT,
PhoneNumber char(10) CHECK(LEN(PhoneNumber)=10),
CountryId INT FOREIGN KEY REFERENCES Countries(CountryId)
)

GO
CREATE TABLE Products(
ProductId INT PRIMARY KEY IDENTITY NOT NULL,
ProductName VARCHAR(25) UNIQUE,
[Description] VARCHAR(250),
Recipe VARCHAR(MAX),
Price DECIMAL(19,2) CHECK(Price>=0)
)

GO
CREATE TABLE Feedbacks(
FeedbackId INT PRIMARY KEY IDENTITY NOT NULL,
[Description] VARCHAR(250),
Rate DECIMAL(1,1) CHECK(Rate>0 AND Rate<=11),
ProductId INT FOREIGN KEY REFERENCES Products(ProductId),
CustomerId INT FOREIGN KEY REFERENCES Customers(CustomerId)
)

GO
CREATE TABLE Distributors(
DistributorId INT Primary key IDENTITY NOT NULL,
DistributorName VARCHAR(25) UNIQUE,
AddressText VARCHAR(30),
Summary	VARCHAR(200),
CountryId INT FOREIGN KEY REFERENCES Countries(Countryid)
)

GO
CREATE TABLE Ingridients(
IngridientId INT PRIMARY KEY IDENTITY NOT NULL,
IngridientName VARCHAR(30) UNIQUE,
[Description] VARCHAR(200),
OriginCountryId INT FOREIGN KEY REFERENCES Countries(CountryId),
DistributorId INT FOREIGN KEY REFERENCES Distributors(DistributorId)
)

GO
CREATE TABLE ProductsIngridients(
ProductId INT FOREIGN KEY REFERENCES Products(ProductId),
IngridientId INT FOREIGN KEY REFERENCES Ingridients(IngridientId),
CONSTRAINT pk_CompositePrimaryKeyIngridProduct PRIMARY KEY(ProductId,IngridientId)
)
