@Test(timeout=5000) public void testHandshakeRejectionTestCase9() throws Exception {
  testProtocolRejection(9,new Draft_6455(Collections.<IExtension>emptyList(),Collections.<IProtocol>singletonList(new Protocol("chat"))));
}
