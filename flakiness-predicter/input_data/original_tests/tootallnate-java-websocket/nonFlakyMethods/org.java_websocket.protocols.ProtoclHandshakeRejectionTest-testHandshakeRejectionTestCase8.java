@Test(timeout=5000) public void testHandshakeRejectionTestCase8() throws Exception {
  testProtocolRejection(8,new Draft_6455(Collections.<IExtension>emptyList(),Collections.<IProtocol>singletonList(new Protocol("chat"))));
}
