public void testReadFully() throws IOException {
  final Random r=new Random(1);
  byte[] data=new byte[1000];
  final AtomicInteger readCount=new AtomicInteger();
  r.nextBytes(data);
  FilterInputStream in=new FilterInputStream(new ByteArrayInputStream(data)){
    @Override public int read(    byte[] buffer,    int off,    int max) throws IOException {
      readCount.incrementAndGet();
      if (r.nextInt(10) == 0) {
        return 0;
      }
      return in.read(buffer,off,Math.min(10,max));
    }
  }
;
  in.mark(10000);
  byte[] test=new byte[1000];
  assertEquals(0,IOUtils.readFully(in,test,0,0));
  assertEquals(0,readCount.get());
  assertEquals(1000,IOUtils.readFully(in,test,0,1000));
  IOUtilsTest.assertEquals(data,test);
  test=new byte[1001];
  in.reset();
  in.mark(10000);
  assertEquals(1000,IOUtils.readFully(in,test,0,1001));
  assertEquals(0,IOUtils.readFully(in,test,0,0));
}
