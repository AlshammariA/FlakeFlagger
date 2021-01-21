@Test public void sameNodeJoinCondition() throws RepositoryException {
  SameNodeJoinCondition s=f.sameNodeJoinCondition("selector1Name","selector2Name","selector2Path");
  assertEquals("selector1Name",s.getSelector1Name());
  assertEquals("selector2Name",s.getSelector2Name());
  assertEquals("selector2Path",s.getSelector2Path());
  assertEquals("ISSAMENODE([selector1Name], [selector2Name], [selector2Path])",s.toString());
}
