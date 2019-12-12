CREATE TABLE tCase
(
  [CaseID]             INT IDENTITY(1, 1) NOT NULL,
  [Name]               NVARCHAR(255)      NULL,
  [ImageLink]          NVARCHAR(255)      NULL,
  [Price]              MONEY              NULL

  CONSTRAINT PK_tCase PRIMARY KEY ([CaseID])
)
GO
