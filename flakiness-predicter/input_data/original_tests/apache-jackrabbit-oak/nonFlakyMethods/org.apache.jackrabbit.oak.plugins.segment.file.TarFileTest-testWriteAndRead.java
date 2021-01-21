@Test public void testWriteAndRead() throws IOException {
  UUID id=UUID.randomUUID();
  long msb=id.getMostSignificantBits();
  long lsb=id.getLeastSignificantBits() & (-1 >>> 4);
  byte[] data="Hello, World!".getBytes(UTF_8);
  TarWriter writer=new TarWriter(file);
  try {
    writer.writeEntry(msb,lsb,data,0,data.length);
    assertEquals(ByteBuffer.wrap(data),writer.readEntry(msb,lsb));
  }
  finally {
    writer.close();
  }
  assertEquals(4096,file.length());
  TarReader reader=TarReader.open(file,false);
  try {
    assertEquals(ByteBuffer.wrap(data),reader.readEntry(msb,lsb));
  }
  finally {
    reader.close();
  }
  reader=TarReader.open(file,false);
  try {
    assertEquals(ByteBuffer.wrap(data),reader.readEntry(msb,lsb));
  }
  finally {
    reader.close();
  }
}
