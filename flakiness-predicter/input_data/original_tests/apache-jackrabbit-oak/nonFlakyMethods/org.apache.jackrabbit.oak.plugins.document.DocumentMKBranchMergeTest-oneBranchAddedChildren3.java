@Test public void oneBranchAddedChildren3(){
  addNodes(null,"/root","/root/child1");
  assertNodesExist(null,"/root","/root/child1");
  String branchRev=mk.branch(null);
  addNodes(null,"/root/child2");
  assertNodesExist(null,"/root","/root/child1","/root/child2");
  assertNodesExist(branchRev,"/root","/root/child1");
  assertNodesNotExist(branchRev,"/root/child2");
  branchRev=addNodes(branchRev,"/root/child1/child3","/root/child4");
  assertNodesExist(branchRev,"/root","/root/child1","/root/child1/child3","/root/child4");
  assertNodesNotExist(branchRev,"/root/child2");
  assertNodesExist(null,"/root","/root/child1","/root/child2");
  assertNodesNotExist(null,"/root/child1/child3","/root/child4");
  mk.merge(branchRev,"");
  assertNodesExist(null,"/root","/root/child1","/root/child2","/root/child1/child3","/root/child4");
}
