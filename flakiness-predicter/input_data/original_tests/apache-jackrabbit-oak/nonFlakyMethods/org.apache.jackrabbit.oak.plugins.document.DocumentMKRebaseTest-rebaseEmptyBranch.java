@Test public void rebaseEmptyBranch(){
  String branch=mk.branch(null);
  String trunk=mk.commit("","+\"/a\":{}",null,null);
  String rebased=mk.rebase(branch,null);
  JSONObject json=parseJSONObject(mk.getNodes("/",rebased,0,0,-1,null));
  assertPropertyValue(json,":childNodeCount",1L);
  assertNotNull(json.get("a"));
  json=parseJSONObject(mk.getNodes("/",null,0,0,-1,null));
  assertPropertyValue(json,":childNodeCount",1L);
  assertNotNull(json.get("a"));
  assertEquals(trunk,mk.getHeadRevision());
  assertFalse(trunk.equals(rebased));
}
