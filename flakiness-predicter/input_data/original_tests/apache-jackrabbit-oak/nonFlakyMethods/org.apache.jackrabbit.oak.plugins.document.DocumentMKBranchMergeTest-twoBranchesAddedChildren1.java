@Test public void twoBranchesAddedChildren1(){
  addNodes(null,"/trunk","/trunk/child1");
  assertNodesExist(null,"/trunk","/trunk/child1");
  String branchRev1=mk.branch(null);
  String branchRev2=mk.branch(null);
  branchRev1=addNodes(branchRev1,"/branch1","/branch1/child1");
  branchRev2=addNodes(branchRev2,"/branch2","/branch2/child2");
  assertNodesExist(branchRev1,"/trunk","/trunk/child1");
  assertNodesExist(branchRev2,"/trunk","/trunk/child1");
  assertNodesExist(branchRev1,"/branch1/child1");
  assertNodesNotExist(branchRev1,"/branch2/child2");
  assertNodesExist(branchRev2,"/branch2/child2");
  assertNodesNotExist(branchRev2,"/branch1/child1");
  assertNodesNotExist(null,"/branch1/child1","/branch2/child2");
  addNodes(null,"/trunk/child2");
  assertNodesExist(null,"/trunk/child2");
  assertNodesNotExist(branchRev1,"/trunk/child2");
  assertNodesNotExist(branchRev2,"/trunk/child2");
  mk.merge(branchRev1,"");
  assertNodesExist(null,"/trunk","/branch1","/branch1/child1");
  assertNodesNotExist(null,"/branch2","/branch2/child2");
  mk.merge(branchRev2,"");
  assertNodesExist(null,"/trunk","/branch1","/branch1/child1","/branch2","/branch2/child2");
}
