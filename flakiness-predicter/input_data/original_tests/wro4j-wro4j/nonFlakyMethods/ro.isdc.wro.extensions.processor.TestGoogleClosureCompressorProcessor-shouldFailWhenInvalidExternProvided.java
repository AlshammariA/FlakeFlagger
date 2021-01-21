@Test(expected=WroRuntimeException.class) public void shouldFailWhenInvalidExternProvided() throws IOException {
  victim=new GoogleClosureCompressorProcessor(CompilationLevel.ADVANCED_OPTIMIZATIONS){
    @Override protected SourceFile[] getExterns(    final Resource resource){
      return new SourceFile[]{SourceFile.fromFile(new File("INVALID"))};
    }
  }
;
  WroTestUtils.createInjector().inject(victim);
  final StringWriter sw=new StringWriter();
  victim.process(null,new StringReader("alert(1);"),sw);
  assertEquals("alert(1);",sw.toString());
}
