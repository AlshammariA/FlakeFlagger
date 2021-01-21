@Test public void testAztecWriter() throws Exception {
  testWriter("\u20AC 1 sample data.","ISO-8859-1",25,true,2);
  testWriter("\u20AC 1 sample data.","ISO-8859-15",25,true,2);
  testWriter("\u20AC 1 sample data.","UTF-8",25,true,2);
  testWriter("\u20AC 1 sample data.","UTF-8",100,true,3);
  testWriter("\u20AC 1 sample data.","UTF-8",300,true,4);
  testWriter("\u20AC 1 sample data.","UTF-8",500,false,5);
  String data="In ut magna vel mauris malesuada";
  AztecWriter writer=new AztecWriter();
  BitMatrix matrix=writer.encode(data,BarcodeFormat.AZTEC,0,0);
  AztecCode aztec=Encoder.encode(data.getBytes(LATIN_1),Encoder.DEFAULT_EC_PERCENT,Encoder.DEFAULT_AZTEC_LAYERS);
  BitMatrix expectedMatrix=aztec.getMatrix();
  assertEquals(matrix,expectedMatrix);
}
