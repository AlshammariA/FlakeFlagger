@Test(timeout=5000) public void testHandshakeRejectionTestCase11() throws Exception {
  testProtocolRejection(11,new Draft_6455(Collections.<IExtension>emptyList(),Collections.<IProtocol>singletonList(new Protocol("chat"))));
}
