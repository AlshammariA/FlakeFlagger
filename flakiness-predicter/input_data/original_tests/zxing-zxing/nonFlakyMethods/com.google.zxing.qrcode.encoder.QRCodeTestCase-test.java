@Test public void test(){
  QRCode qrCode=new QRCode();
  qrCode.setMode(Mode.BYTE);
  qrCode.setECLevel(ErrorCorrectionLevel.H);
  qrCode.setVersion(Version.getVersionForNumber(7));
  qrCode.setMaskPattern(3);
  assertSame(Mode.BYTE,qrCode.getMode());
  assertSame(ErrorCorrectionLevel.H,qrCode.getECLevel());
  assertEquals(7,qrCode.getVersion().getVersionNumber());
  assertEquals(3,qrCode.getMaskPattern());
  ByteMatrix matrix=new ByteMatrix(45,45);
  for (int y=0; y < 45; ++y) {
    for (int x=0; x < 45; ++x) {
      matrix.set(x,y,(y + x) % 2);
    }
  }
  qrCode.setMatrix(matrix);
  assertSame(matrix,qrCode.getMatrix());
}
