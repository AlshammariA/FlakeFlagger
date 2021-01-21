/** 
 * Test that processing invalid sass css produces exceptions.
 */
@Test public void shouldFailWhenInvalidSassCssIsProcessed() throws Exception {
  final File testFolder=new File(url.getFile(),"invalid");
  WroTestUtils.forEachFileInFolder(testFolder,new Function<File,Void>(){
    @Override public Void apply(    final File input) throws Exception {
      try {
        processor.process(null,new FileReader(input),new StringWriter());
        fail("Shouldn't have failed");
      }
 catch (      final WroRuntimeException e) {
      }
      return null;
    }
  }
);
}
