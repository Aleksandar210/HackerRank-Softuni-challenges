--This Querry is used to practice before the BD exam in wendesday

--Pizza Tables
CREATE TABLE Pizzas(
PizzaID INT PRIMARY KEY IDENTITY NOT NULL,
Pizza_Type Varchar(30) NOT NULL
)

ALTER TABLE Pizzas
ADD IsDeleted BIT DEFAULT(0)

GO
CREATE TRIGGER tr_SoftDeletePizzaType ON dbo.Pizzas
INSTEAD OF DELETE 
AS 
BEGIN
UPDATE Pizzas
SET IsDeleted = 1 
WHERE PizzaID IN (SELECT PizzaID from Deleted)
END

DELETE FROM Pizzas
WHERE PizzaID = (SELECT TOP 1 PizzaID FROM Pizzas ORDER BY PizzaID DESC)

SELECT * FROM Pizzas





--Inserts into pizzas
INSERT INTO Pizzas(Pizza_Type)
VALUES
	('Vegetarian'),
	('Hawaian'),
	('Peperoni'),
	('SeaMeatPizza'),
	('Full Meat Pizza')

	GO
	CREATE TABLE Clients(
	ClientID INT PRIMARY KEY IDENTITY NOT NULL,
	ClientName VARCHAR(50) NOT NULL,
	ClientPhoneNumber CHAR(10) NOT NULL CHECK(LEN(ClientPhoneNumber)=10)
	)

	TRUNCATE TABLE Clients
	ALTER TABLE Clients
	DROP COLUMN ClientPhoneNumber



	INSERT INTO Clients(ClientName,ClientPhoneNumber)
		VALUES
			('Ben','0815727352'),
			('Alex','0294574851'),
			('Zac','0895777111'),
			('Kenny','0895778943')

	CREATE TABLE Pizza_Orders(
	PizzaID INT,
	ClientID INT,
	Quantity INT,
	Size CHAR(1),
	DateWhenOrderWasMade DATETIME2,
	CONSTRAINT PK_CLUSTERED_PIZZA PRIMARY KEY(PizzaID,ClientID),
	CONSTRAINT FK_PIZZAID FOREIGN KEY(PizzaID) REFERENCES Pizzas(PizzaID),
	CONSTRAINT FK_CLIENTID FOREIGN KEY(ClientID) REFERENCES Clients(ClientID)
	)

	ALTER TABLE Pizza_Orders
	ADD Price DECIMAL(8,2) NOT NULL CHECK(Price>=0)

	SELECT * FROM Pizzas
	SELECT * FROM Clients

	INSERT INTO Pizza_Orders(PizzaID,ClientID,Quantity,Size,DateWhenOrderWasMade,Price)	
	VALUES
		(1,2,3,'S',GETDATE(),10),
		(2,1,2,'S',GETDATE(),20),
		(3,3,1,'S',GETDATE(),30),
		(4,1,2,'B',GETDATE(),10),
		(4,2,2,'S',GETDATE(),5)



		SELECT ClientName,Pizza_Type,Size
		FROM Pizza_Orders
		JOIN Clients ON Clients.ClientID = Pizza_Orders.ClientID
		JOIN Pizzas ON Pizzas.PizzaID = Pizza_Orders.PizzaID
		WHERE Size LIKE('S')
		ORDER BY Clients.ClientName DESC



		SELECT DISTINCT ClientName as ClientName,dbo.udf_GetNumberOrdersMadeByClient(Pizza_Orders.ClientID) as NumberOrdersMade
		FROM Pizza_Orders
		RIGHT JOIN Clients ON Clients.ClientID = Pizza_Orders.ClientID
	
		SELECT PizzaType,TimesItWasSold
		FROM
		(SELECT DISTINCT Pizza_Type AS PizzaType,dbo.udf_GetSumOfPizzaSales(Pizzas.PizzaID) as ProfitMadeByPizza,dbo.udf_GetNumberOfTimesAPizzaWasOrdered(Pizzas.PizzaID) as TimesItWasSold
		FROM Pizza_Orders
		RIGHT JOIN Pizzas ON Pizzas.PizzaID = Pizza_Orders.PizzaID
		) as tableWithPizzaInfo
		WHERE TimesItWasSold>1

		GO
		CREATE OR ALTER FUNCTION udf_GetNumberOrdersMadeByClient(@ClientID INT)
		RETURNS INT
		AS
		BEGIN

		DECLARE @NumberOrdersMadeByClientVar INT;

		SET @NumberOrdersMadeByClientVar = 
		(
		SELECT COUNT(*) as CountOfOrders
		FROM Pizza_Orders
		WHERE ClientID = @ClientID
		) 

		RETURN @NumberOrdersMadeByClientVar 
		END



		GO
		CREATE FUNCTION udf_GetSumOfPizzaSales(@PizzaID INT)
		RETURNS DECIMAL(8,2)
		AS
		BEGIN

		RETURN
		(
		SELECT SUM(Price)
		FROM Pizza_Orders
		GROUP BY PizzaID
		HAVING PizzaID = @PizzaID
		)
		END


		GO
		CREATE OR ALTER FUNCTION udf_GetNumberOfTimesAPizzaWasOrdered(@Pizza INT)
		RETURNS INT
		AS
		BEGIN
		
		RETURN
		(SELECT COUNT(*)
		FROM Pizza_Orders
		GROUP BY PizzaID
		HAVING PizzaID = @Pizza
		)
	 
		END

