@Test public void simpleFileStressTest() throws IOException, ExecutionException, InterruptedException, URISyntaxException {
  ExecutorService executor=Executors.newFixedThreadPool(NUM_THREADS);
  try {
    File rootPath=new File(getClass().getResource("page.html").toURI()).getParentFile();
    final ResourceHandler handler=new ResourceHandler().setResourceManager(new FileResourceManager(rootPath,10485760));
    final CacheHandler cacheHandler=new CacheHandler(new DirectBufferCache(1024,10,10480),handler);
    final PathHandler path=new PathHandler();
    path.addPath("/path",cacheHandler);
    final CanonicalPathHandler root=new CanonicalPathHandler();
    root.setNext(path);
    DefaultServer.setRootHandler(root);
    final List<Future<?>> futures=new ArrayList<Future<?>>();
    for (int i=0; i < NUM_THREADS; ++i) {
      futures.add(executor.submit(new Runnable(){
        @Override public void run(){
          TestHttpClient client=new TestHttpClient();
          try {
            for (int i=0; i < NUM_REQUESTS; ++i) {
              HttpGet get=new HttpGet(DefaultServer.getDefaultServerURL() + "/path/page.html");
              HttpResponse result=client.execute(get);
              Assert.assertEquals(200,result.getStatusLine().getStatusCode());
              final String response=HttpClientUtils.readResponse(result);
              Assert.assertTrue(response,response.contains("A web page"));
            }
          }
 catch (          IOException e) {
            throw new RuntimeException(e);
          }
 finally {
            client.getConnectionManager().shutdown();
          }
        }
      }
));
    }
    for (    Future<?> future : futures) {
      future.get();
    }
  }
  finally {
    executor.shutdown();
  }
}
