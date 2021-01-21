@Test public void rebaseRemoveNode(){
  mk.commit("","+\"/x\":{\"y\":{}}",null,null);
  String branch=mk.branch(null);
  branch=mk.commit("","-\"/x/y\"",branch,null);
  String trunk=mk.commit("","+\"/x/a\":{}",null,null);
  String rebased=mk.rebase(branch,null);
  assertEquals(2,mk.getChildNodeCount("/x",null));
  assertNotNull(mk.getNodes("/x/a",null,0,0,-1,null));
  assertNotNull(mk.getNodes("/x/y",null,0,0,-1,null));
  assertEquals(0,mk.getChildNodeCount("/x",branch));
  assertEquals(1,mk.getChildNodeCount("/x",rebased));
  assertNotNull(mk.getNodes("/x/a",rebased,0,0,-1,null));
}
