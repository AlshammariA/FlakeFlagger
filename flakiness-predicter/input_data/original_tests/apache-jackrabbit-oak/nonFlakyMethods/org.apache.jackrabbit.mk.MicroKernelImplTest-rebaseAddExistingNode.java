@Test public void rebaseAddExistingNode(){
  mk.commit("","+\"/x\":{}",null,null);
  String branch=mk.branch(null);
  branch=mk.commit("","+\"/x/a\":{\"foo\":true}",branch,null);
  mk.commit("","+\"/x/a\":{\"b\":{}}",null,null);
  branch=mk.rebase(branch,null);
  assertTrue(mk.nodeExists("/x/a/b",branch));
  assertFalse(mk.nodeExists("/x/a/foo",null));
  String branchNode=mk.getNodes("/x",branch,100,0,-1,null);
  assertFalse(branchNode.contains(":conflict"));
}
