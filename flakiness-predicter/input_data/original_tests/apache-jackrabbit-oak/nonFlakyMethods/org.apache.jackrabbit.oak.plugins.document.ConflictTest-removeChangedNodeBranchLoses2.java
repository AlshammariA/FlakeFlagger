@Test public void removeChangedNodeBranchLoses2(){
  String rev=mk.commit("/","+\"foo\":{}",null,null);
  String branchRev=mk.branch(rev);
  mk.commit("/","-\"foo\"",rev,null);
  branchRev=mk.commit("/foo","^\"prop\":\"value\"",branchRev,null);
  try {
    mk.merge(branchRev,null);
    fail("Must fail with conflict for removeChangedNode");
  }
 catch (  MicroKernelException e) {
  }
}
