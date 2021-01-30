--Querry used for mobile.de database project

GO
CREATE DATABASE MobileDe

GO
USE MobileDe

GO
CREATE TABLE [BasicUser](
BasicUserID INT PRIMARY KEY IDENTITY NOT NULL,
BasicUserEmail VARCHAR(50) NOT NULL,
BasicUserPassword VARCHAR(100),
BasicUserFirstName NVARCHAR(50) NOT NULL,
BasicUserMiddleName NVARCHAR(50) NOT NULL,
BasicUserLastName NVARCHAR(50) NOT NULL,
BasicUserDateOfRegistration DATETIME2 DEFAULT(GETDATE()),
IsDeleted BIT NOT NULL DEFAULT(0)
)
						   --Email             Password                 FirstName MiddleName LastName
EXEC usp_InsertIntoBasicUser 'Ruben@gmail.com','Ala-Dfae-fDkso_1411234',N'Рубен',N'Атанасов',N'Георгиев'
EXEC usp_InsertIntoBasicUser 'Ruben@gmail.com','Ala-Dfae-fDkso_1411234',N'Рубен',N'Атанасов',N'Георгиев'
EXEC usp_InsertIntoBasicUser 'Ruben@gmail.com','Ala-Dfae-fDkso_1411234',N'Рубен',N'Атанасов',N'Георгиев'
EXEC usp_InsertIntoBasicUser 'Ruben@gmail.com','Ala-Dfae-fDkso_1411234',N'Рубен',N'Атанасов',N'Георгиев'
EXEC usp_InsertIntoBasicUser 'Ruben@gmail.com','Ala-Dfae-fDkso_1411234',N'Рубен',N'Атанасов',N'Георгиев'
EXEC usp_InsertIntoBasicUser 'Ruben@gmail.com','Ala-Dfae-fDkso_1411234',N'Рубен',N'Атанасов',N'Георгиев'
EXEC usp_InsertIntoBasicUser 'Ruben@gmail.com','Ala-Dfae-fDkso_1411234',N'Рубен',N'Атанасов',N'Георгиев'



GO
CREATE TABLE DealerUsers(
DealerUsersID INT PRIMARY KEY IDENTITY NOT NULL,
DealerUserCompanyName VARCHAR(50) NOT NULL,
DealerUserUserName VARCHAR(50) NOT NULL,
DealerUserPassword VARCHAR(50) NOT NULL,
DealeruserEmail VARCHAR(50) NOT NULL,
StreetName VARCHAR(50) NOT NULL,
DateOfRegistry DATETIME2 DEFAULT(GETDATE()),
IsDeleted BIT DEFAULT(0)
)


EXEC usp_InsertIntoBDealerUserData 'CompanyNameCarSales', 'Atanas2100','afafFAF_2141','Atanas210@agf.com','faagaga'
EXEC usp_InsertIntoBDealerUserData 'CompanyNameCarSales', 'Atanas2100','afafFAF_2141','Atanas210@agf.com','faagaga'
EXEC usp_InsertIntoBDealerUserData 'CompanyNameCarSales', 'Atanas2100','afafFAF_2141','Atanas210@agf.com','faagaga'
EXEC usp_InsertIntoBDealerUserData 'CompanyNameCarSales', 'Atanas2100','afafFAF_2141','Atanas210@agf.com','faagaga'
EXEC usp_InsertIntoBDealerUserData 'CompanyNameCarSales', 'Atanas2100','afafFAF_2141','Atanas210@agf.com','faagaga'
EXEC usp_InsertIntoBDealerUserData 'CompanyNameCarSales', 'Atanas2100','afafFAF_2141','Atanas210@agf.com','faagaga'


