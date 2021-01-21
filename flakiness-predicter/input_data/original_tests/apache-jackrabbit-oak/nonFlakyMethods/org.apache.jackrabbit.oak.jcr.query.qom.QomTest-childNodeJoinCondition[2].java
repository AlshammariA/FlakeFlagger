@Test public void childNodeJoinCondition() throws RepositoryException {
  ChildNodeJoinCondition c=f.childNodeJoinCondition("childSelectorName","parentSelectorName");
  assertEquals("childSelectorName",c.getChildSelectorName());
  assertEquals("parentSelectorName",c.getParentSelectorName());
  assertEquals("ISCHILDNODE([childSelectorName], [parentSelectorName])",c.toString());
}
