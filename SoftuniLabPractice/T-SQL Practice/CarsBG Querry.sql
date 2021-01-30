GO
CREATE DATABASE CarsBG

GO
USE CarsBG

GO
CREATE TABLE PrivateUser(
PrivateUserID INT PRIMARY KEY IDENTITY NOT NULL,
FirstName NVARCHAR(50) NOT NULL,
MiddleName NVARCHAR(50) NULL,
LastName NVARCHAR(50) NOT NULL,
PhoneNumber CHAR(10) NOT NULL,
Email VARCHAR(100) UNIQUE NOT NULL,
UserAddress NVARCHAR(100) NULL,
CONSTRAINT CHK_PhoneNumberLength CHECK(LEN(PhoneNumber)=10)
)

GO
ALTER TABLE PrivateUser
ADD CONSTRAINT DF_IsDeletedValue DEFAULT(0) FOR IsDeleted


GO
ALTER TABLE PrivateUser
ADD [Password] VARBINARY(500) NOT NULL

GO 
ALTER TABLE PrivateUser
ADD UserCity INT FOREIGN KEY REFERENCES Cities(CityID)

SELECT * FROM Cities

--Inserting private users
INSERT INTO PrivateUser(FirstName,MiddleName,LastName,PhoneNumber,Email,UserCity,UserAddress,[Password])
	VALUES
		--('Йордан','Найденов','Колев','1835717857','jordanKolev@gmail.com',1,'Витошка 156',HASHBYTES('SHA2_512', 'jordanKolevspassword'))
		(N'Йордан',N'Найденов',N'Колев','1835717857','jordanKolev@gmail.com',1,N'Витошка 156',HASHBYTES('SHA2_512', 'SamaraSquadAreLamers')),
		(N'Владимир',N'Каменов',N'Георгиев','1235417857','vladoeba4a@abv.bg',2,N'Марица 12',HASHBYTES('SHA2_512', 'VladimirPutinInTheQuerry:)')),
		(N'Страхил',N'Сашев',N'Атанасов','1434714844','Strah@gmail.com',4,N'Македония 156',HASHBYTES('SHA2_512', 'plovdivUniHasTheBestGirls')),
		(N'Кирил',N'Узунов',N'Байчков','2232257178','kirkata@gmail.com',3,N'Кербала 19',HASHBYTES('SHA2_512', 'VlubihSeVObshtakaNoTqsiImaGa4e')),
		(N'Боби',N'Живков',N'Шекеров','7737717777','Fasul4o@gmail.com',5,N'Аспарухова Градина 7',HASHBYTES('SHA2_512', 'nqmaDaDamToziFileNaJoro')),
		(N'Живко',N'Създателов',N'Базев','6865617867','bazata@gmail.com',6,N'Мадара 2000',HASHBYTES('SHA2_512', 'AK47CYMA<3'))
		

		--check entered so far
		SELECT * FROM PrivateUser

GO
CREATE TABLE Companies(
CompanyID INT PRIMARY KEY IDENTITY NOT NULL,
CompanyName NVARCHAR(100) NOT NULL CHECK(CompanyName LIKE('%_ЕТ') OR CompanyName LIKE('%_ООД') OR CompanyName LIKE('%_АД') OR CompanyName LIKE('%_ЕООД')),
CompanyNickname NVARCHAR(100),
OwnerFirstName NVARCHAR(50) NOT NULL,
OwnerMiddleName NVARCHAR(50) NOT NULL,
OnweLastName NVARCHAR(50) NOT NULL,
OwnerPhoneNumberRegistration CHAR(10) CHECK(LEN(OwnerPhoneNumberRegistration)=10),  --this is not for showing it is used for accaount activation
CompanyEmail VARCHAR(100) UNIQUE  NOT NULL,  --this is not for showing it is used to activate accaount on registration
CompanyInformation NVARCHAR(MAX) NULL DEFAULT('Not Included'), -- here the owner can include phone numbers emails and so on even media links
CompanyCity INT FOREIGN KEY REFERENCES Cities(CityID),
CompanyAddress NVARCHAR(100) NOT NULL,
Username VARCHAR(100) NOT NULL,
[Password] VARBINARY(500) NOT NULL,
)

ALTER TABLE Companies
DROP CONSTRAINT [CK__Companies__Compa__6A30C649]

ALTER TABLE Companies
ADD CONSTRAINT CHK_ComapnyNameSufix CHECK(CompanyName LIKE N'%ООД' OR CompanyName LIKE N'%ЕООД' OR CompanyName LIKE N'%АД' OR CompanyName LIKE N'%ЕТ')

GO
ALTER TABLE Companies
ADD IsDeleted BIT NULL DEFAULT(0)



