@Test public void removeChangedPropertyBranchLoses1(){
  String rev=mk.commit("/","+\"foo\":{\"prop\":\"value\"}",null,null);
  String branchRev=mk.branch(rev);
  branchRev=mk.commit("/foo","^\"prop\":\"bar\"",branchRev,null);
  mk.commit("/foo","^\"prop\":null",rev,null);
  try {
    mk.merge(branchRev,null);
    fail("Must fail with conflict for removeChangedProperty");
  }
 catch (  MicroKernelException e) {
  }
}
