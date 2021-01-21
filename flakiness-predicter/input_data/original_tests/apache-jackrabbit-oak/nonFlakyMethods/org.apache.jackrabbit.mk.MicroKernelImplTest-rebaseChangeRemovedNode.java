@Test public void rebaseChangeRemovedNode(){
  mk.commit("","+\"/x\":{\"y\":{}}",null,null);
  String branch=mk.branch(null);
  branch=mk.commit("","^\"/x/p\":42",branch,null);
  mk.commit("","-\"/x\"",null,null);
  branch=mk.rebase(branch,null);
  assertFalse(mk.nodeExists("/x",branch));
  String conflict=mk.getNodes("/:conflict",branch,100,0,-1,null);
  assertEquals("{\":childNodeCount\":1,\"changeDeletedNode\":{\":childNodeCount\":1,\"x\":{\"p\":42,\"" + ":childNodeCount\":1,\"y\":{\":childNodeCount\":0}}}}",conflict);
}
