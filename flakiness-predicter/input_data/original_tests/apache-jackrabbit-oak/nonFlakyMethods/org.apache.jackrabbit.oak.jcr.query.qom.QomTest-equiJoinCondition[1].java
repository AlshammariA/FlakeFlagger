@Test public void equiJoinCondition() throws RepositoryException {
  EquiJoinCondition e=f.equiJoinCondition("selector1Name","property1Name","selector2Name","property2Name");
  assertEquals("selector1Name",e.getSelector1Name());
  assertEquals("property1Name",e.getProperty1Name());
  assertEquals("selector2Name",e.getSelector2Name());
  assertEquals("property2Name",e.getProperty2Name());
  assertEquals("[selector1Name].[property1Name] = [selector2Name].[property2Name]",e.toString());
}
