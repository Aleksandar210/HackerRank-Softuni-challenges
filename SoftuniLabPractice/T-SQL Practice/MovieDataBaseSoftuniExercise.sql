--this querry is for the Movie database exercise
CREATE TABLE Directors(
Id int Primary key IDENTITY NOT NULL,
DirectorName nvarchar(50) NOT NULL,
Notes nvarchar(MAX) NULL
)

CREATE TABLE Genres(
Id INT PRIMARY KEY IDENTITY NOT NULL,
GenreName varchar(60) NOT NULL,
Notes varchar(MAX) NULL
)

CREATE TABLE Categories(
Id INT PRIMARY KEY IDENTITY NOT NULL,
CategoryName varchar(60) NOT NULL,
Notes varchar(MAX) NULL
)

--create movie data base
CREATE TABLE Movies(
Id int PRIMARY KEY IDENTITY NOT NULL,
Title nvarchar(50) NOT NULL,
DirectorId INT Foreign Key References Directors(Id),
CopyRightYear DATETIME2 NOT NULL,
[Length] TIME NOT NULL,
GenreId INT Foreign Key REFERENCES Genres(Id) NOT NULL,
CategoryId INT Foreign Key REFERENCES Categories(Id)NOT NULL,
Rating nvarchar(50) NULL Default('Not specified'),
Notes varchar(MAX) NULL,
Constraint CHK_Rating_IsOneOf CHECK(Rating ='Good' OR Rating ='Bad' OR Rating ='Very Good' OR Rating ='Very Bad')
)

--adding values to the tables but first we add values to the table with no foreign keys
--because if we add values to the others first then there wont by any valid value in the table
INSERT INTO Directors([DirectorName],Notes)
	VALUES
		('Steven Spielberg','Action movie director with some romance inspirations'),
		('Stephen King',NULL),
		('Alan Baker','Indie movie maker with inspiration from detective movies'),
		('Johnatan West','Mystery movies, with some scary aspects'),
		('Romanian Roman','Historical movie maker with Phd in History and langauges')

--now adding values to the rest, in this case only the Movies table has relations with other tables
--so we will insert values to movies last

INSERT INTO Genres(GenreName,Notes)
	VALUES
		('Horro','relate to fear and jump-scares'),		--I misspelled Horror with Horro
		('Comedy','Makes you laugh and puts you in a good mood'),
		('Romance','Straight love stories and maybe nude sex scenes'),
		('Love-Comedy','Its like Romance but with less nudity and more comedy while still being cute for the audience'),
		('Action','shooting, killing,saving people, car crashes etc')


INSERT INTO Categories(CategoryName,Notes)
	VALUES
		('Kaiju','Movies with japanese monsters'),
		('Compilation-movies',NULL),
		('Girls with guns',NULL),
		('Documentary','something like a research film')

--inserting data for the Movies table




--this gives the id (primary key of the genre searched by name) I misspelled horror with horro
Select top 1 Id FROM Genres Where GenreName ='Horro'


