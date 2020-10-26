USE db1901321057

CREATE TABLE Minions
(
Id int  PRIMARY KEY NOT NULL,
[NAME] nvarchar(50) NOT NULL,
AGE TINYINT NULL
)
ALTER TABLE Minions
ADD CONSTRAINT FK_TownsId  FOREIGN KEY (TownId) REFERENCES Towns(Id)


CREATE TABLE Towns
(
Id int PRIMARY KEY NOT NULL,
[NAME] nvarchar(50) NOT NULL
)

--Inserting values in the Towns table (more than 1 value like this)
INSERT INTO Towns(Id,Name)
VALUES
     (1,'София'),
	 (2,'Пловдив'),
	 (3,'Хасково')


	 -- to check what we have entered (it will show us everything from the table)
	 SELECT * FROM Towns

	 INSERT INTO Minions (Id,Name,Age,TownId)
	 VALUES 
		(1,'Kevin',19,1),
		(2,'Teodor',20,2),
		(3,'Alexander',22,3)

		SELECT * FROM Minions

	
	-- if you need to delete everything
	DROP TABLE Minions		--first we drop Minions because they have a foreign key to Towns and if we drop first Towns then the key ill point to void
	DROP TABLE Towns

	-- to delete all values from the table but keeps it
	TRUNCATE TABLE Minions

	