@Test public void movesInBranch() throws Exception {
  String branchRev=mk.branch(null);
  branchRev=mk.commit("/","+\"a\":{}",branchRev,null);
  branchRev=mk.commit("/a","^\"foo\":1",branchRev,null);
  branchRev=mk.commit("/",">\"a\" : \"b\"",branchRev,null);
  branchRev=mk.commit("/",">\"b\" : \"a\"",branchRev,null);
  mk.merge(branchRev,null);
  String json=mk.getNodes("/a",null,0,0,-1,null);
  JSONParser parser=new JSONParser();
  JSONObject obj=(JSONObject)parser.parse(json);
  assertTrue(obj.containsKey("foo"));
}
