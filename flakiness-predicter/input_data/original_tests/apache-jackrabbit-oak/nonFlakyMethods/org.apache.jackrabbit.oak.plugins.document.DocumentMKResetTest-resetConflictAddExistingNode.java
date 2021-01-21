@Test public void resetConflictAddExistingNode(){
  String b0=mk.branch(null);
  addNodes(null,"/foo");
  String b1=addNodes(b0,"/bar");
  String b2=addNodes(b1,"/foo");
  try {
    mk.merge(b2,null);
    fail("merge with conflict must fail");
  }
 catch (  MicroKernelException e) {
  }
  String b3=mk.reset(b2,b1);
  String rev=mk.merge(b3,null);
  assertNodesExist(rev,"/foo","/bar");
}
