@Test(timeout=5000) public void testHandshakeRejectionTestCase10() throws Exception {
  testProtocolRejection(10,new Draft_6455(Collections.<IExtension>emptyList(),Collections.<IProtocol>singletonList(new Protocol("chat"))));
}
