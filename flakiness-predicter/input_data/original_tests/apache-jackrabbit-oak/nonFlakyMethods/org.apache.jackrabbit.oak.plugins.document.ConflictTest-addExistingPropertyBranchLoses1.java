@Test public void addExistingPropertyBranchLoses1(){
  String rev=mk.commit("/","+\"foo\":{}",null,null);
  String branchRev=mk.branch(rev);
  branchRev=mk.commit("/foo","^\"prop\":\"value\"",branchRev,null);
  mk.commit("/foo","^\"prop\":\"value\"",rev,null);
  try {
    mk.merge(branchRev,null);
    fail("Must fail with conflict for addExistingProperty");
  }
 catch (  MicroKernelException e) {
  }
}
