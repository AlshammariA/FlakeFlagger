@Test public void removeChangedNodeBranchWins(){
  String rev=mk.commit("/","+\"foo\":{}",null,null);
  String branchRev=mk.branch(rev);
  branchRev=mk.commit("/foo","^\"prop\":\"value\"",branchRev,null);
  mk.merge(branchRev,null);
  try {
    mk.commit("/","-\"foo\"",rev,null);
    fail("Must fail with conflict for removeChangedNode");
  }
 catch (  MicroKernelException e) {
  }
}
