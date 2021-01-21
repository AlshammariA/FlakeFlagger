@Test public void changeRemovedNodeBranchLoses2(){
  String rev=mk.commit("/","+\"foo\":{}",null,null);
  String branchRev=mk.branch(rev);
  mk.commit("/foo","^\"prop\":\"value\"",rev,null);
  branchRev=mk.commit("/","-\"foo\"",branchRev,null);
  try {
    mk.merge(branchRev,null);
    fail("Must fail with conflict for changeRemovedNode");
  }
 catch (  MicroKernelException e) {
  }
}
