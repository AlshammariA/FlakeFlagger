@Test(timeout=5000) public void testHandshakeRejectionTestCase13() throws Exception {
  testProtocolRejection(13,new Draft_6455(Collections.<IExtension>emptyList(),Collections.<IProtocol>singletonList(new Protocol("chat"))));
}
