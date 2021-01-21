@Test public void testDemoProtocol() throws Exception {
  DemoService service=new DemoServiceImpl();
  protocol.export(proxy.getInvoker(service,DemoService.class,URL.valueOf("dubbo://127.0.0.1:9020/" + DemoService.class.getName() + "?codec=exchange")));
  service=proxy.getProxy(protocol.refer(DemoService.class,URL.valueOf("dubbo://127.0.0.1:9020/" + DemoService.class.getName() + "?codec=exchange")));
  assertEquals(service.getSize(new String[]{"","",""}),3);
}
