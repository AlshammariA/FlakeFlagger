public void testStringReadWrite() throws IOException {
  final Random r=new Random(1);
  for (int i=0; i < 100000; i+=i / 10 + 1) {
    String s="";
    for (int j=0; j < 10; j++) {
      String p=new String(new char[i]).replace((char)0,'a');
      s+=p;
    }
    ByteArrayOutputStream out=new ByteArrayOutputStream();
    IOUtils.writeString(out,s);
    byte[] data=out.toByteArray();
    ByteArrayInputStream in=new ByteArrayInputStream(data){
      @Override public int read(      byte[] b,      int off,      int len){
        if (r.nextBoolean()) {
          len=r.nextInt(len);
        }
        return super.read(b,off,len);
      }
    }
;
    String t=IOUtils.readString(in);
    assertEquals(s,t);
    assertEquals(-1,in.read());
  }
  try {
    InputStream in=new ByteArrayInputStream(new byte[]{1});
    IOUtils.readString(in);
    fail();
  }
 catch (  EOFException e) {
  }
}
