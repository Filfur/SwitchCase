CREATE PROCEDURE spGetCaseList
AS
BEGIN

SET NOCOUNT ON

  SELECT 
    c.CaseID,
    c.Name,
    c.ImageLink,
    c.Price
  FROM tCase c  
GO
GRANT EXEC ON spGetCaseList TO AppRole
GO