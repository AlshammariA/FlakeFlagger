@Test public void rebaseEmptyBranch(){
  String branch=mk.branch(null);
  String trunk=mk.commit("","+\"/a\":{}",null,null);
  String rebased=mk.rebase(branch,null);
  assertEquals("{\":childNodeCount\":1,\"a\":{}}",mk.getNodes("/",rebased,0,0,-1,null));
  assertEquals("{\":childNodeCount\":1,\"a\":{}}",mk.getNodes("/",null,0,0,-1,null));
  assertEquals(trunk,mk.getHeadRevision());
  assertFalse((trunk.equals(rebased)));
}
