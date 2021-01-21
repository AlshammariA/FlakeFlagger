@Test public void join() throws RepositoryException {
  Source left=f.selector("nodeTypeName","selectorName");
  Source right=f.selector("nodeTypeName2","selectorName2");
  ChildNodeJoinCondition jc=f.childNodeJoinCondition("childSelectorName","parentSelectorName");
  Join j=f.join(left,right,QueryObjectModelConstants.JCR_JOIN_TYPE_INNER,jc);
  assertEquals(left,j.getLeft());
  assertEquals(right,j.getRight());
  assertEquals(QueryObjectModelConstants.JCR_JOIN_TYPE_INNER,j.getJoinType());
  assertEquals(jc,j.getJoinCondition());
  assertEquals("ISCHILDNODE([childSelectorName], [parentSelectorName])",jc.toString());
}
