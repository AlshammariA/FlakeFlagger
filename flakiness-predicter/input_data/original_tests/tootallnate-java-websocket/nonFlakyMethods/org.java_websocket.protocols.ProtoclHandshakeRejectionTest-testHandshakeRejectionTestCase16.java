@Test(timeout=5000) public void testHandshakeRejectionTestCase16() throws Exception {
  ArrayList<IProtocol> protocols=new ArrayList<IProtocol>();
  protocols.add(new Protocol("chat"));
  protocols.add(new Protocol("chat2"));
  testProtocolRejection(16,new Draft_6455(Collections.<IExtension>emptyList(),protocols));
}
