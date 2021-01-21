@Test public void rebaseRemoveRemovedNode(){
  mk.commit("","+\"/x\":{\"y\":{}}",null,null);
  String branch=mk.branch(null);
  branch=mk.commit("","-\"/x/y\"",branch,null);
  mk.commit("","-\"/x/y\"",null,null);
  branch=mk.rebase(branch,null);
  assertFalse(mk.nodeExists("/x/y",branch));
  String conflict=mk.getNodes("/x/:conflict",branch,100,0,-1,null);
  assertEquals("{\":childNodeCount\":1,\"deleteDeletedNode\":{\":childNodeCount\":1,\"y\":{\":childNodeCount\":0}}}",conflict);
}
