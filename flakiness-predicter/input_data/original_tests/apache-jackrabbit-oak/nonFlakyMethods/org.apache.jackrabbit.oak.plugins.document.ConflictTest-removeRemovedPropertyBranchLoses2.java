@Test public void removeRemovedPropertyBranchLoses2(){
  String rev=mk.commit("/","+\"foo\":{\"prop\":\"value\"}",null,null);
  String branchRev=mk.branch(rev);
  mk.commit("/foo","^\"prop\":null",rev,null);
  branchRev=mk.commit("/foo","^\"prop\":null",branchRev,null);
  try {
    mk.merge(branchRev,null);
    fail("Must fail with conflict for removeRemovedProperty");
  }
 catch (  MicroKernelException e) {
  }
}
