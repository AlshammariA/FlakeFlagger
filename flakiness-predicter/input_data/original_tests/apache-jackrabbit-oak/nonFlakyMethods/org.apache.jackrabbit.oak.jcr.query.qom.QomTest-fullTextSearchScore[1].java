@Test public void fullTextSearchScore() throws RepositoryException {
  FullTextSearchScore x=f.fullTextSearchScore("selectorName");
  assertEquals("selectorName",x.getSelectorName());
  assertEquals("SCORE([selectorName])",x.toString());
  assertEquals("SCORE()",f.fullTextSearchScore(null).toString());
}
