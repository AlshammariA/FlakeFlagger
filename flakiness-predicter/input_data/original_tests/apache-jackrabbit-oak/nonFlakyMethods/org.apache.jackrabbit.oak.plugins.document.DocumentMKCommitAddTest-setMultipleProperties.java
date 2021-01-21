@Test public void setMultipleProperties() throws Exception {
  mk.commit("/","+\"a\" : {} ^\"a/key1\" : \"value1\"",null,null);
  mk.commit("/","^\"a/key2\" : 2",null,null);
  mk.commit("/","^\"a/key3\" : false",null,null);
  mk.commit("/","^\"a/key4\" : 0.25",null,null);
  String nodes=mk.getNodes("/",null,0,0,-1,null);
  JSONObject obj=parseJSONObject(nodes);
  assertPropertyValue(obj,":childNodeCount",1L);
  nodes=mk.getNodes("/a",null,0,0,-1,null);
  obj=parseJSONObject(nodes);
  assertPropertyValue(obj,"key1","value1");
  assertPropertyValue(obj,"key2",2L);
  assertPropertyValue(obj,"key3",false);
  assertPropertyValue(obj,"key4",0.25);
}
