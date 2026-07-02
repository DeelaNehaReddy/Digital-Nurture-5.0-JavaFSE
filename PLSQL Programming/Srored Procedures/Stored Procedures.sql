CREATE TABLE Accounts (
    AccountID INT PRIMARY KEY,
    CustomerID INT,
    AccountType VARCHAR(20),
    Balance DECIMAL(10,2)
);

CREATE TABLE Employees (
    EmpID INT PRIMARY KEY,
    Name VARCHAR(50),
    Department VARCHAR(50),
    Salary DECIMAL(10,2)
);

#Scenario 1: Monthly Interest (1%)
DELIMITER $$

CREATE PROCEDURE ProcessMonthlyInterest()
BEGIN
    UPDATE Accounts
    SET Balance = Balance + (Balance * 0.01)
    WHERE AccountType = 'Savings';
END $$

DELIMITER 

CALL ProcessMonthlyInterest();

#Scenario 2: Employee Bonus by Department
DELIMITER $$

CREATE PROCEDURE UpdateEmployeeBonus(
    IN deptName VARCHAR(50),
    IN bonusPercent DECIMAL(5,2)
)
BEGIN
    UPDATE Employees
    SET Salary = Salary + (Salary * bonusPercent / 100)
    WHERE Department = deptName;
END $$

DELIMITER ;

CALL UpdateEmployeeBonus('IT', 10);

#Scenario 3: Transfer Funds Between Accounts
DELIMITER $$

CREATE PROCEDURE TransferFunds(
    IN fromAcc INT,
    IN toAcc INT,
    IN amount DECIMAL(10,2)
)
BEGIN
    DECLARE currentBalance DECIMAL(10,2);
    SELECT Balance INTO currentBalance
    FROM Accounts
    WHERE AccountID = fromAcc;
    IF currentBalance >= amount THEN
        UPDATE Accounts
        SET Balance = Balance - amount
        WHERE AccountID = fromAcc;
        UPDATE Accounts
        SET Balance = Balance + amount
        WHERE AccountID = toAcc;
        SELECT 'Transfer Successful' AS Message;
    ELSE
        SELECT 'Insufficient Balance' AS Message;
    END IF;

END $$

DELIMITER ;

CALL TransferFunds(1, 2, 500);