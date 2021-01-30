--Instructors Querry

--Aleksandar Kuzmov
--1901321057

CREATE TABLE Courses(
CourseID INT PRIMARY KEY IDENTITY NOT NULL,
CourseTitle NVARCHAR(50) NOT NULL
)

INSERT INTO Courses(CourseTitle)
	VALUES
		('Mathematic'),
		('History'),
		('Geography'),
		('Net programming'),
		('Web programming'),
		('English C2')

		INSERT INTO Courses(CourseTitle)
	VALUES
		('Gymnastics')

		INSERT INTO Courses(CourseTitle)
	VALUES('Народни танци')

CREATE TABLE Instructors(
InstructorID INT PRIMARY KEY IDENTITY NOT NULL,
FirstName NVARCHAR(50) NOT NULL,
LastName NVARCHAR(50) NOT NULL,
[Address] NVARCHAR(150) NULL DEFAULT('Not included'),
PhoneNumber CHAR(10) NULL CHECK(LEN(PhoneNumber)=10),
)

insert into Instructors(FirstName,LastName,[Address],PhoneNumber)
	VALUES
		('Алекс','Кузмов','Madara 21-25','0195717851'),
		('Димитър','Глухова','Витошка 5','2495747851'),
		('Христо','Гочев','Аляска-13','0895666852'),
		('Живко','Иванов','Боровица-90','0291771851')

ALTER TABLE Instructors
ADD Gender CHAR(1) CHECK(Gender IN ('M','F'))

UPDATE Instructors
SET Gender ='M'

--промяна на адреса на инструктор с идентификатор 2 
UPDATE Instructors
SET [Address] = 'Поликиня-24'
WHERE InstructorID = 2

CREATE TABLE  Instructor_Courses(
InstrucotrID INT FOREIGN KEY REFERENCES Instructors(InstructorID) NOT NULL,
CourseID INT FOREIGN KEY REFERENCES Courses(CourseID) NOT NULL,
StartDate DATETIME2 NOT NULL,
CONSTRAINT PK_CLUSTERED_INSTR_COURSE_ID PRIMARY KEY (InstrucotrID,CourseID)
)



SELECT * FROM Courses
SELECT * FROM Instructors

INSERT INTO Instructor_Courses(InstrucotrID,CourseID,StartDate)
	VALUES
		(1,1,GETDATE()),
		(1,7,GETDATE()),
		(2,4,GETDATE()),
		(4,6,GETDATE()),
		(3,7,GETDATE()),
		(2,2,GETDATE())

		SELECT * FROM Instructor_Courses

--5 Извличане на инструктурите по народни танци
SELECT CONCAT_WS(' ',FirstName,LastName) as [Full Instructor name], [Address],PhoneNumber,CourseTitle
FROM Instructor_Courses 
RIGHT JOIN Instructors ON Instructors.InstructorID = Instructor_Courses.InstrucotrID
JOIN Courses ON Courses.CourseID = Instructor_Courses.CourseID
WHERE Instructor_Courses.CourseID = 7

--6
SELECT CourseTitle,CONCAT_WS(' ',FirstName,LastName) as [Full Instructor name],StartDate
FROM Instructor_Courses
RIGHT JOIN Courses ON Courses.CourseID = Instructor_Courses.CourseID
LEFT JOIN Instructors ON Instructors.InstructorID = Instructor_Courses.InstrucotrID


SELECT * FROM Courses

--7 view
GO
CREATE VIEW v_GetInstructorsWithNumberOfCoursesTheyLead
AS
SELECT CONCAT_WS(' ',FirstName,LastName) as [FullName],dbo.udf_GetInstructorNumberCoursesHeLeads(InstructorID) as [Number Courses he leads]
FROM Instructors

GO
CREATE FUNCTION udf_GetInstructorNumberCoursesHeLeads(@InstructorID INT)
RETURNS INT
BEGIN
RETURN (SELECT COUNT(*) FROM Instructor_Courses WHERE InstrucotrID = @InstructorID)
END

--testing the view
go
SELECT * FROM v_GetInstructorsWithNumberOfCoursesTheyLead