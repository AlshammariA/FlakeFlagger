public void testBytesReadWrite() throws IOException {
  final Random r=new Random();
  int iterations=1000;
  while (iterations-- > 0) {
    int n=Math.abs(r.nextInt()) % 0x40000;
    byte[] buf=new byte[n];
    r.nextBytes(buf);
    ByteArrayOutputStream out=new ByteArrayOutputStream();
    IOUtils.writeBytes(out,buf);
    byte[] buf1=IOUtils.readBytes(new ByteArrayInputStream(out.toByteArray()));
    assertEquals(buf,buf1);
  }
}
