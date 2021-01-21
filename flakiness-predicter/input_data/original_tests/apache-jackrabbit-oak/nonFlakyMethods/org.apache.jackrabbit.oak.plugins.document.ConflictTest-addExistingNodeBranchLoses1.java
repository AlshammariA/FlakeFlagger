@Test public void addExistingNodeBranchLoses1(){
  String rev=mk.commit("/","+\"foo\":{}",null,null);
  String branchRev=mk.branch(rev);
  branchRev=mk.commit("/foo","+\"bar\":{}",branchRev,null);
  mk.commit("/foo","+\"bar\":{}",rev,null);
  try {
    mk.merge(branchRev,null);
    fail("Must fail with conflict for addExistingNode");
  }
 catch (  MicroKernelException e) {
  }
}
