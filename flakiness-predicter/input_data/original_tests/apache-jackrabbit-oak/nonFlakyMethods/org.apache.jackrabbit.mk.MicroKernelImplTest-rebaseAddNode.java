@Test public void rebaseAddNode(){
  mk.commit("","+\"/x\":{}",null,null);
  String branch=mk.branch(null);
  branch=mk.commit("","+\"/x/b\":{}",branch,null);
  String trunk=mk.commit("","+\"/x/a\":{}",null,null);
  String rebased=mk.rebase(branch,null);
  assertEquals(1,mk.getChildNodeCount("/x",null));
  assertNotNull(mk.getNodes("/x/a",null,0,0,-1,null));
  assertEquals(1,mk.getChildNodeCount("/x",branch));
  assertNotNull(mk.getNodes("/x/b",branch,0,0,-1,null));
  assertEquals(2,mk.getChildNodeCount("/x",rebased));
  assertNotNull(mk.getNodes("/x/a",rebased,0,0,-1,null));
  assertNotNull(mk.getNodes("/x/b",rebased,0,0,-1,null));
}
