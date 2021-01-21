@Test public void setPropertyIllegalKey() throws Exception {
  mk.commit("/","+\"a\" : {}",null,null);
  mk.commit("/","^\"a/_id\" : \"value\"",null,null);
  String nodes=mk.getNodes("/a",null,0,0,-1,null);
  JSONObject obj=parseJSONObject(nodes);
  assertPropertyValue(obj,"_id","value");
  mk.commit("/","^\"a/ke.y1\" : \"value\"",null,null);
  nodes=mk.getNodes("/a",null,0,0,-1,null);
  obj=parseJSONObject(nodes);
  assertPropertyValue(obj,"ke.y1","value");
  mk.commit("/","^\"a/ke.y.1\" : \"value\"",null,null);
  nodes=mk.getNodes("/a",null,0,0,-1,null);
  obj=parseJSONObject(nodes);
  assertPropertyValue(obj,"ke.y.1","value");
  mk.commit("/","^\"a/$key1\" : \"value\"",null,null);
  nodes=mk.getNodes("/a",null,0,0,-1,null);
  obj=parseJSONObject(nodes);
  assertPropertyValue(obj,"$key1","value");
}
