@Test public void testFromFolder() throws IOException {
  final URL url=getClass().getResource("csslint");
  final File testFolder=new File(url.getFile());
  WroTestUtils.compareFromSameFolder(testFolder,new WildcardFileFilter("*.css"),Transformers.noOpTransformer(),victim);
}
