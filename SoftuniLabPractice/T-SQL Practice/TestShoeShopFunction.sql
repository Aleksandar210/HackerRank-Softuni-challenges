GO
CREATE DATABASE ShoeOnlineStore

GO
USE ShoeOnlineStore

CREATE TABLE Roles(
ID INT IDENTITY(1,1) PRIMARY KEY,
Name NVARCHAR(255) NOT NULL UNIQUE
);

CREATE TABLE Color(
ID INT IDENTITY(1,1) PRIMARY KEY,
Name NVARCHAR(255) NOT NULL UNIQUE
);

CREATE TABLE Brand(
ID INT IDENTITY(1,1) PRIMARY KEY,
Name NVARCHAR(255) NOT NULL UNIQUE
);

INSERT INTO Brand(Name)  Values ('Adidas');
INSERT INTO Brand(Name)  Values ('Nike');
INSERT INTO Brand(Name)  Values ('Reebok');


INSERT INTO Brand(Name)  Values ('Asics');

INSERT INTO Brand(Name)  Values ('Puma');

INSERT INTO Brand(Name)  Values ('Gucci');




INSERT INTO Roles (Name) VALUES ('Admin');

INSERT INTO Roles (Name) VALUES ('User');

INSERT INTO Roles (Name) VALUES ('User');


INSERT INTO Color (Name) VALUES ('Red');
INSERT INTO Color (Name) VALUES ('Blue');
INSERT INTO Color (Name) VALUES ('Green');
INSERT INTO Color (Name) VALUES ('Orange');
INSERT INTO Color (Name) VALUES ('Yellow');
INSERT INTO Color (Name) VALUES ('Pink');
INSERT INTO Color (Name) VALUES ('Purple');


CREATE TABLE Users(
ID INT IDENTITY(1,1) PRIMARY KEY,
FName NVARCHAR(255) NOT NULL,
LName NVARCHAR(255) NOT NULL,
Username NVARCHAR(255) NOT NULL UNIQUE,
Password NVARCHAR(255) NOT NULL,
Email NVARCHAR(255) NOT NULL UNIQUE,
Phone_Number NVARCHAR(255) NOT NULL UNIQUE,
DateOfBirth DATE NOT NULL,
RegistrationDate DATE NOT NULL,
Gender NVARCHAR(255) NOT NULL,
Country NVARCHAR(255) NOT NULL,
Post_code INT NOT NULL,
Question NVARCHAR(255) NOT NULL,
Answer NVARCHAR(255) NOT NULL,
RoleID INT FOREIGN KEY REFERENCES Roles(ID) NOT NULL
);


CREATE TABLE Shoes (
ID INT IDENTITY(1,1) PRIMARY KEY,
Name NVARCHAR(255) NOT NULL,
Gender NVARCHAR(255) NOT NULL,
ShoeSize DECIMAL(3,1) NOT NULL,
Price DECIMAL(5,2) NOT NULL,
ColorID INT FOREIGN KEY REFERENCES Color(ID) NOT NULL,
BrandID INT FOREIGN KEY REFERENCES Brand(ID) NOT NULL
);

CREATE TABLE Orders (
ID INT IDENTITY(1,1) PRIMARY KEY,
UserID INT FOREIGN KEY REFERENCES Users(ID) NOT NULL,
ShoeID INT FOREIGN KEY REFERENCES Shoes(ID) NOT NULL
)

GO
CREATE PROCEDURE AddUser(
    @FName as NVARCHAR(255),
    @LName as NVARCHAR(255),
    @Username as NVARCHAR(255),
    @Password as NVARCHAR(255) = '123456',
    @Email as NVARCHAR(255),
    @Phone_Number as NVARCHAR(255),
    @DateOfBirth as DATE = '1999-12-29',
    @Gender as NVARCHAR(255) = 'male',
    @Country as NVARCHAR(255) = 'Bulgaria',
    @Post_code as INT = 6300,
    @Question as NVARCHAR(255) = 'Favorite song?',
    @Answer as NVARCHAR(255) = 'Never Gonna Give You Up.',
    @RoleID as INT = 2
    )
AS
BEGIN
    INSERT INTO Users(FName, LName, Username, Password, Email, Phone_Number, DateOfBirth, RegistrationDate, Gender, Country, Post_code, Question, Answer, RoleID)
    VALUES(@FName, @LName, @Username, @Password, @Email, @Phone_Number, @DateOfBirth, GETDATE(), @Gender, @Country, @Post_code, @Question, @Answer, @RoleID);
END;


