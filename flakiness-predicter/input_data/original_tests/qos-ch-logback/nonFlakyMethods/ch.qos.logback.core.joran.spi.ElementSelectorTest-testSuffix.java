@Test public void testSuffix(){
  ElementSelector p=new ElementSelector("a/");
  assertEquals(1,p.size());
  assertEquals("a",p.peekLast());
  assertEquals("a",p.get(0));
}
