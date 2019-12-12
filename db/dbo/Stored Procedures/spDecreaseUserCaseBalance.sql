CREATE PROCEDURE spDecreaseUserCaseBalance
  @inUserID        INT,
  @inCaseID        INT

AS
BEGIN

SET NOCOUNT 

  DECLARE
    @price MONEY = (SELECT TOP(1) Price FROM tCase WHERE CaseID = @inCaseID)

  UPDATE tUser 
  SET
    Balance = Balance - @price
  WHERE UserID = @inUserID
  
GO
GRANT EXEC ON spDecreaseUserCaseBalance TO AppRole
GO