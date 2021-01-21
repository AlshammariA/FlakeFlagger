@Test public void testExtractInvalidResourceType(){
  String uri="/test.js";
  ResourceType type=victim.getResourceType(mockRequestForUri(uri));
  Assert.assertEquals(ResourceType.JS,type);
  uri="/test.css";
  type=victim.getResourceType(mockRequestForUri(uri));
  Assert.assertEquals(ResourceType.CSS,type);
  uri="/test.txt";
  Assert.assertNull(victim.getResourceType(mockRequestForUri(uri)));
}
