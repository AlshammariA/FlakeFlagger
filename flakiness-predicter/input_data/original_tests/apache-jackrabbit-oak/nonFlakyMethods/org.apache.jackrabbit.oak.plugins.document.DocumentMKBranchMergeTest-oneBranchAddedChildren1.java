@Test public void oneBranchAddedChildren1(){
  addNodes(null,"/trunk","/trunk/child1");
  assertNodesExist(null,"/trunk","/trunk/child1");
  String branchRev=mk.branch(null);
  branchRev=addNodes(branchRev,"/branch1","/branch1/child1");
  assertNodesExist(branchRev,"/trunk","/trunk/child1");
  assertNodesExist(branchRev,"/branch1","/branch1/child1");
  assertNodesNotExist(null,"/branch1","/branch1/child1");
  addNodes(null,"/trunk/child2");
  assertNodesExist(null,"/trunk/child2");
  assertNodesNotExist(branchRev,"/trunk/child2");
  mk.merge(branchRev,"");
  assertNodesExist(null,"/trunk","/trunk/child1","/trunk/child2","/branch1","/branch1/child1");
}
