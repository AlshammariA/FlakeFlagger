@Test public void existingNodesMerged() throws Exception {
  String rev=mk.commit("/","+\"a\" : {}",null,null);
  mk.commit("/","+\"a/b\" : {}",null,null);
  mk.commit("/","^\"a/key1\" : \"value1\"",null,null);
  mk.commit("/","^\"a/key2\" : \"value2\"",rev,null);
  String nodes=mk.getNodes("/",null,0,0,-1,null);
  JSONObject obj=parseJSONObject(nodes);
  assertPropertyValue(obj,":childNodeCount",1L);
  nodes=mk.getNodes("/a",null,0,0,-1,null);
  obj=parseJSONObject(nodes);
  assertPropertyValue(obj,"key1","value1");
  assertPropertyValue(obj,"key2","value2");
}
