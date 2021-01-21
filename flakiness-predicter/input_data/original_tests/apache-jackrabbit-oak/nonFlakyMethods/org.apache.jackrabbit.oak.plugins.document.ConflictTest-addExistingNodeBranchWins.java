@Test public void addExistingNodeBranchWins(){
  String rev=mk.commit("/","+\"foo\":{}",null,null);
  String branchRev=mk.branch(rev);
  branchRev=mk.commit("/foo","+\"bar\":{}",branchRev,null);
  mk.merge(branchRev,null);
  try {
    mk.commit("/foo","+\"bar\":{}",rev,null);
    fail("Must fail with conflict for addExistingNode");
  }
 catch (  MicroKernelException e) {
  }
}
