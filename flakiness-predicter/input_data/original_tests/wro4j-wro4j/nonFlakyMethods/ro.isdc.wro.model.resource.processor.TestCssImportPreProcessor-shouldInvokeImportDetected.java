@Test public void shouldInvokeImportDetected() throws IOException {
  final AtomicInteger times=new AtomicInteger();
  victim=new CssImportPreProcessor(){
    @Override protected void onImportDetected(    final String foundImportUri){
      times.incrementAndGet();
    }
  }
;
  WroTestUtils.initProcessor(victim);
  final Resource resource=Resource.create("someResource.css");
  final Reader reader=new StringReader("@import('/path/to/invalid.css');");
  victim.process(resource,reader,new StringWriter());
  assertEquals(1,times.get());
}
