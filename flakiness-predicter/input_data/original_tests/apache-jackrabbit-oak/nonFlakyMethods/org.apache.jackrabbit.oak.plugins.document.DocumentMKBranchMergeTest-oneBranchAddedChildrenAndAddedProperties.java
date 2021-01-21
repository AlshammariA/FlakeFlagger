@Test public void oneBranchAddedChildrenAndAddedProperties(){
  addNodes(null,"/trunk","/trunk/child1");
  setProp(null,"/trunk/child1/prop1","value1");
  setProp(null,"/trunk/child1/prop2","value2");
  assertNodesExist(null,"/trunk","/trunk/child1");
  assertPropExists(null,"/trunk/child1","prop1");
  assertPropExists(null,"/trunk/child1","prop2");
  String branchRev=mk.branch(null);
  branchRev=addNodes(branchRev,"/branch1","/branch1/child1");
  branchRev=setProp(branchRev,"/branch1/child1/prop1","value1");
  branchRev=setProp(branchRev,"/branch1/child1/prop2","value2");
  assertNodesExist(branchRev,"/trunk","/trunk/child1");
  assertPropExists(branchRev,"/trunk/child1","prop1");
  assertPropExists(branchRev,"/trunk/child1","prop2");
  assertNodesExist(branchRev,"/branch1","/branch1/child1");
  assertPropExists(branchRev,"/branch1/child1","prop1");
  assertPropExists(branchRev,"/branch1/child1","prop2");
  assertNodesNotExist(null,"/branch1","/branch1/child1");
  assertPropNotExists(null,"/branch1/child1","prop1");
  assertPropNotExists(null,"/branch1/child1","prop2");
  mk.merge(branchRev,"");
  assertNodesExist(null,"/trunk","/trunk/child1");
  assertPropExists(null,"/trunk/child1","prop1");
  assertPropExists(null,"/trunk/child1","prop2");
  assertNodesExist(null,"/branch1","/branch1/child1");
  assertPropExists(null,"/branch1/child1","prop1");
  assertPropExists(null,"/branch1/child1","prop2");
}
