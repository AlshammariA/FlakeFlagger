@Test public void removeRemovedNodeBranchLoses1(){
  String rev=mk.commit("/","+\"foo\":{}",null,null);
  String branchRev=mk.branch(rev);
  branchRev=mk.commit("/","-\"foo\"",branchRev,null);
  mk.commit("/","-\"foo\"",rev,null);
  try {
    mk.merge(branchRev,null);
    fail("Must fail with conflict for removeRemovedNode");
  }
 catch (  MicroKernelException e) {
  }
}
