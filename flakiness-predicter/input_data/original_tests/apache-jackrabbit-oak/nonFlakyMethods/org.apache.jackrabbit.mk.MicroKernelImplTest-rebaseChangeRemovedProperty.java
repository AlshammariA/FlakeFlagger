@Test public void rebaseChangeRemovedProperty(){
  mk.commit("","+\"/x\":{\"y\":{\"p\":42}}",null,null);
  String branch=mk.branch(null);
  branch=mk.commit("","^\"/x/y/p\":99",branch,null);
  mk.commit("","^\"/x/y/p\":null",null,null);
  branch=mk.rebase(branch,null);
  String branchNode=mk.getNodes("/x/y",branch,0,0,-1,null);
  assertFalse(branchNode.contains("\"p\":99"));
  String conflict=mk.getNodes("/x/y/:conflict",branch,100,0,-1,null);
  assertEquals("{\":childNodeCount\":1,\"changeDeletedProperty\":{\"p\":99,\":childNodeCount\":0}}",conflict);
}
