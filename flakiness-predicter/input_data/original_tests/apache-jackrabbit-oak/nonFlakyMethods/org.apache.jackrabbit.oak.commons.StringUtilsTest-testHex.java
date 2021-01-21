public void testHex(){
  assertEquals("0123",StringUtils.convertBytesToHex(new byte[]{(byte)0x01,(byte)0x23}));
  assertEquals("89bd",StringUtils.convertBytesToHex(new byte[]{(byte)0x89,(byte)0xbd}));
  assertEquals("face",StringUtils.convertBytesToHex(new byte[]{(byte)0xfa,(byte)0xce}));
  IOUtilsTest.assertEquals(new byte[]{(byte)0xfa,(byte)0xce},StringUtils.convertHexToBytes("face"));
  IOUtilsTest.assertEquals(new byte[]{(byte)0xfa,(byte)0xce},StringUtils.convertHexToBytes("fAcE"));
  IOUtilsTest.assertEquals(new byte[]{(byte)0xfa,(byte)0xce},StringUtils.convertHexToBytes("FaCe"));
  IOUtilsTest.assertEquals(new byte[]{(byte)0x09,(byte)0xaf},StringUtils.convertHexToBytes("09af"));
  for (  String s : new String[]{"120","1/","9:","fast","a`","ag","0@","aG"}) {
    try {
      StringUtils.convertHexToBytes(s);
      fail();
    }
 catch (    IllegalArgumentException e) {
    }
  }
}
