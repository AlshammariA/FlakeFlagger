@Test public void changeRemovedPropertyBranchLoses2(){
  String rev=mk.commit("/","+\"foo\":{\"prop\":\"value\"}",null,null);
  String branchRev=mk.branch(rev);
  mk.commit("/foo","^\"prop\":\"bar\"",rev,null);
  branchRev=mk.commit("/foo","^\"prop\":null",branchRev,null);
  try {
    mk.merge(branchRev,null);
    fail("Must fail with conflict for changeRemovedProperty");
  }
 catch (  MicroKernelException e) {
  }
}
