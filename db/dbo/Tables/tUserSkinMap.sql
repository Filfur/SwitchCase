CREATE TABLE tUserSkinMap
(
  [UserSkinMapID]      INT IDENTITY(1, 1) NOT NULL,
  [UserID]             INT                NULL,
  [SkinID]             INT                NULL

  CONSTRAINT PK_tUserSkinMap PRIMARY KEY ([UserSkinMapID])
)
GO
/*FK*/
ALTER TABLE tUserSkinMap
ADD CONSTRAINT [FK_tUserSkinMap_tUser] FOREIGN KEY ([UserID]) REFERENCES [tUserSkinMap]([UserID])
GO

ALTER TABLE tUserSkinMap
ADD CONSTRAINT [FK_tUserSkinMap_tSkin] FOREIGN KEY ([SkinID]) REFERENCES [tUserSkinMap]([SkinID])
GO

/*UK*/
ALTER TABLE tUserSkinMap
ADD CONSTRAINT [UK_tUserSkinMap_UserID_SkinID] UNIQUE ([SkinID], [SkinID])
GO