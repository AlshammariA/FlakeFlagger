@Test public void rebaseRemoveNode(){
  mk.commit("","+\"/x\":{\"y\":{}}",null,null);
  String branch=mk.branch(null);
  branch=mk.commit("","-\"/x/y\"",branch,null);
  mk.commit("","+\"/x/a\":{}",null,null);
  String rebased=mk.rebase(branch,null);
  assertChildNodeCount("/x",null,2);
  assertNotNull(mk.getNodes("/x/a",null,0,0,-1,null));
  assertNotNull(mk.getNodes("/x/y",null,0,0,-1,null));
  assertChildNodeCount("/x",branch,0);
  assertChildNodeCount("/x",rebased,1);
  assertNotNull(mk.getNodes("/x/a",rebased,0,0,-1,null));
}
