@Test public void test4(){
  ElementSelector p=new ElementSelector("/a123/b1234/cvvsdf");
  assertEquals(3,p.size());
  assertEquals("a123",p.get(0));
  assertEquals("b1234",p.get(1));
  assertEquals("cvvsdf",p.get(2));
}