EXEC AddUser
    @FName = 'Atanas',
    @LName = 'Naydev',
    @Username = 'nasetobaby',
    @Email = 'nasetbaby@gmail.com',
    @Phone_Number = '00000',
    @RoleID = 1;
	
EXEC AddUser
    @FName = 'Petko',
    @LName = 'Petkov',
    @Username = 'petkopetkov',
    @Email = 'petkopetkov@gmail.com',
    @Phone_Number = '00001';
	
	
EXEC AddUser
    @FName = 'Niki',
    @LName = 'Andreev',
    @Username = 'nikiandreev',
    @Email = 'nikiandrew@gmail.com',
    @Phone_Number = '00002';
	
EXEC AddUser
    @FName = 'Polina',
    @LName = 'Petrova',
    @Username = 'polinapetrowa',
    @Email = 'polinapetrowa@gmail.com',
    @Phone_Number = '00003';
	
EXEC AddUser
    @FName = 'Spas',
    @LName = 'Spasimirov',
    @Username = 'SpasSpasimirov',
    @Email = 'spasspasimirov@gmail.com',
    @Phone_Number = '00004';

EXEC AddUser
    @FName = 'Angel',
    @LName = 'Angelov',
    @Username = 'AngelAngelov',
    @Email = 'angelangelov@gmail.com',
    @Phone_Number = '00005'; 
	
EXEC AddUser
    @FName = 'Boiko',
    @LName = 'Borisov',
    @Username = 'BoikoBorisov',
    @Email = 'boikoborisov@gmail.com',
    @Phone_Number = '00006';  

EXEC AddUser
    @FName = 'Rumen',
    @LName = 'Radev',
    @Username = 'RumenRadev',
    @Email = 'rumenradev@gmail.com',
    @Phone_Number = '00007';   

EXEC AddUser
    @FName = 'Korneliq',
    @LName = 'Ninova',
    @Username = 'KorneliqNinova',
    @Email = 'korneliqninova@gmail.com',
    @Phone_Number = '00008'; 
	
EXEC AddUser
    @FName = 'Ahmed',
    @LName = 'Dogan',
    @Username = 'AhmedDogan',
    @Email = 'ahmeddogan@gmail.com',
    @Phone_Number = '00009'; 

	
EXEC AddUser
    @FName = 'Peicho',
    @LName = 'Peichev',
    @Username = 'PeichoPeichev',
    @Email = 'peichopeichev@gmail.com',
    @Phone_Number = '00010';
EXEC AddUser
    @FName = 'User',
    @LName = 'Userov',
    @Username = 'UserUserov',
    @Email = 'useruserov@gmail.com',
    @Phone_Number = '00011';    	
		
	
	GO
	CREATE PROCEDURE AddShoes(
    @Name as NVARCHAR(255),
    @Gender as NVARCHAR(255) = 'male',
    @ShoeSize DECIMAL(3,1),
    @Price DECIMAL(5,2),
    @ColorID as INT = 1,
    @BrandID as INT = 1
    )
AS
BEGIN
    INSERT INTO Shoes(Name, Gender, ShoeSize,  Price, ColorID, BrandID)
    VALUES(@Name, @Gender,  @ShoeSize,  @Price, @ColorID, @BrandID);
END;


EXEC AddShoes
	@Name='PW ULTRABOOST DNA',
	@Gender='male',
	@ShoeSize=44,
	@Price=180,
	@ColorID=8,
	@BrandId=1;
	

EXEC AddShoes
	@Name='KANSAS JAYHAWKS ULTRABOOST 1.0 DNA SHOES',
	@Gender='male',
	@ShoeSize=42,
	@Price=180,
	@ColorID=2,
	@BrandId=1;	
	
EXEC AddShoes
	@Name='SWIFT RUN X SHOES',
	@Gender='unisex',
	@ShoeSize=43,
	@Price=140,
	@ColorID=9,
	@BrandId=1;	
   
EXEC AddShoes
	@Name='ULTRABOOST 20 SHOES',
	@Gender='male',
	@ShoeSize=41,
	@Price=120,
	@ColorID=1,
	@BrandId=1;	
	
	
EXEC AddShoes
	@Name='OZWEEGO SHOES',
	@Gender='male',
	@ShoeSize=41.3,
	@Price=100,
	@ColorID=4,
	@BrandId=1;	
	
	
	
		
EXEC AddShoes
	@Name='GEL-NIMBUS 23 ',
	@Gender='male',
	@ShoeSize=41.3,
	@Price=155,
	@ColorID=5,
	@BrandId=3;	
		
EXEC AddShoes
	@Name='GT-2000 9 ',
	@Gender='male',
	@ShoeSize=39,
	@Price=120,
	@ColorID=2,
	@BrandId=3;	
		
