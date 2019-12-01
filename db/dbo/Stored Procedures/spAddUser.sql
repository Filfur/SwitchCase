CREATE PROCEDURE spAddUser
  @inName          NVARCHAR(255),
  @inEmail         NVARCHAR(255),       
  @inPassword      NVARCHAR(10),
  @inTradeLink     NVARCHAR(255),
  @inUserID        INT

AS
BEGIN

SET NOCOUNT ON

  DECLARE
    @msg  NVARCHAR(2048) = ''

  BEGIN TRY

    IF EXISTS (SELECT 1 FROM tUser WHERE Name = @inName OR Email = @inEmail OR TradeLink = @inTradeLink)
    BEGIN
      SET @msg = 'User with such credentials already exists'
      ;THROW 50000, @msg, 1
    END

    BEGIN TRANSACTION

      INSERT INTO tUser (Name, Email, Password, TradeLink)
      VALUES(@inName, @inEmail, @inPassword, @inTradeLink)

    COMMIT TRANSACTION

  BEGIN CATCH
    IF @@trancount > 0 ROLLBACK TRANSACTION;
    DECLARE @ProcName SYSNAME = object_name(@@procid)
    EXEC log.spErrorLog @ErrorProc = @ProcName
    ;THROW
  END CATCH
  
GO
GRANT EXEC ON spAddUser TO AppRole
GO