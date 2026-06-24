#Scenario 1: Apply 1% Discount

UPDATE Loans l
JOIN Customers c ON l.CustomerID = c.CustomerID
SET l.InterestRate = l.InterestRate - 1
WHERE c.Age > 60;

#Scenario 2: Set VIP Status
UPDATE Customers
SET IsVIP = TRUE
WHERE Balance > 10000;

#Scenario 3: Customers with Loans Due in Next 30 Days
SELECT
    c.Name,
    l.LoanID,
    l.DueDate
FROM Customers c
JOIN Loans l
ON c.CustomerID = l.CustomerID
WHERE l.DueDate BETWEEN CURDATE()
                    AND DATE_ADD(CURDATE(), INTERVAL 30 DAY);