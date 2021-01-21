@Test public void oneBranchChangedProperties(){
  addNodes(null,"/trunk","/trunk/child1");
  setProp(null,"/trunk/child1/prop1","value1");
  setProp(null,"/trunk/child1/prop2","value2");
  assertNodesExist(null,"/trunk","/trunk/child1");
  assertPropExists(null,"/trunk/child1","prop1");
  assertPropExists(null,"/trunk/child1","prop2");
  String branchRev=mk.branch(null);
  branchRev=setProp(branchRev,"/trunk/child1/prop1","value1a");
  branchRev=setProp(branchRev,"/trunk/child1/prop2",null);
  branchRev=setProp(branchRev,"/trunk/child1/prop3","value3");
  assertPropValue(branchRev,"/trunk/child1","prop1","value1a");
  assertPropNotExists(branchRev,"/trunk/child1","prop2");
  assertPropValue(branchRev,"/trunk/child1","prop3","value3");
  assertPropValue(null,"/trunk/child1","prop1","value1");
  assertPropExists(null,"/trunk/child1","prop2");
  assertPropNotExists(null,"/trunk/child1","prop3");
  mk.merge(branchRev,"");
  assertPropValue(null,"/trunk/child1","prop1","value1a");
  assertPropNotExists(null,"/trunk/child1","prop2");
  assertPropValue(null,"/trunk/child1","prop3","value3");
}
