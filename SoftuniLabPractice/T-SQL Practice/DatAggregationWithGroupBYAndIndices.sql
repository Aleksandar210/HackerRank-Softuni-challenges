
--Longest Magic Wand
SELECT TOP 1  MAX(MagicWandSize) AS [Longest Magic Land Size]
FROM WizzardDeposits
GROUP BY FirstName,LastName
ORDER BY [Longest Magic Land Size] DESC

--Longest land per Deposits group
SELECT * FROM WizzardDeposits

SELECT DepositGroup,MAX([MagicWandSize])
FROM WizzardDeposits
GROUP BY DepositGroup

--SELECT 2 DEPOSIT GROUPS WITH THE SMALLEST WAND SIZE
SELECT TOP 2  DepositGroup,AverageWandSizePerGroup
FROM
(SELECT DepositGroup AS DepositGroup,AVG([MagicWandSize]) AS AverageWandSizePerGroup
FROM WizzardDeposits
GROUP BY DepositGroup) AS AverageSizesPerGroups
ORDER BY AverageWandSizePerGroup ASC

--Select groups and their sum
SELECT DepositGroup,SUM(DepositAmount)
FROM WizzardDeposits
GROUP BY DepositGroup

--Deposit sums only for the oivander
SELECT DepositGroup,SUM(DepositAmount)
FROM WizzardDeposits
WHERE MagicWandCreator LIKE('Ollivander family')
GROUP BY DepositGroup

--Filter out those with deposit 150000
--Deposit sums only for the oivander
SELECT DepositGroup,SUM(DepositAmount) AS DepositSum
FROM WizzardDeposits
WHERE MagicWandCreator LIKE('Ollivander family') AND DepositAmount<150000
GROUP BY DepositGroup 

SELECT [Group],WandCreator,DepositCharge
FROM
(SELECT DepositGroup AS [Group],MagicWandCreator AS WandCreator,DepositCharge AS DepositCharge,
DENSE_RANK() OVER(PARTITION BY DepositGroup ORDER BY DepositCharge) AS DepositAmountRank
FROM WizzardDeposits) AS MinAmountInfo
WHERE DepositAmountRank =1 


--troll chest uniqu letters Count
SELECT SUBSTRING(FirstName,1,1),COUNT(*)
FROM WizzardDeposits
WHERE DepositGroup LIKE('Troll Chest')
GROUP BY SUBSTRING(FirstName,1,1)

SELECT * FROM WizzardDeposits

--Average interest
SELECT DepositGroup,AVG(DepositInterest)
FROM
(SELECT DepositGroup as DepositGroup,DepositInterest AS DepositInterest,IsDepositExpired AS DepositExpiration
FROM WizzardDeposits
WHERE DepositExpirationDate>'1985-01-01'
) AS DepositsAfter1985
GROUP BY DepositGroup
ORDER BY DepositGroup DESC

--POOR WIZZARD RICH WIZZARD TASK
SELECT SUM(DepositDifference)
FROM
(
SELECT *,ABS(FirstWizardDepositAmount-GuestWizzardDeposit) AS DepositDifference
FROM
(
SELECT Id AS WizzardId, CONCAT_WS(' ',FirstName,LastName) AS [Full Wizard Name], DepositAmount AS FirstWizardDepositAmount,
dbo.udf_GetGuestWizzardNames(Id) AS GuestWizzardNames,dbo.udf_GetGuestWizzardDepositAmount(Id) AS GuestWizzardDeposit
FROM WizzardDeposits
) AS WizzardsRankedOnAfter
) AS WizzardRankedOnAfterWithDifference


--function to return next wizzard names
GO
CREATE OR ALTER FUNCTION udf_GetGuestWizzardNames(@CurrentWizardId INT)
RETURNS VARCHAR(50)
BEGIN

IF(@CurrentWizardId = (SELECT TOP 1 Id FROM WizzardDeposits ORDER BY Id DESC))
BEGIN 
RETURN 'No Guest Wizzard Avaialable'
END

DECLARE @GuestWizzardNames VARCHAR(50);

SET @GuestWizzardNames =(SELECT CONCAT_WS(' ',FirstName,LastName) FROM WizzardDeposits WHERE Id = @CurrentWizardId+1) 

RETURN @GuestWizzardNames
END


--Function to return next wizzard deposit amount if there is such
GO 
CREATE OR ALTER FUNCTION udf_GetGuestWizzardDepositAmount(@CurrentWizardId INT)
RETURNS DECIMAL(8,2)
BEGIN

IF(@CurrentWizardId = (SELECT TOP 1 Id FROM WizzardDeposits ORDER BY Id DESC))
BEGIN 
RETURN 0
END

DECLARE @GuestWizzardDepositAmount DECIMAL(8,2);

SET @GuestWizzardDepositAmount =(SELECT DepositAmount FROM WizzardDeposits WHERE Id = @CurrentWizardId+1) 

RETURN @GuestWizzardDepositAmount

END


--CLEAR TABLE
DROP TABLE WizzardDeposits

--working on softuni table