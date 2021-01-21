@Test public void testEAN(){
  doTestResult("00393157","00393157",ParsedResultType.PRODUCT,BarcodeFormat.EAN_8);
  doTestResult("00393158","00393158",ParsedResultType.TEXT);
  doTestResult("5051140178499","5051140178499",ParsedResultType.PRODUCT,BarcodeFormat.EAN_13);
  doTestResult("5051140178490","5051140178490",ParsedResultType.TEXT);
}
