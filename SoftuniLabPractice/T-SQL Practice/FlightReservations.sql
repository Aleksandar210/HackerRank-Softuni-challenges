--Querry for Airplanes

--CREATING TABLE Clients
CREATE TABLE Clients(
FirstName NVARCHAR(50) NOT NULL,
MiddleName NVARCHAR(50) NULL,
LastName NVARCHAR(50) NOT NULL,
Email VARCHAR(20) NOT NULL,
IdentityDocumentNumber CHAR(9) PRIMARY KEY ,
DateOfBirth DATETIME2 CHECK(DateOfBirth>'1940-01-01')
)

--Inserts
INSERT INTO Clients(FirstName,MiddleName,LastName,Email,IdentityDocumentNumber,DateOfBirth)
	VALUES
		('Атанас','Николов','Колев','akolev@gmail.com','443426789','1967-02-25'),
		('Георги','Спасов','Николов','georgispas@gmail.com','743426789','1989-03-20'),
		('Александър','Александров','Владимиров','aleksvlad@gmail.com','143426789','1999-05-20'),
		('Борис','Nikolov','Kolev','akolev@gmail.com','333426789','1988-05-01'),
		('Мария','Димитрова','Атанасова','matansova@gmail.com','113426789','1979-06-03'),
		('Димитрия','Кирилова','Померийска','dpomeriiska@gmail.com','423226189','1993-05-20'),
		('Atanas Georgiev','Nikolov','Kolev','akolev@gmail.com','443426789','1967-05-20'),
		('Atanas Georgiev','Nikolov','Kolev','akolev@gmail.com','443426789','1967-05-20'),
		('Atanas Georgiev','Nikolov','Kolev','akolev@gmail.com','443426789','1967-05-20'),
		



CREATE TABLE Flights(
CityName NVARCHAR(50) NOT NULL,
CountryName NVARCHAR(50) NOT NULL,
DateOfDeparture DATETIME2 DEFAULT(GETDATE()),
PriceOfFlight DECIMAL(8,2) DEFAULT(1000),
)

INSERT INTO Flights(CityName,CountryName)
VALUES
	--('Haskovo','Bulgaria'),
	('Berlin','Deutshland'),
	('Pris','France'),
	('London','United-Kingdom'),
	('Sofia','Bulgaria'),
	('Nigeria','Africa'),
	('Brazil','Brazil'),
	('Rio De Janiero','Brazil'),
	('Pekin','China'),
	('Pyongyang','North Korea'),
	('Bkurest','Romania'),
	('Skopie','Macedonia'),
	('Anakara','Turkey'),
	('Marakesh','Moroko')

	--Insert data with dates that will e changed in updates later on

--INSERT INTO Flights()


	--see what I have entered so far
	SELECT * FROM Flights



