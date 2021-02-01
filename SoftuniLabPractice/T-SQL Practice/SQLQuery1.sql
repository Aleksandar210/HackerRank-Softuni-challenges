
--Random between 1 and 50
SELECT FLOOR(RAND()*(50-1)+1)

GO
CREATE DATABASE MinionsDB
GO
USE MinionsDB


--Creation Phase
GO
CREATE TABLE EvilnessFactors(
Id INT PRIMARY KEY IDENTITY NOT NULL,
FactorName VARCHAR(50) NOT NULL,
IsDeleted BIT DEFAULT(0)
)

GO
CREATE TABLE Villains(
Id INT PRIMARY KEY IDENTITY NOT NULL,
[Name] NVARCHAR(50) NOT NULL,
EvilnessFactorID INT NOT NULL FOREIGN KEY REFERENCES EvilnessFactors(Id)
)

GO
CREATE TABLE Countries(
CountryCode INT PRIMARY KEY IDENTITY NOT NULL,
CountryName NVARCHAR(50) NOT NULL,
IsDeleted BIT DEFAULT(0)
)

GO
CREATE TABLE Towns(
Id INT PRIMARY KEY IDENTITY NOT NULL,
TownName NVARCHAR(100),
CountryCode INT FOREIGN KEY REFERENCES Countries(CountryCode),
IsDeleted BIT DEFAULT(0)

)

GO
CREATE TABLE Minions(
Id INT PRIMARY KEY IDENTITY NOT NULL,
[Name] NVARCHAR(50) NOT NULL,
Age INT  DEFAULT(20),
IsDeleted BIT DEFAULT 0,
TownId INT NOT NULL FOREIGN KEY REFERENCES Towns(Id),
CONSTRAINT chk_MinionAge CHECK(Age>5)
)

GO
CREATE TABLE MinionsVillains(
MinionID INT NOT NULL FOREIGN KEY REFERENCES Minions(Id),
VillainID INT NOT NULL FOREIGN KEY REFERENCES Villains(Id)
)


--Insert Phase in SQL SERVER
INSERT INTO EvilnessFactors([FactorName])
	VALUES
		('Bad kid'),
		('Wreckless Teen'),
		('Small time hooligan'),
		('Disaster of a kid'),
		('Bad guy'),
		('Problematic bad guy'),
		('Fresh Criminal'),
		('Criminal'),
		('Regular-Criminal'),
		('Serious-Threat'),
		('Evil guy'),
		('Pure Villain on spree'),
		('From Hell With Love'),
		('Terrorist')

INSERT INTO EvilnessFactors([FactorName])
	VALUES
		('evil')

		--continue the rest with Ado.NET

		SELECT * FROM EvilnessFactors

