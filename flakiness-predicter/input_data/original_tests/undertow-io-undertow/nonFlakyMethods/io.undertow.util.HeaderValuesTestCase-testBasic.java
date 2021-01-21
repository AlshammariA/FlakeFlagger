@Test public void testBasic(){
  final HeaderValues headerValues=new HeaderValues(Headers.DEFLATE);
  assertEquals(0,headerValues.size());
  assertTrue(headerValues.isEmpty());
  assertFalse(headerValues.iterator().hasNext());
  assertFalse(headerValues.descendingIterator().hasNext());
  assertFalse(headerValues.listIterator().hasNext());
  assertFalse(headerValues.listIterator(0).hasNext());
  assertNull(headerValues.peek());
  assertNull(headerValues.peekFirst());
  assertNull(headerValues.peekLast());
}
