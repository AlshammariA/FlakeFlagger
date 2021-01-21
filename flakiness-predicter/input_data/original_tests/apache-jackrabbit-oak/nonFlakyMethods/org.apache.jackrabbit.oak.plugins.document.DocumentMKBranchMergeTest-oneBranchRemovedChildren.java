@Test public void oneBranchRemovedChildren(){
  addNodes(null,"/trunk","/trunk/child1");
  assertNodesExist(null,"/trunk","/trunk/child1");
  String branchRev=mk.branch(null);
  branchRev=removeNodes(branchRev,"/trunk/child1");
  assertNodesExist(branchRev,"/trunk");
  assertNodesNotExist(branchRev,"/trunk/child1");
  assertNodesExist(null,"/trunk","/trunk/child1");
  mk.merge(branchRev,"");
  assertNodesExist(null,"/trunk");
  assertNodesNotExist(null,"/trunk/child1");
}
