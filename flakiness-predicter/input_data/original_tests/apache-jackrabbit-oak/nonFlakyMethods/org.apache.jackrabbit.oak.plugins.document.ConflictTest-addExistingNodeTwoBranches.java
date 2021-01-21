@Test public void addExistingNodeTwoBranches(){
  String rev=mk.commit("/","+\"foo\":{}",null,null);
  String branchRev1=mk.branch(rev);
  branchRev1=mk.commit("/foo","+\"bar\":{}",branchRev1,null);
  String branchRev2=mk.branch(rev);
  branchRev2=mk.commit("/foo","+\"bar\":{}",branchRev2,null);
  mk.merge(branchRev2,null);
  try {
    mk.merge(branchRev1,null);
    fail("Must fail with conflict for addExistingNode");
  }
 catch (  MicroKernelException e) {
  }
}
