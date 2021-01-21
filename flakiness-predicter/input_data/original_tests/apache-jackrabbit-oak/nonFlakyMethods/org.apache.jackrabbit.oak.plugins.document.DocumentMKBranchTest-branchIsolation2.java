@Test public void branchIsolation2() throws Exception {
  String filter="{\"properties\":[\"*\",\":hash\",\":id\"]}";
  String baseRev=mk.commit("/","+\"test\":{\"node\":{}}",null,null);
  String branchRev=mk.branch(baseRev);
  String rev1=mk.commit("/test/node","+\"trunk-node\":{}",null,null);
  mk.commit("/test/node","+\"branch-node\":{}",branchRev,null);
  String rev2=mk.commit("/","+\"other\":{}",null,null);
  String json=mk.getNodes("/test",rev2,0,0,1000,filter);
  JSONObject test=parseJSONObject(json);
  String id=resolveValue(test,":id").toString();
  String revision=id.split("@")[1];
  assertEquals(rev1,revision);
  assertNodesExist(revision,"/test/node/trunk-node");
  assertNodesNotExist(revision,"/test/node/branch-node");
}
