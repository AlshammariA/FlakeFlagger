@Test public void rebaseChangePropertyWithSameValue(){
  mk.commit("","+\"/x\":{\"y\":{\"p\":42}}",null,null);
  String branch=mk.branch(null);
  branch=mk.commit("","^\"/x/y/p\":99",branch,null);
  mk.commit("","^\"/x/y/p\":99",null,null);
  mk.rebase(branch,null);
  String branchNode=mk.getNodes("/x/y",branch,0,0,-1,null);
  assertTrue(branchNode.contains("\"p\":99"));
  String rebasedNode=mk.getNodes("/x/y",branch,0,0,-1,null);
  assertTrue(rebasedNode.contains("\"p\":99"));
  String trunkNode=mk.getNodes("/x/y",null,0,0,-1,null);
  assertTrue(trunkNode.contains("\"p\":99"));
}
