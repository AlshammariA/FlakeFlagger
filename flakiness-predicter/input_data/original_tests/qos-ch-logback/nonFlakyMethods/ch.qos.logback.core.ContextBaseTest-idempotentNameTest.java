@Test public void idempotentNameTest(){
  context.setName("hello");
  context.setName("hello");
}
