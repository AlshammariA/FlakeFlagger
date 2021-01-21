@Test public void addExistingChildInBranch(){
  addNodes(null,"/root","/root/child1");
  assertNodesExist(null,"/root","/root/child1");
  String branchRev=mk.branch(null);
  branchRev=addNodes(branchRev,"/root/child2");
  assertNodesExist(branchRev,"/root/child1","/root/child2");
  try {
    addNodes(branchRev,"/root/child1");
    fail("Should not be able to add the same root node twice");
  }
 catch (  Exception expected) {
  }
}
