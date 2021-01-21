@Test public void shouldAcceptNullExterns() throws IOException {
  victim=new GoogleClosureCompressorProcessor(CompilationLevel.ADVANCED_OPTIMIZATIONS){
    @Override protected JSSourceFile[] getExterns(    final Resource resource){
      return null;
    }
  }
;
  final StringWriter sw=new StringWriter();
  WroTestUtils.createInjector().inject(victim);
  victim.process(null,new StringReader("function test( ) {}"),sw);
  assertEquals("",sw.toString());
}
