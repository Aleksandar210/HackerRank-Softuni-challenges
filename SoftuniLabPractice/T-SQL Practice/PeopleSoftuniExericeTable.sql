
-- This is for the task People populated with 5 entries
CREATE TABLE People(
Id INT PRIMARY KEY IDENTITY NOT NULL,
[Name] nvarchar(200) NOT NULL,
Picture varbinary(Max) NULL,
Height real NULL,
Weight real NULL,
Gender char(1) NOT NULL,
Birthdate DATETIME2 NULL DEFAULT(GETDATE()),
Biography ntext NULL
)

ALTER TABLE People
ADD CONSTRAINT CHK_Picture_Size CHECK(DATALENGTH(Picture)>=2097152)

ALTER TABLE People
ADD CONSTRAINT CHK_Gender_MF CHECK(Gender = 'F' OR Gender ='M')

INSERT INTO People([Name],Gender,Biography)
   VALUES 
		('David','M','A 22 year old person living in detroid'),
		('Sarah','F','A 24 old woman working as a dentinst in LA'),
		('Deborah','F','A 21 year old artist living in Stara Zagora Born in the USA'),
		('Michael Reves','M','21 old programmer who currently lvies in the States from the Philipines')

--To display the data entered
Select * from People

--to select only people who start with the letter D
Select * from People Where([Name] LIKE 'd%')

--same as abov but in descending order
Select * from People Where([Name] LIKE 'd%') ORDER BY [NAME] DESC

--Used for deleting the values
TRUNCATE TABLE People

--used to delete the table
DROP TABLE People
