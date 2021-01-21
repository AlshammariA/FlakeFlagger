@Test public void removeRemovedPropertyBranchLoses1(){
  String rev=mk.commit("/","+\"foo\":{\"prop\":\"value\"}",null,null);
  String branchRev=mk.branch(rev);
  branchRev=mk.commit("/foo","^\"prop\":null",branchRev,null);
  mk.commit("/foo","^\"prop\":null",rev,null);
  try {
    mk.merge(branchRev,null);
    fail("Must fail with conflict for removeRemovedProperty");
  }
 catch (  MicroKernelException e) {
  }
}
