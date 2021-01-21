@Test public void testUnpackFromFolder() throws Exception {
  final ResourcePostProcessor processor=JsonHPackProcessor.unpackProcessor();
  final URL url=getClass().getResource("jsonhpack");
  final File testFolder=new File(url.getFile(),"pack");
  final File expectedFolder=new File(url.getFile(),"unpack");
  WroTestUtils.compareFromDifferentFoldersByExtension(testFolder,expectedFolder,"js",processor);
}
