@Test public void addNodeWithParanthesis() throws Exception {
  mk.commit("/","+\"Test({0})\" : {}",null,null);
  String nodes=mk.getNodes("/Test({0})",null,0,0,-1,null);
  JSONObject obj=parseJSONObject(nodes);
  assertPropertyValue(obj,":childNodeCount",0L);
}
