@Test public void testListRecord(){
  RecordId blockId=writer.writeBlock(bytes,0,bytes.length);
  ListRecord one=writeList(1,blockId);
  ListRecord level1=writeList(LEVEL_SIZE,blockId);
  ListRecord level1p=writeList(LEVEL_SIZE + 1,blockId);
  ListRecord level2=writeList(LEVEL_SIZE * LEVEL_SIZE,blockId);
  ListRecord level2p=writeList(LEVEL_SIZE * LEVEL_SIZE + 1,blockId);
  assertEquals(1,one.size());
  assertEquals(blockId,one.getEntry(0));
  assertEquals(LEVEL_SIZE,level1.size());
  assertEquals(blockId,level1.getEntry(0));
  assertEquals(blockId,level1.getEntry(LEVEL_SIZE - 1));
  assertEquals(LEVEL_SIZE + 1,level1p.size());
  assertEquals(blockId,level1p.getEntry(0));
  assertEquals(blockId,level1p.getEntry(LEVEL_SIZE));
  assertEquals(LEVEL_SIZE * LEVEL_SIZE,level2.size());
  assertEquals(blockId,level2.getEntry(0));
  assertEquals(blockId,level2.getEntry(LEVEL_SIZE * LEVEL_SIZE - 1));
  assertEquals(LEVEL_SIZE * LEVEL_SIZE + 1,level2p.size());
  assertEquals(blockId,level2p.getEntry(0));
  assertEquals(blockId,level2p.getEntry(LEVEL_SIZE * LEVEL_SIZE));
  try {
    int count=0;
    for (    RecordId entry : level2p.getEntries()) {
      assertEquals(blockId,entry);
      assertEquals(blockId,level2p.getEntry(count));
      count++;
    }
    assertEquals(LEVEL_SIZE * LEVEL_SIZE + 1,count);
  }
 catch (  IllegalArgumentException e) {
    fail("OAK-1287");
  }
}