EXEC AddShoes
	@Name='GEL-KAYANO 27',
	@Gender='male',
	@ShoeSize=39,
	@Price=155,
	@ColorID=4,
	@BrandId=3;	
		
EXEC AddShoes
	@Name='GEL-CUMULUS 22',
	@Gender='female',
	@ShoeSize=38,
	@Price=120,
	@ColorID=3,
	@BrandId=3;	
		
EXEC AddShoes
	@Name='GEL-CUMULUS 22 G-TX',
	@Gender='male',
	@ShoeSize=42.4,
	@Price=130,
	@ColorID=8,
	@BrandId=3;
		
EXEC AddShoes
	@Name='GEL-NIMBUS 23',
	@Gender='male',
	@ShoeSize=44.4,
	@Price=155,
	@ColorID=6,
	@BrandId=3;	
		
EXEC AddShoes
	@Name='Air Jordan XXXV "Sisterhood"',
	@Gender='male',
	@ShoeSize=42.4,
	@Price=180,
	@ColorID=9,
	@BrandId=2;	
		
EXEC AddShoes
	@Name='Nike Air Max 1',
	@Gender='male',
	@ShoeSize=42.4,
	@Price=140,
	@ColorID=9,
	@BrandId=2;	
		
EXEC AddShoes
	@Name='Nike Blazer Mid 77 Suede',
	@Gender='male',
	@ShoeSize=43,
	@Price=100,
	@ColorID=1,
	@BrandId=2;	
		
EXEC AddShoes
	@Name='RS-X Mid Sneakers',
	@Gender='male',
	@ShoeSize=44,
	@Price=120,
	@ColorID=8,
	@BrandId=4;	
		
EXEC AddShoes
	@Name='RS-X³ X-Mas Edition Mens Sneakers',
	@Gender='male',
	@ShoeSize=41,
	@Price=110,
	@ColorID=8,
	@BrandId=4;	
		
EXEC AddShoes
	@Name='RS-Curve Night Ice Womens Sneakers',
	@Gender='female',
	@ShoeSize=38,
	@Price=100,
	@ColorID=8,
	@BrandId=4;	
		
EXEC AddShoes
	@Name='Cali Wedge Womens Sneakers',
	@Gender='female',
	@ShoeSize=37.5,
	@Price=90,
	@ColorID=8,
	@BrandId=4;	
		
EXEC AddShoes
	@Name='Speedcat OG Sparco Womens Sneakers',
	@Gender='female',
	@ShoeSize=36.6,
	@Price=90,
	@ColorID=1,
	@BrandId=4
	
		
EXEC AddShoes
	@Name='Mens GG Rhyton sneaker',
	@Gender='female',
	@ShoeSize=42,
	@Price=790,
	@ColorID=4,
	@BrandId=5;	
	
		
EXEC AddShoes
	@Name='Mens Disney x Gucci Donald Duck Rhyton sneaker',
	@Gender='male',
	@ShoeSize=44,
	@Price=890,
	@ColorID=3,
	@BrandId=5;	
		
EXEC AddShoes
	@Name='Mens lace-up shoe with Double G',
	@Gender='male',
	@ShoeSize=43,
	@Price=720,
	@ColorID=6,
	@BrandId=5;	
		
EXEC AddShoes
	@Name='Womens matelassé Chelsea boot',
	@Gender='female',
	@ShoeSize=39,
	@Price=890,
	@ColorID=8,
	@BrandId=5;	
		
EXEC AddShoes
	@Name='Womens boot with Interlocking G',
	@Gender='female',
	@ShoeSize=38,
	@Price=990,
	@ColorID=8,
	@BrandId=5;	
		
EXEC AddShoes
	@Name='Leather ankle boot with Sylvie Web',
	@Gender='female',
	@ShoeSize=37,
	@Price=980,
	@ColorID=8,
	@BrandId=5;	

	--This QUERRY IS TO TEST THIS FUNC
GO
CREATE FUNCTION GetNumberOrdersPerBrandsMade(@BrandID INT)
RETURNS INT
BEGIN

DECLARE @NumberOrdersOfGivenBrand INT

SET @NumberOrdersOfGivenBrand = 
(SELECT COUNT(*) FROM
(
SELECT Shoes.Name AS [Shoe Name],Shoes.Gender AS [Shoe Gender], Shoes.Price as [Shoes Price],Shoes.BrandID AS [BrandIDShoe]
FROM Orders
RIGHT OUTER JOIN Shoes ON Shoes.ID = Orders.ShoeID
) as table1
WHERE BrandIDShoe = @BrandID
)

RETURN @NumberOrdersOfGivenBrand
END


