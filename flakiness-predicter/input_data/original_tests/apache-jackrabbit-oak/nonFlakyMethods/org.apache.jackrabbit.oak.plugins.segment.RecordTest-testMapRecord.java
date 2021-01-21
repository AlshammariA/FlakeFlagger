@Test public void testMapRecord(){
  RecordId blockId=writer.writeBlock(bytes,0,bytes.length);
  MapRecord zero=writer.writeMap(null,ImmutableMap.<String,RecordId>of());
  MapRecord one=writer.writeMap(null,ImmutableMap.of("one",blockId));
  MapRecord two=writer.writeMap(null,ImmutableMap.of("one",blockId,"two",blockId));
  Map<String,RecordId> map=Maps.newHashMap();
  for (int i=0; i < 1000; i++) {
    map.put("key" + i,blockId);
  }
  MapRecord many=writer.writeMap(null,map);
  Iterator<MapEntry> iterator;
  assertEquals(0,zero.size());
  assertNull(zero.getEntry("one"));
  iterator=zero.getEntries().iterator();
  assertFalse(iterator.hasNext());
  assertEquals(1,one.size());
  assertEquals(blockId,one.getEntry("one").getValue());
  assertNull(one.getEntry("two"));
  iterator=one.getEntries().iterator();
  assertTrue(iterator.hasNext());
  assertEquals("one",iterator.next().getName());
  assertFalse(iterator.hasNext());
  assertEquals(2,two.size());
  assertEquals(blockId,two.getEntry("one").getValue());
  assertEquals(blockId,two.getEntry("two").getValue());
  assertNull(two.getEntry("three"));
  iterator=two.getEntries().iterator();
  assertTrue(iterator.hasNext());
  iterator.next();
  assertTrue(iterator.hasNext());
  iterator.next();
  assertFalse(iterator.hasNext());
  assertEquals(1000,many.size());
  iterator=many.getEntries().iterator();
  for (int i=0; i < 1000; i++) {
    assertTrue(iterator.hasNext());
    assertEquals(blockId,iterator.next().getValue());
    assertEquals(blockId,many.getEntry("key" + i).getValue());
  }
  assertFalse(iterator.hasNext());
  assertNull(many.getEntry("foo"));
  Map<String,RecordId> changes=Maps.newHashMap();
  changes.put("key0",null);
  changes.put("key1000",blockId);
  MapRecord modified=writer.writeMap(many,changes);
  assertEquals(1000,modified.size());
  iterator=modified.getEntries().iterator();
  for (int i=1; i <= 1000; i++) {
    assertTrue(iterator.hasNext());
    assertEquals(blockId,iterator.next().getValue());
    assertEquals(blockId,modified.getEntry("key" + i).getValue());
  }
  assertFalse(iterator.hasNext());
  assertNull(many.getEntry("foo"));
}
