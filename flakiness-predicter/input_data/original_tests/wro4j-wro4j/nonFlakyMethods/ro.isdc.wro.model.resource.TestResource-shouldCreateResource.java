@Test public void shouldCreateResource(){
  Assert.assertNotNull(Resource.create("resource.js",ResourceType.JS));
}
