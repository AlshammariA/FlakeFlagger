@Test public void testIsValidMaskPattern(){
  assertFalse(QRCode.isValidMaskPattern(-1));
  assertTrue(QRCode.isValidMaskPattern(0));
  assertTrue(QRCode.isValidMaskPattern(7));
  assertFalse(QRCode.isValidMaskPattern(8));
}
