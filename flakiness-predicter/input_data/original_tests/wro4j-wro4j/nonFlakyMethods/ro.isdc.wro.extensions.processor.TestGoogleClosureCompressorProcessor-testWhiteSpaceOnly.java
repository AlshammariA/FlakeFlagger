@Test public void testWhiteSpaceOnly() throws IOException {
  victim.setCompilationLevel(CompilationLevel.WHITESPACE_ONLY);
  final URL url=getClass().getResource("google");
  final File expectedFolder=new File(url.getFile(),"expectedWhitespaceOnly");
  WroTestUtils.compareFromDifferentFoldersByExtension(testFolder,expectedFolder,"js",(ResourcePreProcessor)victim);
}
