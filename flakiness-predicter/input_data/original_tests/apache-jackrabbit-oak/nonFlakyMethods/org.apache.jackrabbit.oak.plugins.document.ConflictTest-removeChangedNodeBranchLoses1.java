@Test public void removeChangedNodeBranchLoses1(){
  String rev=mk.commit("/","+\"foo\":{}",null,null);
  String branchRev=mk.branch(rev);
  branchRev=mk.commit("/foo","^\"prop\":\"value\"",branchRev,null);
  mk.commit("/","-\"foo\"",rev,null);
  try {
    mk.merge(branchRev,null);
    fail("Must fail with conflict for removeChangedNode");
  }
 catch (  MicroKernelException e) {
  }
}
