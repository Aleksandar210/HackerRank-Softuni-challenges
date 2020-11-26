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

ALTER TABLE PrivateUser
ADD IsDeleted BIT NULL DEFAULT(1)

GO
CREATE TABLE Companies(
CompanyID INT PRIMARY KEY IDENTITY NOT NULL,
CompanyName NVARCHAR(100) NOT NULL CHECK(CompanyName LIKE('%_ЕТ') OR CompanyName LIKE('%_ООД') OR CompanyName LIKE('%_АД') OR CompanyName LIKE('%_ЕООД')),
CompanyNickname NVARCHAR(100),
OwnerFirstName NVARCHAR(50) NOT NULL,
OwnerMiddleName NVARCHAR(50) NOT NULL,
OnweLastName NVARCHAR(50) NOT NULL,
OwnerPhoneNumberRegistration CHAR(10) CHECK(LEN(OwnerPhoneNumberRegistration)=10),
CompanyEmail VARCHAR(100) UNIQUE  NOT NULL,
CompanyInformation NVARCHAR(MAX) NULL DEFAULT('Not Included'),
CompanyCity INT FOREIGN KEY REFERENCES Cities(CityID),
CompanyAddress NVARCHAR(100) NOT NULL,
Username VARCHAR(100) NOT NULL,
[Password] VARBINARY(500) NOT NULL,
)

ALTER TABLE Companies
ADD IsDeleted BIT NULL DEFAULT(1)

--Inserts on this table have to be done with
--HASHBYTES('SHA2_512', 'P@ssw0rd') for the password

--TO DO NORMALIZE DATA
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

--Normalizing the above data
CREATE TABLE Cities(
CityID INT PRIMARY KEY IDENTITY NOT NULL,
CityName NVARCHAR(50) NOT NULL
)

--if I dont add N before the string literall the result is ???? in each column which is weird as the column is nvarchar and the literall is cirilic ?
INSERT INTO Cities(CityName)
	SELECT value FROM STRING_SPLIT(N'София Видин Велико-Търново Стара-Загора Пловдив Враца Варна Бургас Габрово Добрич Благоевград',' ')

	

CREATE TABLE VehicleTypes(
VehicleTypeID INT PRIMARY KEY IDENTITY NOT NULL,
VehicleTypeName NVARCHAR(50) NOT NULL
)



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

		TRUNCATE TABLE VehicleTypes
		SELECT * FROM VehicleTypes


--TO DO VERIFY THAT IT WORKS ON TEST
GO
CREATE TABLE Brands(
BrandID INT PRIMARY KEY IDENTITY NOT NULL,
BrandName NVARCHAR(50) NOT NULL
)

INSERT INTO Brands(BrandName)
SELECT value FROM STRING_SPLIT('VW Mercedes-Benz Opel BMW Audi Peugeot Renault Ford Toyota Citreon Fiat Mazda Nissan Honda Seat Skoda Mitsubishi Hyundai Kia Subaru Suzuki Volvo Alfa-Romeo Chevrolet Land-Rover Dacia Jeep Lancia Mini Daihatsu Chrysler Smart Rover Porsche Daewoo Ssangyong Jaguar Saab Lexus Lada Infiniti Dodge Great-wall Isuzu Moskvich Tata Range-Rover UAZ Cadillac Tesla Trabant MG Bentley Lincoln Lamborghini DR Pontiac Volga Wartburg Maserati ВАЗ Mahindra Hummer Ferrari Zaz Iveco Haval Rolls-Royce GAZ Buick Zastava Aston-Martin Acura Piaggio Datsun McLaren GMC DS MAN Aro Yogomo Gac-Gonow Asia-Motoros Alpina Mayach Scion Microcar Barkas Oldsmobile Ligier Aixam Варшава Talbot Landwind Austin Triumph Proton Shuanhuan', ' ')



GO 
CREATE TABLE Colors(
ColorID INT PRIMARY KEY IDENTITY NOT NULL,
ColorName NVARCHAR(50)
)

INSERT INTO Colors(ColorName)
SELECT value FROM STRING_SPLIT(N'Бежов Бордо Бронзов Бял Виолетов Жълт Зелен Златен Кафяв Оранжев Сив Син Сребърен Червен Черен Лилав Охра Перла Розов Хамелеон Светло-Зелен Светло-Син Светло-Сив Тъмно-Зелен Тъмно-Сив Тъмно-Син',' ')


GO
CREATE TABLE Coupes(
CoupeID INT PRIMARY KEY IDENTITY NOT NULL,
CoupeTypeName NVARCHAR(50) NOT NULL
)


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


--Creating Triggers Functions and Procedures





























--TO DO USE FOR TRIGGER LATER
--I tried to use the function as a constraint but it turned out that this isnt allowed so i will use it in a trigger when adding something new
--the trigger will be used on inserts and it will remove the records that do not have a valid email
GO
CREATE or ALTER FUNCTION udf_ChekIfEmailIsValid(@EMAIL varchar(100))RETURNS bit as
BEGIN     
  DECLARE @bitEmailVal as Bit
  DECLARE @EmailText varchar(100)

  SET @EmailText=ltrim(rtrim(isnull(@EMAIL,'')))

  SET @bitEmailVal = case when @EmailText = '' then 0
                          when @EmailText like '% %' then 0
                          when @EmailText like ('%["(),:;<>\]%') then 0
                          when substring(@EmailText,charindex('@',@EmailText),len(@EmailText)) like ('%[!#$%&*+/=?^`_{|]%') then 0
                          when (left(@EmailText,1) like ('[-_.+]') or right(@EmailText,1) like ('[-_.+]')) then 0                                                                                    
                          when (@EmailText like '%[%' or @EmailText like '%]%') then 0
                          when @EmailText LIKE '%@%@%' then 0
                          when @EmailText NOT LIKE '_%@_%._%' then 0
                          else 1 
                      end
  RETURN @bitEmailVal
END 



