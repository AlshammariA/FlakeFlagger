@Test public void rebaseWithoutChanges(){
  String branch=mk.branch(null);
  String rebased=mk.rebase(branch,null);
  assertEquals(branch,rebased);
}
