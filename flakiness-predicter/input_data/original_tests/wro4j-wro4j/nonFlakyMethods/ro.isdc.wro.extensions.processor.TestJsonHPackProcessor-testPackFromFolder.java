@Test public void testPackFromFolder() throws Exception {
  final ResourcePostProcessor processor=JsonHPackProcessor.packProcessor();
  final URL url=getClass().getResource("jsonhpack");
  final File testFolder=new File(url.getFile(),"test");
  final File expectedFolder=new File(url.getFile(),"pack");
  WroTestUtils.compareFromDifferentFoldersByExtension(testFolder,expectedFolder,"js",processor);
}
