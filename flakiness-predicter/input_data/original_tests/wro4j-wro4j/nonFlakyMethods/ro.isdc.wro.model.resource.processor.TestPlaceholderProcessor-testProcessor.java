@Test public void testProcessor() throws Exception {
  final Properties properties=new Properties();
  properties.setProperty("prop1","value1");
  properties.setProperty("prop2","value2");
  properties.setProperty("prop3","value3");
  properties.setProperty("prop4","value4");
  final ResourcePreProcessor processor=new PlaceholderProcessor().setPropertiesFactory(WroUtil.simpleObjectFactory(properties));
  final URL url=getClass().getResource("placeholder");
  final File testFolder=new File(url.getFile(),"test");
  final File expectedFolder=new File(url.getFile(),"expected");
  WroTestUtils.compareFromDifferentFoldersByExtension(testFolder,expectedFolder,"css",processor);
}
