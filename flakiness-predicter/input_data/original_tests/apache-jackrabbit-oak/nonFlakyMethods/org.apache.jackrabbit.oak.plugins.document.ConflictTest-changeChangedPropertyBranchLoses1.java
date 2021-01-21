@Test public void changeChangedPropertyBranchLoses1(){
  String rev=mk.commit("/","+\"foo\":{\"prop\":\"value\"}",null,null);
  String branchRev=mk.branch(rev);
  branchRev=mk.commit("/foo","^\"prop\":\"bar\"",branchRev,null);
  mk.commit("/foo","^\"prop\":\"baz\"",rev,null);
  try {
    mk.merge(branchRev,null);
    fail("Must fail with conflict for changeChangedProperty");
  }
 catch (  MicroKernelException e) {
  }
}
