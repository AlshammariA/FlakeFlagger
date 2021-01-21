@Test public void mergeRebased(){
  mk.commit("","+\"/x\":{\"y\":{}}",null,null);
  String branch=mk.branch(null);
  String trunk=mk.commit("","^\"/x/p\":42",null,null);
  branch=mk.commit("","^\"/x/q\":43",branch,null);
  branch=mk.rebase(branch,null);
  String branchNode=mk.getNodes("/x",branch,0,0,-1,null);
  assertTrue(branchNode.contains("\"p\":42"));
  assertTrue(branchNode.contains("\"q\":43"));
  mk.merge(branch,null);
  String trunkNode=mk.getNodes("/x",branch,0,0,-1,null);
  assertTrue(trunkNode.contains("\"p\":42"));
  assertTrue(trunkNode.contains("\"q\":43"));
}
