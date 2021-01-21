@Test public void rebaseAddProperty(){
  mk.commit("","+\"/x\":{\"y\":{}}",null,null);
  String branch=mk.branch(null);
  branch=mk.commit("","^\"/x/y/p\":42",branch,null);
  String trunk=mk.commit("","^\"/x/y/q\":99",null,null);
  String rebased=mk.rebase(branch,null);
  String branchNode=mk.getNodes("/x/y",branch,0,0,-1,null);
  assertTrue(branchNode.contains("\"p\":42"));
  assertFalse(branchNode.contains("\"q\":99"));
  String rebasedNode=mk.getNodes("/x/y",rebased,0,0,-1,null);
  assertTrue(rebasedNode.contains("\"p\":42"));
  assertTrue(rebasedNode.contains("\"q\":99"));
  String trunkNode=mk.getNodes("/x/y",null,0,0,-1,null);
  assertFalse(trunkNode.contains("\"p\":42"));
  assertTrue(trunkNode.contains("\"q\":99"));
}
