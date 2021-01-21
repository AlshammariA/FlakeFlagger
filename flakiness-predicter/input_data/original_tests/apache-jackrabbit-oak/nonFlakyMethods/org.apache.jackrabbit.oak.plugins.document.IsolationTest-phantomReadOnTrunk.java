@Test public void phantomReadOnTrunk(){
  String base=mk.commit("/","+\"test\":{}",null,null);
  String branchRev1=mk.branch(base);
  branchRev1=mk.commit("/test","+\"node1\":{}",branchRev1,null);
  String rev=mk.commit("/test","+\"node2\":{}",null,null);
  assertNodesNotExist(rev,"/test/node1");
  mk.merge(branchRev1,null);
  assertNodesNotExist(rev,"/test/node1");
}
