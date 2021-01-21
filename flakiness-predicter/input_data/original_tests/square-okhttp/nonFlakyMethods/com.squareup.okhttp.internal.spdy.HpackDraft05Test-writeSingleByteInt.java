@Test public void writeSingleByteInt() throws IOException {
  hpackWriter.writeInt(10,31,0);
  assertBytes(10);
  hpackWriter.writeInt(10,31,0xe0);
  assertBytes(0xe0 | 10);
}
