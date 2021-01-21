@Test public void depthZero() throws Exception {
  SimpleNodeScenario scenario=new SimpleNodeScenario(mk);
  scenario.create();
  JSONObject root=parseJSONObject(mk.getNodes("/",null,0,0,-1,null));
  assertPropertyValue(root,":childNodeCount",1L);
  JSONObject a=resolveObjectValue(root,"a");
  assertPropertyNotExists(a,"int");
}
