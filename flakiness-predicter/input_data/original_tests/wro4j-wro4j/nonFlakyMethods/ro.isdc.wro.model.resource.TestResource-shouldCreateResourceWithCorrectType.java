@Test public void shouldCreateResourceWithCorrectType(){
  Resource resource=Resource.create("resource.js");
  Assert.assertNotNull(resource);
  Assert.assertEquals(ResourceType.JS,resource.getType());
  resource=Resource.create("resource.css");
  Assert.assertNotNull(resource);
  Assert.assertEquals(ResourceType.CSS,resource.getType());
}
