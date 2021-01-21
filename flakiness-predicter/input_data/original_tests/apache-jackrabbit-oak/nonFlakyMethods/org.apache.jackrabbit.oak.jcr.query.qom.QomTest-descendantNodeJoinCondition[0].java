@Test public void descendantNodeJoinCondition() throws RepositoryException {
  DescendantNodeJoinCondition d=f.descendantNodeJoinCondition("descendantSelectorName","ancestorSelectorName");
  assertEquals("descendantSelectorName",d.getDescendantSelectorName());
  assertEquals("ancestorSelectorName",d.getAncestorSelectorName());
  assertEquals("ISDESCENDANTNODE([descendantSelectorName], [ancestorSelectorName])",d.toString());
}
