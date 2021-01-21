@Test public void resetTrunk(){
  String rev=addNodes(null,"/foo");
  try {
    mk.reset(rev,rev);
    fail("MicroKernelException expected");
  }
 catch (  MicroKernelException expected) {
  }
}
