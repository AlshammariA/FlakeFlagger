@Test public void fastForwardRebase(){
  String branch=mk.branch(null);
  branch=mk.commit("","+\"/a\":{}",branch,null);
  String rebased=mk.rebase(branch,null);
  assertEquals(branch,rebased);
}
