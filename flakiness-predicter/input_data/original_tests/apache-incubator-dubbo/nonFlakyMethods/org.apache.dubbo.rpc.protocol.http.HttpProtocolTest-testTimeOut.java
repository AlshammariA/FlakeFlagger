@Test public void testTimeOut(){
  HttpServiceImpl server=new HttpServiceImpl();
  ProxyFactory proxyFactory=ExtensionLoader.getExtensionLoader(ProxyFactory.class).getAdaptiveExtension();
  Protocol protocol=ExtensionLoader.getExtensionLoader(Protocol.class).getAdaptiveExtension();
  URL url=URL.valueOf("http://127.0.0.1:5342/" + HttpService.class.getName() + "?version=1.0.0&timeout=10");
  Exporter<HttpService> exporter=protocol.export(proxyFactory.getInvoker(server,HttpService.class,url));
  Invoker<HttpService> invoker=protocol.refer(HttpService.class,url);
  HttpService client=proxyFactory.getProxy(invoker);
  try {
    client.timeOut(6000);
    fail();
  }
 catch (  RpcException expected) {
    Assert.assertEquals(true,expected.isTimeout());
  }
 finally {
    invoker.destroy();
    exporter.unexport();
  }
}
