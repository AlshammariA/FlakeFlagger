@Test(timeout=5000) public void testHandshakeRejectionTestCase15() throws Exception {
  ArrayList<IProtocol> protocols=new ArrayList<IProtocol>();
  protocols.add(new Protocol("chat"));
  protocols.add(new Protocol("chat2"));
  testProtocolRejection(15,new Draft_6455(Collections.<IExtension>emptyList(),protocols));
}