GO
CREATE TABLE VehicleOffers(
VehicleOfferID INT PRIMARY KEY IDENTITY NOT NULL,
Brand INT FOREIGN KEY REFERENCES Brands(BrandID),
FuelType INT FOREIGN KEY REFERENCES FuelTypes(FuelTypeID),
Price DECIMAL(8,2) NOT NULL CHECK(Price>=0),
[VehicleYear] DATETIME2 NOT NULL CHECK([VehicleYear]>='1970-01-01' AND YEAR([VehicleYear])<YEAR(GETDATE())),
Color INT FOREIGN KEY REFERENCES Colors(ColorID),
HorsePower SMALLINT NOT NULL CHECK(HorsePower>=0 AND HorsePower<=450)
)


GO
CREATE TABLE Brands(
BrandID INT PRIMARY KEY IDENTITY NOT NULL,
BrandName NVARCHAR(50) NOT NULL
)

GO
INSERT INTO Brands(BrandName)
SELECT value FROM STRING_SPLIT('VW Mercedes-Benz Opel BMW Audi Peugeot Renault Ford Toyota Citreon Fiat Mazda Nissan Honda Seat Skoda Mitsubishi Hyundai Kia Subaru Suzuki Volvo Alfa-Romeo Chevrolet Land-Rover Dacia Jeep Lancia Mini Daihatsu Chrysler Smart Rover Porsche Daewoo Ssangyong Jaguar Saab Lexus Lada Infiniti Dodge Great-wall Isuzu Moskvich Tata Range-Rover UAZ Cadillac Tesla Trabant MG Bentley Lincoln Lamborghini DR Pontiac Volga Wartburg Maserati ВАЗ Mahindra Hummer Ferrari Zaz Iveco Haval Rolls-Royce GAZ Buick Zastava Aston-Martin Acura Piaggio Datsun McLaren GMC DS MAN Aro Yogomo Gac-Gonow Asia-Motoros Alpina Mayach Scion Microcar Barkas Oldsmobile Ligier Aixam Варшава Talbot Landwind Austin Triumph Proton Shuanhuan', ' ')

GO 
CREATE TABLE Colors(
ColorID INT PRIMARY KEY IDENTITY NOT NULL,
ColorName NVARCHAR(50)
)

GO
INSERT INTO Colors(ColorName)
SELECT value FROM STRING_SPLIT(N'Бежов Бордо Бронзов Бял Виолетов Жълт Зелен Златен Кафяв Оранжев Сив Син Сребърен Червен Черен Лилав Охра Перла Розов Хамелеон Светло-Зелен Светло-Син Светло-Сив Тъмно-Зелен Тъмно-Сив Тъмно-Син',' ')

GO 
CREATE TABLE FuelTypes(
FuelTypeID INT PRIMARY KEY IDENTITY NOT NULL,
FuelTypeName NVARCHAR(50) NOT NULL
)

INSERT INTO FuelTypes(FuelTypeName)
	VALUES	
		(N'Бензин'),
		(N'Дизел'),
		(N'Газ/Бензин'),
		(N'Метан/Бензин'),
		(N'Хибрид'),
		(N'Електричество')


CREATE TABLE UserTypes(
UserTypeID INT PRIMARY KEY IDENTITY NOT NULL,
UserTypeName VARCHAR(50) NOT NULL
)

INSERT INTO UserTypes(UserTypeName)
	VALUES
	('Basic User'),
	('Dealer User')

GO
CREATE TABLE Users_Offers(
UserType INT FOREIGN KEY REFERENCES UserTypes(UserTypeID),
OffereePrivateUserID INT FOREIGN KEY REFERENCES BasicUser(BasicUserID) NULL,
OffereeCompanyID INT FOREIGN KEY REFERENCES DealerUsers(DealerUsersID) NULL,
VehicleOfferID INT FOREIGN KEY REFERENCES VehicleOffers(VehicleOfferID),
DateWhenOfferWasMade DATETIME2 NOT NULL,
IsOfferActive BIT NULL DEFAULT(1)    --1 yes its active / 0 no its nota ctive
)





--Functions
GO
CREATE OR ALTER FUNCTION udf_CountSpecialForbideCharactersInVarchar(@PasswordEnteredByUser VARCHAR(50))
RETURNS TINYINT
BEGIN

