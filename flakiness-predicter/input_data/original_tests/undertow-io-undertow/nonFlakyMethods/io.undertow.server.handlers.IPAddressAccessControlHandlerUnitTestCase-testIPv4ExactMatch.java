@Test public void testIPv4ExactMatch() throws UnknownHostException {
  IPAddressAccessControlHandler handler=new IPAddressAccessControlHandler().setDefaultAllow(false).addAllow("127.0.0.1");
  Assert.assertTrue(handler.isAllowed(InetAddress.getByName("127.0.0.1")));
  Assert.assertFalse(handler.isAllowed(InetAddress.getByName("127.0.0.2")));
}
