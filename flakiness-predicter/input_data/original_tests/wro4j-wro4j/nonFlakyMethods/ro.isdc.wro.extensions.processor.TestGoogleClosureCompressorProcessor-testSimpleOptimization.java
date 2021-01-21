@Test public void testSimpleOptimization() throws IOException {
  victim.setCompilationLevel(CompilationLevel.SIMPLE_OPTIMIZATIONS);
  final URL url=getClass().getResource("google");
  final File expectedFolder=new File(url.getFile(),"expectedSimple");
  WroTestUtils.compareFromDifferentFoldersByExtension(testFolder,expectedFolder,"js",(ResourcePreProcessor)victim);
}
