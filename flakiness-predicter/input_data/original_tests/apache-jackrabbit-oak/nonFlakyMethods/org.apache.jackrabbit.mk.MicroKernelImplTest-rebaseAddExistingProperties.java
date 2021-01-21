@Test public void rebaseAddExistingProperties(){
  mk.commit("","+\"/x\":{\"y\":{}}",null,null);
  String branch=mk.branch(null);
  branch=mk.commit("","^\"/x/y/p\":42 ^\"/x/y/q\":42",branch,null);
  mk.commit("","^\"/x/y/p\":99 ^\"/x/y/q\":99",null,null);
  branch=mk.rebase(branch,null);
  String branchNode=mk.getNodes("/x/y",branch,0,0,-1,null);
  assertTrue(branchNode.contains("\"p\":99"));
  String conflict=mk.getNodes("/x/y/:conflict",branch,100,0,-1,null);
  assertTrue(conflict,conflict.equals("{\":childNodeCount\":1,\"addExistingProperty\":{\"q\":42,\"p\":42,\":childNodeCount\":0}}") || conflict.equals("{\":childNodeCount\":1,\"addExistingProperty\":{\"p\":42,\"q\":42,\":childNodeCount\":0}}"));
}
