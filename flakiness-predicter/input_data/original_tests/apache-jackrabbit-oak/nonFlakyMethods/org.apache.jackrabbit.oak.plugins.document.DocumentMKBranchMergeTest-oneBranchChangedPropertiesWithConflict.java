@Test public void oneBranchChangedPropertiesWithConflict(){
  addNodes(null,"/trunk");
  setProp(null,"/trunk/prop1","value1");
  assertPropExists(null,"/trunk","prop1");
  String branchRev=mk.branch(null);
  branchRev=setProp(branchRev,"/trunk/prop1","value1a");
  assertPropValue(branchRev,"/trunk","prop1","value1a");
  setProp(null,"/trunk/prop1","value1b");
  try {
    mk.merge(branchRev,"");
    fail("Expected: Concurrent modification exception");
  }
 catch (  Exception expected) {
  }
}
