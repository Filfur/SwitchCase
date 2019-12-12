CREATE TABLE tUser
(
  [UserID]             INT IDENTITY(1, 1) NOT NULL,
  [Name]               NVARCHAR(255)      NULL,
  [Email]              NVARCHAR(255)      NULL,
  [Password]           NVARCHAR(10)       NULL,
  [TradeLink]          NVARCHAR(255)      NULL,
  [Balance]            MONEY              NULL

  CONSTRAINT PK_tUser PRIMARY KEY ([UserID])
)
GO
/*IDX*/
CREATE UNIQUE NONCLUSTERED INDEX [UDX_tUser_Name] ON [tUser] (Name)
WHERE Name IS NOT NULL
GO
CREATE UNIQUE NONCLUSTERED INDEX [UDX_tUser_Email] ON [tUser] (Email)
WHERE Email IS NOT NULL
GO
CREATE UNIQUE NONCLUSTERED INDEX [UDX_tUser_TradeLink] ON [tUser] (TradeLink)
WHERE TradeLink IS NOT NULL
GO
