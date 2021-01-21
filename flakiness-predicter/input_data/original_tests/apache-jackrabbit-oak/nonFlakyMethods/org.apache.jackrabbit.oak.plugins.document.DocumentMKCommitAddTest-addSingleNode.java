@Test public void addSingleNode() throws Exception {
  mk.commit("/","+\"a\" : {}",null,null);
  String nodes=mk.getNodes("/",null,0,0,-1,null);
  JSONObject obj=parseJSONObject(nodes);
  assertPropertyValue(obj,":childNodeCount",1L);
}