INSERT INTO Countries(CountryName)
SELECT value  FROM
STRING_SPLIT(N'
Австрия,Албания,Андора,Беларус,Белгия,Босна и Херцеговина,България,Ватикана,Великобритания,Германия,Грузия,Гърция,Дания,Естония,Ирландия,Исландия,Испания,Италия,Кайманови острови,Кипър,Латвия,Литва,Лихтенщайн,Люксембург,Македония,Малта,Молдова,Монако,Норвегия,Полша,Португалия,Румъния,Русия,Сан Марино,Словакия,Словения,Сърбия,Турция,Украйна,Унгария,Финландия,Франция,Френска Полинезия,Холандия,Хърватия,Черна гора,Чехия,Швейцария,Швеция,Шотландия
', ',')

SELECT * FROM Countries

--INSERT TOWNS IN Ukrane only
INSERT INTO Towns(TownName,CountryCode)
SELECT value,(SELECT CountryCode FROM Countries WHERE CountryName LIKE N'Украйна') as ukranecode
FROM STRING_SPLIT(N'Balin,
Plove,
Priluzhnoye,
Novokorbovka Vtoraya,
Lapshin,
Druzhkovka,
Bolshaya Kondratovka,
Borysivka,
Matroska,
Smosh,
Velikaya Ofirno,
Малі Загірці,
Zaderakovka,
Khorokhorin,
Nadorozhnaya,
Ugly-Zavod,
Syagrov,
Севастянівка,
Курне,
Криски,
Woloczkowce,
Yezhachiy,
Стримба,
Pluh,
Silna-Maydan,
Zubilnoye,
Siyantse,
Dederkały,
Nadezhny,
Yary,
Oyedinennyy,
Cheretskiy,
Zalisoche,
Cherchik,
Yelenkovate,
Podivka,
Shchyrets,
Verkh-Konets,
Здовбиця,
Zdvyzhka,
Babyna Dolyna,
Polushkino,
Kontsovo,
Ciamasir,
Oleksintse,
Velikiy Karashin,
Steblëv Pervyy,
Zavady,
Dolucnioi,
Kulmskaya',',')

SELECT * FROM Towns

GO
INSERT INTO Towns(TownName,CountryCode)
SELECT value,dbo.GenerateRandomNumberBetween1and50(1,50) as RandCountryCode
FROM STRING_SPLIT(N'Chepeldzha,
Chukovtsi,Zlataritsa,Christijanowo,Bizhovtsi,Makhmudkioy,Salaman,Pirgowo,Kozarevets,Bryast,Kyuchuklerito,Werdikal,Momtschilowo,Snegovo,Bogoroditsa,Koymatliy,Baevtsŭ,Batishnitsi,Bryest,Gyuyumliy,Salasch,
Bjelozem,
Khasanovska,
Gerenchar,
Belina,
Botiovo,
Chal,
Nadezhden,
Smeiowo,
Krastovo,
Bazaurt,
Yuyukler,
Kazandzhilar,
Cadichioi,
Topoliza,
Bargan,
Lekhovo,
Vinogradets,
Gaberewo,
José Raydan,
Cirilo,
Pracinha,
Baje,
Guarda-Mor,
Ipiranga do Norte,
Bury,
Ipuaçu,
Itapeim,
Amaná,
Cariaçá,
São Nicolau,
Curva,
Majaratuba,
Salina,
Caetê,
Paricatube,
Frei Gaspar,
Guapimirim,
Atalho,
Tinguis,
Garrafa,
Capibaribe,
Buriche,
Cassiterita,
Alto Paraíso de Goiás,
Cearenses,
Centralina,
Campolide,
Cayaué,
Guahyba,
Viçosa,
Mamoeiro,
Doutor Ricardo,
Porto Belo,
Iraci,
Favelas,
Ezequiel,Fruteira,Nova Maringá,São Francisco do Glória,Regalo,Condessa,Iconha,Abaetetuba,Filadélfia,Mirinsal,Itapecô,Catajal,Zehnbach,Mank,
Neuspielberg,
Merzenstein,Simmerstatt,Semlach,Lobersberg,Weigensam,Achthal,
Steinerzaun,
Holdernach,
Grossstroheim,Fukersberg,
Gaflenz,
Zupfing,
Polsing,Pressguts,Neukirchendorf,Robitzboden,Koglerau,Eichat,Haindorf,Tobitsch,Petersdorf,Gschwendt,Leh,Mirnsdorf,Reinsberg,Wallsberg,
Hintersee,
Buchalm,
Etzing,Ameisthal,
Aberg,
Pribelsdorf,
Oberkarlaberg,Streimberg,Ranshofen,Trenkwald,Oberhofen,Tigring,
Mattsee,Stephun,Ehrensdorf,Gutschau,Anzenbach,Mallenitzen,Leitmannsdorf,Natters,Stoychevtsu,Lipez,Belitza,Swoboda,Zlatitrap,Byelotintsi,Iztochnik,Alekovo,Sorkkinen,Piparby,Pikhtiniemi,Kuusjoenpera,
Kataja,Harhala,Saijanlahti,
Lauteala,Rytkynkyla,
Terhola,Martinkyla,
Heinikyla,Madesalmi,
Viensuu,Pettiby,Huhtamo,Keittu,Mansikkavirta,Jans,Puralankyla,Laukansalo,Kansola,Huhta,Koivakkala,Virranniemi,Puntarniemi,Kallionkorpi,Toijala,Rahkee,Siira,Kiesilä,Paasiniemi,Kuustenlatva,
Nalkkila,
Torsholma,Hiittinen,Matero,Nousiainen,Heikfolk,Mustijoki,Hautajoki,Viesimo,Mullinkylä,Rasi,Hangaslahti,Skuru,Hovi,Lemmikko,Suksela,',',')

--the rest add with ADO.NET


GO
CREATE VIEW vw_getRANDValueEvilnessFactor
AS
SELECT FLOOR(RAND()*((SELECT TOP 1 Id FROM EvilnessFactors ORDER BY Id DESC)-(SELECT TOP 1 Id FROM EvilnessFactors))+(SELECT TOP 1 Id FROM EvilnessFactors)) AS Value

GO
CREATE FUNCTION dbo.GenerateRandomEvilnessFactorID()
RETURNS INT
AS
BEGIN

DECLARE @Result INT
SET @Result = (SELECT * FROM vw_getRANDValueEvilnessFactor)

RETURN @Result
END;

GO
INSERT INTO Villains([Name],EvilnessFactorID)
SELECT value,dbo.GenerateRandomEvilnessFactorID()
FROM STRING_SPLIT(N'Laura Caldwell,
Naomi Jordan,
Clint Maldonado,
Lillie Page,
Patricia Blair,
Hector Parks,
Susie Castillo,
Vernon Garcia,
Mary Elliott,
Allan Tyler,
Melvin Horton,
Ann Graham,
Lindsay Williamson,
Wilson Briggs,
Carmen Bowen,
Matthew Phillips,
Muriel Fitzgerald,
Adrian Murphy,
Sally Wolfe,
Ruben Gordon,
Desiree Sherman,
Krystal Craig,
Damon Holland,
Jimmy Wilkerson,
Sue Mccoy,
Shelley Black,
Beth Vasquez,
Eva Potter,
Isaac Wood,
Evan Flowers,
Oliver Burton,
Elmer Simpson,
Randy Gomez,
Carol Terry,
Zachary Moore,
Louis Norton,
Julian Hicks,
Jesus Roberts,
Morris Lowe,
Dale Dean,
Brittany Henderson,
Paula Gonzales,
Ervin Taylor,
Elbert Morrison,
Faith King,
Tracey Park,
Karl Greene,
Daisy Andrews,
Minnie Stevenson,
Angelica Lewis',',')

-- the rest add with Ado.Net




GO
CREATE VIEW vw_getRANDTownID
AS
SELECT FLOOR(RAND()*((SELECT TOP 1 Id FROM Towns ORDER BY Id DESC)-(SELECT TOP 1 Id FROM Towns))+(SELECT TOP 1 Id FROM Towns)) AS Value

GO
CREATE OR ALTER FUNCTION dbo.GenerateTownID()
RETURNS INT
AS
BEGIN

DECLARE @Result INT
SET @Result = (SELECT * FROM vw_getRANDTownID)

RETURN @Result
END;

SELECT * FROM Towns


GO
CREATE VIEW vw_getRANDAge
AS
SELECT FLOOR(RAND()*(100-8)+8) AS Value

GO
CREATE OR ALTER FUNCTION dbo.GenerateRandomAge()
RETURNS INT
AS
BEGIN

DECLARE @Result INT
SET @Result = (SELECT * FROM vw_getRANDAge)

RETURN @Result
END;


--The rest insert with ADO.NET

--for minions
GO
CREATE VIEW vw_getRANDMinionID
AS
(SELECT ABS(CHECKSUM(NEWID()) % ((SELECT TOP 1 Id from Minions ORDER BY Id DESC)  - (SELECT TOP 1 Id from Minions ORDER BY Id) - 1)) + 
(SELECT TOP 1 Id from Minions ORDER BY Id) as value)  

GO
SELECT ABS(CHECKSUM(NEWID()) % (1000 - 700 - 1)) + 700

GO
CREATE OR ALTER FUNCTION dbo.GenerateRandomMinionID()
RETURNS INT
AS
BEGIN

DECLARE @Result INT
SET @Result = (SELECT * FROM vw_getRANDMinionID)

RETURN @Result
END;


--for villains

GO
CREATE VIEW vw_getRANDVillainID
AS
(SELECT ABS(CHECKSUM(NEWID()) % ((SELECT TOP 1 Id from Villains ORDER BY Id DESC)  - (SELECT TOP 1 Id from Villains ORDER BY Id) - 1)) + 
(SELECT TOP 1 Id from Villains ORDER BY Id) as value)  

GO
CREATE OR ALTER FUNCTION dbo.GenerateRandomVillainID()
RETURNS INT
AS
BEGIN

DECLARE @Result INT
SET @Result = (SELECT * FROM vw_getRANDVillainID)

RETURN @Result
END;

GO
ALTER TABLE MinionsVillains
ADD IsStillValid BIT DEFAULT(1)

GO
UPDATE MinionsVillains
SET IsStillValid = 1

SELECT * FROM MinionsVillains





INSERT INTO MinionsVillains(MinionID,VillainID)
Select dbo.GenerateRandomMinionID(),dbo.GenerateRandomVillainID()
Select dbo.GenerateRandomMinionID(),dbo.GenerateRandomVillainID()
Select dbo.GenerateRandomMinionID(),dbo.GenerateRandomVillainID()
Select dbo.GenerateRandomMinionID(),dbo.GenerateRandomVillainID()
Select dbo.GenerateRandomMinionID(),dbo.GenerateRandomVillainID()
Select dbo.GenerateRandomMinionID(),dbo.GenerateRandomVillainID()
Select dbo.GenerateRandomMinionID(),dbo.GenerateRandomVillainID()
Select dbo.GenerateRandomMinionID(),dbo.GenerateRandomVillainID()
Select dbo.GenerateRandomMinionID(),dbo.GenerateRandomVillainID()

SELECT * FROM MinionsVillains
	


--Updating Town names as I broke the table

CREATE TABLE TemporaryTownNames(
Id INT PRIMARY KEY IDENTITY NOT NULL,
[Name] VARCHAR(50) NOT NULL
)

INSERT INTO TemporaryTownNames([Name])
SELECT VALUE FROM STRING_SPLIT('Tallcaster,Starkarta,Cloudley,South Northham,New Hamburgh,Mansside,Elstead,Buoybrough,West Springworth,West Emerworth,Hapview,Jultown Hills,New Fairford,Lexingwich,Auside,Cloudness,Rockworth Falls,North Daywich,Gilside,Oakton,Hamfolk,Farmstead Falls,East Manview,Sayhampton,North Waterham,Great Freeside,Freeside,Wheelburg Park,New Hamburgh,Bayness,Westdale,Starmouth,Strongbrough,Emerbury,Auburgh,Gilfield,Rockville,New Manshampton,Griffinview,Lawby,Parkview,South Waltfolk,Mannorbrough,Sweetwich,Wingland,Kingstead,New Richford,Southingtown,Riverham,Chatham,Buoyville,Hogtown,Princeview,Angertown,Kingley,Strongmouth,Hollowfolk,Pinestead,Emerness Park,Waltfolk,Eggwich,North Mansborough,Aelkarta,Wheelmouth,Norton,Springbury,Freefolk,Highstead,Emergrad,Eastby,Norland,Hallside,Applemouth,Golddale,Readingborough,Sageburg,Skillwich,Valenness,Fairwich,Great Kettleworth,Lexingkarta,Backstead,Waltby,Parkburg,Highside,Manshampton,Weirburgh,Medstead,Massfield,Chatby,Wingside,Costsbrough,Mannorhampton,Highborough Falls,South Mayhampton,Hapgrad,Fortport,Lunburgh,Richstead,East Cruxburgh,Lexingcaster,Massfolk,Lexingbrough,Middleworth Park,Sandstead Beach,North Bellfolk,Applehampton,North Ashfield,Costsville,Halltown,Waterdol,North Sweetburgh,Bridgeford,Duckdale,Fishby,Hosborough Island,Buoyby,Hosside,Highford,Auford,Haphampton,East Kettleport,Buoymouth,Seaham,Dodgekarta,Valenburgh,South Emerburgh,North Profolk,Postley,Pailtown,Cloudland,Parktown,Snowwich Falls,Starcaster,North Pailville,South Costsness,Hostown,Millport,Seadale,South Luncester,Tallton,Dodgepool,Lexingkarta,Hamwich,Jamestown,DuckfieldEast Queensdol,Factburg,Freeside,Winstead City,Capport,Fortton,Rockstead,Starville Beach,Farmingness,Waltfield,Emerbury,Southhampton City,Beachport,Massbrough,Stonekarta,South Eastley,Richside,Hollowborough,Griffinstead,Snowfield,Passhampton,Seadol,South Rosecaster,Farmingstead City,Fauxhampton,Tallley Hills,Tallkarta,Farmingham,Ashcaster,East Sandbrough,Gilfield Beach,Angerfolk,Hapgrad Island,Medbrough,Snowham,Great Lunness,Lawby,Strongmouth,Haphampton,Lawburg,New Normouth,New Emerland,Melworth,New Lexingness,Bellport,Beachkarta,Bridgeham,Holtsfield,Buoycester,Dayview,East Fauxford,Eggton,East Mayfield,Talldale,Winwich,Northland,Grat Oakfolk,Medbrough,Lunby,Millworth,Aelview Falls,Summerbury,West Hogburg,Winterley,Posthampton,Capport,Highpool Falls,Pailtown,New Cruxby,Julland,Lunside,Foxford,Sagecaster,Tallside,Springfolk,Sagemouth,Manskarta,Pailness,Hallbrough,Beachdol,Weirwich,Greenborough,Bellbury,East Farmingport,Southfield,Saltham,Factpool,New Kettleburg,Jamesville,Forthampton,Hoshampton,Middleburg,West Fortness,Winfolk,Fortwich,Hamtown,Redburg,Dodgefield Park,Stonewich,Hapness,Middlegrad Park,Hosbury,Mayworth Park,East Hapton,Seaview,Mannordol,Elhampton,Winburgh,Windale,Lunabrough City,Greenland,Weststead,Stonebrough,Hollowley,Capbrough,Strongley,Nortown,Waltdol,Farmingview,Fauxland Park,Auport,Beachton,Roseland,Southingpool,Richness,Appleport,Sandton,Emerport,Southdale,Buoymouth,Bannbrough,Reddol,Greendale,Saltcester,Fauxham Park,Hogdale,Mannorside,Redstead,Rockgrad,Kingwich,Lexingpool,New Kettlecaster,Griffinby,Halldale,South Weirfield,Northcaster,Lunworth,New Hogland,West Posthampton,Weirstead,North Wingstead,Summerton,Duckborough,Bridgewich,New Aelburg,Fayham,Waltfolk,Medcester,Bridgeworth,Clamburgh Park,Emerbury,Hosburgh,Farmingbrough,Appleport,Buoymouth,Wheelbrough,Fairmouth,Hapwich,Ashtown,Chatstead,Proham,Jamesdale,Winby,West Foxbury,Cruxley,Lunafolk,West Norley,Lexington,Readingfield,Bayton,Jamesbrough Island,Strongcaster,Northfield,Lawwich,Fairside,New Cruxburgh,Foxhampton,Hogdale,Julborough,Bannborough,Hardley,Rockview,Masshampton,Fairfolk,Maywich,Pinetown,Great Tallport,Hollowtown,Bannport,Lawland,Oakborough,Stonekarta,Mannorworth,Richmouth,Winterdol,Hamside,Summerdol Island,Sayby Park,Farmkarta,Aufield,Bridgewich,Redness,Sayport,Dodgekarta,Fauxton,Richford,West Hamcaster,Hogburgh,Appleland Hills,Queensborough,Hallham Hills,Hosburg Falls,Cruxstead,Transpool,Norburg,Pailness,Rockpool,Lawcester,Hollowbrough,Transness,Hardport,Farmingford,Wheelfield,East Sandbrough,Mandol Island,Farmingdol,Wheelley Hills,Eggness,Manham,Factham,Summerborough,Cruxburg,Oakbrough,Costscester,Northland,Princeland,Redness,Costshampton,Skillborough,Mancaster,Saykarta,Springley Beach,Highview,Wingness,Norpool Island,Fortland Falls,Tallness,Manspool,Cruxstead,Beachhampton,Norford,Middleburg,Southfield Hills,Fauxpool,Sweetburg Falls,Summerfield Park,New Saltley,Southborough,Freecaster,Readingland,Sageview,East Beachville,Ashdol,Rosekarta Park,Queenscester,New Fairdol,Emerburgh,Freeness,Dayley,Jamesport Falls,Cruxburg Beach,Elbury,Lawbury,West Frostbrough,Buoydol,North Hamhampton,South Weirkarta,Hapville,Fauxkarta Island,Valentown,Strongburgh,Lawworth,Appleburgh,West Eastwich,Wincester,Lunmouth,Hogbrough,Fortside,Aufield,Winton,Millpool',',')


--Function to select random country code between 1 and 50
--the problem is I cannot use RAND inside a userdefined function, how boring so I gotta make it a view first and use it as a view
GO
CREATE VIEW vw_getRANDValue
AS
SELECT FLOOR(RAND()*(50-1)+1) AS Value

GO
CREATE FUNCTION dbo.GenerateRandomNumberBetween1and50(@MinNumber INT, @MaxNumber INT)
RETURNS INT AS
BEGIN
DECLARE @NumberToReturn INT
SET @NumberToReturn = (SELECT * FROM vw_getRANDValue)

RETURN @NumberToReturn
END;


--Function to count how many Minions does a villain have
GO

CREATE OR ALTER FUNCTION dbo.CountMinionsOfVilainByID(@VillainID INT)
RETURNS INT
AS
BEGIN

DECLARE @Result INT
SET @Result = (SELECT COUNT(*) FROM MinionsVillains
WHERE VillainID = @VillainID)

RETURN @Result
END;

GO
SELECT [Name],dbo.CountMinionsOfVilainByID(Id) FROM Villains

GO
SELECT Villains.[Name] as VillainName,Minions.[Name] FROM MinionsVillains
JOIN Minions ON Minions.Id = MinionsVillains.MinionID
JOIN Villains ON Villains.Id = VillainID
WHERE VillainID = 38

EXECUTE  pr_AssignCityName

SELECT * FROM Towns

GO
CREATE PROCEDURE pr_AssignCityName
AS
BEGIN

DECLARE @Start INT
SET @Start = 1

DECLARE @End INT
SET @End = 446

DECLARE @TownIdFromTemp INT

WHILE @Start<=@End
BEGIN

SET @TownIdFromTemp = dbo.GenerateRandomTownIdFromTempNames();

UPDATE Towns
SET TownName = (SELECT [Name] FROM TemporaryTownNames WHERE Id = @TownIdFromTemp)
WHERE Id = @TownIdFromTemp

DELETE FROM TemporaryTownNames WHERE Id = @TownIdFromTemp

SET @Start = @Start +1

END

END


SELECT COUNT(*) FROM TemporaryTownNames


GO
CREATE VIEW vw_getRandTownIdFromTempNames
AS
(SELECT ABS(CHECKSUM(NEWID()) % ((SELECT TOP 1 Id from TemporaryTownNames ORDER BY Id DESC)  - (SELECT TOP 1 Id from TemporaryTownNames ORDER BY Id) - 1)) + 
(SELECT TOP 1 Id from TemporaryTownNames ORDER BY Id) as value)  

GO
CREATE OR ALTER FUNCTION dbo.GenerateRandomTownIdFromTempNames()
RETURNS INT
AS
BEGIN

DECLARE @Result INT
SET @Result = (SELECT * FROM vw_getRANDVillainID)

RETURN @Result
END

SELECT dbo.GenerateRandomTownIdFromTempNames()