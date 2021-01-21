@Test public void shouldCreateContextWithNotNullArguments(){
  final WildcardContext context=new WildcardContext("path/to/uri",new File("/path/to/folder/"));
  assertEquals(FilenameUtils.separatorsToSystem("path/to/uri"),FilenameUtils.separatorsToSystem(context.getUri()));
  assertEquals(FilenameUtils.separatorsToSystem("/path/to/folder"),context.getFolder().getPath());
  assertEquals("uri",context.getWildcard());
}
