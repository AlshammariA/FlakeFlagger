@Test public void oneBranchAddedChildren2(){
  addNodes(null,"/trunk","/trunk/child1");
  assertNodesExist(null,"/trunk","/trunk/child1");
  String branchRev=mk.branch(null);
  branchRev=addNodes(branchRev,"/trunk/child1/child2");
  assertNodesExist(branchRev,"/trunk","/trunk/child1");
  assertNodesExist(branchRev,"/trunk/child1/child2");
  assertNodesNotExist(null,"/trunk/child1/child2");
  addNodes(null,"/trunk/child3");
  assertNodesExist(null,"/trunk/child3");
  assertNodesNotExist(branchRev,"/trunk/child3");
  mk.merge(branchRev,"");
  assertNodesExist(null,"/trunk","/trunk/child1","/trunk/child1/child2","/trunk/child3");
}
