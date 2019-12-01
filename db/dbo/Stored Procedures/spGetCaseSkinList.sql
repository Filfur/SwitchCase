CREATE PROCEDURE spGetCaseSkinList
  @inCaseID INT 
AS
BEGIN

SET NOCOUNT ON

  SELECT 
    s.SkinID,
    s.SkinName,
    s.WeaponName,
    s.ImageLink,
    s.Price,
    s.DropRate,
    s.Rarity,
    s.WeaponID,
  FROM tSkin s WHERE CaseID = @inCaseID

  RETURN 0;
GO
GRANT EXEC ON spGetCaseSkinList TO AppRole
GO