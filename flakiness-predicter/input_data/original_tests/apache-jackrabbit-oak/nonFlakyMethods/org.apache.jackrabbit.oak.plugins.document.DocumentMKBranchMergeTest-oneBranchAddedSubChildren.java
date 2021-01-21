@Test public void oneBranchAddedSubChildren(){
  addNodes(null,"/trunk","/trunk/child1","/trunk/child1/child2","/trunk/child1/child2/child3");
  assertNodesExist(null,"/trunk","/trunk/child1","/trunk/child1/child2","/trunk/child1/child2/child3");
  String branchRev=mk.branch(null);
  branchRev=addNodes(branchRev,"/branch1","/branch1/child1","/branch1/child1/child2","/branch1/child1/child2/child3");
  assertNodesExist(branchRev,"/trunk","/trunk/child1","/trunk/child1/child2","/trunk/child1/child2/child3");
  assertNodesExist(branchRev,"/branch1","/branch1/child1","/branch1/child1/child2","/branch1/child1/child2/child3");
  assertNodesNotExist(null,"/branch1","/branch1/child1","/branch1/child1/child2","/branch1/child1/child2/child3");
  addNodes(null,"/trunk/child1/child2/child3/child4","/trunk/child5");
  assertNodesExist(null,"/trunk/child1/child2/child3/child4","/trunk/child5");
  assertNodesNotExist(branchRev,"/trunk/child1/child2/child3/child4","/trunk/child5");
  mk.merge(branchRev,"");
  assertNodesExist(null,"/trunk","/trunk/child1","/trunk/child1/child2","/trunk/child1/child2/child3","/trunk/child1/child2/child3/child4");
  assertNodesExist(null,"/branch1","/branch1/child1","/branch1/child1/child2","/branch1/child1/child2/child3");
}
