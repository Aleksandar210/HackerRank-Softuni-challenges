--Querry used for BookShopDb
GO
CREATE DATABASE BookShopDb

GO
USE BookShopDb

GO
CREATE TABLE Authors(
AuthorId INT PRIMARY KEY IDENTITY NOT NULL,
FirstName NVARCHAR(40) NOT NULL,
LastName NVARCHAR(40) NOT NULL
)

GO
CREATE TABLE Categories(
CategoryId INT PRIMARY KEY IDENTITY NOT NULL,
CategoryName NVARCHAR(50) NOT NULL
)

GO
CREATE TABLE Books(
BookId INT PRIMARY KEY IDENTITY NOT NULL,
AgeRestriction varchar(30) CHECK(AgeRestriction IN ('Minor','Adult','Teen')),
AuthorId INT FOREIGN KEY REFERENCES Authors(AuthorId),
Copies INT NOT NULL,
ReleaseDate Datetime2 NULL,
Title NVARCHAR(50) NOT NULL,
[Description] NVARCHAR(1000) NOT NULL,
Price decimal(19,2) NOT NULL,
EditionType VARCHAR(30) CHECK(EditionType IN('Normal','Promo','Gold')),
)

GO
CREATE TABLE BookCategories(
CategoryId INT FOREIGN KEY REFERENCES Categories(CategoryId),
BookId INT FOREIGN KEY REFERENCES Books(BookId),
CONSTRAINT pk_CompositeBookCateogires PRIMARY KEY (CategoryId,BookId)
)