CREATE PROCEDURE spUpdateUserBalance
  @inUserID        INT,
  @inMoney         MONEY

AS
BEGIN

SET NOCOUNT ON

  UPDATE tUser 
  SET
    u.Balance = u.Balance + @inMoney
  WHERE u.UserID = @inUserID 
  
GO
GRANT EXEC ON spUpdateUserBalance TO AppRole
GO