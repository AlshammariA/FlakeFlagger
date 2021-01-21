@Test public void nonConflictingRemovePropertyWithBranch1(){
  String rev=mk.commit("/","+\"foo\":{\"prop1\":\"value\", \"prop2\":\"value\"}",null,null);
  String branchRev=mk.branch(rev);
  branchRev=mk.commit("/foo","^\"prop1\":\"bar\"",branchRev,null);
  mk.commit("/foo","^\"prop2\":null",rev,null);
  mk.merge(branchRev,null);
}
