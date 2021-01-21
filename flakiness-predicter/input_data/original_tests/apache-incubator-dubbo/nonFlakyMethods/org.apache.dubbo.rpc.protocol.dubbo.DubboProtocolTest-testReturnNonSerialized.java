@Test public void testReturnNonSerialized() throws Exception {
  DemoService service=new DemoServiceImpl();
  protocol.export(proxy.getInvoker(service,DemoService.class,URL.valueOf("dubbo://127.0.0.1:9050/" + DemoService.class.getName() + "?codec=exchange")));
  service=proxy.getProxy(protocol.refer(DemoService.class,URL.valueOf("dubbo://127.0.0.1:9050/" + DemoService.class.getName() + "?codec=exchange")));
  try {
    service.returnNonSerialized();
    Assert.fail();
  }
 catch (  RpcException e) {
    Assert.assertTrue(e.getMessage().contains("org.apache.dubbo.rpc.protocol.dubbo.support.NonSerialized must implement java.io.Serializable"));
  }
}
