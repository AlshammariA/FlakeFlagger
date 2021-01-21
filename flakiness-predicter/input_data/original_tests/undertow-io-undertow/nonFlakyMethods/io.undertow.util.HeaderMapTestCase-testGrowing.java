@Test public void testGrowing(){
  final HeaderMap headerMap=new HeaderMap();
  for (  HttpString item : HTTP_STRING_LIST) {
    for (int i=0; i < (item.hashCode() & 7) + 1; i++)     headerMap.add(item,"Test value");
  }
  for (  HttpString item : HTTP_STRING_LIST) {
    assertTrue(String.format("Missing %s (hash %08x)",item,Integer.valueOf(item.hashCode())),headerMap.contains(item));
    assertNotNull(headerMap.get(item));
    assertEquals((item.hashCode() & 7) + 1,headerMap.get(item).size());
    assertEquals("Test value",headerMap.getFirst(item));
    assertEquals("Test value",headerMap.getLast(item));
  }
  assertEquals(HTTP_STRING_LIST.size(),headerMap.size());
  for (  HttpString item : HTTP_STRING_LIST) {
    assertTrue(headerMap.contains(item));
    assertNotNull(headerMap.remove(item));
    assertFalse(headerMap.contains(item));
  }
  assertEquals(0,headerMap.size());
}
