CREATE TABLE loger.tErrorLog
(
	ErrorLogID      BIGINT IDENTITY   NOT NULL,
	ErrorLogDate    DATETIME2(3)      NOT NULL,
	ErrorNumber     INT               NOT NULL,
	ErrorSeverity   TINYINT           NOT NULL,
	ErrorState      TINYINT           NOT NULL,
	ErrorProcedure  NVARCHAR(50)      NULL,
	ErrorLine       INT               NOT NULL,
	ErrorMessage    NVARCHAR(1000)    NOT NULL,
	CONSTRAINT PK_tErrorLog PRIMARY KEY CLUSTERED(ErrorLogID)
)
GO
ALTER TABLE loger.tErrorLog
ADD CONSTRAINT DF_tErrorLog_ErrorLogDate DEFAULT getutcdate() FOR ErrorLogDate
GO
