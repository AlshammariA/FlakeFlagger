@Test public void testIPv6PrefixMatch() throws UnknownHostException {
  IPAddressAccessControlHandler handler=new IPAddressAccessControlHandler().setDefaultAllow(true).addAllow("FE45:00:00:000:0:AAA:FFFF:0045").addDeny("FE45:00:00:000:0:AAA:FFFF:*");
  Assert.assertTrue(handler.isAllowed(InetAddress.getByName("FE45:0:0:0:0:AAA:FFFF:45")));
  Assert.assertTrue(handler.isAllowed(InetAddress.getByName("127.0.0.2")));
  Assert.assertFalse(handler.isAllowed(InetAddress.getByName("FE45:0:0:0:0:AAA:FFFF:46")));
  Assert.assertTrue(handler.isAllowed(InetAddress.getByName("FE45:0:0:0:0:AAA:FFFb:46")));
}
