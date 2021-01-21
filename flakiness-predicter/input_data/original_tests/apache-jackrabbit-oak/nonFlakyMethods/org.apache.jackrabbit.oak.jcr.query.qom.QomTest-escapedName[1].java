@Test public void escapedName() throws RepositoryException {
  assertEquals("[[n]]]",f.selector("[n]",null).toString());
  assertEquals("[[s]]].[[p]]]",f.propertyValue("[s]","[p]").toString());
  assertEquals("ISSAMENODE([[s1]]], [[s2]]], [[p]]])",f.sameNodeJoinCondition("[s1]","[s2]","[p]").toString());
  assertEquals("ISSAMENODE([[s]]], [[p]]])",f.sameNode("[s]","[p]").toString());
}
