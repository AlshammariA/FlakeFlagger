@Test public void testToString1(){
  QRCode qrCode=new QRCode();
  String expected="<<\n" + " mode: null\n" + " ecLevel: null\n"+ " version: null\n"+ " maskPattern: -1\n"+ " matrix: null\n"+ ">>\n";
  assertEquals(expected,qrCode.toString());
}
