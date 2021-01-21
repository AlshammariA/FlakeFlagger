@Test public void resetToCurrentBranchHead(){
  String rev=mk.branch(null);
  rev=addNodes(rev,"/foo");
  String reset=mk.reset(rev,rev);
  assertTrue(mk.diff(rev,reset,"/",0).length() == 0);
}
