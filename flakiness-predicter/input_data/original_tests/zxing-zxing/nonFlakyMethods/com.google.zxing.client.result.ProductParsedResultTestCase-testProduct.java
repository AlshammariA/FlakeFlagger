@Test public void testProduct(){
  doTest("123456789012","123456789012",BarcodeFormat.UPC_A);
  doTest("00393157","00393157",BarcodeFormat.EAN_8);
  doTest("5051140178499","5051140178499",BarcodeFormat.EAN_13);
  doTest("01234565","012345000065",BarcodeFormat.UPC_E);
}
