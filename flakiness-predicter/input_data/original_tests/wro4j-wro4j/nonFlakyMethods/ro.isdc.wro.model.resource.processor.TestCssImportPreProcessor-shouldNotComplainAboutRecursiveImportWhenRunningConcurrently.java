/** 
 * Fixes <a href="http://code.google.com/p/wro4j/issues/detail?id=505">CssImport processor recursion detection is not thread-safe</a> issue.
 */
@Test public void shouldNotComplainAboutRecursiveImportWhenRunningConcurrently() throws Exception {
  final AtomicReference<Map<?,?>> contextMapRef=new AtomicReference<Map<?,?>>();
  victim=new CssImportPreProcessor(){
{
{
        contextMapRef.set(getContextMap());
      }
    }
    @Override protected void onRecursiveImportDetected(){
      throw new WroRuntimeException("Recursion detected");
    }
  }
;
  WroTestUtils.initProcessor(victim);
  WroTestUtils.runConcurrently(new ContextPropagatingCallable<Void>(new Callable<Void>(){
    public Void call() throws Exception {
      Context.set(Context.standaloneContext());
      final Reader reader=new StringReader("@import('/path/to/imported');");
      final Resource resource1=Resource.create("resource1.css");
      final Resource resource2=Resource.create("resource2.css");
      if (new Random().nextBoolean()) {
        victim.process(resource1,reader,new StringWriter());
      }
 else {
        victim.process(resource2,reader,new StringWriter());
      }
      Context.unset();
      return null;
    }
  }
));
  assertTrue(contextMapRef.get().isEmpty());
}
