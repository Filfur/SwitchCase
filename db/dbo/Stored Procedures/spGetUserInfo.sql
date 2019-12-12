CREATE PROCEDURE spGetUserInfo
  @inUserID        INT

AS
BEGIN

SET NOCOUNT ON

  SELECT 
    u.UserID,
    u.Name,
    u.Email,
    u.Password,
    u.TradeLink,
    u.Balance    
  FROM tUser u WHERE u.UserID = @inUserID 
  
GO
GRANT EXEC ON spGetUserInfo TO AppRole
GO