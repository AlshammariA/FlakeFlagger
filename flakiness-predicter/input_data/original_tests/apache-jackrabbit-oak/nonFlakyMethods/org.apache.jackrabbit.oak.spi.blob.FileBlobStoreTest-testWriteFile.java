@Test public void testWriteFile() throws Exception {
  store.setBlockSize(1024 * 1024);
  byte[] data=new byte[4 * 1024 * 1024];
  Random r=new Random(0);
  r.nextBytes(data);
  String tempFileName="target/temp/test";
  File tempFile=new File(tempFileName);
  tempFile.getParentFile().mkdirs();
  OutputStream out=new FileOutputStream(tempFile,false);
  out.write(data);
  out.close();
  String s=store.writeBlob(tempFileName);
  assertEquals(data.length,store.getBlobLength(s));
  byte[] buff=new byte[1];
  for (int i=0; i < data.length; i+=1024) {
    store.readBlob(s,i,buff,0,1);
    assertEquals(data[i],buff[0]);
  }
  try {
    store.writeBlob(tempFileName + "_wrong");
    fail();
  }
 catch (  Exception e) {
  }
}
