--This Querry will be used for the Trains task
GO
CREATE TABLE Stations(
ID INT PRIMARY KEY IDENTITY NOT NULL,
[Name] NVARCHAR(200) NOT NULL
)

--Inserts
INSERT INTO Stations([Name])
	Values('Пловдив'),
		  ('Хасково'),
		  ('София'),
		  ('Варна'),
		  ('Бургас'),
		  ('Благоев Град'),
		  ('Габрово'),
		  ('Русе'),
		  ('Монтана'),
		  ('Димитров Град'),
		  ('Елена'),
		  ('Брезово'),
		  ('Троян'),
		  ('Стара Загора'),
		  ('Нова Загора'),
		  ('Дунав')

CREATE TABLE Tracks(
ID INT PRIMARY KEY IDENTITY NOT NULL,
TrackName NVARCHAR(50) NOT NULL,
DepartureStation INT FOREIGN KEY REFERENCES Stations(ID) NOT NULL,
ArrivalStation INT FOREIGN KEY REFERENCES Stations(ID) NOT NULL,
CONSTRAINT CHK_TrackNameWithStationNames CHECK([dbo].udf_CheckStationNameWithDepartureAndArrivalStations(TrackName,DepartureStation,ArrivalStation)=1),
CONSTRAINT CHK_TrackNameFormat CHECK(TrackName LIKE('%-%'))
)

-- non needed no more
TRUNCATE TABLE Tracks
DROP TABLE Tracks
TRUNCATE TABLE Stations
DROP TABLE Stations

--reference select when inserting
SELECT * FROM STATIONS
--Inserts
INSERT INTO Tracks (TrackName,DepartureStation,ArrivalStation)
VALUES
	('София-Пловдив',3,1),
	('Пловдив-София',1,3)
	

	



CREATE TABLE Schedules(
ID INT PRIMARY KEY IDENTITY NOT NULL,
DepartureTime DATETIME2 NOT NULL,
ArrivalTime DATETIME2 NOT NULL,
TrackID INT FOREIGN KEY REFERENCES Tracks(ID) NOT NULL,
CONSTRAINT CHK_DepartrueTimeBeforeArrival CHECK(DepartureTime<ArrivalTime),
CONSTRAINT CHK_ArrivalTimeAfterDeparture CHECK(ArrivalTime>DepartureTime)
)


CREATE TABLE Trains(
TrainNumber CHAR(10) PRIMARY KEY NOT NULL CHECK(LEN(TrainNumber)=10),
Desciption NVARCHAR(500) NULL
)

ALTER TABLE Trains
ADD TrainType NVARCHAR(50) CHECK([TrainType] IN ('Пътнически','Експрес','Бърз'))

INSERT INTO Trains(TrainNumber,Desciption,TrainType)
	VALUES
		('RD32564892','Delivered From France in 1989, second from 500 issued during Socialist party ruling','Пътнически'),
		('ZK32564892','Japanese Speed Train invented 2001 and deployed in use in 2007 then delivered in Bulgaria in 2011','Бърз'),
		('ZK32565392','Japanese Speed Train invented 2001 and deployed in use in 2007 then delivered in Bulgaria in 2011','Бърз'),
		('BK32564892','USA express train invented to carry ore passangers with extras','Експрес'),
		('BK32564777','USA express train invented to carry ore passangers with extras','Експрес')


CREATE TABLE Trains_Tracks(
TrainID CHAR(10) FOREIGN KEY REFERENCES Trains(TrainNumber) NOT NULL,
TrackID INT FOREIGN KEY REFERENCES Tracks(ID) NOT NULL,
CONSTRAINT PK_TrainTrackCompositeKey PRIMARY KEY (TrainID,TrackID)
)

INSERT INTO Trains_Tracks(TrackID,TrainID)
	VALUES
		(9,'BK32564777'),
		(2,'BK32564777'),
		(4,'BK32564777'),
		(9,'ZK32565392'),
		(10,'ZK32565392'),
		(10,'BK32564777'),
		(10,'RD32564892')


ALTER TABLE Tracks
DROP CONSTRAINT CHK_TrackNameWithStationNames