DECLARE @CountSpecialForbidenCharacters INT
SET @CountSpecialForbidenCharacters = 
(SELECT COUNT(*) FROM
(SELECT VALUE FROM STRING_SPLIT(TRIM(dbo.udf_CreatePasswordWithSeparatorsFromEnteredPassword('Ala-Dfae-fDkso_1411234')),' ')
WHERE VALUE NOT LIKE('[0-9]') AND VALUE NOT LIKE('[A-Z]') AND VALUE !='-' AND VALUE !='_') as table1)

RETURN @CountSpecialForbidenCharacters
END


GO
CREATE OR ALTER FUNCTION udf_CountIntegersCharactersInVarchar(@PasswordEnteredByUser VARCHAR(50))
RETURNS TINYINT
BEGIN

DECLARE @CountIntegers INT
SET @CountIntegers = 
(SELECT COUNT(*) FROM
(SELECT VALUE FROM STRING_SPLIT(TRIM(dbo.udf_CreatePasswordWithSeparatorsFromEnteredPassword(@PasswordEnteredByUser)),' ')
WHERE VALUE LIKE('[0-9]') ) as table1)

RETURN @CountIntegers
END


GO
CREATE OR ALTER FUNCTION udf_CountUpperCases(@PasswordEnteredByUser VARCHAR(50))
RETURNS TINYINT
BEGIN

DECLARE @CountUpperCases INT
SET @CountUppercases = 
(SELECT COUNT(*) FROM
(SELECT VALUE FROM STRING_SPLIT(TRIM(dbo.udf_CreatePasswordWithSeparatorsFromEnteredPassword(@PasswordEnteredByUser)),' ')
WHERE VALUE !=LOWER(VALUE) COLLATE Latin1_General_CS_AI ) as table1)

RETURN @CountUpperCases
END


GO
CREATE OR ALTER FUNCTION udf_CountUpperCases(@PasswordEnteredByUser VARCHAR(50))
RETURNS TINYINT
BEGIN

DECLARE @CountUpperCases INT
SET @CountUppercases = 
(SELECT COUNT(*) FROM
(SELECT VALUE FROM STRING_SPLIT(TRIM(dbo.udf_CreatePasswordWithSeparatorsFromEnteredPassword(@PasswordEnteredByUser)),' ')
WHERE VALUE !=LOWER(VALUE) COLLATE Latin1_General_CS_AI ) as table1)

RETURN @CountUpperCases
END

GO
CREATE OR ALTER FUNCTION udf_CountLowerCases(@PasswordEnteredByUser VARCHAR(50))
RETURNS TINYINT
BEGIN

DECLARE @CountLowerCases INT
SET @CountLowerCases = 
(SELECT COUNT(*) FROM
(SELECT VALUE FROM STRING_SPLIT(TRIM(dbo.udf_CreatePasswordWithSeparatorsFromEnteredPassword(@PasswordEnteredByUser)),' ')
WHERE VALUE !=UPPER(VALUE) COLLATE Latin1_General_CS_AI ) as table1)

RETURN @CountLowerCases
END


--this function takes a varchar as a paramater and creates a new varchar where it has space between each character
GO
CREATE OR ALTER FUNCTION udf_CreatePasswordWithSeparatorsFromEnteredPassword(@EnteredPassword VARCHAR(50))
RETURNS VARCHAR(50)
BEGIN

DECLARE @ReworkedPassword VARCHAR(50)
SET @ReworkedPassword =''


DECLARE @IndexInLoop INT
SET @IndexInLoop = 1;

DECLARE @EndPointNumber INT 
SET @EndPointNumber = LEN(@EnteredPassword)



WHILE @IndexInLoop<=@EndPointNumber 
BEGIN
SET @ReworkedPassword = @ReworkedPassword+ (SELECT SUBSTRING(@EnteredPassword,@IndexInLoop,1))+' '
SET @IndexInLoop = @IndexInLoop+1;

END;

RETURN @ReworkedPassword
END

--experiment
SELECT dbo.udf_CreatePasswordWithSeparatorsFromEnteredPassword('afafafafaf')


--SELECT * FROM BasicUser


