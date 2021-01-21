@Test public void removeChangedPropertyTwoBranches(){
  String rev=mk.commit("/","+\"foo\":{\"prop\":\"value\"}",null,null);
  String branchRev1=mk.branch(rev);
  branchRev1=mk.commit("/foo","^\"prop\":null",branchRev1,null);
  String branchRev2=mk.branch(rev);
  branchRev2=mk.commit("/foo","^\"prop\":\"bar\"",branchRev2,null);
  mk.merge(branchRev2,null);
  try {
    mk.merge(branchRev1,null);
    fail("Must fail with conflict for removeChangedProperty");
  }
 catch (  MicroKernelException e) {
  }
}
