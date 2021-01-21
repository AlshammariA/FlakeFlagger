@Test public void removeRemovedNodeBranchWins(){
  String rev=mk.commit("/","+\"foo\":{}",null,null);
  String branchRev=mk.branch(rev);
  branchRev=mk.commit("/","-\"foo\"",branchRev,null);
  mk.merge(branchRev,null);
  try {
    mk.commit("/","-\"foo\"",rev,null);
    fail("Must fail with conflict for removeRemovedNode");
  }
 catch (  MicroKernelException e) {
  }
}
