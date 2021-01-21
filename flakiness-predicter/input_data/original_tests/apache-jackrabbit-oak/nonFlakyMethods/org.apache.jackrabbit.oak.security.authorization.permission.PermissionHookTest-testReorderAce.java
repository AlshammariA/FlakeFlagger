@Test public void testReorderAce() throws Exception {
  Tree entry=getEntry(testPrincipalName,testPath,0);
  assertIndex(0,entry);
  Tree aclTree=root.getTree(testPath + "/rep:policy");
  aclTree.getChildren().iterator().next().orderBefore(null);
  root.commit();
  entry=getEntry(testPrincipalName,testPath,1);
  assertIndex(1,entry);
}
