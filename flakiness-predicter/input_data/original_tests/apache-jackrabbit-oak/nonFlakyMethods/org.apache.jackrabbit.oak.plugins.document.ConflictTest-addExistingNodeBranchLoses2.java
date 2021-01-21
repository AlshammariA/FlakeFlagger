@Test public void addExistingNodeBranchLoses2(){
  String rev=mk.commit("/","+\"foo\":{}",null,null);
  String branchRev=mk.branch(rev);
  mk.commit("/foo","+\"bar\":{}",rev,null);
  branchRev=mk.commit("/foo","+\"bar\":{}",branchRev,null);
  try {
    mk.merge(branchRev,null);
    fail("Must fail with conflict for addExistingNode");
  }
 catch (  MicroKernelException e) {
  }
}