--Намери дестинации на даден влак
GO
CREATE OR ALTER PROC usp_GetTrainDestinations(@TrainID CHAR(10))
AS
BEGIN
IF(EXISTS(SELECT * FROM Trains WHERE TrainNumber LIKE(@TrainID)))
BEGIN
SELECT TrainNumber,TrainType,ISNULL(Desciption,'No description included'),TrackName
FROM Trains
JOIN Trains_Tracks ON Trains_Tracks.TrainID = @TrainID
JOIN Tracks ON Trains_Tracks.TrackID = Tracks.ID
WHERE TrainNumber = @TrainID
END
ELSE
BEGIN
SELECT 'No such train exists'
END
END

--test
EXEC usp_GetTrainDestinations 'BK32564777'

--Всички влакове с дестинация Пловдив-София
SELECT TrainNumber,TrainType,ISNULL([Desciption],'Not inncluded') as [Description],TrackName
FROM Trains
JOIN Trains_Tracks ON Trains_Tracks.TrainID = Trains.TrainNumber
JOIN dbo.Tracks ON Trains_Tracks.TrackID = Tracks.ID
--WHERE Tracks.ID = 10
WHERE Tracks.DepartureStation = 1 AND ArrivalStation = 3


SELECT * FROM Tracks



--FUNCTIONS AND STORED PROCEDURES  USED IN THE TASK
GO
CREATE OR ALTER FUNCTION udf_CheckStationNameWithDepartureAndArrivalStations(@TrackName NVARCHAR(50),@DepartureStationID INT,@ArrivalStationID INT)
RETURNS bit
BEGIN

IF(EXISTS(SELECT [Name] FROM Stations WHERE ID = @DepartureStationID) AND EXISTS(SELECT [Name] FROM Stations WHERE ID = @ArrivalStationID))
BEGIN

--First Track name from the split
DECLARE @FirstValueTrackNameSplit NVARCHAR(50)
SET @FirstValueTrackNameSplit = 
(SELECT valName
FROM
(SELECT  ROW_NUMBER() OVER (ORDER BY (SELECT 2)) AS rownum, VALUE as valName FROM STRING_SPLIT(@TrackName,'-')) AS GetTrackNames
WHERE rownum =1)

--Second track name from the split
DECLARE @SecondValueTrackNameSplit NVARCHAR(50)
SET @SecondValueTrackNameSplit = 
(SELECT valName
FROM
(SELECT  ROW_NUMBER() OVER (ORDER BY (SELECT 2)) AS rownum, VALUE as valName FROM STRING_SPLIT(@TrackName,'-')) AS GetTrackNames
WHERE rownum =2)

DECLARE @DepartureStationName NVARCHAR(50)
SET @DepartureStationName = (SELECT [Name] FROM Stations WHERE ID = @DepartureStationID)

DECLARE @ArrivalStationName NVARCHAR(50)
SET @ArrivalStationName = (SELECT [Name] FROM Stations WHERE ID = @ArrivalStationID)

DECLARE @Result BIT 

IF((@FirstValueTrackNameSplit LIKE @DepartureStationName) AND (@SecondValueTrackNameSplit LIKE @ArrivalStationName))
BEGIN
SET @Result = 1
END
ELSE
BEGIN
SET @Result =0;
END

END
ELSE 
BEGIN
RETURN 0
END

RETURN @Result

END




SELECT * FROM Stations
SELECT * FROM Tracks

GO
----------------------------------------------------------------------------------------
--TESTS FOR CHECK FUNCTION
--get count and it works with the seperator
SELECT COUNT(*) FROM
(SELECT VALUE FROM STRING_SPLIT('Пловдив-Димитров Град','-') AS [TrackDest]) AS Table1

--testing getting every value seperatly

--getting the first
SELECT TOP 1 VALUE AS [DepStation] FROM 
(SELECT VALUE FROM STRING_SPLIT('Пловдив-Димитров Град','-') AS[TrackDest]) AS Table2


--works
--getting the second
SELECT TOP 1 VALUE
FROM
(SELECT VALUE FROM STRING_SPLIT('Пловдив-Димитров Град','-') AS [TrackDest]) AS Table1
WHERE VALUE NOT LIKE ((SELECT TOP 1 VALUE AS [DepStation] FROM 
(SELECT VALUE FROM STRING_SPLIT('Пловдив-Димитров Град','-') AS[TrackDest]) AS Table2
))

-----------------------------------------------------------------------------------------------------
--END OF TESTS

