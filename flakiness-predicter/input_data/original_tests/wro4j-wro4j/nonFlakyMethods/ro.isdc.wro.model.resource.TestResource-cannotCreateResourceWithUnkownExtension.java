@Test(expected=IllegalArgumentException.class) public void cannotCreateResourceWithUnkownExtension(){
  Assert.assertNotNull(Resource.create("resource.coffee"));
}
