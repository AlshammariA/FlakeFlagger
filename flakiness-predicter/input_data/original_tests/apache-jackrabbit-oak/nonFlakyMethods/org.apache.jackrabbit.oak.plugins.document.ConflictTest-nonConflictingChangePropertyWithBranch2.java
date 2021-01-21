@Test public void nonConflictingChangePropertyWithBranch2(){
  String rev=mk.commit("/","+\"foo\":{\"prop1\":\"value\", \"prop2\":\"value\"}",null,null);
  String branchRev=mk.branch(rev);
  mk.commit("/foo","^\"prop2\":\"baz\"",rev,null);
  branchRev=mk.commit("/foo","^\"prop1\":\"bar\"",branchRev,null);
  mk.merge(branchRev,null);
}
