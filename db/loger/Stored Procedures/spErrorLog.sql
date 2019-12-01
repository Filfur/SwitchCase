CREATE PROCEDURE loger.spErrorLog
  @ErrorProc SYSNAME = NULL
WITH ENCRYPTION
AS
BEGIN
/* INFO: Logging error information. Procedure name can be passed into, it helps with dynamic sql */
	SET NOCOUNT ON

	INSERT INTO loger.tErrorLog (ErrorNumber, ErrorSeverity, ErrorState, ErrorProcedure, ErrorLine, ErrorMessage)
	SELECT error_number(), error_severity(), error_state(), isnull(@ErrorProc, error_procedure()), error_line(), error_message()

  RETURN 0
END
GO
