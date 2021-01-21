@Test public void removeChangedPropertyBranchWins(){
  String rev=mk.commit("/","+\"foo\":{\"prop\":\"value\"}",null,null);
  String branchRev=mk.branch(rev);
  branchRev=mk.commit("/foo","^\"prop\":\"bar\"",branchRev,null);
  mk.merge(branchRev,null);
  try {
    mk.commit("/foo","^\"prop\":null",rev,null);
    fail("Must fail with conflict for removeChangedProperty");
  }
 catch (  MicroKernelException e) {
  }
}
