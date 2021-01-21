@Test public void testAdvancedOptimization() throws IOException {
  victim.setCompilationLevel(CompilationLevel.ADVANCED_OPTIMIZATIONS);
  final URL url=getClass().getResource("google");
  final File expectedFolder=new File(url.getFile(),"expectedAdvanced");
  WroTestUtils.compareFromDifferentFoldersByExtension(testFolder,expectedFolder,"js",(ResourcePreProcessor)victim);
}
