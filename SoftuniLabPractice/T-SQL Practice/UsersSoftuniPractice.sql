CREATE TABLE Users(
Id BIGINT PRIMARY KEY IDENTITY NOT NULL,
Username varchar(30) UNIQUE NOT NULL,
[Password] varchar(26) NOT NULL,
ProfilePicture varbinary(max) NULL,
LastLogin DATETIME2 NOT NULL,
IsDeleted BIT NOT NULL,
 CONSTRAINT CHK_ProfilePictureSize CHECK(DATALENGTH(ProfilePicture)<=900*1024)
)

--inserting data into the table
INSERT INTO Users(Username,[Password],LastLogin,IsDeleted)
	VALUES
			('TheDemolisher','98751513',GETDATE(),0),
			('DOOM SLAYER','123456',GETDATE(),0),
			('cod player 69','200720092011',GETDATE(),1),
			('TeemoPlayer','riotgamesdabest',GETDATE(),1),
			('normal person','normal password',GETDATE(),0)

--remove primary key constraint
ALTER TABLE Users
DROP CONSTRAINT PK__Users__3214EC0706F8D8E5

--adds combination of primary keys which means
--that there can be 1 john and 2 john but not two 1 john (both have to be unique AND)
ALTER TABLE Users
ADD CONSTRAINT PK_IdUsername PRIMARY KEY(Id,Username)

--reverse the combiination done
ALTER TABLE Users
DROP CONSTRAINT PK_IdUsername

--and put only id to be primary because after the constraint now there is no primary key
ALTER TABLE Users
ADD CONSTRAINT PK_Id PRIMARY KEY(Id)

--adding check constraint to check if the password is at least 5 symbols long
ALTER TABLE Users
ADD CONSTRAINT CHK_Password_length CHECK(LEN([Password])>=5)

--chekc if the username is at least 3 symbols long
ALTER TABLE Users
ADD CONSTRAINT CHK_Username_Length CHECK(LEN(Username)>=3)


--sets the default  value for 
ALTER TABLE Users
ADD CONSTRAINT DF_LastLogin DEFAULT(GETDATE()) FOR LastLogin

--changes the column schema because I made LastLogin NOT NULL int hte create statement
ALTER TABLE Users
ALTER COLUMN LastLogin DATETIME2 Null

-- get the (2 specified column) data from the table
SELECT Username,LastLogin FROM USERS

--get everything
SELECT * FROM Users

--remove values form the table but keep the table
TRUNCATE TABLE Users

--REMOVE TABLE
DROP TABLE Users

