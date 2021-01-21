@Test public void changeRemovedNodeTwoBranches(){
  String rev=mk.commit("/","+\"foo\":{}",null,null);
  String branchRev1=mk.branch(rev);
  branchRev1=mk.commit("/foo","^\"prop\":\"value\"",branchRev1,null);
  String branchRev2=mk.branch(rev);
  branchRev2=mk.commit("/","-\"foo\"",branchRev2,null);
  mk.merge(branchRev2,null);
  try {
    mk.merge(branchRev1,null);
    fail("Must fail with conflict for changeRemovedNode");
  }
 catch (  MicroKernelException e) {
  }
}
