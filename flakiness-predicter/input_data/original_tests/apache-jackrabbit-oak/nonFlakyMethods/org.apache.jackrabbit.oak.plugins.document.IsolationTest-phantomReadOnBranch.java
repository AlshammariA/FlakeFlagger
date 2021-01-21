@Test public void phantomReadOnBranch(){
  String base=mk.commit("/","+\"test\":{}",null,null);
  String branchRev1=mk.branch(base);
  String branchRev2=mk.branch(base);
  branchRev1=mk.commit("/test","+\"node1\":{}",branchRev1,null);
  branchRev2=mk.commit("/test","+\"node2\":{}",branchRev2,null);
  String r=mk.commit("/test","+\"node3\":{}",null,null);
  assertNodesNotExist(branchRev1,"/test/node3");
  branchRev1=mk.rebase(branchRev1,r);
  assertNodesExist(branchRev1,"/test/node1","/test/node3");
  assertNodesNotExist(branchRev1,"/test/node2");
  mk.merge(branchRev2,null);
  assertNodesExist(branchRev1,"/test/node1","/test/node3");
  assertNodesNotExist(branchRev1,"/test/node2");
}
