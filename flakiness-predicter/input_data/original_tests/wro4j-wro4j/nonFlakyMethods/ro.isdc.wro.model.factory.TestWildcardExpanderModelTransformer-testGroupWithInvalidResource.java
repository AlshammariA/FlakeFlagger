/** 
 * Invalid resources should be ignored, leaving the model unchanged.
 */
@Test public void testGroupWithInvalidResource(){
  final WroModel model=new WroModel();
  final String uri=String.format(ClasspathUriLocator.PREFIX + "%s/expander/INVALID.*",WroUtil.toPackageAsFolder(getClass()));
  model.addGroup(new Group("group").addResource(Resource.create(uri,ResourceType.JS)));
  Mockito.when(decoratedFactory.create()).thenReturn(model);
  final WroModel changedModel=transformer.transform(model);
  Assert.assertEquals(1,changedModel.getGroups().size());
}
