@Test public void changeChangedPropertyBranchLoses2(){
  String rev=mk.commit("/","+\"foo\":{\"prop\":\"value\"}",null,null);
  String branchRev=mk.branch(rev);
  mk.commit("/foo","^\"prop\":\"baz\"",rev,null);
  branchRev=mk.commit("/foo","^\"prop\":\"bar\"",branchRev,null);
  try {
    mk.merge(branchRev,null);
    fail("Must fail with conflict for changeChangedProperty");
  }
 catch (  MicroKernelException e) {
  }
}
