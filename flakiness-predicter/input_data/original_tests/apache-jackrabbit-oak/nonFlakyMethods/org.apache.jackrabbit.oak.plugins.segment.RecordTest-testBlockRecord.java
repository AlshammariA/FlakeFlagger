@Test public void testBlockRecord(){
  RecordId blockId=writer.writeBlock(bytes,0,bytes.length);
  BlockRecord block=new BlockRecord(blockId,bytes.length);
  for (int n=1; n < bytes.length; n++) {
    for (int i=0; i + n <= bytes.length; i++) {
      Arrays.fill(bytes,i,i + n,(byte)'.');
      assertEquals(n,block.read(i,bytes,i,n));
      assertEquals(hello,new String(bytes,Charsets.UTF_8));
    }
  }
  byte[] large=new byte[bytes.length * 2];
  assertEquals(bytes.length,block.read(0,large,0,large.length));
  assertEquals(hello,new String(large,0,bytes.length,Charsets.UTF_8));
}
