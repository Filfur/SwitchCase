CREATE TABLE tSkin
(
  [SkinID]             INT IDENTITY(1, 1) NOT NULL,
  [SkinName]           NVARCHAR(255)      NULL,
  [WeaponName]         NVARCHAR(255)      NULL,  
  [ImageLink]          NVARCHAR(255)      NULL,
  [Price]              MONEY              NULL,
  [DropRate]           FLOAT(4)           NULL,
  [Rarity]             NVARCHAR(255)      NULL,
  [RarityID]           INT                NULL,
  [WeaponID]           INT                NULL,
  [CaseID]             INT                NULL

  CONSTRAINT PK_tSkin PRIMARY KEY ([SkinID])
)
GO
/*FK*/
ALTER TABLE tSkin
ADD CONSTRAINT [FK_tSkin_tWeapon] FOREIGN KEY([WeaponID]) REFERENCES [tWeapon](WeaponID)
GO
ALTER TABLE tSkin
ADD CONSTRAINT [FK_tSkin_tCase] FOREIGN KEY([CaseID]) REFERENCES [tCase](CaseID)
GO
ALTER TABLE tSkin
ADD CONSTRAINT [FK_tSkin_tRarity] FOREIGN KEY([RarityID]) REFERENCES [tRarity](RarityID)
GO
