@Test public void twoBranchChangedPropertiesWithConflict(){
  addNodes(null,"/trunk");
  setProp(null,"/trunk/prop1","value1");
  setProp(null,"/trunk/prop2","value1");
  assertPropExists(null,"/trunk","prop1");
  assertPropExists(null,"/trunk","prop2");
  String branchRev1=mk.branch(null);
  branchRev1=setProp(branchRev1,"/trunk/prop1","value1-b1");
  assertPropValue(branchRev1,"/trunk","prop1","value1-b1");
  String branchRev2=mk.branch(null);
  branchRev2=setProp(branchRev2,"/trunk/prop2","value1-b2");
  assertPropValue(branchRev2,"/trunk","prop2","value1-b2");
  mk.commit("/","^\"trunk/prop1\":\"value1-modified\"" + "^\"trunk/prop2\":\"value1-modified\"",null,null);
  try {
    mk.merge(branchRev1,"");
    fail("Expected: Concurrent modification exception");
  }
 catch (  Exception expected) {
  }
  try {
    mk.merge(branchRev2,"");
    fail("Expected: Concurrent modification exception");
  }
 catch (  Exception expected) {
  }
}
