@Test(timeout=5000) public void testHandshakeRejectionTestCase6() throws Exception {
  testProtocolRejection(6,new Draft_6455(Collections.<IExtension>emptyList(),Collections.<IProtocol>singletonList(new Protocol("chat"))));
}
