@Test public void test5(){
  ElementSelector p=new ElementSelector("//a");
  assertEquals(1,p.size());
  assertEquals("a",p.get(0));
}
