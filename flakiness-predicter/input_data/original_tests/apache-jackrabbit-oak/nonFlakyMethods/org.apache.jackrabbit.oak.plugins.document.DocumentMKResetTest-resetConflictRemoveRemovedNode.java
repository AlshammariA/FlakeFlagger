@Test public void resetConflictRemoveRemovedNode(){
  String rev=addNodes(null,"/foo","/bar");
  String b0=mk.branch(rev);
  removeNodes(null,"/foo");
  String b1=removeNodes(b0,"/bar");
  String b2=removeNodes(b1,"/foo");
  try {
    mk.merge(b2,null);
    fail("merge with conflict must fail");
  }
 catch (  MicroKernelException e) {
  }
  String b3=mk.reset(b2,b1);
  rev=mk.merge(b3,null);
  assertNodesNotExist(rev,"/foo","/bar");
}
