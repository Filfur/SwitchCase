CREATE TABLE tWeapon
(
  [WeaponID]           INT IDENTITY(1, 1) NOT NULL,
  [Name]               NVARCHAR(255)      NULL

  CONSTRAINT PK_tWeapon PRIMARY KEY ([WeaponID])
)
GO
