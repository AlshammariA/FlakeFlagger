@Test public void test6(){
  ElementSelector p=new ElementSelector("//a//b");
  assertEquals(2,p.size());
  assertEquals("a",p.get(0));
  assertEquals("b",p.get(1));
}
