public void testVarEOF() throws IOException {
  try {
    IOUtils.readVarInt(new ByteArrayInputStream(new byte[0]));
    fail();
  }
 catch (  EOFException e) {
  }
  try {
    IOUtils.readVarLong(new ByteArrayInputStream(new byte[0]));
    fail();
  }
 catch (  EOFException e) {
  }
}
