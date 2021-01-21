@Test public void rebaseAddExistingConflictingNode(){
  mk.commit("","+\"/x\":{}",null,null);
  String branch=mk.branch(null);
  branch=mk.commit("","+\"/x/a\":{\"foo\":true}",branch,null);
  mk.commit("","+\"/x/a\":{\"foo\":false,\"b\":{}}",null,null);
  branch=mk.rebase(branch,null);
  assertTrue(mk.nodeExists("/x/a/b",branch));
  String branchNode=mk.getNodes("/x",branch,100,0,-1,null);
  assertTrue(branchNode.contains(":conflict"));
}
