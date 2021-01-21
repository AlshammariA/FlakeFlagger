@Test public void testWorstCaseMap(){
  RecordId blockId=writer.writeBlock(bytes,0,bytes.length);
  Map<String,RecordId> map=Maps.newHashMap();
  char[] key=new char[2];
  for (int i=0; i <= MapRecord.BUCKETS_PER_LEVEL; i++) {
    key[0]=(char)('A' + i);
    key[1]=(char)('\u1000' - key[0] * 31);
    map.put(new String(key),blockId);
  }
  MapRecord bad=writer.writeMap(null,map);
  assertEquals(map.size(),bad.size());
  Iterator<MapEntry> iterator=bad.getEntries().iterator();
  for (int i=0; i < map.size(); i++) {
    assertTrue(iterator.hasNext());
    assertEquals('\u1000',iterator.next().getName().hashCode());
  }
  assertFalse(iterator.hasNext());
}
