@Test public void removeRemovedPropertyBranchWins(){
  String rev=mk.commit("/","+\"foo\":{\"prop\":\"value\"}",null,null);
  String branchRev=mk.branch(rev);
  branchRev=mk.commit("/foo","^\"prop\":null",branchRev,null);
  mk.merge(branchRev,null);
  try {
    mk.commit("/foo","^\"prop\":null",rev,null);
    fail("Must fail with conflict for removeRemovedProperty");
  }
 catch (  MicroKernelException e) {
  }
}
