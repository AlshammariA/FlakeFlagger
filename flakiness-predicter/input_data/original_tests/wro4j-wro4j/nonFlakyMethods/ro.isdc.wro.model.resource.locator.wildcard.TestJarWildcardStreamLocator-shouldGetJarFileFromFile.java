@Test public void shouldGetJarFileFromFile(){
  final String actual=jarStreamLocator.getJarFile(new File("file:path/to/file!one/two/three.class")).getPath();
  final String expected=FilenameUtils.separatorsToSystem("path/to/file");
  Assert.assertEquals(expected,actual);
}
