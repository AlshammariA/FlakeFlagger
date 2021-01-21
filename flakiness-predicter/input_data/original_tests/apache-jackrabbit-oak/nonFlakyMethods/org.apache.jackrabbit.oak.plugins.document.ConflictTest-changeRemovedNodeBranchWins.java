@Test public void changeRemovedNodeBranchWins(){
  String rev=mk.commit("/","+\"foo\":{}",null,null);
  String branchRev=mk.branch(rev);
  branchRev=mk.commit("/","-\"foo\"",branchRev,null);
  mk.merge(branchRev,null);
  try {
    mk.commit("/foo","^\"prop\":\"value\"",rev,null);
    fail("Must fail with conflict for changeRemovedNode");
  }
 catch (  MicroKernelException e) {
  }
}
