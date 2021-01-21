@Test public void writeMultibyteInt() throws IOException {
  hpackWriter.writeInt(1337,31,0);
  assertBytes(31,154,10);
  hpackWriter.writeInt(1337,31,0xe0);
  assertBytes(0xe0 | 31,154,10);
}
