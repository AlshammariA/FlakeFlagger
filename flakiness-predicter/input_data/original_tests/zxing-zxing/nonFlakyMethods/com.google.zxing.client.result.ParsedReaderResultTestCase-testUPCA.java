@Test public void testUPCA(){
  doTestResult("123456789012","123456789012",ParsedResultType.PRODUCT,BarcodeFormat.UPC_A);
  doTestResult("1234567890123","1234567890123",ParsedResultType.PRODUCT,BarcodeFormat.UPC_A);
  doTestResult("12345678901","12345678901",ParsedResultType.TEXT);
}
