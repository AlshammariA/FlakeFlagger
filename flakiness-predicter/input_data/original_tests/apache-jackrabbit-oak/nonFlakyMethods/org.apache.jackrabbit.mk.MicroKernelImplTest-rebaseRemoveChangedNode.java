@Test public void rebaseRemoveChangedNode(){
  mk.commit("","+\"/x\":{\"y\":{}}",null,null);
  String branch=mk.branch(null);
  branch=mk.commit("","-\"/x/y\"",branch,null);
  mk.commit("","^\"/x/y/p\":42",null,null);
  branch=mk.rebase(branch,null);
  String branchNode=mk.getNodes("/x/y",branch,0,0,-1,null);
  assertTrue(branchNode.contains("\"p\":42"));
  String conflict=mk.getNodes("/x/:conflict",branch,100,0,-1,null);
  assertEquals("{\":childNodeCount\":1,\"deleteChangedNode\":{\":childNodeCount\":1,\"y\":{\":childNodeCount\":0}}}",conflict);
}
