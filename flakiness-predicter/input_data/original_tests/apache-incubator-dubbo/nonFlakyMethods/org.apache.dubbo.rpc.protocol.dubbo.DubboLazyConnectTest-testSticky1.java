@Test(expected=RpcException.class) public void testSticky1(){
  URL url=URL.valueOf("dubbo://127.0.0.1:9090/org.apache.dubbo.rpc.protocol.dubbo.IDemoService");
  ProtocolUtils.refer(IDemoService.class,url);
}
