@Test public void addExistingPropertyBranchLoses2(){
  String rev=mk.commit("/","+\"foo\":{}",null,null);
  String branchRev=mk.branch(rev);
  mk.commit("/foo","^\"prop\":\"value\"",rev,null);
  branchRev=mk.commit("/foo","^\"prop\":\"value\"",branchRev,null);
  try {
    mk.merge(branchRev,null);
    fail("Must fail with conflict for addExistingProperty");
  }
 catch (  MicroKernelException e) {
  }
}
