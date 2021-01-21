@Test public void afterDelete() throws Exception {
  SimpleNodeScenario scenario=new SimpleNodeScenario(mk);
  scenario.create();
  JSONObject root=parseJSONObject(mk.getNodes("/",null,0,0,-1,null));
  assertPropertyValue(root,":childNodeCount",1L);
  JSONObject a=parseJSONObject(mk.getNodes("/a",null,0,0,-1,null));
  assertPropertyValue(a,":childNodeCount",2L);
  scenario.deleteA();
  root=parseJSONObject(mk.getNodes("/",null,0,0,-1,null));
  assertPropertyValue(root,":childNodeCount",0L);
}
