@Test public void testInitial(){
  final HeaderMap headerMap=new HeaderMap();
  assertEquals(0,headerMap.size());
  assertEquals(-1L,headerMap.fastIterate());
  assertFalse(headerMap.iterator().hasNext());
}
