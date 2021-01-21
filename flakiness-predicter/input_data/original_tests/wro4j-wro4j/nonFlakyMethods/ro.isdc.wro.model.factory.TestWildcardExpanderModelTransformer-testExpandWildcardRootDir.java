@Test public void testExpandWildcardRootDir() throws Exception {
  final String uri="/**.js";
  final Resource resource=Resource.create(uri,ResourceType.JS);
  final Group group=new Group("group").addResource(resource);
  final String baseNameFolder=WroUtil.toPackageAsFolder(getClass());
  final Function<Collection<File>,Void> expanderHandler=transformer.createExpanderHandler(group,resource,baseNameFolder);
  final File mockFile1=Mockito.mock(File.class);
  Mockito.when(mockFile1.getPath()).thenReturn(baseNameFolder + "/js1.js");
  final File mockFile2=Mockito.mock(File.class);
  Mockito.when(mockFile2.getPath()).thenReturn(baseNameFolder + "/js2.js");
  expanderHandler.apply(Arrays.asList(mockFile1,mockFile2));
  LOG.debug("group: {}",group);
  Assert.assertEquals(2,group.getResources().size());
  Assert.assertEquals("/js1.js",group.getResources().get(0).getUri());
  Assert.assertEquals("/js2.js",group.getResources().get(1).getUri());
}
