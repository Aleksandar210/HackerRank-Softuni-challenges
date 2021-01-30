
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

INSERT INTO Towns(TownName,CountryCode)
SELECT value,dbo.GenerateRandomNumberBetween1and50(1,50) as RandCountryCode
FROM STRING_SPLIT(N'Chepeldzha,
Chukovtsi,
Zlataritsa,
Christijanowo,
Bizhovtsi,
Makhmudkioy,
Salaman,
Pirgowo,
Kozarevets,
Bryast,
Kyuchuklerito,
Stambolovo,
Werdikal,
Momtschilowo,
Snegovo,
Bogoroditsa,
Devesilitsa,
Koymatliy,
Baevtsŭ,
Batishnitsi,
Bryest,
Rosomai,
Gyuyumliy,
Salasch,
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
Ezequiel,
Fruteira,
Nova Maringá,
São Francisco do Glória,
Regalo,
Condessa,
Iconha,
Abaetetuba,
Bonfinópolis de Minas,
Filadélfia,
Mirinsal,
Itapecô,
Catajal,
Zehnbach,
Mank,
Neuspielberg,
Merzenstein,
Simmerstatt,
Semlach,
Lobersberg,
Weigensam,
Achthal,
Steinerzaun,
Holdernach,
Grossstroheim,
Fukersberg,
Gaflenz,
Zupfing,
Polsing,
Pressguts,
Neukirchendorf,
Robitzboden,
Koglerau,
Eichat,
Haindorf,
Tobitsch,
Petersdorf,
Gschwendt,
Leh,
Mirnsdorf,
Reinsberg,
Wallsberg,
Riedenberg,
Hintersee,
Buchalm,
Etzing,
Ameisthal,
Aberg,
Pribelsdorf,
Oberkarlaberg,
Streimberg,
Ranshofen,
Trenkwald,
Oberhofen,
Tigring,
Mattsee,
Stephun,
Ehrensdorf,
Gutschau,
Anzenbach,
Mallenitzen,
Leitmannsdorf,
Natters,
Stoychevtsu,
Lipez,
Belitza,
Swoboda,
Zlatitrap,
Byelotintsi,
Iztochnik,
Alekovo,
Sorkkinen,
Piparby,
Pikhtiniemi,
Kuusjoenperä,
Kataja,
Harhala,
Saijanlahti,
Lauteala,
Rytkynkylä,
Terhola,
Martinkylä,
Heinikylä,
Madesalmi,
Viensuu,
Pettiby,
Huhtamo,
Keittu,
Mansikkavirta,
Jans,
Puralankylä,
Laukansalo,
Kansola,
Huhta,
Koivakkala,
Virranniemi,
Bodbacken,
Puntarniemi,
Kallionkorpi,
Toijala,
Rahkee,
Siira,
Kiesilä,
Paasiniemi,
Kuustenlatva,
Nalkkila,
Torsholma,
Hiittinen,
Matero,
Nousiainen,
Heikfolk,
Mustijoki,
Hautajoki,
Viesimo,
Mullinkylä,
Rasi,
Hangaslahti,
Skuru,
Hovi,
Lemmikko,
Suksela,',',')

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


GO
INSERT INTO Minions([Name],Age,TownID)
	SELECT value,dbo.GenerateRandomAge(),dbo.GenerateTownID()
	FROM 
	STRING_SPLIT(N'Ache,
Aches,
Azi,
Bhavin,
Bark,
Basher,
Bedlam,
Beef,
Belch,
Bellow,
Berserk,
Bill,
Bitey,
Bloat,
Blob,
Blump,
Blunt,
Blurt,
Bobba,
Bones,
Bonce,
Bones,
Boog,
Boot,
Boxer,
Bracket,
Brash,
Brawly,
Brawn,
Brick,
Bruise,
Brunt,
Brute,
Buba,
Bumps,
Burly,
Cackle,
Canis,
Chaff,
Cheese,
Chewy,
Chops,
Chuckles,
Chunk,
Clank,
Clash,
Claws,
Clay,
Cliffy,
Cleft,
Clobber,
Clod,
Clog,
Clogg,
Clot,
Clout,
Clunk,
Colon,
Conk,
Cragg,
Crbbage,
Crank,
Crash,
Crawb,
Cribble,
Crivice,
Crot,
Crummy,
Crunchy,
Crusher,
Crusty,
Curly,
Cyst,
Daft,
Daks,
Dave,
Deek,
Dirt,
Doog,
Dookie,
Drag,
Drag,
Dribble,
Dringe,
Drivel,
Drob,
Drogan,
Drongo,
Drot,
Drozz,
Drub,
Duggs,
Duh,
Dusty,
Dweeb,
Ears,
Egg,
Fatso,
Fearless,
Feral,
Fidget,
Flakes,
Flaky,
Flange,
Flarbic,
Fleas,
Flibble,
Flint,
Flub,
Flumber,
Flummox,
Flunk,
Frack,
Frebb,
Frenzy,
Frothmouth,
Footrot,
Fury,
Glob,
Gloob,
Glottis,
Gnarf,
Gnash,
Gnat,
Gobble,
Gobbler,
Gonk,
Goober,
Goulash,
Grabber,
Grapple,
Graves,
Gribble,
Grime,
Grimm,
Grinder,
Grit,
Groan,
Groat,
Grockle,
Grody,
Grot,
Grotty,
Grouch,
Grout,
Grub,
Grug,
Gruff,
Grump,
Grunt,
Gubbin,
Gunk,
Gurk,
Gusto,
Havoc,
Heabag,
Headcase,
Herc,
Hinge,
Hobble,
Hog,
Hooter,
Howler,
Huffy,
Hunt,
Hurtle,
Husk,
Huso,
Itchy,
Kenny,
Khan,
Klepto,
Klutts,
Kniff,
Knobbly,
Knotts,
Knud,
Krudster,
Krug,
Krumb,
Krump,
Lacky,
Lard,
Lash,
Len,
Lestek,
Limp,
Lix,
Loafer,
Lobe,
Loob,
Loon,
Loony,
Louse,
Ludz,
Lug,
Lumber,
Lumper,
Lumpy,
Maaka,
Mac,
Maggot,
Mangle,
Manky,
Manny,
Maul,
McGee,
Meph,
Midge,
Migs,
Migsy,
Minc,
Mite,
Moldy,
Moloch,
Mooker,
Moxy,
Muck,
Muckle,
Mud,
Muggins,
Mugsy,
Murf,
Murk,
Murry,
Musher,
Musty,
Nails,
Nerc,
Nibbles,
Nip,
Nit,
Nokk,
Nork,
Nub,
Nubbage,
Nubbin,
Nud,
Nudge,
Nug,
Numpty,
Nutter,
Nutts,
Odd,
Omph,
Orl,
Pants,
Pest,
Pigpen,
Pimples,
Plunk,
Podge,
Pounder,
Psycho,
Pudge,
Pug,
Puke,
Pummel,
Punchy,
Pus,
Rabid,
Raglam,
Rags,
Raider,
Ramshackle,
Rascal,
Rasp,
Rat,
Ravage,
Raw,
Reggie,
Ricket,
Riggs,
Rocky,
Rootle,
Rubble,
Rumpus,
Runt,
Ruttle,
Scabby,
Scabies,
Scars,
Schlump,
Scrappings,
Scraps,
Scroop,
Scrot,
Scrub,
Scrum,
Scrunch,
Scrunge,
Scrunt,
Scuffle,
Scum,
Scuz,
Scuzzy,
Shabby,
Shaktor,
Shotter,
Shub,
Sins,
Skank,
Skritch,
Skum,
Skull,
Slab,
Slain,
Slasher,
Sleaver,
Slog,
Sloth,
Sloot,
Slurp,
Smasher,
Smear,
Smidge,
Smirk,
Smoosh,
Snelp,
Snort,
Snotter,
Snub,
Snubbly,
Snurt,
Soiled,
Sores,
Spasm,
Spink,
Splitter,
Spod,
Spoon,
Sporker,
Sprocket,
Squabble,
Squat,
Squib,
Squiggle,
Stig,
Stomped,
Stomper,
Stones,
Stonk,
Stoop,
Stout,
Straggle,
Striker,
Strut,
Stripe,
Stubby,
Stump,
Sug,
Sulks,
Swat,
Toady',',')

SELECT * FROM Minions

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

