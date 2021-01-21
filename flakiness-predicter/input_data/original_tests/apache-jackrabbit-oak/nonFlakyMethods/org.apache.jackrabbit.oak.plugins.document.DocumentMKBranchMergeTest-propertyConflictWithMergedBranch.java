@Test public void propertyConflictWithMergedBranch(){
  addNodes(null,"/trunk");
  String rev=setProp(null,"/trunk/prop1","value1");
  assertPropExists(null,"/trunk","prop1");
  String branchRev=mk.branch(null);
  branchRev=setProp(branchRev,"/trunk/prop1","value1a");
  assertPropValue(branchRev,"/trunk","prop1","value1a");
  mk.merge(branchRev,"");
  assertPropValue(null,"/trunk","prop1","value1a");
  try {
    setProp(rev,"/trunk/prop1","value1b");
    fail("Expected: Concurrent modification exception");
  }
 catch (  Exception expected) {
  }
}
