@Test public void testPerm() throws Exception {
  DemoService service=new DemoServiceImpl();
  protocol.export(proxy.getInvoker(service,DemoService.class,URL.valueOf("dubbo://127.0.0.1:9050/" + DemoService.class.getName() + "?codec=exchange")));
  service=proxy.getProxy(protocol.refer(DemoService.class,URL.valueOf("dubbo://127.0.0.1:9050/" + DemoService.class.getName() + "?codec=exchange")));
  long start=System.currentTimeMillis();
  for (int i=0; i < 1000; i++)   service.getSize(new String[]{"","",""});
  System.out.println("take:" + (System.currentTimeMillis() - start));
}
