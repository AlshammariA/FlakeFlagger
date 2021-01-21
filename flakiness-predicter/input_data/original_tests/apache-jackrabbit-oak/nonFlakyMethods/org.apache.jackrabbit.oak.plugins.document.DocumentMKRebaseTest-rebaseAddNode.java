@Test public void rebaseAddNode(){
  mk.commit("","+\"/x\":{}",null,null);
  String branch=mk.branch(null);
  branch=mk.commit("","+\"/x/b\":{}",branch,null);
  mk.commit("","+\"/x/a\":{}",null,null);
  String rebased=mk.rebase(branch,null);
  assertChildNodeCount("/x",null,1);
  assertNotNull(mk.getNodes("/x/a",null,0,0,-1,null));
  assertChildNodeCount("/x",branch,1);
  assertNotNull(mk.getNodes("/x/b",branch,0,0,-1,null));
  assertChildNodeCount("/x",rebased,2);
  assertNotNull(mk.getNodes("/x/a",rebased,0,0,-1,null));
  assertNotNull(mk.getNodes("/x/b",rebased,0,0,-1,null));
}