--Procedures
GO
CREATE or alter PROC usp_InsertIntoBasicUser(@BasicUserEmail VARCHAR(50),@BasicUserPassword VARCHAR(50),@BasicUserFirstName VARCHAR(50), @BasicUserMiddleName VARCHAR(50),
@BasicUserLastName VARCHAR(50))
AS

IF(dbo.udf_CountSpecialForbideCharactersInVarchar(@BasicUserPassword)=0 AND dbo.udf_CountIntegersCharactersInVarchar(@BasicUserPassword)>=1
AND dbo.udf_CountLowerCases(@BasicUserPassword)>=1 AND dbo.udf_CountUpperCases(@BasicUserPassword)>=1 AND (@BasicUserPassword LIKE('%_%') OR @BasicUserPassword LIKE('%-%') ))
BEGIN
INSERT INTO BasicUser(BasicUserEmail,BasicUserPassword,BasicUserFirstName,BasicUserMiddleName,BasicUserLastName)
VALUES
	(@BasicUserEmail,HASHBYTES('SHA2_512', @BasicUserPassword),@BasicUserFirstName,@BasicUserMiddleName,@BasicUserLastName)
END
ELSE
BEGIN
PRINT('Did not execute due to incorrect password format. Password must contain (- or _,1 lowercase,1uppercase and numbers)')
END

SELECT * FROM DealerUsers

GO
CREATE or alter PROC usp_InsertIntoBDealerUserData(@DealeruserCompany VARCHAR(50), @DealeruserUsername VARCHAR(50), @DealerUserPassword VARCHAR(50),
@DealerUserEmail VARCHAR(50),@Streetname VARCHAR(50))
AS

IF(dbo.udf_CountSpecialForbideCharactersInVarchar(@DealerUserPassword)=0 AND dbo.udf_CountIntegersCharactersInVarchar(@DealerUserPassword)>=1
AND dbo.udf_CountLowerCases(@DealerUserPassword)>=1 AND dbo.udf_CountUpperCases(@DealerUserPassword)>=1 AND (@DealerUserPassword LIKE('%_%') OR @DealerUserPassword LIKE('%-%') ))
BEGIN
INSERT INTO DealerUsers(DealerUserCompanyName,DealerUserUserName,DealerUserPassword,DealeruserEmail,StreetName)
VALUES
	(@DealeruserCompany,@DealeruserUsername,HASHBYTES('SHA2_256',@DealerUserPassword),@DealerUserEmail,@Streetname)
END
ELSE
BEGIN
PRINT('Did not execute due to incorrect password format. Password must contain (- or _,1 lowercase,1uppercase and numbers)')
END



SELECT * FROM DealerUsers


TRUNCATE TABLE DealerUsers
DROP TABLE DealerUsers


--ТРИГЕРИ
GO
CREATE OR ALTER TRIGGER tr_SoftDeleteCompanies ON dbo.DealerUsers
  INSTEAD OF DELETE AS
BEGIN
UPDATE dbo.DealerUsers
  SET IsDeleted = 1
  WHERE DealerUsersID IN (SELECT DealerUsersID FROM deleted);
END


GO
CREATE OR ALTER TRIGGER tr_SoftDeleteBasicUsers ON dbo.BasicUser
  INSTEAD OF DELETE AS
BEGIN
UPDATE dbo.BasicUser
  SET IsDeleted = 1
  WHERE BasicUserID IN (SELECT BasicUserID FROM deleted);
END










--Experiment
/*
GO
DECLARE @CountSpecialForbidenCharacters INT
SET @CountSpecialForbidenCharacters = 
(SELECT COUNT(*) FROM
(SELECT VALUE FROM STRING_SPLIT(TRIM(dbo.udf_CreatePasswordWithSeparatorsFromEnteredPassword('$@afD123a_@!!')),' ')
WHERE VALUE != LOWER(VALUE)COLLATE Latin1_General_CS_AI)  as table1)


PRINT @CountSpecialForbidenCharacters

IF('AFAAF' LIKE('%_%'))
PRINT('YES')
*/