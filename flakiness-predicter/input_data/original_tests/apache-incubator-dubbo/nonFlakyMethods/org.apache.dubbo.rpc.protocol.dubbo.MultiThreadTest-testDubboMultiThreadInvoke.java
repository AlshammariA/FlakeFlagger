@Test public void testDubboMultiThreadInvoke() throws Exception {
  Exporter<?> rpcExporter=protocol.export(proxy.getInvoker(new DemoServiceImpl(),DemoService.class,URL.valueOf("dubbo://127.0.0.1:20259/TestService")));
  final AtomicInteger counter=new AtomicInteger();
  final DemoService service=proxy.getProxy(protocol.refer(DemoService.class,URL.valueOf("dubbo://127.0.0.1:20259/TestService")));
  Assert.assertEquals(service.getSize(new String[]{"123","456","789"}),3);
  final StringBuffer sb=new StringBuffer();
  for (int i=0; i < 1024 * 64 + 32; i++)   sb.append('A');
  Assert.assertEquals(sb.toString(),service.echo(sb.toString()));
  ExecutorService exec=Executors.newFixedThreadPool(10);
  for (int i=0; i < 10; i++) {
    final int fi=i;
    exec.execute(new Runnable(){
      public void run(){
        for (int i=0; i < 30; i++) {
          System.out.println(fi + ":" + counter.getAndIncrement());
          Assert.assertEquals(service.echo(sb.toString()),sb.toString());
        }
      }
    }
);
  }
  exec.shutdown();
  exec.awaitTermination(10,TimeUnit.SECONDS);
  rpcExporter.unexport();
}
