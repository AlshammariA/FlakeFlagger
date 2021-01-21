@Test public void branchIsolation1() throws Exception {
  String filter="{\"properties\":[\"*\",\":hash\",\":id\"]}";
  String baseRev=mk.commit("/","+\"test\":{\"node\":{}}",null,null);
  String branchRev=mk.branch(baseRev);
  String branchRev1=mk.commit("/test/node","+\"branch-node\":{}",branchRev,null);
  mk.commit("/test/node","+\"trunk-node\":{}",null,null);
  String branchRev2=mk.commit("/","+\"other\":{}",branchRev1,null);
  String json=mk.getNodes("/test",branchRev2,0,0,1000,filter);
  JSONObject test=parseJSONObject(json);
  String id=resolveValue(test,":id").toString();
  String revision=id.split("@")[1];
  assertNodesExist(revision,"/test/node/branch-node");
  assertNodesNotExist(revision,"/test/node/trunk-node");
}
