@Test public void rebaseChangeProperty(){
  mk.commit("","+\"/x\":{\"y\":{\"p\":42}}",null,null);
  String branch=mk.branch(null);
  branch=mk.commit("","^\"/x/y/p\":41",branch,null);
  String trunk=mk.commit("","^\"/x/y/q\":99",null,null);
  String rebased=mk.rebase(branch,null);
  String branchNode=mk.getNodes("/x/y",branch,0,0,-1,null);
  assertTrue(branchNode.contains("\"p\":41"));
  assertFalse(branchNode.contains("\"q\":99"));
  String rebasedNode=mk.getNodes("/x/y",rebased,0,0,-1,null);
  assertTrue(rebasedNode.contains("\"p\":41"));
  assertTrue(rebasedNode.contains("\"q\":99"));
  String trunkNode=mk.getNodes("/x/y",null,0,0,-1,null);
  assertTrue(trunkNode.contains("\"p\":42"));
  assertTrue(trunkNode.contains("\"q\":99"));
}
