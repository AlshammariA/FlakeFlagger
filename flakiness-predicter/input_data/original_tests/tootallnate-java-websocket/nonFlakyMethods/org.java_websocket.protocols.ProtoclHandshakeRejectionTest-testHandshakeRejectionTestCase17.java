@Test(timeout=5000) public void testHandshakeRejectionTestCase17() throws Exception {
  ArrayList<IProtocol> protocols=new ArrayList<IProtocol>();
  protocols.add(new Protocol("chat"));
  protocols.add(new Protocol(""));
  testProtocolRejection(17,new Draft_6455(Collections.<IExtension>emptyList(),protocols));
}
