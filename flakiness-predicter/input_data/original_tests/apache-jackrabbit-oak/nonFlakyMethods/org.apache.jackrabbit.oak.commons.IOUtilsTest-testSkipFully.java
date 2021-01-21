public void testSkipFully() throws IOException {
  final Random r=new Random(1);
  byte[] data=new byte[1000];
  r.nextBytes(data);
  FilterInputStream in=new FilterInputStream(new ByteArrayInputStream(data)){
    @Override public int read(    byte[] buffer,    int off,    int max) throws IOException {
      return in.read(buffer,off,Math.min(10,max));
    }
  }
;
  in.mark(10000);
  IOUtils.skipFully(in,1000);
  assertEquals(-1,in.read());
  in.reset();
  try {
    IOUtils.skipFully(in,1001);
    fail();
  }
 catch (  EOFException e) {
  }
}
