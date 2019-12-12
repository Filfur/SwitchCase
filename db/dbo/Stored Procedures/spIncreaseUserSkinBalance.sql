CREATE PROCEDURE spIncreaseUserSkinBalance
  @inUserID        INT,
  @inSkinID        INT

AS
BEGIN

SET NOCOUNT 

  DECLARE
    @price MONEY = (SELECT TOP(1) Price FROM tSkin WHERE SkinID = @inSkinID)

  UPDATE tUser 
  SET
    Balance = Balance + @price
  WHERE UserID = @inUserID
  
GO
GRANT EXEC ON spIncreaseUserSkinBalance TO AppRole
GO