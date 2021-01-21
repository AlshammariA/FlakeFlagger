@Test public void setOverwritingProperty() throws Exception {
  String rev1=mk.commit("/","+\"a\" : {} ^\"a/key1\" : \"value1\"",null,null);
  String rev2=mk.commit("/","^\"a/key1\" : \"value2\"",rev1,null);
  try {
    mk.commit("/","^\"a/key1\" : \"value3\"",rev1,null);
    fail("commit must fail with conflicting change");
  }
 catch (  MicroKernelException e) {
  }
  mk.commit("/","^\"a/key1\" : \"value3\"",rev2,null);
  String nodes=mk.getNodes("/a",null,0,0,-1,null);
  JSONObject obj=parseJSONObject(nodes);
  assertPropertyValue(obj,"key1","value3");
}
