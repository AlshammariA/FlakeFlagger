@Test public void setSingleProperty() throws Exception {
  mk.commit("/","+\"a\" : {} ^\"a/key1\" : \"value1\"",null,null);
  String nodes=mk.getNodes("/",null,0,0,-1,null);
  JSONObject obj=parseJSONObject(nodes);
  assertPropertyValue(obj,":childNodeCount",1L);
  nodes=mk.getNodes("/a",null,0,0,-1,null);
  obj=parseJSONObject(nodes);
  assertPropertyValue(obj,"key1","value1");
}
