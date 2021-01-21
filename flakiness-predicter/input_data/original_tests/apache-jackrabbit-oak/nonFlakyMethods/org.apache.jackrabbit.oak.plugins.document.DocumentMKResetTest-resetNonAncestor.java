@Test public void resetNonAncestor(){
  String rev=mk.getHeadRevision();
  addNodes(null,"/foo");
  String branch=mk.branch(null);
  branch=addNodes(branch,"/bar");
  try {
    mk.reset(branch,rev);
    fail("MicroKernelException expected");
  }
 catch (  MicroKernelException expected) {
  }
}
