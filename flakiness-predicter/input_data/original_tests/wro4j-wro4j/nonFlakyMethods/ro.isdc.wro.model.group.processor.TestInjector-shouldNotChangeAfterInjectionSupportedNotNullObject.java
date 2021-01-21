@Test public void shouldNotChangeAfterInjectionSupportedNotNullObject() throws Exception {
  new Callable<Void>(){
    @Inject private final ResourcePreProcessor inner=new ResourcePreProcessor(){
      public void process(      final Resource resource,      final Reader reader,      final Writer writer) throws IOException {
      }
    }
;
    public Void call() throws Exception {
      Assert.assertNotNull(inner);
      return null;
    }
  }
.call();
}
