@Test public void addExistingRootInBranch(){
  addNodes(null,"/root");
  assertNodesExist(null,"/root");
  String branchRev=mk.branch(null);
  try {
    addNodes(branchRev,"/root");
    fail("Should not be able to add the same root node twice");
  }
 catch (  Exception expected) {
  }
}