SELECT * FROM Companies

--inserting into companies
INSERT INTO Companies(CompanyName,CompanyNickname,OwnerFirstname,OwnerMiddleName,OnweLastName,OwnerPhoneNumberRegistration,CompanyEmail,CompanyInformation,CompanyCity,CompanyAddress,Username,[Password])
	VALUES
		(N'Авто Вид ООД',N'АвтоВид',N'Станил',N'Стилиянов',N'Арменов','1895177810','avtoVid@dir.bg',N'0896754413 0898301313 0878281728  Околовръстен път Е773 66 (кв. Кольо Ганчев, до обръщалото на тролейбусите, Стара Загора',4,N'Околовръстен път Е773 66','KolataNaBosa155',HASHBYTES('SHA2_512', 'rpuBatkaNa2016')),
		(N'Мото Финанс АД',N'МотоФинанс',N'Стили',N'Димитров',N'Карнилов','2895177810','motoFinance@dir.bg',N'0895303009 Квартал Широк център,Мол Варна до Кауфланд',7,N'Квартал Широк център,Мол Варна до Кауфланд','PytnoPrevoznoJivotno',HASHBYTES('SHA2_512', 'zastavaiNa4ertata')),
		(N'Мари Транс 05 ЕООД',N'Мари Транс 05',N'Тихомир',N'Панайотов',N'Унаров','3895177810','mariaTransp@dir.bg',N'0898568418 Под СБА',10,N'Под СБА','Mangal4etoKeci',HASHBYTES('SHA2_512', '19tdiZASTAVAINA4ERTATA')),
		(N'АВТОБОРСА СБА ООД',N'СБА ЯМБОЛ',N'Галин',N'Модоров',N'Станимиров','4895177810','sbaJamb@dir.bg',N'0898553183 УЛ.ТЪРГОВСКА 95 ДО СГРАДАТА НА СБА. ДЕНОНОЩНА ПЪТНА',5,N'УЛ.ТЪРГОВСКА 95 ДО СГРАДАТА НА СБА. ДЕНОНОЩНА ПЪТНА','Maneken4eEbence',HASHBYTES('SHA2_512', 'mom4eZavsichkoDoriIzaDa')),
		(N'Ауто Слов ЕООД','Auto Slov',N'Петър',N'Иванов',N'Петров','5895177810','autoSlov@dir.bg',N'0893519208 0894603773 След КАТ Плевен . Срещу Жандармерията, Плевен
      виж на картата',3,N'След КАТ Плевен . Срещу Жандармерията','kokosaNaKokosaIliBosa',HASHBYTES('SHA2_512', 'ne slu6am4algaKo'))
		
		SELECT * FROM Companies

GO
CREATE TABLE VehicleOffers(
VehicleOfferID INT PRIMARY KEY IDENTITY NOT NULL,
[VehicleType] INT FOREIGN KEY REFERENCES VehicleTypes(VehicleTypeID),
Coupe INT FOREIGN KEY REFERENCES Coupes(CoupeID),
Brand INT FOREIGN KEY REFERENCES Brands(BrandID),
FuelType INT FOREIGN KEY REFERENCES FuelTypes(FuelTypeID),
Gears INT FOREIGN KEY REFERENCES Gears(GearID),
Price DECIMAL(8,2) NOT NULL CHECK(Price>=0),
[VehicleYearProduction] DATETIME2 NOT NULL CHECK([VehicleYearProduction]>='1970-01-01' AND YEAR([VehicleYearProduction])<YEAR(GETDATE())),
Color INT FOREIGN KEY REFERENCES Colors(ColorID),
NumberOfDoors TINYINT NOT NULL CHECK(NumberOfDoors>=2 AND NumberOfDoors<=4),
HorsePower SMALLINT NOT NULL CHECK(HorsePower>=0 AND HorsePower<=450)
)

SELECT * FROM VehicleTypes
SELECT * FROM Coupes
SELECT * FROM Brands
SELECT * FROM FuelTypes
SELECT * FROM Gears
SELECT * FROM Colors

--Inserting offers
INSERT INTO VehicleOffers(VehicleType,Coupe,Brand,FuelType,Gears,Price,VehicleYearProduction,Color,NumberOfDoors,HorsePower)
	VALUES
		(1,2,8,1,2,15000,'2001-05-20',2,4,140),
		(2,4,1,5,1,20000,'1993-01-01',2,4,200),
		(1,1,3,5,1,10000,'2005-02-10',2,4,170),
		(1,1,3,4,1,30000,'2004-03-16',2,4,300),
		(1,5,3,4,1,25000,'2009-4-15',2,4,340),
		(1,6,20,4,1,15000,'2015-04-21',2,4,250),
		(1,3,19,4,1,18000,'2019-05-01',2,4,270),
		(1,7,27,4,1,17000,'2019-01-01',2,4,300),
		(1,4,14,4,1,20000,'2018-09-12',2,4,240)



GO
CREATE TABLE Cities(
CityID INT PRIMARY KEY IDENTITY NOT NULL,
CityName NVARCHAR(50) NOT NULL
)

GO
--if I dont add N before the string literall the result is ???? in each column which is weird as the column is nvarchar and the literall is cirilic ?
INSERT INTO Cities(CityName)
	SELECT value FROM STRING_SPLIT(N'София Видин Велико-Търново Стара-Загора Пловдив Враца Варна Бургас Габрово Добрич Благоевград',' ')

	
GO
CREATE TABLE VehicleTypes(
VehicleTypeID INT PRIMARY KEY IDENTITY NOT NULL,
VehicleTypeName NVARCHAR(50) NOT NULL
)

GO
INSERT INTO VehicleTypes(VehicleTypeName)
	VALUES
		(N'Автомобили'),
		(N'Бусове'),
		(N'Лодки'),
		(N'Строителни'),
		(N'Селскостопански'),
		(N'Камиони'),
		(N'Каравани'),
		(N'Мотори')


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
CREATE TABLE Coupes(
CoupeID INT PRIMARY KEY IDENTITY NOT NULL,
CoupeTypeName NVARCHAR(50) NOT NULL
)

GO
INSERT INTO Coupes(CoupeTypeName)
	VALUES
		(N'Седан'),
		(N'Хечкбег'),
		(N'Комби'),
		(N'Купе'),
		(N'Кабрио'),
		(N'Джип'),
		(N'Пикап'),
		(N'Ван')

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

GO
CREATE TABLE Gears(
GearID INT PRIMARY KEY IDENTITY NOT NULL,
GearTypeName NVARCHAR(30)
)

INSERT INTO Gears(GearTypeName)
	VALUES
		(N'Ръчна'),
		(N'Автоматик')


--used for Hashing passwords
--HASHBYTES('SHA2_512', 'P@ssw0rd')


CREATE TABLE OffereeTypes(
OffereeID INT PRIMARY KEY IDENTITY NOT NULL,
OffereeTypeName VARCHAR(30),
)

INSERT INTO OffereeTypes(OffereeTypeName)
	VALUES
	('Company'),
	('PrivateUser')

GO
CREATE TABLE Offerees_VehicleOffers(
OffereeType INT FOREIGN KEY REFERENCES OffereeTypes(OffereeID),
OffereePrivateUserID INT FOREIGN KEY REFERENCES PrivateUser(PrivateuserID) NULL,
OffereeCompanyID INT FOREIGN KEY REFERENCES Companies(CompanyID) NULL,
VehicleOfferID INT FOREIGN KEY REFERENCES VehicleOffers(VehicleOfferID),
DateWhenOfferWasMade DATETIME2 NOT NULL,
IsOfferActive BIT NULL DEFAULT(1)    --1 yes its active / 0 no its nota ctive
)

ALTER Table Offerees_VehicleOffers
ADD CONSTRAINT UQ_OfferId Unique(VehicleOfferID)

SELECT * FROM OffereeTypes
SELECt * FROM PrivateUser
SELECT * FROM Companies
SELECT * FROM VehicleOffers

ALTER TABLE Offerees_VehicleOffers
ADD ID INT PRIMARY KEY IDENTITY NOT NULL

INSERT INTO Offerees_VehicleOffers(OffereeType,OffereePrivateUserID,OffereeCompanyID,VehicleOfferID,DateWhenOfferWasMade)
VALUES
	(1,Null,8,3,'2017-05-14'),
	(2,4,NULL,1,'2018-09-20'),
	(1,NULL,9,2,'2020-03-16'),
	(1,NULL,10,7,'2019-04-18'),
	(1,NULL,11,6,'2005-03-14'),
	(2,7,NULL,8,'2009-01-01'),
	(2,5,NULL,5,'2011-07-14'),
	(1,null,12,4,'2012-12-12')


--this table will be used to keep track of favored offers by all types of users
--this is a table that is for analysis as it keeps track of every offer being favored
--TO DO CHANGE OR NORMALISE IT REPEATS DATA WITH OFFERREES AND OFFERS JSUT USE THE ID FROM THAT TABLE
GO
CREATE TABLE Favorites(
ID INT PRIMARY KEY IDENTITY NOT NULL,
UserType INT FOREIGN KEY REFERENCES OffereeTypes(OffereeID),
PrivateUserID INT FOREIGN KEY REFERENCES PrivateUser(PrivateuserID) NULL,
CompanyID INT FOREIGN KEY REFERENCES Companies(CompanyID) NULL,
OfferID INT FOREIGN KEY REFERENCES Offerees_VehicleOffers(ID),
IsOfferStillFavored BIT NULL DEFAULT(1)    --1 yes its active / 0 no its nota ctive
)




--NOTES
--Inserts on this table have to be done with
--HASHBYTES('SHA2_512', 'P@ssw0rd') for the password

--Creating Triggers Functions and Procedures
GO
CREATE OR ALTER TRIGGER tr_SoftDeletePrivateUsers ON dbo.PrivateUser
  INSTEAD OF DELETE AS
BEGIN
UPDATE dbo.PrivateUser
  SET IsDeleted = 1
  WHERE PrivateUserID IN (SELECT PrivateUserID FROM deleted);
END


GO
CREATE OR ALTER TRIGGER tr_SoftDeleteCompanies ON dbo.Companies
  INSTEAD OF DELETE AS
BEGIN
UPDATE dbo.Companies
  SET IsDeleted = 1
  WHERE CompanyID IN (SELECT CompanyID FROM deleted);
END

--this function will get the offer time in (months, year or days) with the current date
GO
CREATE FUNCTION udf_GetOfferTimeElapsed(@TimeType VARCHAR(15),@OfferID INT)
RETURNS INT
AS
BEGIN

IF(@TimeType LIKE('Year'))
BEGIN 
RETURN DATEDIFF(year,GETDATE(),(SELECT DateWhenOfferWasMade FROM Offerees_VehicleOffers WHERE Offerees_VehicleOffers.ID = @OfferID))
END
ELSE IF (@TimeType LIKE ('Month'))
BEGIN
RETURN DATEDIFF(month,GETDATE(),(SELECT DateWhenOfferWasMade FROM Offerees_VehicleOffers WHERE Offerees_VehicleOffers.ID = @OfferID))
END
ELSE IF (@TimeType LIKE('Day'))
BEGIN
RETURN DATEDIFF(DAY,GETDATE(),(SELECT DateWhenOfferWasMade FROM Offerees_VehicleOffers WHERE Offerees_VehicleOffers.ID = @OfferID))
END

RETURN 0 

END

--procedure to show offers older in N months
GO
CREATE PROC usp_SelectOffersOlderThanSomeTimeType(@Number INT,@TimeType VARCHAR(15),@OffereeType VARCHAR(15))
AS
BEGIN
IF(@OffereeType LIKE('Company'))
BEGIN
SELECT OffereeTypes.OffereeTypeName AS [OffereeTypeName],Companies.CompanyName AS [CompanyName],VehicleOffers.Brand AS [BRAND],VehicleOffers.HorsePower AS[HorsePower],
VehicleOffers.Price AS [VehiclePrice],DateWhenOfferWasMade as [DateOfOffering],IsOfferActive AS [IsOfferStillActive]
FROM Offerees_VehicleOffers
JOIN VehicleOffers ON VehicleOffers.VehicleOfferID = Offerees_VehicleOffers.VehicleOfferID
JOIN Companies ON Companies.CompanyID = Offerees_VehicleOffers.OffereeCompanyID
JOIN OffereeTypes ON OffereeTypes.OffereeID = Offerees_VehicleOffers.OffereeType
WHERE dbo.udf_GetOfferTimeElapsed(@TimeType,ID) = @Number
END
ELSE IF(@OffereeType LIKE('PrivateUser'))
BEGIN
SELECT OffereeTypes.OffereeTypeName AS [OffereeTypeName],Concat_WS(' ',PrivateUser.FirstName,PrivateUser.MiddleName,PrivateUser.LastName) AS [UserFullName],VehicleOffers.Brand AS [BRAND],VehicleOffers.HorsePower AS[HorsePower],
VehicleOffers.Price AS [VehiclePrice],DateWhenOfferWasMade as [DateOfOffering],IsOfferActive AS [IsOfferStillActive]
FROM Offerees_VehicleOffers
JOIN VehicleOffers ON VehicleOffers.VehicleOfferID = Offerees_VehicleOffers.VehicleOfferID
JOIN PrivateUser ON PrivateUser.PrivateUserID = Offerees_VehicleOffers.OffereePrivateUserID
JOIN OffereeTypes ON OffereeTypes.OffereeID = Offerees_VehicleOffers.OffereeType
WHERE dbo.udf_GetOfferTimeElapsed(@TimeType,ID) = @Number
END


END

SELECT * FROM Offerees_VehicleOffers