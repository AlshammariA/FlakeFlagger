@Test public void testISBN(){
  doTestResult("9784567890123","9784567890123",ParsedResultType.ISBN,BarcodeFormat.EAN_13);
  doTestResult("9794567890123","9794567890123",ParsedResultType.ISBN,BarcodeFormat.EAN_13);
  doTestResult("97845678901","97845678901",ParsedResultType.TEXT);
  doTestResult("97945678901","97945678901",ParsedResultType.TEXT);
}
