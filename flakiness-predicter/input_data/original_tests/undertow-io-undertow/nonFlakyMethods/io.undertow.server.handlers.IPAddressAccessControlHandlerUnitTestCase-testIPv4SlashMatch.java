@Test public void testIPv4SlashMatch() throws UnknownHostException {
  IPAddressAccessControlHandler handler=new IPAddressAccessControlHandler().setDefaultAllow(true).addAllow("127.0.0.1").addAllow("127.0.0.48/30").addDeny("127.0.0.0/16");
  Assert.assertTrue(handler.isAllowed(InetAddress.getByName("127.0.0.1")));
  Assert.assertFalse(handler.isAllowed(InetAddress.getByName("127.0.0.2")));
  Assert.assertFalse(handler.isAllowed(InetAddress.getByName("127.0.1.1")));
  Assert.assertTrue(handler.isAllowed(InetAddress.getByName("127.1.0.2")));
  Assert.assertFalse(handler.isAllowed(InetAddress.getByName("127.0.0.47")));
  Assert.assertTrue(handler.isAllowed(InetAddress.getByName("127.0.0.48")));
  Assert.assertTrue(handler.isAllowed(InetAddress.getByName("127.0.0.49")));
  Assert.assertTrue(handler.isAllowed(InetAddress.getByName("127.0.0.50")));
  Assert.assertTrue(handler.isAllowed(InetAddress.getByName("127.0.0.51")));
  Assert.assertFalse(handler.isAllowed(InetAddress.getByName("127.0.0.52")));
}
