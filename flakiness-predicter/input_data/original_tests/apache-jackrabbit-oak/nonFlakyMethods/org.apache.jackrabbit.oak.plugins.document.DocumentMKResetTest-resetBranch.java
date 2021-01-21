@Test public void resetBranch(){
  String branch=mk.branch(null);
  branch=addNodes(branch,"/foo");
  String head=addNodes(branch,"/bar");
  assertNodesExist(head,"/bar");
  head=mk.reset(head,branch);
  assertNodesNotExist(head,"/bar");
}
