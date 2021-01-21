@Test public void fileToURLAndBack() throws MalformedURLException {
  File file=new File("a b.xml");
  URL url=file.toURI().toURL();
  ConfigurationWatchList cwl=new ConfigurationWatchList();
  File back=cwl.convertToFile(url);
  assertEquals(file.getName(),back.getName());
}
