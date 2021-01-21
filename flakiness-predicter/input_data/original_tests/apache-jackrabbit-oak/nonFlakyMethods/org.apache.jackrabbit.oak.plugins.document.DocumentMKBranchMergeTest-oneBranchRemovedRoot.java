@Test public void oneBranchRemovedRoot(){
  addNodes(null,"/trunk","/trunk/child1");
  assertNodesExist(null,"/trunk","/trunk/child1");
  String branchRev=mk.branch(null);
  branchRev=removeNodes(branchRev,"/trunk");
  assertNodesNotExist(branchRev,"/trunk","/trunk/child1");
  assertNodesExist(null,"/trunk","/trunk/child1");
  mk.merge(branchRev,"");
  assertNodesNotExist(null,"/trunk","/trunk/child1");
}
